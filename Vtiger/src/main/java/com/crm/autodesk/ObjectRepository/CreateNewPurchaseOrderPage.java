package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericUtility.WebDriverUtility;

public class CreateNewPurchaseOrderPage extends WebDriverUtility {

	WebDriverUtility wLib= new WebDriverUtility();

	@FindBy(name="subject")
	private WebElement subjectEdt;

	@FindBys({ @FindBy(name="vendor_name"), @FindBy(xpath="//img[@alt='Select']")})
	private WebElement vendorNameLookUpImg;

	@FindBy(name="bill_street")
	private WebElement billingAddEdt;

	@FindBy(name="ship_street")
	private WebElement shippingAddEdt;

	@FindBy(id="searchIcon1")
	private WebElement productsLookUpImg;

	@FindBy(id="qty1")
	private WebElement productsQtyEdt;

	@FindBy(id="searchIcon2")
	private WebElement addServicesLookUpImg;

	@FindBy(name="qty2")
	private WebElement addServicesQtyEdt;

	@FindBy(xpath="//input[@value='Add Service']")
	private WebElement addServiceBtn;

	@FindBy(xpath="//input[@value='Add Product']")
	private WebElement addProductBtn;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public CreateNewPurchaseOrderPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getSubjectEdt() {
		return subjectEdt;
	}

	public WebElement getVendorNameLookUpImg() {
		return vendorNameLookUpImg;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getBillingAddEdt() {
		return billingAddEdt;
	}

	public WebElement getShippingAddEdt() {
		return shippingAddEdt;
	}

	public WebElement getProductsLookUpImg() {
		return productsLookUpImg;
	}

	public WebElement getProductsQtyEdt() {
		return productsQtyEdt;
	}

	public WebElement getAddServicesLookUpImg() {
		return addServicesLookUpImg;
	}

	public WebElement getAddServicesQtyEdt() {
		return addServicesQtyEdt;
	}

	public WebElement getAddServiceBtn() {
		return addServiceBtn;
	}

	public WebElement getAddProductBtn() {
		return addProductBtn;
	}

	public void setSaveBtn(WebElement saveBtn) {
		this.saveBtn = saveBtn;
	}

	//Business Library to create purchase order
	public void createPurchaseOrder(WebDriver driver, String subject,String serviceName,String billingAdd, String shippinAdd)
	{
		subjectEdt.sendKeys(subject);
		vendorNameLookUpImg.click();
		wLib.switchToWindow(driver, "Vendors");
		driver.findElement(By.linkText("blue dart446")).click();
		wLib.switchToWindow(driver, "Purchase");
		billingAddEdt.sendKeys(billingAdd);
		shippingAddEdt.sendKeys(shippinAdd);
		productsLookUpImg.click();
		wLib.switchToWindow(driver, "Products");
		driver.findElement(By.linkText("Hp Laptop")).click();
		wLib.switchToWindow(driver, "Purchase");
		productsQtyEdt.sendKeys(""+1);
		addServiceBtn.click();
		addServicesLookUpImg.click();
		wLib.switchToWindow(driver, "Services");
		driver.findElement(By.linkText(serviceName)).click();
		wLib.switchToWindow(driver, "Purchase");
		addServicesQtyEdt.sendKeys(""+1);
		saveBtn.click();
	}
}
