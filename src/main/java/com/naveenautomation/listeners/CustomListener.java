package com.naveenautomation.listeners;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.naveenautomation.testbase.TestBase;
import com.naveenautomation.utility.Utility;

public class CustomListener extends TestBase implements ITestListener {

	public void onTestStart(ITestResult result) {
		((JavascriptExecutor)driver.get()).executeScript("sauce:job-name=" + result.getMethod().getMethodName());
		logger.info("Test Starts : " + result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		((JavascriptExecutor) driver.get()).executeScript("sauce:job-result=" + (result.isSuccess() ? "passed" : "failed"));
		logger.info("Test Passed : " + result.getMethod().getMethodName());
	}

	public void onTestFailure(ITestResult result) {
		((JavascriptExecutor) driver.get()).executeScript("sauce:job-result=" + (result.isSuccess() ? "passed" : "failed"));
		logger.info("Test Failed !!!!! Taking Screenshot : " + result.getMethod().getMethodName());
		Utility.takeFailedTestScreenShot(result.getMethod().getMethodName());
	}

	public void onTestSkipped(ITestResult result) {
		logger.info("Test Skipped : " + result.getMethod().getMethodName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {

	}

}