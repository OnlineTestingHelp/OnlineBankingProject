package com.obs.pages;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.obs.common.StandardWaitTimes;
import com.obs.tests.LoginTest;

public class AdminLoginPage  {
	
	Logger log = (Logger) LogManager.getLogger(AdminLoginPage.class);
	
	WebDriver driver;
	ExtentTest test;
	
	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement UserName;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement Password;
	
	@FindBy(xpath = "//button[normalize-space()='Sign In']")
	WebElement SignIn;
	
	@FindBy(xpath = "//a[normalize-space()='Go to Website']")
	WebElement goToWebSite;
	
	public AdminLoginPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		driver.manage().timeouts().implicitlyWait(StandardWaitTimes.waitTime, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
	}
	
	public void login(String UN, String Pwd) {
		try {
			test.log(Status.PASS, "Verifying admin user login");
			log.info("Verifying admin user login");
			UserName.sendKeys(UN);
			Password.sendKeys(Pwd);
			SignIn.click();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void gotoUserLogin() {
		try {
		test.log(Status.PASS, "Verifying gotoWebSite Link");
		log.info("Verifying gotoWebSite Link");
		goToWebSite.click();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void launchApp(String URL) {
		try {
		test.log(Status.PASS, "Verifying open admin user login");
		log.info("Verifying open admin user login");
		driver.get(URL);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
