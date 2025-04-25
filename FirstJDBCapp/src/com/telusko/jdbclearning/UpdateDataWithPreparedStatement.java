package com.telusko.jdbclearning;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class UpdateDataWithPreparedStatement {

	public static void main(String[] args)  {
		System.out.println("SQl");
		Connection connect=null;
		//Statement statement=null;
		java.sql.PreparedStatement prest=null;
		try {
			connect=JDBCUtil.getConnection();
			String sql="update studentinfo set sAge=? where id=? ";
			prest=connect.prepareStatement(sql);
			
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the age you want to update");
			int newage=sc.nextInt();
			System.out.println("Enter the age where you want to be update");
			int id=sc.nextInt();
			prest.setInt(1, newage);
			prest.setInt(2, id);
			
			int rowsUpdated=prest.executeUpdate();
			if(rowsUpdated==0)
			{
				System.out.println("Unable to update the data");
			}
			else
			{
				System.out.println("Update successful");
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
