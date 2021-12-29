package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {

	@FindBy(xpath="//img[@alt='Create Product...']")
	private WebElement createProductLookUpImg;

	public ProductsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateProductLookUpImg() {
		return createProductLookUpImg;
	}
	//Business logic to click on create new Product
	public void clickOnCreateProduct()
	{
		createProductLookUpImg.click();	
	}	
}
