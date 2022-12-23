package com.obs.base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	public static WebDriver driver;
	public ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent = new ExtentReports();  ;
	public static ExtentTest test;
	
	@BeforeSuite
	public void initialyeReport() {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/ExtentReport.html");
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "Venkata Krishna");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User Name", "Venkat");
		htmlReporter.config().setDocumentTitle("Extent Report "); 
		htmlReporter.config().setReportName("OBS Report "); 
		htmlReporter.config().setTheme(Theme.STANDARD);
	}
	
	@AfterSuite
	public void cleanup() {
		extent.flush();
	}
	
	
	@BeforeMethod
	@Parameters(value= {"Browser"})
	public void launch(String browser,Method m) {
		test = extent.createTest(m.getName());
		if(browser.toLowerCase().contains("chrome")){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browser.toLowerCase().contains("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(browser.toLowerCase().contains("edge")) {
			WebDriverManager.edgedriver().setup();
			driver =new EdgeDriver();
		}
	}
	
	@AfterMethod
	public void closeBrowser(ITestResult result) {
		driver.quit();
	}
}
