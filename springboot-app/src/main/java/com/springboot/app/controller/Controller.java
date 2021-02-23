package com.springboot.app.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.springboot.app.service.AppService;

import Errors.ConnectionProblem;
import Errors.ErrorResponse;

@RestController
public class Controller {
 @Autowired 
 AppService service;
 @GetMapping("/getfilters")
 public ResponseEntity<HashMap> getfilters(){
	return new ResponseEntity<HashMap>(service.GetPossibleFilters(),HttpStatus.OK);
 }
 @GetMapping("/getdatabase")
 public ResponseEntity<Object> getdatabase(){
	 return new ResponseEntity<Object>(service.GetDatabase(),HttpStatus.OK);
 }
 @ExceptionHandler(ConnectionProblem.class)
 public final ResponseEntity<ErrorResponse> exceptionConnection(Exception e){
	 ErrorResponse er = new ErrorResponse();
	 return new ResponseEntity<ErrorResponse>(er,HttpStatus.GATEWAY_TIMEOUT);
 }
 
}
