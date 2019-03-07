package org.deloitte.td.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AemTarget {

  public AemTarget() {
    List<String> records = loadContainerFile("/Users/jimmyhernandez/Documents/projects/td/config-files/containers-example.csv");
    containersReview(records);
  }

  public void containersReview(List<String> records) {
    for(String rec : records) {
      System.out.println(rec);
      if ( rec.contains("|") && (!rec.contains("MBNA"))) {
        System.out.println("Multiple containers Start");
        multipleContainerRule(rec);
        System.out.println("Multiple containers End");
      } else {
        System.out.println("Single container");
        System.out.println(singleContainerRule(rec));
      }
    }
  }

  public String singleContainerRule(String container) {
    String path = null;
    if (container.contains("MBNA & CUETS")) {
      path = "/Personal Banking/Credit Cards/MBNA/";
    }
    return path;
  }

  public String multipleContainerRule(String container) {
    String path = null;
    int previousLevel = 0;

    List<String> tokens = new ArrayList<String>();
    StringTokenizer tokenizer = new StringTokenizer(container, "|");
    while (tokenizer.hasMoreElements()) {
      String tax = "";
      String t = tokenizer.nextToken();
//      System.out.println(t);
      String h = t.replace("$Containers:","");
//      System.out.println(h.lastIndexOf(":"));
      int po = h.lastIndexOf(":");
//      System.out.println(h.substring(0,po));
      String result = h.substring(0,po);
      StringTokenizer results = new StringTokenizer(result, ":");
      int level = 0;
      int maxLevel = results.countTokens() - 1;

      System.out.println("Max Level >> " + maxLevel);
      while (results.hasMoreElements()) {
        if(level < maxLevel) {
          String token1 = results.nextToken();
          level++;
          tax += level < maxLevel ? token1 + ":" : token1;

        } else {
          break;
        }
      }

      System.out.println(tax);
//      System.out.println(results.countTokens());





//      String h = t.replace("$Containers:","");
//      System.out.println(h);
//      if(h.contains("TD:TD (Can):")) {
//        System.out.println("TD Contains");
//      }
      //tokens.add(tokenizer.nextToken());
    }


    return path;
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
