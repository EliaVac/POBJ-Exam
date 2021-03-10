package com.springboot.app.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.json.JSONException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.springboot.app.singledataclasses.DateTime;

import Errors.ConnectionProblem;
import Errors.FilterProblem;
import Errors.JSONProblem;
import Filtersmanagement.SingleFilterStats;
import Filtersmanagement.StatisticsApply;

/**
 * 
 * @author Elia Vaccarini
 * @author Federico Di Tullio
 */
public class ThirdTest {
	/**
	 * 
	 */
	private String[] filter;
	SingleFilterStats singlefilterstats;
	/**
	 * 
	 */
	@BeforeEach 
	public void setUp () {
		filter = new String[2];
		//a JSON filter written thanks to Postman
		filter[0] = "[\n"
				+ "		          {\n"
				+ "                   \"zone\":\"IT\",\n"
				+ "		              \"minimum_date\":"
				+ "		               {\n"
				+ "		                  \"year\":2020,\n"
				+ "		                  \"month\":6,\n"
				+ "		                  \"day\": 1,\n"
				+ "		                  \"hour\":0,\n"
				+ "		                  \"minute\":0\n"
				+ "		               },\n"
				+ "					  \"maximum_date\":"
				+ "		               {\n"
				+ "		                  \"year\":2021,\n"
				+ "		                  \"month\":5,\n"
				+ "		                  \"day\": 30,\n"
				+ "		                  \"hour\":23,\n"
				+ "		                  \"minute\":59\n"
				+ "		               },\n"
				+ "					  \"increment\": \n"
				+ "		               {\n"
				+ "		                  \"minimum\":20,\n"
				+ "		                  \"maximum\":25,\n"
				+ "		               },\n"
				+ "					  \"decrement\":\n"
				+ "		               {\n"
				+ "		                  \"minimum\":35,\n"
				+ "		                  \"maximum\":45,\n"
				+ "		               },\n"
				+ "					  \"total\":\n" 
				+ "		               {\n"
				+ "		                  \"minimum\":37,\n"
				+ "		                  \"maximum\":67,\n"
				+ "		               },\n"
				+ "		          }"
				+ "		      ]";
		filter[1]= "[\n"
				+ "		          {\n"
				+ "		              \"zone\":\"US\",\n"
				+ "                   \"isdead\": \"true\" \n"
				+ "		          }"
				+ "		      ]";
		int[] inc= {20,25};
		int[] dec={35,45};
		int[] tot= {37,67};
		singlefilterstats=new SingleFilterStats("IT", new DateTime(2020,6,1,0,0), new DateTime(2021,5,30,23,59),inc,dec,tot);
	}
	/**
	 * 
	 */
	@AfterEach
	public void tearDown () {
		
	}
	/**
	 * 
	 * @throws JSONProblem
	 * @throws JSONException
	 * @throws FilterProblem
	 * @throws ConnectionProblem
	 */
	@Test
	public void test() throws JSONProblem, JSONException, FilterProblem, ConnectionProblem {
		//Compare the expected filter with the one to elaborate
		StatisticsApply statisticapply = new StatisticsApply(filter[0], null);
		assertEquals(singlefilterstats, statisticapply.getFilterList().get(0));
		//It's found an invalid attribute
		Throwable exception = assertThrows(FilterProblem.class, ()-> new StatisticsApply(filter[1], null));
		//Compare if the launched exception has the same message expected
		assertEquals("The field isdead doesn't exist; check all the possible filters with the root: /getfilters",exception.getMessage());
	}
}
