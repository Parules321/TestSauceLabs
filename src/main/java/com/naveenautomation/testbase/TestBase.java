package com.naveenautomation.testbase;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;

import com.naveenautomation.browsers.Browsers;
import com.naveenautomation.env.Environment;
import com.naveenautomation.utility.WebDriverUtil;

public class TestBase {
	private static String defaultBrowser;
	private static String defaultEnv;
	public static Logger logger;
	//private WebDriverListener listener = new WebDriverEvents();
	//private EventFiringDecorator <WebDriver> eDriver = new EventFiringDecorator<WebDriver>(listener);
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	public static final String sauceLabsUsername = "oauth-sparulonline-0b577";
	public static final String sauceLabsAccessKey = "76941f45-82f1-41f1-8bdc-cc8eb15a25e3";
	public static final String sauceLabsUrl = "https://" + sauceLabsUsername + ":" + sauceLabsAccessKey + "@ondemand.us-west-1.saucelabs.com:443/wd/hub";
	//you can further abstract username and accesskey in a separate enum class and then not hard code the sauce labs url
	
	@BeforeClass
	public void setUpLogger() {
		//logger = LogManager.getLogger(TestBase.class); // common way to obtain logger in Log4j 2.x
		logger = Logger.getLogger(TestBase.class); //part of Log4j 1.x
		PropertyConfigurator.configure("log4j.properties");
		BasicConfigurator.configure();
		logger.setLevel(Level.ALL);
	}

	public void intialization() throws MalformedURLException {
		setDriver();
		driverManagement();
		//eDriver.decorate(getDriverCopy());
		logger.info("Loading Page in Browser");
		getDriverCopy().get(getDefaultEnv());
	}

	private void driverManagement() {
		getDriverCopy().manage().window().maximize();
		// defaultWebDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	private void setDriver() throws MalformedURLException {
		
		if(isRunningOnJenkins()) {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setBrowserName(System.getenv("SAUCE_ONDEMAND_BROWSERS"));
			capabilities.setVersion(System.getenv("SAUCE_ONDEMAND_BROWSERS"));
			capabilities.setCapability("Platform", System.getenv("SAUCE_ONDEMAND_BROWSERS"));
			capabilities.setCapability("build", System.getenv("SAUCE_BUILD_NAME"));
			driver.set(new RemoteWebDriver(new URL (sauceLabsUrl), capabilities));}

		else {	switch (getDefaultBrowser()) {
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
		}}
	}

	public void tearDown() {
		getDriverCopy().close();
	}

	public static WebDriver getDriverCopy() {
		return driver.get();
	}

	private static String getDefaultBrowser() {
//		if (isRunningOnJenkins()) {
//			defaultBrowser = System.getProperty("browser");
//		} else {
//			defaultBrowser = Browsers.CHROME.getBrowserName();
//		}
		defaultBrowser = Browsers.CHROME.getBrowserName();
		return defaultBrowser;

	}

	private static String getDefaultEnv() {
//		if (isRunningOnJenkins()) {
//			defaultEnv = System.getProperty("environment");
//		} else {
//			defaultEnv = Environment.PROD.getEnvUrl();
//		}
		defaultEnv = Environment.PROD.getEnvUrl();
		return defaultEnv;
	}
	
	
	
	private static void setDefaultFirefoxDriver() throws MalformedURLException {

//		if (isRunningOnJenkins()) {
//			WebDriverUtil.setRemoteFirefoxDriver("Standard");
//		} else {
//			WebDriverUtil.setFirefoxDriver("Headless");
//		}
		WebDriverUtil.setFirefoxDriver("Headless");
	}
	
	private static void setDefaultEdgeDriver() throws MalformedURLException {
//	if (isRunningOnJenkins()) {
//		WebDriverUtil.setRemoteEdgeDriver("Standard");
//	} else {
//		WebDriverUtil.setEdgeDriver("Incognito");
//	}
		WebDriverUtil.setEdgeDriver("Incognito");
}
	
	private static void setDefaultChromeDriver() throws MalformedURLException {
//	if (isRunningOnJenkins()) {
//		WebDriverUtil.setRemoteChromeDriver("Standard");
//	} else {
//		WebDriverUtil.setChromeDriver("Incognito");}
		WebDriverUtil.setChromeDriver("Incognito");
	}

//	private static void setDefaultFirefoxDriver() throws MalformedURLException {
//
//		if (isRunningOnJenkins() && isGridReady("localhost", 4444, 15000)) {
//			WebDriverUtil.setRemoteFirefoxDriver("Standard");
//		} else {
//			WebDriverUtil.setFirefoxDriver("Headless");
//		}
//	}
//
//	private static void setDefaultEdgeDriver() throws MalformedURLException {
//		if (isRunningOnJenkins() && isGridReady("localhost", 4444, 15000)) {
//			WebDriverUtil.setRemoteEdgeDriver("Incognito");
//		} else {
//			WebDriverUtil.setEdgeDriver("Standard");
//		}
//	}
//
//	private static void setDefaultChromeDriver() throws MalformedURLException {
//		if (isRunningOnJenkins() && isGridReady("localhost", 4444, 20000)) {
//			WebDriverUtil.setRemoteChromeDriver("Standard");
//		} else {
//			WebDriverUtil.setChromeDriver("Incognito");
//		}
//	}

	private static boolean isRunningOnJenkins() {
		// Check if Jenkins-specific environment variable is set

		return System.getenv("JENKINS_HOME") != null;
	}
	// Method to check if a server is reachable using a socket connection
	//use below for jenkns too
//	private static boolean isGridReady(String host, int port, int timeout) {
//		Socket socket = new Socket();
//		try {
//			socket.connect(new InetSocketAddress(host, port), timeout);
//			return true;
//		} catch (IOException e) {
//			return false;
//		}
//	}

}
