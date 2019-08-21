package com.wait.Qa;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * Synchronization in selenium means implicit wait and explicit wait
 * Thread.sleep(2000) is static wait
 * 
 * */

public class SynchronizationInSelenium {

	public static void main(String[] args)
	{
		
		System.setProperty ("webdriver.chrome.driver","/home/qainfotech/Downloads/chromedriver" );
		WebDriver driver = new ChromeDriver(); 
		
		//Dynamic wait
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.get("http://demo.guru99.com/V4/");
		
		WebElement username=driver.findElement(By.name("uid"));
		WebElement password=driver.findElement(By.name("password"));
		WebElement btn=driver.findElement(By.name("btnLogin"));
		
		sendKeys(driver, username, 10, "Tom");
		sendKeys(driver, password,5, "12345");
		clickOn(driver, btn, 10);
		

	}
	
	
	public static void sendKeys(WebDriver driver , WebElement element , int timeout , String value)
	{
		
		new WebDriverWait(driver, timeout).
		until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
		
	}
	
	public static void clickOn(WebDriver driver , WebElement element, int timeout)
	{
		new WebDriverWait(driver, timeout).
		until(ExpectedConditions.visibilityOf(element));
		element.click();
		
		
	}

}
