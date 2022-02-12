package practiceCRUDWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetSingleProjectTest {

	@Test
	public void getSingleProject()
	{
		//STEP 1
		Response resp = RestAssured.get("http://localhost:8084/projects/TY_PROJ_005	");

		//STEP 2
		ValidatableResponse validate = resp.then();
		validate.assertThat().statusCode(200);
		validate.log().all();
	//	System.out.println(resp.prettyPeek());

	}
}
