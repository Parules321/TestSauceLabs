package com.naveenautomation.utility;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.naveenautomation.testbase.TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverUtil extends TestBase{
	
	
	public static WebDriver getLocalChromeDriver() {
		WebDriverManager.chromedriver().setup();
		logger.info("Launching Chrome Browser");
		defaultWebDriver = new ChromeDriver(OptionsUtil.getDefaultChrome());
		return defaultWebDriver;
	}
			
	public static WebDriver getLocalEdgeDriver() {
		WebDriverManager.edgedriver().setup();
		logger.info("Launching Edge Browser");
		defaultWebDriver = new EdgeDriver(OptionsUtil.getDefaultEdge());
		return defaultWebDriver;
	}
	
	public static WebDriver getLocalFirefoxDriver() {	
		WebDriverManager.firefoxdriver().setup();
		logger.info("Launching Firefox Browser");
		defaultWebDriver = new FirefoxDriver(OptionsUtil.getDefaultFirefox());
		return defaultWebDriver;
	}
	
	
	public static WebDriver getLocalHeadlessChromeDriver() {
		WebDriverManager.chromedriver().setup();
		logger.info("Launching Chrome Browser");
		defaultWebDriver = new ChromeDriver(OptionsUtil.getChromeHeadless());
		return defaultWebDriver;
	}
			
	
	public static WebDriver getLocalHeadlessFirefoxDriver() {	
		WebDriverManager.firefoxdriver().setup();
		logger.info("Launching Firefox Browser");
		defaultWebDriver = new FirefoxDriver(OptionsUtil.getFirefoxHeadless());
		return defaultWebDriver;
	}
	
	
	public static WebDriver getLocalIncognitoChromeDriver() {
		WebDriverManager.chromedriver().setup();
		logger.info("Launching Chrome Browser");
		defaultWebDriver = new ChromeDriver(OptionsUtil.getChromeIncognito());
		return defaultWebDriver;
	}
			
	public static WebDriver getLocalIncognitoEdgeDriver() {
		WebDriverManager.edgedriver().setup();
		logger.info("Launching Edge Browser");
		defaultWebDriver = new EdgeDriver(OptionsUtil.getEdgeIncognito());
		return defaultWebDriver;
	}
	
	public static WebDriver getLocalIncognitoFirefoxDriver() {	
		WebDriverManager.firefoxdriver().setup();
		logger.info("Launching Firefox Browser");
		defaultWebDriver = new FirefoxDriver(OptionsUtil.getFirefoxIncognito());
		return defaultWebDriver;
	}
	
	
	public static WebDriver getGridChromeDriver() throws MalformedURLException {
		String hubURL = "http://192.168.2.25:4444/wd/hub";
		logger.info("Launching Chrome Browser");
		defaultWebDriver=new RemoteWebDriver(new URL(hubURL), OptionsUtil.getChromeWithCapabilities());
		return defaultWebDriver;
	}
			
	public static WebDriver getGridEdgeDriver() throws MalformedURLException {
		String hubURL = "http://192.168.2.25:4444/wd/hub";
		logger.info("Launching Edge Browser");
		defaultWebDriver=new RemoteWebDriver(new URL(hubURL), OptionsUtil.getEdgeWithCapabilities());
		return defaultWebDriver;
	}
	
	public static WebDriver getGridFirefoxDriver() throws MalformedURLException {	
		String hubURL = "http://192.168.2.25:4444/wd/hub";
		logger.info("Launching Firefox Browser");
		defaultWebDriver=new RemoteWebDriver(new URL(hubURL), OptionsUtil.getFirefoxWithCapabilities());
		return defaultWebDriver;
	}
	
			
	public static WebDriver getIncognitoGridEdgeDriver() throws MalformedURLException {
		String hubURL = "http://192.168.2.25:4444/wd/hub";
		logger.info("Launching Edge Browser");
		defaultWebDriver=new RemoteWebDriver(new URL(hubURL), OptionsUtil.getEdgeIncognitoWithCapabilities());
		return defaultWebDriver;
	}
	
	public static WebDriver getIncognitoGridFirefoxDriver() throws MalformedURLException {	
		String hubURL = "http://192.168.2.25:4444/wd/hub";
		logger.info("Launching Firefox Browser");
		defaultWebDriver=new RemoteWebDriver(new URL(hubURL), OptionsUtil.getFirefoxIncognitoWithCapabilities());
		return defaultWebDriver;
	}
	
	public static WebDriver getIncognitoGridChromeDriver() throws MalformedURLException {
		String hubURL = "http://192.168.2.25:4444/wd/hub";
		logger.info("Launching Chrome Browser");
		defaultWebDriver=new RemoteWebDriver(new URL(hubURL), OptionsUtil.getChromeIncognitoWithCapabilities());
		return defaultWebDriver;
	}
	
	public static WebDriver getHeadlessGridChromeDriver() throws MalformedURLException {
		String hubURL = "http://192.168.2.25:4444/wd/hub";
		logger.info("Launching Chrome Browser");
		defaultWebDriver=new RemoteWebDriver(new URL(hubURL), OptionsUtil.getChromeHeadlessWithCapabilities());
		return defaultWebDriver;
	}
			
	
	public static WebDriver getHeadlessGridFirefoxDriver() throws MalformedURLException {	
		String hubURL = "http://192.168.2.25:4444/wd/hub";
		logger.info("Launching Firefox Browser");
		defaultWebDriver=new RemoteWebDriver(new URL(hubURL), OptionsUtil.getFirefoxHeadlessWithCapabilities());
		return defaultWebDriver;
	}

	
	
	

}
