package org.deloitte.td.helpers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import org.deloitte.td.model.Asset;

public class RetrieveMetadataCSV {

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
                        HashMap<String, String> level4AndCorrectPath = TaxonomyChanges.getLevel4AndCorrectPath(lines[19]);
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
