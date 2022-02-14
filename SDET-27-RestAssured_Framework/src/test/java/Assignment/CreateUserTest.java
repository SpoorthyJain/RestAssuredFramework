package Assignment;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class CreateUserTest 
{
	@Test
	public void create()
	{
		JSONObject jObj = new JSONObject();
		jObj.put("designation", "SDET");
		jObj.put("dob", "25/05/1999");
		jObj.put("email", "nitheshh@gmail.com");
		jObj.put("empName", "nitheshh");
		jObj.put("experience", 15);
		jObj.put("mobileNo", "9888777857");
		jObj.put("project", "HDFC");
		jObj.put("role", "ROLE_ADMIN");
		jObj.put("username", "nitheshh");
		
		given()
			.body(jObj)
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