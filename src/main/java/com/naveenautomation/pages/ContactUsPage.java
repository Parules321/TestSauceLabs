package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.testbase.TestBase;

public class ContactUsPage extends TestBase {

	public ContactUsPage() {
		PageFactory.initElements(driver, this); // this method is defined inside the constructor to initialize all the
												// elements of the current class object.
	}

	@FindBy(id = "input-enquiry")
	WebElement enquiryInputBox;

	@FindBy(css = "[type ='submit']")
	WebElement submitBtn;

	@FindBy(xpath = "//p[contains(text(),'successfully sent')]")
	WebElement successMsg;

	public String verifyContactPageTitle() {
		return driver.getTitle();
	}

	public String submitContactDetails(String enquiry) {
		enquiryInputBox.sendKeys(enquiry);
		submitBtn.click();
		String successMsgText = successMsg.getText();
		return successMsgText;
	}

}
