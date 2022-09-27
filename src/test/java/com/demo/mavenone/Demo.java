package com.demo.mavenone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {

	@Parameters({"Choice"})
	@Test
	public void hello(@Optional("chrome")String browser) throws InterruptedException {
		String choice = System.getProperty("Choice");
		System.out.println("Choice is: "+choice);
		if (browser.equalsIgnoreCase("chrome")) {
			System.out.println("mavenone: hello");
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.gmail.com");
			WebElement un = driver.findElement(By.id("identifierId"));
			Assert.assertTrue(un.isDisplayed()&&un.isEnabled());
			un.sendKeys("java");
			//Thread.sleep(5000);
			//WebDriverManager.chromedriver().create();
			System.out.println("@Test: hello()");
			System.out.println("BROWSER: "+browser);
			Thread.sleep(5000);
			driver.quit();
		}
		else {
			System.out.println("Hello: "+browser);
			System.out.println("hello");
			System.out.println("hello");
		}
		
		
	}
	
}
