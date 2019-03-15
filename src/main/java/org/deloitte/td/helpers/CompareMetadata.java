package org.deloitte.td.helpers;

import com.google.gson.JsonObject;
import org.deloitte.td.model.AssetModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CompareMetadata {

    public static HashMap<String, String> getAEMMappings() {

        HashMap<String, String> aemMappings = new HashMap<>();
        aemMappings.put("AP (Activity Proposal) Number", "td:apn");
        aemMappings.put("Project Name", "td:projectname");
        aemMappings.put("Asset Type", "td:assettype");
        aemMappings.put("Keywords", "td:keywords");
        aemMappings.put("In Market", "td:inmarket@date");
        aemMappings.put("Expiry Date", "td:expiry@date");
        aemMappings.put("Channel", "td:channel");
        aemMappings.put("Branch ID", "td:branchid");
        aemMappings.put("Agency Name", "td:agency");
        aemMappings.put("Agency Project ID", "td:agencypid");
        aemMappings.put("Description", "dc:description");
        aemMappings.put("Language", "td:language");
        aemMappings.put("Line Of Business", "td:lob");
        aemMappings.put("Photo Source", "td:photosource");
        aemMappings.put("Usage Rights", "td:usageright");
        aemMappings.put("Approval Status", "td:approval");
        aemMappings.put("Image Width", "tiff:ImageWidth");
        aemMappings.put("Image Height", "tiff:ImageLength");
        aemMappings.put("Resolution (Horizontal)", "tiff:XResolution");
        aemMappings.put("Resolution (Vertical)", "tiff:YResolution");
        aemMappings.put("Photographer or Creator", "dc:creator");
        aemMappings.put("Date File Captured", "td:datefilecaptured");
        aemMappings.put("File Format", "dam:FileFormat");
        aemMappings.put("File Size", "dam:size");
        aemMappings.put("Date Record Last Modified", "dc:modified@date");
        aemMappings.put("Date File Cataloged", "td:catalogued@date");
        return aemMappings;

    }

    public static HashMap<String, String> checkForDifferences(ArrayList<AssetModel> fromCSV, JsonObject fromAEM) {

        HashMap<String, String> aemMappings = getAEMMappings();
        HashMap<String, String> differences = new HashMap<>();

        /*
         * Check AEM Column Names
         */
        for (AssetModel asset : fromCSV) {
            for (Map.Entry<String, String> proposalNumber : asset.getActivityProposalNumber().entrySet()) {
                 String expectedColumnName = proposalNumber.getKey();
            }
        }
        /*
         * If column names don't match, write this to differences and quit.
         */

        for (AssetModel asset : fromCSV) {
            for (Map.Entry<String, String> proposalNumber : asset.getActivityProposalNumber().entrySet()) {
                String expectedColumnName = proposalNumber.getValue();

            }
        }


        for (Map.Entry<String, String> aemMapping : aemMappings.entrySet()) {
            String taxonomy2FieldName = aemMapping.getKey();
            String aemMetadataKey = aemMapping.getValue();
            for (AssetModel asset : fromCSV) {

            }
            String csvMetadataValue = fromCSV.get(taxonomy2FieldName);
            String aemMetadataValue = fromAEM.get(aemMetadataKey).getAsString();
        }
        




        return differences;

    }
}
