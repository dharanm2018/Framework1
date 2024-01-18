package com.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectHotelPage {
	
	private WebDriver driver;
	
	public SelectHotelPage() {

	PageFactory.initElements(driver, this);

		
	}
@FindBy(id="radiobutton_0")
private WebElement selectRadioButton;

@FindBy(id="continue")
private WebElement continueButton;

public WebElement getSelectRadioButton() {
	return selectRadioButton;
}

public WebElement getContinueButton() {
	return continueButton;
}
	
public void selectHotel() {
	getSelectRadioButton().click();
	getContinueButton().click();
}




	
}
