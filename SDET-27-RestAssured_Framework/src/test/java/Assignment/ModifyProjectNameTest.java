package Assignment;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class ModifyProjectNameTest 
{
	@Test
	public void updateProject()
	{
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "Deepak");
		jObj.put("projectName", "Deepak_pro-3");
		jObj.put("status", "Completed");
		jObj.put("teamSize", 10);
		
		given()
			.body(jObj)
			.contentType(ContentType.JSON)
		.when()
			.put("http://localhost:8084/projects/TY_PROJ_1009")
			
		.then()
			.assertThat().time(Matchers.lessThan(3000L), TimeUnit.MILLISECONDS)
			.statusCode(200)
			.log().all();
	}
}