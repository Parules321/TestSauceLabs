package com.naveenautomation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.pages.AccountLoginPage;
import com.naveenautomation.pages.ChangePwdPage;
import com.naveenautomation.pages.MyAccountPage;
import com.naveenautomation.testbase.TestBase;

public class MyAccountPageTest extends TestBase {

	AccountLoginPage page;
	MyAccountPage myAccountPage;
	ChangePwdPage changePwdPage;

	@BeforeMethod
	public void launchBrowser() {
		intialisation();
		page = new AccountLoginPage();
	}

	@Test (enabled = false)
	public void validateLogin() {
		AccountLoginPage page = new AccountLoginPage();
		myAccountPage = page.submitLogin("dean@gmail.com", "dean");
		String myAccountText = myAccountPage.getMyAccountText();
		Assert.assertEquals(myAccountText, "My Account1");
	}

	@Test (enabled = false)
	public void validatePasswordUpdate() {

		// Login in
		myAccountPage = page.submitLogin("dean@gmail.com", "dean");
		// Updating Password
		changePwdPage = myAccountPage.clickChangePasswordBtn();
		// Updating Password
		myAccountPage = changePwdPage.updatePassword("dean", "dean");

		String pwdAlertMessage = myAccountPage.getPasswordUpdateAlertText();

		// Asserting whether password change is successfully or not
		Assert.assertEquals("Success: Your password has been successfully updated.", pwdAlertMessage);

	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

}