package GenericUtility;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.*;

public class BaseAPIClass {

	public DatabaseUtility dLib= new DatabaseUtility();
	public JavaUtility jLib= new JavaUtility();
	public RestAssuredUtility rLib= new RestAssuredUtility();
	@BeforeSuite
	public void bsConfig() throws Throwable
	{
		baseURI= "http://localhost";
		port= 8084;
		dLib.connectToDb();
		System.out.println("===Connected to Database===");
	}

	@AfterSuite
	public void asConfing() throws Throwable
	{
		dLib.closeDbConnection();
		System.out.println("===Database connection closed===");
	}
}
