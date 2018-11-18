package com.security.SpringBootSecurity.service;

import java.util.List;

import com.security.SpringBootSecurity.dto.EmployeeDto;
import com.security.SpringBootSecurity.entity.Employee;

public interface IEmployeeService {
	
	List<Employee> getAllEmployees();
	Employee getEmployeeByEmpId(String empId);
    boolean addEmployee(EmployeeDto employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(String empId);
}
