package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericUtility.WebDriverUtility;

public class HomePage extends WebDriverUtility {

	WebDriverUtility wLib= new WebDriverUtility();

	@FindBy(linkText="Organizations")
	private WebElement organizationsLnk;

	@FindBy(linkText="Contacts")
	private WebElement contactsLnk;

	@FindBy(linkText="Products")
	private WebElement productsLnk;

	@FindBy(xpath="//td[@onmouseout=\"fnHide_Event('allMenu');\"]")
	private WebElement moreDropdown;

	@FindBy(xpath="//td[@onmouseout=\"fnHideDrop('ondemand_sub');\"]")
	private WebElement administratorImageDropdown;

	@FindBy(name="Vendors")
	private WebElement vendorsLink;

	@FindBy(name="Purchase Order")
	private WebElement purchaseOrderLink;

	@FindBy(name="Services")
	private WebElement servicesLink;

	@FindBy(linkText="Sign Out")
	private WebElement signOutBtn;

	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public WebElement getOrganizationsLnk() {
		return organizationsLnk;
	}
	public WebElement getContactsLnk() {
		return contactsLnk;
	}
	public WebElement getProductsLnk() {
		return productsLnk;
	}
	public WebElement getMoreDropdown() {
		return moreDropdown;
	}
	public WebElement getVendorLink() {
		return vendorsLink;
	}
	public WebElement getPurchaseOrderLink() {
		return purchaseOrderLink;
	}

	public WebElement getServicesLink() {
		return servicesLink;
	}
	//Business logic to click on organisations link
	public void clickOnOrganizations() {
		organizationsLnk.click();
	}
	//Business logic to click on Products link
	public void clickOnProducts() {
		productsLnk.click();
	}
	//Business logic to click on contacts link
	public void clickOnContact() {
		contactsLnk.click();
	}
	//Buness library to mouse hover to more
	public void mouseHoverToMore(WebDriver driver)
	{
		wLib.mouseHoverOnElement(driver, moreDropdown);
	}
	//Business Library to click on vendors link
	public void clickOnVendors()
	{
		wLib.mouseHoverOnElement(null, moreDropdown);
		vendorsLink.click();
	}
	//Business Library to click on services link
	public void clickOnServicesLink(WebDriver driver)
	{
		wLib.mouseHoverOnElement(driver, moreDropdown);
		servicesLink.click();
	}
	//Business Library to click on purchase order link
	public void clickOnPurchaseOrderLink(WebDriver driver)
	{
		wLib.mouseHoverOnElement(driver, moreDropdown);
		purchaseOrderLink.click();
	}
	//Business logic to logout
	public void logOut(WebDriver driver)
	{
		wLib.mouseHoverOnElement(driver, administratorImageDropdown);
		signOutBtn.click();
	}

}
