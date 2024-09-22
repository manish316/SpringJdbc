package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Program Started");
//		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
		ApplicationContext context = new AnnotationConfigApplicationContext(jdbcConfig.class);


		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
		Student student = new Student();
		student.setId(5);
		student.setName("Anjali Singh");
		student.setCity("Jail Road");
		int insertStudent = studentDao.insertStudent(student);
//		int updatedStudent = studentDao.updateStudent(student);
//		int deletedStudent = studentDao.deleteStudent(4);
//		Student studentByid = studentDao.getStudentByid(2);
//		List<Student> allStudent = studentDao.getAllStudent();

//		for(Student s: allStudent)
		System.out.println(insertStudent);
		
   
	}
}
