package com.crm.comcast.objectrespositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	// This constructor is used to initialize all the page element.
	public ContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/* Identify all the elements using @FindBy annotations */
	@FindBy(xpath = "//Img[@alt='Create Contact...']")
	private WebElement crtContactLink;

	public WebElement getCrtContactLink() {
		return crtContactLink;
	}

}
//101709460071