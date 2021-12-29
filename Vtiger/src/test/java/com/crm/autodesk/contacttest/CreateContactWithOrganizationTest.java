package com.crm.autodesk.contacttest;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.autodesk.ObjectRepository.ContactInfoPage;
import com.crm.autodesk.ObjectRepository.ContactsPage;
import com.crm.autodesk.ObjectRepository.CreateNewContactPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.genericUtility.BaseClass;

public class CreateContactWithOrganizationTest extends BaseClass
{
	@Test(groups = "RegressionSuit")
	public void createContactWithOrg() throws Throwable {

		//generate random number
		int ranNum= jLib.getRandomNumber();

		//read data from excel sheet
		String cont= eLib.getExcelData("org", 2, 1)+ ranNum;
		//String orgName= eLib.getExcelData("org", 1, 2);

		//Click on contacts
		HomePage hp= new HomePage(driver);
		hp.clickOnContact();

		//Click on create new contact
		ContactsPage cp= new ContactsPage(driver);
		cp.clickOnCreateContact();

		//create contact with organization
		CreateNewContactPage newCont= new CreateNewContactPage(driver);
		newCont.createContact(driver, "Accounts" , "Contacts", cont, "Ty_org707");

		//Varify result
		ContactInfoPage cinfo= new ContactInfoPage(driver);
		String text = cinfo.ContactInfoHeaderText();

		String actualOrgName = cinfo.getOrgNameEdt().getText().trim();

		//varify org name-Using soft Asset for non mandatory field
		SoftAssert sa= new SoftAssert();
		sa.assertEquals(actualOrgName, "Ty_org707");

		//varify cont last name-Using hard assert for mandatory field
		boolean result = text.contains(cont);
		Assert.assertTrue(result);
		Reporter.log("Contact created with organization...Test script pass...",true);

		sa.assertAll();
	}
	/*@Test
	public void createOrgDemo()
	{
		System.out.println("Orgnization created...");
	}*/
}
