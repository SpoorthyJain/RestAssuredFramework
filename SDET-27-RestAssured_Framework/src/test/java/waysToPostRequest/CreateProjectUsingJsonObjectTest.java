package waysToPostRequest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class CreateProjectUsingJsonObjectTest 
{
	@Test
	public void create()
	{
		//Create random number
		Random ran = new Random();
		int randomNumber = ran.nextInt(500);
				
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "Aloo");
		jObj.put("projectName", "APTY14"+randomNumber);
		jObj.put("status", "Completed");
		jObj.put("teamSize", 90);
				
		given()
			.body(jObj)
			.contentType(ContentType.JSON)
				
		.when()
			.post("http://localhost:8084/addProject")
				
		.then()
			.assertThat().statusCode(201)
			.contentType(ContentType.JSON)
			.log().all();
	}
}