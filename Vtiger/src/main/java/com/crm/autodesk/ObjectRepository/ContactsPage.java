package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage { //step 1=create seperate class 

	@FindBy(xpath="//img[@alt=\"Create Contact...\"]")
	private WebElement createContactLookUpImg;

	@FindAll({@FindBy(name="search_text") , @FindBy(xpath="//input[@class=\"txtBox\"]")})
	private WebElement searchforEdt;

	@FindBy(name="submit")
	private WebElement searchNowBtn;

	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);	
	}
	public void searchForContact(String contact)
	{
		searchforEdt.sendKeys(contact);
	}
	//Business logic to click on Create new contact
	public void clickOnCreateContact()
	{
		createContactLookUpImg.click();
	}
}
