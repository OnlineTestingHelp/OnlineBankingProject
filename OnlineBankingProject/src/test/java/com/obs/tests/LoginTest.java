package com.obs.tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.obs.base.BasePage;
import com.obs.listeners.ListenerClass;
import com.obs.pages.AdminHomePage;
import com.obs.pages.AdminLoginPage;
import com.obs.utilities.ReadProperties;



public class LoginTest extends BasePage{
	
	@Test
	public void verifyLogin() throws IOException, InterruptedException {

		//Verify admin login and check the login
		String url,userName,Password;
		
		url = ReadProperties.readProp("AdminURL");
		userName = ReadProperties.readProp("AdminUN");
		Password = ReadProperties.readProp("AdminPwd");
		
		AdminLoginPage login = new AdminLoginPage(driver,test);
		login.launchApp(url);
		login.login(userName, Password);
		
		AdminHomePage adminHomePage = new AdminHomePage(driver,test);
		adminHomePage.verifyHomePageText();
		adminHomePage.logout();
		
	}
	
}
