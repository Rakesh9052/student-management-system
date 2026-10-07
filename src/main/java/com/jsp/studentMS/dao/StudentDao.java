package com.jsp.studentMS.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.studentMS.entity.Student;
import com.jsp.studentMS.repository.StudentRepository;



@Repository
public class StudentDao {
	
	@Autowired
	private StudentRepository repository;

	// Save Student
	public Student saveStudent(Student student) {

		return repository.save(student);
	}

	// Fetch Student By ID
	public Student fetchById(int id) {

		return repository.findById(id).orElse(null);
	}

	// Fetch All Students
	public List<Student> fetchAll() {

		return repository.findAll();
	}

	// Update Student
	public Student updateStudent(Student student) {

		return repository.save(student);
	}

	// Delete Student
	public Student deleteById(int id) {

		Student student = repository.findById(id).orElse(null);

		if (student != null) {

			repository.deleteById(id);
		}

		return student;
	}

}
