package com.naveenautomation.testbase;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.BeforeClass;

import com.naveenautomation.browsers.Browsers;
import com.naveenautomation.env.Environment;
import com.naveenautomation.listeners.WebDriverEvents;
import com.naveenautomation.utility.WebDriverUtil;

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
		setDriver();
		driverManagement();
		logger.info("Loading Page in Browser");
		defaultWebDriver.get(getDefaultEnv());
	}

	private void driverManagement() {
		defaultWebDriver.manage().window().maximize();
		defaultWebDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	private void setDriver() throws MalformedURLException {

		switch (getDefaultBrowser()) {
		case "chrome":
			defaultWebDriver = getDefaultChromeDriver();
			break;
		case "firefox":
			defaultWebDriver = getDefaultFirefoxDriver();
			break;
		case "MicrosoftEdge":
			defaultWebDriver = getDefaultEdgeDriver();
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

	private static WebDriver getDefaultFirefoxDriver() throws MalformedURLException {

		if (isRunningOnJenkins() && isGridReady("localhost", 4444, 15000)) {
			WebDriverUtil.getRemoteFirefoxDriver("Standard");
		}

		else {
			WebDriverUtil.getFirefoxDriver("Headless");
		}

		return defaultWebDriver;
	}

	private static WebDriver getDefaultEdgeDriver() throws MalformedURLException {
		if (isRunningOnJenkins() && isGridReady("localhost", 4444, 15000)) {
			WebDriverUtil.getRemoteEdgeDriver("Incognito");
		}

		else {
			WebDriverUtil.getEdgeDriver("Standard");
		}

		return defaultWebDriver;
	}

	private static WebDriver getDefaultChromeDriver() throws MalformedURLException {
		if (isRunningOnJenkins() && isGridReady("localhost", 4444, 15000)) {
			WebDriverUtil.getRemoteChromeDriver("Standard");
		} else {
			WebDriverUtil.getChromeDriver("Incognito");
		}
		return defaultWebDriver;
	}

	private static boolean isRunningOnJenkins() {
		// Check if Jenkins-specific environment variable is set
		return System.getenv("JENKINS_HOME") != null;
	}

	private static boolean isGridReady(String host, int port, int timeout) {
		try (Socket socket = new Socket()) {
			socket.connect(new InetSocketAddress(host, port), timeout);
			return true;
		} catch (IOException e) {
			return false; // Either timeout or unreachable or failed DNS lookup.
		}

	}

}
