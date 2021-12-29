package com.crm.autodesk.purchaseordertest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.autodesk.genericUtility.ExcelUtility;
import com.crm.autodesk.genericUtility.FileUtility;
import com.crm.autodesk.genericUtility.JavaUtility;
import com.crm.autodesk.genericUtility.WebDriverUtility;

public class CreatePurchageOrderWithItemAndServicesTest {

	public static void main(String[] args) throws Throwable {

		WebDriverUtility wLib= new WebDriverUtility();
		JavaUtility jLib=new JavaUtility();
		ExcelUtility eLib= new ExcelUtility();
		FileUtility fLib=new FileUtility();

		//CREATE RANDOM NUMBER
		int num = jLib.getRandomNumber();

		//READ DATA FROM PROPERTY FILE
		String url=fLib.getPropertyValue("url");
		String browser=fLib.getPropertyValue("browser");
		String userName=fLib.getPropertyValue("username");
		String pwd=fLib.getPropertyValue("password");

		//READ DATA FROM EXCEL SHEET
		String subject = eLib.getExcelData("PurchaseOrder", 1, 0)+num;
		String vendor = eLib.getExcelData("PurchaseOrder", 1, 1);
		String billAddress = eLib.getExcelData("PurchaseOrder", 1, 2)+num;
		String shipAddress = eLib.getExcelData("PurchaseOrder", 1, 3)+num;
		String service = eLib.getExcelData("PurchaseOrder", 1, 4);
		String product = eLib.getExcelData("PurchaseOrder", 1, 5);

		//LAUNCH BROWSER
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

		wLib.waitForPageToLoad(driver);
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(userName);
		driver.findElement(By.name("user_password")).sendKeys(pwd);
		driver.findElement(By.id("submitButton")).click();

		//CREATE PRODUCT
		/*driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@alt=\"Create Product...\"]")).click();
		driver.findElement(By.name("productname")).sendKeys(product);
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();*/

		//CREATE VENDOR
		/*wLib.mouseHoverOnElement(driver, driver.findElement(By.xpath("//td[@onmouseout=\"fnHide_Event('allMenu');\"]")));
		driver.findElement(By.name("Vendors")).click();
		driver.findElement(By.xpath("//img[@alt=\"Create Vendor...\"]")).click();
		driver.findElement(By.name("vendorname")).sendKeys(vendor);
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();*/

		//CREATE SERVICE
		/*wLib.mouseHoverOnElement(driver, driver.findElement(By.xpath("//td[@onmouseover=\"fnvshobjMore(this,'allMenu','');\"]")));
		driver.findElement(By.linkText("Services")).click();
		driver.findElement(By.xpath("//img[@alt=\"Create Service...\"]")).click();
		driver.findElement(By.name("servicename")).sendKeys(service);
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		driver.findElement(By.linkText("Create Purchase Order")).click();*/

		//CREATE PURCHAGE ORDER WITH Existing ITEM AND SERVICE
		wLib.mouseHoverOnElement(driver, driver.findElement(By.xpath("//td[@onmouseout=\"fnHide_Event('allMenu');\"]")));
		driver.findElement(By.name("Purchase Order")).click();
		driver.findElement(By.xpath("//img[@alt=\"Create Purchase Order...\"]")).click();
		driver.findElement(By.name("subject")).sendKeys(subject);

		//SELECT EXISTING VENDOR
		driver.findElement(By.xpath("//input[@name=\"vendor_id\"]/following-sibling::img")).click();
		wLib.switchToWindow(driver, "Vendors");
		driver.findElement(By.xpath("(//a[contains(text(),'"+vendor+"')])[last()]")).click();//DYNAMIC XPATH
		wLib.switchToWindow(driver, "Administrator");
		driver.findElement(By.name("bill_street")).sendKeys(billAddress);
		driver.findElement(By.name("ship_street")).sendKeys(shipAddress);

		//SELECT Existing ITEM/PRODUCT
		driver.findElement(By.id("searchIcon1")).click();
		wLib.switchToWindow(driver, "Products");
		driver.findElement(By.id("search_txt")).sendKeys(product);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.partialLinkText(product)).click();
		//driver.findElement(By.xpath("(//a[contains(text(),'Hp Laptop')])[last()]")).click();

		//SELECT ITEM QUANTITY
		wLib.switchToWindow(driver, "Administrator");
		driver.findElement(By.id("qty1")).sendKeys(""+num);


		//SELECT EXISTING SERVICE 
		driver.findElement(By.xpath("//input[@value=\"Add Service\"]")).click();
		driver.findElement(By.id("searchIcon2")).click();
		wLib.switchToWindow(driver,"Services");
		driver.findElement(By.id("search_txt")).sendKeys(service);
		wLib.select(driver.findElement(By.name("search_field")), "Service Name");
		driver.findElement(By.name("search")).click();
		driver.findElement(By.partialLinkText(service)).click();
		//driver.findElement(By.xpath("(//a[contains(text(),'Laptop Service')])[last()]")).click();
		wLib.switchToWindow(driver, "Administrator");
		driver.findElement(By.id("qty2")).sendKeys(""+num);
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();		
		//wLib.switchToAlertWindowAndAccept(driver);

		//Verify result
		String text = driver.findElement(By.xpath("//span[contains(text(),'Purchase Order Information')]")).getText();
		if(text.contains("Purchase Order Information"))
		{
			System.out.println("Purchase order created with item and existing service created..PASS");
		}
		else
		{
			System.out.println("Error...");
		}
		wLib.mouseHoverOnElement(driver, driver.findElement(By.xpath("//td[@onmouseout=\"fnHideDrop('ondemand_sub');\"]")));
		driver.findElement(By.linkText("Sign Out")).click();

	}

}
