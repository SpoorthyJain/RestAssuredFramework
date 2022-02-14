package responseValidation;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import pojoLibrary.PojoClass;

import static io.restassured.RestAssured.*;

public class CreateMultipleDataTest 
{
	@Test(dataProvider = "getData")
	public void create(String createdBy, String projectName, String status, int teamSize)
	{
		PojoClass pojo = new PojoClass(createdBy, projectName, status, teamSize);
		
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
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] objArray = new Object[2][4];
		
		objArray[0][0]="Spoor";
		objArray[0][1]="Audi";
		objArray[0][2]="Completed";
		objArray[0][3]=99;

		objArray[1][0]="Spooru";
		objArray[1][1]="BMW";
		objArray[1][2]="Created";
		objArray[1][3]=101;
		
		return objArray;
		
	}
}