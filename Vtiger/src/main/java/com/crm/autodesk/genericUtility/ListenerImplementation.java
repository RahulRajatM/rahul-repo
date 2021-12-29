package com.crm.autodesk.genericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementation implements ITestListener{

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailure(ITestResult result) {
		//get a random number
		int num = new JavaUtility().getRandomNumber();
		//get method name
		//String methodName = result.getMethod().getMethodName();
		String methodName = result.getName();
		//get current date
		String currentDate = new JavaUtility().getSystemDateWithFormat();
		//concatenate method name with date and num
		String screenshotName = methodName+"_"+num+"_"+currentDate;
		//take screenshot
		try {
			new WebDriverUtility().takeScreenShot(BaseClass.sdriver, screenshotName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}


}
