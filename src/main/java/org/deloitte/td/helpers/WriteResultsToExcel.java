package org.deloitte.td.helpers;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class WriteResultsToExcel {

    private static Map<String, String> headerMap;

    static {
        headerMap = new LinkedHashMap<>();
        headerMap.put("td:apn", "AP (Activity Proposal) Number");
        headerMap.put("td:projectname", "Project Name");
        headerMap.put("td:assettype", "Asset Type");
        headerMap.put("td:keywords", "Keywords");
        headerMap.put("td:inmarket", "In Market");
        headerMap.put("td:expiry", "Expiry Date");
        headerMap.put("td:channel", "Channel");
        headerMap.put("td:branchid", "Branch ID");
        headerMap.put("td:agency", "Agency Name");
        headerMap.put("td:agencypid", "Agency Project ID");
        headerMap.put("dc:description", "Description");
        headerMap.put("td:language", "Language");
        headerMap.put("td:lob", "Line Of Business");
        headerMap.put("td:photosource", "Photo Source");
        headerMap.put("td:usageright", "Usage Rights");
        headerMap.put("td:approval", "Approval Status");
        headerMap.put("tiff:ImageWidth", "Image Width");
        headerMap.put("tiff:ImageLength", "Image Height");
        headerMap.put("tiff:XResolution", "Resolution (Horizontal)");
        headerMap.put("tiff:YResolution", "Resolution (Vertical)");
        headerMap.put("dc:creator", "Photographer or Creator");
        headerMap.put("td:datefilecaptured", "Date File Captured");
        headerMap.put("dam:FileFormat", "File Format");
        headerMap.put("dam:size", "File Size");
        headerMap.put("dc:modified", "Date Record Last Modified");
        headerMap.put("td:catalogued", "Date File Cataloged");
        headerMap.put("td:cataloguedby", "Cataloged By");
    }

    public static void writeHeader(String fileLocation, boolean detailed) {
        BufferedWriter bufferedWriter = null;
        FileOutputStream fileOutputStream = null;
        OutputStreamWriter outputStreamWriter = null;

        try {
            File file = new File(fileLocation);
            fileOutputStream = new FileOutputStream(file);
            outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            bufferedWriter = new BufferedWriter(outputStreamWriter);

            bufferedWriter.write("Canto ID\tMissing in AEM?\tAEM Path");
            for (String key : headerMap.keySet()) {
                if (!detailed) {
                    bufferedWriter.write("\t" + headerMap.get(key));
                } else {
                    bufferedWriter.write("\t" + headerMap.get(key) + "-Canto\t" + headerMap.get(key) + "-AEM");
                }
            }
            bufferedWriter.newLine();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStreamWriter != null) {
                try {
                    outputStreamWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void writeResult(ComparisonResult result, String fileLocation, boolean detailed) {
        BufferedWriter bufferedWriter = null;
        FileOutputStream fileOutputStream = null;
        OutputStreamWriter outputStreamWriter = null;

        try {
            File file = new File(fileLocation);
            fileOutputStream = new FileOutputStream(file, true);
            outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            bufferedWriter = new BufferedWriter(outputStreamWriter);

            bufferedWriter.write(result.getCantoId() + "\t" + result.getMissingInAEM() + "\t" + result.getAssetPath());
            for (String key : headerMap.keySet()) {
                if (result.getDifferences().containsKey(key)) {
                    ComparisonResult.Difference difference = result.getDifferences().get(key);
                    if (!detailed) {
                        bufferedWriter.write("\tDifferent");
                    } else {
                        bufferedWriter.write("\t" + difference.getCantoValue() + "\t" + difference.getAemValue());
                    }
                } else {
                    if (!detailed) {
                        bufferedWriter.write("\t");
                    } else {
                        bufferedWriter.write("\t\t");
                    }
                }
            }
            bufferedWriter.newLine();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStreamWriter != null) {
                try {
                    outputStreamWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void writeResultsToExcel (String excelLocation, HashMap<String, String> filesAndDifferences, int iteration) {

        System.out.println("Start of writing results to Excel for BATCH " + iteration);

        // Column Names.
        String[] excelColumns = {"File Path in AEM", "Metadata Fields Different"};

        // Create a Workbook for generating a .xlsx file.
        Workbook workbook = new XSSFWorkbook();

        // Create a Sheet.
        Sheet sheet = workbook.createSheet("QA Results");

        // Create a Font for styling header cells.
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.BLACK.getIndex());

        // Create a CellStyle with the font.
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        // Create a Row.
        Row headerRow = sheet.createRow(0);

        // Create cells.
        for(int i = 0; i < excelColumns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(excelColumns[i]);
            cell.setCellStyle(headerCellStyle);
        }

        // Create rows with AEM Path of Asset and Metadata Differences.
        int rowNum = 1;
        for (Map.Entry<String, String> fileAndDifferences : filesAndDifferences.entrySet()) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(fileAndDifferences.getKey());
            row.createCell(1).setCellValue(fileAndDifferences.getValue());
        }

        // Resize all columns to fit the content size.
        for(int i = 0; i < excelColumns.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Write the output to a file and close the workbook. If fails, print out the exception.
        try {
            FileOutputStream fileOut = new FileOutputStream(excelLocation + ".xlsx");
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();
        } catch (IOException e) {
            System.out.println("Failed: " + e.toString());
        }

        System.out.println("End of writing results to Excel for BATCH " + iteration);

    }

}
