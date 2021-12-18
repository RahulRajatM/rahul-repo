package com.crm.autodest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrganisation 
{
	public static void main(String[] args) throws Throwable 
	{
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
		String orgName = wb.getSheet("org").getRow(1).getCell(2).getStringCellValue()+random;

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
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("root");
		driver.findElement(By.id("submitButton")).submit();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt=\"Create Organization...\"]")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		String text = driver.findElement(By.xpath("//span[contains(text(),'Organization Information')]")).getText();
		if(text.contains("Ty_org"))
		{
			System.out.println("new organization created successfully...so pass");
		}
		else
		{
			System.out.println("Error");
		}
		WebElement e = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		Actions a= new Actions(driver);
		a.moveToElement(e).perform();
		driver.findElement(By.linkText("Sign Out")).click();

		driver.close();
	}
}
