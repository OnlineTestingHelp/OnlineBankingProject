package com.testng.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownEx {
	
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
	
	@Test(groups = {"Sanity"})
	public void dropdown() throws InterruptedException {
		
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Dropdowns
		Select drp = new Select(driver.findElement(By.xpath("//select[@name='country']")));
		List<WebElement> allItems = drp.getOptions();
		
		System.out.println("Dropdown size is "+ allItems.size());
		
		for(int i=0;i<allItems.size();i++) {
			System.out.println("Element text is "+ allItems.get(i).getText());
		}
		
		//Select the item in dropdown
		drp.selectByIndex(10);
		Thread.sleep(3000);
		drp.selectByValue("ESTONIA");
		Thread.sleep(3000);
		drp.selectByVisibleText("INDIA");
	}
	

}
