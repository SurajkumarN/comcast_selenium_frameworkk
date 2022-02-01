package com.crm.comcast.objectrespositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.GenericLibrary.WebDriverUtility;

public class CreateNewOrganization extends WebDriverUtility{
	
	/*Constructor used in initialization using PageFactory*/
	public CreateNewOrganization(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	/* Identifying the elements using @FindBy annotation*/
	@FindBy(name = "accountname")
	private WebElement orgNameFld;
	
	@FindBy(name = "industry")
	private WebElement indDrop;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public WebElement getOrgNameFld() {
		return orgNameFld;
	}

	public WebElement getIndDrop() {
		return indDrop;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	/**
	 * THis method is used to provide data for mandated fields 
	 * @param orgName
	 */
	public void createOrg(String orgName) {
		orgNameFld.sendKeys(orgName);
		saveBtn.click();
	}
	/**
	 * This method is used to provide data for mandated fields and industry DropDown
	 * @param orgName
	 * @param ind
	 */
	public void createOrg(String orgName, String ind) {
		orgNameFld.sendKeys(orgName);
		select(ind, indDrop);
	}

}
