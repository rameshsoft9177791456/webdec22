package com.demo.mavenone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {

	@Test
	public void hello() throws InterruptedException {
		System.out.println("maven: hello");
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
		Thread.sleep(5000);
		driver.quit();
	}
	
}
