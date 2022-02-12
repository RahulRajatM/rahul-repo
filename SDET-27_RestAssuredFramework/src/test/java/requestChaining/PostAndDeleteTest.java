package requestChaining;

import org.testng.annotations.Test;

import PojoLibrary.Pojo;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class PostAndDeleteTest {
	@Test
	public void postAndDeleteTest()
	{

		Pojo pObj= new Pojo("THE RRM", "Gange", "Completed", 111); 

		Response resp = given()
		.body(pObj)
		.contentType(ContentType.JSON)
		.when()
		.post("http://localhost:8084/addProject");

		resp.then()
		.assertThat().statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();

		//System.out.println(resp.prettyPeek());

		String proId = resp.jsonPath().get("projectId");

		given()
		.pathParam("projectId", proId)

		.when()
		.delete("http://localhost:8084/projects/{projectId}")

		.then()
		.assertThat().log().all();




	}
}
