package com.telusko.jdbclearning;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class RetriveDataWithPreparedStatement {

	public static void main(String[] args)  {
		System.out.println("SQl");
		Connection connect=null;
		//Statement statement=null;
		java.sql.PreparedStatement prest=null;
		try {
			connect=JDBCUtil.getConnection();
			String sql="select * from studentinfo where sAge>?";
			prest=connect.prepareStatement(sql);
			
			Scanner sc=new Scanner(System.in);
			
			System.out.println("Enter the age to get all the students who are above the mentioned age");
			int age=sc.nextInt();
		
			prest.setInt(1, age);
			
			ResultSet rs=prest.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4));
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
