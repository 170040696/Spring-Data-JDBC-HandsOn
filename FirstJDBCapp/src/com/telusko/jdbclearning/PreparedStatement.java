package com.telusko.jdbclearning;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class PreparedStatement {

	public static void main(String[] args)  {
		System.out.println("SQl");
		Connection connect=null;
		//Statement statement=null;
		java.sql.PreparedStatement prest=null;
		try {
			//Load and register the Driver
			
		//Establish the Connection
			connect=JDBCUtil.getConnection();
		
		//Creating the statement
	   // statement=connect.createStatement();
			String sql="insert into studentinfo (id,sName,sAge,sCity)values(?,?,?,?)";
			prest=connect.prepareStatement(sql);
			Scanner sc=new Scanner(System.in);
			System.out.println("enter your id");
			Integer id=sc.nextInt();
			System.out.println("enter your name");
			String name=sc.next();
			System.out.println("enter your age");
			int age=sc.nextInt();
			System.out.println("enter city");
			String city=sc.next();
			
	    //execute query
	  prest.setInt(1,id);
	  prest.setString(2, name);
	  prest.setInt(3, age);
	  prest.setString(4, city);
	    int rowsEffected=prest.executeUpdate();
	    
	    //process the result
		   
	   if(rowsEffected==0)
	   {
		   System.out.println("Unable to insert data");
		   
	   }
	   else {
		   System.out.println("Data inserted successfully");
		   
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
		    JDBCUtil.closeConnection(connect, prest);
			   }
			   catch(SQLException e) {
				   e.printStackTrace();
			   }
		}
		
		
	}
}
