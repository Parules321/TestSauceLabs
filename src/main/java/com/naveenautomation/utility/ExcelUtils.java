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
	
	public static XSSFWorkbook wbCopy;

	// Represent the Individual sheet
	public static XSSFSheet ws;

	// Represent the Rows of the sheet
	public static XSSFRow row;

	// Represent the cells of the sheet
	public static XSSFCell cell;
	
	 private static ThreadLocal<XSSFWorkbook> workBook = new ThreadLocal<>();

	    public static XSSFWorkbook getWorkbook(String filePath) throws IOException {
	        wb = workBook.get();
	        if (wb == null) {
	           FileInputStream is = new FileInputStream(filePath);
	                wb= new XSSFWorkbook(is);
	                workBook.set(wb);
	            }
	        return wb;
	    }

	    public static void closeWorkbook(String filePath) throws IOException {      
	         getWorkbook(filePath).close();        
	        }
	
	public static int getRowCount(String xFile, String sheetName) throws IOException {
		int lastRowNo = 0;
		ws = getWorkbook(xFile).getSheet(sheetName);
		lastRowNo = ws.getLastRowNum();
		return lastRowNo;
	}

	public static int getColumnCount(String xFile, String sheetName, int lastRowNo) throws IOException {
		int lastColCount = 0;
		ws = getWorkbook(xFile).getSheet(sheetName);
		row = ws.getRow(lastRowNo);
		lastColCount = row.getLastCellNum();
		return lastColCount;
	}

	public static String getCellValue(String xFile, String sheetName, int rowNo, int colCount) throws IOException {
		String data = "";
		ws = getWorkbook(xFile).getSheet(sheetName);
		row = ws.getRow(rowNo);
		cell = row.getCell(colCount);
		data = new DataFormatter().formatCellValue(cell); // returns the cell value formatted as string
		getWorkbook(xFile).close();
		return data;
	}

}
