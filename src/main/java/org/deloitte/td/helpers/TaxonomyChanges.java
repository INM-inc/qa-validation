package org.deloitte.td.helpers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TaxonomyChanges {

    public static HashMap<String, String> getContainerMappings() {

        HashMap<String, String> containerMappings = new HashMap<>();
        containerMappings.put("Corporate", "Brand/Corporate");
        containerMappings.put("Corporate:Corporate", "Brand/Corporate");
        containerMappings.put("Credit Cards", "personal-banking/credit-cards");
        containerMappings.put("Credit Cards:Affiliate MBNA", "personal-banking/credit-cards/MBNA");
        containerMappings.put("Credit Cards:Affinity Sports MBNA", "personal-banking/credit-cards/MBNA");
        containerMappings.put("Credit Cards:Credit Cards Production", "personal-banking/credit-cards");
        containerMappings.put("Brand", "Brand");
        containerMappings.put("Personal Banking", "personal-banking");
        containerMappings.put("Personal Lending", "personal-banking/secured-loans/personal-loans");
        containerMappings.put("RESL", "personal-banking/Mortgages");
        containerMappings.put("Small Business", "small-business-banking");
        containerMappings.put("TD-Auto-Finance", "personal-banking/secured-loans/auto-finance");
        containerMappings.put("TD Securities", "wholesale-banking");
        containerMappings.put("Wealth", "Wealth");
        containerMappings.put("Digital Banking", "personal-banking/service-options");

        return containerMappings;

    }

    public static String getPathFromContainer(String containerField) {

        HashMap<String, String> containerMappings = getContainerMappings();
        String pathStructure = "";

        containerField = containerField.split("\\$Containers:")[1];
        if (containerField.contains("MBNA")) {
            pathStructure = "personal-banking/credit-cards/MBNA";
        } else if (containerField.contains("TD:TD (Can):")) {
            containerField = containerField.split("TD:TD (Can):")[1];
            pathStructure = containerMappings.get(containerField) == null ? "IGNORE" : containerMappings.get(containerField);
        } else {
            pathStructure = "IGNORE";
        }

        return pathStructure;
    }

    public static String getCorrectContainer(String containerField) {

        if (containerField.contains("|")) {
            String[] fields = containerField.split("\\|");
            for (String field : fields) {
                if (field.contains("$Containers:")) {
                    containerField = field;
                }
            }
            return getPathFromContainer(containerField);
        } else {
            return getPathFromContainer(containerField);
        }

    }

    /*
     * Structure of the Corrected Container: $Containers:TD:TD (Can):Credit Cards:EVEREST DIGITAL:...
     * Level 4 is 5th element.
     */
    public static String getContainerLevel4(String containerField) {

        String[] containerLevels = containerField.split(":");
        if (containerLevels.length < 3) {
            return "NO_LEVEL_4";
        } else {
            return containerLevels[3];
        }

    }

    public static ArrayList<String> addKeywords(String level4) {

        ArrayList<String> taxonomy2KeywordsToAdd = new ArrayList<>();
        HashMap<String, String> taxonomy2KeysAndKeywords = new HashMap<>();
        taxonomy2KeysAndKeywords.put("Everest Digital", "Everest Digital");
        taxonomy2KeysAndKeywords.put("PERSONAL/TDCT CARDS", "Personal/TDCT Cards");
        taxonomy2KeysAndKeywords.put("Brand Production", "Production");
        taxonomy2KeysAndKeywords.put("Insurance Content", "Content");
        taxonomy2KeysAndKeywords.put("Insurance Production", "Production");
        taxonomy2KeysAndKeywords.put("CHEQUING & SAVING EDB", "Savings");
        taxonomy2KeysAndKeywords.put("PERSONAL BANKING PRODUCTION", "Production");
        taxonomy2KeysAndKeywords.put("Rate Sale", "Rate Sale");
        taxonomy2KeysAndKeywords.put("Content Marketing", "Content Marketing");
        taxonomy2KeysAndKeywords.put("Integrated Marketing Planning", " Integrated Marketing Planning");
        taxonomy2KeysAndKeywords.put("Marketing Express", "Marketing Express");
        taxonomy2KeysAndKeywords.put("Optimization / Relocation", "Optimization / Reloccation");
        taxonomy2KeysAndKeywords.put("Real-time Marketing", "Real-time Marketing");
        taxonomy2KeysAndKeywords.put("Retail", "Retail");
        taxonomy2KeysAndKeywords.put("Financial Planning", "Financial Planning");
        taxonomy2KeysAndKeywords.put("TD Wealth Templates", "TD Wealth Templates");
        taxonomy2KeysAndKeywords.put("All Windows 2", "Window");
        taxonomy2KeysAndKeywords.put("Window 1 - All", "Window");
        taxonomy2KeysAndKeywords.put("Window 1 - DI", "Window");
        taxonomy2KeysAndKeywords.put("Window 1 - PS&I", "Window");
        taxonomy2KeysAndKeywords.put("Window 2 - RESL", "Window");
        for (Map.Entry<String, String> taxonomy2KeyAndKeyword : taxonomy2KeysAndKeywords.entrySet()) {
            if (level4.equalsIgnoreCase(taxonomy2KeyAndKeyword.getKey())) {
                taxonomy2KeywordsToAdd.add(taxonomy2KeyAndKeyword.getValue());
            }
        }
        return taxonomy2KeywordsToAdd;

    }

    public static ArrayList<String> addLOBs(String level4) {

        ArrayList<String> taxonomy2LOBsToAdd = new ArrayList<>();
        HashMap<String, String> taxonomy2KeysAndLOBs = new HashMap<>();
        taxonomy2KeysAndLOBs.put("TD Asset Management", "TD Asset Management");
        taxonomy2KeysAndLOBs.put("Asset Management", "TD Asset Management");
        taxonomy2KeysAndLOBs.put("TDAM", "TDAM");
        for (Map.Entry<String, String> taxonomy2KeyAndLOB : taxonomy2KeysAndLOBs.entrySet()) {
            if (level4.equalsIgnoreCase(taxonomy2KeyAndLOB.getKey())) {
                taxonomy2LOBsToAdd.add(taxonomy2KeyAndLOB.getValue());
            }
        }
        return taxonomy2LOBsToAdd;

    }

    public static ArrayList<String> addChannels(String level4) {

        ArrayList<String> taxonomy2ChannelsToAdd = new ArrayList<>();
        HashMap<String, String> taxonomy2KeysAndChannels = new HashMap<>();
        taxonomy2KeysAndChannels.put("Direct Investing", "Direct Investment");
        for (Map.Entry<String, String> taxonomy2KeyAndChannel : taxonomy2KeysAndChannels.entrySet()) {
            if (level4.equalsIgnoreCase(taxonomy2KeyAndChannel.getKey())) {
                taxonomy2ChannelsToAdd.add(taxonomy2KeyAndChannel.getValue());
            }
        }
        return taxonomy2ChannelsToAdd;

    }

    public static String changePath(String level4) {

        String newPath = "";
        HashMap<String, String> taxonomy2KeysAndPaths = new HashMap<>();
        taxonomy2KeysAndPaths.put("Everest Digital", "Personal Banking");
        taxonomy2KeysAndPaths.put("PERSONAL/TDCT CARDS", "Personal Banking");
        taxonomy2KeysAndPaths.put("Brand Production", "Brand");
        taxonomy2KeysAndPaths.put("Insurance Content", "Insurance");
        taxonomy2KeysAndPaths.put("Insurance Production", "Insurance");
        taxonomy2KeysAndPaths.put("CHEQUING & SAVING EDB", "Personal Banking/Accounts/CHEQUING");
        taxonomy2KeysAndPaths.put("PERSONAL BANKING PRODUCTION", "Personal Banking");
        taxonomy2KeysAndPaths.put("Rate Sale", "Personal Banking/Mortgages");
        taxonomy2KeysAndPaths.put("Content Marketing", "Personal Banking");
        taxonomy2KeysAndPaths.put("Integrated Marketing Planning", "Personal Banking/Service & Options");
        taxonomy2KeysAndPaths.put("Marketing Express", "Personal Banking");
        taxonomy2KeysAndPaths.put("Optimization / Relocation", "Brand/Regional");
        taxonomy2KeysAndPaths.put("Real-time Marketing", "Brand/Event/Pride");
        taxonomy2KeysAndPaths.put("Retail", "Personal Banking");
        taxonomy2KeysAndPaths.put("TD Asset Management", "Wealth");
        taxonomy2KeysAndPaths.put("Asset Management", "Wealth");
        taxonomy2KeysAndPaths.put("Direct Investing", "Wealth");
        taxonomy2KeysAndPaths.put("Financial Planning", "Wealth");
        taxonomy2KeysAndPaths.put("TD Wealth Templates", "Wealth");
        taxonomy2KeysAndPaths.put("TDAM", "Wealth");
        taxonomy2KeysAndPaths.put("All Windows 2", "Personal Banking");
        taxonomy2KeysAndPaths.put("Window 1 - All", "Personal Banking");
        taxonomy2KeysAndPaths.put("Window 1 - DI", "Wealth");
        taxonomy2KeysAndPaths.put("Window 1 - PS&I", "Wealth");
        taxonomy2KeysAndPaths.put("Window 2 - RESL", "Personal Banking/Mortgages");
        for (Map.Entry<String, String> taxonomy2KeyAndPath : taxonomy2KeysAndPaths.entrySet()) {
            if (level4.equalsIgnoreCase(taxonomy2KeyAndPath.getKey())) {
                newPath = taxonomy2KeyAndPath.getValue();
            }
        }
        return newPath;

    }

}
