package com.RMGYantraTests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import GeneriUtility.BaseAPIClass;
import GeneriUtility.EndPoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoLibrary.PojoClass;

import static io.restassured.RestAssured.*;

public class CreateResourseAndVerifyInDatabase extends BaseAPIClass
{
	@Test
	public void createResourceAndVerifyInDB() throws Throwable
	{
		//Step 1: Create test data
		PojoClass pObj= new PojoClass("Spoorthy", "TechMahindra"+jLib.getRandomNumber(), "OnGoing", 10);

		//Step 2: Execute post request
		Response resp = given()
				.body(pObj)
				.contentType(ContentType.JSON)

			.when()
			.post(EndPoints.createProject);
		
		//Step3: Capture the projectId from response

		String expData = rLib.getJSONData(resp, "projectId");
		System.out.println(expData);
		
		//Step4: verify data in DB
		String query= "select * from project;";
		String actData= dLib.executeQueryAndGetData(query, 1, expData);
		Reporter.log(actData+" data in database", true);

		Assert.assertEquals(expData, actData);
		Reporter.log("Data verification successful", true);
	}
}