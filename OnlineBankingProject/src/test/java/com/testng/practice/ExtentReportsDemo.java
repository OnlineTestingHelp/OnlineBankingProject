package com.testng.practice;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportsDemo {
	public WebDriver driver;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;

	@BeforeSuite
	public void launchReport() {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/ExtentReport.html");
		extent = new ExtentReports();  
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "Venkata Krishna");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User Name", "Venkat");
		htmlReporter.config().setDocumentTitle("Extent Report "); 
		htmlReporter.config().setReportName("OBS Report "); 
		htmlReporter.config().setTheme(Theme.STANDARD);

	}
	
	@BeforeMethod
	public void preRequisite() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void testCase1() {
		driver.get("https://www.google.com/");
		test = extent.createTest("To verify Google Title");
		Assert.assertEquals(driver.getTitle(),"Google");
	}
	
	@Test
	public void testCase2() {
		driver.get("https://www.google.com/");
		test = extent.createTest("To verify Google Title2");
		Assert.assertEquals(driver.getTitle(),"Google2");
	}
	
	@AfterMethod
	public void afterTest(ITestResult result) throws IOException {
		if(result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test case is working fine");
			
		}else if(result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test case is Failed");
			String screenshotPath = getScreenShot(driver, result.getName());
			//To add it in the extent report 
			test.fail("Test Case Failed Snapshot is below " + test.addScreenCaptureFromPath(screenshotPath));
		}
		driver.quit();
	}
	
	@AfterSuite
	public void cleanup() {
		extent.flush();
	}
	
	public static String getScreenShot(WebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots" under src folder
		String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
	
}
