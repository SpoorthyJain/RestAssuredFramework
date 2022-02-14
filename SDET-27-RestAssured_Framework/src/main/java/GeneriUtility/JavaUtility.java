package GeneriUtility;

import java.util.Random;

/**
 * This class contains java specific generic methods
 * @author Spoorthy
 *
 */
public class JavaUtility 
{
	/**
	 * This method will generate a random value for every run
	 */
	public int getRandomNumber()
	{
		Random ran = new Random();
		int value = ran.nextInt(100);
		return value;
	}
}