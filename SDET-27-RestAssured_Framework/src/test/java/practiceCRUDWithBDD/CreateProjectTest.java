package practiceCRUDWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class CreateProjectTest 
{
	@Test
	public void create()
	{
		//Create random number
		Random ran = new Random();
		int randomNumber = ran.nextInt(500);
		
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "ALIA");
		jObj.put("projectName", "APTY123");
		jObj.put("status", "Completed");
		jObj.put("teamSize", 30);
		
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