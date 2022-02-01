package com.crm.comcast.objectrespositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationPage {

	/* Constructor used to initialization using PageFactory */
	public OrganisationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/* Identify the elements using @FindBy annotation */
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement crtOrgLink;

	@FindBy(id = "search_txt")
	private WebElement searchFieldEdt;

	@FindBy(name = "search")
	private WebElement searchBtn;

	public WebElement getCrtOrgLink() {
		return crtOrgLink;
	}

	public WebElement getSearchFieldEdt() {
		return searchFieldEdt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

}
