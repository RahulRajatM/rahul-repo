package com.RMGYantraTest;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import GenericUtility.BaseAPIClass;
import GenericUtility.IEndPoint;
import PojoLibrary.Pojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class CreateResourceAndVarifyInDbTest extends BaseAPIClass {

	@Test
	public void createResourceAndVarifyInDBTest() throws Throwable
	{
		//Step1: create test data
		Pojo pObj= new Pojo("The RRM", "LifeJourney"+jLib.getRadomNUm(), "OnGoing", 1);

		//Step2: execute post request
		Response resp = given()
				.body(pObj)
				.contentType(ContentType.JSON)

				.when()
				.post(IEndPoint.createProject);

		//Step3: capture the projectId from response

		String expData = rLib.getJSONData(resp, "projectId");
		Reporter.log(expData +" data in response body", true);

		//Step4: Varify data in DB
		String query= "select * from project;";
		String actData= dLib.executeQueryAndGetData(query, 1, expData);
		Reporter.log(actData+" data in database", true);

		Assert.assertEquals(expData, actData);
		Reporter.log("Data verification successful", true);

	}
}
