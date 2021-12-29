package practice;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class CreateCustomerTest {

	@Test(retryAnalyzer = com.crm.autodesk.genericUtility.RetryAnalyserImpl.class)
	public void createCustomerTest()
	{
		Reporter.log("Customer Created successfully...",true);
		Assert.fail();
	}
}
