package com.naveenautomation.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.naveenautomation.testbase.TestBase;

public class RetryAnalyzer extends TestBase implements IRetryAnalyzer {
	int cnt = 0;

	int maxCnt = 1;
//Returns true if the test method has to be retried, false otherwise.
	@Override
	public boolean retry(ITestResult result) {

		if (cnt < maxCnt) {
			logger.info("Test failed, Retrying for " + cnt + " ,Test Name : " + result.getMethod().getMethodName());
			cnt++;
			return true;
		}

		return false;
	}

}
