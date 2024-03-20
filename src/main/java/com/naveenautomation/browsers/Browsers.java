package com.naveenautomation.browsers;

public enum Browsers {
	CHROME("Chrome"),
	EDGE("Edge"),
	FIREFOX("Firefox");
	
	
	private String browserName;

	Browsers(String browser) {
		this.browserName=browser;
	}

	public String getBrowserName() {
		return browserName;
	}	
}