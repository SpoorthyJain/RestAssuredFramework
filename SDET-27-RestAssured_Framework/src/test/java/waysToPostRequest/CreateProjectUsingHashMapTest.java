package waysToPostRequest;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class CreateProjectUsingHashMapTest 
{
	@Test
	public void create()
	{
		HashMap map = new HashMap();
		map.put("createdBy", "REAGAN");
		map.put("projectName", "APTY456");
		map.put("status", "Completed");
		map.put("teamSize", 40);
		
		given()
			.body(map)
			.contentType(ContentType.JSON)
		
		.when()
			.post("http://localhost:8084/addProject")
		
		.then()
			.assertThat().statusCode(201)
			.contentType(ContentType.JSON)
			.log().all();
	}
}