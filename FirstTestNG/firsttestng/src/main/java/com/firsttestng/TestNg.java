package com.firsttestng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestNg {
	  
	public static WebDriver driver;
	@Test
	   public void testAdd() {
		System.setProperty("webdriver.chrome.driver", "/home/thrymr/Desktop/chromedriver");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8080");
		driver.close();
	}
}
