package com.telusko.jdbclearning;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class DeleteDataWithPreparedStatement {

	public static void main(String[] args)  {
		System.out.println("SQl");
		Connection connect=null;
		//Statement statement=null;
		java.sql.PreparedStatement prest=null;
		try {
			connect=JDBCUtil.getConnection();
			String sql="delete from studentinfo where id=?";
			prest=connect.prepareStatement(sql);
			
			Scanner sc=new Scanner(System.in);
			
			System.out.println("Enter the id where you want to be delete");
			int id=sc.nextInt();
			
			prest.setInt(1, id);
			
			int rowsUpdated=prest.executeUpdate();
			if(rowsUpdated==0)
			{
				System.out.println("Unable to delete the data");
			}
			else
			{
				System.out.println("delete successful");
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
