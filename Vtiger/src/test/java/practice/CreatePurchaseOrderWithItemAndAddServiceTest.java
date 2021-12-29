package practice;

import org.testng.annotations.Test;

import com.crm.autodesk.ObjectRepository.CreateNewPurchaseOrderPage;
import com.crm.autodesk.ObjectRepository.CreateNewServicePage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.PurchaseOrderInfoPage;
import com.crm.autodesk.ObjectRepository.PurchaseOrderPage;
import com.crm.autodesk.ObjectRepository.ServicesPage;
import com.crm.autodesk.genericUtility.BaseClass;

public class CreatePurchaseOrderWithItemAndAddServiceTest extends BaseClass {
	@Test
	public void CreateNewPurchaseOrderTest()
	{
		HomePage hp= new HomePage(driver);
		hp.clickOnServicesLink(driver);
		ServicesPage sp= new ServicesPage(driver);
		sp.clickOnCreateService();
		CreateNewServicePage cns= new CreateNewServicePage(driver);
		cns.createNewService("Food Delivery Service");
		hp.getMoreDropdown();
		hp.clickOnPurchaseOrderLink(driver);
		PurchaseOrderPage pop= new PurchaseOrderPage(driver);
		pop.clickOnCreatePurchaseOrder();
		CreateNewPurchaseOrderPage cpop= new CreateNewPurchaseOrderPage(driver);
		cpop.createPurchaseOrder(driver, "Test","Food Delivery Service","Patna", "Chapra");
		PurchaseOrderInfoPage poInfo= new PurchaseOrderInfoPage(driver);
		String text=poInfo.purchaseOrderInfoHeaderText();
		System.out.println(text);
	}
}
