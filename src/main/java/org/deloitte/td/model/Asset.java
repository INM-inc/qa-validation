package org.deloitte.td.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Asset {

    private String activityProposalNumber;
    private String projectName;
    private String assetType;
    private ArrayList<String> keywords = new ArrayList<>();
    private String inMarketDate;
    private String expiryDate;
    private ArrayList<String> channels = new ArrayList<>();
    private String branchID;
    private String agencyName;
    private String agencyNameOther;
    private String agencyProjectID;
    private String description;
    private String language;
    private ArrayList<String> linesOfBusiness = new ArrayList<>();
    private String photoSource;
    private String usageRights;
    private String usageRightsOther;
    private String approvalStatus;
    private String imageWidth;
    private String imageHeight;
    private String resolutionHorizontal;
    private String resolutionVertical;
    private String photographer;
    private String dateFileCaptured;
    private String fileFormat;
    private String fileSize;
    private String dateRecordLastModified;
    private String dateFileCataloged;
    private String catalogedBy;
    private String fileName;
    private String container;
    private String sha;
    private String id;
    private boolean corrupted;
    private int csvLine;

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
        this.assetType = assetType;
    }

    public ArrayList<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(ArrayList<String> keywords) {
        this.keywords = keywords;
    }

    public String getInMarketDate() {
        return inMarketDate;
    }

    public void setInMarketDate(String inMarketDate) {
        this.inMarketDate = inMarketDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public ArrayList<String> getChannels() {
        return channels;
    }

    public void setChannels(ArrayList<String> channels) {
        this.channels = channels;
    }

    public String getBranchID() {
        return branchID;
    }

    public void setBranchID(String branchID) {
        this.branchID = branchID;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public String getAgencyNameOther() {
        return agencyNameOther;
    }

    public void setAgencyNameOther(String agencyNameOther) {
        this.agencyNameOther = agencyNameOther;
    }

    public String getAgencyProjectID() {
        return agencyProjectID;
    }

    public void setAgencyProjectID(String agencyProjectID) {
        this.agencyProjectID = agencyProjectID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public ArrayList<String> getLOBs() {
        return linesOfBusiness;
    }

    public void setLOBs(ArrayList<String> linesOfBusiness) {
        this.linesOfBusiness = linesOfBusiness;
    }

    public String getPhotoSource() {
        return photoSource;
    }

    public void setPhotoSource(String photoSource) {
        this.photoSource = photoSource;
    }

    public String getUsageRights() {
        return usageRights;
    }

    public void setUsageRights(String usageRights) {
        this.usageRights = usageRights;
    }

    public String getUsageRightsOther() {
        return usageRightsOther;
    }

    public void setUsageRightsOther(String usageRightsOther) {
        this.usageRightsOther = usageRightsOther;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(String imageWidth) {
        this.imageWidth = imageWidth;
    }

    public String getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(String imageHeight) {
        this.imageHeight = imageHeight;
    }

    public String getResolutionHorizontal() {
        return resolutionHorizontal;
    }

    public void setResolutionHorizontal(String resolutionHorizontal) {
        this.resolutionHorizontal = resolutionHorizontal;
    }

    public String getResolutionVertical() {
        return resolutionVertical;
    }

    public void setResolutionVertical(String resolutionVertical) {
        this.resolutionVertical = resolutionVertical;
    }

    public String getPhotographer() {
        return photographer;
    }

    public void setPhotographer(String photographer) {
        this.photographer = photographer;
    }

    public String getDateFileCaptured() {
        return dateFileCaptured;
    }

    public void setDateFileCaptured(String dateFileCaptured) {
        this.dateFileCaptured = dateFileCaptured;
    }

    public String getFileFormat() {
        return fileFormat;
    }

    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getDateRecordLastModified() {
        return dateRecordLastModified;
    }

    public void setDateRecordLastModified(String dateRecordLastModified) {
        this.dateRecordLastModified = dateRecordLastModified;
    }

    public String getDateFileCataloged() {
        return dateFileCataloged;
    }

    public void setDateFileCataloged(String dateFileCataloged) {
        this.dateFileCataloged = dateFileCataloged;
    }

    public String getCatalogedBy() {
        return catalogedBy;
    }

    public void setCatalogedBy(String catalogedBy) {
        this.catalogedBy = catalogedBy;
    }

    public String getContainer() {
        return container;
    }

    public void setContainer(String container) {
        this.container = container;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getSha() {
        return sha;
    }

    public void setSha(String sha) {
        this.sha = sha;
    }

    public boolean getCorrupted() {
        return corrupted;
    }

    public void setCorrupted(boolean corrupted) {
        this.corrupted = corrupted;
    }

    public int getCSVLine() {
        return csvLine;
    }

    public void setCSVLine(int csvLine) {
        this.csvLine = csvLine;
    }

    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }

}
