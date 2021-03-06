package com.springboot.app.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import org.json.JSONException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.springboot.app.singledataclasses.DateTime;

import Errors.FilterProblem;
import Errors.JSONProblem;
import Filtersmanagement.FiltersApply;
import Filtersmanagement.SingleFilter;

/**
 * This class is used to test if the expected results for this filter of database are
 * truthful
 * 
 * @author Federico Di Tullio
 * @author Elia Vaccarini
 */
public class FirstTest {
	/**
	 * For the management of the filter
	 */
	private FiltersApply filtersapply;
	/**
	 * The filter
	 */
	private String filter;
	/**
	 * Single Filter expected
	 */
	private SingleFilter expected;

	/**
	 * This void sets up the filter
	 */
	@BeforeEach
	public void setUp() {
		// a JSON filter written thanks to Postman
		filter = "[\n" 
		        + "		          {\n" 
		        + "		              \"country\":\"US\",\n"
				+ "		              \"minimum_createtime\":\n" 
				+ "		               {\n"
				+ "		                  \"year\":2018,\n" 
				+ "		                  \"month\":7,\n"
				+ "		                  \"day\": 24,\n" 
				+ "		                  \"hour\":14,\n"
				+ "		                  \"minute\":7\n" 
				+ "		               },\n"
				+ "		              \"maximum_createtime\":{\n" 
				+ "		              },\n"
				+ "		              \"minimum_updatetime\":{\n" 
				+ "		                  \"year\":2018,\n"
				+ "		                  \"month\":7,\n" 
				+ "		                  \"day\": 24\n"
				+ "		              }, \n" 
				+ "		              \"maximum_updatetime\":\n"
				+ "		              {   \n" 
				+ "		                  \"hour\":14,\n"
				+ "		                  \"minute\":7\n" 
				+ "		               },\n"
				+ "		              \"isdead\": \"true\"\n" 
				+ "		          }" 
				+ "		      ]";
		LocalDateTime now = LocalDateTime.now();
		DateTime firstdate = new DateTime(2018, 7, 24, 14, 7);
		DateTime seconddate = new DateTime(now.getYear(), now.getMonthValue(), now.getDayOfMonth(), 0, 0);
		DateTime thirddate = new DateTime(2018, 7, 24, 0, 0);
		DateTime fourthdate = new DateTime(now.getYear(), now.getMonthValue(), now.getDayOfMonth(), 14, 7);
		expected = new SingleFilter("US", firstdate, seconddate, thirddate, fourthdate, 1);
	}

	@AfterEach
	public void tearDown() {
	}

	/**
	 * This void tests if the expected result is the same of the application
	 * 
	 * @throws JSONProblem
	 * @throws JSONException
	 * @throws FilterProblem
	 */
	@Test
	public void test() throws JSONProblem, JSONException, FilterProblem {
		filtersapply = new FiltersApply(filter, null);
		assertEquals(expected, filtersapply.getFilterList().get(0));
	}
}
