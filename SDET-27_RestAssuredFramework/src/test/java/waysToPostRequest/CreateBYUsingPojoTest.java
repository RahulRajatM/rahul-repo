package waysToPostRequest;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import PojoLibrary.Pojo;
import io.restassured.http.ContentType;

public class CreateBYUsingPojoTest {

	@Test
	public void create()
	{
		Pojo pObj= new Pojo("Lord Thanos", "Cosmos","completed", 1000);
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
}
