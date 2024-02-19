package com.naveenautomation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.pages.RegisterAccountPage;
import com.naveenautomation.testbase.TestBase;

public class RegisterAccountPageTest extends TestBase {
	RegisterAccountPage registerAccountPage;

	@BeforeMethod
	public void launchBrowser() {
		intialisation();
		registerAccountPage = new RegisterAccountPage();
	}

	@Test
	public void validateRegistrationTest() {
		registerAccountPage.registerAccount(getFirstName(), getLastName(), getPhoneNo(), getEmail(), getPassword());
		String landingAccntPageTitle = driver.getTitle();
		Assert.assertEquals(landingAccntPageTitle, "My Account", "Test Failed - Landing page titles did not match.");
	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}
}
