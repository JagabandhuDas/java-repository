package com.security.SpringBootSecurity.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student implements Serializable { 
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="rollNo")
    private String rollNumber;  
	
	@Column(name="Name")
    private String name;
	
	@Column(name="Age")	
	private int age;
	
	@Column(name="Branch")	
	private String branch;
	
	@Column(name="Session")	
	private String session;
	
	@Column(name="Address")	
	private String address;
	
	
	public String getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getSession() {
		return session;
	}
	public void setSession(String session) {
		this.session = session;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}  

