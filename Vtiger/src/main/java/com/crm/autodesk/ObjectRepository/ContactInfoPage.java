package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {

	@FindBy(xpath= "//span[contains(text(),'Contact Information')]")
	private WebElement contactInfoHeaderText;

	@FindAll({@FindBy(xpath="onmouseover=\"hndMouseOver(255,'Last Name');\""), @FindBy(id= "mouseArea_Last Name")})
	private WebElement lastNameEdt;

	@FindBy(id="mouseArea_Organization Name")
	private WebElement orgNameEdt;

	public ContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getContactInfoText() {
		return contactInfoHeaderText;
	}

	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	// Business Library to get Header Text
	public String ContactInfoHeaderText()
	{
		return contactInfoHeaderText.getText();
	}
	//Business Library to get Contact last name Text
	public String ContactLastName()
	{
		return lastNameEdt.getText();
	}
}
