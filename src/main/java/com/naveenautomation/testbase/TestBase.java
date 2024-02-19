package com.naveenautomation.testbase;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	public static String browserName;

	public void intialisation() {
		browserName = getBrowserName();
		if (browserName.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equals("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
	}

	public void tearDown() {
		driver.close();
	}

	public String getBrowserName() {
		String[] browsers = { "Chrome", "Firefox", "Edge" };
		int browserNameIndex = new java.util.Random().nextInt(browsers.length);
		String browser = browsers[browserNameIndex];
		return browser;
	}

	public String getFirstName() {
		String firstName = RandomStringUtils.randomAlphabetic(1, 30);
		return firstName;
	}

	public String getLastName() {
		String lastName = RandomStringUtils.randomAlphabetic(1, 30);
		return lastName;
	}

	public String getPhoneNo() {
		String phoneNo = RandomStringUtils.randomNumeric(10);
		return phoneNo;
	}

	public String getEmail() {
		String email = RandomStringUtils.randomAlphanumeric(1, 25) + "@example.com";
		return email;
	}

	public String getPassword() {
		String password = RandomStringUtils.random(8,
				"0123456789!@#$%^&*()_-+=<>?ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz");
		return password;
	}

	public String getRecipientName() {
		String recipientFirstName = RandomStringUtils.randomAlphabetic(1, 30);
		String recipientLastName = RandomStringUtils.randomAlphabetic(1, 30);
		String recipientName = recipientFirstName + " " + recipientLastName;
		return recipientName;
	}

	public String getRecipientEmail() {
		String recipientEmail = RandomStringUtils.randomAlphanumeric(1, 50) + "@example.com";
		return recipientEmail;
	}

	public String getAmount() {
		String amount = RandomStringUtils.randomNumeric(2, 4);
		return amount;
	}

}
