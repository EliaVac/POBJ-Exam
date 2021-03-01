package com.springboot.app.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import com.springboot.app.singledataclasses.SingleDomain;
import com.springboot.app.utilities.DatabaseCreator;
import com.springboot.app.utilities.FiltersCollection;

import Errors.ConnectionProblem;
import Errors.JSONProblem;
import Filtersmanagement.FiltersApply;

/**
 * The service class that implements all methods useful to the controller
 * 
 * @author Federico Di Tullio
 * @author Elia Vaccarini
 */
@Service
public class AppService {
	/**
	 * the possible filters collection
	 */
	private HashMap<String, String> possiblefilters;
	/**
	 * the database
	 */
	private ArrayList<SingleDomain> database;

	/**
	 * Initialize possible filters collection and database
	 * 
	 * @throws ConnectionProblem
	 * @throws JSONException
	 */
	public AppService() throws ConnectionProblem, JSONException {
		FiltersCollection filtercollector = new FiltersCollection();
		possiblefilters = filtercollector.GetFiltersCollection();
		DatabaseCreator datacreator = new DatabaseCreator();
		database = datacreator.getDatabase();
	}

	/**
	 * Getters of the possible filters collection attribute
	 * 
	 * @return the possible filters collection
	 */
	public HashMap<String, String> GetPossibleFilters() {
		return possiblefilters;
	}

	/**
	 * Getters of the database attribute
	 * 
	 * @return the database
	 */
	public ArrayList<SingleDomain> GetDatabase() {
		return database;
	}

	public HashMap GetKeyWords() {
		return null;
	}

	public ArrayList<SingleDomain> GetDatabase(JSONObject filter) {
		return null;
	}

	public ArrayList<SingleDomain> GetDatabase(String filter) throws JSONProblem, JSONException {
		FiltersApply filtering = new FiltersApply(filter,database);
		return null;
	}

}
