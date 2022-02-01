package com.crm.comcast.GenericLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.crm.comcast.objectrespositorylib.Home;
import com.crm.comcast.objectrespositorylib.Login;

public class BaseClass {

	public static WebDriver Sdriver=null;
	public static WebDriver driver=null;
	
	Fileutility fLib=new Fileutility();
	Excelutility eLib=new Excelutility();
	JavaUtility jLib=new JavaUtility();
	WebDriverUtility wLib=new WebDriverUtility();
	
	/* read data from property file*/
	String BROWSER = fLib.readDataFromPropertyFile("browser");
	String URL = fLib.readDataFromPropertyFile("url");
	String USERNAME = fLib.readDataFromPropertyFile("username");
	String PASSWORD = fLib.readDataFromPropertyFile("password");
	
	//@Parameters("browser")
	@BeforeClass (groups = {"SmokeTest","RegressionTest"})
	public void openbrowser(/*String BROWSER*/) {
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			System.out.println("Invalid browser");
		}
		Reporter.log("==== Browser Launched Succesfully ====",true);
		//wLib.maximizeWindow(driver);
		wLib.waitForPageLoad(driver);
		driver.get(URL);
		Reporter.log("Login Page is Dispalyed", true);
	}
	
	@BeforeMethod (groups = {"SmokeTest","RegressionTest"})
	public void login() {
		/* Step : Login into application */
		Login lp = new Login(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		Reporter.log("---- Application Login ----",true);
	}
	
	@AfterMethod (groups = {"SmokeTest","RegressionTest"})
	public void logout() throws InterruptedException {
		/* Step : Logout from the Application */
		Home hp = new Home(driver);
		hp.logout(driver);
		Reporter.log("---- Application Logout ----",true);
		//Thread.sleep(2000);
	}
	
	@AfterClass (groups = {"SmokeTest","RegressionTest"})
	public void closeBrowser() {
		/* Step : Close the browser */
		driver.close();
		Reporter.log("==== Browser Successfuly Closed ====", true);
	}
}
