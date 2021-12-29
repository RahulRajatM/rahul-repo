package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericUtility.WebDriverUtility;

public class ServicesPage extends WebDriverUtility{

	@FindBy(xpath="//img[@alt='Create Service...']")
	private WebElement createServiceLink;

	public ServicesPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateServiceLink() {
		return createServiceLink;
	}
	//Business Library to click on create service link
	public void clickOnCreateService()
	{
		createServiceLink.click();
	}
}
