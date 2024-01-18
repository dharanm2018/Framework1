package com.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelectHotelPage {

	private WebDriver driver;
	private SelectHotelPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public WebElement getSelectHotel() {
		return SelectHotel;
	}


	public void setSelectHotel(WebElement selectHotel) {
		SelectHotel = selectHotel;
	}


	private WebElement SelectHotel; 
	
}
