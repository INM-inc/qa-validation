package org.deloitte.td;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.google.gson.JsonObject;
import org.deloitte.td.helpers.*;
import org.deloitte.td.model.Asset;
import org.apache.commons.cli.*;

public class QATester {

  public static void main(String[] args) {

    QATester qaTester = new QATester();
    qaTester.run(args);
    // java -jar /Users/averzea/Projects/qa-validation/target/qa-validation-1.0-SNAPSHOT.jar -source /Users/averzea/Documents/td-config-files/sources/source.csv -target /Users/averzea/Downloads/TD_DAM_QA_BATCH_ -batchSize 5000 -host https://13.88.236.91

  }

  public void run(String[] args) {

    Options options = new Options();
    options.addRequiredOption("source", "",true, "Source CSV File");
    options.addRequiredOption("target", "",true, "Output file");
    options.addRequiredOption("batchSize", "",true, "Batch Size");
    options.addRequiredOption("host", "",true, "Host");

    CommandLineParser parser = new DefaultParser();

    try {

      CommandLine commandLine = parser.parse(options, args);
      String csvFile = commandLine.getOptionValue("source");
      int batchSize = Integer.parseInt(commandLine.getOptionValue("batchSize"));

      String outputFile = commandLine.getOptionValue("target") + "/report.csv";
      String outputFileDetailed = commandLine.getOptionValue("target") + "/report-detailed.csv";

      System.out.println(new Date() + " - Start of CSV metadata retrieval");
      List<Asset> assets = RetrieveMetadataCSV.loadAllAssetsFromCsv(csvFile);
      System.out.println(new Date() + " - End of CSV metadata retrieval");
      System.out.println(new Date() + " - " + assets.size() + " assets loaded");

      WriteResultsToExcel.writeHeader(outputFile, false);
      WriteResultsToExcel.writeHeader(outputFileDetailed, true);

      int count = 0;
      System.out.println(new Date() + " - Start of metadata comparison");
      for (Asset asset : assets) {
        if (count % batchSize == 0) {
          System.out.println(new Date() + " - " + count + " assets compared");
        }
        String aemAssetPath = "/content/dam/Canada/" + asset.getContainer() + "/" + asset.getFileName();
        JsonObject aemAssetJson = RetrieveMetadataAEM.retrieveAssetJsonFromAem(aemAssetPath, commandLine.getOptionValue("host"));
        ComparisonResult comparisonResult = null;
        if (aemAssetJson == null) {
          comparisonResult = CompareMetadata.returnAemAssetNotFound(asset);
        } else {
          comparisonResult = CompareMetadata.compareCantoAemMetadata(asset, aemAssetJson, aemAssetPath);
        }
        WriteResultsToExcel.writeResult(comparisonResult, outputFile, false);
        WriteResultsToExcel.writeResult(comparisonResult, outputFileDetailed, true);
        count++;
      }
      System.out.println(new Date() + " - End of metadata comparison");

    } catch (Exception e) {

      e.printStackTrace(System.out);

    }

  }
}