package com.security.SpringBootSecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.security.SpringBootSecurity.entity.Employee;
import com.security.SpringBootSecurity.service.IEmployeeService;
import com.security.SpringBootSecurity.vo.EmployeeVo;


@CrossOrigin
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	
	@Autowired
	private IEmployeeService employeeService;
	
	@GetMapping("employee/{id}")
	public ResponseEntity<Employee> getEmployeeByEmpId(@PathVariable("id") String empId) {
		Employee employee = employeeService.getEmployeeByEmpId(empId);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
	
	@GetMapping("employees")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		
		System.out.println("Insideeeee");
		List<Employee> list = employeeService.getAllEmployees();
		return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
	}
	
	@PostMapping("employee/add")
	public ResponseEntity<Void> addEmployee(@RequestBody final EmployeeVo employeeVo) {
				System.out.println(""+employeeVo.toString());
                boolean flag = employeeService.addEmployee(employeeVo.convertToEmployeDto());
                /*if (flag == false) {
        	    return new ResponseEntity<Void>(HttpStatus.CONFLICT);
                }*/
                HttpHeaders headers = new HttpHeaders();
                //headers.setLocation(builder.path("/employee/{id}").buildAndExpand(employeeVo.getEmpId()).toUri());
                return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("employee/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		
		employeeService.updateEmployee(employee);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
	
	@DeleteMapping("employee/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable("id") String empId) {
		employeeService.deleteEmployee(empId);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
}
