package com.telusko.jdbclearning;
import java.sql.*;

import com.mysql.cj.protocol.Resultset;
public class DeleteData {

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
	    String sql="delete from studentinfo where sAge=25";
	    int rowsEffected=statement.executeUpdate(sql);
	    
	    //process the result
		   
	   if(rowsEffected==0)
	   {
		   System.out.println("Unable to delete the records");
	   }
	   else {
		   System.out.println("Deleted successfully");
	   }
	    //close the resources
	   
	    statement.close();
	    connect.close();
	}
}
