package org.deloitte.td.helpers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.deloitte.td.model.AssetModel;

public class RetrieveMetadataCSV {

    public static ArrayList<AssetModel> retrieveFromCSV() {

        ArrayList<AssetModel> records = new ArrayList<>();
        BufferedReader br = null;
        String line = "";
        int counter = 0;
        try {
            br = new BufferedReader(new FileReader("/Users/averzea/Documents/td-config-files/source3.csv"));
            while ((line = br.readLine()) != null) {

                if (counter > 0) {
                    String[] lines = line.split("\\t");
                    AssetModel asset = new AssetModel();
                    System.out.println(counter);

                    // Initial Keywords, LOBs, Channels and Path.
                    ArrayList<String> keywords = new ArrayList<>(Arrays.asList(lines[79].split(", ")));
                    ArrayList<String> lobs = new ArrayList<>(Arrays.asList(lines[1].split(", ")));
                    ArrayList<String> channels = new ArrayList<>(Arrays.asList(lines[34].split(", ")));
                    asset.setTaxonomy2NewPath("NO_NEW_PATH");

                    // Additions to Initial Keywords, LOBs, Channels and Path based on Taxonomy Tab 2.
                    String container = lines[19];
                    String level4 = TaxonomyChanges.getContainerLevel4(container);
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
                    asset.setKeywords(keywords);
                    asset.setLOBs(lobs);
                    asset.setChannels(channels);
//                    System.out.println(asset.getChannels().entrySet().iterator().next());

                    // Agency Name
                    String agencyNameOther = lines[76];
                    if (!agencyNameOther.isEmpty()) {
                        asset.setAgencyName(agencyNameOther);
                    } else {
                        asset.setAgencyName(lines[30]);
                    }

                    // Usage Rights
                    String usageRightsOther = lines[32];
                    if (!usageRightsOther.isEmpty()) {
                        asset.setUsageRights(usageRightsOther);
                    } else {
                        asset.setUsageRights(lines[69]);
                    }

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
                    asset.setImageWidth(lines[29]);
                    asset.setImageHeight(lines[28]);
                    asset.setPrintDimensions(lines[75]);
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
