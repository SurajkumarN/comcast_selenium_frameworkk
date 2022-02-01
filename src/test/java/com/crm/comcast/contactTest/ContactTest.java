package com.crm.comcast.contactTest;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.GenericLibrary.BaseClass;
import com.crm.comcast.GenericLibrary.Excelutility;
import com.crm.comcast.GenericLibrary.JavaUtility;
import com.crm.comcast.GenericLibrary.WebDriverUtility;
import com.crm.comcast.objectrespositorylib.ContactInformationPage;
import com.crm.comcast.objectrespositorylib.ContactPage;
import com.crm.comcast.objectrespositorylib.CreateNewContactPage;
import com.crm.comcast.objectrespositorylib.CreateNewOrganization;
import com.crm.comcast.objectrespositorylib.Home;
import com.crm.comcast.objectrespositorylib.OrganisationPage;
import com.crm.comcast.objectrespositorylib.OrganizationInformation;

@Listeners(com.crm.comcast.GenericLibrary.ListenerImplements.class)
public class ContactTest extends BaseClass {

	Excelutility eLib = new Excelutility();
	JavaUtility jLib = new JavaUtility();
	WebDriverUtility wLib = new WebDriverUtility();

	@Test(groups = "SmokeTest")
	public void CreateContactTest() throws Throwable {

		/* read data from excel */
		String lastName = eLib.getDataFromExcel("Sheet2", 1, 2) + jLib.getRandomNumber();

		/* Step 1: Navigate to Contact Page */
		Home hp = new Home(driver);
		hp.getContactLink().click();

		/* Step 2: Navigate to create New Contact page */
		ContactPage cp = new ContactPage(driver);
		cp.getCrtContactLink().click();

		/* Step 3: Create New Contact */
		CreateNewContactPage cnp = new CreateNewContactPage(driver);
		cnp.CreateContact(lastName);

		/* Step 4: Verification of the contact created */
		ContactInformationPage cip = new ContactInformationPage(driver);
		String actContact = cip.getContactSucMsg().getText();
		// String actContact ="xxx";
		Assert.assertTrue(actContact.contains(lastName));
		Reporter.log("Contact Name Created successfully ====>C1 Test Script Pass", true);
	}

	@Test(groups = "RegressionTest")
	public void CreateContactWithOrganizationTest() throws Throwable {

		/* read data from excel */
		String contactName = eLib.getDataFromExcel("Sheet2", 4, 2) + jLib.getRandomNumber();
		String orgName = eLib.getDataFromExcel("Sheet2", 4, 3) + jLib.getRandomNumber();

		/* Step 1: Navigate to organization Page */
		Home hp = new Home(driver);
		hp.getOrgLink().click();

		/* Step 2: Navigate to create New Organization page */
		OrganisationPage o = new OrganisationPage(driver);
		o.getCrtOrgLink().click();

		/* Step 3: Create a New Organization */
		CreateNewOrganization cno = new CreateNewOrganization(driver);
		cno.createOrg(orgName);

		/* Wait for the header Element */
		OrganizationInformation oi = new OrganizationInformation(driver);
		wLib.waitForElementToBeVisible(driver, oi.getOrgSucMsg());

		/* Step 4: Navigate to contact Page */
		hp.getContactLink().click();

		/* Step 5: Navigate to New COntact Page */
		ContactPage cp = new ContactPage(driver);
		cp.getCrtContactLink().click();

		/* Step 6: Create a new contact with organization */
		CreateNewContactPage cnp = new CreateNewContactPage(driver);
		cnp.CreateContact(contactName, orgName);

		/* Step 7: Verification of Contact with Organization */
		ContactInformationPage cip = new ContactInformationPage(driver);
		String actContactOrg = cip.getContactOrgSucMsg().getText();

		Assert.assertTrue(actContactOrg.contains(orgName));
		Reporter.log("Contact with Organization created Successfully ====>C2 TestScript Pass", true);

	}
}
