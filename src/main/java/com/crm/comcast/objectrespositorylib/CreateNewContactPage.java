package com.crm.comcast.objectrespositorylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.GenericLibrary.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility {
	WebDriver driver = null;

	/* Construct used to initialize the page elements */
	public CreateNewContactPage(WebDriver driver) {
		this.driver = driver;// This making the driver usable in the entire class
		PageFactory.initElements(driver, this);
	}

	/* Identify the elements using @FindBy annotation */
	@FindBy(name = "lastname")
	private WebElement lastNameEdt;

	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement orgNameImg;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getOrgNameImg() {
		return orgNameImg;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	/**
	 * This methods is used to create contact with mandate fields
	 * 
	 * @param contactLastName
	 */
	public void CreateContact(String contactLastName) {
		lastNameEdt.sendKeys(contactLastName);
		saveBtn.click();
	}

	/**
	 * this method is used to create contact with organization
	 * 
	 * @param contactLastName
	 * @param orgName
	 * @param driver
	 */
	public void CreateContact(String contactLastName, String orgName) {
		lastNameEdt.sendKeys(contactLastName);
		orgNameImg.click();
		swtichToWindow(driver, "Accounts&action");
		OrganisationPage op = new OrganisationPage(driver);
		op.getSearchFieldEdt().sendKeys(orgName);
		op.getSearchBtn().click();
		driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();
		swtichToWindow(driver, "Contacts&action");
		saveBtn.click();
	}

}
