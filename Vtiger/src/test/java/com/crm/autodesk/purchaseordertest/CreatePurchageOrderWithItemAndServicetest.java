package com.crm.autodesk.purchaseordertest;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.autodesk.genericUtility.WebDriverUtility;

public class CreatePurchageOrderWithItemAndServicetest 
{
	public static void main(String[] args) throws Throwable {

		//read data from proprty
		FileInputStream fis=new FileInputStream("./data/commondata.properties");	
		Properties p= new Properties();
		p.load(fis);
		String browser = p.getProperty("browser");
		String url = p.getProperty("url");
		String un = p.getProperty("username");
		String pw = p.getProperty("password");

		//create random number
		Random r=new Random();
		int random = r.nextInt(1000);

		//read data from excel
		FileInputStream fis_e= new FileInputStream("./data/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis_e);
		String vendor = wb.getSheet("PurchaseOrder").getRow(1).getCell(1).getStringCellValue()+random;
		String subject = wb.getSheet("PurchaseOrder").getRow(1).getCell(0).getStringCellValue()+random;
		String billing = wb.getSheet("PurchaseOrder").getRow(1).getCell(2).getStringCellValue()+random;
		String shipping = wb.getSheet("PurchaseOrder").getRow(1).getCell(3).getStringCellValue()+random;
		String service = wb.getSheet("PurchaseOrder").getRow(1).getCell(4).getStringCellValue()+random;

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
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pw);
		driver.findElement(By.id("submitButton")).submit();

		//mouse hover to more
		Actions a=new Actions(driver);
		WebElement more1 = driver.findElement(By.xpath("//td[@onmouseout=\"fnHide_Event('allMenu');\"]"));
		a.moveToElement(more1).perform();

		//create vendor
		driver.findElement(By.name("Vendors")).click();
		driver.findElement(By.xpath("//img[@alt=\"Create Vendor...\"]")).click();
		driver.findElement(By.name("vendorname")).sendKeys(vendor);
		driver.findElement(By.name("button")).click();

		//mouse hover to more
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[contains(text(),'Vendor Information')]"))));
		WebElement more2=driver.findElement(By.xpath("//td[@onmouseover=\"fnvshobjMore(this,'allMenu','');\"]"));
		a.moveToElement(more2).perform();

		//create service
		driver.findElement(By.name("Services")).click();
		driver.findElement(By.xpath("//img[@alt=\"Create Service...\"]")).click();
		driver.findElement(By.name("servicename")).sendKeys(service);
		driver.findElement(By.name("button")).click();

		//Create purchase order
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[contains(text(),'Service Information')]"))));
		Thread.sleep(3000);
		driver.findElement(By.linkText("Create Purchase Order")).click();
		driver.findElement(By.name("subject")).sendKeys(subject);
		Thread.sleep(3000);

		//select vendor
		driver.findElement(By.xpath("//input[@name=\"vendor_id\"]/following-sibling::img")).click();
		String pwh = driver.getWindowHandle();
		Set<String> allwh1 = driver.getWindowHandles();
		Iterator<String> itr1=allwh1.iterator();
		while(itr1.hasNext())
		{
			String currentwh = itr1.next();
			driver.switchTo().window(currentwh);
			String title1 = driver.getTitle();
			if(title1.contains("vendors"))
			{
				break;
			}	
		}
		driver.findElement(By.xpath("(//a[contains(text(),'blue dart')])[last()]")).click();
		driver.switchTo().window(pwh);

		//enter shipping details
		driver.findElement(By.name("bill_street")).sendKeys(billing);
		driver.findElement(By.name("ship_street")).sendKeys(shipping);
		Thread.sleep(3000);

		//add service on create purchase order page
		driver.findElement(By.xpath("//input[@value=\"Add Service\"]")).click();
		driver.findElement(By.id("searchIcon2")).click();
		Set<String> allwh2=driver.getWindowHandles();
		Iterator<String> itr2 = allwh2.iterator();
		while(itr2.hasNext())
		{
			String activewh = itr2.next();
			driver.switchTo().window(activewh);
			String title2 = driver.getTitle();
			if(title2.contains("Services"))
			{
				break;
			}
		}
		driver.findElement(By.xpath("(//a[contains(text(),'Laptop Service')])[last()]")).click();
		driver.switchTo().window(pwh);
		driver.findElement(By.id("qty2")).sendKeys(""+ random );
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();

		WebDriverUtility wLib= new WebDriverUtility();
		wLib.switchToAlertWindowAndAccept(driver);

		//verify result
		String text = driver.findElement(By.xpath("//span[contains(text(),'Service Information')]")).getText();
		if(text.contains("Service Information"))
		{
			System.out.println("Purchase order with item and service created...PASS");
		}
		else
		{
			System.out.println("Error...");
		}
		//logout
		WebElement lout = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		Actions aa=new Actions(driver);
		aa.moveToElement(lout).perform();
		driver.findElement(By.linkText("Sign Out")).click();
	}		
}

