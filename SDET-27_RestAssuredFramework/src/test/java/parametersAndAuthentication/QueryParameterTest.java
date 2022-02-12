package parametersAndAuthentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class QueryParameterTest {

	@Test
	public void queryParamTest()
	{
		given()
		.queryParam("page", "2")

		.when()
		.get("https://reqres.in/api/users")

		.then()
		.assertThat().log().all();

	}
}
