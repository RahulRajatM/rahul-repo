package practice;

import java.util.Date;
import java.util.StringTokenizer;

public class SystemDateAndTimeWithFormat 
{
	public static void main(String[] args) {
		Date date= new Date();
		String dateAndTime=date.toString();
		String YYYY=dateAndTime.split(" ")[5];
		String DD=dateAndTime.split(" ")[2];
		int MM=date.getMonth();
		String finalFormat=YYYY+"-"+MM+"-"+DD;
		System.out.println(finalFormat);
	}
}
