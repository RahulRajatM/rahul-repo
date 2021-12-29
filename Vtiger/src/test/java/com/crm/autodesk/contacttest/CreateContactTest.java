package com.crm.autodesk.contacttest;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.autodesk.ObjectRepository.ContactInfoPage;
import com.crm.autodesk.ObjectRepository.ContactsPage;
import com.crm.autodesk.ObjectRepository.CreateNewContactPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.genericUtility.BaseClass;
@Listeners(com.crm.autodesk.genericUtility.ListenerImplementation.class)
public class CreateContactTest extends BaseClass
{

	@Test(groups="SmokeSuit")
	public void createContactTest() throws Throwable {

		// get a random number
		int ranNum= jLib.getRandomNumber();

		//read data from Excel
		String cont= eLib.getExcelData("org", 2, 1)+ ranNum;

		//click on contact link
		HomePage hp= new HomePage(driver);
		hp.clickOnContact();

		//click on create new contact lookUp img
		ContactsPage cp= new ContactsPage(driver);
		cp.clickOnCreateContact();
		//SoftAssert sa= new SoftAssert();
		//sa.fail();

		//create new contact
		CreateNewContactPage newContact= new CreateNewContactPage(driver);
		newContact.createContact(cont);

		//varify result-Using hard assert for mandatory field
		ContactInfoPage cip= new ContactInfoPage(driver);
		String contact = cip.ContactInfoHeaderText();

		boolean result = contact.contains(cont);
		Assert.assertTrue(result);
		Reporter.log("Contact Created...Test script pass...", true);
		//sa.assertAll();
	}
}
