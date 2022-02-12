package com.authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BearerTokenTest {

	@Test
	public void bearerToken()
	{
		given()
		.auth().oauth2("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")
		.get("https://api.github.com/user/repos")

		.then()
		.assertThat().statusCode(200)
		.log().all();

	}
}
