package org.deloitte.td.helpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TaxonomyChanges {

    public static HashMap<String, String> getContainerMappings() {

        HashMap<String, String> containerMappings = new HashMap<>();
        containerMappings.put("Corporate", "Brand/Corporate");
        containerMappings.put("Corporate:Human Resources", "Brand/Corporate/human-resources");
        containerMappings.put("Corporate:Corporate", "Brand/Corporate");
        containerMappings.put("Credit Cards", "personal-banking/credit-cards");
        containerMappings.put("Credit Cards:Aeroplan", "personal-banking/credit-cards");
        containerMappings.put("Credit Cards:Affiliate MBNA", "personal-banking/credit-cards/MBNA");
        containerMappings.put("Credit Cards:Affinity Sports MBNA", "personal-banking/credit-cards/MBNA");
        containerMappings.put("Credit Cards:Business Credit Cards", "small-business-banking/credit-cards");
        containerMappings.put("Credit Cards:Credit Cards Production", "personal-banking");
        containerMappings.put("Credit Cards:Everest Digital", "personal-banking");
        containerMappings.put("Credit Cards:PERSONAL/TDCT CARDS", "personal-banking");
        containerMappings.put("Credit Cards:Rewards MBNA", "personal-banking/credit-cards/MBNA");
        containerMappings.put("Brand", "Brand");
        containerMappings.put("Brand:Masterbrand Customer", "Brand/Customer/Masterbrand");
        containerMappings.put("Brand:Friends of the Environment Community", "Brand/Community/friends-of-the-environment");
        containerMappings.put("Brand:Pride Community", "Brand/Event/Pride");
        containerMappings.put("Brand:Financial Literacy Community", "Brand/Community/financial-literacy");
        containerMappings.put("Brand:Children's Literacy Community", "brand/community/children-literacy");
        containerMappings.put("Brand:Music Community", "Brand/Community/Music");
        containerMappings.put("Brand:Arts & Culture Community", "Brand/Community/arts-culture");
        containerMappings.put("Brand:Brand Community", "Brand/Community");
        containerMappings.put("Brand:Ethnic  Community", "Brand/Community/Ethnic");
        containerMappings.put("Brand:Local Area Marketing Regional", "Brand/Regional/local-area-marketing");
        containerMappings.put("Brand:Branch Flagship Regional", "Brand/Regional/branch-flagship");
        containerMappings.put("Brand:Music Sponsorship", "Brand/Community/Music");
        containerMappings.put("Brand:Blue Jays Sponsorship", "Brand/Sponsorship/blue-jays");
        containerMappings.put("Brand:Union Station Sponsorship", "Brand/Sponsorship/union-station");
        containerMappings.put("Brand:Brand Innovation & Functional", "Brand/innovation-functional");
        containerMappings.put("Brand:ATM Innovation & Functional", "Brand/innovation-functional");
        containerMappings.put("Brand:Direct Channel Innovation & Functional", "Brand/innovation-functional");
        containerMappings.put("Brand:Black History Month", "Brand/Event/black-history-month");
        containerMappings.put("Brand:Lunar New Year", "Brand/Event/lunar-new-year");
        containerMappings.put("Brand:Visual Art Community", "Brand/Community/arts-culture");
        containerMappings.put("Brand:Corporate Social Responsibility", "Brand/corporate-social-responsibility");
        containerMappings.put("Brand:Security Innovations", "Brand/innovation-and-functional/security-innovations");
        containerMappings.put("Brand:Brand Production", "Brand");
        containerMappings.put("Brand:Assets", "Brand");
        containerMappings.put("Insurance", "Insurance");
        containerMappings.put("Insurance:Home Insurance", "Insurance/general-insurance/Home");
        containerMappings.put("Insurance:Auto Insurance", "Insurance/general-insurance/Auto");
        containerMappings.put("Insurance:Home & Auto Insurance", "Insurance/general-insurance/home-auto");
        containerMappings.put("Insurance:HOME & AUTO INSURANCE - FSA", "Insurance/general-insurance/home-auto");
        containerMappings.put("Insurance:Term Insurance", "Insurance/life-health/term-life-insurance");
        containerMappings.put("Insurance:Life Insurance", "Insurance/life-health/life-insurance");
        containerMappings.put("Insurance:Term & Life Insurance", "Insurance/life-health/term-life-insurance");
        containerMappings.put("Insurance:Accident Insurance", "Insurance/life-health/accidental-death");
        containerMappings.put("Insurance:Travel Insurance", "Insurance/Travel");
        containerMappings.put("Insurance:AMG Insurance", "Insurance/general-insurance/home-auto/AMG");
        containerMappings.put("Insurance:Credit Protection", "Insurance/credit-protection");
        containerMappings.put("Insurance:Travel Insurance Snowbirds", "Insurance/general-insurance/home-auto/AMG");
        containerMappings.put("Insurance:Insurance Plug N Drive", "Insurance/general-insurance/Auto");
        containerMappings.put("Insurance:Insurance Auto Centre", "Insurance/general-insurance/Auto");
        containerMappings.put("Insurance:Insurance Content", "Insurance");
        containerMappings.put("Insurance:Insurance Production", "Insurance");
        containerMappings.put("Insurance:Life & Health Insurance ", "Insurance/life-health/life-insurance");
        containerMappings.put("Personal Banking", "personal-banking");
        containerMappings.put("Personal Banking:CHEQUING & SAVING EDB", "personal-banking/Accounts");
        containerMappings.put("Personal Banking:CHEQUING EDB", "personal-banking/Accounts");
        containerMappings.put("Personal Banking:SAVING EDB", "personal-banking/Accounts");
        containerMappings.put("Personal Banking:CROSS BORDER BANKING EDB", "personal-banking/Accounts");
        containerMappings.put("Personal Banking:NEW TO CANADA EDB", "personal-banking/Accounts");
        containerMappings.put("Personal Banking:NEW TO BANK EDB", "personal-banking/Accounts");
        containerMappings.put("Personal Banking:STUDENT", "personal-banking/Accounts");
        containerMappings.put("Personal Banking:PERSONAL BANKING PRODUCTION", "personal-banking");
        containerMappings.put("Personal Banking:Personal Lending EDB", "personal-banking/secured-loans");
        containerMappings.put("Personal Lending", "personal-banking/secured-loans/personal-loans");
        containerMappings.put("Personal Lending:SLOC", "personal-banking/secured-loans/SLOC");
        containerMappings.put("Personal Lending:ULOC", "personal-banking/secured-loans/ULOC");
        containerMappings.put("RESL", "personal-banking/Mortgages");
        containerMappings.put("RESL:Mortgage Mortgage", "personal-banking/Mortgages");
        containerMappings.put("RESL:Rate Sale", "personal-banking/Mortgages");
        containerMappings.put("RESL:RESL Preapproval", "personal-banking/Mortgages");
        containerMappings.put("RESL:RESL Production", "personal-banking/Mortgages");
        containerMappings.put("Small Business", "small-business-banking");
        containerMappings.put("Small Business:Accounts", "small-business-banking/Accounts");
        containerMappings.put("Small Business:Agriculture - Core Segments", "small-business-banking/service-options/industry-sector");
        containerMappings.put("Small Business:Business Credit Card", "small-business-banking/credit-cards");
        containerMappings.put("Small Business:Merchant Solutions", "merchant-solutions");
        containerMappings.put("Small Business:Investing", "small-business-banking/investment-plan");
        containerMappings.put("Small Business:Small Business Banking", "small-business-banking");
        containerMappings.put("TD-Auto-Finance", "personal-banking/secured-loans/auto-finance");
        containerMappings.put("TD-Auto-Finance:Customer", "personal-banking/secured-loans/auto-finance");
        containerMappings.put("TD-Auto-Finance:TD Auto Finance", "personal-banking/secured-loans/auto-finance");
        containerMappings.put("TD Internal Agency", "Insurance");
        containerMappings.put("TD Internal Agency:Affinity Marketing Group", "Insurance/general-insurance/home-auto/AMG");
        containerMappings.put("TD Internal Agency:Business Banking", "small-business-banking");
        containerMappings.put("TD Internal Agency:Content Marketing", "personal-banking");
        containerMappings.put("TD Internal Agency:Insurance", "Insurance/general-insurance");
        containerMappings.put("TD Internal Agency:Integrated Marketing Planning", "personal-banking");
        containerMappings.put("TD Internal Agency:Marketing Express", "personal-banking/service-options");
        containerMappings.put("TD Internal Agency:Merchant Services", "merchant-solutions");
        containerMappings.put("TD Internal Agency:Optimization / Relocation", "Brand/Regional");
        containerMappings.put("TD Internal Agency:Real-time Marketing", "Brand/Event/Pride");
        containerMappings.put("TD Internal Agency:Retail", "personal-banking");
        containerMappings.put("TD Internal Agency:TD Asset Management", "Wealth");
        containerMappings.put("TD Securities", "wholesale-banking");
        containerMappings.put("TD Securities:TD Securities Production", "wholesale-banking");
        containerMappings.put("Wealth", "Wealth");
        containerMappings.put("Wealth:Asset Management", "Wealth");
        containerMappings.put("Wealth:Brokerage / WebBroker / eServices", "Wealth/brokerage-account");
        containerMappings.put("Wealth:Direct Investing", "Wealth");
        containerMappings.put("Wealth:Financial Planning", "Wealth");
        containerMappings.put("Wealth:High Net Worth", "Wealth/wealth-partners");
        containerMappings.put("Wealth:Merit Club", "Wealth/wealth-partners");
        containerMappings.put("Wealth:Mutual Funds", "Wealth/mutual-funds");
        containerMappings.put("Wealth:Non Member Exceptions", "Wealth/wealth-partners");
        containerMappings.put("Wealth:Other PS&I", "Wealth/registered-plans");
        containerMappings.put("Wealth:President Club", "Wealth/wealth-partners");
        containerMappings.put("Wealth:Private Client Group", "Wealth/wealth-partners");
        containerMappings.put("Wealth:Private Investment Advice", "Wealth/wealth-partners");
        containerMappings.put("Wealth:Retail Investment Specialists", "Wealth/service-options");
        containerMappings.put("Wealth:TD Wealth Templates", "Wealth");
        containerMappings.put("Wealth:TDAM", "Wealth");
        containerMappings.put("Wealth:TFSA PS&I", "Wealth/registered-plans");
        containerMappings.put("Wealth:Wealth Advise", "Wealth/service-options");
        containerMappings.put("Windows", "personal-banking");
        containerMappings.put("Windows:All Windows 2", "personal-banking");
        containerMappings.put("Windows:Window 1 - All", "personal-banking");
        containerMappings.put("Windows:Window 1 - DI", "Wealth");
        containerMappings.put("Windows:Window 1 - PS&I", "Wealth/other-investments");
        containerMappings.put("Windows:Window 2 - RESL", "personal-banking/Mortgages");
        containerMappings.put("Digital Banking", "personal-banking/service-options");
        containerMappings.put("Digital Banking:Digital Banking", "personal-banking/service-options");
        containerMappings.put("Digital Banking:Digital Production", "personal-banking/service-options");

        return containerMappings;

    }

    public static String getPathFromContainer(String correctContainer) {

        HashMap<String, String> containerMappings = getContainerMappings();
        String pathStructure = "";

        correctContainer = correctContainer.split("\\$Containers:")[1];
        if (correctContainer.contains("MBNA") || correctContainer.contains("MBNA & CUETS")) {
            pathStructure = "personal-banking/credit-cards/MBNA";
        } else if (correctContainer.contains("TD:TD (Can)")) {
            correctContainer = correctContainer.split("TD:TD \\(Can\\):")[1];
            String[] correctContainerContents = correctContainer.split(":");
            String relevantPiece = "";
            if (correctContainerContents.length > 1) {
                 relevantPiece =  correctContainerContents[0] + ":" + correctContainerContents[1];
            } else {
                relevantPiece =  correctContainerContents[0];
            }
            pathStructure = containerMappings.get(relevantPiece) == null ? "IGNORE" : containerMappings.get(relevantPiece);
        } else {
            pathStructure = "IGNORE";
        }

        return pathStructure;

    }

    public static String getCorrectContainer(String containerField) {

        String currentContainer = "";
        if (containerField.contains("|")) {
            String[] fields = containerField.split("\\|");
            for (String field : fields) {
                if (field.contains("$Containers:")) {
                    if (currentContainer.equals("")) {
                        currentContainer = field;
                    } else {
                        int currentContainerSize = currentContainer.split(":").length;
                        int candidateContainerSize = field.split(":").length;
                        if (candidateContainerSize > currentContainerSize) {
                            currentContainer = field;
                        }
                    }
                }
            }
        } else {
            currentContainer = containerField;
        }
        return currentContainer;

    }

    public static HashMap<String, String> getLevel4AndCorrectPath(String containerField) {

        HashMap<String, String> level4AndCorrectPath = new HashMap<>();
        String correctContainer = getCorrectContainer(containerField);
        level4AndCorrectPath.put("level4", findLevel4(correctContainer.split(":")));
        level4AndCorrectPath.put("correctPath", getPathFromContainer(correctContainer));

        return level4AndCorrectPath;

    }

    /*
     * Structure of the Corrected Container: $Containers:TD:TD (Can):Credit Cards:EVEREST DIGITAL:...
     * Level 4 is 5th element.
     */
    public static String findLevel4(String[] containerLevels) {

        String level4 = "";
        if (containerLevels.length < 5) {
            level4 = "NO_LEVEL_4";
        } else {
            level4 = containerLevels[4];
        }
        return level4;

    }

    public static ArrayList<String> addKeywords(String level4) {

        ArrayList<String> taxonomy2KeywordsToAdd = new ArrayList<>();
        HashMap<String, String> taxonomy2KeysAndKeywords = new HashMap<>();
        taxonomy2KeysAndKeywords.put("Everest Digital", "Everest Digital");
        taxonomy2KeysAndKeywords.put("PERSONAL/TDCT CARDS", "Personal/TDCT Cards");
        taxonomy2KeysAndKeywords.put("Brand Production", "Production");
        taxonomy2KeysAndKeywords.put("Travel Insurance Snowbirds", "Snowbirds");
        taxonomy2KeysAndKeywords.put("Insurance Content", "Content");
        taxonomy2KeysAndKeywords.put("Insurance Production", "Production");
        taxonomy2KeysAndKeywords.put("CHEQUING & SAVING EDB", "Savings");
        taxonomy2KeysAndKeywords.put("CROSS BORDER BANKING EDB", "Cross border banking EDB");
        taxonomy2KeysAndKeywords.put("NEW TO CANADA EDB", "New to Canada");
        taxonomy2KeysAndKeywords.put("NEW TO BANK EDB", "New to Bank");
        taxonomy2KeysAndKeywords.put("PERSONAL BANKING PRODUCTION", "Production");
        taxonomy2KeysAndKeywords.put("Rate Sale", "Rate Sale");
        taxonomy2KeysAndKeywords.put("Content Marketing", "Content Marketing");
        taxonomy2KeysAndKeywords.put("Integrated Marketing Planning", " Integrated Marketing Planning");
        taxonomy2KeysAndKeywords.put("Marketing Express", "Marketing Express");
        taxonomy2KeysAndKeywords.put("Optimization / Relocation", "Optimization / Reloccation");
        taxonomy2KeysAndKeywords.put("Real-time Marketing", "Real-time Marketing");
        taxonomy2KeysAndKeywords.put("TD Securities Production", "TD Securities");
        taxonomy2KeysAndKeywords.put("Financial Planning", "Financial Planning");
        taxonomy2KeysAndKeywords.put("TD Wealth Templates", "TD Wealth Templates");
        taxonomy2KeysAndKeywords.put("All Windows 2", "Window");
        taxonomy2KeysAndKeywords.put("Window 1 - All", "Window");
        taxonomy2KeysAndKeywords.put("Window 1 - DI", "Window");
        taxonomy2KeysAndKeywords.put("Window 1 - PS&I", "Window");
        taxonomy2KeysAndKeywords.put("Window 2 - RESL", "Window");
        taxonomy2KeysAndKeywords.put("Digital Banking", "Digital Banking");
        taxonomy2KeysAndKeywords.put("Digital Production", "Digital Banking");
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
        taxonomy2KeysAndChannels.put("Direct Channel Innovation & Functional", "Direct Mail");
        taxonomy2KeysAndChannels.put("Digital Banking", "Digital");
        taxonomy2KeysAndChannels.put("Digital Production", "Digital");
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
