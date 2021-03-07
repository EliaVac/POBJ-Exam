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
	 * Class used to desrcibe the two tipes of filter
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
		 * To introduce the statistics type of filter
		 */
		private String filterStatIntroduction;
		/**
		 * Collection of possible statistics filters
		 */
		private HashMap<String, String> filtersStatcollection;
		/**
		 * @return the filterIntroduction
		 */
		public String getFilterIntroduction() {
			return filterIntroduction;
		}
		/**
		 * @return the filterscollection
		 */
		public HashMap<String, String> getFilterscollection() {
			return filterscollection;
		}
		/**
		 * @return the filterStatIntroduction
		 */
		public String getFilterStatIntroduction() {
			return filterStatIntroduction;
		}
		/**
		 * @return the filtersStatcollection
		 */
		public HashMap<String, String> getFiltersStatcollection() {
			return filtersStatcollection;
		}
	}
	private PossibleFilter possiblefilter;
	/**
	 * Initialize the hashmap of the possible filters
	 */
	public FiltersCreator() {
		/*"country", "minimum_createtime", "maximum_createtime", "minimum_updatetime",
		"maximum_updatetime", "isdead","zone","minimum_date","maximum_date","increment","decrement","total"*/
		possiblefilter = new PossibleFilter();
		possiblefilter.filterIntroduction="A simply filter for database can be described by:";
		possiblefilter.filterscollection = new HashMap<String, String>();
		possiblefilter.filterscollection.put("country", "The country that host the domain: Undefined,US,RU,HK");
		possiblefilter.filterscollection.put("minimum_createtime", "Identify the date of start with an object, composed by: \"year\",\"month\",\"day\",\"hour\",\"minute\". The default date is today at 00:00");
		possiblefilter.filterscollection.put("Creating Time", "Require a date of start and/or a date of end: dd/mm/yyyy");
		possiblefilter.filterscollection.put("isdead", "Identify is the domain is still alive: Alive or Dead");
		possiblefilter.filterStatIntroduction="A simply filter for statistic can be described by:";
		possiblefilter.filtersStatcollection = new HashMap<String, String>();
		possiblefilter.filtersStatcollection.put("1", "a");
		possiblefilter.filtersStatcollection.put("2", "b");
		possiblefilter.filtersStatcollection.put("3", "c");
		possiblefilter.filtersStatcollection.put("4", "d");
		possiblefilter.filtersStatcollection.put("5", "e");
	}
	public PossibleFilter GetFiltersCollection() {
		return possiblefilter;
	}

}
