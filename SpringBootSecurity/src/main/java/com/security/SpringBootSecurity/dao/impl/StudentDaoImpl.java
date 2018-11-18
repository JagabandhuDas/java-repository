package com.security.SpringBootSecurity.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.security.SpringBootSecurity.dao.IStudentDao;
import com.security.SpringBootSecurity.entity.Student;

@Transactional
@Repository
public class StudentDaoImpl   implements IStudentDao{

	@PersistenceContext	
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		String hql = "FROM Student";
		return (List<Student>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Student getStudentById(String rollNo) {
		// TODO Auto-generated method stub
		return entityManager.find(Student.class, rollNo);
	}

	@Override
	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		entityManager.persist(student);
		
	}

	@Override
	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		Student stdnt = getStudentById(student.getRollNumber());
		stdnt.setAge(student.getAge());
		stdnt.setAddress(student.getAddress());
		entityManager.flush();
		
	}

	@Override
	public void deleteStudent(String rollNo) {
		// TODO Auto-generated method stub
		entityManager.remove(getStudentById(rollNo));
		
	}

	@Override
	public boolean studentExists(String name, String branch) {
		// TODO Auto-generated method stub
		String hql = "FROM Student as studnt WHERE studnt.name = ? and studnt.branch = ?";
		int count = entityManager.createQuery(hql).setParameter(1, name)
		              .setParameter(2, branch).getResultList().size();
		return count > 0 ? true : false;
	}
	
	

}
