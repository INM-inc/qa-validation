package org.deloitte.td.utils;

import java.io.*;
import java.net.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.KeyManagementException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.*;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.deloitte.td.dto.MigrationDto;

import javax.net.ssl.*;

public class AemTarget {

  private Map<String,String> paths;
  private Map<String,String> orphans;
  private Map<String,String> props;
  private Map<String,String> cantoInfo;
  private List<MigrationDto> dataMigration;

  public AemTarget() {
    props = conf();
  }

  public HashMap<String, HashMap<String, String>> run() {
    String HEADER_RESULT = "Canto Id\tFile name\tAEM Migration Path\tAEM URL\tFilesize\tSha1 Code\tAEM Found";
    String HEADER_NOT_FOUND_FILES = "Canto Id\tCanto path\tRenamed file\tFile name\tAsset exist";

    dataMigration = loadMigrationFile(props.get("containers"));
    paths = loadTaxonomy(props.get("paths"));
    orphans = mappingFile(props.get("orphans"));
    cantoInfo = mappingFile(props.get("cantoInfo"));

    List<String> foundAssets = new ArrayList<>();
    List<String> notFoundAssets = new ArrayList<>();
    List<String> cantoResults = new ArrayList<>();

    cantoResults.add(HEADER_RESULT);
    notFoundAssets.add(HEADER_NOT_FOUND_FILES);

    int i = 0;
    int max = 6;

    HashMap<String, HashMap<String, String>> shaAndFilesMetadata = new HashMap<>();

    for (MigrationDto dto : dataMigration) {
      // Get Canto path based on Id
      String assetFile = "NA";
      String cantoPath = cantoInfo.get(dto.getId());
      File asset = new File(cantoPath);
      HashMap<String, String> fileMetadata = new HashMap<>();
      if ( asset.exists() && asset.isDirectory() ) {
        // Get Asset based on filename - search Assets renamed folder
        assetFile = props.get("cantoAssetsRenamedFolder") +"/"+dto.getFileName();
        asset = new File(assetFile);

        if ( asset.length() > 0 ) {
          // Get AEM path based on Container value
          String aemPath = getAemPath(dto);
          // Generate the sha code for the file
          String sha1Code = generateSha(asset);

          String assetAemFile = props.get("aemServer") + aemPath + "/" + dto.getFileName();

          // Http Get to validated if the asset exist on AEM
          HttpURLConnection assetConn = assetAemValidation(assetAemFile,props.get("aemUserName"),props.get("aemPassword"));
          String aemAssetFound = "Not Found";

          try {
            if(assetConn.getResponseCode() == 200) {
              //                JsonObject md = aemMetadata(assetConn);
              System.out.println("Found");
              aemAssetFound = "Found";
            }
          } catch (IOException e) {
            e.printStackTrace();
          }


          cantoResults.add(dto.getId()+"\t"+dto.getFileName()+"\t"+aemPath+"\t"+assetAemFile+"\t"+asset.length()+"\t"+sha1Code+"\t"+aemAssetFound);

          fileMetadata.put("File Name", dto.getFileName());
          fileMetadata.put("Containers", getCorrectContainer(dto.getContainers()));
          fileMetadata.put("AEM PATH", aemPath);
          shaAndFilesMetadata.put(sha1Code, fileMetadata);


        } else {
          notFoundAssets.add(dto.getId()+"\t"+cantoPath+"\t"+assetFile+"\t"+dto.getFileName()+"\t"+asset.exists());
          fileMetadata.put("File Name", "");
          fileMetadata.put("Containers", "");
          fileMetadata.put("AEM PATH", "");
          shaAndFilesMetadata.put("", fileMetadata);
        }

      } else {
        notFoundAssets.add(dto.getId()+"\t"+cantoPath+"\t"+assetFile+"\t"+dto.getFileName()+"\t"+asset.exists());
        fileMetadata.put("File Name", "");
        fileMetadata.put("Containers", "");
        fileMetadata.put("AEM PATH", "");
        shaAndFilesMetadata.put("", fileMetadata);
      }
      i++;
    }
    return shaAndFilesMetadata;


//    wrCsvFile(cantoResults,props.get("cantoResults"));
//    wrCsvFile(notFoundAssets,props.get("notFoundFile"));

  }

