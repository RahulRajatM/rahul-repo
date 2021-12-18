package com.crm.contacts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateContact
{
	public static void main(String[] args) throws Throwable {
		FileInputStream fis= new FileInputStream("./data/commondata.properties");
		Properties p= new Properties();
		p.load(fis);
		String url = p.getProperty("url");
		String un = p.getProperty("username");
		String pw = p.getProperty("password");
		String browser=p.getProperty("browser");
		Random r=new Random();
		int num = r.nextInt(1000);
		FileInputStream fis_t=new FileInputStream("./data/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis_t);
		String cont = wb.getSheet("org").getRow(2).getCell(1).getStringCellValue()+num;
		WebDriver driver=null;
		if(browser.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pw);
		driver.findElement(By.id("submitButton")).submit();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt=\"Create Contact...\"]")).click();
		driver.findElement(By.name("lastname")).sendKeys(cont);
		driver.findElement(By.name("button")).click();
		String contact = driver.findElement(By.xpath("//span[contains(text(),'Contact Information')]")).getText();
		if(contact.contains(cont))
		{
			System.out.println("contact Created Successfully...so pass");
		}
		else
		{
			System.out.println("Error");
		}
		WebElement img = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		Actions a=new Actions(driver);
		a.moveToElement(img).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.close();
	}
}
