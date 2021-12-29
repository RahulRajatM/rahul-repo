package practice;

import java.sql.ResultSet;

import com.crm.autodesk.genericUtility.DataBaseUtility;
import com.crm.autodesk.genericUtility.JavaUtility;

public class DataBaseOperations {

	public static void main(String[] args) throws Exception {

		int num = new JavaUtility().getRandomNumber();

		//connect to db
		DataBaseUtility dLib= new DataBaseUtility();
		dLib.connectToDb("employeedb");
		//add data...update table
		dLib.updateQuery("insert into emp(id,name,address)values("+num+",'Rama','Ayodhya');");
		//read all data from cust table
		ResultSet result = dLib.executeQuery("select* from emp;");
		//print on consol
		while(result.next())
		{
			System.out.println(result.getInt(1)+"==>"+result.getString(2)+"==>"+result.getString(3));
		}
		//close db
		dLib.closeDb();
	}
}
