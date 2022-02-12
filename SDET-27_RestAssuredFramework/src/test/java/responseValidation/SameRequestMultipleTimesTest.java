package responseValidation;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PojoLibrary.Pojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class SameRequestMultipleTimesTest {

	@Test(dataProvider = "setData")
	public void createResource(String createdBy, String projectName, String status, int teamSize)
	{
		Pojo pObj= new Pojo(createdBy, projectName, status, teamSize);

		given()
		.body(pObj)
		.contentType(ContentType.JSON)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();

	}
	@DataProvider
	public Object[][] setData()
	{
		Object[][] obj= new Object[2][4];
		obj[0][0]="AAA";
		obj[0][1]="BBB";
		obj[0][2]="Completed";
		obj[0][3]=100;

		obj[1][0]="CCC";
		obj[1][1]="DDD";
		obj[1][2]="Completed";
		obj[1][3]=200;

		return obj;
	}
}
