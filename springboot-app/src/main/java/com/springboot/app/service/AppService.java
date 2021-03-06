package com.springboot.app.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONException;
import org.springframework.stereotype.Service;

import com.springboot.app.singledataclasses.SingleDomain;
import com.springboot.app.singledataclasses.SingleStatistic;
import com.springboot.app.utilities.DatabaseCreator;
import com.springboot.app.utilities.FiltersCreator;
import com.springboot.app.utilities.FiltersCreator.PossibleFilter;
import com.springboot.app.utilities.KeyWordsCreator;
import com.springboot.app.utilities.StatisticsCreator;

import Errors.ConnectionProblem;
import Errors.FilterProblem;
import Errors.JSONProblem;
import Filtersmanagement.FiltersApply;
import Filtersmanagement.StatisticsApply;

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
	private PossibleFilter possiblefilters;
	/**
	 * the database
	 */
	private ArrayList<SingleDomain> database;

	/**
	 * the possible key words
	 */
	private HashMap<String, String> possiblekeywords;
	/**
	 * the statistics
	 */
	private ArrayList<SingleStatistic> statistics;

	/**
	 * Initialize possible filters collection and database
	 * 
	 * @throws ConnectionProblem
	 * @throws JSONException
	 */
	public AppService() throws ConnectionProblem, JSONException {
		FiltersCreator filtercollector = new FiltersCreator();
		possiblefilters = filtercollector.GetFiltersCollection();
		DatabaseCreator datacreator = new DatabaseCreator();
		database= datacreator.getDatabase();
		KeyWordsCreator keywordscollector = new KeyWordsCreator();
		possiblekeywords = keywordscollector.GetKeyWordsCollection();
		StatisticsCreator statisticscollector = new StatisticsCreator("bundle_all_zones");
		statistics = statisticscollector.getStats();
	}

	/**
	 * Getters of the possible filters collection attribute
	 * 
	 * @return the possible filters collection
	 */
	public PossibleFilter GetPossibleFilters() {
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

	/**
	 * Getters of the key words hashmap attribute
	 * 
	 * @return the possible key words
	 */

	public HashMap<String, String> GetKeyWords() {
		return possiblekeywords;
	}

	/**
	 * Getters of the filtered database thanks to a string parameter "filter"
	 * 
	 * @param filter
	 * @return the filtered database
	 * @throws JSONProblem
	 * @throws JSONException
	 * @throws FilterProblem
	 */

	public ArrayList<SingleDomain> GetDatabase(String filter) throws JSONProblem, JSONException, FilterProblem {
		FiltersApply filtering = new FiltersApply(filter, (ArrayList<SingleDomain>)database.clone());
		return filtering.getFilteredDatabase();
	}

	/**
	 * Getters of the statistic attribute
	 * 
	 * @return the statistics
	 */
	public ArrayList<SingleStatistic> GetStats() {
		return statistics;
	}

	/**
	 * Getters of the filtered statistics thanks to a string parameter "filter"
	 * 
	 * @param filter
	 * @return the filtered statistics
	 * @throws JSONProblem
	 * @throws FilterProblem
	 * @throws JSONException
	 * @throws ConnectionProblem
	 */
	public ArrayList<SingleStatistic> GetStats(String filter)
			throws JSONException, FilterProblem, JSONProblem, ConnectionProblem {
		StatisticsApply filtering = new StatisticsApply(filter,(ArrayList<SingleStatistic>)statistics.clone());

		return filtering.getFilteredStatistic();
	}

}
