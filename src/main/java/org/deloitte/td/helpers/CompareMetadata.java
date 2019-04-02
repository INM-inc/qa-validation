package org.deloitte.td.helpers;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.deloitte.td.model.Asset;

import java.text.SimpleDateFormat;
import java.util.*;

public class CompareMetadata {

    private static Map<String, String> approvalStatusMappings;
    private static Map<String, String> agencyNameMappings;
    private static Map<String, String> languageMappings;
    private static Map<String, String> channelMappings;
    private static Map<String, String> assetTypeMappings;
    private static Map<String, String> usageRightsMappings;
    private static Map<String, String> lobMappings;
    private static Map<String, String> photoSourceMappings;

    static {
        approvalStatusMappings = new HashMap<>();
        approvalStatusMappings.put("#Not Applicable", "Draft");
        approvalStatusMappings.put("#Unknown", "Draft");
        approvalStatusMappings.put("Approved", "Approved");
        approvalStatusMappings.put("On Hold", "Draft");
        approvalStatusMappings.put("Pending", "Draft");
        approvalStatusMappings.put("Rejected", "Draft");

        agencyNameMappings = new HashMap<>();
        agencyNameMappings.put("# Not Applicable", "");
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

        languageMappings = new HashMap<>();
        languageMappings.put("# Not Applicable", "");
        languageMappings.put("# Unknown", "");
        languageMappings.put("Bilingual", "English");
        languageMappings.put("Cantonese", "Cantonese");
        languageMappings.put("English", "English");
        languageMappings.put("English and French (different versions)", "English");
        languageMappings.put("French", "French");
        languageMappings.put("Korean", "Korean");
        languageMappings.put("Mandarin", "Mandarin");
        languageMappings.put("Other", "");
        languageMappings.put("Simplified Chinese", "Simplified Chinese");
        languageMappings.put("Traditional Chinese", "Traditional Chinese");
        languageMappings.put("South Asian", "");

        channelMappings = new HashMap<>();
        channelMappings.put("# Not Applicable", "Advisor");
        channelMappings.put("# Unknown", "Branch");
        channelMappings.put("Digital", "");
        channelMappings.put("Direct Marketing", "");
        channelMappings.put("Event / Seminars / F2F", "Event");
        channelMappings.put("Offline / Print", "Print");
        channelMappings.put("Other", "");

        assetTypeMappings = new HashMap<>();
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
        assetTypeMappings.put("Card Design", "Card Carrier");
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
        assetTypeMappings.put("Wallet Card", "Info Sheet");
        assetTypeMappings.put("Web Banner", "Banner");
        assetTypeMappings.put("Web page", "Wireframe");
        assetTypeMappings.put("Wicket Sign", "");
        assetTypeMappings.put("Wireframe", "Wireframe");
        assetTypeMappings.put("Wordmarks", "Wordmarks");
        assetTypeMappings.put("Wrap", "Cling");

        usageRightsMappings = new HashMap<>();
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

        lobMappings = new HashMap<>();
        lobMappings.put("Haryley-Davidson", "HARLEY-DAVIDSON FINANCIAL");

        photoSourceMappings = new HashMap<>();
        photoSourceMappings.put("Shutterstock", "Shutterstock");
        photoSourceMappings.put("Shutterstock (Offset)", "Shutterstock");
        photoSourceMappings.put("iStock", "iStock");
        photoSourceMappings.put("Getty Images", "Getty Images");
        photoSourceMappings.put("Pond5", "Pond5");
        photoSourceMappings.put("Other", "");
    }

    private ComparisonResult compareResolution(String fieldName, String csvValue, JsonObject assetJson, ComparisonResult comparisonResult) {
        JsonElement aemValue = assetJson.get(fieldName);
        if (aemValue == null) {
            if (csvValue != null && !csvValue.isEmpty()) {
                comparisonResult.getDifferences().put(fieldName, comparisonResult.new Difference(csvValue, ""));
            }
        } else if (csvValue == null) {
            if (aemValue != null && !aemValue.getAsString().isEmpty()) {
                comparisonResult.getDifferences().put(fieldName, comparisonResult.new Difference("", aemValue.getAsString()));
            }
        } else {
            try {
                String[] aemResolutionValues = aemValue.getAsString().split("/");
                int aemResolutionInt;
                if (aemResolutionValues.length == 1) {
                    double aemResolutiontCalculated = Double.parseDouble(aemResolutionValues[0].replaceAll("\"", ""));
                    aemResolutionInt = (int) Math.round(aemResolutiontCalculated);
                } else {
                    double aemResolutionDividend = Double.parseDouble(aemResolutionValues[0].replaceAll("\"", ""));
                    double aemResolutionDivisor = Double.parseDouble(aemResolutionValues[1].replaceAll("\"", ""));
                    aemResolutionInt = (int) Math.round(aemResolutionDividend / aemResolutionDivisor);
                }
                int csvResolutionInt = (int) Math.round(Double.parseDouble(csvValue));
                if (aemResolutionInt != csvResolutionInt) {
                    comparisonResult.getDifferences().put(fieldName, comparisonResult.new Difference(csvValue, aemValue.getAsString()));
                }
            } catch (Exception e) {
                comparisonResult.getDifferences().put(fieldName, comparisonResult.new Difference(csvValue, aemValue.getAsString()));
            }
        }

        return comparisonResult;
    }

