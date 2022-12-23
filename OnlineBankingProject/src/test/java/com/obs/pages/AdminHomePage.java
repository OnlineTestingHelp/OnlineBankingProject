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

public class AdminHomePage {

	Logger log = (Logger) LogManager.getLogger(AdminHomePage.class);
	WebDriver driver;
	ExtentTest test;
	
	@FindBy(xpath="//h1[normalize-space()='Welcome to Online Banking System']")
	WebElement homePageText;
	
	@FindBy(xpath="//p[normalize-space()='Account Management']")
	WebElement accountManagement;
	
	@FindBy(xpath="//p[normalize-space()='Transaction']")
	WebElement transaction;
	
	@FindBy(xpath="//p[normalize-space()='Announcements']")
	WebElement announcements;
	
	@FindBy(xpath="//span[@class='ml-3']")
	WebElement profileIcon;
	
	@FindBy(xpath="//a[normalize-space()='Logout']")
	WebElement logout;
	
	public AdminHomePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		driver.manage().timeouts().implicitlyWait(StandardWaitTimes.waitTime, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		PageFactory.initElements(driver, this);
	}
	
	//Verify home page text
	public void verifyHomePageText() {
		if(homePageText.isDisplayed()) {
			Assert.assertTrue(true, "Home page is displayed successfully");
			test.log(Status.PASS, "Home page is displayed successfully");
			log.info("Home page is displayed successfully");
		}else {
			Assert.assertTrue(false, "Home page is NOT displayed");
			test.log(Status.FAIL, "Home page is NOT displayed");
			log.info("Home page is NOT displayed");
		}
	}
	
	//Click on Account management
	public void clickOnAccMgmt() {
		accountManagement.click();
	}
	
	//Click on Transactions
	public void transaction() {
		transaction.click();
	}
	
	//Click on announcements
	public void announcements() {
		announcements.click();
	}
	
	//For logout of admin user
	public void logout() throws InterruptedException {
			Thread.sleep(5000);
			profileIcon.click();
			logout.click();
	}
	
}
