package com.demo.mavenone;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerDemo {
public static void main(String[] args) throws InterruptedException, IOException {
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	
	List<String> list = WebDriverManager.chromedriver().getDriverVersions();
	//case1: for each loop
	for(String str : list)
	{
		System.out.println(str);
	}
	/*//case2: normal for loop
	for(int i=0; i<list.size(); i++)
	{
		System.out.println(list.get(i));
	}
	//case3: using cursors
	Iterator<String> itr = list.iterator();
	while(itr.hasNext())
	{
		String str = itr.next();
		System.out.println(str);
	}
	
	//case4:
	Stream<String> stream = list.stream();
	stream.forEach(ele->System.out.println(ele));
	
	Stream<String> stream1 = list.parallelStream();
	//stream1.forEach(ele->System.out.println(ele));
	stream1.forEach(System.out::println);
	
	*/
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	//driver.manage().timeouts().implicitlyWait(59, TimeUnit.SECONDS);
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
	
	driver.get("https://www.gmail.com");
	String driverPath = WebDriverManager.chromedriver().getDownloadedDriverPath();
	System.out.println("Driver path is: "+driverPath);
	
	String driverVersion = WebDriverManager.chromedriver().getDownloadedDriverVersion();
	System.out.println("Driver version is: "+driverVersion);
	
	WebElement userName = driver.findElement(By.id("identifierId"));
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
	wait.until(ExpectedConditions.visibilityOf(userName));
	File un1 = userName.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(un1, new File("D:\\new8amapr22\\mavenone\\target\\Screenshots\\unelement1.jpeg"));
	
	userName.clear();
	userName.sendKeys("rameshsoft.9177791456@gmail.com");
	
	File un = userName.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(un, new File("D:\\new8amapr22\\mavenone\\target\\Screenshots\\unelement2.jpeg"));
	
	WebElement nxt = driver.findElement(By.id("identifierNext"));
	nxt.click();
	Thread.sleep(5000);
	TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
	File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(file, new File("D:\\new8amapr22\\mavenone\\target\\Screenshots\\homepage.jpeg"));
	
	Thread.sleep(5000);
	driver.close();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
}
