package com.naveenautomation.utility;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class OptionsUtil {

	public static ChromeOptions getChromeOption(String option) {
		ChromeOptions options = null;

		if (option.equals("Standard")) {
			options = new ChromeOptions();
		}

		else if (option.equals("Headless")) {
			options = new ChromeOptions();
			options.setHeadless(true);
		}

		else if (option.equals("Incognito")) {
			options = new ChromeOptions();
			options.addArguments("--incognito");
		}

		return options;
	}

	public static FirefoxOptions getFirefoxOption(String option) {
		FirefoxOptions options = null;
		if (option.equals("Standard")) {
			options = new FirefoxOptions();
		}

		else if (option.equals("Headless")) {
			options = new FirefoxOptions();
			options.setHeadless(true);
		}

		else if (option.equals("Incognito")) {
			options = new FirefoxOptions();
			options.addArguments("--incognito");
		}

		return options;
	}

	public static EdgeOptions getEdgeOption(String option) {
		EdgeOptions options = null;
		if (option.equals("Standard")) {
			options = new EdgeOptions();
		}

		else if (option.equals("Incognito")) {
			options = new EdgeOptions();
			options.setCapability("ms:inPrivate", true);
		}

		return options;
	}

	public static ChromeOptions getRemoteChromeOption(String option) {
		ChromeOptions options = null;

		if (option.equals("Standard")) {
			DesiredCapabilities capability = new DesiredCapabilities();
			options = new ChromeOptions();
			capability.setBrowserName("chrome");
			capability.setPlatform(Platform.WINDOWS);
			options.merge(capability);
		}

		else if (option.equals("Headless")) {
			options = new ChromeOptions();
			options.setHeadless(true);
			DesiredCapabilities capability = new DesiredCapabilities();
			capability.setBrowserName("chrome");
			capability.setPlatform(Platform.WINDOWS);
			options.merge(capability);
		}

		else if (option.equals("Incognito")) {
			options = new ChromeOptions();
			options.addArguments("--incognito");
			DesiredCapabilities capability = new DesiredCapabilities();
			capability.setBrowserName("chrome");
			capability.setPlatform(Platform.WINDOWS);
			options.merge(capability);
		}

		return options;
	}

	public static FirefoxOptions getRemoteFirefoxOption(String option) {
		FirefoxOptions options = null;
		if (option.equals("Standard")) {
			DesiredCapabilities capability = new DesiredCapabilities();
			options = new FirefoxOptions();
			capability.setBrowserName("firefox");
			capability.setPlatform(Platform.WINDOWS);
			options.merge(capability);
		}

		else if (option.equals("Headless")) {
			options = new FirefoxOptions();
			options.setHeadless(true);
			DesiredCapabilities capability = new DesiredCapabilities();
			capability.setBrowserName("firefox");
			capability.setPlatform(Platform.WINDOWS);
			options.merge(capability);
		}

		else if (option.equals("Incognito")) {
			options = new FirefoxOptions();
			options.addArguments("--incognito");
			DesiredCapabilities capability = new DesiredCapabilities();
			capability.setBrowserName("firefox");
			capability.setPlatform(Platform.WINDOWS);
			options.merge(capability);
		}

		return options;
	}

	public static EdgeOptions getRemoteEdgeOption(String option) {
		EdgeOptions options = null;
		if (option.equals("Standard")) {
			DesiredCapabilities capability = new DesiredCapabilities();
			options = new EdgeOptions();
			capability.setBrowserName("MicrosoftEdge");
			capability.setPlatform(Platform.WINDOWS);
			options.merge(capability);
		}

		else if (option.equals("Incognito")) {
			options = new EdgeOptions();
			options.setCapability("ms:inPrivate", true);
			DesiredCapabilities capability = new DesiredCapabilities();
			capability.setBrowserName("MicrosoftEdge");
			capability.setPlatform(Platform.WINDOWS);
			options.merge(capability);
		}

		return options;
	}

}
