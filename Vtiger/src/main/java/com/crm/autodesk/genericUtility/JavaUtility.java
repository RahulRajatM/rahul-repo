package com.crm.autodesk.genericUtility;

import java.util.Date;
import java.util.Random;
/**
 * @author Rahul
 *
 */
public class JavaUtility 
{
	/**
	 * It's used to return random number
	 * @return int number
	 */
	public int getRandomNumber()
	{
		Random random= new Random();
		int intRandom = random.nextInt(1000);
		return intRandom;
	}
	/**
	 * Used to get system date and time in IST format
	 * @return
	 */
	public String getSystemDateAndTime()
	{
		Date date= new Date();
		return date.toString();
	}
	/**
	 * Used to get system date and time in YYYY-MM-DD format
	 * @return
	 */
	public String getSystemDateWithFormat()
	{
		Date date= new Date();
		String dateAndTime=date.toString();
		String YYYY=dateAndTime.split(" ")[5];
		String DD=dateAndTime.split(" ")[2];
		@SuppressWarnings("deprecation")
		int MM=date.getMonth();
		String finalFormat=YYYY+"-"+MM+"-"+DD;
		return finalFormat;
	}
}
