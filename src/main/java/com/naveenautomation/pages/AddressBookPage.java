
package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.testbase.TestBase;
import com.naveenautomation.utility.ExplicitWaitUtil;

public class AddressBookPage extends TestBase {
	public AddressBookPage() {
		PageFactory.initElements(getDriverCopy(), this);
	}

	@FindBy(css = ".btn-primary")
	private WebElement addNewAddressBtn;

	@FindBy(css = "div.alert")
	WebElement addressUpdateAlertText;

	public AddAddressPage clickAddNewAddressBtn() {
		ExplicitWaitUtil.clickOnElement(addNewAddressBtn);
		return new AddAddressPage();
	}

	public String getAddressUpdateAlertText() {
		return ExplicitWaitUtil.getText(addressUpdateAlertText);
	}


}