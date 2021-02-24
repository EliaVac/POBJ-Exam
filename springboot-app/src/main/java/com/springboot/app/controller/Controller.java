package com.springboot.app.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.app.service.AppService;
import Errors.ConnectionProblem;
import Errors.ErrorResponse;
import Errors.JSONProblem;
import Errors.ResourceNotFoundException;

@RestController
public class Controller {
 @Autowired 
 private AppService service;
 @GetMapping("/getfilters")
 public ResponseEntity<HashMap> getfilters(){
	return new ResponseEntity<HashMap>(service.GetPossibleFilters(),HttpStatus.OK);
 }
 @GetMapping("/getdatabase")
 public ResponseEntity<Object> getdatabase() throws ConnectionProblem{
	 return new ResponseEntity<Object>(service.GetDatabase(),HttpStatus.OK);
 }
 @ExceptionHandler(ResourceNotFoundException.class)
 @ResponseStatus(HttpStatus.NOT_FOUND)
 public final ResponseEntity<ErrorResponse> NotFound(Exception e){
	 ErrorResponse er = new ErrorResponse(404,"NOTNOTNOT");
	 return new ResponseEntity<ErrorResponse>(er,HttpStatus.NOT_FOUND);
 }
 @ExceptionHandler(ConnectionProblem.class)
 public final ResponseEntity<ErrorResponse> exceptionConnection(Exception e){
	 ErrorResponse er = new ErrorResponse(409,e.getMessage());
	 return new ResponseEntity<ErrorResponse>(er,HttpStatus.GATEWAY_TIMEOUT);
 }
 @ExceptionHandler(JSONProblem.class)
 public final ResponseEntity<ErrorResponse> exceptionJSON(Exception e){
	 ErrorResponse er = new ErrorResponse(409,e.getMessage());
	 return new ResponseEntity<ErrorResponse>(er,HttpStatus.CONFLICT);
 }
 
}
