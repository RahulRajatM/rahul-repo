package parametersAndAuthentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathParameterTest {

	@Test
	public void getUserTest()
	{
		given()
		.pathParam("proID", "TY_PROJ_005")

		.when()
		.get("http://localhost:8084/projects/{proID}")

		.then()
		.assertThat().log().all();
	}
}
