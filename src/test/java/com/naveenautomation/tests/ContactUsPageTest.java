package com.naveenautomation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.pages.ContactUsPage;
import com.naveenautomation.pages.MyAccountPage;
import com.naveenautomation.pages.RegisterAccountPage;
import com.naveenautomation.testbase.TestBase;

public class ContactUsPageTest extends TestBase {
	RegisterAccountPage registerAccountPage;
	MyAccountPage myAccountPage;
	ContactUsPage contactPage;

	@BeforeMethod
	public void launchBrowser() {
		intialisation();
		registerAccountPage = new RegisterAccountPage();
		myAccountPage = registerAccountPage.registerAccount(getFirstName(), getLastName(), getPhoneNo(), getEmail(),
				getPassword());
		contactPage = myAccountPage.clickOnContactBtn();
	}

	@Test(priority = 1)
	public void verifyContactPageTitleTest() {
		String contactPageTitle = contactPage.verifyContactPageTitle();
		Assert.assertEquals(contactPageTitle, "Contact Us", "Actual title does not match the expected title.");
	}

	@Test(priority = 2)
	public void verifySubmitContactDetailsTest() {

		String successPageMsg = contactPage.submitContactDetails("This is test enquiry.");
		Assert.assertEquals(successPageMsg, "Your enquiry has been successfully sent to the store owner!",
				"Test Failed - Landing page success message did not match.");
		// Assert.assertEquals(landingEnquirySuccessPageTitle, "Contact Us", "Test
		// Failed - Landing page titles did not match.");
		// this is a testing website so the title of every page is not unique.
	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

}
