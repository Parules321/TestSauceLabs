package com.naveenautomation.testbase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.BeforeClass;

import com.naveenautomation.browsers.Browsers;
import com.naveenautomation.env.Environment;
import com.naveenautomation.listeners.WebDriverEvents;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
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

	public void intialisation() {
		setBrowserForTesting();
		driverManagement();
		logger.info("Loading Page in Browser");
		driver.get(getDefaultEnv());
		}
	

	private void driverManagement() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	private void setBrowserForTesting() {

			switch (getDefaultBrowser()) {
			case "Chrome":
				WebDriverManager.chromedriver().setup();
				logger.info("Launching Chrome Browser");
				driver = new ChromeDriver();
				break;
			case "Firefox":
				WebDriverManager.firefoxdriver().setup();
				logger.info("Launching Firefox Browser");
				driver = new FirefoxDriver();
				break;
			case "Edge":
				WebDriverManager.edgedriver().setup();
				logger.info("Launching Edge Browser");
				driver = new EdgeDriver();
				break;

			default:
				throw new IllegalArgumentException();
			}


			// Intialising Event Firing Webdriver
			eDriver = new EventFiringWebDriver(driver);

			// Intialising Webdriver Events
			events = new WebDriverEvents();

			// Register the event
			eDriver.register(events);
			driver = eDriver;
		}
	

	public void tearDown() {
		driver.close();
	}

	private String getDefaultBrowser() {
		if (isRunningOnJenkins()) {
			defaultBrowser.equals(System.getProperty("browser"));
		} else {
			defaultBrowser.equals(Browsers.CHROME.getBrowserName());
		}

		return defaultBrowser;

	}

	private String getDefaultEnv() {

		if (isRunningOnJenkins()) {
			defaultEnv.equals(System.getProperty("environment"));
		} else {
			defaultEnv.equals(Environment.PROD.getEnvUrl());
		}

		return defaultEnv;
	}

	private static boolean isRunningOnJenkins() {
		// Check if a Jenkins-specific environment variable is set
		return System.getenv("JENKINS_HOME") != null;
	}
}
