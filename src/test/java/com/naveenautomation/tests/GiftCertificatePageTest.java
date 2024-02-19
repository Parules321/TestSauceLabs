package com.naveenautomation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.pages.ContactUsPage;
import com.naveenautomation.pages.GiftCertificatePage;
import com.naveenautomation.pages.MyAccountPage;
import com.naveenautomation.pages.RegisterAccountPage;
import com.naveenautomation.testbase.TestBase;

public class GiftCertificatePageTest extends TestBase {
	RegisterAccountPage registerAccountPage;
	MyAccountPage myAccountPage;
	GiftCertificatePage giftPage;

	@BeforeMethod
	public void launchBrowser() {
		intialisation();
		registerAccountPage = new RegisterAccountPage();
		myAccountPage = registerAccountPage.registerAccount(getFirstName(), getLastName(),getPhoneNo(), getEmail(), getPassword());
		giftPage = myAccountPage.clickOnGiftCerificateBtn();
	}

	@Test(priority = 1)
	public void verifyGiftPageTitleTest() {
		String giftPageTitle = giftPage.verifyGiftPageTitle();
		Assert.assertEquals(giftPageTitle, "Purchase a Gift Certificate",
				"Actual title does not match the expected title.");
	}

	@Test(priority = 2)
	public void verifySubmitGiftDetailsTest() {
		String actualGiftSuccessPageMsg = giftPage.submitGiftPurchaseDetails(getRecipientName(), getRecipientEmail(),
				getAmount());
		Assert.assertEquals(actualGiftSuccessPageMsg,
				"Thank you for purchasing a gift certificate! Once you have completed your order your gift certificate recipient will be sent an e-mail with details how to redeem their gift certificate.",
				"Test Failed - Landing page success message did not match.");
		
	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

}
