package com.naveenautomation.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.naveenautomation.testbase.TestBase;
import com.naveenautomation.utility.ExplicitWaitUtil;

public class MyAccountPage extends TestBase {
	public MyAccountPage() {
		PageFactory.initElements(getDriverCopy(), this);
	}

	@FindBy(css = ".list-group a")
	private List<WebElement> sideNavMenuList;

	@FindBy(xpath = "//h2[text()='My Account']")
	private WebElement myAccountBannerTxt;

	@FindBy(css = "span.caret")
	private WebElement myAccountDropDwnBtn;

	@FindBy(css = "ul.dropdown-menu-right li:last-of-type")
	private WebElement myAccountLogOutBtn;

	public String getMyAccountText() {
		return ExplicitWaitUtil.getText(myAccountBannerTxt);
	}

	public AddressBookPage clickAddressBookBtn() {
		ExplicitWaitUtil.clickOnElementFromWebElementsList(sideNavMenuList, "Address Book");
		return new AddressBookPage();
	}

	private void getMyAccountDropDownMenu() {
		ExplicitWaitUtil.clickOnElement(myAccountDropDwnBtn);
	}

	private void clickMyAcctLogOutBtn() {
		ExplicitWaitUtil.clickOnElement(myAccountLogOutBtn);
	}

	public AccountLogoutPage clickSideNavLogOutBtn() {
		ExplicitWaitUtil.clickOnElementFromWebElementsList(sideNavMenuList, "Logout");
		return new AccountLogoutPage();
	}

	public AccountLogoutPage clickMyAccountLogOutBtn() {
		getMyAccountDropDownMenu();
		clickMyAcctLogOutBtn();
		return new AccountLogoutPage();
	}

}
