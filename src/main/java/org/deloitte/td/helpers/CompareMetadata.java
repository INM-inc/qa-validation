package org.deloitte.td.helpers;

import com.google.gson.JsonObject;
import org.deloitte.td.model.Asset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CompareMetadata {

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

    public static HashMap<String, String> getLOBMappings() {

        HashMap<String, String> lobMappings = new HashMap<>();
        lobMappings.put("Haryley-Davidson", "HARLEY-DAVIDSON FINANCIAL");

        return lobMappings;

    }

    public static HashMap<String, String> checkForDifferences(ArrayList<Asset> fromCSV, HashMap<String, JsonObject> fromAEM) {

        HashMap<String, String> pathsAndDifferences = new HashMap<>();
        HashMap<String, String> approvalStatusMappings = getApprovalStatusMappings();
        HashMap<String, String> agencyNameMappings = getAgencyNameMappings();
        HashMap<String, String> languageMappings = getLanguageMappings();
        HashMap<String, String> channelMappings = getChannelMappings();
        HashMap<String, String> assetTypeMappings = getAssetTypeMappings();
        HashMap<String, String> usageRightsMappings = getUsageRightsMappings();
        HashMap<String, String> lobMappings = getLOBMappings();

        for (Asset assetFromCSV : fromCSV) {

            String assetKeyCSV = assetFromCSV.getContainer() + assetFromCSV.getFileName();

            for (Map.Entry<String, JsonObject> assetFromAEM : fromAEM.entrySet()) {

                String assetFromAEMPath = assetFromAEM.getKey();
                JsonObject assetFromAEMMetadata = assetFromAEM.getValue();

                if (assetFromAEMMetadata.get(rootPath).toString().equals(assetKeyCSV)) {

                    ArrayList<String> metadataDifferences = new ArrayList<>();

                    String aemAPN = assetFromAEMMetadata.get("td:apn").toString();
                    String csvAPN = assetFromCSV.getActivityProposalNumber();
                    if (!aemAPN.equals(csvAPN)) {
                        metadataDifferences.add("AP (Activity Proposal) Number");
                    }

                    String aemProjectName = assetFromAEMMetadata.get("td:projectname").toString();
                    String csvProjectName = assetFromCSV.getProjectName();
                    if (!aemProjectName.equals(csvProjectName)) {
                        metadataDifferences.add("Project Name");
                    }

                    String aemAssetType = assetFromAEMMetadata.get("td:assettype").toString();
                    String csvAssetType = assetTypeMappings.get(assetFromCSV.getAssetType());
                    if (!aemAssetType.equals(csvAssetType)) {
                        metadataDifferences.add("Asset Type");
                    }

                    String aemKeywords = assetFromAEMMetadata.get("td:keywords").toString();
                    String csvKeywords = assetFromCSV.getKeywords().toString();
                    if (!aemKeywords.equals(csvKeywords)) {
                        metadataDifferences.add("Keywords");
                    }

                    String aemInMarket = assetFromAEMMetadata.get("td:inmarket@date").toString();
                    String csvInMarket = assetFromCSV.getInMarketDate();
                    if (!aemInMarket.equals(csvInMarket)) {
                        metadataDifferences.add("In Market");
                    }

                    String aemExpiryDate = assetFromAEMMetadata.get("td:expiry@date").toString();
                    String csvExpiryDate = assetFromCSV.getExpiryDate();
                    if (!aemExpiryDate.equals(csvExpiryDate)) {
                        metadataDifferences.add("Expiry Date");
                    }

                    String aemChannels = assetFromAEMMetadata.get("td:channel").toString();
                    ArrayList<String> csvChannels = assetFromCSV.getChannels();
                    ArrayList<String> mappedCSVChannels = new ArrayList<>();
                    for (String channel : csvChannels) {
                        mappedCSVChannels.add(channelMappings.get(channel));
                    }
                    if (!aemChannels.equals(mappedCSVChannels.toString())) {
                        metadataDifferences.add("Channel");
                    }

                    String aemBranchID = assetFromAEMMetadata.get("td:branchid").toString();
                    String csvBranchID = assetFromCSV.getBranchID();
                    if (!aemBranchID.equals(csvBranchID)) {
                        metadataDifferences.add("Branch ID");
                    }

                    String aemAgencyName = assetFromAEMMetadata.get("td:agency").toString();
                    String csvAgencyName;
                    if (assetFromCSV.getAgencyNameOther().isEmpty()) {
                        csvAgencyName = agencyNameMappings.get(assetFromCSV.getAgencyName());
                    } else {
                        csvAgencyName = assetFromCSV.getAgencyNameOther();
                    }
                    if (!aemAgencyName.equals(csvAgencyName)) {
                        metadataDifferences.add("Agency Name");
                    }

                    String aemAgencyPID = assetFromAEMMetadata.get("td:agencypid").toString();
                    String csvAgencyPID = assetFromCSV.getAgencyProjectID();
                    if (!aemAgencyPID.equals(csvAgencyPID)) {
                        metadataDifferences.add("Agency Project ID");
                    }

                    String aemDescription = assetFromAEMMetadata.get("dc:description").toString();
                    String csvDescription = assetFromCSV.getDescription();
                    if (!aemDescription.equals(csvDescription)) {
                        metadataDifferences.add("Description");
                    }

                    String aemLanguage = assetFromAEMMetadata.get("td:language").toString();
                    String csvLanguage = languageMappings.get(assetFromCSV.getLanguage());
                    if (!aemLanguage.equals(csvLanguage)) {
                        metadataDifferences.add("Language");
                    }

                    String aemLOBs = assetFromAEMMetadata.get("td:lob").toString();
                    ArrayList<String> csvLOBs = assetFromCSV.getLOBs();
                    ArrayList<String> mappedLOBs = new ArrayList<>();
                    for (String lob : csvLOBs) {
                        mappedLOBs.add(lobMappings.get(lob));
                    }
                    if (!aemLOBs.equals(mappedLOBs.toString())) {
                        metadataDifferences.add("Lines Of Business");
                    }

                    String aemPhotoSource = assetFromAEMMetadata.get("td:photosource").toString();
                    String csvPhotoSource = assetFromCSV.getPhotoSource();
                    if (!aemPhotoSource.equals(csvPhotoSource)) {
                        metadataDifferences.add("Photo Source");
                    }

                    String aemUsageRights = assetFromAEMMetadata.get("td:usageright").toString();
                    String csvUsageRights;
                    if (assetFromCSV.getUsageRightsOther().isEmpty()) {
                        csvUsageRights = usageRightsMappings.get(assetFromCSV.getUsageRights());
                    } else {
                        csvUsageRights = assetFromCSV.getUsageRightsOther();
                    }
                    if (!aemUsageRights.equals(csvUsageRights)) {
                        metadataDifferences.add("Agency Name");
                    }

                    String aemApprovalStatus = assetFromAEMMetadata.get("td:approval").toString();
                    String csvApprovalStatus = approvalStatusMappings.get(assetFromCSV.getApprovalStatus());
                    if (!aemApprovalStatus.equals(csvApprovalStatus)) {
                        metadataDifferences.add("Approval Status");
                    }

                    String aemImageWidth = assetFromAEMMetadata.get("tiff:ImageWidth").toString();
                    String csvImageWidth = assetFromCSV.getImageWidth();
                    if (!aemImageWidth.equals(csvImageWidth)) {
                        metadataDifferences.add("Image Width");
                    }

                    String aemImageHeight = assetFromAEMMetadata.get("tiff:ImageLength").toString();
                    String csvImageHeight = assetFromCSV.getImageHeight();
                    if (!aemImageHeight.equals(csvImageHeight)) {
                        metadataDifferences.add("Image Height");
                    }

                    String aemResolutionHorizontal = assetFromAEMMetadata.get("tiff:XResolution").toString();
                    String csvResolutionHorizontal = assetFromCSV.getResolutionHorizontal();
                    if (!aemResolutionHorizontal.equals(csvResolutionHorizontal)) {
                        metadataDifferences.add("Resolution (Horizontal)");
                    }

                    String aemResolutionVertical = assetFromAEMMetadata.get("tiff:YResolution").toString();
                    String csvResolutionVertical = assetFromCSV.getResolutionVertical();
                    if (!aemResolutionVertical.equals(csvResolutionVertical)) {
                        metadataDifferences.add("Resolution (Vertical)");
                    }

                    String aemPhotographerOrCreator = assetFromAEMMetadata.get("dc:creator").toString();
                    String csvPhotographerOrCreator = assetFromCSV.getPhotographer();
                    if (!aemPhotographerOrCreator.equals(csvPhotographerOrCreator)) {
                        metadataDifferences.add("Photographer or Creator");
                    }

                    String aemDateFileCaptured = assetFromAEMMetadata.get("td:datefilecaptured").toString();
                    String csvDateFileCaptured = assetFromCSV.getDateFileCaptured();
                    if (!aemDateFileCaptured.equals(csvDateFileCaptured)) {
                        metadataDifferences.add("Date File Captured");
                    }

                    String aemFileFormat = assetFromAEMMetadata.get("dam:FileFormat").toString();
                    String csvFileFormat = assetFromCSV.getFileFormat();
                    if (!aemFileFormat.equals(csvFileFormat)) {
                        metadataDifferences.add("File Format");
                    }

                    String aemFileSize = assetFromAEMMetadata.get("dam:size").toString();
                    String csvFileSize = assetFromCSV.getFileSize();
                    if (!aemFileSize.equals(csvFileSize)) {
                        metadataDifferences.add("File Size");
                    }

                    String aemDateRecordLastModified = assetFromAEMMetadata.get("dc:modified@date").toString();
                    String csvDateRecordLastModified = assetFromCSV.getDateRecordLastModified();
                    if (!aemDateRecordLastModified.equals(csvDateRecordLastModified)) {
                        metadataDifferences.add("Date Record Last Modified");
                    }

                    String aemDateFileCataloged = assetFromAEMMetadata.get("td:catalogued@date").toString();
                    String csvDateFileCataloged = assetFromCSV.getDateFileCataloged();
                    if (!aemDateFileCataloged.equals(csvDateFileCataloged)) {
                        metadataDifferences.add("Date File Cataloged");
                    }

                    String aemCatalogedBy = assetFromAEMMetadata.get("td:cataloguedBy").toString();
                    String csvCatalogedBy = assetFromCSV.getCatalogedBy();
                    if (!aemCatalogedBy.equals(csvCatalogedBy)) {
                        metadataDifferences.add("Cataloged By");
                    }

                    if (metadataDifferences.size() > 0) {
                        pathsAndDifferences.put(assetFromAEMPath, metadataDifferences.toString());
                    }

                }
            }
        }




        return pathsAndDifferences;

    }
}
