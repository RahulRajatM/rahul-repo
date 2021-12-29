package com.crm.autodesk.producttest;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.autodesk.ObjectRepository.CreateNewProductPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.ProductInfoPage;
import com.crm.autodesk.ObjectRepository.ProductsPage;
import com.crm.autodesk.genericUtility.BaseClass;

public class CreateProductsTest extends BaseClass {
	@Test(groups="SmokeSuit")
	public  void CreateProductTest() throws  Throwable {

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

		//create a new product
		CreateNewProductPage cnp= new CreateNewProductPage(driver);
		cnp.createProduct(product);

		//varify result-Using hard assert for mandatory field
		ProductInfoPage pInfo= new ProductInfoPage(driver);
		String text = pInfo.getProductInfoHeaderText().getText();

		boolean result = text.contains(product);
		Assert.assertEquals(result, true);
		Reporter.log("product created successfully...Pass",true);

	}
}
