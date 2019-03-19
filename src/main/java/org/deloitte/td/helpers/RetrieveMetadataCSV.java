package org.deloitte.td.helpers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.deloitte.td.model.Asset;

public class RetrieveMetadataCSV {

    public static ArrayList<Asset> retrieveFromCSV() {

        ArrayList<Asset> records = new ArrayList<>();
        BufferedReader br = null;
        String line = "";
        int counter = 0;
        try {
            br = new BufferedReader(new FileReader("/Users/averzea/Documents/td-config-files/source3.csv"));
            while ((line = br.readLine()) != null) {

                String[] lines = line.split("\\t");
                if (counter > 0 && !lines[64].equalsIgnoreCase("Archived") && !lines[5].equalsIgnoreCase("Rejected") && lines[19].contains("$Containers:")) {

                    Asset asset = new Asset();

                    // Initial Keywords, LOBs, Channels and Path.
                    ArrayList<String> keywords = new ArrayList<>(Arrays.asList(lines[79].replace("\"", "").split(", ")));
                    ArrayList<String> lobs = new ArrayList<>(Arrays.asList(lines[1].split(", ")));
                    ArrayList<String> channels = new ArrayList<>(Arrays.asList(lines[34].split(", ")));
                    asset.setTaxonomy2NewPath("NO_NEW_PATH");

                    // Additions to Initial Keywords, LOBs, Channels and Path based on Taxonomy Tab 2.
                    String containerField = TaxonomyChanges.getCorrectContainer(lines[19]);
                    String level4 = TaxonomyChanges.getContainerLevel4(containerField);
                    if (!level4.equals("NO_LEVEL_4")) {

                        ArrayList<String> keywordAdditions = TaxonomyChanges.addKeywords(level4);
                        keywords.addAll(keywordAdditions);

                        ArrayList<String> lobAdditions = TaxonomyChanges.addLOBs(level4);
                        lobs.addAll(lobAdditions);

                        ArrayList<String> channelAdditions = TaxonomyChanges.addChannels(level4);
                        channels.addAll(channelAdditions);

                        String taxonomy2NewPath = TaxonomyChanges.changePath(level4);
                        asset.setTaxonomy2NewPath(taxonomy2NewPath);

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
                    asset.setContainer(containerField);
                    asset.setFileName(lines[8]);
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

                    records.add(asset);
                }
                counter++;
            }
            br.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }

}
