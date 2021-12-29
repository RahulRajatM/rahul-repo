package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchaseOrderPage {

	@FindBy(xpath="//img[@alt='Create Purchase Order...']")
	private WebElement CreatePurchaseOrderLookUpImg;

	public PurchaseOrderPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getPurchaseOrderLink() {
		return CreatePurchaseOrderLookUpImg;
	}
	//Business Library to click on Purchase Order LookUp Img
	public void clickOnCreatePurchaseOrder()
	{
		CreatePurchaseOrderLookUpImg.click();
	}
}
