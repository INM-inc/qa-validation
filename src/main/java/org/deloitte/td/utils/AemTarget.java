package org.deloitte.td.utils;

import java.io.*;
import java.net.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.*;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.deloitte.td.dto.MigrationDto;

import javax.net.ssl.*;

public class AemTarget {

  private Map<String,String> taxonomy;
  private Map<String,String> otherFiles;
  private List<MigrationDto> dataMigration;

  public AemTarget() {
    taxonomy = loadTaxonomy("/Users/jimmyhernandez/Documents/projects/td/config-files/taxonomy.csv");
  }

  public void run() {
    dataMigration = loadMigrationFile("/Users/jimmyhernandez/Documents/projects/td/config-files/source2.csv");
    //taxonomy = loadTaxonomy("/Users/jimmyhernandez/Documents/projects/td/config-files/taxonomy.csv");
    otherFiles = mappingFile("/Users/jimmyhernandez/Documents/projects/td/config-files/others.csv");

    //System.out.println(otherFiles.get("79101"));
    List<String> results = new ArrayList<>();

    int counter = 0;
    for(MigrationDto m: dataMigration){
      String aemPath = null;
      if ( m.getContainers().equals("ORPHAN") ) {
        aemPath = otherFiles.get(m.getId());
//        System.out.println(m.getId() + " " + aemPath);
      } else if ( m.getContainers().contains("$Containers:") ) {
        if (m.getContainers().contains("MBNA")) {
          aemPath = mbna(m.getContainers());
        } else if ( m.getContainers().contains("|") && !m.getContainers().contains("MBNA") ) {
          aemPath = multipleContainer(m.getContainers());
        } else if ( !m.getContainers().contains("MBNA") && !m.getContainers().contains("|") ) {
          aemPath = notMbna(m.getContainers());
        }
      }

//      if (aemPath != null) {
        results.add(aemPath+"\t"+m.getId());
//      }

    }

    Path file = Paths.get("/Users/jimmyhernandez/Documents/projects/td/config-files/path-result.csv");
    try {
      Files.write(file, results, Charset.forName("UTF-8"));
    } catch (IOException e) {
      e.printStackTrace();
    }

    try {

      Authenticator.setDefault (new Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
          return new PasswordAuthentication("jimmyhernandez", "P@ssw0rd123!".toCharArray());
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

      URL url = new URL("https://13.88.236.91/content/dam/Canada/small-business-banking/5369-1018_SBB_Advice_Series-A_Banner-OCT19_TDCT_WB_A.jpg/jcr:content/metadata.json");
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();

      conn.setRequestMethod("GET");
      int code = conn.getResponseCode();

      System.out.println(code);

      StringBuilder result = new StringBuilder();
      BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));

      String line;

      while((line = rd.readLine()) != null) {
        result.append(line);
      }

      rd.close();


      JsonParser jsonParser = new JsonParser();
      JsonObject jo = (JsonObject)jsonParser.parse(result.toString());

      System.out.println("dam:sha1" + jo.get("dam:sha1"));

//      if (resultSha1.equals(jo.get("dam:sha1"))) {
//        System.out.println("true");
//      } else {
//        System.out.println("false");
//      }

    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  public void containersReview(List<String> records) {

    List<String> results = new ArrayList<String>();


    for(String rec : records) {
      if (rec.contains("$Containers:")) {

        if(rec.contains("MBNA")) {
          results.add(rec+ "\t"+mbna(rec));
        }

        if (rec.contains("|") && !rec.contains("MBNA")) {
          results.add(rec + "\t" + multipleContainer(rec));
        }

        if(rec.equals("$Containers:TD:TD (Can)")) {
          results.add(rec +"\tSearch by Id");
        }

        if(!rec.contains("MBNA") && !rec.equals("$Containers:TD:TD (Can)") && !rec.contains("|")) {
          results.add(rec + "\t" + notMbna(rec));
        }
      } else {
        results.add(rec + "\tNot to be migrated");
      }
    }

    Path file = Paths.get("/Users/jimmyhernandez/Documents/projects/td/config-files/filtered.csv");
    try {
      Files.write(file, results, Charset.forName("UTF-8"));
    } catch (IOException e) {
      e.printStackTrace();
    }
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
        cantoPath += token;
        level++;
      }
    }

    return taxonomy.get(cantoPath.toUpperCase());
  }

  public String notMbna(String container) {
    String result = findAemPath(container);
    return result;
  }

  public String mbna(String container) {
    String path = null;
    if (container.contains("MBNA & CUETS")) {
      path = taxonomy.get("MBNA");
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

  public List<String> loadContainerFile(String path) {
    List<String> records = new ArrayList<String>();
    BufferedReader br = null;
    String _line = "";
    try {
      br = new BufferedReader(new FileReader(path));
      while((_line = br.readLine()) != null) {
        records.add(_line);
      }
      br.close();

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return records;
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

}
