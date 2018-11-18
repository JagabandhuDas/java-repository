package com.security.SpringBootSecurity.service;

import java.util.List;

import com.security.SpringBootSecurity.entity.Student;

public interface IStudentService {
	
    List<Student> getAllStudents();
    Student getStudentById(String rollNumber);
    boolean addStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(String rollNumber);
}