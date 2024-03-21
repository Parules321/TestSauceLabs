package com.naveenautomation.browsers;

public enum Browsers {
	CHROME("chrome"),
	EDGE("MicrosoftEdge"),
	FIREFOX("firefox");
	
	
	private String browserName;

	Browsers(String browser) {
		this.browserName=browser;
	}

	public String getBrowserName() {
		return browserName;
	}	
}