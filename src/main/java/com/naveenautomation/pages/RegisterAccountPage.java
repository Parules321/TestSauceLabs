package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.testbase.TestBase;

public class RegisterAccountPage extends TestBase {

	public RegisterAccountPage() {
		PageFactory.initElements(driver, this); // this method is defined inside the constructor to initialize all the
												// elements of the current class object.
	}

	@FindBy(id = "input-firstname") // @FindBy here is equivalent to driver.findElementBy &
									// is better for maintenance purpose
	WebElement firstNameInput;
	@FindBy(id = "input-lastname")
	WebElement lastNameInput;
	@FindBy(id = "input-email")
	WebElement emailInput;
	@FindBy(id = "input-telephone")
	WebElement phoneInput;
	@FindBy(id = "input-password")
	WebElement passwordInput;
	@FindBy(id = "input-confirm")
	WebElement pswdConfirmationInput;
	@FindBy(css = ".radio-inline [type = 'radio'][value='1']")
	WebElement subscriptionRadioBtn;
	@FindBy(css = "[type = 'checkbox'][value='1']")
	WebElement agreeCheckBox;
	@FindBy(css = "[type = 'submit'][value='Continue']")
	WebElement submitBtn;
	@FindBy(xpath = "//a[text()='Continue']")
	WebElement continueBtn;

	public MyAccountPage registerAccount(String firstName, String lastName, String phone, String email,
			String password) {
		firstNameInput.sendKeys(firstName);
		lastNameInput.sendKeys(lastName);
		emailInput.sendKeys(email);
		phoneInput.sendKeys(phone);
		passwordInput.sendKeys(password);
		pswdConfirmationInput.sendKeys(password);
		subscriptionRadioBtn.click();
		agreeCheckBox.click();
		submitBtn.submit();
		continueBtn.click();
		return new MyAccountPage();
	}

}