    private ComparisonResult compareStringWithOtherAndMappingValue(String fieldName, String csvValue, String csvOtherValue, JsonObject assetJson, ComparisonResult comparisonResult, Map<String, String> mapping) {
        JsonElement aemValue = assetJson.get(fieldName);
        if (aemValue == null) {
            if (csvValue != null && !csvValue.isEmpty()) {
                if (csvValue.contains("Other")) {
                    if (csvOtherValue != null && !csvOtherValue.isEmpty()) {
                        comparisonResult.getDifferences().put(fieldName, comparisonResult.new Difference(csvOtherValue, ""));
                    }
                } else if (mapping.containsKey(csvValue) && !mapping.get(csvValue).isEmpty()) {
                    comparisonResult.getDifferences().put(fieldName, comparisonResult.new Difference(mapping.get(csvValue), ""));
                }
            }
        } else if (csvValue == null) {
            if (aemValue != null && !aemValue.getAsString().isEmpty()) {
                comparisonResult.getDifferences().put(fieldName, comparisonResult.new Difference("", aemValue.getAsString()));
            }
        } else {
            String cantoValue = null;
            if (csvValue != null && !csvValue.isEmpty()) {
                if (!csvValue.contains("Other")) {
                    cantoValue = mapping.get(csvValue);
                } else {
                    if (csvOtherValue != null && !csvOtherValue.isEmpty()) {
                        cantoValue = csvOtherValue;
                    }
                }
            }

            if (cantoValue != null) {
                if (!aemValue.getAsString().equals(cantoValue)) {
                    comparisonResult.getDifferences().put(fieldName, comparisonResult.new Difference(cantoValue, aemValue.getAsString()));
                }
            }
        }

        return comparisonResult;
    }

    private ComparisonResult compareStringWithMappingValue(String fieldName, String csvValue, JsonObject assetJson, ComparisonResult comparisonResult, Map<String, String> mapping, boolean ignoreCase) {
        if (assetJson.has(fieldName)) {
            if (assetJson.get(fieldName).isJsonArray()) {
                JsonArray aemArrayValues = assetJson.getAsJsonArray(fieldName);
                List<String> aemValues = new ArrayList<>();
                for (JsonElement element : aemArrayValues) {
                    aemValues.add(element.getAsString());
                }

                if (csvValue == null) {
                    if (!aemValues.isEmpty()) {
                        comparisonResult.getDifferences().put(fieldName, comparisonResult.new Difference("", String.join(",", aemValues)));
                    }
                } else {
                    try {
                        if (!ignoreCase) {
                            if (!aemValues.contains(mapping.get(csvValue))) {
                                comparisonResult.getDifferences().put(fieldName, comparisonResult.new Difference(mapping.get(csvValue), String.join(",", aemValues)));
                            }
                        } else {
                            boolean found = false;
                            for (String aemValue : aemValues) {
                                if (aemValue.equalsIgnoreCase(mapping.get(csvValue))) {
                                    found = true;
                                }
                            }
                            if (!found) {
                                comparisonResult.getDifferences().put(fieldName, comparisonResult.new Difference(mapping.get(csvValue), String.join(",", aemValues)));
                            }
                        }
                    } catch (Exception e) {
                        comparisonResult.getDifferences().put(fieldName, comparisonResult.new Difference(mapping.get(csvValue), String.join(",", aemValues)));
                    }
                }
            } else {
                JsonElement aemValue = assetJson.get(fieldName);
                if (csvValue == null) {
                    if (aemValue != null && !aemValue.getAsString().isEmpty()) {
                        comparisonResult.getDifferences().put(fieldName, comparisonResult.new Difference("", aemValue.getAsString()));
                    }
                } else {
                    if (ignoreCase) {
                        if (!aemValue.getAsString().equalsIgnoreCase(mapping.get(csvValue))) {
                            comparisonResult.getDifferences().put(fieldName, comparisonResult.new Difference(mapping.get(csvValue), aemValue.getAsString()));
                        }
                    } else {
                        if (!aemValue.getAsString().equals(mapping.get(csvValue))) {
                            comparisonResult.getDifferences().put(fieldName, comparisonResult.new Difference(mapping.get(csvValue), aemValue.getAsString()));
                        }
                    }
                }
            }
        } else {
            if (csvValue != null && !csvValue.isEmpty()) {
                if (mapping.containsKey(csvValue) && !mapping.get(csvValue).isEmpty()) {
                    comparisonResult.getDifferences().put(fieldName, comparisonResult.new Difference(csvValue, ""));
                }
            }
        }

        return comparisonResult;
    }

    private ComparisonResult compareStringValue(String fieldName, String csvValue, JsonObject assetJson, ComparisonResult comparisonResult) {
        if (assetJson.has(fieldName)) {
            if (assetJson.get(fieldName).isJsonArray()) {
                JsonArray aemArrayValues = assetJson.getAsJsonArray(fieldName);
                List<String> aemValues = new ArrayList<>();
                for (JsonElement element : aemArrayValues) {
                    aemValues.add(element.getAsString());
                }

                if (csvValue == null) {
                    if (!aemValues.isEmpty()) {
                        comparisonResult.getDifferences().put(fieldName, comparisonResult.new Difference("", String.join(",", aemValues)));
                    }
                } else {
                    try {
                        if (!aemValues.contains(csvValue.trim())) {
                            comparisonResult.getDifferences().put(fieldName, comparisonResult.new Difference(csvValue, String.join(",", aemValues)));
                        }
                    } catch (Exception e) {
                        comparisonResult.getDifferences().put(fieldName, comparisonResult.new Difference(csvValue, String.join(",", aemValues)));
                    }
                }

            } else {
                JsonElement aemValue = assetJson.get(fieldName);
                if (csvValue == null) {
                    if (aemValue != null && !aemValue.getAsString().isEmpty()) {
                        comparisonResult.getDifferences().put(fieldName, comparisonResult.new Difference("", aemValue.getAsString()));
                    }
                } else {
                    try {
                        if (!aemValue.getAsString().trim().equals(csvValue.trim())) {
                            comparisonResult.getDifferences().put(fieldName, comparisonResult.new Difference(csvValue, aemValue.getAsString()));
                        }
                    } catch (Exception e) {
                        comparisonResult.getDifferences().put(fieldName, comparisonResult.new Difference(csvValue, aemValue.toString()));
                    }
                }
            }
        } else {
            if (csvValue != null && !csvValue.isEmpty()) {
                comparisonResult.getDifferences().put(fieldName, comparisonResult.new Difference(csvValue, ""));
            }
        }

        return comparisonResult;
    }

