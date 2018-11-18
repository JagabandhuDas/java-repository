package com.security.SpringBootSecurity.dao;

import java.util.List;

import com.security.SpringBootSecurity.entity.Employee;


public interface IEmployeeDao {
	List<Employee> getAllEmployees();
	Employee getEmployeeByEmpId(String empId);
	void addEmployee(Employee employee);
	void updateEmployee(Employee employee);
	void deleteEmployee(String empId);
	boolean employeeExists(String name, String gender);
}
