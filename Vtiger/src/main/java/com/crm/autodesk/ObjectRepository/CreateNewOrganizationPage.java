package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericUtility.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility{
	@FindBy(name="accountname")
	private WebElement orgNameEdt;

	@FindBy(name="industry")
	private WebElement industryDropdown;

	//@FindBy(xpath="//option[contains(text(),'industryName')]") //Dynamic xpath
	//private WebElement industryOption;

	@FindBy(name= "accounttype")
	private WebElement typeDropdown;

	//@FindBy(xpath="//option[contains(text(),'typeName')]") // Dynamic xpath
	//private WebElement typeOption;

	@FindBy(xpath="//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveBtn;

	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getIndustryDropdown() {
		return industryDropdown;
	}

	public WebElement getTypeDropdown() {
		return typeDropdown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	//Business Logic to Create Organization
	public void createOrg(String orgName) {
		orgNameEdt.sendKeys(orgName);
		saveBtn.click();
	}
	//Business logic to create Organisation with Industry and type
	public void createOrgWithIndustryAndType(String orgname,String industry,String type)
	{
		orgNameEdt.sendKeys(orgname);	
		select(industryDropdown, industry);
		select(typeDropdown, type);
		saveBtn.click();
	}

}
