package com.Parameters;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class QueryParameterTest 
{
	@Test
	public void param()
	{
		given()
			.queryParams("page", "2")
			
		.when()
			.get("https://reqres.in/api/users")
			
		.then()
			.assertThat().contentType(ContentType.JSON)
			.statusCode(200)
			.log().all();
	}
}