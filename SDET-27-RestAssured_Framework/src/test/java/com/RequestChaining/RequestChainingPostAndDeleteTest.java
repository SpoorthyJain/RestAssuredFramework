package com.RequestChaining;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoLibrary.PojoClass;

import static io.restassured.RestAssured.*;

public class RequestChainingPostAndDeleteTest 
{
	@Test
	public void chaining()
	{
		PojoClass pojo = new PojoClass("Reagan007", "Reagan777", "Completed", 70);
		
		 Response res = given()
				.body(pojo)
			    .contentType(ContentType.JSON)
				 
		 .when()
		 	.post("http://localhost:8084/addProject");
		 
		String proId = res.jsonPath().get("projectId");
		 
		 given()
		 	.pathParam("project", proId)
		 	
		 	.delete("http://localhost:8084/projects/{project}")
		 	
		 .then()
		 	.statusCode(204)
		 	.contentType(ContentType.JSON)
		 	.log().all();
	}
}