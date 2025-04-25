package com.example.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties.Connection;
import org.springframework.stereotype.Repository;

import com.example.model.Student;

@Repository
public class StudentDaoImpl implements iStudentDao {

	@Autowired
	private DataSource datasource;
	private String sql="select * from studentinfo";
	private ArrayList<Student> studentlist=new ArrayList<>();
	
	public StudentDaoImpl() {
		System.out.println("StudentDaoimpl bean created");
	}

	@Override
	public List<Student> getAllStudentsInfo() {
		// TODO Auto-generated method stub
		
		try {
			//loading driver
			
			//getting the connection --> use Hikari Connection pooling mechanism(in Springboot default CP is HikariCP)
			java.sql.Connection connect=datasource.getConnection();
			System.out.println("Connection from Hikari CP is : "+connect.getClass().getName());
			
			PreparedStatement ps=connect.prepareStatement(sql);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Student st=new Student();
				st.setId(rs.getInt(1));
				st.setName(rs.getString(2));
				st.setAge(rs.getInt(3));
				st.setCity(rs.getString(4));
				studentlist.add(st);
			}
			
		}
		catch(Exception e) {
			 e.printStackTrace();
		}
		return studentlist;
	}

}
