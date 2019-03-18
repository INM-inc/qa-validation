package org.deloitte.td.helpers;

import com.google.gson.JsonElement;
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

            String assetKeyCSV = assetFromCSV.getContainer() + "/" + assetFromCSV.getFileName();

            for (Map.Entry<String, JsonObject> assetFromAEM : fromAEM.entrySet()) {

                String assetFromAEMPath = assetFromAEM.getKey();
                JsonObject assetFromAEMMetadata = assetFromAEM.getValue();
                ArrayList<String> metadataDifferences = new ArrayList<>();

                if (assetFromAEMMetadata.get("outcome").toString().equals("fail")) {

                    metadataDifferences.add("Failed to import metadata from AEM!");
                    pathsAndDifferences.put(assetFromAEMPath, metadataDifferences.toString());

                } else {

                    if (assetFromAEMPath.equals(assetKeyCSV)) {

                        System.out.println(assetFromAEMMetadata);

                        JsonElement aemAPN = assetFromAEMMetadata.get("td:apn");
                        if (aemAPN == null) {
                            metadataDifferences.add("AP (Activity Proposal) Number Missing");
                        } else {
                            String csvAPN = assetFromCSV.getActivityProposalNumber();
                            if (!aemAPN.toString().equals(csvAPN)) {
                                metadataDifferences.add("AP (Activity Proposal) Number");
                            }
                        }

                        JsonElement aemProjectName = assetFromAEMMetadata.get("td:projectname");
                        if (aemProjectName == null) {
                            metadataDifferences.add("Project Name Missing");
                        } else {
                            String csvProjectName = assetFromCSV.getProjectName();
                            if (!aemProjectName.toString().equals(csvProjectName)) {
                                metadataDifferences.add("Project Name");
                            }
                        }

                        JsonElement aemAssetType = assetFromAEMMetadata.get("td:assettype");
                        if (aemAssetType == null) {
                            metadataDifferences.add("Asset Type Missing");
                        } else {
                            String csvAssetType = assetTypeMappings.get(assetFromCSV.getAssetType());
                            if (!aemAssetType.toString().equals(csvAssetType)) {
                                metadataDifferences.add("Asset Type");
                            }
                        }

                        JsonElement aemKeywords = assetFromAEMMetadata.get("td:keywords");
                        if (aemKeywords == null) {
                            metadataDifferences.add("Keywords Missing");
                        } else {
                            String csvKeywords = assetFromCSV.getKeywords().toString();
                            if (!aemKeywords.toString().equals(csvKeywords)) {
                                metadataDifferences.add("Keywords");
                            }
                        }

                        JsonElement aemInMarket = assetFromAEMMetadata.get("td:inmarket");
                        if (aemInMarket == null) {
                            metadataDifferences.add("In Market Missing");
                        } else {
                            String csvInMarket = assetFromCSV.getInMarketDate();
                            if (!aemInMarket.toString().equals(csvInMarket)) {
                                metadataDifferences.add("In Market");
                            }
                        }

                        JsonElement aemExpiryDate = assetFromAEMMetadata.get("td:expiry");
                        if (aemExpiryDate == null) {
                            metadataDifferences.add("Expiry Date Missing");
                        } else {
                            String csvExpiryDate = assetFromCSV.getExpiryDate();
                            if (!aemExpiryDate.toString().equals(csvExpiryDate)) {
                                metadataDifferences.add("Expiry Date");
                            }
                        }

                        JsonElement aemChannels = assetFromAEMMetadata.get("td:channel");
                        if (aemChannels == null) {
                            metadataDifferences.add("Channel Missing");
                        } else {
                            ArrayList<String> csvChannels = assetFromCSV.getChannels();
                            ArrayList<String> mappedCSVChannels = new ArrayList<>();
                            for (String channel : csvChannels) {
                                mappedCSVChannels.add(channelMappings.get(channel));
                            }
                            if (!aemChannels.toString().equals(mappedCSVChannels.toString())) {
                                metadataDifferences.add("Channel");
                            }
                        }

                        JsonElement aemBranchID = assetFromAEMMetadata.get("td:branchid");
                        if (aemBranchID == null) {
                            metadataDifferences.add("Branch ID Missing");
                        } else {
                            String csvBranchID = assetFromCSV.getBranchID();
                            if (!aemBranchID.toString().equals(csvBranchID)) {
                                metadataDifferences.add("Branch ID");
                            }
                        }

                        JsonElement aemAgencyName = assetFromAEMMetadata.get("td:agency");
                        if (aemAgencyName == null) {
                            metadataDifferences.add("Agency Name Missing");
                        } else {
                            String csvAgencyName;
                            if (assetFromCSV.getAgencyNameOther().isEmpty()) {
                                csvAgencyName = agencyNameMappings.get(assetFromCSV.getAgencyName());
                            } else {
                                csvAgencyName = assetFromCSV.getAgencyNameOther();
                            }
                            if (!aemAgencyName.toString().equals(csvAgencyName)) {
                                metadataDifferences.add("Agency Name");
                            }
                        }

                        JsonElement aemAgencyPID = assetFromAEMMetadata.get("td:agencypid");
                        if (aemAgencyPID == null) {
                            metadataDifferences.add("Agency Project ID Missing");
                        } else {
                            String csvAgencyPID = assetFromCSV.getAgencyProjectID();
                            if (!aemAgencyPID.toString().equals(csvAgencyPID)) {
                                metadataDifferences.add("Agency Project ID");
                            }
                        }

                        JsonElement aemDescription = assetFromAEMMetadata.get("dc:description");
                        if (aemDescription == null) {
                            metadataDifferences.add("Description Missing");
                        } else {
                            String csvDescription = assetFromCSV.getDescription();
                            if (!aemDescription.toString().equals(csvDescription)) {
                                metadataDifferences.add("Description");
                            }
                        }

                        JsonElement aemLanguage = assetFromAEMMetadata.get("td:language");
                        if (aemLanguage == null) {
                            metadataDifferences.add("Language Missing");
                        } else {
                            String csvLanguage = languageMappings.get(assetFromCSV.getLanguage());
                            if (!aemLanguage.toString().equals(csvLanguage)) {
                                metadataDifferences.add("Language");
                            }
                        }

                        JsonElement aemLOBs = assetFromAEMMetadata.get("td:lob");
                        if (aemLOBs == null) {
                            metadataDifferences.add("Lines Of Business Missing");
                        } else {
                            ArrayList<String> csvLOBs = assetFromCSV.getLOBs();
                            ArrayList<String> mappedLOBs = new ArrayList<>();
                            for (String lob : csvLOBs) {
                                mappedLOBs.add(lobMappings.get(lob));
                            }
                            if (!aemLOBs.toString().equals(mappedLOBs.toString())) {
                                metadataDifferences.add("Lines Of Business");
                            }
                        }

                        JsonElement aemPhotoSource = assetFromAEMMetadata.get("td:photosource");
                        if (aemPhotoSource == null) {
                            metadataDifferences.add("Photo Source Missing");
                        } else {
                            String csvPhotoSource = assetFromCSV.getPhotoSource();
                            if (!aemPhotoSource.toString().equals(csvPhotoSource)) {
                                metadataDifferences.add("Photo Source");
                            }
                        }

                        JsonElement aemUsageRights = assetFromAEMMetadata.get("td:usageright");
                        if (aemUsageRights == null) {
                            metadataDifferences.add("Usage Rights Missing");
                        } else {
                            String csvUsageRights;
                            if (assetFromCSV.getUsageRightsOther().isEmpty()) {
                                csvUsageRights = usageRightsMappings.get(assetFromCSV.getUsageRights());
                            } else {
                                csvUsageRights = assetFromCSV.getUsageRightsOther();
                            }
                            if (!aemUsageRights.toString().equals(csvUsageRights)) {
                                metadataDifferences.add("Usage Rights");
                            }
                        }

                        JsonElement aemApprovalStatus = assetFromAEMMetadata.get("td:approval");
                        if (aemApprovalStatus == null) {
                            metadataDifferences.add("Approval Status Missing");
                        } else {
                            String csvApprovalStatus = approvalStatusMappings.get(assetFromCSV.getApprovalStatus());
                            if (!aemApprovalStatus.toString().equals(csvApprovalStatus)) {
                                metadataDifferences.add("Approval Status");
                            }
                        }

                        JsonElement aemImageWidth = assetFromAEMMetadata.get("tiff:ImageWidth");
                        if (aemImageWidth == null) {
                            metadataDifferences.add("Image Width Missing");
                        } else {
                            String csvImageWidth = assetFromCSV.getImageWidth();
                            if (!aemImageWidth.toString().equals(csvImageWidth)) {
                                metadataDifferences.add("Image Width");
                            }
                        }

                        JsonElement aemImageHeight = assetFromAEMMetadata.get("tiff:ImageLength");
                        if (aemImageHeight == null) {
                            metadataDifferences.add("Image Height Missing");
                        } else {
                            String csvImageHeight = assetFromCSV.getImageHeight();
                            if (!aemImageHeight.toString().equals(csvImageHeight)) {
                                metadataDifferences.add("Image Height");
                            }
                        }

                        JsonElement aemResolutionHorizontal = assetFromAEMMetadata.get("tiff:XResolution");
                        if (aemResolutionHorizontal == null) {
                            metadataDifferences.add("Resolution (Horizontal) Missing");
                        } else {
                            String csvResolutionHorizontal = assetFromCSV.getResolutionHorizontal();
                            if (!aemResolutionHorizontal.toString().equals(csvResolutionHorizontal)) {
                                metadataDifferences.add("Resolution (Horizontal)");
                            }
                        }

                        JsonElement aemResolutionVertical = assetFromAEMMetadata.get("tiff:YResolution");
                        if (aemResolutionVertical == null) {
                            metadataDifferences.add("Resolution (Vertical) Missing");
                        } else {
                            String csvResolutionVertical = assetFromCSV.getResolutionVertical();
                            if (!aemResolutionVertical.toString().equals(csvResolutionVertical)) {
                                metadataDifferences.add("Resolution (Vertical)");
                            }
                        }

                        JsonElement aemPhotographerOrCreator = assetFromAEMMetadata.get("dc:creator");
                        if (aemPhotographerOrCreator == null) {
                            metadataDifferences.add("Photographer or Creator Missing");
                        } else {
                            String csvPhotographerOrCreator = assetFromCSV.getPhotographer();
                            if (!aemPhotographerOrCreator.toString().equals(csvPhotographerOrCreator)) {
                                metadataDifferences.add("Photographer or Creator");
                            }
                        }

                        JsonElement aemDateFileCaptured = assetFromAEMMetadata.get("td:datefilecaptured");
                        if (aemDateFileCaptured == null) {
                            metadataDifferences.add("Date File Captured Missing");
                        } else {
                            String csvDateFileCaptured = assetFromCSV.getDateFileCaptured();
                            if (!aemDateFileCaptured.toString().equals(csvDateFileCaptured)) {
                                metadataDifferences.add("Date File Captured");
                            }
                        }

                        JsonElement aemFileFormat = assetFromAEMMetadata.get("dam:FileFormat");
                        if (aemFileFormat == null) {
                            metadataDifferences.add("File Format Missing");
                        } else {
                            String csvFileFormat = assetFromCSV.getFileFormat();
                            if (!aemFileFormat.toString().equals(csvFileFormat)) {
                                metadataDifferences.add("File Format");
                            }
                        }

                        JsonElement aemFileSize = assetFromAEMMetadata.get("dam:size");
                        if (aemFileSize == null) {
                            metadataDifferences.add("File Size Missing");
                        } else {
                            String csvFileSize = assetFromCSV.getFileSize();
                            if (!aemFileSize.toString().equals(csvFileSize)) {
                                metadataDifferences.add("File Size");
                            }
                        }

                        JsonElement aemDateRecordLastModified = assetFromAEMMetadata.get("dc:modified");
                        if (aemDateRecordLastModified == null) {
                            metadataDifferences.add("Date Record Last Modified Missing");
                        } else {
                            String csvDateRecordLastModified = assetFromCSV.getDateRecordLastModified();
                            if (!aemDateRecordLastModified.toString().equals(csvDateRecordLastModified)) {
                                metadataDifferences.add("Date Record Last Modified");
                            }
                        }

                        JsonElement aemDateFileCataloged = assetFromAEMMetadata.get("td:catalogued");
                        if (aemDateFileCataloged == null) {
                            metadataDifferences.add("Date File Cataloged Missing");
                        } else {
                            String csvDateFileCataloged = assetFromCSV.getDateFileCataloged();
                            if (!aemDateFileCataloged.toString().equals(csvDateFileCataloged)) {
                                metadataDifferences.add("Date File Cataloged");
                            }
                        }

                        JsonElement aemCatalogedBy = assetFromAEMMetadata.get("td:cataloguedBy");
                        if (aemCatalogedBy == null) {
                            metadataDifferences.add("Cataloged By Missing");
                        } else {
                            String csvCatalogedBy = assetFromCSV.getCatalogedBy();
                            if (!aemCatalogedBy.toString().equals(csvCatalogedBy)) {
                                metadataDifferences.add("Cataloged By");
                            }
                        }

                        if (metadataDifferences.size() > 0) {
                            pathsAndDifferences.put(assetFromAEMPath, metadataDifferences.toString());
                        }

                    }

                }

            }
        }




        return pathsAndDifferences;

    }
}
