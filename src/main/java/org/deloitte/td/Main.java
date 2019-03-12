package org.deloitte.td;

import org.deloitte.td.dto.MigrationDto;
import org.deloitte.td.utils.AemTarget;

import java.util.List;

public class Main {
  public static void main(String[] args) {
    AemTarget aem = new AemTarget();
    if (args.length > 0) {
      aem.run(args[0],args[1]);
    }
  }
}
