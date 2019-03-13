package org.deloitte.td;

import java.util.Iterator;
import java.util.List;

import org.deloitte.td.helpers.RetrieveMetadataCSV;
import org.deloitte.td.helpers.RetrieveMetadataAEM;
import org.deloitte.td.model.AssetModel;

//import org.deloitte.td.dto.MigrationDto;
//import org.deloitte.td.utils.AemTarget;

public class Main {

  public static void main(String[] args) {

    List<AssetModel> fromCSV = RetrieveMetadataCSV.retrieveFromCSV();
    String result = RetrieveMetadataAEM.retrieveFromAEM();


//    Iterator iterator = fromCSV.iterator();
    // for (AssetModel asset : fromCSV) {
    // System.out.println(asset);
    // }

    // AemTarget aem = new AemTarget();
    // aem.run();
  }
}
