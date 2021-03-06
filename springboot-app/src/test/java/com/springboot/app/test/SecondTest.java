package com.springboot.app.test;

import static org.junit.Assert.assertThrows;
import org.json.JSONException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Errors.FilterProblem;
import Errors.JSONProblem;
import Filtersmanagement.FiltersApply;
/**
 * This is the class to test the exceptions that are launched when the user inserted a wrong filter of database
 * @author Federico Di Tullio
 * @author Elia Vaccarini
 */
public class SecondTest {
	/**
	 * The filter array of string
	 */
	private String[] filter;

	/**
	 * This void sets up the filter
	 */
	@BeforeEach 
	public void setUp () {
		filter = new String[3];
		//a Json filter written thanks to Postman
		filter[0] = "[\n"
				+ "		          {\n"
				+ "		              \"country\":\"US\",\n"
				+ "                   \"Country\":\"US\",\n"
				+ "		              \"isdead\": \"true\" \n"
				+ "		          }"
				+ "		      ]";
		filter[1]= "[\n"
				+ "		          {\n"
				+ "		              \"country\":\"US\",\n"
				+ "                   \"unexpected\":\"doesn'texist\",\n"
				+ "		              \"isdead\": \"true\" \n"
				+ "		          }"
				+ "		      ]";
		filter[2]= "[\n"
				+ "		          {\n"
				+ "		              \"country\":\"US\",\n"
				+ "                   \"this line is uncomplete\": ,\n"
				+ "		              \"isdead\": \"true\" \n"
				+ "		          }"
				+ "		      ]";
	}

	@AfterEach
	public void tearDown () {
		
	}
	/**
	 * The test controls if the exceptions returned by the function is matching with the class that identify the type of error contained in the
	 * filter
	 * @throws JSONProblem
	 * @throws JSONException
	 * @throws FilterProblem
	 */
	@Test
	public void test() throws JSONProblem, JSONException, FilterProblem {
		//It's found a second attribute with different case
		assertThrows(FilterProblem.class, ()-> new FiltersApply(filter[0], null));
		//It's found an unacceptable field
		assertThrows(FilterProblem.class, ()-> new FiltersApply(filter[1], null));
		//It's impossible to generate an incomplete JSON
		assertThrows(JSONProblem.class, ()-> new FiltersApply(filter[2], null));
	}
}
