package com.example.demo.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandling {

	//@ResponseStatus(HttpStatus.CREATED) //
	@ResponseStatus(HttpStatus.BAD_REQUEST) 
	@ExceptionHandler(MethodArgumentNotValidException.class)
	ProblemDetail handleValidation(MethodArgumentNotValidException exception) {
		ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
		
		List<FieldError> fieldErrors = exception.getFieldErrors();
		List<String> errors = new ArrayList<>();
		
		
		for(FieldError fe : fieldErrors) {
			errors.add(fe.getDefaultMessage());
		}
		
		problemDetail.setProperty("errors", errors);		
		return problemDetail;
	}
	
}
