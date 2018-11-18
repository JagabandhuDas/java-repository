package com.security.SpringBootSecurity.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.SpringBootSecurity.dao.IEmployeeDao;
import com.security.SpringBootSecurity.dto.EmployeeDto;
import com.security.SpringBootSecurity.entity.Employee;
import com.security.SpringBootSecurity.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService{
	
	@Autowired
	private IEmployeeDao employeeDAO;
	
	//Check dependencies in constructor 
	/*public EmployeeServiceImpl(IEmployeeDao employeeDAO) {
		  if (employeeDAO == null) {
		    throw new IllegalArgumentException("IEmployeeDao cannot be null");
		  }
		  this.employeeDAO = employeeDAO;
	}*/

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeDAO.getAllEmployees();
	}

	@Override
	public Employee getEmployeeByEmpId(String empId) {
		// TODO Auto-generated method stub
		Employee obj = employeeDAO.getEmployeeByEmpId(empId);
		return obj;
	}

	@Override
	public synchronized boolean addEmployee(EmployeeDto employee) {
		// TODO Auto-generated method stub
		if (employeeDAO.employeeExists(employee.getName(), employee.getGender())) {
            return false;
        } else {  
        	System.out.println(""+employee.toString());
        	//employeeDAO.addEmployee(employee.toEmployeeEntity());
            return true;
        }
	}

	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeDAO.updateEmployee(employee);
	}

	@Override
	public void deleteEmployee(String empId) {
		// TODO Auto-generated method stub
		employeeDAO.deleteEmployee(empId);
	}
	

}

