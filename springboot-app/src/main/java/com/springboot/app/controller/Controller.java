package com.springboot.app.controller;

import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.springboot.app.service.AppService;
import Errors.ConnectionProblem;
import Errors.ErrorResponse;
import Errors.FilterProblem;
import Errors.JSONProblem;
import Filtersmanagement.SingleFilter;
/**
 * The controller of the project; here you can see the different roots of the project
 * @author Federico Di Tullio
 * @author Elia Vaccarini
 */
@RestController
public class Controller {
	/**
	 * The appservice that provides all the requests
	 */
 @Autowired 
 private AppService service;
 /**
  * The root where you can see the key words of the app
  * @return the class that contains the filters
  */
 @GetMapping("/getkeywords")
 public ResponseEntity<HashMap> getkeywords(){
	return new ResponseEntity<HashMap>(service.GetKeyWords(),HttpStatus.OK);
 }
 /**
  * The root where you can see the filters of the app
  * @return the class that contains the filters
  */
 @GetMapping("/getfilters")
 public ResponseEntity<HashMap> getfilters(){
	return new ResponseEntity<HashMap>(service.GetPossibleFilters(),HttpStatus.OK);
 }
 /**
  * The root associated with "/getdatabase" that permits to get database 
  * @return the database
  * @throws ConnectionProblem
  */
 @GetMapping("/getdatabase")
 public ResponseEntity<Object> getdatabase() throws ConnectionProblem{
	 return new ResponseEntity<Object>(service.GetDatabase(),HttpStatus.OK);
 }
 /**
  * The root associated with "/getdatabase" that permits to get filtered database by the JSON parameter "filter" inserted
  * @param filter
  * @return the database
  * @throws JSONProblem
  * @throws JSONException
 * @throws FilterProblem 
  */
 @PostMapping("/getdatabase")
 public ResponseEntity<Object> getdatabase(@RequestBody String filter) throws JSONProblem, JSONException, FilterProblem{
	 return new ResponseEntity<Object>(service.GetDatabase(filter),HttpStatus.OK);
 }
 /**
  * The root associated with "/getstats" that permits to get the statistics
  * @return the statistics
  * @throws JSONProblem
  * @throws JSONException
  * @throws FilterProblem
  */
 @GetMapping("/getstats")
 public ResponseEntity<Object> getstats() throws JSONProblem, JSONException, FilterProblem{
	 return new ResponseEntity<Object>(service.GetStats(),HttpStatus.OK);
 }
 /**
  * The root associated with "/getstats" that permits to get the filtered statistics by the JSON parameter "filter" inserted
  * @param filter
  * @return the statistics
  * @throws JSONProblem
  * @throws JSONException
  * @throws FilterProblem
  */
 @PostMapping("/getstats")
 public ResponseEntity<Object> getstats(@RequestBody String filter) throws JSONProblem, JSONException, FilterProblem{
	 return new ResponseEntity<Object>(service.GetStats(filter),HttpStatus.OK);
 }
 /**
  * Exception handler for connection problems
  * @param e
  * @return the connection problem message
  */
 @ExceptionHandler(ConnectionProblem.class)
 public final ResponseEntity<ErrorResponse> exceptionConnection(NoHandlerFoundException e){
	 ErrorResponse er = new ErrorResponse(409,e.getMessage());
	 return new ResponseEntity<ErrorResponse>(er,HttpStatus.GATEWAY_TIMEOUT);
 }
 /**
  * Exception handler for JSON conversion problems
  * @param e
  * @return the JSON conversion problem message
  */
 @ExceptionHandler(JSONProblem.class)
 public final ResponseEntity<ErrorResponse> exceptionJSON(Exception e){
	 ErrorResponse er = new ErrorResponse(409,e.getMessage());
	 return new ResponseEntity<ErrorResponse>(er,HttpStatus.CONFLICT);
 }
 /**
  * Exception handler for filter problems
  * @param e
  * @return the filter problem message
  */
 @ExceptionHandler(FilterProblem.class)
 public final ResponseEntity<ErrorResponse> exceptionFilter(Exception e){
	 ErrorResponse er = new ErrorResponse(409,e.getMessage());
	 return new ResponseEntity<ErrorResponse>(er,HttpStatus.BAD_REQUEST);
	 
 }
 
 }

