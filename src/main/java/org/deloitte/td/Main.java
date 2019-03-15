package org.deloitte.td;

import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.JsonObject;
import org.deloitte.td.helpers.CompareMetadata;
import org.deloitte.td.helpers.RetrieveMetadataAEM;
import org.deloitte.td.helpers.RetrieveMetadataCSV;
import org.deloitte.td.helpers.WriteResultsToExcel;
import org.deloitte.td.model.AssetModel;

//import org.deloitte.td.dto.MigrationDto;
//import org.deloitte.td.utils.AemTarget;

public class Main {

  public static void main(String[] args) {

    ArrayList<AssetModel> fromCSV = RetrieveMetadataCSV.retrieveFromCSV();
    JsonObject fromAEM = RetrieveMetadataAEM.retrieveFromAEM();
    HashMap<String, String> filesAndDifferences = CompareMetadata.checkForDifferences(fromCSV, fromAEM);
    WriteResultsToExcel.writeResultsToExcel(filesAndDifferences);

//    Iterator iterator = fromCSV.iterator();
    // for (AssetModel asset : fromCSV) {
    // System.out.println(asset);
    // }

    // AemTarget aem = new AemTarget();
    // aem.run();
  }
}
