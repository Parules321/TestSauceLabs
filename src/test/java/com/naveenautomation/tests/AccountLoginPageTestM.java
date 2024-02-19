package com.naveenautomation.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.pages.AccountLoginPageM;
import com.naveenautomation.testbase.TestBase;

public class AccountLoginPageTestM extends TestBase {
	AccountLoginPageM loginPage;

	@BeforeMethod
	public void launchBrowser() {
		intialisation();
		loginPage = new AccountLoginPageM();
	}

	@Test
	public void validateLogin() {
		
		loginPage.submitLogin("mansan@gmail.com", "Password1");
	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}
}
