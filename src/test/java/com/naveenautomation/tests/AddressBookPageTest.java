package com.naveenautomation.tests;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.pages.AccountLoginPage;
import com.naveenautomation.pages.AddAddressPage;
import com.naveenautomation.pages.AddressBookPage;
import com.naveenautomation.pages.MyAccountPage;
import com.naveenautomation.testbase.TestBase;
import com.naveenautomation.utility.DataProviderUtils;

public class AddressBookPageTest extends TestBase {
	AccountLoginPage loginPage;
	MyAccountPage accountPage;
	AddressBookPage addressBookPage;
	AddAddressPage addAddressPage;

	@BeforeMethod
	public void launchBrowser() throws MalformedURLException {
		intialization();
		loginPage = new AccountLoginPage();
	}

	@Test (dataProvider = "validAddressData", dataProviderClass = DataProviderUtils.class)
	public void validateSubmitAddress(String username, String password, String firstName, String lastName, String city, String address, String postalCode, String country, String zone, String countryValue, String zoneValue
) {
		accountPage = loginPage.submitCorrectLoginInfo(username, password);
		addressBookPage = accountPage.clickAddressBookBtn();
		addAddressPage = addressBookPage.clickAddNewAddressBtn();
		addressBookPage = addAddressPage.submitAddress(firstName, lastName, city, address, postalCode, country,
				zone, countryValue, zoneValue);
		String addressUpdateAlertText = addressBookPage.getAddressUpdateAlertText();
		Assert.assertEquals(addressUpdateAlertText, "Your address has been successfully added");

	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

}
