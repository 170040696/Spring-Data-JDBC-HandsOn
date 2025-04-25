package com.example;

import java.util.Iterator;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.model.Student;
import com.example.repository.iStudentDao;

@SpringBootApplication
public class JdbCspringApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext container=SpringApplication.run(JdbCspringApplication.class, args);
		iStudentDao dao=container.getBean(iStudentDao.class);
		/*
		 * List<Student>list=dao.getAllStudentsInfo(); Iterator<Student>
		 * itr=list.iterator(); while(itr.hasNext()) { System.out.println(itr.next()); }
		 */
		dao.getAllStudentsInfo().forEach(l->System.out.println(l));
	}

}
