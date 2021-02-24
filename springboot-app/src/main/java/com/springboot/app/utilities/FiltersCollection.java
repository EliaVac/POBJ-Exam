package com.springboot.app.utilities;

import java.util.HashMap;

public class FiltersCollection {
	private HashMap<String,String> filterscollection;
	public FiltersCollection() {
		filterscollection = new HashMap<String, String>();
		filterscollection.put("Country", "The country that host the domain: Undefined,US,RU,HK");
		filterscollection.put("Updating Time ","Require a date of start and/or a date of end: dd/mm/yyyy");
		filterscollection.put("Creating Time", "Require a date of start and/or a date of end: dd/mm/yyyy");
		filterscollection.put("State","Identify is the domain is still alive: Alive or Dead");
	}
	public HashMap<String,String> GetFiltersCollection(){
		return filterscollection;
	}
}
