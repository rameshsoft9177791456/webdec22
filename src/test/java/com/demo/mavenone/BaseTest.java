package com.demo.mavenone;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	WebDriver driver;
	
	@Parameters({"browser"})
	@BeforeMethod
	public void setUp(@Optional("chrome")String browser,Method method) throws MalformedURLException {
		MutableCapabilities mc = new MutableCapabilities();
		mc.setCapability("name", method.getName());
		mc.setCapability("seleniumVersion", "5.2.3");
		mc.setCapability("username", "oauth-rameshsoft.cucumber-9eabe");
		mc.setCapability("accessKey", "50d7bbaa-90a4-45bc-a7b6-27d37f868f76");
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("sauce:options", mc);
		dc.setCapability("browserVersion", "latest");
		dc.setCapability("platformName", "windows 10");
		
		
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			dc.setCapability("browserName", "chrome");
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			
			dc.setCapability("browserName", "firefox");
			dc.setCapability("browserVersion", "106");
			WebDriverManager.firefoxdriver().setup();
			
			//dc.setCapability("browserVersion", "106");
		}
		driver = new RemoteWebDriver(new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub"),dc);
		System.out.println("Browser: "+driver);
		System.out.println("Browser name: "+browser);
	}
	@AfterMethod
	public void closeBrowser() {
		if (driver!=null) {
			driver.close();
		}
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
}
