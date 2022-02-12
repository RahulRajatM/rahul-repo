package com.authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PreemptiveAuthTest {

	@Test
	public void preemptiveAuthTest()
	{
		given()
		.auth().preemptive().basic("rmgyantra", "rmgy@9999")

		.when()
		.get("http://localhost:8084/login");


	}

	@Test
	public void digestiveTest()
	{

	}
}
