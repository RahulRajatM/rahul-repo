package practiceCRUDWithBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;


public class DeleteResourceTest {
	@Test
	public void deleteProjects()
	{
		when()
		.delete("http:localhost:8086/projects/TY_PROJ_008")
		.then()
		.assertThat().statusCode(204)
		.log().all();

	}

}
