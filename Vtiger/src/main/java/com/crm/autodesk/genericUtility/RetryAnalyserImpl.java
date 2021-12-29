package com.crm.autodesk.genericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyserImpl implements IRetryAnalyzer {

	int count=0;
	int retryCount=5;
	public boolean retry(ITestResult result) {
		while(count<retryCount)
		{
			count++;
			return true;
		}
		return false;
	}
}
