package org.deloitte.td;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.JsonObject;
import org.deloitte.td.helpers.CompareMetadata;
import org.deloitte.td.helpers.RetrieveMetadataAEM;
import org.deloitte.td.helpers.RetrieveMetadataCSV;
import org.deloitte.td.helpers.WriteResultsToExcel;
import org.deloitte.td.model.Asset;
import org.apache.commons.cli.*;

public class QATester {

  public static void main(String[] args) {

    QATester qaTester = new QATester();
    qaTester.run(args);
    // java -jar /Users/averzea/Projects/qa-validation/target/qa-validation-1.0-SNAPSHOT.jar -source /Users/averzea/Documents/td-config-files/sources/source.csv -target /Users/averzea/Downloads/TD_DAM_QA_BATCH_ -batchSize 5000

  }

  public void run(String[] args) {

    Options options = new Options();
    options.addRequiredOption("source", "",true, "Source CSV File");
    options.addRequiredOption("target", "",true, "Output file");
    options.addRequiredOption("batchSize", "",true, "Batch Size");

    CommandLineParser parser = new DefaultParser();

    try {

      CommandLine commandLine = parser.parse(options, args);
      String csvFile = commandLine.getOptionValue("source");
      int batchSize = Integer.parseInt(commandLine.getOptionValue("batchSize"));

      int numberOfLines = 0;
      BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFile));
      while (bufferedReader.readLine() != null) numberOfLines++;
      int numberOfBatches = (int) Math.ceil((double) numberOfLines/batchSize);

      /*
       * Mock parameters for testing.
       */
      batchSize = 100;
      numberOfBatches = 2;

      for (int iteration = 0; iteration < numberOfBatches; iteration++) {

        ArrayList<Asset> fromCSV = RetrieveMetadataCSV.retrieveFromCSV(csvFile, batchSize, iteration);
        HashMap<String, JsonObject> fromAEM = RetrieveMetadataAEM.retrieveFromAEM(fromCSV, iteration);
        HashMap<String, String> filesAndDifferences = CompareMetadata.checkForDifferences(fromCSV, fromAEM, iteration);
        WriteResultsToExcel.writeResultsToExcel(commandLine.getOptionValue("target") + iteration, filesAndDifferences, iteration);

      }

      bufferedReader.close();

    } catch (Exception e) {

      System.out.println(e.getMessage());

    }

  }
}