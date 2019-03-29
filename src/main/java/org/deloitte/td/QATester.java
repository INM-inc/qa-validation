package org.deloitte.td;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
        options.addOption("debugId", "", true, "ID of Canto asset to debug (-1 to debug for all assets)");

        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss");

        CommandLineParser parser = new DefaultParser();

        RetrieveMetadataCSV csvRetriever = new RetrieveMetadataCSV();
        WriteResultsToExcel reportWriter = new WriteResultsToExcel();
        RetrieveMetadataAEM aemRetriever = new RetrieveMetadataAEM();
        CompareMetadata metadataComparator = new CompareMetadata();

//        String debugId = "86483";

        try {
            Date currentTime = new Date();

            CommandLine commandLine = parser.parse(options, args);
            String csvFile = commandLine.getOptionValue("source");
            int batchSize = Integer.parseInt(commandLine.getOptionValue("batchSize"));

            String outputFile = commandLine.getOptionValue("target") + "/report-" + dateFormat.format(currentTime) + ".csv";
            String outputFileDetailed = commandLine.getOptionValue("target") + "/report-detailed-" + dateFormat.format(currentTime) + ".csv";

            String debugId = commandLine.getOptionValue("debugId");
            if (debugId != null) {
                System.out.println(new Date() + " - [debugging for ID '" + debugId + "']");
            } else {
                System.out.println(new Date() + " - [no debugging]");
            }

            System.out.println(new Date() + " - Start of CSV metadata retrieval");
            List<Asset> assets = csvRetriever.loadAllAssetsFromCsv(csvFile);
            System.out.println(new Date() + " - End of CSV metadata retrieval");
            System.out.println(new Date() + " - " + assets.size() + " assets loaded");

            reportWriter.writeHeader(outputFile, false);
            reportWriter.writeHeader(outputFileDetailed, true);

            int count = 0;
            System.out.println(new Date() + " - Start of metadata comparison");
            for (Asset asset : assets) {
                if (count % batchSize == 0) {
                    System.out.println(new Date() + " - " + count + " assets compared");
                }

                String aemAssetPath = "/content/dam/Canada/" + asset.getContainer() + "/" + asset.getFileName();
                JsonObject aemAssetJson = aemRetriever.retrieveAssetJsonFromAem(aemAssetPath, commandLine.getOptionValue("host"));

                if (asset.getID().equals(debugId)) {
                    System.out.println("Canto ID = " + asset.getID());
                    System.out.println("First AEM asset path found = " + aemAssetPath);
                }

                if (aemAssetJson == null || (aemAssetJson != null && aemAssetJson.has("td:originalid") && !asset.getID().equals(aemAssetJson.get("td:originalid").getAsString()))) {
                    // ID different but same AEM path, probably a duplicate
                    String realAemPath = aemRetriever.findAemPathByCantoId(asset.getID(), commandLine.getOptionValue("host"), debugId);
                    if (realAemPath != null) {
                        aemAssetPath = realAemPath;
                        aemAssetJson = aemRetriever.retrieveAssetJsonFromAem(aemAssetPath, commandLine.getOptionValue("host"));
                    }
                }

                if (asset.getID().equals(debugId)) {
                    System.out.println("Canto ID = " + asset.getID());
                    System.out.println("Final AEM asset path found = " + aemAssetPath);
                }

                ComparisonResult comparisonResult = null;
                if (aemAssetJson == null) {
                    comparisonResult = metadataComparator.returnAemAssetNotFound(asset, aemAssetPath);
                } else {
                    comparisonResult = metadataComparator.compareCantoAemMetadata(asset, aemAssetJson, aemAssetPath);
                }

                reportWriter.writeResult(comparisonResult, outputFile, false);
                reportWriter.writeResult(comparisonResult, outputFileDetailed, true);
                count++;
            }
            System.out.println(new Date() + " - End of metadata comparison");

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}