package com.security.SpringBootSecurity.resource;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/hello")
public class HelloResource {
	@GetMapping("/all")
	public String hello() {
		System.out.println("hjkhhhkjjhkjjhkjh");
		return "hello test";
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("/secured/all")
	public String securedHello() {
		System.out.println("inside secured service");
		return "hello test  inside secured service";
	}
}
