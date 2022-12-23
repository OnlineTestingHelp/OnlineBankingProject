package com.obs.tests;

import java.io.IOException;
import java.util.HashMap;

import javax.swing.text.Utilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.obs.base.BasePage;
import com.obs.pages.AdminHomePage;
import com.obs.pages.AdminLoginPage;
import com.obs.pages.NewAccountPage;
import com.obs.pages.TransactionsPage;
import com.obs.pages.UserHomePage;
import com.obs.pages.UserLoginPage;
import com.obs.utilities.RandomNumber;
import com.obs.utilities.ReadProperties;

public class VerifyDepositAmount extends BasePage{

	String url,userName,Password;
	long accountNumber = RandomNumber.getRandomNumber();
	String emailId = "onlinetestinghelp"+accountNumber+"@gmail.com";
	String userPwd = "123456";
	String deposit_Amount = "10000";
	int expected_Balance = 1010000;

	@Test
	public void verifyDepositAmount() throws IOException, InterruptedException {
		
		url = ReadProperties.readProp("AdminURL");
		userName = ReadProperties.readProp("AdminUN");
		Password = ReadProperties.readProp("AdminPwd");
		
		AdminLoginPage login = new AdminLoginPage(driver,test);
		login.launchApp(url);
		login.login(userName, Password);
		
		AdminHomePage adminHomePage = new AdminHomePage(driver,test);
		adminHomePage.verifyHomePageText();
		
		//Click on account management
		adminHomePage.clickOnAccMgmt();
		
		//Click on New Account
		HashMap<String,String> testData = new HashMap<String,String>();
		testData.put("accountNumber", String.valueOf(accountNumber));
		testData.put("FirstName", "Venkat");
		testData.put("middleName", "Krishna");
		testData.put("lastName", "VK");
		testData.put("email", emailId);
		testData.put("password", userPwd);
		testData.put("pin", "1234");
		testData.put("balance", "100000");
		
		NewAccountPage newAccount = new NewAccountPage(driver, test);
		newAccount.NewUserCreation(testData);
		//Deposit Operation
		TransactionsPage transactions = new TransactionsPage(driver, test);
		transactions.clickOnTransaction();
		transactions.clickonDeposit();
		transactions.deposit_Amount(String.valueOf(accountNumber), deposit_Amount);
		
		adminHomePage.logout();
		
		//User Login
		login.gotoUserLogin();
		UserLoginPage userPage = new UserLoginPage(driver, test);
		userPage.userLogin(emailId, userPwd);
		
		UserHomePage userHome = new UserHomePage(driver, test);
		userHome.verifyWelcomeText();
		
		//Verify Deposit Amount
		userHome.verifyAmount(expected_Balance);
		
		//Logout
		userHome.logout();
		

	}
	
}
