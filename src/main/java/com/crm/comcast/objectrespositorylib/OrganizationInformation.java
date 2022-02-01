package com.crm.comcast.objectrespositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformation {
	/* Constructor used in initialization using PageFactory */
	public OrganizationInformation(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/* Identifying the elements using @FindBy annotation */
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement orgSucMsg;

	@FindBy(xpath = "//span[@id='dtlview_Industry']")
	private WebElement indSucMsg;

	public WebElement getIndSucMsg() {
		return indSucMsg;
	}

	public WebElement getOrgSucMsg() {
		return orgSucMsg;
	}

}
