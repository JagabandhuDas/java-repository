package com.security.SpringBootSecurity.model;


import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="userId")
	private int  id;
	@Column(name="Name")
	private String name;
	@Column(name="Email")
	private String email;
	@Column(name="Password")
	private String password;
	@Column(name="Active")
	private int  active;
	@OneToMany(cascade = CascadeType.ALL, fetch= FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "userId"),
	inverseJoinColumns = @JoinColumn(name = "roleId"))
	private Set<Role> roles;
	
	
	public User() {
		
	}

	public User(User user) {
		// TODO Auto-generated constructor stub
		this.id = user.getId();
		this.name = user.getName();
		this.email = user.getEmail();
		this.active = user.getActive();
		this.password = user.getPassword();
		this.roles = user.getRoles();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	

}
