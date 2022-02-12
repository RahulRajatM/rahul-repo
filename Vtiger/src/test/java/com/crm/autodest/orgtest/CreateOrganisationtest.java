package com.crm.autodest.orgtest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.ObjectRepository.CreateNewOrganizationPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.OrganizationInfoPage;
import com.crm.autodesk.ObjectRepository.OrganizationPage;
import com.crm.autodesk.genericUtility.BaseClass;

public class CreateOrganisationtest  extends BaseClass
{
	@Test
	public void createOrg() throws Throwable 
	{
		//create random number
		int ranNum = jLib.getRandomNumber();

		//read data from excel
		String orgName = eLib.getExcelData("Org", 1, 2)+ranNum;

		//click on Organizations
		HomePage hp=new HomePage(driver);
		hp.clickOnOrganizations();

		//click on create new Organization
		OrganizationPage op=new OrganizationPage(driver);
		op.ClickOnCreateOrg();

		//create Organization
		CreateNewOrganizationPage cop=new CreateNewOrganizationPage(driver);
		cop.createOrg(orgName);

		//get Organization info header
		OrganizationInfoPage orgInfo= new OrganizationInfoPage(driver);
		String text=orgInfo.OrgHeaderInfo();

		//varify result
		boolean actualResult = text.contains("AutoDesk");
		Assert.assertEquals(actualResult, true);

		System.out.println("new organization created successfully...so pass");


	}
}
