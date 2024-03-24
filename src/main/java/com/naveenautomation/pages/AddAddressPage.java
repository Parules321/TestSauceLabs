package com.naveenautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.testbase.TestBase;
import com.naveenautomation.utility.ExplicitWaitUtil;
import com.naveenautomation.utility.Utility;

public class AddAddressPage extends TestBase {
	public AddAddressPage() {
		PageFactory.initElements(getDriverCopy(), this);
	}

	@FindBy(id = "input-firstname")
	WebElement firstNameInputBox;

	@FindBy(id = "input-lastname")
	WebElement lastNameInputBox;

	@FindBy(id = "input-address-1")
	WebElement addressInputBox;

	@FindBy(id = "input-city")
	WebElement cityInputBox;

	@FindBy(id = "input-postcode")
	WebElement postCodeInputBox;

	@FindBy(id = "input-country")
	WebElement countryInputBox;

	@FindBy(id = "input-zone")
	WebElement regionInputBox;

	@FindBy(css = ".btn-primary")
	WebElement continueBtn;

	@FindBy(css = "div.text-danger")
	WebElement incompleteAddressAlertText;

	private void enterFirstName(String firstName) {
		ExplicitWaitUtil.sendText(firstNameInputBox, firstName);
	}

	private void enterLastName(String lastName) {
		ExplicitWaitUtil.sendText(lastNameInputBox, lastName);
	}

	private void enterAddress(String address) {
		ExplicitWaitUtil.sendText(addressInputBox, address);
	}

	private void enterCity(String city) {
		ExplicitWaitUtil.sendText(cityInputBox, city);
	}

	private void enterPostCode(String postCode) {
		ExplicitWaitUtil.sendText(postCodeInputBox, postCode);
	}

	private void selectCountry(String country, String value) {
		Utility.selectElement(countryInputBox, country, value);
	}

	private void enterRegion(String country, String region, String value) {
		ExplicitWaitUtil.selectOptionFromDynamicDropdown(countryInputBox, country, regionInputBox,
				By.xpath("//select//option[text()='Ontario']"), region, value);
	}

	private void clickContinueBtn() {
		ExplicitWaitUtil.clickOnElement(continueBtn);
	}

	public AddressBookPage submitAddress(String firstName, String lastName, String city, String address,
			String postalCode, String country, String zone, String countryValue, String zoneValue) {
		enterFirstName(firstName);
		enterLastName(lastName);
		enterCity(city);
		enterAddress(address);
		enterPostCode(postalCode);
		selectCountry(country, countryValue);
		enterRegion(country, zone, zoneValue);
		clickContinueBtn();
		return new AddressBookPage();
	}
}
