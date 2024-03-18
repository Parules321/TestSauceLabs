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
	private static String browserName = System.getProperty("browser");
	//private static Browsers DEFAULT_BROWSER = Browsers.CHROME;
	private static Environment DEFAULT_ENV = Environment.PROD;
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
		driver.get(DEFAULT_ENV.getEnvUrl());
	}

	private void driverManagement() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	private void setBrowserForTesting() {
		switch (browserName) {
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
	

//	private void setBrowserForTesting() {
//		switch (DEFAULT_BROWSER) {
//		case CHROME:
//			WebDriverManager.chromedriver().setup();
//			logger.info("Launching Chrome Browser");
//			driver = new ChromeDriver();
//			break;
//		case FIREFOX:
//			WebDriverManager.firefoxdriver().setup();
//			logger.info("Launching Firefox Browser");
//			driver = new FirefoxDriver();
//			break;
//		case EDGE:
//			WebDriverManager.edgedriver().setup();
//			logger.info("Launching Edge Browser");
//			driver = new EdgeDriver();
//			break;
//
//		default:
//			throw new IllegalArgumentException();
//		}

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

}
