package com.driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
//	public WebDriver driver;
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	/**
	 * this method is used  to initialize the threadlocal driver on the basis of given browser
	 * @param browse
	  * @return
	 */
	
	public WebDriver init_driver(String browser) {
		System.out.println("browser value is "+browser);
		
				if (browser.equals("edge")) {
					WebDriverManager.edgedriver().setup();
					tlDriver.set(new EdgeDriver());
					
				}
				else if (browser.equals("firefox")) {
					WebDriverManager.firefoxdriver().setup();
					tlDriver.set(new FirefoxDriver());
					
				}
				else {
					System.out.println("Please pass the correct browser value");
				}
				getDriver().manage().deleteAllCookies();
				getDriver().manage().window().maximize();
				return getDriver();
	}
	
	/**
	 * when running multiple thread in parallel execution (ex 5)
	 * all will be calling this getDriver() hence all the thrad should be in sync
	 * @return
	 */
	public static synchronized WebDriver getDriver() {
		
		return tlDriver.get();
	}

}
