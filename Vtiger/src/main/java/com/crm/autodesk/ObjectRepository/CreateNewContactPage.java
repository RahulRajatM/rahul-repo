package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericUtility.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility {

	@FindBy(name="lastname")
	private WebElement contactLastNameEdt;

	@FindBys({@FindBy(name="account_id"), @FindBy(xpath="//img[@alt='Select']")})
	private WebElement orgNameLookUpImg;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getContactLastNameEdt() {
		return contactLastNameEdt;
	}

	public WebElement getOrgNameLookUpImg() {
		return orgNameLookUpImg;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	//Business Logic to create new contact
	public void createContact(String contLastName)
	{
		contactLastNameEdt.sendKeys(contLastName);
		saveBtn.click();
	}
	//Business Logic to Create new Contact with Organization
	public void createContact(WebDriver driver,String pwhPopUp,String pwhHome,String contLastName,String orgName)
	{
		contactLastNameEdt.sendKeys(contLastName);
		orgNameLookUpImg.click();
		switchToWindow(driver, pwhPopUp);
		driver.findElement(By.linkText(orgName)).click();;
		switchToWindow(driver, pwhHome);
		saveBtn.click();

	}
}
