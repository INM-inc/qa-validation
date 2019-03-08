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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AemTarget {

  private Map<String,String> taxonomy;

  public AemTarget() {
    taxonomy = loadTaxonomy("/Users/jimmyhernandez/Documents/projects/td/config-files/taxonomy.csv");
    List<String> records = loadContainerFile("/Users/jimmyhernandez/Documents/projects/td/config-files/containers-example.csv");
    containersReview(records);
//    multipleContainer("$Containers:TD:TD (Can)|$Containers:TD|$Containers:TD:TD (Can):TD Internal Agency:Content Marketing:tres|$Containers:TD:TD (Can):TD Internal Agency:Business Banking:Test1:Test2");
  }

  public void containersReview(List<String> records) {

    List<String> results = new ArrayList<String>();

//    System.out.println(findAemPath("$Containers:TD:TD (Can):Insurance:AMG Insurance"));

    for(String rec : records) {
      if (rec.contains("$Containers:")) {

        if(rec.contains("MBNA")) {
//          System.out.println(rec + " > " + mbna(rec));
          results.add(rec+ "\t"+mbna(rec));
        }

        if (rec.contains("|") && !rec.contains("MBNA")) {
//          System.out.println(rec + " > " + multipleContainer(rec));
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

//    System.out.println("Counter " + tokens);

    while (results.hasMoreElements()) {
      String token = results.nextToken();
      if(level < maxLevel) {
        cantoPath += token;
        level++;
      }
    }

//    System.out.println(cantoPath);
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

  public String multipleContainerRule(String container) {
    String path = null;
    int previousLevel = 0;
    String previousPath = null;
    String tempPath = "";

    List<String> tokens = new ArrayList<String>();
    StringTokenizer tokenizer = new StringTokenizer(container, "|");
    while (tokenizer.hasMoreElements()) {
      tempPath = "";
      String t = tokenizer.nextToken();
      String h = t.replace("$Containers:","");
      int po = h.lastIndexOf(":");

      String result = h.substring(0,po);
      StringTokenizer results = new StringTokenizer(result, ":");
      int level = 0;
      int maxLevel = results.countTokens() - 1;

      while (results.hasMoreElements()) {
        if(level < maxLevel) {
          String token1 = results.nextToken();
          level++;
          tempPath += level < maxLevel ? token1 + ":" : token1;

        } else {
          break;
        }
      }

      if(previousLevel == 0) {
        previousLevel = maxLevel;
        previousPath = tempPath;
        path = tempPath;
      } else if (maxLevel > previousLevel) {
        previousLevel = maxLevel;
        previousPath = tempPath;
        path = tempPath;
      }

    }
    return taxonomy.get(path);
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

  public List<String> loadContainerFile(String path) {
    List<String> records = new ArrayList<String>();
    BufferedReader br = null;
    String _line = "";
    try {
      br = new BufferedReader(new FileReader(path));
      while((_line = br.readLine()) != null) {
        records.add(_line);
//        String[] asset = _line.split(csvSplitBy);
//        records.add(Arrays.asList(asset));
      }
      br.close();

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return records;
  }

  public String targetPath() {
    return "Target Path";
  }
}
