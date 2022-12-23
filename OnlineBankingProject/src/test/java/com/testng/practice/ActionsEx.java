package com.testng.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsEx {
	
	WebDriver driver;
	
	@BeforeMethod
	@Parameters(value= {"Browser"})
	public void launch(String browser) {
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Krish Soft\\Downloads\\chromedriver_win32 (5)\\chromedriver.exe");
		if(browser.toLowerCase().contains("chrome")){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browser.toLowerCase().contains("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(browser.toLowerCase().contains("edge")) {
			WebDriverManager.edgedriver().setup();
			driver =new EdgeDriver();
		}
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	@Test(groups = {"Smoke"})
	public void actionsTest() {
		
		driver.get("https://the-internet.herokuapp.com/jqueryui/menu");
		driver.manage().window().maximize();
		//It is for all the elements in the script
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement enabled = driver.findElement(By.xpath("//a[normalize-space()='Enabled']"));
		WebElement downloads = driver.findElement(By.xpath("//a[normalize-space()='Downloads']"));
		WebElement excel = driver.findElement(By.xpath("//a[normalize-space()='Excel']"));
		
		Actions a = new Actions(driver);
		a.moveToElement(enabled).pause(2000).moveToElement(downloads).pause(2000).moveToElement(excel).click().build().perform();

	}

}
