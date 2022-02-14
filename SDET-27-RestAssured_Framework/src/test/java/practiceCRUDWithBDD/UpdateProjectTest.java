package practiceCRUDWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class UpdateProjectTest 
{
	@Test
	public void update()
	{
		//Create random number
		Random ran = new Random();
		int randomNumber = ran.nextInt(500);
				
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "ALIA");
		jObj.put("projectName", "APTY123");
		jObj.put("status", "Completed");
		jObj.put("teamSize", 50);
				
		given()
			.body(jObj)
			.contentType(ContentType.JSON)
				
		.when()
			.put("http://localhost:8084/projects/TY_PROJ_1002")
				
		.then()
			.assertThat().statusCode(200)
			.log().all();
	}
}