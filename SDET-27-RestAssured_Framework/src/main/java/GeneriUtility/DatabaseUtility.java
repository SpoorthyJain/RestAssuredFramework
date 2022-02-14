package GeneriUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import com.mysql.cj.jdbc.Driver;

/**
 * This class contains generic methods to connect to database
 * @author Spoorthy
 *
 */
public class DatabaseUtility 
{
	Connection con = null;
	//Step 1: Register the Database---1
	//Step 2: Get Connection with Database---1
	//Step 3: Issue create statement---2
	//Step 4: Execute Query---2
	//Step 5: Close connection---3
	
	/**
	 * This method will establish connection with database
	 * @throws Throwable
	 */
	public void connectTODB() throws Throwable
	{
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		con = DriverManager.getConnection(IConstants.dbURL, IConstants.dbUserName, IConstants.dbPassword);
	}
	
	/**
	 * This method will ececute query and return data present in database
	 * @param query
	 * @param columnIndex
	 * @param expData
	 * @return
	 * @throws Throwable
	 */
	public String executeQueryAndGetData(String query, int columnIndex, String expData) throws Throwable
	{
		boolean flag = false;
		ResultSet result = con.createStatement().executeQuery(query);
		while(result.next())
		{
			String value = result.getString(columnIndex);
			if(value.equalsIgnoreCase(expData))
			{
				flag = true; //rising flag
				break;
			}
		}
		if(flag)
		{
			System.out.println(expData+" Data Verified ");
			return expData;
		}
		else
		{
			System.out.println("Data is not present");
			return "";
		}
	}
	
	/**
	 * This method will close database connection
	 * @throws Throwable 
	 */
	public void closeDB() throws Throwable
	{
		con.close();
	}
}