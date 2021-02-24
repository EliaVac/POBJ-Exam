package com.springboot.app.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONException;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import com.springboot.app.singledataclasses.SingleDomain;
import com.springboot.app.utilities.DatabaseCreator;
import com.springboot.app.utilities.FiltersCollection;

import Errors.ConnectionProblem;
@Service 
public class AppService {
private HashMap<String,String> possiblefilters;
private ArrayList<SingleDomain> database;
	public  AppService() throws ConnectionProblem, JSONException {
		FiltersCollection filtercollector = new FiltersCollection();
		possiblefilters = filtercollector.GetFiltersCollection();
		DatabaseCreator datacreator = new DatabaseCreator();
		database = datacreator.getDatabase();
	}
	public HashMap<String, String> GetPossibleFilters() {
		return possiblefilters;
	}
	public ArrayList<SingleDomain> GetDatabase() {
		return database;
	}

}
