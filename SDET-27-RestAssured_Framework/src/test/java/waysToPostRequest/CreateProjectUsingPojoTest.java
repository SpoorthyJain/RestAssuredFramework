package waysToPostRequest;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import pojoLibrary.PojoClass;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingPojoTest 
{
	@Test
	public void create()
	{
		PojoClass pojo = new PojoClass("SP Jain", "Honeywell", "Created", 70);
		
		given()
			.body(pojo)
			.contentType(ContentType.JSON)
			
		.when()
			.post("http://localhost:8084/addProject")
			
		.then()
			.assertThat().statusCode(201)
			.contentType(ContentType.JSON)
			.log().all();
	}
}