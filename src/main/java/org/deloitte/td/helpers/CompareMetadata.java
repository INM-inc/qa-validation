package org.deloitte.td.helpers;

import com.google.gson.JsonObject;
import org.deloitte.td.model.Asset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CompareMetadata {

    public static ArrayList<String> getAEMMappings() {

        ArrayList<String> aemMappings = new ArrayList<>();
        aemMappings.add("td:apn");
        aemMappings.add("td:projectname");
        aemMappings.add("td:assettype");
        aemMappings.add("td:keywords");
        aemMappings.add("td:inmarket@date");
        aemMappings.add("td:expiry@date");
        aemMappings.add("td:channel");
        aemMappings.add("td:branchid");
        aemMappings.add("td:agency");
        aemMappings.add("td:agencypid");
        aemMappings.add("dc:description");
        aemMappings.add("td:language");
        aemMappings.add("td:lob");
        aemMappings.add("td:photosource");
        aemMappings.add("td:usageright");
        aemMappings.add("td:approval");
        aemMappings.add("tiff:ImageWidth");
        aemMappings.add("tiff:ImageLength");
        aemMappings.add("tiff:XResolution");
        aemMappings.add("tiff:YResolution");
        aemMappings.add("dc:creator");
        aemMappings.add("td:datefilecaptured");
        aemMappings.add("dam:FileFormat");
        aemMappings.add("dam:size");
        aemMappings.add("dc:modified@date");
        aemMappings.add("td:catalogued@date");
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
        assetTypeMappings.put("Flag", "Promo Flags");
        assetTypeMappings.put("Flyer", "Flyer");
        assetTypeMappings.put("Form", "Form");
        assetTypeMappings.put("Guidelines", "Guidelines");
        assetTypeMappings.put("Header", "");
        assetTypeMappings.put("Icon", "Icon");
        assetTypeMappings.put("Indicia", "Indicia");
        assetTypeMappings.put("Info Sheet", "Info Sheet");
        assetTypeMappings.put("Insert", "Insert");
        assetTypeMappings.put("Insert/Buckslip", "Insert");
        assetTypeMappings.put("Interceptor", "Interceptor");
        assetTypeMappings.put("Invitation", "Invitation");
        assetTypeMappings.put("Invoice", "Dependencies");
        assetTypeMappings.put("Kiosk", "");
        assetTypeMappings.put("Lanyards", "Merchandise");
        assetTypeMappings.put("Letter", "Letter");
        assetTypeMappings.put("Logo", "Logo");
        assetTypeMappings.put("Market Commentary", "Market Commentary");
        assetTypeMappings.put("Masthead", "Banner");
        assetTypeMappings.put("Meeting Agenda", "Info Sheet");
        assetTypeMappings.put("Merchandise", "Merchandise");
        assetTypeMappings.put("Mobile", "");
        assetTypeMappings.put("Newsletter", "Newsletter");
        assetTypeMappings.put("Newspaper", "Advertisement");
        assetTypeMappings.put("Notepad", "Template");
        assetTypeMappings.put("Other", "");
        assetTypeMappings.put("Photography", "Photography");
        assetTypeMappings.put("Pocket Folder", "Pocket Folder");
        assetTypeMappings.put("Portfolio Update", "Letter");
        assetTypeMappings.put("POS", "");
        assetTypeMappings.put("Postcard", "Postcard");
        assetTypeMappings.put("Poster", "Poster");
        assetTypeMappings.put("Premiums", "");
        assetTypeMappings.put("Presentation (Power Point)", "Presentation");
        assetTypeMappings.put("Print Banner", "Banner");
        assetTypeMappings.put("Print Campaign", "");
        assetTypeMappings.put("Privacy Notice", "");
        assetTypeMappings.put("Prize", "");
        assetTypeMappings.put("Program", "Info Sheet");
        assetTypeMappings.put("Proposal", "Template");
        assetTypeMappings.put("Pull-Up Banner", "Banner");
        assetTypeMappings.put("Regulatory", "");
        assetTypeMappings.put("Rights Documentation", "");
        assetTypeMappings.put("Round (Precious Metals)", "Precious Metals");
        assetTypeMappings.put("Sales Aid", "");
        assetTypeMappings.put("Self-Mailer", "Envelope");
        assetTypeMappings.put("Sign", "Signage");
        assetTypeMappings.put("Signature", "Signature");
        assetTypeMappings.put("Skirt", "Cling");
        assetTypeMappings.put("Social Media", "");
        assetTypeMappings.put("Sticker", "Cling");
        assetTypeMappings.put("Take away", "Brochure");
        assetTypeMappings.put("Take One", "Brochure");
        assetTypeMappings.put("Template", "Template");
        assetTypeMappings.put("Tent", "Merchandise");
        assetTypeMappings.put("Tent Card", "Brochure");
        assetTypeMappings.put("Thank-You Card", "Invitation");
        assetTypeMappings.put("Tools", "");
        assetTypeMappings.put("Training", "Info Sheet");
        assetTypeMappings.put("Video", "Video");
        assetTypeMappings.put("Wallet Card", "Infor");
        assetTypeMappings.put("Web Banner", "Banner");
        assetTypeMappings.put("Web page", "Wireframes");
        assetTypeMappings.put("Wicket Sign", "");
        assetTypeMappings.put("Wireframe", "Wireframe");
        assetTypeMappings.put("Wordmarks", "Wordmarks");
        assetTypeMappings.put("Wrap", "Cling");

        return assetTypeMappings;

    }

    public static HashMap<String, String> getUsageRightsMappings() {

        HashMap<String, String> usageRightsMappings = new HashMap<>();
        usageRightsMappings.put("Shutterstock: All Digital [No print]", "Digital");
        usageRightsMappings.put("Shutterstock: All Media [All Uses]", "Digital , Print");
        usageRightsMappings.put("iStock [Standard] Store inside project zip - DO NOT USE in filename", "");
        usageRightsMappings.put("iStock [Extended] Describe license purchased", "");
        usageRightsMappings.put("Client Provided: WIth rights to use again [Provide usage rights information; expiry, how it can be used etc.]", "");
        usageRightsMappings.put("Created Internally [Indicate restrictions]", "");
        usageRightsMappings.put("Other [Please specify the rights associated with this file + link rights document in the description of this asset]", "");
        usageRightsMappings.put("# Unknown", "");
        usageRightsMappings.put("Editorial [Describe restrictions]", "");
        usageRightsMappings.put("Royalty Free", "Royalty Free");
        usageRightsMappings.put("TD Owned Photos", "Unlimited");
        usageRightsMappings.put("TD Owned Image", "Unlimited");

        return usageRightsMappings;

    }

    public static HashMap<String, String> getPhotoSourceMappings() {

        HashMap<String, String> photoSourceMappings = new HashMap<>();
        photoSourceMappings.put("Shutterstock", "Shutterstock");
        photoSourceMappings.put("Shutterstock (Offset)", "Shutterstock");
        photoSourceMappings.put("iStock", "iStock");
        photoSourceMappings.put("Getty Images", "Getty Images");
        photoSourceMappings.put("Pond5", "Pond5");
        photoSourceMappings.put("Other", "Pond5");

        return photoSourceMappings;

    }

    public static HashMap<String, String> getLOBMappings() {

        HashMap<String, String> lobMappings = new HashMap<>();
        lobMappings.put("Haryley-Davidson", "HARLEY-DAVIDSON FINANCIAL");

        return lobMappings;

    }

    public static HashMap<String, String> checkForDifferences(ArrayList<Asset> fromCSV, HashMap<String, JsonObject> fromAEM) {

        HashMap<String, String> differences = new HashMap<>();
        ArrayList<String> aemMappings = getAEMMappings();
        HashMap<String, String> approvalStatusMappings = getApprovalStatusMappings();
        HashMap<String, String> agencyNameMappings = getAgencyNameMappings();
        HashMap<String, String> languageMappings = getLanguageMappings();
        HashMap<String, String> channelMappings = getChannelMappings();
        HashMap<String, String> assetTypeMappings = getAssetTypeMappings();
        HashMap<String, String> usageRightsMappings = getUsageRightsMappings();
        HashMap<String, String> photoSourceMappings = getPhotoSourceMappings();
        HashMap<String, String> lobMappings = getLOBMappings();

        for (String aemMapping : aemMappings) {
            String taxonomy2Field = aemMapping;
            for (Asset asset : fromCSV) {
                for (Map.Entry<String, JsonObject> aemAssetMetadata : fromAEM.entrySet()) {
                    if (aemAssetMetadata.getValue().get("dam:sha1").equals(asset.getSha())) {

                    }
                }
            }
        }




        return differences;

    }
}
