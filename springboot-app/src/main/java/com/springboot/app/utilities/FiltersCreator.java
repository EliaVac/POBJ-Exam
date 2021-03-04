package com.springboot.app.utilities;

import java.util.HashMap;

/**
 * The class sets up a collection of possible filters and allows the reading of
 * this
 * 
 * @author Federico Di Tullio
 * @author Elia Vaccarini
 */

public class FiltersCreator {
	/**
	 * Collection of possible filters
	 */
	private HashMap<String, String> filterscollection;

	/**
	 * The initialize the list of the possible filters
	 */
	public FiltersCreator() {
		filterscollection = new HashMap<String, String>();
		filterscollection.put("Country", "The country that host the domain: Undefined,US,RU,HK");
		filterscollection.put("Updating Time ", "Require a date of start and/or a date of end: dd/mm/yyyy");
		filterscollection.put("Creating Time", "Require a date of start and/or a date of end: dd/mm/yyyy");
		filterscollection.put("State", "Identify is the domain is still alive: Alive or Dead");
}

	/**
	 * Getters of the hashmap filterscollection
	 * 
	 * @return the filterscollection
	 */
	public HashMap<String, String> GetFiltersCollection() {
		return filterscollection;
	}
}
