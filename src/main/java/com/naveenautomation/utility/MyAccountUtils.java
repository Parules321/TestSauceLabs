package com.naveenautomation.utility;

public class MyAccountUtils {
	public static void sleep(long milli) {
		try {
			Thread.sleep(milli);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}