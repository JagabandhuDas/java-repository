package com.security.SpringBootSecurity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.SpringBootSecurity.model.User;

@Repository
public interface UsersRepository extends JpaRepository<User, Integer>{

	Optional<User> findByName(String username);
	
	
	
}
