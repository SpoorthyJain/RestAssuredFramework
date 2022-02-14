package com.Authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class OAuth2 
{
	@Test
	public void auths()
	{
		Response response = given()
				.formParams("client_id", "SDET-27")
				.formParams("client_secret", "320cf223ec3ce29381786e85a9246843")
				.formParams("grant_type", "client_credentials")
				.formParams("redirect_uri", "https://example.com")
				
			.when()
				.post("http://coop.apps.symfonycasts.com/token");
			String token = response.jsonPath().get("access_token");
			
			given()
				.auth().oauth2(token)
				.pathParam("USER_ID", "2773")
				
			.when()
				.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/chickens-feed")
				
			.then()
				.log().all();
	}
}