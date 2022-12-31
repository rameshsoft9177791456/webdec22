package com.demo.mavenone;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

//import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

public class Selenium4Test {

	@Test
	public void login() throws InterruptedException {
		
		//WebDriverManager.chromedriver().setup();
		//WebDriverManager.firefoxdriver().setup();
		//WebDriver driver = new ChromeDriver();
		//WebDriverManager.edgedriver().setup();
		//WebDriver driver = new EdgeDriver();
		WebDriver driver = WebDriverManager.chromedriver().create();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(2));
		driver.get("https://www.gmail.com");
		WebElement userName = driver.findElement(By.id("identifierId"));
		userName.clear();
		userName.sendKeys("Rameshsoft.9177791456@gmail.com");
		
		WebElement nxt = driver.findElement(By.id("identifierNext"));
		nxt.click();
		//WebElement userName = driver.findElement(By.id("identifierId"));
		
		//driver.findElement(with(By.tagName("div")).below(By.xpath("//div[text()='Email or phone']"))).sendKeys("rameshsoft.9177791456");;
		
		//System.out.println("Gmail title is: "+driver.getTitle());
		
		/*//driver.switchTo().newWindow(WindowType.TAB);
		driver.switchTo().newWindow(WindowType.WINDOW);
		
		System.out.println("Title1 is: "+driver.getTitle());
		
		driver.get("https://www.facebook.com");
		String title = driver.getTitle();
		System.out.println("Fb title is: "+title);
		
		Set<String> windows = driver.getWindowHandles();
		
		List<String> list = new ArrayList<String>(windows);
		driver.switchTo().window(list.get(0));
		driver.findElement(By.id("identifierId")).sendKeys(title);
		*/
		Thread.sleep(9000);
		driver.quit();
		
	}
	
}
