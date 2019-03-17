package org.deloitte.td;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonObject;
import org.deloitte.td.helpers.CompareMetadata;
import org.deloitte.td.helpers.RetrieveMetadataAEM;
import org.deloitte.td.helpers.RetrieveMetadataCSV;
import org.deloitte.td.helpers.AddShaToMetadataCSV;
import org.deloitte.td.model.Asset;
import org.deloitte.td.utils.AemTarget;

//import org.deloitte.td.dto.MigrationDto;
//import org.deloitte.td.utils.AemTarget;

public class Main {

  public static void main(String[] args) {

    ArrayList<Asset> fromCSV = RetrieveMetadataCSV.retrieveFromCSV();
    AemTarget aem = new AemTarget();
    HashMap<String, HashMap<String, String>> fromAssetsRenamed = aem.run();
    ArrayList<Asset> fromCSVWithSha = AddShaToMetadataCSV.addShaToMetadataCSV(fromCSV, fromAssetsRenamed);
    HashMap<String, JsonObject> fromAEM = RetrieveMetadataAEM.retrieveFromAEM();
    HashMap<String, String> filesAndDifferences = CompareMetadata.checkForDifferences(fromCSVWithSha, fromAEM);
//    for (Map.Entry<String, JsonObject> aemAsset : fromAEM.entrySet()) {
//      System.out.println(aemAsset.getKey());
//      System.out.println(aemAsset.getValue());
//      System.out.println("...................");
//    }
//    for (Map.Entry<String, HashMap<String, String>> shaAndFileMetadata : shaAndFilesMetadata.entrySet()) {
//      System.out.println(shaAndFileMetadata.getKey());
//      for (Map.Entry<String, String> fileMetadata : shaAndFileMetadata.getValue().entrySet()) {
//        System.out.println(fileMetadata);
//      }
//      System.out.println("........");
//    }
//    WriteResultsToExcel.writeResultsToExcel(filesAndDifferences);

  }
}
