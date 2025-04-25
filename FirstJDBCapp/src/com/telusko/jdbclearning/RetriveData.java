package com.telusko.jdbclearning;
import java.sql.*;

import com.mysql.cj.protocol.Resultset;
public class RetriveData {

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
	    String sql="Select * from studentinfo where sAge>20";
	    ResultSet rs=statement.executeQuery(sql);
	    
	    //process the result
		   
	    while(rs.next())
	    {
	    	System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4));
	    }
	   
	 
	    
	    //close the resources
	    rs.close();
	    statement.close();
	    connect.close();
	}
}
