package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericUtility.WebDriverUtility;

public class CreateNewServicePage extends WebDriverUtility {

	@FindBy(name="servicename")
	private WebElement serviceNameEdt;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public CreateNewServicePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getServiceNameEdt() {
		return serviceNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	//Business Library to create new service
	public void createNewService(String serviceName)
	{
		serviceNameEdt.sendKeys(serviceName);
		saveBtn.click();
	}
}
