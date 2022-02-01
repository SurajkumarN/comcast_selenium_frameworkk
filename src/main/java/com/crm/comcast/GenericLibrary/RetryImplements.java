package com.crm.comcast.GenericLibrary;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImplements implements IRetryAnalyzer {

	int counter = 0;
	int retrylimit = 3;

	@Override
	public boolean retry(ITestResult result) {
		if (counter < retrylimit) {
			counter++;
			return true;
		}
		return false;
	}

}
