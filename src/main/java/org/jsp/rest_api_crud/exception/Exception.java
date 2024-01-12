package org.jsp.rest_api_crud.exception;

import java.util.NoSuchElementException;

import org.jsp.rest_api_crud.helper.RepoStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Exception {

	@Autowired
	RepoStructure<String> structure;
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<RepoStructure<String>> handler(DataIntegrityViolationException exception){
		structure.setMes("Data can not be saved");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData("Mobile alredy exist");
		
		return new ResponseEntity<RepoStructure<String>>(structure,HttpStatus.CREATED);
	}
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<RepoStructure<String>> handler(NoSuchElementException exception){
		structure.setMes("no found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(exception.getMessage());
		
		return new ResponseEntity<RepoStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
}
