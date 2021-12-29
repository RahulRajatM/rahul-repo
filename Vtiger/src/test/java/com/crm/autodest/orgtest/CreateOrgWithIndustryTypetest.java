package com.crm.autodest.orgtest;

import org.testng.annotations.Test;

import com.crm.autodesk.ObjectRepository.CreateNewOrganizationPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.OrganizationInfoPage;
import com.crm.autodesk.ObjectRepository.OrganizationPage;
import com.crm.autodesk.genericUtility.BaseClass;

public class CreateOrgWithIndustryTypetest extends BaseClass{
	@Test
	public void createOrg() throws Throwable 
	{
		//create random number
		int randomNo = jLib.getRandomNumber();

		//read data from excel
		String orgName = eLib.getExcelData("org", 1, 2) + randomNo;
		String indsName = eLib.getExcelData("Org", 1, 3) ;
		String indstype = eLib.getExcelData("Org", 1, 4) ;


		//click on organizationLink
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizations();

		//click on lookup img in OrganizationPage
		OrganizationPage op= new OrganizationPage(driver);
		op.ClickOnCreateOrg();

		// Create Org with industry and type
		CreateNewOrganizationPage cop=new CreateNewOrganizationPage(driver);
		cop.createOrgWithIndustryAndType(orgName, indsName, indstype);

		//varify result
		OrganizationInfoPage orgInfo= new OrganizationInfoPage(driver);
		String orgHeader=orgInfo.OrgHeaderInfo();
		if(orgHeader.contains(orgName))
		{
			System.out.println("Organization created with industry and type...so pass");
		}
		else
		{
			System.out.println("Organization not created with industry and type...so fail");
		}
	}
}
