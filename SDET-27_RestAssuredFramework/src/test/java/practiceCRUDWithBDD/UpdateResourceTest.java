package practiceCRUDWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UpdateResourceTest {

	@Test
	public void updateResource()
	{
		JSONObject jObj= new JSONObject();
		jObj.put("createdBy", "PKMishra");
		jObj.put("projectName","RestAssuredBDD");
		jObj.put("status", "On Going");
		jObj.put("teamSize", 25);
		given()
		.body(jObj)
		.contentType(ContentType.JSON)
		.when()
		.put("http://localhost:8084/projects/TY_PROJ_008")
		.then()
		.statusCode(200)
		.assertThat().contentType(ContentType.JSON)
		.log().all();

	}
}
