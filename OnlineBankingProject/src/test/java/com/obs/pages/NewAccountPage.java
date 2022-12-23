package com.obs.pages;

import java.util.HashMap;
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

public class NewAccountPage {

	Logger log = (Logger) LogManager.getLogger(NewAccountPage.class);
	WebDriver driver;
	ExtentTest test;
	

	@FindBy(xpath="//p[normalize-space()='New Account']")
	WebElement NewAccount;
	
	@FindBy(xpath = "//input[@name='account_number']")
	WebElement accountNumber;
	
	@FindBy(xpath="//input[@name='firstname']")
	WebElement FirstName;
	
	@FindBy(xpath="//input[@placeholder='(optional)']")
	WebElement middleName;
	
	@FindBy(xpath="//input[@name='lastname']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@name='email']")
	WebElement email;
	
	@FindBy(xpath="//input[@name='generated_password']")
	WebElement password;
	
	@FindBy(xpath="//input[@name='pin']")
	WebElement pin;
	
	@FindBy(xpath="//input[@name='balance']")
	WebElement balance;
	
	@FindBy(xpath="//button[@class='btn btn-primary mr-2']")
	WebElement save;
	
	@FindBy(xpath="//a[normalize-space()='Cancel']")
	WebElement Cancel;
	
	public NewAccountPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		driver.manage().timeouts().implicitlyWait(StandardWaitTimes.waitTime, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
	}
	
	//New Account Page
	@SuppressWarnings("unlikely-arg-type")
	public void NewUserCreation(HashMap<String,String> data) {
		NewAccount.click();
		accountNumber.sendKeys(data.get("accountNumber"));
		FirstName.sendKeys(data.get("FirstName"));
		middleName.sendKeys(data.get("middleName"));
		lastName.sendKeys(data.get("lastName"));
		email.sendKeys(data.get("email"));
		password.sendKeys(data.get("password"));
		pin.sendKeys(data.get("pin"));
		balance.sendKeys(data.get("balance"));
		save.click();

	}
	
}
