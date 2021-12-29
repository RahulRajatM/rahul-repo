package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class UpdateDataJDBC 
{
	public static void main(String[] args) throws SQLException {
		//step1=register driver
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		//step2=establish connection with database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "root");
		//create sql statement
		Statement state = con.createStatement();
		//execute sql query
		//int result = state.executeUpdate("insert into cust(id,name,place)values(108,'ravi','delhi');");
		//	int result = state.executeUpdate("update cust set name='rita' where id=102;");
		int result=state.executeUpdate("update cust set mobno=9123407387 where id=102;");
		if(result==1)
		{
			System.out.println("data updated successfully..so pass");
		}
		else
		{
			System.out.println("Error");
		}
		con.close();
	}
}
