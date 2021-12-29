package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorsPage {

	@FindBy(xpath="alt=\"Create Vendor...\"")
	private WebElement createVendorLookUpImg;

	public VendorsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Business library to click on create vendor link
	public void clickOnCreateVendorLookUpImg()
	{
		createVendorLookUpImg.click();
	}
	//Business library to select existing vendor link
	public void selectExistingVendor(WebDriver driver,String vendorName)
	{
		driver.findElement(By.linkText(vendorName)).click();
	}
}
