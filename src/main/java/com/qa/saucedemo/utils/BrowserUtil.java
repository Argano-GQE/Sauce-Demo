package com.qa.saucedemo.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserUtil {
	
	private WebDriver driver;

	/**
	 * This Method is used to initialize the driver based on given browser
	 * 
	 * @param browserName
	 */
	public WebDriver launchBrowser(String browserName) {

		System.out.println("Browser Name is : " + browserName);

		if (browserName == null) {
			System.out.println("Browser Name Can't Null");
			//throw new FrameworkExcepetion("Browser Name Can't Null");
		}

		switch (browserName.toLowerCase().trim()) {
		case "chrome":
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;

		default:
			System.out.println("Please pass the correct browser->" +":" +browserName);
			//throw new FrameworkExcepetion("Not a Valid Browser");
		}
		
		return driver;

	}
/**
 * 
 * @param url
 */
	
	public void enterURL(String url) {

		if (url.contains("http")) {

			driver.get(url);
		} else {
			//throw new FrameworkExcepetion("Url should have http(s)");
		}

	}

	public String getPageTitle() {
		
		System.out.println(driver.getTitle());
		return driver.getTitle();
	}

	public String getCurrentURL() {
		
		System.out.println(driver.getCurrentUrl());
		return driver.getCurrentUrl();
	}

	public void quitBrowser() {

		driver.quit();
	}

	public void closeBrowser() {

		driver.close();
	}

}
