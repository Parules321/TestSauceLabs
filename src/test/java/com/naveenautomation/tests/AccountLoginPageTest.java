package com.naveenautomation.tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.naveenautomation.pages.AccountLoginPage;
import com.naveenautomation.testbase.TestBase;
import com.naveenautomation.utility.ExcelUtils;

public class AccountLoginPageTest extends TestBase {

	@BeforeMethod
	public void launchBrowser() {
		intialisation();
	}

	@Test
	public void validateGetEachCellValue() throws IOException {

		ExcelUtils.getEachCellValue("./LoginData.xlsx", "Sheet1");

	}

	@Test(dataProvider = "LoginData", dataProviderClass = com.naveenautomation.utility.DataProviderUtils.class)
	public void validateLogin(String username, String password) {
		AccountLoginPage page = new AccountLoginPage();
		page.submitLogin(username, password);
	}

//	@DataProvider(name = "LoginData")
//	private String[][] loginInfoProvider() throws IOException {
//		String filePath = "./LoginData.xlsx";
//		int rowCount = ExcelUtils.getRowCount(filePath, "Sheet1");// since row count is zero based and cell count starts
//																	// from 1, the length of rows and columns in 2D
//																	// array will be rowcount and columncount as row in
//																	// 2D array is actually 1 less than the number of
//																	// rows in actual sheet with header.
//		int colCount = ExcelUtils.getColumnCount(filePath, "Sheet1", rowCount);
//		String[][] loginData = new String[rowCount][colCount];// empty 2 dimensional array will be initialized here
//		for (int i = 1; i <= rowCount; i++) {
//			for (int j = 0; j < colCount; j++) {
//				loginData[i - 1][j] = ExcelUtils.getCellValue(filePath, "Sheet1", i, j); // populating the 2D array.
//																							// Here we need to store
//																							// data in 2D array where
//																							// corresponding rows of 2D
//																							// array will always be 1
//																							// less than the row in
//																							// actual file, hence this
//																							// logic.
//			}
//		}
//		return loginData;
//	}

	@DataProvider(name = "LoginData2")
	private String[][] loginInfoProvider2()  {

		String[][] loginData = new String[2][2];

		loginData[0][0] = "Parul";
		loginData[0][1] = "Shukla";
		loginData[1][0] = "Ankit";
		loginData[1][1] = "Vishnoi";
		return loginData;
	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

}