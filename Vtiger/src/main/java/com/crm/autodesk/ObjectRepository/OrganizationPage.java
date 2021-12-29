package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericUtility.WebDriverUtility;

public class OrganizationPage extends WebDriverUtility {

	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createOrgLookUpImg;
	@FindBy(name="search_text")
	private WebElement searchForEdt;
	@FindBy(name="submit")
	private WebElement searchNowBtn;
	@FindBy(id="bas_searchfield")
	private WebElement inDropdown;
	
	public OrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public WebElement getCreateOrgLookUpImg() {
		return createOrgLookUpImg;
	}
	public WebElement getSearchForEdt() {
		return searchForEdt;
	}
	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}
	public WebElement getInDropdown() {
		return inDropdown;
	}
	//business Library/logic to click create new Organization
	public void ClickOnCreateOrg() {
		createOrgLookUpImg.click();
	}
	//business logic for selecting searchIn
	public void searchOrg(String searchForOrgName, String searchIn)
	{
		searchForEdt.sendKeys(searchForOrgName);
		select(inDropdown,searchIn );
		searchNowBtn.click();
	}
}
