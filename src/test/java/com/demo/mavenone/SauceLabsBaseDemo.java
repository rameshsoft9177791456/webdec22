package com.demo.mavenone;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class SauceLabsBaseDemo {

	private WebDriver driver;

	@Parameters({"browser"})
	@BeforeMethod
	public void openBrowser(@Optional("chrome") String browser, Method method) throws MalformedURLException {

		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setPlatformName("Windows 10");
			chromeOptions.setBrowserVersion("latest");

			Map<String, Object> sauceOptions = new HashMap<String, Object>();
			sauceOptions.put("TCName", " :Current Execution TC Name " + method.getName());
			sauceOptions.put("build", "regression");
			sauceOptions.put("username", "oauth-rameshsoft.selenium1-7b549");
			sauceOptions.put("accessKey", "79b69d2b-c299-464a-ba0f-d03f7a679531");
			chromeOptions.setCapability("sauce:options", sauceOptions);
			URL remoteAddUrl = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
			driver = new RemoteWebDriver(remoteAddUrl, chromeOptions);
		} else if (browser.equalsIgnoreCase("edge")) {
			EdgeOptions edgeOptions = new EdgeOptions();
			edgeOptions.setPlatformName("Windows 10");
			edgeOptions.setBrowserVersion("latest");

			Map<String, Object> sauceOptions = new HashMap<String, Object>();
			sauceOptions.put("TCName", " :Current Execution TC Name " + method.getName());
			sauceOptions.put("build", "regression");
			sauceOptions.put("username", "oauth-rameshsoft.selenium1-7b549");
			sauceOptions.put("accessKey", "79b69d2b-c299-464a-ba0f-d03f7a679531");
			edgeOptions.setCapability("sauce:options", sauceOptions);
			URL remoteAddUrl = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
			driver = new RemoteWebDriver(remoteAddUrl, edgeOptions);
		}

		else if (browser.equalsIgnoreCase("firefox")) {
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.setPlatformName("Windows 10");
			firefoxOptions.setBrowserVersion("latest");

			Map<String, Object> sauceOptions = new HashMap<String, Object>();
			sauceOptions.put("TCName", " :Current Execution TC Name " + method.getName());
			sauceOptions.put("build", "regression");
			sauceOptions.put("username", "oauth-rameshsoft.selenium1-7b549");
			sauceOptions.put("accessKey", "79b69d2b-c299-464a-ba0f-d03f7a679531");
			firefoxOptions.setCapability("sauce:options", sauceOptions);
			URL remoteAddUrl = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
			driver = new RemoteWebDriver(remoteAddUrl, firefoxOptions);
		}
		else if (browser.equalsIgnoreCase("ie")) {
			InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
			internetExplorerOptions.setPlatformName("Windows 10");
			internetExplorerOptions.setBrowserVersion("latest");

			Map<String, Object> sauceOptions = new HashMap<String, Object>();
			sauceOptions.put("TCName", " :Current Execution TC Name " + method.getName());
			sauceOptions.put("build", "regression");
			sauceOptions.put("username", "oauth-rameshsoft.selenium1-7b549");
			sauceOptions.put("accessKey", "79b69d2b-c299-464a-ba0f-d03f7a679531");
			internetExplorerOptions.setCapability("sauce:options", sauceOptions);
			URL remoteAddUrl = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
			driver = new RemoteWebDriver(remoteAddUrl, internetExplorerOptions);
		}

	}
	@AfterMethod
	public void closeBrowser() {
		if (driver!=null) {
			driver.close();
		}
		else {
			//throw exception
		}
	}

	public WebDriver getDriver() {
		return driver;
	}
	
}
