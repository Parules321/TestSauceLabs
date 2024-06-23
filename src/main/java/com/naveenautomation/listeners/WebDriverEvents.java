package com.naveenautomation.listeners;

import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

import com.naveenautomation.testbase.TestBase;

public class WebDriverEvents extends TestBase implements WebDriverListener {

	public void beforeAlertAccept(WebDriver driver) {

	}

	public void afterAlertAccept(WebDriver driver) {

	}

	public void afterAlertDismiss(WebDriver driver) {

	}

	public void beforeAlertDismiss(WebDriver driver) {

	}

	public void beforeNavigateTo(String url, WebDriver driver) {
		logger.info("Navigating to URL : " + url);

	}

	// correct one
	public void beforeTo(WebDriver.Navigation navigation, String url) {
	}

	// correct one
	public void afterTo(WebDriver.Navigation navigation, String url) {
	}

	// correct one
	public void beforeGet(WebDriver driver, String url) {
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		logger.info("Navigated to URL : " + url);

	}

	public void beforeNavigateBack(WebDriver driver) {

	}

	public void afterNavigateBack(WebDriver driver) {

	}

	public void beforeNavigateForward(WebDriver driver) {

	}

	public void afterNavigateForward(WebDriver driver) {

	}

	public void beforeNavigateRefresh(WebDriver driver) {

	}

	public void afterNavigateRefresh(WebDriver driver) {

	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		logger.info("Finding element by : " + by);

	}

	// correct
	public void beforeFindElement(WebDriver driver, By locator) {
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		logger.info("Found element by : " + by);

	}

	// correct
	public void afterFindElement(WebDriver driver, By locator, WebElement result) {
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		logger.info("Clicking on element by : " + element);

	}

	// correct
	public void beforeClick(WebElement element) {
	};

	// correct
	public void afterClick(WebElement element) {
	};

	public void afterClickOn(WebElement element, WebDriver driver) {

	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {

	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {

	}

	public void beforeScript(String script, WebDriver driver) {

	}

	public void afterScript(String script, WebDriver driver) {

	}

	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		logger.info("Switching to Window  : " + windowName);

	}

	// correct
	public void beforeAnyWindowCall(WebDriver.Window window, Method method, Object[] args) {

	}

	// correct
	public void afterAnyWindowCall(WebDriver.Window window, Method method, Object[] args, Object result) {
	}

	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		logger.info("Switched to Window  : " + windowName);

	}

	public void onException(Throwable throwable, WebDriver driver) {

	}
//correct
	public void afterSendKeys(Alert alert, String text) {};
	
	
	//correct
	public void beforeBack(WebDriver.Navigation navigation) {};
	
	
	//correct
	public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {};
	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		logger.info("Taking screen shot");

	}

	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {

	}
//correct
	public void beforeGetText(WebElement element) {};
	public void afterGetText(WebElement element, String result) {};
	public void beforeGetText(WebElement element, WebDriver driver) {
		// logger.info("Getting text from element : " + element.getText());

	}

	public void afterGetText(WebElement element, WebDriver driver, String text) {
		// logger.info("Got text from element : " + element.getText());

	}

}