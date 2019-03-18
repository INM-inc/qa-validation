package org.deloitte.td.helpers;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WriteResultsToExcel {

    public static void writeResultsToExcel (HashMap<String, String> filesAndDifferences) {

        // Location and Column Names.
        String excelLocation = "/Users/averzea/Downloads/qa_results.xlsx";
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
            FileOutputStream fileOut = new FileOutputStream(excelLocation);
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();
        } catch (IOException e) {
            System.out.println("Failed: " + e.toString());
        }

    }

}
