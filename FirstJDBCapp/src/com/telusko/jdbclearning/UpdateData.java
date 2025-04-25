package com.telusko.jdbclearning;
import java.sql.*;
public class UpdateData {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println("SQl");
		
		
	    //Load and register the Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//Establish the Connection
		String url="jdbc:mysql://localhost:3306/jdbclearning";
		String user="root";
		String password="@1Prasada";
		Connection connect=DriverManager.getConnection(url, user, password);
		
		//Creating the statement
	    Statement statement=connect.createStatement();
	   
	    //execute query
	    String sql="UPDATE studentinfo set sAge=23 where id=12";
	    statement.executeUpdate(sql);
	    int rowsEffected= statement.executeUpdate(sql);
	    if(rowsEffected==0)
	    {
	    	System.out.println("Unable to update the data");
	    }
	    else {
	    	System.out.println("Update Successful");
	    }
	    
	    //process the result
	   
	    
	    //close the resources
	    statement.close();
	    connect.close();
	}
}
