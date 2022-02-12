package waysToPostRequest;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateByUsingJSONFileTest {

	@Test
	public void create()
	{
		File f= new File("./JSONDATA.json");

		given()
		.body(f)
		.contentType(ContentType.JSON)
		.when()
		.post("http://localhost:8084/addProject")		
		.then()
		.assertThat().statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
	}
}
