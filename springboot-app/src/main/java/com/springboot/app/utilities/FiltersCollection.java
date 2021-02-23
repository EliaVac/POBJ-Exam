package com.springboot.app.utilities;

import java.util.HashMap;

public class FiltersCollection {
	private HashMap<String,String> filterscollection;
	public FiltersCollection() {
		filterscollection = new HashMap<String, String>();
		filterscollection.put("Country", "");
	}
	public HashMap<String,String> GetFiltersCollection(){
		return filterscollection;
	}
}
