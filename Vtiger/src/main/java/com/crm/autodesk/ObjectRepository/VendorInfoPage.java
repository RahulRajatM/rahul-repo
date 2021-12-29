package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorInfoPage {

	@FindBy(xpath="//span[contains(text(),'Vendor Information')]")
	private WebElement vendorInfoHeaderText;

	public VendorInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getVendorInfoHeaderText() {
		return vendorInfoHeaderText;
	}
	//Business Library to get vendorInfo header text
	public String VendorInfoHeaderText()
	{
		return vendorInfoHeaderText.getText();
	}
}
