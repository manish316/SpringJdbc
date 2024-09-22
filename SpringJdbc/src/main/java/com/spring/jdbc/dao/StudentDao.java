package com.spring.jdbc.dao;

import java.util.List;

import com.spring.jdbc.entities.Student;

public interface StudentDao {
	public int insertStudent(Student student);
	public int updateStudent(Student student);
	public int deleteStudent(int id);
	public Student getStudentByid(int id);
	public List<Student> getAllStudent();
}
