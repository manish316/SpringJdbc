package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.spring.jdbc.entities.Student;
import com.spring.jdbc.rowmapper.RowMapper;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int insertStudent(Student student) {
		String query = "insert into student(id, name, city) values (?,?,?)";
		int result = jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());

		return result;
	}

	@Override
	public int updateStudent(Student student) {
		String query = "update student set name=? , city=? where id = ?";
		int result = jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
		return result;
	}

	@Override
	public int deleteStudent(int id) {
		String query = "delete from student where id=?";
		int result = jdbcTemplate.update(query, id);
		return result;
	}

	@Override
	public Student getStudentByid(int id) {

		String query = "select * from student where id=?";
		RowMapper rowMapper = new RowMapper();
		Student student = jdbcTemplate.queryForObject(query, rowMapper, id);

		return student;
	}
	@Override
	public List<Student> getAllStudent() {
		String query ="select * from student";
		RowMapper rowMapper = new RowMapper();
		List<Student> studentList = jdbcTemplate.query(query, rowMapper);
		return studentList;
	}
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}



}
