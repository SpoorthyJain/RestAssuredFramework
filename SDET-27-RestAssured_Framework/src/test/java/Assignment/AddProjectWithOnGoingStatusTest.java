package Assignment;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class AddProjectWithOnGoingStatusTest 
{
	@Test
	public void create()
	{
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "Deepak");
		jObj.put("createdOn", "11/02/2022");
		jObj.put("projectName", "Deepak_pro-2");
		jObj.put("status", "On Going");
		jObj.put("teamSize", 10);
		
		given()
			.body(jObj)
			.contentType(ContentType.JSON)
			
		.when()
			.post("http://localhost:8084/addProject")
			
		.then()
			.assertThat().statusCode(201).time(Matchers.lessThan(3000L), TimeUnit.MILLISECONDS)
			.contentType(ContentType.JSON)
			.log().all();
	}
}