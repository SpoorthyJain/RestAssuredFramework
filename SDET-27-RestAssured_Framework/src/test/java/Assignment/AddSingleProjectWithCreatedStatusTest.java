package Assignment;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class AddSingleProjectWithCreatedStatusTest 
{
	@Test
	public void create()
	{
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "Deepak");
		jObj.put("createdOn", "11/02/2022");
		jObj.put("projectName", "Deepak_pro-1");
		jObj.put("status", "Created");
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