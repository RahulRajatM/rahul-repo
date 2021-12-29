package practice;

import com.crm.autodesk.genericUtility.DataBaseUtility;

public class DeleteCustTableData {
	public static void main(String[] args) throws Exception {

		DataBaseUtility dLib= new DataBaseUtility();
		//connect to db
		dLib.connectToDb("employeedb");
		//update table
		dLib.updateQuery("delete from cust where name='Rama';");

		dLib.closeDb();
	}
}
