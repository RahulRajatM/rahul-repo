package practiceCRUDWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;



import java.util.Random;

public class CreateResourceTest {

	@Test
	public void createResource()
	{
		
		
		Random ran = new Random();
		int ranNum= ran.nextInt(500);
		
		JSONObject jObj= new JSONObject();
		jObj.put("createdBy", "RRMishra");
		jObj.put("projectName","RestAssuredBDD"+ranNum);
		jObj.put("status", "On Going");
		jObj.put("teamSize", 25);

		given() //precondition
		.body(jObj)
		.contentType(ContentType.JSON)
		
		.when() //action
		.post("http://localhost:8086/addProject")
		
		.then() //validation
		.assertThat().contentType(ContentType.JSON)
		.statusCode(201)
		.log().all();

	}

}
