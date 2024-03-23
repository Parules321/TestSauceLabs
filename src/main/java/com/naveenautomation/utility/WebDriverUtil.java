package com.naveenautomation.utility;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.naveenautomation.testbase.TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverUtil extends TestBase {

	public static WebDriver getChromeDriver(String option) {
		logger.info("Launching Chrome Browser");
		WebDriverManager.chromedriver().setup();
		defaultWebDriver = new ChromeDriver(OptionsUtil.getChromeOption(option));
		return defaultWebDriver;
	}

	public static WebDriver getFirefoxDriver(String option) {
		logger.info("Launching Firefox Browser");
		WebDriverManager.firefoxdriver().setup();
		defaultWebDriver = new FirefoxDriver(OptionsUtil.getFirefoxOption(option));
		return defaultWebDriver;
	}

	public static WebDriver getEdgeDriver(String option) {
		logger.info("Launching Edge Browser");
		WebDriverManager.edgedriver().setup();
		defaultWebDriver = new EdgeDriver(OptionsUtil.getEdgeOption(option));
		return defaultWebDriver;
	}

	public static WebDriver getRemoteChromeDriver(String option) throws MalformedURLException {
		logger.info("Launching Chrome Browser");
		String hubURL = "http://192.168.2.25:4444/wd/hub";
		defaultWebDriver = new RemoteWebDriver(new URL(hubURL), OptionsUtil.getChromeOption(option));
		return defaultWebDriver;

	}

	public static WebDriver getRemoteFirefoxDriver(String option) throws MalformedURLException {
		logger.info("Launching Firefox Browser");
		String hubURL = "http://192.168.2.25:4444/wd/hub";
		defaultWebDriver = new RemoteWebDriver(new URL(hubURL), OptionsUtil.getFirefoxOption(option));
		return defaultWebDriver;
	}

	public static WebDriver getRemoteEdgeDriver(String option) throws MalformedURLException {
		logger.info("Launching Firefox Browser");
		String hubURL = "http://192.168.2.25:4444/wd/hub";
		defaultWebDriver = new RemoteWebDriver(new URL(hubURL), OptionsUtil.getEdgeOption(option));
		return defaultWebDriver;
	}
}