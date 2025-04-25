package com.telusko.jdbclearning;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class BatchUpdate {

	public static void main(String[] args)  {
		System.out.println("SQl");
		Connection connect=null;
		//Statement statement=null;
		java.sql.PreparedStatement prest=null;
		try {
			connect=JDBCUtil.getConnection();
			String sql="update studentinfo set sAge=? where id=?";
			prest=connect.prepareStatement(sql);
			
			//Scanner sc=new Scanner(System.in);
			
			//System.out.println("Enter the age and id that you wanted to update the age");
//			int age=sc.nextInt();
//		    int id=sc.nextInt();
			prest.setInt(1, 20);
			prest.setInt(2,2);
			prest.addBatch();
			
			prest.setInt(1, 22);
			prest.setInt(2,3);
			prest.addBatch();
			
			prest.setInt(1, 23);
			prest.setInt(2,4);
			prest.addBatch();
			
			//this batch update we can only for the non select queries(update,insert,delete)
			prest.executeBatch();
			
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
