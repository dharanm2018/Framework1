package com.pageObject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchHotelPage {

	private WebDriver driver;
	//1 By locators
	private By locations =By.cssSelector("select#location option");



	//2. Constructor of page class
	public SearchHotelPage(WebDriver driver) {
		this.driver=driver;
	}

	public int getLocationCount() {
		return driver.findElements(locations).size();
	}
	
	public String getSearchHotelTitle() {
		
		return driver.getTitle();
	}

	public List<String> getLocationList() {
		List<WebElement> locationOptions = driver.findElements(locations);
		List<String>locationList=new ArrayList<>();

		for (WebElement ele : locationOptions) {
			String text = ele.getText();
			System.out.println(text);
			locationList.add(text);

		}	
		return locationList;

	}
	
	
	
}
