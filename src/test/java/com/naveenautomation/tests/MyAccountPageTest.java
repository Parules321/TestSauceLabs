package com.naveenautomation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.pages.MyAccountPage;
import com.naveenautomation.pages.RegisterAccountPage;
import com.naveenautomation.testbase.TestBase;

public class MyAccountPageTest extends TestBase {
	RegisterAccountPage registerAccountPage;
	MyAccountPage myAccountPage;

	@BeforeMethod
	public void launchBrowser() {
		intialisation();
		registerAccountPage = new RegisterAccountPage();
		myAccountPage = registerAccountPage.registerAccount(getFirstName(), getLastName(), getPhoneNo(), getEmail(),
				getPassword());
	}

	@Test(priority = 1)
	public void verifyMyAccountPageTitleTest() {
		String accountPageTitle = myAccountPage.verifyMyAccountPageTitle();
		Assert.assertEquals(accountPageTitle, "My Account", "Actual title does not match the expected title.");
	}

	@Test(priority = 2)
	public void validateContactBtnClickTest() {
		myAccountPage.clickOnContactBtn();
		String landingContactPageTitle = driver.getTitle();
		Assert.assertEquals(landingContactPageTitle, "Contact Us", "Test Failed - Landing page titles did not match.");
	}

	@Test(priority = 3)
	public void validateGiftCertificateBtnClickTest() {
		myAccountPage.clickOnGiftCerificateBtn();
		String landingGiftPageTitle = driver.getTitle();
		Assert.assertEquals(landingGiftPageTitle, "Purchase a Gift Certificate",
				"Test Failed - Landing page titles did not match.");
	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}
}
