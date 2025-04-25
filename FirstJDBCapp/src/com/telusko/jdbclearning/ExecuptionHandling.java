package com.telusko.jdbclearning;
import java.sql.*;

import com.mysql.cj.protocol.Resultset;
public class ExecuptionHandling {

	public static void main(String[] args)  {
		System.out.println("SQl");
		Connection connect=null;
		Statement statement=null;
		try {
			//Load and register the Driver
			
		//Establish the Connection
			connect=JDBCUtil.getConnection();
		
		//Creating the statement
	    statement=connect.createStatement();
	   
	    //execute query
	    String sql="insert into studentinfo (id,sName, sAge,sCity) values(2,'rathnesh',22,'vijayawada')";
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
	   
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			 //close the resources
			   try {
		    JDBCUtil.closeConnection(connect, statement);
			   }
			   catch(SQLException e) {
				   e.printStackTrace();
			   }
		}
		
		
	}
}
