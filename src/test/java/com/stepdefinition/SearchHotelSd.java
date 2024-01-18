package com.stepdefinition;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.driverfactory.DriverFactory;
import com.pageObject.LoginPage;
import com.pageObject.SearchHotelPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class SearchHotelSd {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private SearchHotelPage searchHotel;

	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable credTable) {
	    List<Map<String, String>> credList = credTable.asMaps();
	    String user = credList.get(0).get("username");
	    String pass = credList.get(0).get("password");
	    DriverFactory.getDriver().get("https://adactinhotelapp.com/");
	    searchHotel=loginPage.doLogin(user, pass);
	}

	@Given("user is on Search page")
	public void user_is_on_Search_page() {
	   String searchHotelTitle = searchHotel.getSearchHotelTitle();
	   System.out.println("SearchTItle "+searchHotelTitle);
	}

	@Then("user gets Location section criteria")
	public void user_gets_Location_section_criteria(DataTable LocationListTable) {
	   List<String> exptectedList = LocationListTable.asList();
	   System.out.println("Expected List "+exptectedList );
	   
	   List<String> actualList = searchHotel.getLocationList();
	   System.out.println("Actual List "+actualList );
	   
//	   Assert.assertTrue(exptectedList.contains(actualList));
	   Assert.assertTrue(exptectedList.containsAll(actualList));

	}

	@Then("Search criteria should be {int}")
	public void search_criteria_should_be(Integer expectedListCount) {
	    Assert.assertTrue(searchHotel.getLocationCount()==expectedListCount);
	}

	@Given("user is on search hotel result page")
	public void user_is_on_search_hotel_result_page() {
	   
	}

	@Then("click on the searched result and Continue")
	public void click_on_the_searched_result_and_continue() {
	   
	}

}
