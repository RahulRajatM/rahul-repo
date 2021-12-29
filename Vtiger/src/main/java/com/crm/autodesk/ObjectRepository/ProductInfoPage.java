package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoPage {

	@FindBy(xpath="//span[contains(text(),'Product Information')]")
	public WebElement productInfoHeaderText;

	@FindBy(id="mouseArea_Product Name")
	public WebElement productNameEdt;

	@FindBy(id="mouseArea_Vendor Name")
	private WebElement vendorNameEdt;

	public ProductInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getProductInfoHeaderText() {
		return productInfoHeaderText;
	}

	public WebElement getProductNameEdt() {
		return productNameEdt;
	}

	public WebElement getVendorNameEdt() {
		return vendorNameEdt;
	}


}
