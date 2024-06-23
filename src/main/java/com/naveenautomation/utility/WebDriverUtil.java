package com.naveenautomation.utility;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.naveenautomation.listeners.WebDriverEvents;
import com.naveenautomation.testbase.TestBase;



public class WebDriverUtil extends TestBase {

	public static void setChromeDriver(String option) {
		logger.info("Launching Chrome Browser");
		//WebDriverManager.chromedriver().setup();
		driver.set(new ChromeDriver(OptionsUtil.getChromeOption(option)));
	}

	public static void setFirefoxDriver(String option) {
		logger.info("Launching Firefox Browser");
		//WebDriverManager.firefoxdriver().setup();
		driver.set(new FirefoxDriver(OptionsUtil.getFirefoxOption(option)));
	}

	public static void setEdgeDriver(String option) {
		logger.info("Launching Edge Browser");
		//WebDriverManager.edgedriver().setup();
		driver.set(new EdgeDriver(OptionsUtil.getEdgeOption(option)));
	}

	public static void setRemoteChromeDriver(String option) throws MalformedURLException {
		logger.info("Launching Remote Chrome Browser");
		String hubURL = "http://192.168.2.25:4444/wd/hub";
		driver.set(new RemoteWebDriver(new URL(hubURL), OptionsUtil.getRemoteChromeOption(option)));
	}

	public static void setRemoteFirefoxDriver(String option) throws MalformedURLException {
		logger.info("Launching Remote Firefox Browser");
		String hubURL = "http://192.168.2.25:4444/wd/hub";
		driver.set(new RemoteWebDriver(new URL(hubURL), OptionsUtil.getRemoteFirefoxOption(option)));

	}

	public static void setRemoteEdgeDriver(String option) throws MalformedURLException {
		logger.info("Launching Remote Edge Browser");
		String hubURL = "http://192.168.2.25:4444/wd/hub";
		driver.set(new RemoteWebDriver(new URL(hubURL), OptionsUtil.getRemoteEdgeOption(option)));
	}
}