package com.testng.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class AlertsEx {

	
	
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
	
	@Test(groups = {"Regression"})
	public void alertsTest() {
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		//It is for all the elements in the script
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//--------------------------------Simple JS with ok button------------------------------------
		//Click on button
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
		
		//It is for only perticular element
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.alertIsPresent());
		
		//Text
		String text = driver.switchTo().alert().getText();
		System.out.println("Alert text is "+ text);
		
		//Click on ok button
		driver.switchTo().alert().accept();
		
		text = driver.findElement(By.xpath("//p[@id='result']")).getText();
		System.out.println("Message text is "+ text);
		
		//--------------------------------Simple JS with ok and cancel------------------------------------
		//Click on button
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
		
		//It is for only perticular element
		 wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.alertIsPresent());
		
		//Text
		text = driver.switchTo().alert().getText();
		System.out.println("Alert text is "+ text);
		
		//Click on ok button
		driver.switchTo().alert().dismiss();
		
		text = driver.findElement(By.xpath("//p[@id='result']")).getText();
		System.out.println("Message text is "+ text);
		
		//--------------------------------Simple JS with ok and cancel and enter data in alert------------------------------------
		//Click on button
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
		
		//It is for only perticular element
		 wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.alertIsPresent());
		
		//Text
		text = driver.switchTo().alert().getText();
		System.out.println("Alert text is "+ text);
		
		//Click on ok button
		driver.switchTo().alert().sendKeys("This is my alert");
		driver.switchTo().alert().accept();
		
		text = driver.findElement(By.xpath("//p[@id='result']")).getText();
		System.out.println("Message text is "+ text);

	}

}
