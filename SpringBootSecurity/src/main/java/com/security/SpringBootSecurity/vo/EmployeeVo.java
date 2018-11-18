package com.security.SpringBootSecurity.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.security.SpringBootSecurity.dto.EmployeeDto;

public class EmployeeVo {
	
    private String empId;  
	
    private String name;
	
	private String gender;
	
	private Integer annualSalary;
	

	private String dateOfBirth;
	
	EmployeeVo(){}
	
	EmployeeVo(@JsonProperty(value = "empId", required=true) String empId,
				@JsonProperty(value = "name",required=true) String name,
				@JsonProperty(value = "gender",required=true) String gender,
				@JsonProperty(value = "annualSalary",required=true) Integer annualSalary,
				@JsonProperty(value = "dateOfBirth",required=true) String dateOfBirth){
		this.empId = empId;
		this.name = name;
		this.gender = gender;
		this.annualSalary = annualSalary;
		this.dateOfBirth = dateOfBirth;
		
	}
	@JsonProperty(value = "empId", required=true)
	public String getEmpId() {
		return empId;
	}
	
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	@JsonProperty(value = "name",required=true)
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	@JsonProperty(value = "gender",required=true)
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	@JsonProperty(value = "annualSalary",required=true)
	public Integer getAnnualSalary() {
		return annualSalary;
	}

	public void setAnnualSalary(Integer annualSalary) {
		this.annualSalary = annualSalary;
	}
	@JsonProperty(value = "dateOfBirth",required=true)
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public EmployeeDto convertToEmployeDto() {
		
		return new EmployeeDto(this.empId,
				       			this.name,this.gender,this.annualSalary,
				       			this.dateOfBirth);
	}
	
}
