package com.testng.practice;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

	public void onFinish(ITestContext context) {

	}

	public void onStart(ITestContext context) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onTestFailure(ITestResult result) {
//		//Takes the screenshot
//		System.out.println("Screenshot is captured");
//		if(result.getStatus() == ITestResult.SUCCESS) {
//		test.log(Status.PASS, "Test case is working fine");
//		
//	}else if(result.getStatus() == ITestResult.FAILURE) {
//		test.log(Status.FAIL, "Test case is Failed");
//		String screenshotPath = getScreenShot(driver, result.getName());
//		//To add it in the extent report 
//		test.fail("Test Case Failed Snapshot is below " + test.addScreenCaptureFromPath(screenshotPath));
//	}

	}

	public void onTestSkipped(ITestResult result) {

	}

	public void onTestStart(ITestResult result) {

	}

	public void onTestSuccess(ITestResult result) {

	}

}
