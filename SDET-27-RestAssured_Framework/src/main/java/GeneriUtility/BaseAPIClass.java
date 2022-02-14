package GeneriUtility;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.*;


public class BaseAPIClass 
{
	public DatabaseUtility dLib = new DatabaseUtility();
	public JavaUtility jLib = new JavaUtility();
	public RestAssuredUtility rLib = new RestAssuredUtility();
	
	@BeforeSuite
	public void bsConfig() throws Throwable
	{	
		baseURI = "http://localhost";
		port = 8084;
		
		dLib.connectTODB();
		System.out.println("********Database Connection Established********");
	}
	
	@AfterSuite
	public void asConfig() throws Throwable  
	{
		dLib.closeDB();
		System.out.println("********Database Connection Closed********");
	}
} 