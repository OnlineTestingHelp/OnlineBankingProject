package com.testng.practice;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

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

public class DragAndDropEx {

	
	WebDriver driver;
	Logger log =(Logger) LogManager.getLogger(DragAndDropEx.class);
	
	@BeforeMethod
	@Parameters(value= {"Browser"})
	public void launch(String browser) {
		log.info("Launching the browser");
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Krish Soft\\Downloads\\chromedriver_win32 (5)\\chromedriver.exe");
		if(browser.toLowerCase().contains("chrome")){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browser.toLowerCase().contains("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(browser.toLowerCase().contains("edge")) {
			WebDriverManager.edgedriver().setup();
			driver =new EdgeDriver();
		}
	}
	
	@AfterMethod
	public void closeBrowser() {
		log.info("Closing the browser");
		driver.quit();
	}
	
	@Test(groups = {"Smoke"})
	public void dragAndDropTest() {
		
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		//It is for all the elements in the script
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.switchTo().frame(0);
		
		Actions a =new Actions(driver);
		WebElement dragA = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement dragB = driver.findElement(By.xpath("//div[@id='droppable']"));
		
		a.dragAndDrop(dragA, dragB).build().perform();
		log.info("Draganddrop functionality is tested");
	}

}
