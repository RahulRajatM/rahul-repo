package practiceCRUDWithBDD;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetAllResourceTest {

	@Test
	public void getResource()
	{
		when()
		.get("http://localhost:8084/projects")
		.then()
		.assertThat().statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();

	}
}
