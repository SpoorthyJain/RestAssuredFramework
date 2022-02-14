package practiceCRUDWithoutBDD;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteProject 
{
	public void deleteProject()
	{
		//Step 1
		int expStatus = 204;
		Response resp = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_802");
		
		//Step 2
		int actStatus = resp.getStatusCode();
		Assert.assertEquals(expStatus, actStatus);
		System.out.println(resp.prettyPrint());
	}
}