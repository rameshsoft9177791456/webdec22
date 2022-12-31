package com.demo.mavenone;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.http.ClientConfig;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest1 {

	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		FirefoxOptions browserOptions = new FirefoxOptions();
		browserOptions.setPlatformName("Windows 10");
		browserOptions.setBrowserVersion("latest");
		browserOptions.setAcceptInsecureCerts(true);
		browserOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.IGNORE);

		Map<String, Object> sauceOptions = new HashMap<>();
		sauceOptions.put("name","demo456");
		sauceOptions.put("build", "build456");
		sauceOptions.put("username","oauth-rameshsoft.cucumber-9eabe");
		sauceOptions.put("accessKey", "50d7bbaa-90a4-45bc-a7b6-27d37f868f76");

		/*ClientConfig config = ClientConfig.defaultConfig()
		        .connectionTimeout(Duration.ofMinutes(5))
		        .readTimeout(Duration.ofMinutes(3));*/

		driver = RemoteWebDriver.builder()
		        .oneOf(browserOptions)
		        .setCapability("sauce:options", sauceOptions)
		        .address("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub")
		        //.config(config)
		        .build();
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
