package com.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	//1 By locators
	private By username =By.id("username");
	private By password =By.id("password");
	private By login =By.id("login");
	private By forgotPasswordLink=By.linkText("Forgot Password?");

	//2. Constructor of page class
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	//3 page actions
	//should not write assertion in page class
	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean isForgotPasswordLinkExit() {
		return driver.findElement(forgotPasswordLink).isDisplayed();
	}

	public void enterUsername(String user) {
		driver.findElement(username).sendKeys(user);
	}
	public void enterPassword(String pass) {
		driver.findElement(password).sendKeys(pass);
	}
	public void clickonLogin() {
		driver.findElement(login).click();
	}

	public SearchHotelPage doLogin(String user, String pass)
	{
		System.out.println("UserLogin with "+user);
		driver.findElement(username).sendKeys(user);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(login).click();
		
		return new SearchHotelPage(driver);
	}




}
