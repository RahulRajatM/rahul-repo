package com.crm.autodesk.producttest;

import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.autodesk.ObjectRepository.CreateNewProductPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.ProductInfoPage;
import com.crm.autodesk.ObjectRepository.ProductsPage;
import com.crm.autodesk.genericUtility.BaseClass;

public class CreateProductWithVendorTest extends BaseClass {

	@Test(groups = "RegressionSuit")
	public void createProductWithVendorTest() throws InvalidFormatException, IOException
	{
		//get random number
		int ranNum= jLib.getRandomNumber();

		//read data from Excel
		String product = eLib.getExcelData("PurchaseOrder", 1, 5)+ ranNum;

		//Click on product link
		HomePage hp= new HomePage(driver);
		hp.clickOnProducts();

		//Click on create product lookUp Img
		ProductsPage pp= new ProductsPage(driver);
		pp.clickOnCreateProduct();

		//create a new product with vendor
		CreateNewProductPage cnp= new CreateNewProductPage(driver);
		cnp.createProduct(driver, product);

		//varify result
		ProductInfoPage pInfo= new ProductInfoPage(driver);
		String text = pInfo.getProductInfoHeaderText().getText();

		//verify vendor name-Using soft Asset for non mandatory field
		String vendorName = pInfo.getVendorNameEdt().getText().trim();
		SoftAssert sa= new SoftAssert();
		sa.assertEquals(vendorName, "blue dart494");

		//verify product name- Using hard assert for mandatory field
		boolean result = text.contains(product);
		Assert.assertEquals(result, true);
		Reporter.log("product created with vendor name successfully...Pass",true);

		sa.assertAll();
	}
}
