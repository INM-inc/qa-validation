package org.deloitte.td.helpers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import org.deloitte.td.model.Asset;

public class RetrieveMetadataCSV {

    private static int indexRecordStatus = 64;
    private static int indexApprovalStatus = 5;
    private static int indexContainers = 19;
    private static int indexKeywords = 79;
    private static int indexGroupName = 1;
    private static int indexChannels = 34;
    private static int indexUsageRights = 69;
    private static int indexUsageRightsOther = 32;
    private static int indexAgencyName = 30;
    private static int indexAgencyNameOther = 76;
    private static int indexFileName = 8;
    private static int indexAgencyProjectId = 67;
    private static int indexActivityProposalNumber = 9;
    private static int indexProjectName = 56;
    private static int indexAssetType = 82;
    private static int indexInMarketDate = 12;
    private static int indexExpiry = 84;
    private static int indexBranchId = 44;
    private static int indexDescription = 53;
    private static int indexLanguage = 62;
    private static int indexPhotoSource = 61;
    private static int indexImageWidth = 3;
    private static int indexImageHeight = 54;
    private static int indexResolutionVertical = 31;
    private static int indexResolutionHorizontal = 17;
    private static int indexPhotographer = 45;
    private static int indexDateFileCaptured = 70;
    private static int indexFileFormat = 18;
    private static int indexFileSize = 11;
    private static int indexDateRecordLastModified = 21;
    private static int indexDateFileCatalogued = 22;
    private static int indexCataloguedBy = 16;
    private static int indexId = 7;