  public String getCorrectContainer(String containers) {
    String aemPath = null;
    if ( containers.contains("$Containers:") ) {
      containers = containers.split("\\$Containers:")[1];
      if (containers.contains("MBNA")) {
        return "MBNA";
      } else if (containers.contains("|") && !containers.contains("MBNA")) {
        String[] tokens = containers.split("\\|");

        int index = 0;
        int elementLength = tokens[0].length();
        for(int i=1; i< tokens.length; i++) {
          if(tokens[i].length() > elementLength) {
            index = i; elementLength = tokens[i].length();
          }
        }
        return tokens[index];
      } else {
        return containers;
      }
    } else {
      return "NO_CONTAINER";
    }
  }

  public String getAemPath(MigrationDto m) {
    String aemPath = null;
    if ( m.getContainers().equals("ORPHAN") ) {
      aemPath = orphans.get(m.getId());
    } else if ( m.getContainers().contains("$Containers:") ) {
      if (m.getContainers().contains("MBNA")) {
        aemPath = mbna(m.getContainers());
      } else if ( m.getContainers().contains("|") && !m.getContainers().contains("MBNA") ) {
        aemPath = multipleContainer(m.getContainers());
      } else if ( !m.getContainers().contains("MBNA") && !m.getContainers().contains("|") ) {
        aemPath = notMbna(m.getContainers());
      }
    }
    return aemPath;
  }



  public String findAemPath(String container) {
    String cantoPath = "";
    int level = 0;
    int maxLevel = 4;
    String cleanPath = container.replace("$Containers:","");

    StringTokenizer results = new StringTokenizer(cleanPath, ":");
    int tokens = results.countTokens();

    while (results.hasMoreElements()) {
      String token = results.nextToken();
      if(level < maxLevel) {
        cantoPath += token.trim();
        level++;
      }
    }

    return paths.get(cantoPath.toUpperCase());
  }

  public String notMbna(String container) {
    String result = findAemPath(container);
    return result;
  }

  public String mbna(String container) {
    String path = null;
    if (container.contains("MBNA & CUETS")) {
      path = paths.get("MBNA");
    }
    return path;
  }

  public String multipleContainer(String container) {
    String[] tokens = container.split("\\|");

    int index = 0;
    int elementLength = tokens[0].length();
    for(int i=1; i< tokens.length; i++) {
      if(tokens[i].length() > elementLength) {
        index = i; elementLength = tokens[i].length();
      }
    }

    return findAemPath(tokens[index]);
  }


