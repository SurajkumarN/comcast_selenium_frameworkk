package com.crm.comcast.orgTest;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.GenericLibrary.BaseClass;
import com.crm.comcast.GenericLibrary.Excelutility;
import com.crm.comcast.GenericLibrary.JavaUtility;
import com.crm.comcast.objectrespositorylib.CreateNewOrganization;
import com.crm.comcast.objectrespositorylib.Home;
import com.crm.comcast.objectrespositorylib.OrganisationPage;
import com.crm.comcast.objectrespositorylib.OrganizationInformation;

@Listeners(com.crm.comcast.GenericLibrary.ListenerImplements.class)
public class OrganizationTest extends BaseClass {

	JavaUtility jLib = new JavaUtility();
	Excelutility eLib = new Excelutility();

	@Test(priority = 4 , groups = "SmokeTest")
	public void createOrganizationTest() throws Throwable {

		/* read data from excel */
		String organizationName = eLib.getDataFromExcel("Sheet1", 1, 2) + jLib.getRandomNumber();

		/* Step 1:Navigate to organization */
		Home hp = new Home(driver);
		hp.getOrgLink().click();

		/* Step 2: Navigate to create organization page */
		OrganisationPage o = new OrganisationPage(driver);
		o.getCrtOrgLink().click();

		/* Step 3:Create New organization */
		CreateNewOrganization co = new CreateNewOrganization(driver);
		co.createOrg(organizationName);

		/* Step 4: Verify Created Organization */
		OrganizationInformation oi = new OrganizationInformation(driver);
		String actOrgName = oi.getOrgSucMsg().getText();

		Assert.assertTrue(actOrgName.contains(organizationName));
		Reporter.log("Organization created successfully ====>O1 Testscript pass", true);

	}

	@Test (priority = 1,groups = "RegressionTest")
	public void CreateOrgWithIndustriesTypeTest() throws Throwable {

		/* read data from excel */
		String organizationName = eLib.getDataFromExcel("Sheet1", 4, 2) + jLib.getRandomNumber();
		String indName = eLib.getDataFromExcel("Sheet1", 4, 3);

		/* Step 1: Navigate to organization */
		Home hp = new Home(driver);
		hp.getOrgLink().click();

		/* Step 2: Navigate to create organization page */
		OrganisationPage o = new OrganisationPage(driver);
		o.getCrtOrgLink().click();

		/* Step 3: Create New Organization */
		CreateNewOrganization co = new CreateNewOrganization(driver);
		co.createOrg(organizationName, indName);
		co.getSaveBtn().click();

		/* Step 5: Verify Created Organization */
		OrganizationInformation oi = new OrganizationInformation(driver);
		String actind = oi.getIndSucMsg().getText();

		Assert.assertTrue(actind.contains(indName));
		Reporter.log("Organization created with industry successfully ====>O2 Testscript pass", true);

	}
}
