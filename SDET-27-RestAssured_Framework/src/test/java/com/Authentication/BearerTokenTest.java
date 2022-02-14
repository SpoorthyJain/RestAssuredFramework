package com.Authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BearerTokenTest 
{
	@Test
	public void bearerAuth()
	{
		given()
			.auth().oauth2("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")
		
		.when()
			.get("http://api.github.com/user/repos")
		
		.then()
			.assertThat().statusCode(200)
			.log().all();
	}
}