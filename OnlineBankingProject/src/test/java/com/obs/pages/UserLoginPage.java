package com.obs.pages;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.obs.common.StandardWaitTimes;
import com.obs.tests.LoginTest;

public class UserLoginPage  {
	
	Logger log = (Logger) LogManager.getLogger(UserLoginPage.class);
	
	WebDriver driver;
	ExtentTest test;
	
	@FindBy(xpath = "//input[@name='email']")
	WebElement emailField;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordField;
	
	@FindBy(xpath = "//button[normalize-space()='Login']")
	WebElement loginbtn;

	
	public UserLoginPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		driver.manage().timeouts().implicitlyWait(StandardWaitTimes.waitTime, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
	}
	
	public void userLogin(String email,String password) throws InterruptedException {
		emailField.sendKeys(email);
		passwordField.sendKeys(password);
		//loginbtn.click();
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", loginbtn);
		Thread.sleep(3000);
	}
	
}
