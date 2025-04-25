package com.telusko.jdbclearning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {

	static {
	    //Load and register the Driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
	
		public static Connection getConnection() throws SQLException {
			//Establish the Connection
			String url="jdbc:mysql://localhost:3306/jdbclearning";
			String user="root";
			String password="@1Prasada";
			 Connection connect=DriverManager.getConnection(url, user, password);
			 return connect;
		}
		public static void closeConnection(Connection connect, Statement statement) throws SQLException {
			statement.close();
		    connect.close();
		}
	}

