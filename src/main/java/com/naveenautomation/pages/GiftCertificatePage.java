package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.testbase.TestBase;

public class GiftCertificatePage extends TestBase {

	public GiftCertificatePage() {
		PageFactory.initElements(driver, this); // this method is defined inside the constructor to initialize all the
												// elements of the current class object.
	}

	@FindBy(id = "input-to-name")
	WebElement recipientNameInputBox;

	@FindBy(id = "input-to-email")
	WebElement recipientEmailInputBox;

	@FindBy(css = "[name='voucher_theme_id'][value='7']")
	WebElement voucherThemeRadioBtn;

	@FindBy(id = "input-message")
	WebElement msgInputBox;

	@FindBy(id = "input-amount")
	WebElement amountInputBox;

	@FindBy(css = "[type = 'checkbox'][value='1']")
	WebElement agreeCheckBox;

	@FindBy(css = "[type = 'submit'][value='Continue']")
	WebElement continueBtn;

	@FindBy(xpath = "//p[contains(text(),'Thank you')]")
	WebElement successMsg;

	public String verifyGiftPageTitle() {
		return driver.getTitle();
	}

	public String submitGiftPurchaseDetails(String recipientName, String recipientEmail, String amount) {
		recipientNameInputBox.sendKeys(recipientName);
		recipientEmailInputBox.sendKeys(recipientEmail);
		voucherThemeRadioBtn.click();
		msgInputBox.sendKeys("Test Message - Enjoy your gift");
		amountInputBox.clear();
		amountInputBox.sendKeys(amount);
		agreeCheckBox.click();
		continueBtn.click();
		String successMsgText = successMsg.getText();
		return successMsgText;
	}

}
