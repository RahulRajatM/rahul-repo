package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	@FindBy(xpath="//span[contains(text(),'Organization Information')]")
	private WebElement orgInfoHeaderText;

	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgHeaderText() {
		return orgInfoHeaderText;
	}

	//Business logic to varify Org
	public String OrgHeaderInfo() {
		return orgInfoHeaderText.getText();
	}
}
