package com.security.SpringBootSecurity.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.SpringBootSecurity.model.CustomUserDetails;
import com.security.SpringBootSecurity.model.User;
import com.security.SpringBootSecurity.repository.UsersRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	UsersRepository usersRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("inside CustomeUserDetailsService class");
		Optional<User> optionalUser = usersRepository.findByName(username);
		
		optionalUser.orElseThrow(()-> new UsernameNotFoundException("User not found"));

		return optionalUser.map(CustomUserDetails::new).get();
		
		// new CustomUserDetailsService(users.);
	}

}
