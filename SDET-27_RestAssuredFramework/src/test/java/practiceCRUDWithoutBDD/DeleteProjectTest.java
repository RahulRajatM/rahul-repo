package practiceCRUDWithoutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteProjectTest {

	@Test
	public void deleteProject()
	{
		//STEP 1: perform action
		int expStatus= 204;
		Response resp = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_1002");

		//STEP 2: VArify response

		int actStatus= resp.getStatusCode();
		Assert.assertEquals(expStatus, actStatus);
		System.out.println(resp.prettyPeek());
	}
}