    private ComparisonResult compareDateValue(String fieldName, String csvValue, JsonObject assetJson, String cantoDateFormat, String aemDateFormat, ComparisonResult comparisonResult) {
        JsonElement aemValue = assetJson.get(fieldName);
        if (aemValue == null) {
            if (!csvValue.isEmpty()) {
                comparisonResult.getDifferences().put(fieldName, comparisonResult.new Difference(csvValue, ""));
            }
        } else if (csvValue == null) {
            if (aemValue != null && !aemValue.getAsString().isEmpty()) {
                comparisonResult.getDifferences().put(fieldName, comparisonResult.new Difference("", aemValue.getAsString()));
            }
        } else {
            try {
                SimpleDateFormat sd1 = new SimpleDateFormat(aemDateFormat);
                Date aemDateValue = sd1.parse(aemValue.getAsString());
                SimpleDateFormat sd2 = new SimpleDateFormat(cantoDateFormat);
                Date csvDateValue = sd2.parse(csvValue);
                if (!aemDateValue.equals(csvDateValue)) {
//                    System.out.println("Field = " + fieldName);
//                    System.out.println("Canto Value = " + csvDateValue);
//                    System.out.println("AEM Value = " + aemDateValue);
                    comparisonResult.getDifferences().put(fieldName, comparisonResult.new Difference(csvValue, aemValue.getAsString()));
                }
            } catch (Exception e) {
//                e.printStackTrace(System.out);
                comparisonResult.getDifferences().put(fieldName, comparisonResult.new Difference(csvValue, aemValue.getAsString()));
            }
        }

        return comparisonResult;
    }

    public ComparisonResult returnAemAssetNotFound(Asset asset, String aemAssetPath) {
        ComparisonResult comparisonResult = new ComparisonResult();
        comparisonResult.setCantoId(asset.getID());
        comparisonResult.setAssetPath(aemAssetPath);
        comparisonResult.setMissingInAEM(true);

        return comparisonResult;
    }

