package responseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class DynamicResponseValidationTest {

	@Test
	public void varify()
	{
		String project= "stringP";
		Response resp = when()
				.get("http://localhost:8084/projects");

		List<String> projects= resp.jsonPath().get("projectName");
		boolean flag= false;
		for (String string : projects) {

			try {
				if(string.equals(project))
				{
					flag= true;
				}
			}
			catch(NullPointerException e)
			{
				e.printStackTrace();
			}
		}

		resp.then().assertThat().statusCode(200).and().contentType(ContentType.JSON)
		.log().all();

		Assert.assertEquals(flag, true);
	}
}
