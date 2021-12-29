package com.crm.autodesk.genericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.LoginPage;

public class BaseClass {

	public DataBaseUtility dLib= new DataBaseUtility();
	public  FileUtility fLib= new FileUtility();
	public  WebDriverUtility wLib= new WebDriverUtility();
	public  JavaUtility jLib= new JavaUtility();
	public  ExcelUtility eLib= new ExcelUtility();
	public  WebDriver driver;
	public static WebDriver sdriver;

	//Connect to DataBase
	@BeforeSuite(groups= {"SmokeSuit","RegressionSuit"})
	public void openDbConnection() throws Exception
	{
		dLib.connectToDb("employeedb");
		System.out.println("==DB Connection Successful==");
	}

	//Launch the Browser
	//@Parameters("browser")
	@BeforeClass(groups= {"SmokeSuit","RegressionSuit"})
	public void launchBrowser(/*String browser*/) throws Throwable
	{
		//read data from Property File
		String url= fLib.getPropertyValue("url");
		String browser= fLib.getPropertyValue("browser");

		if(browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			driver= new ChromeDriver();
		}
		/*Use static driver while implementing ITestListener*/
		//sdriver= driver;
		wLib.maximizeWindow(driver);
		wLib.waitForPageToLoad(driver);
		driver.get(url);
		System.out.println("Browser Opened");
	}

	//login 
	@BeforeMethod(groups= {"SmokeSuit","RegressionSuit"})
	public void loginToApp() throws Throwable
	{
		String username= fLib.getPropertyValue("username");
		String password= fLib.getPropertyValue("password");
		LoginPage lp= new LoginPage(driver);
		lp.login(username, password);
		System.out.println("Login Successful");
	}

	//logout
	@AfterMethod(groups= {"SmokeSuit","RegressionSuit"})
	public void logOutApp()
	{
		HomePage hp= new HomePage(driver);
		hp.logOut(driver);
		System.out.println("LogOut successful");
	}

	//Close the browser
	@AfterClass(groups= {"SmokeSuit","RegressionSuit"})
	public void closeBrowser()
	{
		driver.quit();
		System.out.println("Browser Closed");
	}
	//close DB cconnection
	@AfterSuite(groups= {"SmokeSuit","RegressionSuit"})
	public void closeDbConnection() throws Exception
	{
		dLib.closeDb();
		System.out.println("DataBase Closed ");
	}
}
