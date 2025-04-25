package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.model.Student;
import com.example.repository.iStudentDao;

@SpringBootApplication
public class DataJdBcspringApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext container =SpringApplication.run(DataJdBcspringApplication.class, args);
		iStudentDao dao=container.getBean(iStudentDao.class);
		dao.AddStudent(new Student(5,"nagu",45,"Marellaguntapalem"));
	}

}
