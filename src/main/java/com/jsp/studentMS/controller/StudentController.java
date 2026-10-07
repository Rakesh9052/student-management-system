package com.jsp.studentMS.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.studentMS.entity.Student;
import com.jsp.studentMS.service.StudentService;
import com.jsp.studentMS.utill.ResponseStructure;





@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService service;

	// Save Student
	@PostMapping
	public ResponseEntity<ResponseStructure<Student>> saveStudent(
			@RequestBody Student student) {

		return service.saveStudent(student);
	}

	// Fetch Student By ID
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Student>> fetchById(
			@PathVariable int id) {

		return service.fetchById(id);
	}

	// Fetch All Students
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Student>>> fetchAll() {

		return service.fetchAll();
	}

	// Update Student
	@PutMapping
	public ResponseEntity<ResponseStructure<Student>> updateStudent(
			@RequestBody Student student) {

		return service.updateStudent(student);
	}

	// Delete Student
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Student>> deleteById(
			@PathVariable int id) {

		return service.deleteById(id);
	}

}
