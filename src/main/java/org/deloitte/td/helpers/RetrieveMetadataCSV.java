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

        List<AssetModel> records = new ArrayList<>();
        BufferedReader br = null;
        String _line = "";
        try {
            br = new BufferedReader(new FileReader("/Users/averzea/Documents/td-config-files/source3.csv"));
            while ((_line = br.readLine()) != null) {
                String[] lines = _line.split("\\t");

                AssetModel asset = new AssetModel();
                asset.setActivityProposalNumber(lines[0]);
                asset.setProjectName(lines[1]);
                asset.setAssetType(lines[2]);
                asset.setKeywords(lines[3]);
                asset.setKeywords(lines[3]);
                asset.setKeywords(lines[3]);
                asset.setKeywords(lines[3]);
                records.add(asset);
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
