package com.Parameters;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class ParametersTest 
{
	@Test
	public void params()
	{
		given()
			.pathParam("username", "spoorthyjain")
			.queryParam("type", "member")
			.queryParam("sort", "created")
			.queryParam("per_page", 100)
			
			.when()
				.get("https://api.github.com/users/{username}/repos")
				
			.then()
				.assertThat().contentType(ContentType.JSON)
				.statusCode(200)
				.log().all();
	}
}