package com.crm.autodesk.genericUtility;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * It contains WebDriver specific reusable methods
 * @author Rahul
 *
 */
public class WebDriverUtility
{
	/**
	 * wait for page to load before finding any synchronized element in DOM[HTML-Document]
	 * @param driver
	 */
	public void waitForPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
	}
	/**
	 * wait for page to load before indentifying any assychronized[java scripts actions] element in DOM [HTML-Docuent]
	 * @param driver
	 */
	public void waitForPageToLoadForJSElement(WebDriver driver) {
		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);	
	}
	/**
	 * used to wait for element to be clickable in GUI , & check for specific element for every 500 milli seconds
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * wait till alert is present
	 * @param driver
	 */
	public void waitForAlert(WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.alertIsPresent());
	}
	/**
	 *used to wait for element to be clickable in GUI , & check for specific element after specified time 
	 * @param driver
	 * @param element
	 * @param pollingTime
	 * @throws InterruptedException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked", "deprecation" })
	public void waitForElementWithCustomTimeOut(WebDriver driver,WebElement element,int pollingTime) throws InterruptedException {
		FluentWait wait = new FluentWait(driver);
		wait.pollingEvery(pollingTime, TimeUnit.SECONDS);
		wait.wait(20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * used to Switch to Any Window based on Window Title
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void switchToWindow(WebDriver driver,String partialWindowTitle)
	{
		Set<String> set = driver.getWindowHandles();	
		Iterator<String> itr = set.iterator();
		while(itr.hasNext())
		{
			String wID = itr.next();
			driver.switchTo().window(wID);
			String CurrentWindowtitle = driver.getTitle();
			if(CurrentWindowtitle.contains(partialWindowTitle))
			{
				break;
			}
		}
	}
	/**
	 * used to Switch to Alert Window & click on OK button
	 * @param driver
	 */
	public void switchToAlertWindowAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	/**
	 * used to Switch to Alert Window & click on Cancel button
	 * @param driver
	 */
	public void switchToAlertWindowAndCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	/**
	 * used to Switch to Frame Window based on index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * used to Switch to Frame Window based on id,name and attribute
	 * @param driver
	 * @param id_name_Attribute
	 */
	public void switchToFrame(WebDriver driver,String id_name_Attribute)
	{
		driver.switchTo().frame(id_name_Attribute);
	}
	/**
	 * used to select the value from the dropDwon  based on index
	 * @param element
	 * @param index
	 */
	public void select(WebElement element, int index) {
		Select s= new Select(element);
		s.selectByIndex(index);
	}
	/**
	 * used to select the value from the dropDwon  based on visible text
	 * @param element
	 * @param text
	 */
	public void select(WebElement element, String text) {
		Select s= new Select(element);
		s.selectByVisibleText(text);
	}
	/**
	 * used to place mouse cursor on specified element
	 * @param driver
	 * @param element
	 */
	public void mouseHoverOnElement(WebDriver driver,WebElement element) {
		Actions a= new Actions(driver);
		a.moveToElement(element).perform();
	}
	/**
	 * used to right click  on specified element
	 * @param driver
	 * @param element
	 */
	public void rightClickOnElement(WebDriver driver,WebElement element) {
		Actions a= new Actions(driver);
		a.contextClick().perform();
	}
	/**
	 * 	It's used execute java script to handle disabled element and scroll bar
	 * @param driver
	 * @param javaScript
	 */
	public void executeJavaScript(WebDriver driver,String javaScript) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript(javaScript, null);
	}
	/**
	 * used to click on element after every 1000ms
	 * @param element
	 * @throws InterruptedException
	 */
	public void waitAndClick(WebElement element) throws InterruptedException {
		int count=0;
		while(count<20)
		{
			try 
			{
				element.click();
				break;
			} 
			catch (Throwable e) {
				Thread.sleep(1000);
				count++;
			}
		}
	}
	/**
	 * used to take screenshot
	 * @param driver
	 * @param screenshotName
	 * @throws IOException
	 */
	public void takeScreenShot(WebDriver driver,String screenshotName) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest= new File("./screenshot/"+screenshotName+".png");
		FileUtils.copyFile(src,dest);
	}
	/**
	 * Used to press Enter button
	 * @param driver
	 */
	public void pressEnterKey(WebDriver driver) {
		Actions act=new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
}
