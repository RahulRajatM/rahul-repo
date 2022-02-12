package parametersAndAuthentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class ParhAndQueryParameterTest {

	@Test
	public void parameters()
	{
		given()
		.pathParam("endPoint", "api/users")
		.queryParam("page", "2")

		.when()
		.get("https://reqres.in/{endPoint}")

		.then()
		.assertThat()
		.log().all();

	}
}
