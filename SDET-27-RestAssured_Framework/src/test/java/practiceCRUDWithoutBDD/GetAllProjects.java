package practiceCRUDWithoutBDD;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllProjects 
{
	public void getAllProjects()
	{
		//Step 1
		int expStatus = 200;
		Response resp = RestAssured.get("http://localhost:8084/projects");
		
		//Step 2
		System.out.println(resp.prettyPeek());
		int actStatus = resp.getStatusCode();
		Assert.assertEquals(expStatus, actStatus);
	}
}