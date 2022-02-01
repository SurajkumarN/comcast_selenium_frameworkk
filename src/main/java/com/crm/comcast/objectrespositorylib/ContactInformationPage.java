package com.crm.comcast.objectrespositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage {
	/* Construct used to initialize the page elements*/
	public ContactInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/*Identify the elements using @FindBy annotation*/
	@FindBy(xpath ="//span[@class='dvHeaderText']")
	private WebElement ContactSucMsg;
	
	@FindBy(xpath = "//td[@id='mouseArea_Organization Name']/a")
	private WebElement ContactOrgSucMsg;

	public WebElement getContactSucMsg() {
		return ContactSucMsg;
	}

	public WebElement getContactOrgSucMsg() {
		return ContactOrgSucMsg;
	}
}
