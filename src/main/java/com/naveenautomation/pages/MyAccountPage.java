package com.naveenautomation.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.testbase.TestBase;

public class MyAccountPage extends TestBase {
	public MyAccountPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#content>ul:nth-of-type(1) li:nth-of-type(2) a")
	WebElement changePwdBtn;

	@FindBy(css = "div.alert")
	WebElement successBanner;

	@FindBy(css = "#account-account>div.row h2:first-of-type")
	WebElement myAccountText;

	@FindBy(css = "#column-right a")
	List<WebElement> sideNavWebelementList;

	public ChangePwdPage clickChangePasswordBtn() {
		changePwdBtn.click();
		return new ChangePwdPage();
	}

	public String getPasswordUpdateAlertText() {
		return successBanner.getText();
	}

	public String getMyAccountText() {
		return myAccountText.getText();
	}

	public AddressBookPage clickSideNavMenuItem(String item) {
		for (int i = 0; i < sideNavWebelementList.size(); i++) {
			if (sideNavWebelementList.get(i).getText().equalsIgnoreCase(item)) {
				sideNavWebelementList.get(i).click();
				break;
			}
		}
		return new AddressBookPage();
	}
}
