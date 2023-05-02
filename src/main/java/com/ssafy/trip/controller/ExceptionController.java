package com.ssafy.trip.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class ExceptionController {

	//모든 예외를 처리할 메소드
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> exceptionHandler(Exception e) {
		e.printStackTrace();
	
		//return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//		return ResponseEntity.internalServerError().body(e.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
//		return ResponseEntity.status(500).body(e.getMessage());
	}
	
	//404 (NoHandlerFoundException)
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<?> noHandlerFoundExceptionHandler(Exception e) {
		e.printStackTrace();
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}
}
