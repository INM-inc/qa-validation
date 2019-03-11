package org.deloitte.td.dto;

public class MigrationDto {
  private String id;
  private String containers;
  private String fileName;
  private String filesize;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getContainers() {
    return containers;
  }

  public void setContainers(String containers) {
    this.containers = containers;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public String getFilesize() {
    return filesize;
  }

  public void setFilesize(String filesize) {
    this.filesize = filesize;
  }
}
