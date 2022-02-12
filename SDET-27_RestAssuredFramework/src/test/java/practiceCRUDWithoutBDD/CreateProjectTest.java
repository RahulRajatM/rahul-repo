package practiceCRUDWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProjectTest {

	@Test
	public void createProject()
	{
		//step 1: create test data (create JSONObject using json simple library

		JSONObject jObj= new JSONObject();
		jObj.put("createdBy", "RRM");
		jObj.put("projectName","RestAssured1233" );
		jObj.put("status", "On Going");
		jObj.put("teamSize", 44);

		//STEP-2: provide RequestSpecification

		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.body(jObj);

		// STEP-3: perform the action
		Response resp = req.post("http://localhost:8084/addProject");

		//STEP-4: print on the consol and varify
		int expStatusCode= 201;
		System.out.println(resp.prettyPrint());
		System.out.println(resp.asString());
		System.out.println(resp.prettyPeek());
		System.out.println(resp.contentType());
		int actualStatusCode = resp.statusCode();
		Assert.assertEquals(expStatusCode, actualStatusCode);
	}
}
