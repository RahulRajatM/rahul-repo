package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericUtility.WebDriverUtility;

public class CreateNewProductPage extends WebDriverUtility {

	@FindBy(name="productname")
	private WebElement productNameEdt;

	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement vendorNameLookUpImg;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public CreateNewProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getProductLastNameEdt() {
		return productNameEdt;
	}

	public WebElement getOrgNameLookUpImg() {
		return vendorNameLookUpImg;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	//Business logic to create product
	public void createProduct(String productName)
	{
		productNameEdt.sendKeys(productName);
		saveBtn.click();
	}
	//Business logic to create product with Vendor
	public void createProduct(WebDriver driver, String productName)
	{
		productNameEdt.sendKeys(productName);
		vendorNameLookUpImg.click();
		switchToWindow(driver, "Vendors");
		driver.findElement(By.linkText("blue dart494")).click();
		switchToWindow(driver, "Products");
		saveBtn.click();
	}
}
