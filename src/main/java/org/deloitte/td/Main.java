package org.deloitte.td;

import java.util.HashMap;

import org.deloitte.td.helpers.WriteResultsToExcel;

//import org.deloitte.td.dto.MigrationDto;
//import org.deloitte.td.utils.AemTarget;

public class Main {

  public static void main(String[] args) {

//    ArrayList<AssetModel> fromCSV = RetrieveMetadataCSV.retrieveFromCSV();
//    JsonObject fromAEM = RetrieveMetadataAEM.retrieveFromAEM();
//    HashMap<String, String> differences = CompareMetadata.checkForDifferences(fromCSV, fromAEM);
    HashMap<String, String> filesAndDifferences = new HashMap<>();
    filesAndDifferences.put("file1", "Diff1, Diff2");
    filesAndDifferences.put("file2", "Diff3, Diff4");
    WriteResultsToExcel.writeResultsToExcel(filesAndDifferences);

//    Iterator iterator = fromCSV.iterator();
    // for (AssetModel asset : fromCSV) {
    // System.out.println(asset);
    // }

    // AemTarget aem = new AemTarget();
    // aem.run();
  }
}
