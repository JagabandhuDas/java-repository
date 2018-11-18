package com.security.SpringBootSecurity.dao;

import java.util.*;

import com.security.SpringBootSecurity.entity.Student;

public interface IStudentDao {
	
	List<Student> getAllStudents();
	Student getStudentById(String rollNo);
	void addStudent(Student student);
	void updateStudent(Student student);
	void deleteStudent(String rollNo);
	boolean studentExists(String name, String branch);
	 
}
