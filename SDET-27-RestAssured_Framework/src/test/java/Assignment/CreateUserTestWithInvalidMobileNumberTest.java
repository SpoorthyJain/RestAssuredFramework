package Assignment;

import static io.restassured.RestAssured.given;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoLibrary.PojoClassEmployee;

public class CreateUserTestWithInvalidMobileNumberTest 
{
	@Test
	public void create()
	{
		int randomNumber = new Random().nextInt();
		String proName = "nitheshh"+randomNumber;
		PojoClassEmployee pojo = new PojoClassEmployee("SDET", "25/05/1999", "nithesh@gmail.com", 
				proName, "15", "9888777857111", "HDFC", "ROLE_ADMIN", "nitheshh");
		
		Response resp = given()
			.body(pojo)
			.contentType(ContentType.JSON)
		
		.when()
			.post("http://localhost:8084/employees");
			String projectName = resp.jsonPath().get("username");
		
		resp.then()
			.assertThat().time(Matchers.lessThan(600L), TimeUnit.MILLISECONDS)
			.statusCode(422)
			.contentType(ContentType.JSON)
			.log().all();
	}
}