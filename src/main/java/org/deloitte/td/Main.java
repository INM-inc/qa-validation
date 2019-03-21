package org.deloitte.td;

import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.JsonObject;
import org.deloitte.td.helpers.CompareMetadata;
import org.deloitte.td.helpers.RetrieveMetadataAEM;
import org.deloitte.td.helpers.RetrieveMetadataCSV;
import org.deloitte.td.helpers.WriteResultsToExcel;
import org.deloitte.td.model.Asset;

public class Main {

  public static void main(String[] args) {

    ArrayList<Asset> fromCSV = RetrieveMetadataCSV.retrieveFromCSV();
    HashMap<String, JsonObject> fromAEM = RetrieveMetadataAEM.retrieveFromAEM(fromCSV);
    HashMap<String, String> filesAndDifferences = CompareMetadata.checkForDifferences(fromCSV, fromAEM);
    WriteResultsToExcel.writeResultsToExcel(filesAndDifferences);

  }
}
