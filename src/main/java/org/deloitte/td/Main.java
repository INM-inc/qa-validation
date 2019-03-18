package org.deloitte.td;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonObject;
import org.deloitte.td.helpers.CompareMetadata;
import org.deloitte.td.helpers.RetrieveMetadataAEM;
import org.deloitte.td.helpers.RetrieveMetadataCSV;
import org.deloitte.td.helpers.AddShaToMetadataCSV;
import org.deloitte.td.helpers.WriteResultsToExcel;
import org.deloitte.td.model.Asset;
import org.deloitte.td.utils.AemTarget;

//import org.deloitte.td.dto.MigrationDto;
//import org.deloitte.td.utils.AemTarget;

public class Main {

  public static void main(String[] args) {

//    AemTarget aem = new AemTarget();
//    HashMap<String, HashMap<String, String>> fromAssetsRenamed = aem.run();
//    ArrayList<Asset> fromCSVWithSha = AddShaToMetadataCSV.addShaToMetadataCSV(fromCSV, fromAssetsRenamed);
    ArrayList<Asset> fromCSV = RetrieveMetadataCSV.retrieveFromCSV();
    HashMap<String, JsonObject> fromAEM = RetrieveMetadataAEM.retrieveFromAEM(fromCSV);
    HashMap<String, String> filesAndDifferences = CompareMetadata.checkForDifferences(fromCSV, fromAEM);
    WriteResultsToExcel.writeResultsToExcel(filesAndDifferences);

  }
}
