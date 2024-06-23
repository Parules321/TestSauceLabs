package com.naveenautomation.tests;

import java.net.MalformedURLException;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.pages.AccountLoginPage;
import com.naveenautomation.pages.AccountLogoutPage;
import com.naveenautomation.pages.MyAccountPage;
import com.naveenautomation.testbase.TestBase;
import com.naveenautomation.utility.DataProviderUtils;

public class AccountLogoutPageTest extends TestBase {
	AccountLoginPage loginPage;
	MyAccountPage accountPage;
	AccountLogoutPage logoutPage;

	@BeforeMethod
	public void launchBrowser() throws MalformedURLException {
		intialization();
		loginPage = new AccountLoginPage();
	}

	@Test (dataProvider = "validLoginData", dataProviderClass = DataProviderUtils.class)
	public void validateSignOutFromMyAccountDropDwn(String username, String password) {
		accountPage = loginPage.submitCorrectLoginInfo(username, password);
		logoutPage = accountPage.clickMyAccountLogOutBtn();
		String logoutText = logoutPage.getLogoutMsgText();
//		Alert alert = getDriverCopy().switchTo().alert();
//		alert.sendKeys("just testing alerts");
		Assert.assertEquals("Account Logout", logoutText);
	}

	@Test (dataProvider = "validLoginData", dataProviderClass = DataProviderUtils.class)
	public void validateSignOutFromSideMenuBtn(String username, String password) {
		accountPage = loginPage.submitCorrectLoginInfo(username, password);
		logoutPage = accountPage.clickSideNavLogOutBtn();
		String logoutText = logoutPage.getLogoutMsgText();
		System.out.println("Always use soft assert.");
		Assert.assertEquals("Account Logout", logoutText);
		
	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}
}