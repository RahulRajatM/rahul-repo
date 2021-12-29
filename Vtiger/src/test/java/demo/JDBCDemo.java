package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;


public class JDBCDemo {

	public static void main(String[] args) throws SQLException {

		// load/register Mysql  DB
		Driver driver= new Driver();
		DriverManager.registerDriver(driver);
		//get connection with db
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "root");
		//create sql statement
		Statement state = con.createStatement();
		//execute sql statement
		ResultSet result = state.executeQuery("select* from cust;");
		//display result
		while(result.next())
		{
			System.out.println(result.getString(1)+"==>"+result.getString(2)+"==>"+result.getString(3));
		}
		//close connecttion
		con.close();
	}
}
