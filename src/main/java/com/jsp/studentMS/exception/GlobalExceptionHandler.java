package com.jsp.studentMS.exception;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.studentMS.utill.ResponseStructure;



@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(StudentIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> studentIdNotFound(
			StudentIdNotFoundException exception) {

		ResponseStructure<String> structure =
				new ResponseStructure<>();

		structure.setData(null);
		structure.setMessage(exception.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());

		return new ResponseEntity<ResponseStructure<String>>(
				structure,
				HttpStatus.NOT_FOUND
		);
	}

	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> studentNotFound(
			StudentNotFoundException exception) {

		ResponseStructure<String> structure =
				new ResponseStructure<>();

		structure.setData(null);
		structure.setMessage(exception.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());

		return new ResponseEntity<ResponseStructure<String>>(
				structure,
				HttpStatus.NOT_FOUND
		);
	}

}
