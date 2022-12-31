package com.demo.mavenone;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest2 {

	WebDriver driver;
	
	@Parameters({"browser"})
	@BeforeMethod
	public void setUp(@Optional("chrome")String browser,Method method) throws MalformedURLException {
		
		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
	        options.setPlatformName("Windows 10");
	        options.setBrowserVersion("latest");

	        Map<String, Object> sauceOptions = new HashMap<>();
	        sauceOptions.put("name",method.getName()+"  EXECUTING IN CHROME BROWSER");
			sauceOptions.put("build", "regression");
			sauceOptions.put("username","oauth-rameshsoft.selenium1-7b549");
			sauceOptions.put("accessKey", "79b69d2b-c299-464a-ba0f-d03f7a679531");
	        options.setCapability("sauce:options", sauceOptions);
	        URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
	        //WebDriverManager.chromedriver().setup();
	        driver = new RemoteWebDriver(url, options);
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			FirefoxOptions browserOptions = new FirefoxOptions();
			browserOptions.setPlatformName("Windows 10");
			browserOptions.setBrowserVersion("latest");
			browserOptions.setAcceptInsecureCerts(true);
			browserOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.IGNORE);
			Map<String, Object> sauceOptions = new HashMap<>();
			sauceOptions.put("name",method.getName()+"  EXECUTING IN FIREFOX BROWSER");
			sauceOptions.put("build", "regression");
			sauceOptions.put("username","oauth-rameshsoft.selenium1-7b549");
			sauceOptions.put("accessKey", "79b69d2b-c299-464a-ba0f-d03f7a679531");
			browserOptions.setCapability("sauce:options", sauceOptions);
	        URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
	        
	        //WebDriverManager.firefoxdriver().setup();
	        driver = new RemoteWebDriver(url, browserOptions);	
		}
		else if (browser.equalsIgnoreCase("edge")) {
			EdgeOptions browserOptions = new EdgeOptions();
			browserOptions.setPlatformName("Windows 10");
			browserOptions.setBrowserVersion("latest");
			Map<String, Object> sauceOptions = new HashMap<>();
			sauceOptions.put("name",method.getName()+"  EXECUTING IN EDGE BROWSER");
			sauceOptions.put("username","oauth-rameshsoft.selenium1-7b549");
			sauceOptions.put("accessKey", "79b69d2b-c299-464a-ba0f-d03f7a679531");
			browserOptions.setCapability("sauce:options", sauceOptions);
	        URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
	        
	        //WebDriverManager.firefoxdriver().setup();
	        driver = new RemoteWebDriver(url, browserOptions);	
		}
		else if (browser.equalsIgnoreCase("ie")) {
			InternetExplorerOptions browserOptions = new InternetExplorerOptions();
			browserOptions.setPlatformName("Windows 10");
			browserOptions.setBrowserVersion("11");
			Map<String, Object> sauceOptions = new HashMap<>();
			sauceOptions.put("name",method.getName()+"  EXECUTING IN IE BROWSER");
			sauceOptions.put("build", "build456");
			sauceOptions.put("username","oauth-rameshsoft.selenium1-7b549");
			sauceOptions.put("accessKey", "79b69d2b-c299-464a-ba0f-d03f7a679531");
	        browserOptions.setCapability("sauce:options", sauceOptions);
			URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
	        driver = new RemoteWebDriver(url, browserOptions);	
		}
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
