package com.demo.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.demo.mavenone.SauceLabsBaseDemo;

public class SauceLabsTest extends SauceLabsBaseDemo{

	@Test
	public void sauceLabsTest() throws InterruptedException {
		getDriver().get("https://www.gmail.com");
		Thread.sleep(5000);
		WebElement un = getDriver().findElement(By.id("identifierId"));
		un.clear();
		un.sendKeys("rameshsoft.9177791456");
		Thread.sleep(5000);
		WebElement nxt = getDriver().findElement(By.id("identifierNext"));
		nxt.click();
		Thread.sleep(5000);
		System.out.println("hello");
		Thread.sleep(5000);
	}
	
}
