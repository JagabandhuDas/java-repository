package com.security.SpringBootSecurity.resource;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserResourceService {
	@GetMapping("/list")
	public String listUser() {
		System.out.println("hjkhhhkjjhkjjhkjh");
		return "hello test";
	}
	
	
	@GetMapping("/find")
	public String findUser() {
		
		return "hello test";
	}
}