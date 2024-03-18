package com.naveenautomation.utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	// Represent the location of the excel sheet
	public static FileInputStream fi;

	// Represent the Whole excel sheet
	public static XSSFWorkbook wb;

	// Represent the Individual sheet
	public static XSSFSheet ws;

	// Represent the Rows of the sheet
	public static XSSFRow row;

	// Represent the cells of the sheet
	public static XSSFCell cell;

	public static int getRowCount(String xFile, String sheetName) throws IOException {
		int lastRowNo = 0;
		// Fetch the file
		fi = new FileInputStream(xFile);
		// Initialize the Work Book
		wb = new XSSFWorkbook(fi);
		// Get the sheet from Work book
		ws = wb.getSheet(sheetName);
		// Get the last row.
		lastRowNo = ws.getLastRowNum();

		wb.close();
		fi.close();
		return lastRowNo;
	}
	public static int getColumnCount(String xFile, String sheetName, int lastRowNo) throws IOException {

		int lastColCount = 0;
		// Fetch the file
		fi = new FileInputStream(xFile);
		// Initialize the Work Book
		wb = new XSSFWorkbook(fi);
		// Get the last row.
		ws = wb.getSheet(sheetName);

		row = ws.getRow(lastRowNo);
		lastColCount = row.getLastCellNum();
		wb.close();
		fi.close();
		return lastColCount;
	}

	public static String getCellValue(String xFile, String sheetName, int rowNo, int colCount) throws IOException {
		String data = "";
		fi = new FileInputStream(xFile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheetName);
		row = ws.getRow(rowNo);
		cell = row.getCell(colCount);
		data = new DataFormatter().formatCellValue(cell); // returns the cell value formatted as string
		return data;
	}
	// self practice
	public static String[][] getEachCellValue(String xFile, String sheetName) throws IOException {
		// String data = "";
		fi = new FileInputStream(xFile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheetName);
		int rowNo = ws.getLastRowNum();
		row = ws.getRow(rowNo);
		int colCount = row.getLastCellNum();
		String[][] data = new String[rowNo + 1][colCount];
		for (int i = 1; i <rowNo+1; i++) {
			for (int j = 0; j < colCount; j++) {
				XSSFRow currentRow = ws.getRow(i);
				XSSFCell cell = currentRow.getCell(j);
				data[i][j] = new DataFormatter().formatCellValue(cell);
				System.out.println(data[i][j]);
			}
		}
		return data;

	}

}
