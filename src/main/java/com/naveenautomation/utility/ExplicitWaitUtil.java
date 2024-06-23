package com.naveenautomation.utility;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.naveenautomation.testbase.TestBase;

public class ExplicitWaitUtil extends TestBase {

	//private static int defaultTimeout = 20;
	private static boolean found = false;

	public static WebElement waitForElementToBeClickable(WebElement element) {
		return new WebDriverWait(getDriverCopy(), Duration.ofSeconds(20))
				.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void clickOnElement(WebElement element) {
		waitForElementToBeClickable(element).click();
	}

	public static void clearElement(WebElement element) {
		waitForElementToBeClickable(element).clear();
	}

	public static void submitElement(WebElement element) {
		waitForElementToBeClickable(element).submit();
	}

	public static WebElement waitForVisibilityOfElement(WebElement element) {
		return new WebDriverWait(getDriverCopy(), Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(element));
	}

	public static void sendText(WebElement element, String text) {
		waitForVisibilityOfElement(element).sendKeys(text);
	}

	public static String getText(WebElement element) {
		return waitForVisibilityOfElement(element).getText();
	}

	public static void moveToElement(WebElement element) {
		Actions action = new Actions(getDriverCopy());
		action.moveToElement(waitForVisibilityOfElement(element)).perform();
		//waitForVisibilityOfElement(element).getRect().getX();
		//action.moveToElement(waitForVisibilityOfElement(element)).click().perform(); - selenium 3
		//action.click(waitForVisibilityOfElement(element)); - selenium 4
		
	}

	public static void clickOnElementFromWebElementsList(List<WebElement> elements, String elementText) {

		for (WebElement element : elements) {
			if (getText(element).equals(elementText)) {
				clickOnElement(element);
				break;
			}
	}
//		elements.forEach(element -> {
//			if (getText(element).equals(elementText)) {
//				clickOnElement(element);
//				found = true;
//			}
//		});

	}

	public static WebElement waitForVisibilityOfElement(By locator) {
		return new WebDriverWait(getDriverCopy(), Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static void clickElementFromWebTable(List<WebElement> rowList, List<WebElement> columnList, By locator,
			String expectedText) {
		for (int r = 1; r <= rowList.size(); r++) {
			for (int c = 1; c <= columnList.size(); c++) {
				WebElement element = waitForVisibilityOfElement(locator);
				if (getText(element).equals(expectedText)) {
					clickOnElement(element);
					break;
				}
			}
		}
	}

	public static Alert waitforAlertToBePresent() {
		return new WebDriverWait(getDriverCopy(), Duration.ofSeconds(20)).until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert() {
		if (waitforAlertToBePresent() != null) {
			getDriverCopy().switchTo().alert().accept();
		}
	}

	public void dismissAlert() {
		if (waitforAlertToBePresent() != null) {
			getDriverCopy().switchTo().alert().dismiss();
		}
	}

	public static boolean waitForTextToBePresent(WebElement element, String text) {
		return new WebDriverWait(getDriverCopy(), Duration.ofSeconds(20))
				.until(ExpectedConditions.textToBePresentInElement(element, text));
	}

	public static WebElement waitForNestedElementToBePresent(WebElement element, By nestedElementLocator) {
		return new WebDriverWait(getDriverCopy(), Duration.ofSeconds(20))
				.until(ExpectedConditions.presenceOfNestedElementLocatedBy(element, nestedElementLocator));
	}

	public static void selectOptionFromDynamicDropdown(WebElement staticDrpdwn, String text, WebElement dynamicDrpdwn,
			By nestedOptionLocator, String nestedOptionText, String nestedOptionValue) {
		if (waitForTextToBePresent(staticDrpdwn, text)) {
			waitForNestedElementToBePresent(dynamicDrpdwn, nestedOptionLocator);
			Utility.selectElement(dynamicDrpdwn, nestedOptionText, nestedOptionValue);
		}

	}

	public static boolean waitForInputFieldToBeEmpty(WebElement element) {
		return new WebDriverWait(getDriverCopy(), Duration.ofSeconds(20))
				.until(defaultWebDriver -> element.getText().isEmpty());
	}

	public static void sendKeysWhenEmpty(WebElement element, String text) {
		if (waitForInputFieldToBeEmpty(element)) {
			element.sendKeys(text);
		}
	}
}