package com.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverInstance {
	
	public static DriverInstance instance;
	WebDriver driver;
	WebDriverWait wait;
	
	@SuppressWarnings("deprecation")
	public DriverInstance(String browser) {
		if(browser.equals("firefox")) {
			System.setProperty("webdriver.firefoxDriver.driver", "D:\\selenium-server\\Driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\selenium-server\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		wait = new WebDriverWait(driver, 120);
	}
	
	public static void setInstance(String browser) {
		DriverInstance.instance = new DriverInstance(browser);
	}
	
	public static DriverInstance getinstance() {
		return instance;
	}
	
	public WebDriver getDiver() {
		return driver;
	}
	
	public WebDriverWait getWait() {
		return wait;
	}

}
