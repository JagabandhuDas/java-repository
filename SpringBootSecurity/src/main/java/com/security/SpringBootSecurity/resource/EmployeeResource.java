package com.security.SpringBootSecurity.resource;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employee")
public class EmployeeResource {
	@GetMapping("/list")
	public String listEmployees() {
		System.out.println("Employee list");
		return "hello employeeeee list";
	}
	
	
	@GetMapping("/find")
	public String findEmployee() {
		
		return "hello employee details";
	}
}
