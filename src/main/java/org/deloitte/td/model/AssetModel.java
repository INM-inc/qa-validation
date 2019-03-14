package org.deloitte.td.model;

import java.util.ArrayList;
import java.util.HashMap;

public class AssetModel {

    private HashMap<String, String> activityProposalNumber = new HashMap<>();
    private HashMap<String, String> projectName = new HashMap<>();
    private HashMap<String, String> assetType = new HashMap<>();
    private HashMap<String, ArrayList<String>> keywords = new HashMap<>();
    private HashMap<String, String> inMarketDate = new HashMap<>();
    private HashMap<String, String> expiryDate = new HashMap<>();
    private HashMap<String, ArrayList<String>> channels = new HashMap<>();
    private HashMap<String, String> branchID = new HashMap<>();
    private HashMap<String, String> agencyName = new HashMap<>();
    private HashMap<String, String> agencyProjectID = new HashMap<>();
    private HashMap<String, String> description = new HashMap<>();
    private HashMap<String, String> language = new HashMap<>();
    private HashMap<String, ArrayList<String>> linesOfBusiness = new HashMap<>();
    private HashMap<String, String> photoSource = new HashMap<>();
    private HashMap<String, String> usageRights = new HashMap<>();
    private HashMap<String, String> approvalStatus = new HashMap<>();
    private HashMap<String, String> imageWidth = new HashMap<>();
    private HashMap<String, String> imageHeight = new HashMap<>();
    private HashMap<String, String> resolutionHorizontal = new HashMap<>();
    private HashMap<String, String> resolutionVertical = new HashMap<>();
    private HashMap<String, String> photographer = new HashMap<>();
    private HashMap<String, String> dateFileCaptured = new HashMap<>();
    private HashMap<String, String> fileFormat = new HashMap<>();
    private HashMap<String, String> fileSize = new HashMap<>();
    private HashMap<String, String> dateRecordLastModified = new HashMap<>();
    private HashMap<String, String> dateFileCataloged = new HashMap<>();
    private String taxonomy2NewPath;

    public HashMap<String, String> getActivityProposalNumber() {
        return activityProposalNumber;
    }

    public void setActivityProposalNumber(String activityProposalNumber) {
        this.activityProposalNumber.put("AP (Activity Proposal) Number", activityProposalNumber);
    }

    public HashMap<String, String> getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName.put("Project Name", projectName);
    }

    public HashMap<String, String> getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType.put("Asset Type", assetType);
    }

    public HashMap<String, ArrayList<String>> getKeywords() {
        return keywords;
    }

    public void setKeywords(ArrayList<String> keywords) {
        this.keywords.put("Keywords", keywords);
    }

    public HashMap<String, String> getInMarketDate() {
        return inMarketDate;
    }

    public void setInMarketDate(String inMarketDate) {
        this.inMarketDate.put("In Market", inMarketDate);
    }

    public HashMap<String, String> getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate.put("Expiry Date", expiryDate);
    }

    public HashMap<String, ArrayList<String>> getChannels() {
        return channels;
    }

    public void setChannels(ArrayList<String> channels) {
        this.channels.put("Channel", channels);
    }

    public HashMap<String, String> getBranchID() {
        return branchID;
    }

    public void setBranchID(String branchID) {
        this.branchID.put("Branch ID", branchID);
    }

    public HashMap<String, String> getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName.put("Agency Name", agencyName);
    }

    public HashMap<String, String> getAgencyProjectID() {
        return agencyProjectID;
    }

    public void setAgencyProjectID(String agencyProjectID) {
        this.agencyProjectID.put("Agency Project ID", agencyProjectID);
    }

    public HashMap<String, String> getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description.put("Description", description);
    }

    public HashMap<String, String> getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language.put("Language", language);
    }

    public HashMap<String, ArrayList<String>> getLOBs() {
        return linesOfBusiness;
    }

    public void setLOBs(ArrayList<String> linesOfBusiness) {
        this.linesOfBusiness.put("Line Of Business", linesOfBusiness);
    }

    public HashMap<String, String> getPhotoSource() {
        return photoSource;
    }

    public void setPhotoSource(String photoSource) {
        this.photoSource.put("Photo Source", photoSource);
    }

    public HashMap<String, String> getUsageRights() {
        return usageRights;
    }

    public void setUsageRights(String usageRights) {
        this.usageRights.put("Usage Rights", usageRights);
    }

    public HashMap<String, String> getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus.put("Approval Status", approvalStatus);
    }

    public HashMap<String, String> getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(String imageWidth) {
        this.imageWidth.put("Image Width", imageWidth);
    }

    public HashMap<String, String> getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(String imageHeight) {
        this.imageHeight.put("Image Height", imageHeight);
    }

    public HashMap<String, String> getResolutionHorizontal() {
        return resolutionHorizontal;
    }

    public void setResolutionHorizontal(String resolutionHorizontal) {
        this.resolutionHorizontal.put("Resolution (Horizontal)", resolutionHorizontal);
    }

    public HashMap<String, String> getResolutionVertical() {
        return resolutionVertical;
    }

    public void setResolutionVertical(String resolutionVertical) {
        this.resolutionVertical.put("Resolution (Vertical)", resolutionVertical);
    }

    public HashMap<String, String> getPhotographer() {
        return photographer;
    }

    public void setPhotographer(String photographer) {
        this.photographer.put("Photographer or Creator", photographer);
    }

    public HashMap<String, String> getDateFileCaptured() {
        return dateFileCaptured;
    }

    public void setDateFileCaptured(String dateFileCaptured) {
        this.dateFileCaptured.put("Date File Captured", dateFileCaptured);
    }

    public HashMap<String, String> getFileFormat() {
        return fileFormat;
    }

    public void setFileFormat(String fileFormat) {
        this.fileFormat.put("File Format", fileFormat);
    }

    public HashMap<String, String> getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize.put("File Size", fileSize);
    }

    public HashMap<String, String> getDateRecordLastModified() {
        return dateRecordLastModified;
    }

    public void setDateRecordLastModified(String dateRecordLastModified) {
        this.dateRecordLastModified.put("Date Record Last Modified", dateRecordLastModified);
    }

    public HashMap<String, String> getDateFileCataloged() {
        return dateFileCataloged;
    }

    public void setDateFileCataloged(String dateFileCataloged) {
        this.dateFileCataloged.put("Date File Cataloged", dateFileCataloged);
    }

    public String getTaxonomy2NewPath() {
        return taxonomy2NewPath;
    }

    public void setTaxonomy2NewPath(String taxonomy2NewPath) {
        this.taxonomy2NewPath = taxonomy2NewPath;
    }

}
