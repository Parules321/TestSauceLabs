package com.naveenautomation.utility;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderUtils {

	@DataProvider(name = "validAddressData")
	private String[][] validAddressDataProvider() throws IOException {
		String filePath = "./src/main/java/resources/AccountUpdateInfo.xlsx";
	//	ExcelUtils.getFile(filePath);
		int rowCount = ExcelUtils.getRowCount(filePath, "address");
		int colCount = ExcelUtils.getColumnCount(filePath, "address", rowCount);
		String[][] userAccountData = new String[rowCount][colCount];
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				userAccountData[i - 1][j] = ExcelUtils.getCellValue(filePath, "address", i, j);
			}
		}
		ExcelUtils.closeWorkbook(filePath);
		return userAccountData;
	}
	
	@DataProvider(name = "validLoginData")
	private String[][] loginInfoProvider() throws IOException {
		String filePath = "./src/main/java/resources/LoginDetails.xlsx";
	//	ExcelUtils.getFile(filePath);
		int rowCount = ExcelUtils.getRowCount(filePath, "validDetails");
		int colCount = ExcelUtils.getColumnCount(filePath, "validDetails", rowCount);
		String[][] loginData = new String[rowCount][colCount];
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				loginData[i - 1][j] = ExcelUtils.getCellValue(filePath, "validDetails", i, j);
			}
		}
		ExcelUtils.closeWorkbook(filePath);
		return loginData;
	}

	
}