  public Map<String,String> loadTaxonomy(String path) {
    Map<String,String> map = new HashMap<String, String>();

    BufferedReader br = null;
    String _line = "";

    try {
      br = new BufferedReader(new FileReader(path));
      while((_line = br.readLine()) != null) {
        String[] lines = _line.split("\t");
        map.put(lines[0].toUpperCase(),lines[1]);
      }
      br.close();

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return map;
  }

  public Map<String,String> mappingFile(String path) {
    Map<String,String> map = new HashMap<String, String>();

    BufferedReader br = null;
    String _line = "";

    try {
      br = new BufferedReader(new FileReader(path));
      while((_line = br.readLine()) != null) {
        String[] lines = _line.split("\t");
        map.put(lines[0],lines[1]);
      }
      br.close();

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return map;
  }

  public File getFile(String sourceFile) {

    File asset = new File(sourceFile);

    return asset;
  }

  public List<MigrationDto> loadMigrationFile(String path) {
    List<MigrationDto> records = new ArrayList<MigrationDto>();
    BufferedReader br = null;
    String _line = "";
    try {
      br = new BufferedReader(new FileReader(path));
      while((_line = br.readLine()) != null) {
        String[] lines = _line.split("\\t");

        MigrationDto mdto = new MigrationDto();
        mdto.setId(lines[0]);
        mdto.setFileName(lines[1]);
        mdto.setFilesize(lines[2]);
        mdto.setContainers(lines[3]);
        records.add(mdto);
      }
      br.close();

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return records;
  }

  public void wrCsvFile(List<String> data, String path) {
    Path filePath = Paths.get(path);
    try {
      Files.write(filePath, data, Charset.forName("UTF-8"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static String generateSha(File asset) {
    String sha1 = "";
    try {
      if (asset.exists()) {
        MessageDigest shaDigest = MessageDigest.getInstance("SHA-1");
        sha1 = getFileChecksum(shaDigest, asset);
      }
    } catch (IOException| NoSuchAlgorithmException e) {
      e.getMessage();
    }
    return sha1;
  }

  public static String getFileChecksum(MessageDigest digest, File file) throws IOException
  {
    //Get file input stream for reading the file content
    FileInputStream fis = new FileInputStream(file);

    //Create byte array to read data in chunks
    byte[] byteArray = new byte[1024];
    int bytesCount = 0;

    //Read file data and update in message digest
    while ((bytesCount = fis.read(byteArray)) != -1) {
      digest.update(byteArray, 0, bytesCount);
    }

    //close the stream; We don't need it now.
    fis.close();

    //Get the hash's bytes
    byte[] bytes = digest.digest();

        /* This bytes[] has bytes in decimal format;
        Convert it to hexadecimal format*/
    StringBuilder sb = new StringBuilder();
    for(int i=0; i< bytes.length ;i++)
    {
      sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
    }

    //return complete hash
    return sb.toString();
  }

  public HttpURLConnection assetAemValidation(String asset, final String userName, final String password) {
    HttpURLConnection conn = null;

    try {

      String aemAssetFile = asset+"/jcr:content/metadata.json";

      Authenticator.setDefault (new Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
          return new PasswordAuthentication(userName, password.toCharArray());
        }
      });

      // Create a trust manager that does not validate certificate chains
      TrustManager[] trustAllCerts = new TrustManager[] {new X509TrustManager() {
        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
          return null;
        }
        public void checkClientTrusted(X509Certificate[] certs, String authType) {
        }
        public void checkServerTrusted(X509Certificate[] certs, String authType) {
        }
      }
      };

      // Install the all-trusting trust manager
      SSLContext sc = null;
      try {
        sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, new java.security.SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
      } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
      } catch (KeyManagementException e) {
        e.printStackTrace();
      }


      // Create all-trusting host name verifier
      HostnameVerifier allHostsValid = new HostnameVerifier() {
        public boolean verify(String hostname, SSLSession session) {
          return true;
        }
      };

      // Install the all-trusting host verifier
      HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);

      URL url = new URL(aemAssetFile);
      conn = (HttpURLConnection) url.openConnection();

      conn.setRequestMethod("GET");

    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }


    return conn;
  }

  public Map<String,String> conf() {
    Map<String,String> result = new HashMap<>();
    InputStream inputStream = null;

    try {
      Properties prop = new Properties();
      String propFileName = "config.properties";

      inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

      if (inputStream != null) {
        prop.load(inputStream);
      } else {
        throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
      }

      Date time = new Date(System.currentTimeMillis());

      // get the property value and print it out
      result.put("aemServer",prop.getProperty("aemServer"));
      result.put("aemUserName",prop.getProperty("aemUserName"));
      result.put("aemPassword",prop.getProperty("aemPassword"));

      result.put("resultsFile",prop.getProperty("resultsFile"));
      result.put("foundFile",prop.getProperty("foundFile"));
      result.put("notFoundFile",prop.getProperty("notFoundFile"));

      result.put("containers",prop.getProperty("containers"));
      result.put("paths",prop.getProperty("paths"));
      result.put("orphans",prop.getProperty("orphans"));

      result.put("cantoInfo",prop.getProperty("cantoInfo"));
      result.put("cantoResults",prop.getProperty("cantoResults"));
      result.put("cantoAssetsRenamedFolder",prop.getProperty("cantoAssetsRenamedFolder"));

      inputStream.close();

    } catch (IOException ioe) {
      System.out.println(ioe);
    } catch (Exception e) {
      System.out.println("Exception: " + e);
    }


    return result;
  }

  public JsonObject aemMetadata(HttpURLConnection conn) {
    StringBuilder result = new StringBuilder();
    BufferedReader rd = null;
    JsonObject metadata = null;

    try {
      rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));

      String line;

      while((line = rd.readLine()) != null) {
        result.append(line);
      }

      rd.close();

      JsonParser jsonParser = new JsonParser();
      metadata = (JsonObject)jsonParser.parse(result.toString());

    } catch (IOException e) {
      e.printStackTrace();
    }


    return metadata;
  }

}
