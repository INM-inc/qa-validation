package org.deloitte.td.helpers;

import org.deloitte.td.model.AssetModel;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RetrieveMetadataCSV {

    public static List<AssetModel> retrieveFromCSV() {

        List<AssetModel> records = new ArrayList<AssetModel>();
        BufferedReader br = null;
        String _line = "";
        int counter = 0;
        try {
            br = new BufferedReader(new FileReader("/Users/averzea/Documents/td-config-files/source3.csv"));
            while ((_line = br.readLine()) != null) {
                if (counter > 0) {
                    String[] lines = _line.split("\\t");
                    AssetModel asset = new AssetModel();
                    asset.setActivityProposalNumber(lines[9]);
                    asset.setProjectName(lines[56]);
                    asset.setAssetType(lines[52]);
                    // asset.setKeywords(lines[79]);
                    asset.setInMarket(lines[12]);
                    asset.setExpiryDate(lines[84]);
                    asset.setChannel(lines[34]);
                    asset.setBranchID(lines[44]);
                    asset.setAgencyName(lines[30]);
                    asset.setDescription(lines[53]);
                    asset.setLanguage(lines[62]);
                    asset.setGroupName(lines[1]);
                    asset.setPhotoSource(lines[61]);
                    asset.setUsageRights(lines[69]);
                    asset.setImageWidth(lines[29]);
                    asset.setImageHeight(lines[28]);
                    asset.setPrintDimensions(lines[75]);
                    asset.setResolutionVertical(lines[31]);
                    asset.setResolutionHorizontal(lines[17]);
                    asset.setPhotographer(lines[45]);
                    asset.setDateFileCaptured(lines[70]);
                    asset.setFileFormat(lines[18]);
                    asset.setFileSize(lines[11]);
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
