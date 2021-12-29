package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericUtility.WebDriverUtility;

public class CreateNewVendorPage extends WebDriverUtility {

	@FindBy(name="vendorname")
	private WebElement vendorNameEdt;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public CreateNewVendorPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getVendorNameEdt() {
		return vendorNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	//Business Library to create new vendor
	public void createNewVendor(String vendorName)
	{
		vendorNameEdt.sendKeys(vendorName);
		saveBtn.click();
	}
}
