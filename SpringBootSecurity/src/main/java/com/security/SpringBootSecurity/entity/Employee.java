package com.security.SpringBootSecurity.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="employeeId")
    private String empId;  
	
	@Column(name="name")
    private String name;
	
	@Column(name="gender")	
	private String gender;
	
	@Column(name="annualSalary")	
	private Integer annualSalary;
	
	@Column(name="dob")	
	private String dateOfBirth;

	public  Employee() {}
	
	public  Employee(String empId,  String name,String gender, 
			Integer annualSalary,String dateOfBirth) {
		this.empId=empId; 
		this.name=name;
		this.gender=gender;
		this.annualSalary=annualSalary;
		this.dateOfBirth=dateOfBirth;
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
	
	
	
}
