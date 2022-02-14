package Assignment;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoLibrary.PojoClassEmployee;

import static io.restassured.RestAssured.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Create_and_Delete_User_E2E_Test 
{
	@Test
	public void create()
	{
		Random ran = new Random();
		int randomNumber = ran.nextInt(500);
		
		PojoClassEmployee pojo = new PojoClassEmployee("SDET"+randomNumber, "25/05/1999", "nithesh@gmail.com", 
				"nithesh"+randomNumber, "15", "9888777857", "HDFC", "ROLE_ADMIN", "nitheshh"+randomNumber);
		
		Response resp = given()
				.body(pojo)
				.contentType(ContentType.JSON)
			
		.when()
			.post("http://localhost:8084/employees");
		
		resp.then()
		.assertThat().time(Matchers.lessThan(2200L), TimeUnit.MILLISECONDS)
		.statusCode(201)
		.contentType(ContentType.JSON);
		
		String empid = resp.jsonPath().get("employeeId");
		System.out.println(empid);
		given()
			.pathParam("userID", empid)
			.contentType(ContentType.JSON)
			.get("http://localhost:8084/employees/{userID}")
		
		.then()
			.assertThat().statusCode(200)
			.contentType(ContentType.JSON).time(Matchers.lessThan(2200L), TimeUnit.MILLISECONDS)
			.log().all();
	}
}
