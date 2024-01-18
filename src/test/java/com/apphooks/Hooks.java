package com.apphooks;

import java.util.Properties;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.driverfactory.DriverFactory;
import com.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {


	// why private these particular ref only for the hooks only
	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;


	@Before(order=1)
	public void getProperty() {
		configReader = new ConfigReader();
		prop=configReader.initProperties();
	}

	@Before(order=2)
	public void launchBrowser() {
		String browserName = prop.getProperty("browser");
		driverFactory=new DriverFactory();
		driver= driverFactory.init_driver(browserName);//store driver to avoid null
	}
	
	@Before(value="@Skip", order=0)
	public void skipScenario(Scenario scenario) {
		System.out.println("Skipped Scenario" +scenario.getName());
//		Assume.assumeTrue(false);
	}
	

	@After(order=0)
	public void quitBrowser() {
		driver.quit();
	}
	
	@After(order=1)
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			//if we write in byte it wil for use for genkins cicd
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);
			
		}
	}





}
