package org.deloitte.td.helpers;

import org.deloitte.td.model.AssetModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AddShaToMetadataCSV {

    public static ArrayList<AssetModel> addShaToMetadataCSV(ArrayList<AssetModel> fromCSV, HashMap<String, HashMap<String, String>> fromAssetsRenamed) {

        for (AssetModel assetFromCSV : fromCSV) {
            for (Map.Entry<String, HashMap<String, String>> assetFromAssetsRenamed : fromAssetsRenamed.entrySet()) {
                String fromCSVContainer = assetFromCSV.getContainer();
                String fromCSVFileName = assetFromCSV.getFileName();
                String fromAssetsRenamedSha = assetFromAssetsRenamed.getKey();
                HashMap<String, String> fromAssetsRenamedMetadata = assetFromAssetsRenamed.getValue();
                String fromAssetsRenamedFileName = fromAssetsRenamedMetadata.get("File Name");
                String fromAssetsRenamedContainer = fromAssetsRenamedMetadata.get("Containers");
                if (fromCSVContainer.equalsIgnoreCase(fromAssetsRenamedContainer) && fromCSVFileName.equalsIgnoreCase(fromAssetsRenamedFileName)) {
                    assetFromCSV.setSha(fromAssetsRenamedSha);
                }
            }
        }
        return fromCSV;
    }
}