package GeneriUtility;

import io.restassured.response.Response;

/**
 * THis class contains generic methods specific to rest assured
 * @author Spoorthy
 *
 */
public class RestAssuredUtility 
{
	/**
	 * This method will return the json data for the json path specified
	 * @param resp
	 * @param jsonPath
	 * @return
	 */
	public String getJSONData(Response resp, String jsonPath)
	{
		String jsonData = resp.jsonPath().get(jsonPath);
		return jsonData;
	}
}