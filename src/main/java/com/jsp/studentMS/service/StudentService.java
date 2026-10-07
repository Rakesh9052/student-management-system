package com.jsp.studentMS.service;






import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.studentMS.dao.StudentDao;
import com.jsp.studentMS.entity.Student;
import com.jsp.studentMS.exception.StudentIdNotFoundException;
import com.jsp.studentMS.exception.StudentNotFoundException;
import com.jsp.studentMS.utill.ResponseStructure;

import java.util.List;

@Service
public class StudentService {
	
	@Autowired
	private StudentDao dao;

	// Save Student
	public ResponseEntity<ResponseStructure<Student>> saveStudent(
			Student student) {

		ResponseStructure<Student> structure =
				new ResponseStructure<>();

		structure.setData(dao.saveStudent(student));
		structure.setMessage("Student saved successfully");
		structure.setStatus(HttpStatus.CREATED.value());

		return new ResponseEntity<ResponseStructure<Student>>(
				structure,
				HttpStatus.CREATED
		);
	}

	// Fetch Student By ID
	public ResponseEntity<ResponseStructure<Student>> fetchById(
			int id) {

		Student db = dao.fetchById(id);

		if (db != null) {

			ResponseStructure<Student> structure =
					new ResponseStructure<>();

			structure.setData(db);
			structure.setMessage(
					"Student found successfully"
			);
			structure.setStatus(HttpStatus.OK.value());

			return new ResponseEntity<ResponseStructure<Student>>(
					structure,
					HttpStatus.OK
			);
		}

		throw new StudentIdNotFoundException(
				"Student ID " + id + " not found"
		);
	}

	// Fetch All Students
	public ResponseEntity<ResponseStructure<List<Student>>> fetchAll() {

		List<Student> db = dao.fetchAll();

		if (db != null && !db.isEmpty()) {

			ResponseStructure<List<Student>> structure =
					new ResponseStructure<>();

			structure.setData(db);
			structure.setMessage(
					"Students found successfully"
			);
			structure.setStatus(HttpStatus.OK.value());

			return new ResponseEntity<
					ResponseStructure<List<Student>>>(
							structure,
							HttpStatus.OK
					);
		}

		throw new StudentNotFoundException(
				"No students found"
		);
	}

	// Update Student
	public ResponseEntity<ResponseStructure<Student>> updateStudent(
			Student student) {

		Student db = dao.fetchById(student.getId());

		if (db != null) {

			ResponseStructure<Student> structure =
					new ResponseStructure<>();

			structure.setData(
					dao.updateStudent(student)
			);

			structure.setMessage(
					"Student updated successfully"
			);

			structure.setStatus(HttpStatus.OK.value());

			return new ResponseEntity<ResponseStructure<Student>>(
					structure,
					HttpStatus.OK
			);
		}

		throw new StudentIdNotFoundException(
				"Student ID " + student.getId() + " not found"
		);
	}

	// Delete Student
	public ResponseEntity<ResponseStructure<Student>> deleteById(
			int id) {

		Student db = dao.fetchById(id);

		if (db != null) {

			ResponseStructure<Student> structure =
					new ResponseStructure<>();

			structure.setData(
					dao.deleteById(id)
			);

			structure.setMessage(
					"Student deleted successfully"
			);

			structure.setStatus(HttpStatus.OK.value());

			return new ResponseEntity<ResponseStructure<Student>>(
					structure,
					HttpStatus.OK
			);
		}

		throw new StudentIdNotFoundException(
				"Student ID " + id + " not found"
		);
	}
}
