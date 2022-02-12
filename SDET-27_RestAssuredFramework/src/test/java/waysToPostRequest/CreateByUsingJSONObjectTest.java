package waysToPostRequest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateByUsingJSONObjectTest {

	@Test
	public void create()
	{
		JSONObject jObj= new JSONObject();
		jObj.put("createdBy", "DON");
		jObj.put("projectName", "Underword");
		jObj.put("status", "completed");
		jObj.put("teamSize", 100);

		given()
		.body(jObj)
		.contentType(ContentType.JSON)

		.when()
		.post("http://localhost:8084/addProject")

		.then()
		.assertThat().contentType(ContentType.JSON)
		.statusCode(201)
		.log().all();
	}
}
