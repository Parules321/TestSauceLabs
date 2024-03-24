package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.testbase.TestBase;
import com.naveenautomation.utility.ExplicitWaitUtil;

public class AccountLogoutPage extends TestBase{
	
	public AccountLogoutPage() {
		PageFactory.initElements(getDriverCopy(), this);
	}
		
	@FindBy(css = "#content h1")
	private WebElement logoutMsgText;
	
	public String getLogoutMsgText() {
		return ExplicitWaitUtil.getText(logoutMsgText);
	}

}

