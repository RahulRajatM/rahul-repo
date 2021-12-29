package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchaseOrderInfoPage {

	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement purchaseInfoHeaderText;

	public PurchaseOrderInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getPurchaseInfoHeaderText() {
		return purchaseInfoHeaderText;
	}
	//Business library to get purchase order header text
	public String purchaseOrderInfoHeaderText()
	{
		return purchaseInfoHeaderText.getText();
	}
}
