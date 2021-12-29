package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ReadDataJDBC 
{
	public static void main(String[] args) throws Exception {
		//step1-register driver
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		//step2-establish connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb","root","root");
		//step3-create sql statement
		Statement state = con.createStatement();
		//step4-execute sql query
		ResultSet result = state.executeQuery("select* from cust;");
		while(result.next())
		{
			System.out.println(result.getString(2)+"===> "+result.getString(3));
		}
		con.close();
	}
}
