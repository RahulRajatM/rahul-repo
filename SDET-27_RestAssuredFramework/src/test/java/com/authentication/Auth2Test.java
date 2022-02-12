package com.authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Auth2Test {

	@Test
	public void oAuth2()
	{
		Response resp =given()
				.formParam("client_id", "First_APP")
				.formParam("client_secret", "352bf38596ce260672e7375516910b6b")

				.formParam("grant_type", "client_credentials")
				.formParam("redirect_uri", "https://example.com")


				.when()
				.post("http://coop.apps.symfonycasts.com/token");

		/*String token = resp.jsonPath().get("access_token");
		given()
		.auth().oauth2(token)

		.pathParam("USER_ID", "2780")
		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/chickens-feed")*/

		resp.then()
		.assertThat().log().all();



	}
}
