package requestChaining;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class RequestChainingTest {

	@Test
	public void requestChaining()
	{
		Response resp = when()
				.get("http://localhost:8084/projects");

		String proId = resp.jsonPath().get("[0].projectId");
		given()
		.pathParam("projectId", proId)

		.when()
		.delete("http://localhost:8084/projects/{projectId}")
		.then()
		.assertThat().log().all();


	}
}
