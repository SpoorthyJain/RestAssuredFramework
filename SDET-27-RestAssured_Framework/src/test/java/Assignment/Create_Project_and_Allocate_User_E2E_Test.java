package Assignment;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class Create_Project_and_Allocate_User_E2E_Test 
{
	@Test
	public void createAndAllocate()
	{
		//Step 1: Create project
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "Deepak");
		jObj.put("projectName", "Airtel");
		jObj.put("status", "Completed");
		jObj.put("teamSize", 12);
		
		//Step 2: Provide request specification
		Response resp = given()
				.body(jObj)
				.contentType(ContentType.JSON)
				
			.when()
				.post("http://localhost:8084/addProject");
		resp.then()
			.assertThat().time(Matchers.lessThan(600L), TimeUnit.MILLISECONDS)
			.statusCode(201)
			.contentType(ContentType.JSON)
			.log().all();
		
		String proName = resp.jsonPath().get("projectName");
		
		JSONObject jObj1 = new JSONObject();
		jObj1.put("designation", "SDET");
		jObj1.put("dob", "25/05/1999");
		jObj1.put("designation", "SDET");
		jObj1.put("email", "nithesh@gmail.com");
		jObj1.put("empName", "Nithesh");
		jObj1.put("experience", 15);
		jObj1.put("mobileNo", "9888777657");
		jObj1.put("project", proName);
		jObj1.put("role", "ROLE_ADMIN");
		jObj1.put("username", "nithesh");
		
		given()
			.body(jObj1)
			.contentType(ContentType.JSON)
			
		.when()
			.post("http://localhost:8084/employees")
			
		.then()
			.assertThat().time(Matchers.lessThan(600L), TimeUnit.MILLISECONDS)
			.statusCode(201)
			.contentType(ContentType.JSON)
			.log().all();
	}
}