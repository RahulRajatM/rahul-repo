package com.crm.contacts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

public class CreateContactWithOrganization 
{
	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream("./data/commondata.properties");
		Properties p=new Properties();
		p.load(fis);
		String url = p.getProperty("url");
		String un=p.getProperty("username");
		String pw=p.getProperty("password");
		String browser=p.getProperty("browser");
		Random r=new Random();
		int num = r.nextInt(1000);
		FileInputStream fis_e=new FileInputStream("./data/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis_e);
		String orgName = wb.getSheet("org").getRow(1).getCell(2).getStringCellValue()+num;
		String contact=wb.getSheet("org").getRow(2).getCell(1).getStringCellValue()+num;
		WebDriver driver=null;
		if(browser.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pw);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt=\"Create Organization...\"]")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.name("button")).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt=\"Create Contact...\"]")).click();
		driver.findElement(By.name("lastname")).sendKeys("contact");
		driver.findElement(By.xpath("(//img[@title=\"Select\"])[1]")).click();
		String wh = driver.getWindowHandle();
		Set<String> whs = driver.getWindowHandles();
		for (String window : whs) 
		{
			if(!window.equals(wh))
			{
				driver.switchTo().window(window);
			}
		}
		driver.findElement(By.xpath("(//a[contains(text(),'Ty_org')])[last()]")).click();
		driver.switchTo().window(wh);
		driver.findElement(By.xpath("//input[@accesskey=\"S\"]")).click();
		String text = driver.findElement(By.xpath("//span[contains(text(),'Contact Information')]")).getText();
		if(text.contains("contact"))
		{
			System.out.println("Contact created with organization...so pass");
		}
		else
		{
			System.out.println("Error");
		}
		WebElement e = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		Actions a=new Actions(driver);
		a.moveToElement(e).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
	}
}
