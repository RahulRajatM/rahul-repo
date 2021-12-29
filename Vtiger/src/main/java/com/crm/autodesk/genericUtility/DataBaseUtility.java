package com.crm.autodesk.genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;
/**
 * generic class containing methods to perform database operatons
 * @author Rahul
 *
 */
public class DataBaseUtility {

	Statement state;
	Connection con;
	/**
	 * Establish database connection
	 * @param dbName
	 * @throws Exception
	 */
	public void connectToDb(String dbName) throws Exception
	{
		//load Mysql database or  register the driver
		Driver driver= new Driver();
		DriverManager.registerDriver(driver);

		// get connection to db
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbName+"", "root", "root");

		//create sql statement
		state = con.createStatement();
		System.out.println("DataBase Connected");
	}
	/**
	 * used to execute select query
	 * @param query
	 * @return result
	 * @throws Exception
	 */
	public ResultSet executeQuery(String query) throws Exception
	{
		ResultSet result = state.executeQuery(query);
		System.out.println("Query Executed");
		return result;
	}
	/**
	 * used to execute non select query
	 * @param query
	 * @return int
	 * @throws Exception
	 */
	public int updateQuery(String query) throws Exception
	{
		int result = state.executeUpdate(query);
		System.out.println("DataBase Updated");
		return result;																						
	}
	/**
	 * used to close current db connection
	 * @throws Exception
	 */
	public void closeDb() throws Exception
	{
		this.con.close();
		System.out.println("Db Closed");

	}

}
