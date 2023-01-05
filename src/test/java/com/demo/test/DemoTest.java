package com.demo.test;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.demo.mavenone.BaseTest;
import com.demo.mavenone.BaseTest1;
import com.demo.mavenone.BaseTest2;


public class DemoTest extends BaseTest2{

	@Test
	public void loginTest() throws InterruptedException {
		getDriver().get("https://www.gmail.com");
		getDriver().findElement(By.id("identifierId")).sendKeys("rameshsoft.9177791456@gmail.com");
		Thread.sleep(5000);
		getDriver().findElement(By.id("identifierNext")).click();
		Thread.sleep(5000);
		System.out.println("hello");
		System.out.println("hello");
		System.out.println("hello");
		System.out.println("hello");
		System.out.println("Hardwork");
		System.out.println("hello");
		System.out.println("Hardwork");
		System.out.println("Hardwork");
	}
	
}
