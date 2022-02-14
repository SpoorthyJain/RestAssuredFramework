package com.Parameters;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PathParameterTest 
{
	@Test
	public void param()
	{
		String proId = "TY_PROJ_003";
		
		given()
			.pathParam("projectID", proId)
			
		.when()
			.delete("http://localhost:8084/projects/{projectID}")
			
		.then()
			.assertThat().contentType(ContentType.JSON)
			.statusCode(204)
			.log().all();
	}
}