    public static List<Asset> loadAllAssetsFromCsv(String csvFile) {
        List<Asset> assets = new ArrayList<>();
        BufferedReader bufferedReader = null;
        FileReader fileReader = null;
        String line = null;

        try {
            fileReader = new FileReader(csvFile);
            bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
//                System.out.println("counter " + counter);
                if (!line.contains("Number of Words")) {

                    String[] lines = line.split("\\t");
//                    System.out.println(lines.length);
                    Asset asset = new Asset();
                    if (
                            lines.length >= (Math.max(Math.max(indexRecordStatus, indexApprovalStatus), indexContainers) + 1) &&
                            !lines[indexRecordStatus].equalsIgnoreCase("Archived") &&
                                    !lines[indexRecordStatus].equalsIgnoreCase("Inactive/Expired") &&
                                    !lines[indexApprovalStatus].equalsIgnoreCase("Rejected") &&
                                    lines[indexContainers].contains("$Containers:")
                    ) {

                        // Initial Keywords, LOBs and Channels.
                        ArrayList<String> keywords = new ArrayList<>();
                        if (lines.length >= (indexKeywords + 1)) {
                            keywords = new ArrayList<>(Arrays.asList(lines[indexKeywords].replace("\"", "").split(", ")));
                        }
                        ArrayList<String> lobs = new ArrayList<>(Arrays.asList(lines[indexGroupName].split(", ")));
                        ArrayList<String> channels = new ArrayList<>(Arrays.asList(lines[indexChannels].split(", ")));

                        // Additions to Initial Keywords, LOBs and Channels based on Taxonomy Tab 2.
                        HashMap<String, String> level4AndCorrectPath = TaxonomyChanges.getLevel4AndCorrectPath(lines[indexContainers], lines[indexId]);
                        String level4 = level4AndCorrectPath.get("level4");
                        String correctPath = level4AndCorrectPath.get("correctPath");

//                        if (lines[indexId].equals("147064")) {
//                            System.out.println("Container = '" + lines[indexContainers] + "'");
//                            System.out.println("correctPath = '" + correctPath + "'");
//                        }

                        if (!level4.equals("NO_LEVEL_4")) {

                            ArrayList<String> keywordAdditions = TaxonomyChanges.addKeywords(level4);
                            keywords.addAll(keywordAdditions);

                            ArrayList<String> lobAdditions = TaxonomyChanges.addLOBs(level4);
                            lobs.addAll(lobAdditions);

                            ArrayList<String> channelAdditions = TaxonomyChanges.addChannels(level4);
                            channels.addAll(channelAdditions);

                        }

                        // Eliminate empty string values as they bias the result.
                        keywords.removeAll(Arrays.asList("", null));
                        lobs.removeAll(Arrays.asList("", null));
                        channels.removeAll(Arrays.asList("", null));

                        // Set the corrected ArrayLists
                        asset.setKeywords(keywords);
                        asset.setLOBs(lobs);
                        asset.setChannels(channels);

                        if (lines.length >= (indexUsageRights + 1)) {
                            asset.setUsageRights(lines[indexUsageRights]);
                        }
                        asset.setUsageRightsOther(lines[indexUsageRightsOther]);
                        asset.setAgencyName(lines[indexAgencyName]);
                        if (lines.length >= (indexAgencyNameOther + 1)) {
                            asset.setAgencyNameOther(lines[indexAgencyNameOther]);
                        }
                        asset.setContainer(correctPath);
                        asset.setFileName(lines[indexFileName].replaceAll("%", "").replaceAll("#", "").replaceAll("\\[", "_").replaceAll("\\]", "_"));
                        if (lines.length >= (indexAgencyProjectId + 1)) {
                            asset.setAgencyProjectID(lines[indexAgencyProjectId]);
                        }
                        asset.setActivityProposalNumber(lines[indexActivityProposalNumber]);
                        if (lines.length >= (indexProjectName + 1)) {
                            asset.setProjectName(lines[indexProjectName]);
                        }
                        if (lines.length >= (indexAssetType + 1)) {
                            asset.setAssetType(lines[indexAssetType]);
                        }
                        asset.setInMarketDate(lines[indexInMarketDate]);
                        if (lines.length >= (indexExpiry + 1)) {
                            asset.setExpiryDate(lines[indexExpiry]);
                        }
                        asset.setBranchID(lines[indexBranchId]);
                        asset.setDescription(lines[indexDescription]);
                        if (lines.length >= (indexLanguage + 1)) {
                            asset.setLanguage(lines[indexLanguage]);
                        }
                        if (lines.length >= (indexPhotoSource + 1)) {
                            asset.setPhotoSource(lines[indexPhotoSource]);
                        }
                        asset.setApprovalStatus(lines[indexApprovalStatus]);
                        asset.setImageWidth(lines[indexImageWidth]);
                        asset.setImageHeight(lines[indexImageHeight]);
                        asset.setResolutionVertical(lines[indexResolutionVertical]);
                        asset.setResolutionHorizontal(lines[indexResolutionHorizontal]);
                        asset.setPhotographer(lines[indexPhotographer]);
                        if (lines.length >= (indexDateFileCaptured + 1)) {
                            asset.setDateFileCaptured(lines[indexDateFileCaptured]);
                        }
                        asset.setFileFormat(lines[indexFileFormat]);
                        asset.setFileSize(lines[indexFileSize]);
                        asset.setDateRecordLastModified(lines[indexDateRecordLastModified]);
                        asset.setDateFileCataloged(lines[indexDateFileCatalogued]);
                        asset.setCatalogedBy(lines[indexCataloguedBy]);
                        asset.setID(lines[indexId]);
                        asset.setCorrupted(false);
                        //if (!correctPath.equals("IGNORE")) {
                            assets.add(asset);
                        //}
                    }
                }
            }

            bufferedReader.close();
            fileReader.close();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace(System.out);
                }
            }
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace(System.out);
                }
            }
        }

        return assets;
    }

    public static ArrayList<Asset> retrieveFromCSV(String csvFile, int batchSize, int iteration) {

        ArrayList<Asset> records = new ArrayList<>();
        String line = "";
        int start = batchSize * iteration + 1;
        int end = batchSize * (iteration + 1);
        int counter = start;

        System.out.println("Start of CSV metadata retrieval for BATCH " + iteration);

        try {

            /*
             * Initialize the BR and skip lines corresponding to previous batches.
             */
            BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFile));
            for (int numberOfLinesBefore = 0; numberOfLinesBefore < counter; numberOfLinesBefore++) {
                bufferedReader.readLine();
            }

            while (((line = bufferedReader.readLine()) != null) && counter <= end) {

                if (!line.contains("Number of Words")) {

                    String[] lines = line.split("\\t");
                    Asset asset = new Asset();
                    if (
                        lines.length > 85 &&
                        !lines[64].equalsIgnoreCase("Archived") &&
                        !lines[5].equalsIgnoreCase("Rejected") &&
                        !lines[5].equalsIgnoreCase("Inactive/Expired") &&
                        lines[19].contains("$Containers:")
                    ) {

                        // Initial Keywords, LOBs and Channels.
                        ArrayList<String> keywords = new ArrayList<>(Arrays.asList(lines[79].replace("\"", "").split(", ")));
                        ArrayList<String> lobs = new ArrayList<>(Arrays.asList(lines[1].split(", ")));
                        ArrayList<String> channels = new ArrayList<>(Arrays.asList(lines[34].split(", ")));

                        // Additions to Initial Keywords, LOBs and Channels based on Taxonomy Tab 2.
                        HashMap<String, String> level4AndCorrectPath = TaxonomyChanges.getLevel4AndCorrectPath(lines[19], lines[7]);
                        String level4 = level4AndCorrectPath.get("level4");
                        String correctPath = level4AndCorrectPath.get("correctPath");
                        if (!level4.equals("NO_LEVEL_4")) {

                            ArrayList<String> keywordAdditions = TaxonomyChanges.addKeywords(level4);
                            keywords.addAll(keywordAdditions);

                            ArrayList<String> lobAdditions = TaxonomyChanges.addLOBs(level4);
                            lobs.addAll(lobAdditions);

                            ArrayList<String> channelAdditions = TaxonomyChanges.addChannels(level4);
                            channels.addAll(channelAdditions);

                        }

                        // Eliminate empty string values as they bias the result.
                        keywords.removeAll(Arrays.asList("", null));
                        lobs.removeAll(Arrays.asList("", null));
                        channels.removeAll(Arrays.asList("", null));

                        // Set the corrected ArrayLists
                        asset.setKeywords(keywords);
                        asset.setLOBs(lobs);
                        asset.setChannels(channels);

                        asset.setUsageRights(lines[69]);
                        asset.setUsageRightsOther(lines[32]);
                        asset.setAgencyName(lines[30]);
                        asset.setAgencyNameOther(lines[76]);
                        asset.setContainer(correctPath);
                        asset.setFileName(lines[8].replace(" ", "%20"));
                        asset.setAgencyProjectID(lines[67]);
                        asset.setActivityProposalNumber(lines[9]);
                        asset.setProjectName(lines[56]);
                        asset.setAssetType(lines[82]);
                        asset.setInMarketDate(lines[12]);
                        asset.setExpiryDate(lines[84]);
                        asset.setBranchID(lines[44]);
                        asset.setDescription(lines[53]);
                        asset.setLanguage(lines[62]);
                        asset.setPhotoSource(lines[61]);
                        asset.setApprovalStatus(lines[5]);
                        asset.setImageWidth(lines[3]);
                        asset.setImageHeight(lines[54]);
                        asset.setResolutionVertical(lines[31]);
                        asset.setResolutionHorizontal(lines[17]);
                        asset.setPhotographer(lines[45]);
                        asset.setDateFileCaptured(lines[70]);
                        asset.setFileFormat(lines[18]);
                        asset.setFileSize(lines[11]);
                        asset.setDateRecordLastModified(lines[21]);
                        asset.setDateFileCataloged(lines[22]);
                        asset.setCatalogedBy(lines[16]);
                        asset.setID(lines[7]);
                        asset.setCorrupted(false);
                        asset.setCSVLine(counter);
                        if (!correctPath.equals("IGNORE")) {
                            records.add(asset);
                        }
                    } else if (lines.length <= 85) {
                        asset.setCorrupted(true);
                        asset.setCSVLine(counter);
                        records.add(asset);
                    }

                    counter++;

                }

            }

            bufferedReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("End of CSV metadata retrieval for BATCH " + iteration);

        return records;
    }

}
