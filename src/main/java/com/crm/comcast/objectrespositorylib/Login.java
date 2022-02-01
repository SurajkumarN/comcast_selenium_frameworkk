package com.crm.comcast.objectrespositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	// This constructor is used to handle the initialization using pageFactory
	public Login(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/* Identifying all the element using @findBy annotation */
	@FindBy(xpath = "//input[@name='user_name']")
	private WebElement userNameEdt;

	@FindBy(name = "user_password")
	private WebElement passwordEdt;

	@FindBy(id = "submitButton")
	private WebElement subBtn;

	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getSubBtn() {
		return subBtn;
	}

	/**
	 * This methods is used to login into the application
	 * 
	 * @param username
	 * @param password
	 */
	public void loginToApp(String username, String password) {
		userNameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		subBtn.click();
	}

}
