package com.security.SpringBootSecurity.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.SpringBootSecurity.dao.IStudentDao;
import com.security.SpringBootSecurity.entity.Student;
import com.security.SpringBootSecurity.service.IStudentService;


@Service
public class StudentServiceImpl implements IStudentService{
	
	@Autowired
	private IStudentDao studentDAO;

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentDAO.getAllStudents();
	}

	@Override
	public Student getStudentById(String rollNumber) {
		// TODO Auto-generated method stub
		Student obj = studentDAO.getStudentById(rollNumber);
		return obj;
	}

	@Override
	public synchronized boolean addStudent(Student student) {
		// TODO Auto-generated method stub
		if (studentDAO.studentExists(student.getName(), student.getBranch())) {
            return false;
        } else {
        	studentDAO.addStudent(student);
            return true;
        }
	}

	@Override
	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		studentDAO.updateStudent(student);
	}

	@Override
	public void deleteStudent(String rollNumber) {
		// TODO Auto-generated method stub
		studentDAO.deleteStudent(rollNumber);
	}
	

}
