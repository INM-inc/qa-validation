package org.deloitte.td.model;

public class AssetModel {

    private String activityProposalNumber;
    private String projectName;
    private String assetType;
    private String keywords;
    private String inMarket;
    private String alwaysOn;
    private String expiryDate;
    private String channel;
    private String branchID;
    private String mediaTraffickingAssetName;

    public String getActivityProposalNumber() {
        return activityProposalNumber;
    }
    public void setActivityProposalNumber(String activityProposalNumber) {
        this.activityProposalNumber = activityProposalNumber;
    }

    public String getProjectName() {
        return projectName;
    }
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }


    public String getAssetType() {
        return assetType;
    }
    public void setAssetType(String assetType) {
        this.projectName = assetType;
    }

    public String[] getKeywords() {
        return keywords;
    }
    public void setKeywords(String[] keywords) {
        this.keywords = keywords;
    }

    public String getInMarket() {
        return inMarket;
    }
    public void setInMarket(String inMarket) {
        this.projectName = inMarket;
    }

    public String getAlwaysOn() {
        return alwaysOn;
    }
    public void setAlwaysOn(String alwaysOn) {
        this.alwaysOn = alwaysOn;
    }

    public String getExpiryDate() {
        return expiryDate;
    }
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getChannel() {
        return channel;
    }
    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getBranchID() {
        return branchID;
    }
    public void setBranchID(String branchID) {
        this.branchID = branchID;
    }

    public String getMediaTraffickingAssetName() {
        return mediaTraffickingAssetName;
    }
    public void setMediaTraffickingAssetName(String mediaTraffickingAssetName) {
        this.mediaTraffickingAssetName = mediaTraffickingAssetName;
    }

}
