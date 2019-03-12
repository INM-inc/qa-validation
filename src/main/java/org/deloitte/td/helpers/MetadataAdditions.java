package org.deloitte.td.helpers;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class MetadataAdditions {

    public static ArrayList<String> searchForKeywords(String line) {

        ArrayList<String> keywordsToAdd = new ArrayList<>();
        HashMap<String, String> keysAndKeywords = new HashMap<>();
        keysAndKeywords.put("Everest Digital", "Everest Digital");
        keysAndKeywords.put("PERSONAL/TDCT CARDS", "Personal/TDCT Cards");
        keysAndKeywords.put("Brand Production", "Production");
        keysAndKeywords.put("Insurance Content", "Content");
        keysAndKeywords.put("Insurance Production", "Production");
        keysAndKeywords.put("CHEQUING & SAVING EDB", "Savings");
        keysAndKeywords.put("PERSONAL BANKING PRODUCTION", "Production");
        keysAndKeywords.put("Rate Sale", "Rate Sale");
        keysAndKeywords.put("Content Marketing", "Content Marketing");
        keysAndKeywords.put("Integrated Marketing Planning", " Integrated Marketing Planning");
        keysAndKeywords.put("Marketing Express", "Marketing Express");
        keysAndKeywords.put("Optimization / Relocation", "Optimization / Reloccation");
        keysAndKeywords.put("Real-time Marketing", "Real-time Marketing");
        keysAndKeywords.put("Financial Planning", "Financial Planning");
        keysAndKeywords.put("TD Wealth Templates", "TD Wealth Templates");
        keysAndKeywords.put("All Windows 2", "Window");
        keysAndKeywords.put("Window 1 - All", "Window");
        keysAndKeywords.put("Window 1 - DI", "Window");
        keysAndKeywords.put("Window 1 - PS&I", "Window");
        keysAndKeywords.put("Window 2 - RESL", "Window");
        for (Map.Entry<String, String> keyAndKeyword : keysAndKeywords.entrySet()) {
            if (line.contains(keyAndKeyword.getKey())) {
                keywordsToAdd.add(keyAndKeyword.getValue());
            }
        }
        return keywordsToAdd;

    }

    public static ArrayList<String> searchForGroups(String line) {

        ArrayList<String> groupsToAdd = new ArrayList<>();
        HashMap<String, String> keysAndGroups = new HashMap<>();
        keysAndGroups.put("TD Asset Management", "TD Asset Management");
        keysAndGroups.put("Asset Management", "TD Asset Management");
        keysAndGroups.put("TDAM", "TDAM");
        for (Map.Entry<String, String> keyAndGroup : keysAndGroups.entrySet()) {
            if (line.contains(keyAndGroup.getKey())) {
                groupsToAdd.add(keyAndGroup.getValue());
            }
        }
        return groupsToAdd;

    }

    public static ArrayList<String> searchForChannels(String line) {

        ArrayList<String> channelsToAdd = new ArrayList<>();
        HashMap<String, String> keysAndChannels = new HashMap<>();
        keysAndChannels.put("Direct Investing", "Direct Investment");
        for (Map.Entry<String, String> keyAndChannel : keysAndChannels.entrySet()) {
            if (line.contains(keyAndChannel.getKey())) {
                channelsToAdd.add(keyAndChannel.getValue());
            }
        }
        return channelsToAdd;

    }

    public static ArrayList<String> searchForOthers(String line) {

        ArrayList<String> othersToAdd = new ArrayList<>();
        HashMap<String, String> keysAndOthers = new HashMap<>();
        keysAndOthers.put("Retail", "Clean Up");
        for (Map.Entry<String, String> keyAndOther : keysAndOthers.entrySet()) {
            if (line.contains(keyAndOther.getKey())) {
                othersToAdd.add(keyAndOther.getValue());
            }
        }
        return othersToAdd;

    }

}
