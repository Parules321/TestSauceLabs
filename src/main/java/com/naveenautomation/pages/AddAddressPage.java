package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.naveenautomation.testbase.TestBase;

public class AddAddressPage extends TestBase {
	public AddAddressPage() {
		PageFactory.initElements(defaultWebDriver, this);
	}

	@FindBy(id = "input-firstname")
	WebElement firstName;

	@FindBy(id = "input-lastname")
	WebElement lastName;

	@FindBy(id = "input-company")
	WebElement companyName;

	@FindBy(id = "input-address-1")
	WebElement addressOne;

	@FindBy(id = "input-city")
	WebElement city;

	@FindBy(id = "input-postcode")
	WebElement postCode;

	@FindBy(id = "input-country")
	WebElement country;

	@FindBy(id = "input-zone")
	WebElement zone;

	@FindBy(css = "div.buttons.clearfix input")
	WebElement continueBtn;

	private void enterFirstName(String name) {
		firstName.sendKeys(name);
	}

	private void enterLastName(String name) {
		lastName.sendKeys(name);
	}

	private void enterCompany(String name) {
		companyName.sendKeys(name);
	}

	private void enterAddressOne(String name) {
		addressOne.sendKeys(name);
	}

	private void enterCity(String name) {
		city.sendKeys(name);
	}

	private void enterPostCode(String name) {
		postCode.sendKeys(name);
	}

	private void selectCountry(String name) {
		selectElement(country, name);
	}

	private void enterZone(String name) {
		selectElement(zone, name);
	}

	public AddressBookPage SubmitAddress(String name, String lastName, String company, String city, String address,
			String postalCode, String country, String zone) {
		enterFirstName(name);
		enterLastName(lastName);
		enterCompany(company);
		enterCity(city);
		enterAddressOne(address);
		enterPostCode(postalCode);
		selectCountry(country);
		enterZone(zone);
		continueBtn.click();
		return new AddressBookPage();
	}

	private void selectElement(WebElement element, String text) {
		Select sc = new Select(element);

		try {
			sc.selectByVisibleText(text);
		} catch (Exception e) {
			sc.selectByValue(text);
		}
	}

}
