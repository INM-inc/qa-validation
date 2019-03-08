package org.deloitte.td.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import org.deloitte.td.dto.MigrationDto;

public class AemTarget {

  private Map<String,String> taxonomy;
  private Map<String,String> otherFiles;
  private List<MigrationDto> dataMigration;

  public AemTarget() {
    taxonomy = loadTaxonomy("/Users/jimmyhernandez/Documents/projects/td/config-files/taxonomy.csv");
  }

  public void run() {
    dataMigration = loadMigrationFile("/Users/jimmyhernandez/Documents/projects/td/config-files/source2.csv");
    taxonomy = loadTaxonomy("/Users/jimmyhernandez/Documents/projects/td/config-files/taxonomy.csv");
    otherFiles = mappingFile("/Users/jimmyhernandez/Documents/projects/td/config-files/others.csv");

    //System.out.println(otherFiles.get("79101"));
    List<String> results = new ArrayList<>();

    int counter = 0;
    for(MigrationDto m: dataMigration){
      String aemPath = null;
      if ( m.getContainers().equals("ORPHAN") ) {
        aemPath = otherFiles.get(m.getId());
      } else if ( m.getContainers().contains("$Containers:") ) {
        if (m.getContainers().contains("MBNA")) {
          aemPath = mbna(m.getContainers());
        } else if ( m.getContainers().contains("|") && !m.getContainers().contains("MBNA") ) {
          aemPath = multipleContainer(m.getContainers());
        } else if ( !m.getContainers().contains("MBNA") && !m.getContainers().equals("$Containers:TD:TD (Can)") && !m.getContainers().contains("|") ) {
          aemPath = notMbna(m.getContainers());
        }
      }
//        String rcontainer = m.getContainers().isEmpty() ? otherFiles.get(m.getId()) : m.getContainers();
      if (aemPath != null) {
        results.add(aemPath+"\t"+m.getId());
      }

    }

    Path file = Paths.get("/Users/jimmyhernandez/Documents/projects/td/config-files/the-file-name2.csv");
    try {
      Files.write(file, results, Charset.forName("UTF-8"));
    } catch (IOException e) {
      e.printStackTrace();
    }


    List<String> records = loadContainerFile("/Users/jimmyhernandez/Documents/projects/td/config-files/containers-example.csv");
    containersReview(records);
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

    Path file = Paths.get("/Users/jimmyhernandez/Documents/projects/td/config-files/the-file-name.csv");
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
