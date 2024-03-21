package com.naveenautomation.testbase;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.BeforeClass;

import com.naveenautomation.browsers.Browsers;
import com.naveenautomation.env.Environment;
import com.naveenautomation.listeners.WebDriverEvents;
import com.naveenautomation.utility.WebDriverUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver defaultWebDriver;
	private static String defaultBrowser;
	private static String defaultEnv;
	public static Logger logger;
	private WebDriverEvents events;
	private EventFiringWebDriver eDriver;

	@BeforeClass
	public void setUpLogger() {
		logger = Logger.getLogger(TestBase.class);
		PropertyConfigurator.configure("log4j.properties");
		BasicConfigurator.configure();
		logger.setLevel(Level.ALL);
	}

	public void intialisation() throws MalformedURLException {
		setBrowserForTesting();
		driverManagement();
		logger.info("Loading Page in Browser");
		defaultWebDriver.get(getDefaultEnv());
	}

	private void driverManagement() {
		defaultWebDriver.manage().window().maximize();
		defaultWebDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	private void setBrowserForTesting() throws MalformedURLException {

		switch (getDefaultBrowser()) {
		case "chrome":
			defaultWebDriver = WebDriverUtil.getGridChromeDriver();
			break;
		case "firefox":
			defaultWebDriver = WebDriverUtil.getHeadlessGridFirefoxDriver();
			break;
		case "MicrosoftEdge":
			defaultWebDriver = WebDriverUtil.getLocalIncognitoEdgeDriver();
			break;

		default:
			throw new IllegalArgumentException();
		}

		// Intialising Event Firing Webdriver
		eDriver = new EventFiringWebDriver(defaultWebDriver);

		// Intialising Webdriver Events
		events = new WebDriverEvents();

		// Register the event
		eDriver.register(events);
		defaultWebDriver = eDriver;
	}

	public void tearDown() {
		defaultWebDriver.close();
	}
		

	private static String getDefaultBrowser() {
		if (isRunningOnJenkins()) {
			defaultBrowser = System.getProperty("browser");
		} else {
			defaultBrowser = Browsers.CHROME.getBrowserName();
		}
		return defaultBrowser;

	}

	private static String getDefaultEnv() {
		if (isRunningOnJenkins()) {
			defaultEnv = System.getProperty("environment");
		} else {
			defaultEnv = Environment.PROD.getEnvUrl();
		}	
		return defaultEnv;
	}

	private static boolean isRunningOnJenkins() {
		// Check if a Jenkins-specific environment variable is set
		return System.getenv("JENKINS_HOME") != null;
	}
}
