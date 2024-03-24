package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.testbase.TestBase;
import com.naveenautomation.utility.ExplicitWaitUtil;

public class AccountLoginPage extends TestBase {
	public AccountLoginPage() {
		PageFactory.initElements(getDriverCopy(), this);
	}

	@FindBy(id = "input-email")
	private WebElement loginInput;

	@FindBy(id = "input-password")
	private WebElement pwdInput;

	@FindBy(css = "#content div>div form>input")
	private WebElement loginBtn;

	@FindBy(css = "#account-login li:nth-of-type(3) a")
	private WebElement loginText;

	private void enterEmail(String email) {
		ExplicitWaitUtil.sendText(loginInput, email);
	}

	private void enterPwd(String pwd) {
		ExplicitWaitUtil.sendText(pwdInput, pwd);
	}

	private void clickLoginBtn() {
		ExplicitWaitUtil.clickOnElement(loginBtn);
	}

	public MyAccountPage submitCorrectLoginInfo(String email, String pwd) {
		enterEmail(email);
		enterPwd(pwd);
		clickLoginBtn();
		return new MyAccountPage();
	}

	}
