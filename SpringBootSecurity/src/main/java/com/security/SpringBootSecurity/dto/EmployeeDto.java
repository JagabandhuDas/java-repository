package com.security.SpringBootSecurity.dto;


import com.security.SpringBootSecurity.entity.Employee;

public class EmployeeDto {
	
    private String empId;  
	
    private String name;
	
	private String gender;
	
	private Integer annualSalary;
	
	private String dateOfBirth;
	
	public EmployeeDto(){}
	
	public EmployeeDto( String empId,
				 String name,
				String gender,
				Integer annualSalary,
				String dateOfBirth){
		this.empId = empId;
		this.name = name;
		this.gender = gender;
		this.annualSalary = annualSalary;
		this.dateOfBirth = dateOfBirth;
		
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAnnualSalary() {
		return annualSalary;
	}

	public void setAnnualSalary(Integer annualSalary) {
		this.annualSalary = annualSalary;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public Employee toEmployeeEntity() {
		
		return new Employee(this.empId,this.name,this.gender,this.annualSalary,this.dateOfBirth);
	}
	
	
}
