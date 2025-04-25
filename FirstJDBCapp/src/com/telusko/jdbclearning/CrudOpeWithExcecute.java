package com.telusko.jdbclearning;
import java.sql.*;

import com.mysql.cj.protocol.Resultset;
public class CrudOpeWithExcecute {

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
	    String sql="UPDATE studentinfo set sAge=20 where sAge=22";
	    Boolean status=statement.execute(sql);
	    
	    //process the result
		   
	   if(status)
	   {
		   System.out.println("if Status is true then Query is Select query");
		   ResultSet rs=statement.getResultSet();
		   while(rs.next()) {
			   System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4));
		   }
	   }
	   else {
		   System.out.println("If status is not true then Query is not select query");
		   if(statement.getUpdateCount()==0)
		   {
			   System.out.println("Operation failed");
		   }
		   else
		   {System.out.println("Operation successful");}
	   }
	    //close the resources
	   
	    statement.close();
	    connect.close();
	}
}
