
package com.stepdefinition;



import org.testng.Assert;

import com.driverfactory.DriverFactory;
import com.pageObject.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSD {

	private static String title;

	// what ever driver going on it will give particular driver (driverfactory)
	private LoginPage log = new LoginPage(DriverFactory.getDriver());

	@Given("user is on login page")
	public void user_is_on_login_page() {
		DriverFactory.getDriver().get("http://adactinhotelapp.com/");

	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		title = log.getLoginPageTitle();
		System.out.println(title+" "+"Login Page Title");
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String exptectedTitleName) {
		Assert.assertTrue(title.contains(exptectedTitleName));
		
	}

	@Then("forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {
		Assert.assertTrue(log.isForgotPasswordLinkExit());

	}

	@When("user enters username {string}")
	public void user_enters_username(String username) {
		log.enterUsername(username);

	}

	@When("user enters password {string}")
	public void user_enters_password(String password) {
		log.enterPassword(password);

	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
		log.clickonLogin();
	}




}
