package parametersAndAuthentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathParaDeleteProject {

	@Test
	public void deleteProject()
	{
		given()
		.pathParam("proId", "TY_PROJ_007")

		.when()
		.delete("http://localhost:8084/projects/{proId}")
		.then()
		.assertThat().log().all();

	}
}
