package Assignment;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class GetAllProjectsTest 
{
	@Test
	public void getProject()
	{
		when()
			.get("http://localhost:8084/projects")
			
		.then()
			.assertThat().time(Matchers.lessThan(1000L), TimeUnit.MILLISECONDS)
			.statusCode(200).contentType(ContentType.JSON)
			.log().all();
	}
}