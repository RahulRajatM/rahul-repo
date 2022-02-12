package GenericUtility;

import java.util.Random;

public class JavaUtility {

	/**
	 * This class contains java specific generic method
	 * @author Rahul
	 */

	public int getRadomNUm()
	{
		/**
		 * This method return a random number for each execution
		 * @author Rahul
		 * @return int
		 */
		Random random= new Random();
		int value= random.nextInt(5000);
		return value;
	}
}
