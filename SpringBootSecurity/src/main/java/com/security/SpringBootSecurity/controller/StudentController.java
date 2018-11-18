package com.security.SpringBootSecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.security.SpringBootSecurity.entity.Student;
import com.security.SpringBootSecurity.service.IStudentService;


@CrossOrigin
@RestController
@RequestMapping("/api/student")
public class StudentController {
	
	@Autowired
	private IStudentService studentService;
	@GetMapping("student/{id}")
	public ResponseEntity<Student> getstudentById(@PathVariable("id") String id) {
		Student student = studentService.getStudentById(id);
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
	
	@GetMapping("students")
	public ResponseEntity<List<Student>> getAllStudents() {
		
		System.out.println("Insideeeee");
		List<Student> list = studentService.getAllStudents();
		return new ResponseEntity<List<Student>>(list, HttpStatus.OK);
	}
	
	@PostMapping("student")
	public ResponseEntity<Void> addStudent(@RequestBody Student student, UriComponentsBuilder builder) {
                boolean flag = studentService.addStudent(student);
                if (flag == false) {
        	    return new ResponseEntity<Void>(HttpStatus.CONFLICT);
                }
                HttpHeaders headers = new HttpHeaders();
                headers.setLocation(builder.path("/student/{id}").buildAndExpand(student.getRollNumber()).toUri());
                return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("student")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
		
		studentService.updateStudent(student);
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
	
	@DeleteMapping("student/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable("id") String id) {
		studentService.deleteStudent(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	

}
