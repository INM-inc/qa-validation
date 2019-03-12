package org.deloitte.td.helpers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.deloitte.td.model.AssetModel;
import org.deloitte.td.helpers.MetadataAdditions;

public class RetrieveMetadataCSV {

    public static ArrayList<AssetModel> retrieveFromCSV() {

        ArrayList<AssetModel> records = new ArrayList<>();
        BufferedReader br = null;
        String line = "";
        int counter = 0;
        try {
            br = new BufferedReader(new FileReader("/Users/averzea/Documents/td-config-files/source3.csv"));
            while ((line = br.readLine()) != null) {

                // Group Additions
                ArrayList<String> groupAdditions = MetadataAdditions.searchForGroups(line);

                // Channel Additions
                ArrayList<String> channelAdditions = MetadataAdditions.searchForChannels(line);

                // Other Additions
                ArrayList<String> otherAdditions = MetadataAdditions.searchForOthers(line);

                if (counter > 0) {
                    String[] lines = line.split("\\t");
                    AssetModel asset = new AssetModel();

                    // All Keywords
                    String[] keywords = lines[79].split(", ");
                    ArrayList<String> keywordAdditions = MetadataAdditions.searchForKeywords(line);
                    asset.setKeywords(keywords);

                    asset.setActivityProposalNumber(lines[9]);
                    asset.setProjectName(lines[56]);
                    asset.setAssetType(lines[52]);

                    asset.setInMarket(lines[12]);
                    asset.setExpiryDate(lines[84]);
                    asset.setChannel(lines[34]);
                    asset.setBranchID(lines[44]);
                    asset.setAgencyName(lines[30]);
                    asset.setAgencyNameOther(lines[76]);
                    asset.setDescription(lines[53]);
                    asset.setLanguage(lines[62]);
                    asset.setGroupName(lines[1]);
                    asset.setPhotoSource(lines[61]);
                    asset.setUsageRights(lines[69]);
                    asset.setUsageRightsOther(lines[32]);
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