    public ComparisonResult compareCantoAemMetadata(Asset asset, JsonObject assetJson, String aemAssetPath) {
        ComparisonResult comparisonResult = new ComparisonResult();

        comparisonResult.setMissingInAEM(false);
        comparisonResult.setAssetPath(aemAssetPath);
        comparisonResult.setCantoId(asset.getID());

        comparisonResult = compareStringValue("td:apn", asset.getActivityProposalNumber(), assetJson, comparisonResult);
        comparisonResult = compareStringValue("td:projectname", asset.getProjectName(), assetJson, comparisonResult);
        comparisonResult = compareStringWithMappingValue("td:assettype", asset.getAssetType(), assetJson, comparisonResult, assetTypeMappings, true);

        JsonElement aemKeywords = assetJson.get("td:keywords");
        if (aemKeywords == null) {
            if (asset.getKeywords().size() != 0) {
                comparisonResult.getDifferences().put("td:keywords", comparisonResult.new Difference(String.join(",", asset.getKeywords()), ""));
            }
        } else {
            ArrayList<String> aemKeywordsAsArray = new ArrayList<>(Arrays.asList(aemKeywords.toString().replace("\"", "").split(", |: |; |,|:|;")));
            ArrayList<String> csvKeywords = asset.getKeywords();
            boolean missingKeyword = false;
            for (String keyword : csvKeywords) {
                if (!aemKeywordsAsArray.contains(keyword)) {
                    missingKeyword = true;
                    break;
                }
            }
            if (missingKeyword) {
                comparisonResult.getDifferences().put("td:keywords", comparisonResult.new Difference(String.join(",", asset.getKeywords()), String.join(",", aemKeywordsAsArray)));
            }
        }

        comparisonResult = compareDateValue("td:inmarket", asset.getInMarketDate(), assetJson, "d-MMM-y", "EEE MMM d yyyy HH:mm:ss 'GMT'Z", comparisonResult);
        comparisonResult = compareDateValue("td:expiry", asset.getExpiryDate(), assetJson, "dd-MMM-y", "EEE MMM d yyyy HH:mm:ss 'GMT'Z", comparisonResult);
//        comparisonResult = compareStringValue("td:expiry", asset.getExpiryDate(), assetJson, comparisonResult);

//        JsonElement aemChannels = assetJson.get("td:channel");
//        if (aemChannels == null) {
//            if (asset.getChannels().size() != 0) {
//                comparisonResult.getDifferences().put("td:channel", comparisonResult.new Difference(String.join(",", asset.getChannels()), ""));
//            }
//        } else {
//            ArrayList<String> csvChannels = asset.getChannels();
//            ArrayList<String> mappedCSVChannels = new ArrayList<>();
//            for (String channel : csvChannels) {
//                mappedCSVChannels.add(channelMappings.get(channel));
//            }
//            if (!aemChannels.getAsString().equals(mappedCSVChannels.toString())) {
//                comparisonResult.getDifferences().put("td:channel", comparisonResult.new Difference(String.join(",", asset.getChannels()), String.join(",", mappedCSVChannels)));
//            }
//        }
//        comparisonResult = compareStringValue("td:channel", asset.getChannel(), assetJson, comparisonResult);
//        comparisonResult = compareStringWithMappingValue("td:channel", asset.getChannel(), assetJson, comparisonResult, channelMappings, true);
        List<String> cantoChannels = new ArrayList<>();
        List<String> aemChannels = new ArrayList<>();

        if (asset.getChannels() != null && !asset.getChannels().isEmpty()) {
            for (String cantoChannel : asset.getChannels()) {
                String mappedChannel = channelMappings.get(cantoChannel);
                if (cantoChannel.equals("Digital-RAW")) {
                    mappedChannel = "Digital";
                }
                if (mappedChannel != null && !mappedChannel.isEmpty() && !cantoChannels.contains(mappedChannel)) {
                    cantoChannels.add(mappedChannel);
                }
            }
        }
        if (assetJson.has("td:channel")) {
            JsonArray jsonArray = assetJson.getAsJsonArray("td:channel");
            if (jsonArray.size() > 0) {
                for (JsonElement jsonElement : jsonArray) {
                    String value = jsonElement.getAsString();
                    if (value != null && !value.isEmpty() && !aemChannels.contains(value)) {
                        aemChannels.add(value);
                    }
                }
            }
        }

        if (aemChannels == null) {
            if (!cantoChannels.isEmpty()) {
                comparisonResult.getDifferences().put("td:channel", comparisonResult.new Difference(String.join(",", cantoChannels), ""));
            }
        } else if (cantoChannels == null || cantoChannels.isEmpty()) {
            if (!aemChannels.isEmpty()) {
                comparisonResult.getDifferences().put("td:channel", comparisonResult.new Difference("", String.join(",", aemChannels)));
            }
        } else {
            for (String cantoChannel : cantoChannels) {
                if (!aemChannels.contains(cantoChannel)) {
                    comparisonResult.getDifferences().put("td:channel", comparisonResult.new Difference(String.join(",", cantoChannels), String.join(",", aemChannels)));
                    break;
                }
            }
        }

        comparisonResult = compareStringValue("td:branchid", asset.getBranchID(), assetJson, comparisonResult);
        comparisonResult = compareStringWithOtherAndMappingValue("td:agency", asset.getAgencyName(), asset.getAgencyNameOther(), assetJson, comparisonResult, agencyNameMappings);
        comparisonResult = compareStringValue("td:agencypid", asset.getAgencyProjectID(), assetJson, comparisonResult);
        comparisonResult = compareStringValue("dc:description", asset.getDescription(), assetJson, comparisonResult);
        comparisonResult = compareStringWithMappingValue("td:language", asset.getLanguage(), assetJson, comparisonResult, languageMappings, true);
/*
        JsonElement aemLOBs = assetJson.get("td:lob");
        if (aemLOBs == null) {
            if (asset.getLOBs().size() != 0) {
                comparisonResult.getDifferences().put("td:lob", comparisonResult.new Difference(String.join(",", asset.getLOBs()), ""));
            }
        } else {
            ArrayList<String> csvLOBs = asset.getLOBs();
            ArrayList<String> mappedLOBs = new ArrayList<>();
            for (String lob : csvLOBs) {
                mappedLOBs.add(lobMappings.get(lob));
            }
            if (!aemLOBs.getAsString().equals(mappedLOBs.toString())) {
                comparisonResult.getDifferences().put("td:lob", comparisonResult.new Difference(mappedLOBs.toString(), aemLOBs.getAsString()));
            }
        }
*/
//        comparisonResult = compareStringValue("td:photosource", asset.getPhotoSource(), assetJson, comparisonResult);
        comparisonResult = compareStringWithMappingValue("td:photosource", asset.getPhotoSource(), assetJson, comparisonResult, photoSourceMappings, false);
        comparisonResult = compareStringWithOtherAndMappingValue("td:usageright", asset.getUsageRights(), asset.getUsageRightsOther(), assetJson, comparisonResult, usageRightsMappings);
        comparisonResult = compareStringWithMappingValue("td:approval", asset.getApprovalStatus(), assetJson, comparisonResult, approvalStatusMappings, false);
        comparisonResult = compareStringValue("tiff:ImageWidth", asset.getImageWidth(), assetJson, comparisonResult);
        comparisonResult = compareStringValue("tiff:ImageLength", asset.getImageHeight(), assetJson, comparisonResult);

        comparisonResult = compareResolution("tiff:XResolution", asset.getResolutionHorizontal(), assetJson, comparisonResult);
        comparisonResult = compareResolution("tiff:YResolution", asset.getResolutionVertical(), assetJson, comparisonResult);

        comparisonResult = compareStringValue("dc:creator", asset.getPhotographer(), assetJson, comparisonResult);
//        comparisonResult = compareStringValue("td:datefilecaptured", asset.getDateFileCaptured(), assetJson, comparisonResult);
        comparisonResult = compareDateValue("td:datefilecaptured", asset.getDateFileCaptured(), assetJson, "yyyy-MM-dd'T'HH:mm:ssXXX", "EEE MMM d yyyy HH:mm:ss 'GMT'Z", comparisonResult);
        comparisonResult = compareStringValue("dam:FileFormat", asset.getFileFormat(), assetJson, comparisonResult);
        comparisonResult = compareStringValue("dam:size", asset.getFileSize(), assetJson, comparisonResult);
        comparisonResult = compareDateValue("dc:modified", asset.getDateRecordLastModified(), assetJson, "yyyy-MM-dd'T'HH:mm:ssXXX", "EEE MMM d yyyy HH:mm:ss 'GMT'Z", comparisonResult);
        comparisonResult = compareDateValue("td:catalogued", asset.getDateFileCataloged(), assetJson, "yyyy-MM-dd'T'HH:mm:ssXXX", "EEE MMM d yyyy HH:mm:ss 'GMT'Z", comparisonResult);
        comparisonResult = compareStringValue("td:cataloguedBy", asset.getCatalogedBy(), assetJson, comparisonResult);

        return comparisonResult;
    }

