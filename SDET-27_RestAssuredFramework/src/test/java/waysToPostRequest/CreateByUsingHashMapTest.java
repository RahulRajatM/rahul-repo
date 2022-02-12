package waysToPostRequest;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateByUsingHashMapTest {

	@Test
	public void createProject()
	{
		HashMap map= new HashMap();
		map.put("createdBy", "RRM");
		map.put("projectName","Hash" );
		map.put("status", "On Going");
		map.put("teamSize", 44);

		given()
		.body(map)
		.contentType(ContentType.JSON)
		.when()
		.post("http://localhost:8084/addProject")		
		.then()
		.assertThat().statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();

	}
}
