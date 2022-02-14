package responseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StaticResponseValidation 
{
	@Test
	public void verify()
	{
		String expectedProjectName = "TestYantra001";
		Response response = when()
			.get("http://localhost:8084/projects");
		String actualProjectName = response.jsonPath().get("[0].projectName");
		
		response.then()
			.assertThat()
			.contentType(ContentType.JSON).and().statusCode(200)
			.log().all();
		Assert.assertEquals(expectedProjectName, actualProjectName);
	}
}