package org.deloitte.td;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.JsonObject;
import org.deloitte.td.dto.MigrationDto;
import org.deloitte.td.helpers.CompareMetadata;
import org.deloitte.td.helpers.RetrieveMetadataAEM;
import org.deloitte.td.helpers.RetrieveMetadataCSV;
import org.deloitte.td.helpers.AddShaToMetadataCSV;
import org.deloitte.td.helpers.WriteResultsToExcel;
import org.deloitte.td.model.AssetModel;
import org.deloitte.td.utils.AemTarget;

//import org.deloitte.td.dto.MigrationDto;
//import org.deloitte.td.utils.AemTarget;

public class Main {

  public static void main(String[] args) {

    ArrayList<AssetModel> fromCSV = RetrieveMetadataCSV.retrieveFromCSV();
    AemTarget aem = new AemTarget();
    HashMap<String, HashMap<String, String>> fromAssetsRenamed = aem.run();
    ArrayList<AssetModel> fromCSVWithSha = AddShaToMetadataCSV.addShaToMetadataCSV(fromCSV, fromAssetsRenamed);
//    for (Map.Entry<String, HashMap<String, String>> shaAndFileMetadata : shaAndFilesMetadata.entrySet()) {
//      System.out.println(shaAndFileMetadata.getKey());
//      for (Map.Entry<String, String> fileMetadata : shaAndFileMetadata.getValue().entrySet()) {
//        System.out.println(fileMetadata);
//      }
//      System.out.println("........");
//    }
//    JsonObject fromAEM = RetrieveMetadataAEM.retrieveFromAEM();
//    HashMap<String, String> filesAndDifferences = CompareMetadata.checkForDifferences(fromCSV, fromAEM);
//    WriteResultsToExcel.writeResultsToExcel(filesAndDifferences);

  }
}
