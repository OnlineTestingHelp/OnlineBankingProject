package com.obs.pages;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.obs.common.StandardWaitTimes;
import com.obs.tests.LoginTest;

public class UserHomePage  {
	
	Logger log = (Logger) LogManager.getLogger(UserHomePage.class);
	
	WebDriver driver;
	ExtentTest test;
	
	@FindBy(xpath = "//h1[normalize-space()='Welcome to Online Banking System']")
	WebElement WelcomeText;
	
	@FindBy(xpath="//span[@class='ml-3']")
	WebElement profileIcon;
	
	@FindBy(xpath="//a[normalize-space()='Logout']")
	WebElement logout;
	
	@FindBy(xpath="//h3[contains(normalize-space(),'Current Balance: ')]")
	WebElement CurrentBalance;

	public UserHomePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		driver.manage().timeouts().implicitlyWait(StandardWaitTimes.waitTime, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
	}
	
	public void verifyWelcomeText() {
		if(WelcomeText.isDisplayed()) {
			Assert.assertTrue(true, "User Home page is displayed successfully");
			test.log(Status.PASS, "User Home page is displayed successfully");
			log.info("User Home page is displayed successfully");
		}else {
			test.log(Status.FAIL, "User Home page is NOT displayed");
			log.info("User Home page is NOT displayed");
			Assert.assertTrue(false, "User Home page is NOT displayed");
		}

	}
	
	//For logout of admin user
	public void logout() throws InterruptedException {
			profileIcon.click();
			logout.click();
	}
	
	public void verifyAmount(int amount) {
		String current_Balance = CurrentBalance.getText();
		
		String[] balance = current_Balance.split(" ");
		String original_bal = balance[2].replace(",", "");
		
		int balanceValue = Double.valueOf(original_bal).intValue();
		
		if(balanceValue!=amount) {
			Assert.assertTrue(true, "Verified deposit happened successfully");
			test.log(Status.PASS, "Verified deposit happened  successfully");
			log.info("Verified deposit happened  successfully");
		}else {
			test.log(Status.FAIL, "Deposit is not working");
			log.info("Deposit is not working");
			Assert.assertTrue(false, "Deposit is not working");
		}
	}

}
