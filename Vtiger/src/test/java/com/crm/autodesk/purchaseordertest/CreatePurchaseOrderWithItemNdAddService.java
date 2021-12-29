package com.crm.autodesk.purchaseordertest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.autodesk.genericUtility.ExcelUtility;
import com.crm.autodesk.genericUtility.FileUtility;
import com.crm.autodesk.genericUtility.JavaUtility;
import com.crm.autodesk.genericUtility.WebDriverUtility;

public class CreatePurchaseOrderWithItemNdAddService 
{
	public static void main(String[] args) throws Throwable {

		//get random number
		JavaUtility jLib=new JavaUtility();
		int num = jLib.getRandomNumber();

		//read property file data
		FileUtility fLib=new FileUtility();
		String url=fLib.getPropertyValue("url");
		String browser=fLib.getPropertyValue("browser");
		String userName=fLib.getPropertyValue("username");
		String pwd=fLib.getPropertyValue("password");

		//read Excel data
		ExcelUtility eLib= new ExcelUtility();
		String subject = eLib.getExcelData("PurchaseOrder", 1, 0)+num;
		String vendor = eLib.getExcelData("PurchaseOrder", 1, 1)+num;
		String billAddress = eLib.getExcelData("PurchaseOrder", 1, 2)+num;
		String shipAddress = eLib.getExcelData("PurchaseOrder", 1, 3)+num;
		String service = eLib.getExcelData("PurchaseOrder", 1, 4)+num;

		//launch browser
		WebDriver driver=null;
		if(browser.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
		driver.manage().window().maximize();
		WebDriverUtility wLib= new WebDriverUtility();
		wLib.waitForPageToLoad(driver);

		//login to Vtiger
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(userName);
		driver.findElement(By.name("user_password")).sendKeys(pwd);
		driver.findElement(By.id("submitButton")).click();

		//create new Vendor
		wLib.mouseHoverOnElement(driver, driver.findElement(By.xpath("//td[@onmouseout=\"fnHide_Event('allMenu');\"]")));
		driver.findElement(By.name("Vendors")).click();
		driver.findElement(By.xpath("//img[@alt=\"Create Vendor...\"]")).click();
		driver.findElement(By.name("vendorname")).sendKeys(vendor);
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();

		//create new service
		wLib.mouseHoverOnElement(driver, driver.findElement(By.xpath("//td[@onmouseover=\"fnvshobjMore(this,'allMenu','');\"]")));
		driver.findElement(By.linkText("Services")).click();
		driver.findElement(By.xpath("//img[@alt=\"Create Service...\"]")).click();
		driver.findElement(By.name("servicename")).sendKeys(service);
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();

		//nevigate to create purchase order page and create purchase order
		driver.findElement(By.linkText("Create Purchase Order")).click();
		driver.findElement(By.name("subject")).sendKeys(subject);
		driver.findElement(By.xpath("//input[@name=\"vendor_id\"]/following-sibling::img")).click();
		wLib.switchToWindow(driver, "Vendors");
		driver.findElement(By.xpath("(//a[contains(text(),'blue dart')])[last()]")).click();

		wLib.switchToWindow(driver, "Administrator");
		driver.findElement(By.name("bill_street")).sendKeys(billAddress);
		driver.findElement(By.name("ship_street")).sendKeys(shipAddress);
		driver.findElement(By.xpath("//input[@value=\"Add Service\"]")).click();
		driver.findElement(By.id("searchIcon2")).click();

		wLib.switchToWindow(driver,"Services");
		driver.findElement(By.id("search_txt")).sendKeys(service);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText(service)).click();
		//driver.findElement(By.xpath("(//a[contains(text(),'Laptop Service')])[last()]")).click();

		wLib.switchToWindow(driver, "Administrator");
		driver.findElement(By.id("qty2")).sendKeys(""+num+"");
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();		
		wLib.switchToAlertWindowAndAccept(driver);

		//verify result
		String text = driver.findElement(By.xpath("//span[contains(text(),'Service Information')]")).getText();
		if(text.contains("Service Information"))
		{
			System.out.println("Purchase order created with item and service");
		}
		else
		{
			System.out.println("Error...");
		}
		wLib.mouseHoverOnElement(driver, driver.findElement(By.xpath("//td[@onmouseout=\"fnHideDrop('ondemand_sub');\"]")));
		driver.findElement(By.linkText("Sign Out")).click();

	}

}
