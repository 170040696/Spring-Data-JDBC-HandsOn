package com.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.model.Student;

@Repository
public class StudentDaoImpl implements iStudentDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private String sql="insert into studentinfo (id,sName,sAge,sCity)values(?,?,?,?)";
	
	@Override
	public void AddStudent(Student s) {
		// TODO Auto-generated method stub
		System.out.println("Inserting student: " + s.getId() + ", " + s.getName()+", "+s.getAge()+", "+s.getCity());
		int row=jdbcTemplate.update(sql, s.getId(),s.getName(),s.getAge(),s.getCity());
		System.out.println("number of rows affercted :"+ row);
		System.out.println("Insertion Successful");  
	}

}

