package practiceCRUDWithoutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllProjectsTest {

	@Test
	public void getAllProjects()
	{
		//STEP 1 : send get request
		int expStatus= 200;
		Response resp = RestAssured.get("http://localhost:8084/projects");

		//STEP 2: varify result
		int actStatus= resp.getStatusCode();
		System.out.println(resp.prettyPeek());
		Assert.assertEquals(expStatus, actStatus);


	}
}
