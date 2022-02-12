package practiceCRUDWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpdateProjectTest {

	@Test
	public void updateProject()
	{
		//STEP 1: Create data to be updated
		JSONObject jObj= new JSONObject();
		jObj.put("createdBy", "RRM");
		jObj.put("projectName","RestAssured" );
		jObj.put("status", "Completed");
		jObj.put("teamSize", 50);

		//STEP 2: set RequestSpecification
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.body(jObj);

		// perform action 

		Response resp = req.put("http://localhost:8084/projects/TY_PROJ_1002");

		//STEP 4: Verify response

		//System.out.println(resp.prettyPeek());
		ValidatableResponse validate = resp.then();
		validate.assertThat().statusCode(200);
		validate.log().all();
	}

}
