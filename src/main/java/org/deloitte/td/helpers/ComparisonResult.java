package org.deloitte.td.helpers;

import java.util.HashMap;
import java.util.Map;

public class ComparisonResult {

    private String cantoId;
    private String assetPath;
    private Map<String, Difference> differences;

    public class Difference {
        String cantoValue;
        String aemValue;

        public Difference(String cantoValue, String aemValue) {
            this.cantoValue = cantoValue;
            this.aemValue = aemValue;
        }

        public String getCantoValue() {
            return cantoValue;
        }

        public String getAemValue() {
            return aemValue;
        }
    }

    public ComparisonResult() {
        this.differences = new HashMap<>();
    }

    public String getCantoId() {
        return cantoId;
    }

    public void setCantoId(String cantoId) {
        this.cantoId = cantoId;
    }

    public String getAssetPath() {
        return assetPath;
    }

    public void setAssetPath(String assetPath) {
        this.assetPath = assetPath;
    }

    public Map<String, Difference> getDifferences() {
        return differences;
    }

    public void setDifferences(Map<String, Difference> differences) {
        this.differences = differences;
    }
}
