package com.naveenautomation.utility;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class OptionsUtil {

	public static ChromeOptions getDefaultChrome() {
		ChromeOptions options = new ChromeOptions();
		return options;
	}

	public static FirefoxOptions getDefaultFirefox() {
		FirefoxOptions options = new FirefoxOptions();
		return options;
	}

	public static EdgeOptions getDefaultEdge() {
		EdgeOptions options = new EdgeOptions();
		return options;
	}

	public static ChromeOptions getChromeWithCapabilities() {
		DesiredCapabilities capability = new DesiredCapabilities();
		ChromeOptions options = new ChromeOptions();
		capability.setBrowserName("chrome");
		capability.setPlatform(Platform.WINDOWS);
		options.merge(capability);
		return options;
	}

	public static FirefoxOptions getFirefoxWithCapabilities() {
		DesiredCapabilities capability = new DesiredCapabilities();
		FirefoxOptions options = new FirefoxOptions();
		capability.setBrowserName("firefox");
		capability.setPlatform(Platform.WINDOWS);
		options.merge(capability);
		return options;
	}

	public static EdgeOptions getEdgeWithCapabilities() {
		DesiredCapabilities capability = new DesiredCapabilities();
		EdgeOptions options = new EdgeOptions();
		capability.setBrowserName("MicrosoftEdge");
		capability.setPlatform(Platform.WINDOWS);
		options.merge(capability);
		return options;
	}

	public static ChromeOptions getChromeHeadless() {
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
		return options;
	}

	public static FirefoxOptions getFirefoxHeadless() {
		FirefoxOptions options = new FirefoxOptions();
		options.setHeadless(true);
		return options;
	}

//	public static EdgeOptions getEdgeHeadless() {
//		EdgeOptions options = new EdgeOptions();
//		//edge has no option to run headless
//		return options;
//	}
//	

	public static ChromeOptions getChromeIncognito() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		return options;
	}

	public static FirefoxOptions getFirefoxIncognito() {
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("--incognito");
		return options;
	}

	public static EdgeOptions getEdgeIncognito() {
		EdgeOptions options = new EdgeOptions();
		options.setCapability("ms:inPrivate", true);
		return options;
	}

	public static ChromeOptions getChromeHeadlessWithCapabilities() {
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setBrowserName("chrome");
		capability.setPlatform(Platform.WINDOWS);
		options.merge(capability);
		return options;
	}

	public static FirefoxOptions getFirefoxHeadlessWithCapabilities() {
		FirefoxOptions options = new FirefoxOptions();
		options.setHeadless(true);
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setBrowserName("firefox");
		capability.setPlatform(Platform.WINDOWS);
		options.merge(capability);
		return options;
	}

	public static ChromeOptions getChromeIncognitoWithCapabilities() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setBrowserName("chrome");
		capability.setPlatform(Platform.WINDOWS);
		options.merge(capability);
		return options;
	}

	public static FirefoxOptions getFirefoxIncognitoWithCapabilities() {
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("--incognito");
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setBrowserName("firefox");
		capability.setPlatform(Platform.WINDOWS);
		options.merge(capability);
		return options;
	}

	public static EdgeOptions getEdgeIncognitoWithCapabilities() {
		EdgeOptions options = new EdgeOptions();
		options.setCapability("ms:inPrivate", true);
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setBrowserName("MicrosoftEdge");
		capability.setPlatform(Platform.WINDOWS);
		options.merge(capability);
		return options;
	}

}
