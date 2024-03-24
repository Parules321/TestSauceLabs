package com.naveenautomation.testbase;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Socket;

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
	private static String defaultBrowser;
	private static String defaultEnv;
	public static Logger logger;
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	@BeforeClass
	public void setUpLogger() {
		logger = Logger.getLogger(TestBase.class);
		PropertyConfigurator.configure("log4j.properties");
		BasicConfigurator.configure();
		logger.setLevel(Level.ALL);
	}

	public void intialization() throws MalformedURLException {
		setDriver();
		driverManagement();
		logger.info("Loading Page in Browser");
		getDriverCopy().get(getDefaultEnv());
	}

	private void driverManagement() {
		getDriverCopy().manage().window().maximize();
		// defaultWebDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	private void setDriver() throws MalformedURLException {

		switch (getDefaultBrowser()) {
		case "chrome":
			setDefaultChromeDriver();
			break;
		case "firefox":
			setDefaultFirefoxDriver();
			break;
		case "MicrosoftEdge":
			setDefaultEdgeDriver();
			break;

		default:
			throw new IllegalArgumentException();
		}
	}

	public void tearDown() {
		getDriverCopy().close();
	}

	public static WebDriver getDriverCopy() {
		return driver.get();
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

	private static void setDefaultFirefoxDriver() throws MalformedURLException {

		if (isRunningOnJenkins() && isGridReady("localhost", 4444, 15000)) {
			WebDriverUtil.setRemoteFirefoxDriver("Standard");
		} else {
			WebDriverUtil.setFirefoxDriver("Headless");
		}
	}

	private static void setDefaultEdgeDriver() throws MalformedURLException {
		if (isRunningOnJenkins() && isGridReady("localhost", 4444, 15000)) {
			WebDriverUtil.setRemoteEdgeDriver("Incognito");
		} else {
			WebDriverUtil.setEdgeDriver("Standard");
		}
	}

	private static void setDefaultChromeDriver() throws MalformedURLException {
		if (isRunningOnJenkins() && isGridReady("localhost", 8082, 20000)) {
			WebDriverUtil.setRemoteChromeDriver("Standard");
		} else {
			WebDriverUtil.setChromeDriver("Incognito");
		}
	}

	private static boolean isRunningOnJenkins() {
		// Check if Jenkins-specific environment variable is set

		return System.getenv("JENKINS_HOME") != null;
	}

	private static boolean isGridReady(String host, int port, int timeout) {
		Socket socket = new Socket();
		try {
			socket.connect(new InetSocketAddress(host, port), timeout);
			return true;
		} catch (IOException e) {
			return false;
		}
	}

}
