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

    public static HashMap<String, String> getApprovalStatusMappings() {

        HashMap<String, String> approvalStatusMappings = new HashMap<>();
        approvalStatusMappings.put("#Not Applicable", "Draft");
        approvalStatusMappings.put("#Unknown", "Draft");
        approvalStatusMappings.put("Approved ", "Approved");
        approvalStatusMappings.put("On Hold", "Draft");
        approvalStatusMappings.put("Pending", "Draft");
        approvalStatusMappings.put("Rejected", "Draft");

        return approvalStatusMappings;

    }

    public static HashMap<String, String> getAgencyNameMappings() {

        HashMap<String, String> agencyNameMappings = new HashMap<>();
        agencyNameMappings.put("#Not Applicable", "");
        agencyNameMappings.put("# Unknown", "");
        agencyNameMappings.put("Akshari Solutions Inc.", "Akshari Solutions Inc.");
        agencyNameMappings.put("Ariad (Archived)", "Ariad (Archived)");
        agencyNameMappings.put("Barret and Welsh", "Barret and Welsh");
        agencyNameMappings.put("BlueRush (Archived)", "BlueRush (Archived)");
        agencyNameMappings.put("Cossette", "Cossette");
        agencyNameMappings.put("Crop Marks (Archived)", "Crop Marks (Archived)");
        agencyNameMappings.put("Diamond", "Diamond");
        agencyNameMappings.put("H&M (Archived)", "H&M (Archived)");
        agencyNameMappings.put("iD", "iD");
        agencyNameMappings.put("Jean-Denis Richard (Archived)", "Jean-Denis Richard (Archived)");
        agencyNameMappings.put("KOO (Cossette)", "KOO (Cossette)");
        agencyNameMappings.put("Leo Burnett", "Leo Burnett");
        agencyNameMappings.put("Mirum (Archived)", "Mirum (Archived)");
        agencyNameMappings.put("Response Innovations", "Response Innovations");
        agencyNameMappings.put("St Joseph", "St Joseph");
        agencyNameMappings.put("TD Internal Agency", "TD Internal Agency");
        agencyNameMappings.put("TEST Agency", "");
        agencyNameMappings.put("Twist Image", "Twist Image");
        agencyNameMappings.put("", "<use text box value>");

        return agencyNameMappings;

    }

    public static HashMap<String, String> getLanguageMappings() {

        HashMap<String, String> languageMappings = new HashMap<>();
        languageMappings.put("#Not Applicable", "");
        languageMappings.put("#Unknown", "");
        languageMappings.put("Bilingual", "English");
        languageMappings.put("Cantonese", "Cantonese");
        languageMappings.put("English", "English");
        languageMappings.put("English & French (different versions", "English");
        languageMappings.put("French", "French");
        languageMappings.put("Korean", "Korean");
        languageMappings.put("Mandarin", "Mandarin");
        languageMappings.put("Other", "");
        languageMappings.put("Simplified Chinese", "Simplified Chinese");
        languageMappings.put("Traditional Chinese", "Traditional Chinese");
        languageMappings.put("South Asian", "");

        return languageMappings;

    }

    public static HashMap<String, String> getChannelMappings() {

        HashMap<String, String> channelMappings = new HashMap<>();
        channelMappings.put("# Not Applicable", "Branch");
        channelMappings.put("# Unknown", "Advisor");
        channelMappings.put("Digital", "");
        channelMappings.put("Direct Marketing", "");
        channelMappings.put("Event/ Seminars/F2F", "Event");
        channelMappings.put("Offline/Print", "Print");
        channelMappings.put("Other", "");

        return channelMappings;

    }

    public static HashMap<String, String> getAssetTypeMappings() {

        HashMap<String, String> assetTypeMappings = new HashMap<>();
        assetTypeMappings.put("# Not Applicable", "");
        assetTypeMappings.put("# Unknown", "");
        assetTypeMappings.put("A-Frame", "");
        assetTypeMappings.put("Access Cheque", "");
        assetTypeMappings.put("Account agreement", "Account agreement");
        assetTypeMappings.put("Ad", "Advertisement");
        assetTypeMappings.put("Application", "Application");
        assetTypeMappings.put("ATM DME", "");
        assetTypeMappings.put("Backdrop", "Backdrop");
        assetTypeMappings.put("Bar (Precious Metals)", "");
        assetTypeMappings.put("Billboard (Digital)", "");
        assetTypeMappings.put("Billboard (Physical)", "");
        assetTypeMappings.put("Bio Sheet", "Bio Sheet");
        assetTypeMappings.put("Boilerplate", "Template");
        assetTypeMappings.put("Booth", "");
        assetTypeMappings.put("Brochure", "Brochure");
        assetTypeMappings.put("Button", "Button");
        assetTypeMappings.put("Card Carrier", "Card Carrier");
        assetTypeMappings.put("Card Design", "Card");
        assetTypeMappings.put("Cling", "Cling");
        assetTypeMappings.put("Content", "");
        assetTypeMappings.put("Contest", "Contest");
        assetTypeMappings.put("Counters", "Blueprint");
        assetTypeMappings.put("Credit Card", "Credit Card");
        assetTypeMappings.put("Decal", "Cling");
        assetTypeMappings.put("Design", "");
        assetTypeMappings.put("Digital Screen", "Digital Screen");
        assetTypeMappings.put("Email", "Email");
        assetTypeMappings.put("Email (Banner/Signature)", "Email");
        assetTypeMappings.put("Email (Evite)", "Evite");
        assetTypeMappings.put("Envelope", "Envelope");
        assetTypeMappings.put("Festival Collateral", "");

        return assetTypeMappings;

    }

    public static HashMap<String, String> getUsageRightsMappings() {

        HashMap<String, String> usageRightsMappings = new HashMap<>();

        return usageRightsMappings;

    }

    public static HashMap<String, String> getPhotoSourceMappings() {

        HashMap<String, String> photoSourceMappings = new HashMap<>();

        return photoSourceMappings;

    }

    public static HashMap<String, String> getLOBMappings() {

        HashMap<String, String> lobMappings = new HashMap<>();
        lobMappings.put("Haryley-Davidson", "HARLEY-DAVIDSON FINANCIAL");

        return lobMappings;

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
//            String csvMetadataValue = fromCSV.get(taxonomy2FieldName);
//            String aemMetadataValue = fromAEM.get(aemMetadataKey).getAsString();
        }
        




        return differences;

    }
}
