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
	 * Class used to describe the two types of filter
	 * 
	 * @author Federico Di Tullio
	 * @author Elia Vaccarini
	 */
	public class PossibleFilter {
		/**
		 * To introduce the database type of filter
		 */
		private String filterIntroduction;
		/**
		 * Collection of possible database filters
		 */
		private HashMap<String, String> filterscollection;
		/**
		 * To introduce the statistic type of filter
		 */
		private String filterStatIntroduction;
		/**
		 * Collection of possible statistic filters
		 */
		private HashMap<String, String> filtersStatcollection;

		/**
		 * Getters of the introduction to the database type of filter
		 * 
		 * @return the filterIntroduction
		 */
		public String getFilterIntroduction() {
			return filterIntroduction;
		}

		/**
		 * Getters of possible database of filters
		 * 
		 * @return the filterscollection
		 */
		public HashMap<String, String> getFilterscollection() {
			return filterscollection;
		}

		/**
		 * Getters of the introduction to the statistic type of filter
		 * 
		 * @return the filterStatIntroduction
		 */
		public String getFilterStatIntroduction() {
			return filterStatIntroduction;
		}

		/**
		 * Getters of the possible collection statistic filters
		 * 
		 * @return the filtersStatcollection
		 */
		public HashMap<String, String> getFiltersStatcollection() {
			return filtersStatcollection;
		}
	}

	/**
	 * Attribute to describe the possible instructions
	 */
	private PossibleFilter possiblefilter;

	/**
	 * Initialize the hashmap of the two possible filters
	 */
	public FiltersCreator() {
		possiblefilter = new PossibleFilter();
		possiblefilter.filterIntroduction = "A simply filter for database can be described by:";
		possiblefilter.filterscollection = new HashMap<String, String>();
		possiblefilter.filterscollection.put("country", "The country that host the domain: undefined,US,RU,HK");
		possiblefilter.filterscollection.put("minimum_createtime", "Identify the date of start with an object, composed by: 'year', 'month', 'day', 'hour', 'minute'. The default date is today at 00:00");
		possiblefilter.filterscollection.put("maximum_createtime", "Identify the date of end with an object, composed by: 'year', 'month', 'day', 'hour', 'minute'. The default date is today at 00:00");
		possiblefilter.filterscollection.put("minimum_updatetime", "Identify the date of start with an object, composed by: 'year', 'month', 'day', 'hour', 'minute'. The default date is today at 00:00");
		possiblefilter.filterscollection.put("maximum_updatetime", "Identify the date of end with an object, composed by: 'year', 'month', 'day', 'hour', 'minute'. The default date is today at 00:00");
		possiblefilter.filterscollection.put("isdead", "Identify if the domain is still alive: Alive or Dead");
		possiblefilter.filterStatIntroduction = "A simply filter for statistic can be described by:";
		possiblefilter.filtersStatcollection = new HashMap<String, String>();
		possiblefilter.filtersStatcollection.put("zone", "The zone where are analyzed the statistics: undefined,US,RU,HK");
		possiblefilter.filtersStatcollection.put("minimum_date", "Identify the date of start with an object, composed by: 'year', 'month', 'day', 'hour', 'minute'. The default date is today at 00:00");
		possiblefilter.filtersStatcollection.put("maximum_date", "Identify the date of end with an object, composed by: 'year', 'month', 'day', 'hour', 'minute'. The default date is today at 00:00");
		possiblefilter.filtersStatcollection.put("increment", "Identify the records increment");
		possiblefilter.filtersStatcollection.put("decrement", "Identify the records decrement");
		possiblefilter.filtersStatcollection.put("total", "Identify the total records");
	}

	/**
	 * Getters of the possible instructions
	 * 
	 * @return possiblefilter
	 */
	public PossibleFilter GetFiltersCollection() {
		return possiblefilter;
	}

}