    public static HashMap<String, String> checkForDifferences(ArrayList<Asset> fromCSV, HashMap<String, JsonObject> fromAEM, int iteration) {

        ArrayList<String> metadataDifferences = new ArrayList<>();
        HashMap<String, String> pathsAndDifferences = new HashMap<>();

        System.out.println("Start of metadata comparison for BATCH " + iteration);

        for (Asset assetFromCSV : fromCSV) {

            if (assetFromCSV.getCorrupted()) {

                metadataDifferences.add("Asset metadata in CSV is corrupted! See the CSV Line in the first column!");
                pathsAndDifferences.put(Integer.toString(assetFromCSV.getCSVLine()), metadataDifferences.toString());
                metadataDifferences.clear();

            } else {

                String assetKeyCSV = assetFromCSV.getContainer() + "/" + assetFromCSV.getFileName();

                for (Map.Entry<String, JsonObject> assetFromAEM : fromAEM.entrySet()) {

                    String assetFromAEMPath = assetFromAEM.getKey();
                    JsonObject assetFromAEMMetadata = assetFromAEM.getValue();

                    if (assetFromAEMMetadata.get("outcome").toString().replaceAll("\"", "").equals("fail")) {

                        metadataDifferences.add("Failed to import metadata from AEM!");
                        pathsAndDifferences.put(assetFromAEMPath + ":" + assetFromCSV.getID(), metadataDifferences.toString());

                    } else {

                        if (assetFromAEMPath.equals(assetKeyCSV)) {

                            System.out.println("Comparing : " + assetFromAEMPath);

                            JsonElement aemAPN = assetFromAEMMetadata.get("td:apn");
                            if (aemAPN == null) {
                                if (!assetFromCSV.getActivityProposalNumber().isEmpty()) {
                                    metadataDifferences.add("AP (Activity Proposal) Number Missing");
                                }
                            } else {
                                String csvAPN = "\"" + assetFromCSV.getActivityProposalNumber() + "\"";
                                if (!aemAPN.toString().equals(csvAPN)) {
                                    metadataDifferences.add("AP (Activity Proposal) Number");
                                }
                            }

                            JsonElement aemProjectName = assetFromAEMMetadata.get("td:projectname");
                            if (aemProjectName == null) {
                                if (!assetFromCSV.getProjectName().isEmpty()) {
                                    metadataDifferences.add("Project Name Missing");
                                }
                            } else {
                                String csvProjectName = "\"" + assetFromCSV.getProjectName() + "\"";
                                if (!aemProjectName.toString().equals(csvProjectName)) {
                                    metadataDifferences.add("Project Name");
                                }
                            }

                            JsonElement aemAssetType = assetFromAEMMetadata.get("td:assettype");
                            if (aemAssetType == null) {
                                if (!assetFromCSV.getAssetType().isEmpty()) {
                                    metadataDifferences.add("Asset Type Missing");
                                }
                            } else {
                                String csvAssetType = "\"" + assetTypeMappings.get(assetFromCSV.getAssetType()) + "\"";
                                if (!aemAssetType.toString().equals(csvAssetType)) {
                                    metadataDifferences.add("Asset Type");
                                }
                            }

                            JsonElement aemKeywords = assetFromAEMMetadata.get("td:keywords");
                            if (aemKeywords == null) {
                                if (assetFromCSV.getKeywords().size() != 0) {
                                    metadataDifferences.add("Keywords Missing");
                                }
                            } else {
                                ArrayList<String> aemKeywordsAsArray = new ArrayList<>(Arrays.asList(aemKeywords.toString().replace("\"", "").split(", ")));
                                ArrayList<String> csvKeywords = assetFromCSV.getKeywords();
                                if (!aemKeywordsAsArray.equals(csvKeywords)) {
                                    metadataDifferences.add("Keywords");
                                }
                            }

                            JsonElement aemInMarket = assetFromAEMMetadata.get("td:inmarket");
                            if (aemInMarket == null) {
                                if (!assetFromCSV.getInMarketDate().isEmpty()) {
                                    metadataDifferences.add("In Market Missing");
                                }
                            } else {
                                String csvInMarket = "\"" + assetFromCSV.getInMarketDate() + "\"";
                                try {
                                    SimpleDateFormat sd1 = new SimpleDateFormat("EEE MMM d yyyy hh:mm:ss 'GMT'Z");
                                    Date aemInMarketDate = sd1.parse(aemInMarket.toString().replaceAll("\"", ""));
                                    SimpleDateFormat sd2 = new SimpleDateFormat("d-MMM-yy");
                                    Date csvInMarketDate = sd2.parse(csvInMarket.replaceAll("\"", ""));
                                    if (!aemInMarketDate.equals(csvInMarketDate)) {
                                        metadataDifferences.add("In Market");
                                    }
                                } catch (Exception e) {
                                    System.out.println(e.toString());
                                    metadataDifferences.add("In Market");
                                }
                            }

                            JsonElement aemExpiryDate = assetFromAEMMetadata.get("td:expiry");
                            if (aemExpiryDate == null) {
                                if (!assetFromCSV.getExpiryDate().isEmpty()) {
                                    metadataDifferences.add("Expiry Date Missing");
                                }
                            } else {
                                String csvExpiryDate = "\"" + assetFromCSV.getExpiryDate() + "\"";
                                if (!aemExpiryDate.toString().equals(csvExpiryDate)) {
                                    metadataDifferences.add("Expiry Date");
                                }
                            }

                            JsonElement aemChannels = assetFromAEMMetadata.get("td:channel");
                            if (aemChannels == null) {
                                if (assetFromCSV.getChannels().size() != 0) {
                                    metadataDifferences.add("Channel Missing");
                                }
                            } else {
                                ArrayList<String> csvChannels = assetFromCSV.getChannels();
                                ArrayList<String> mappedCSVChannels = new ArrayList<>();
                                for (String channel : csvChannels) {
                                    mappedCSVChannels.add(channelMappings.get(channel));
                                }
                                if (!aemChannels.toString().equals("\"" + mappedCSVChannels.toString() + "\"")) {
                                    metadataDifferences.add("Channel");
                                }
                            }

                            JsonElement aemBranchID = assetFromAEMMetadata.get("td:branchid");
                            if (aemBranchID == null) {
                                if (!assetFromCSV.getBranchID().isEmpty()) {
                                    metadataDifferences.add("Branch ID Missing");
                                }
                            } else {
                                String csvBranchID = "\"" + assetFromCSV.getBranchID() + "\"";
                                if (!aemBranchID.toString().equals(csvBranchID)) {
                                    metadataDifferences.add("Branch ID");
                                }
                            }

                            JsonElement aemAgencyName = assetFromAEMMetadata.get("td:agency");
                            if (aemAgencyName == null) {
                                if (!assetFromCSV.getAgencyNameOther().isEmpty()) {
                                    metadataDifferences.add("Agency Name Missing");
                                }
                            } else {
                                String csvAgencyName;
                                if (assetFromCSV.getAgencyNameOther().isEmpty()) {
                                    csvAgencyName = agencyNameMappings.get(assetFromCSV.getAgencyName());
                                } else {
                                    csvAgencyName = assetFromCSV.getAgencyNameOther();
                                }
                                if (!aemAgencyName.toString().equals("\"" + csvAgencyName + "\"")) {
//                                    System.out.println("CSV Agency Name: " + csvAgencyName);
//                                    System.out.println("AEM Agency Name: " + aemAgencyName);
//                                    System.out.println("....................................");
                                    metadataDifferences.add("Agency Name");
                                }
                            }

                            JsonElement aemAgencyPID = assetFromAEMMetadata.get("td:agencypid");
                            if (aemAgencyPID == null) {
                                if (!assetFromCSV.getAgencyProjectID().isEmpty()) {
                                    metadataDifferences.add("Agency Project ID Missing");
                                }
                            } else {
                                String csvAgencyPID = "\"" + assetFromCSV.getAgencyProjectID() + "\"";
                                if (!aemAgencyPID.toString().equals(csvAgencyPID)) {
                                    metadataDifferences.add("Agency Project ID");
                                }
                            }

                            JsonElement aemDescription = assetFromAEMMetadata.get("dc:description");
                            if (aemDescription == null) {
                                if (!assetFromCSV.getDescription().isEmpty()) {
                                    metadataDifferences.add("Description Missing");
                                }
                            } else {
                                String csvDescription = "\"" + assetFromCSV.getDescription() + "\"";
                                if (!aemDescription.toString().replaceAll(" ", "").equals(csvDescription.replaceAll(" ", ""))) {
                                    metadataDifferences.add("Description");
                                }
                            }

                            JsonElement aemLanguage = assetFromAEMMetadata.get("td:language");
                            if (aemLanguage == null) {
                                if (!assetFromCSV.getLanguage().isEmpty()) {
                                    metadataDifferences.add("Language Missing");
                                }
                            } else {
                                String csvLanguage = "\"" + languageMappings.get(assetFromCSV.getLanguage()) + "\"";
                                if (!aemLanguage.toString().equalsIgnoreCase(csvLanguage)) {
                                    metadataDifferences.add("Language");
                                }
                            }

                            JsonElement aemLOBs = assetFromAEMMetadata.get("td:lob");
                            if (aemLOBs == null) {
                                if (assetFromCSV.getLOBs().size() != 0) {
                                    metadataDifferences.add("Line Of Business Missing");
                                }
                            } else {
                                ArrayList<String> csvLOBs = assetFromCSV.getLOBs();
                                ArrayList<String> mappedLOBs = new ArrayList<>();
                                for (String lob : csvLOBs) {
                                    mappedLOBs.add(lobMappings.get(lob));
                                }
                                if (!aemLOBs.toString().equals("\"" + mappedLOBs.toString() + "\"")) {
                                    metadataDifferences.add("Line Of Business");
                                }
                            }

                            JsonElement aemPhotoSource = assetFromAEMMetadata.get("td:photosource");
                            if (aemPhotoSource == null) {
                                if (!assetFromCSV.getPhotoSource().isEmpty()) {
                                    metadataDifferences.add("Photo Source Missing");
                                }
                            } else {
                                String csvPhotoSource = "\"" + assetFromCSV.getPhotoSource() + "\"";
                                if (!aemPhotoSource.toString().equals(csvPhotoSource)) {
                                    metadataDifferences.add("Photo Source");
                                }
                            }

                            JsonElement aemUsageRights = assetFromAEMMetadata.get("td:usageright");
                            if (aemUsageRights == null) {
                                if (!assetFromCSV.getUsageRightsOther().isEmpty()) {
                                    metadataDifferences.add("Usage Rights Missing");
                                }
                            } else {
                                String csvUsageRights;
                                if (assetFromCSV.getUsageRightsOther().isEmpty()) {
                                    csvUsageRights = usageRightsMappings.get(assetFromCSV.getUsageRights());
                                } else {
                                    csvUsageRights = assetFromCSV.getUsageRightsOther();
                                }
                                if (!aemUsageRights.toString().equals("\"" + csvUsageRights + "\"")) {
                                    metadataDifferences.add("Usage Rights");
                                }
                            }

                            JsonElement aemApprovalStatus = assetFromAEMMetadata.get("td:approval");
                            if (aemApprovalStatus == null) {
                                if (!assetFromCSV.getApprovalStatus().isEmpty()) {
                                    metadataDifferences.add("Approval Status Missing");
                                }
                            } else {
                                String csvApprovalStatus = "\"" + approvalStatusMappings.get(assetFromCSV.getApprovalStatus()) + "\"";
                                if (!aemApprovalStatus.toString().equals(csvApprovalStatus)) {
                                    metadataDifferences.add("Approval Status");
                                }
                            }

                            JsonElement aemImageWidth = assetFromAEMMetadata.get("tiff:ImageWidth");
                            if (aemImageWidth == null) {
                                if (!assetFromCSV.getImageWidth().isEmpty()) {
                                    metadataDifferences.add("Image Width Missing");
                                }
                            } else {
                                String csvImageWidth = assetFromCSV.getImageWidth();
                                if (!aemImageWidth.toString().equals(csvImageWidth)) {
                                    metadataDifferences.add("Image Width");
                                }
                            }

                            JsonElement aemImageHeight = assetFromAEMMetadata.get("tiff:ImageLength");
                            if (aemImageHeight == null) {
                                if (!assetFromCSV.getImageHeight().isEmpty()) {
                                    metadataDifferences.add("Image Height Missing");
                                }
                            } else {
                                String csvImageHeight = assetFromCSV.getImageHeight();
                                if (!aemImageHeight.toString().equals(csvImageHeight)) {
                                    metadataDifferences.add("Image Height");
                                }
                            }

                            JsonElement aemResolutionHorizontal = assetFromAEMMetadata.get("tiff:XResolution");
                            if (aemResolutionHorizontal == null) {
                                if (!assetFromCSV.getResolutionHorizontal().isEmpty()) {
                                    metadataDifferences.add("Resolution (Horizontal) Missing");
                                }
                            } else {
                                try {
                                    String csvResolutionHorizontal = assetFromCSV.getResolutionHorizontal();
                                    String[] aemResolutionHorizontalNumbers = aemResolutionHorizontal.toString().split("/");
                                    int aemResolutionHorizontalInt;
                                    if (aemResolutionHorizontalNumbers.length == 1) {
                                        double aemResolutionHorizontalSoleInt = Double.parseDouble(aemResolutionHorizontalNumbers[0].replaceAll("\"", ""));
                                        aemResolutionHorizontalInt = (int) Math.round(aemResolutionHorizontalSoleInt);
                                    } else {
                                        double aemResolutionHorizontalDividend = Double.parseDouble(aemResolutionHorizontalNumbers[0].replaceAll("\"", ""));
                                        double aemResolutionHorizontalDivisor = Double.parseDouble(aemResolutionHorizontalNumbers[1].replaceAll("\"", ""));
                                        aemResolutionHorizontalInt = (int) Math.round(aemResolutionHorizontalDividend / aemResolutionHorizontalDivisor);
                                    }
                                    int csvResolutionHorizontalInt = (int) Math.round(Double.parseDouble(csvResolutionHorizontal));
                                    if (aemResolutionHorizontalInt != csvResolutionHorizontalInt) {
                                        metadataDifferences.add("Resolution (Horizontal)");
                                    }
                                } catch (Exception e) {
                                    metadataDifferences.add("Resolution (Horizontal)");
                                }
                            }

                            JsonElement aemResolutionVertical = assetFromAEMMetadata.get("tiff:YResolution");
                            if (aemResolutionVertical == null) {
                                if (!assetFromCSV.getResolutionVertical().isEmpty()) {
                                    metadataDifferences.add("Resolution (Vertical) Missing");
                                }
                            } else {
                                try {
                                    String csvResolutionVertical = assetFromCSV.getResolutionVertical();
                                    String[] aemResolutionVerticalNumbers = aemResolutionVertical.toString().split("/");
                                    int aemResolutionVerticalInt;
                                    if (aemResolutionVerticalNumbers.length == 1) {
                                        double aemResolutionVerticalSoleInt = Double.parseDouble(aemResolutionVerticalNumbers[0].replaceAll("\"",""));
                                        aemResolutionVerticalInt = (int) Math.round(aemResolutionVerticalSoleInt);
                                    } else {
                                        double aemResolutionVerticalDividend = Double.parseDouble(aemResolutionVerticalNumbers[0].replaceAll("\"",""));
                                        double aemResolutionVerticalDivisor = Double.parseDouble(aemResolutionVerticalNumbers[1].replaceAll("\"",""));
                                        aemResolutionVerticalInt = (int) Math.round(aemResolutionVerticalDividend / aemResolutionVerticalDivisor);
                                    }
                                    int csvResolutionVerticalInt = (int) Math.round(Double.parseDouble(csvResolutionVertical));
                                    if (aemResolutionVerticalInt != csvResolutionVerticalInt) {
                                        metadataDifferences.add("Resolution (Vertical)");
                                    }
                                } catch (Exception e) {
                                    metadataDifferences.add("Resolution (Vertical)");
                                }
                            }

                            JsonElement aemPhotographerOrCreator = assetFromAEMMetadata.get("dc:creator");
                            if (aemPhotographerOrCreator == null) {
                                if (!assetFromCSV.getPhotographer().isEmpty()) {
                                    metadataDifferences.add("Photographer or Creator Missing");
                                }
                            } else {
                                String csvPhotographerOrCreator = "\"" + assetFromCSV.getPhotographer() + "\"";
                                if (!aemPhotographerOrCreator.toString().equals(csvPhotographerOrCreator)) {
                                    metadataDifferences.add("Photographer or Creator");
                                }
                            }

                            JsonElement aemDateFileCaptured = assetFromAEMMetadata.get("td:datefilecaptured");
                            if (aemDateFileCaptured == null) {
                                if (!assetFromCSV.getDateFileCaptured().isEmpty()) {
                                    metadataDifferences.add("Date File Captured Missing");
                                }
                            } else {
                                String csvDateFileCaptured = assetFromCSV.getDateFileCaptured();
                                try {
                                    SimpleDateFormat sd7 = new SimpleDateFormat("EEE MMM d yyyy hh:mm:ss 'GMT'Z");
                                    Date aemDateFileCapturedDate = sd7.parse(aemDateFileCaptured.toString().replaceAll("\"", ""));
                                    SimpleDateFormat sd8 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
                                    Date csvDateFileCapturedDate = sd8.parse(csvDateFileCaptured);
                                    if (!aemDateFileCapturedDate.equals(csvDateFileCapturedDate)) {
                                        metadataDifferences.add("Date File Captured");
                                    }
                                } catch (Exception e) {
                                    metadataDifferences.add("Date File Captured");
                                }
                            }

                            JsonElement aemFileFormat = assetFromAEMMetadata.get("dam:FileFormat");
                            if (aemFileFormat == null) {
                                if (!assetFromCSV.getFileFormat().isEmpty()) {
                                    metadataDifferences.add("File Format Missing");
                                }
                            } else {
                                String csvFileFormat = "\"" + assetFromCSV.getFileFormat() + "\"";
                                if (!aemFileFormat.toString().equals(csvFileFormat)) {
                                    metadataDifferences.add("File Format");
                                }
                            }

                            JsonElement aemFileSize = assetFromAEMMetadata.get("dam:size");
                            if (aemFileSize == null) {
                                if (!assetFromCSV.getFileSize().isEmpty()) {
                                    metadataDifferences.add("File Size Missing");
                                }
                            } else {
                                String csvFileSize = assetFromCSV.getFileSize();
                                if (!aemFileSize.toString().equals(csvFileSize)) {
                                    metadataDifferences.add("File Size");
                                }
                            }

                            JsonElement aemDateRecordLastModified = assetFromAEMMetadata.get("dc:modified");
                            if (aemDateRecordLastModified == null) {
                                if (!assetFromCSV.getDateRecordLastModified().isEmpty()) {
                                    metadataDifferences.add("Date Record Last Modified Missing");
                                }
                            } else {
                                String csvDateRecordLastModified = assetFromCSV.getDateRecordLastModified();
                                try {
                                    SimpleDateFormat sd5 = new SimpleDateFormat("EEE MMM d yyyy hh:mm:ss 'GMT'Z");
                                    Date aemDateRecordLastModifiedDate = sd5.parse(aemDateRecordLastModified.toString().replaceAll("\"", ""));
                                    SimpleDateFormat sd6 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
                                    Date csvDateRecordLastModifiedDate = sd6.parse(csvDateRecordLastModified);
                                    if (!aemDateRecordLastModifiedDate.equals(csvDateRecordLastModifiedDate)) {
                                        metadataDifferences.add("Date Record Last Modified");
                                    }
                                } catch (Exception e) {
                                    metadataDifferences.add("Date Record Last Modified");
                                }
                            }

                            JsonElement aemDateFileCataloged = assetFromAEMMetadata.get("td:catalogued");
                            if (aemDateFileCataloged == null) {
                                if (!assetFromCSV.getDateFileCataloged().isEmpty()) {
                                    metadataDifferences.add("Date File Cataloged Missing");
                                }
                            } else {
                                String csvDateFileCataloged = assetFromCSV.getDateFileCataloged();
                                try {
                                    SimpleDateFormat sd3 = new SimpleDateFormat("EEE MMM d yyyy hh:mm:ss 'GMT'Z");
                                    Date aemDateFileCatalogedDate = sd3.parse(aemDateFileCataloged.toString().replaceAll("\"", ""));
                                    SimpleDateFormat sd4 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
                                    Date csvDateFileCatalogedDate = sd4.parse(csvDateFileCataloged);
                                    if (!aemDateFileCatalogedDate.equals(csvDateFileCatalogedDate)) {
                                        metadataDifferences.add("Date File Cataloged");
                                    }
                                } catch (Exception e) {
                                    metadataDifferences.add("Date File Cataloged");
                                }
                            }

                            JsonElement aemCatalogedBy = assetFromAEMMetadata.get("td:cataloguedBy");
                            if (aemCatalogedBy == null) {
                                if (!assetFromCSV.getCatalogedBy().isEmpty()) {
                                    metadataDifferences.add("Cataloged By Missing");
                                }
                            } else {
                                String csvCatalogedBy = "\"" + assetFromCSV.getCatalogedBy() + "\"";
                                if (!aemCatalogedBy.toString().equals(csvCatalogedBy)) {
                                    metadataDifferences.add("Cataloged By");
                                }
                            }

                            if (metadataDifferences.size() > 0) {
                                pathsAndDifferences.put(assetFromAEMPath + ":" + assetFromCSV.getID(), metadataDifferences.toString());
                            }

                        }

                    }

                    metadataDifferences.clear();

                }


            }

        }

        System.out.println(new Date() + " - End of metadata comparison for BATCH " + iteration);

        return pathsAndDifferences;

    }
}
