package org.deloitte.td;

import java.util.List;
import org.deloitte.td.dto.MigrationDto;
import org.deloitte.td.helpers.RetrieveMetadataCSV;
import org.deloitte.td.helpers.RetrieveMetadataAEM;
import org.deloitte.td.helpers.CheckMetadata;

//import org.deloitte.td.dto.MigrationDto;
//import org.deloitte.td.utils.AemTarget;


public class Main {

  public static void main(String[] args) {

    List<MigrationDto> fromCSV = RetrieveMetadataCSV.retrieveFromCSV();
    for (MigrationDto mdto : fromCSV) {
      System.out.println(mdto);
    }

//    AemTarget aem = new AemTarget();
//    aem.run();
  }
}
