package com.RMGYantraTests;

import org.testng.Reporter;
import org.testng.annotations.Test;

import GeneriUtility.BaseAPIClass;
import GeneriUtility.EndPoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoLibrary.PojoClass;

import static io.restassured.RestAssured.*;

public class UpdateResourceAndVerifyInDatabase extends BaseAPIClass
{
	@Test
	public void updateResourceAndVerifyInDB() throws Throwable
	{
		//Step 1: Update the data
		PojoClass pObj= new PojoClass("Spoorthy", "TechMahindra"+jLib.getRandomNumber(), "Completed", 10);
		
		//Step 2: Execute put request
		Response resp = given()
		.body(pObj)
		.contentType(ContentType.JSON)
		.when()
		.put(EndPoints.updateProject +"/TY_PROJ_1013");
		
		//Step 3: Capture the project reponse
		String expData = rLib.getJSONData(resp, "status");
		
		//Step 4: Verify in databade
		String querry = "select * from project;";
		String actData = dLib.executeQueryAndGetData(querry, 5, expData);
		
		Reporter.log(actData,true);
		System.out.println(actData);
	}
}