package com.security.SpringBootSecurity.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.security.SpringBootSecurity.dao.IEmployeeDao;
import com.security.SpringBootSecurity.entity.Employee;;


@Transactional
@Repository
public class EmployeeDaoImpl implements IEmployeeDao{
	
	@PersistenceContext	
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		String hql = "FROM Employee";
		return (List<Employee>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Employee getEmployeeByEmpId(String empId) {
		// TODO Auto-generated method stub
		return entityManager.find(Employee.class, empId);
	}

	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		entityManager.persist(employee);
		
	}

	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Employee stdnt = getEmployeeByEmpId(employee.getEmpId());
		stdnt.setAnnualSalary(employee.getAnnualSalary());
		stdnt.setDateOfBirth(employee.getDateOfBirth());
		entityManager.flush();
		
	}

	@Override
	public void deleteEmployee(String empId) {
		// TODO Auto-generated method stub
		entityManager.remove(getEmployeeByEmpId(empId));
		
	}

	@Override
	public boolean employeeExists(String name, String gender) {
		// TODO Auto-generated method stub
		String hql = "FROM Employee as emp WHERE emp.name = ? and emp.gender = ?";
		int count = entityManager.createQuery(hql).setParameter(1, name)
		              .setParameter(2, gender).getResultList().size();
		return count > 0 ? true : false;
	}
}
