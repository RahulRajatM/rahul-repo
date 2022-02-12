package responseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StaticResponseValidationTest {

	@Test
	public void varify()
	{
		String expProName= "stringP";

		Response response = when()
				.get("http://localhost:8084/projects");

		String actProName= response.jsonPath().get("[0].projectName");

		response.then().assertThat()
		.contentType(ContentType.JSON).and().statusCode(200)
		.log().all();

		Assert.assertEquals(expProName, actProName);

	}
}
