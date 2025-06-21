package com.qascript.Utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {
    private XSSFWorkbook workbook = null;
    private FileInputStream fis = null;
    private XSSFSheet sheet = null;
    private XSSFRow headerRow = null;
    private int colNum = -1;

    public ExcelUtils(String filepath) {
        try {
            fis = new FileInputStream(filepath);
            workbook = new XSSFWorkbook(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public List<String> readExcelData(String sheetName, String columnName) {
        List<String> columnData = new ArrayList<>();

        sheet = workbook.getSheet(sheetName);
        if (sheet == null) {
            System.out.println("Sheet not found: " + sheetName);
            return columnData;
        }

        headerRow = sheet.getRow(0);
        if (headerRow == null) {
            System.out.println("Header row is empty");
            return columnData;
        }

        // Find the column number for the given column name
        for (int i = 0; i < headerRow.getLastCellNum(); i++) {
            Cell cell = headerRow.getCell(i);
            if (cell != null && cell.getStringCellValue().trim().equalsIgnoreCase(columnName.trim())) {
                colNum = i;
                break;
            }
        }

        if (colNum == -1) {
            System.out.println("Column not found: " + columnName);
            return columnData;
        }

        // Read values from the column
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                Cell cell = row.getCell(colNum);
                if (cell != null) {
                    columnData.add(cell.toString());
                } else {
                    columnData.add("");
                }
            }
        }

        return columnData;
    }
}
