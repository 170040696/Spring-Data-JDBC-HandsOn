package com.telusko.jdbclearning;
import java.sql.*;
public class InsertData {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println("SQl");
		Connection connect=null;
		Statement statement=null;
		
	    //Load and register the Driver
		/* Class.forName("com.mysql.cj.jdbc.Driver"); */
		
		//Establish the Connection
		/*
		 * String url="jdbc:mysql://localhost:3306/jdbclearning"; String user="root";
		 * String password="@1Prasada"; Connection
		 * connect=DriverManager.getConnection(url, user, password);
		 */
		connect=JDBCUtil.getConnection();
		//Creating the statement
	     statement=connect.createStatement();
	   
	    //execute query
	    String sql = "INSERT INTO studentinfo(id,sName,sAge,sCity) VALUES(3,'yamini', 25, 'Bangaluru')";
	    int rowsEffected= statement.executeUpdate(sql);
	    
	    //process the result
	    if(rowsEffected==0) {
	    	System.out.println("Unable to insert the data");
	    }
	    else {
	    	System.out.println("Data inserted successfully");
	    }
	    
	    //close the resources
//	    statement.close();
//	    connect.close();
	    JDBCUtil.closeConnection(connect, statement);
	}
}
