package practiceCRUDWithoutBDD;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpdateProject 
{
	public void updateProject()
	{
		//Step 1: Create test data
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "SJ");
		jObj.put("projectName", "APTY");
		jObj.put("status", "Completed");
		jObj.put("teamSize", 12);
		
		//Step 2
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.body(jObj);
		
		//Step 3
		Response resp = req.put("http://localhost:8084/projects/TY_PROJ_802");
		
		//Step 4
		ValidatableResponse validate = resp.then();
		validate.assertThat().statusCode(200);
		validate.log().all();
	}
}