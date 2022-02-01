package com.crm.comcast.objectrespositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.GenericLibrary.WebDriverUtility;

public class Home extends WebDriverUtility {
	WebDriver driver=null;
	// This constructor is used to initialization using PageFactory
	public Home(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/* Identify the elements using @FindBy annotations */
	@FindBy(linkText = "Organizations")
	private WebElement orgLink;

	@FindBy(linkText = "Contacts")
	private WebElement contactLink;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administorImg;

	@FindBy(linkText = "Sign Out")
	private WebElement signOut;

	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}

	public WebElement getAdministorImg() {
		return administorImg;
	}

	public WebElement getSignOut() {
		return signOut;
	}

	/**
	 * This method is used to logout from the application
	 * 
	 * @param driver
	 */
	public void logout(WebDriver driver) {
		mouseHover(driver, administorImg);
		signOut.click();
	}

}
