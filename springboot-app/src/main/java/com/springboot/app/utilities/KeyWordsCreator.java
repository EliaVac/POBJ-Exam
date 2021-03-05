package com.springboot.app.utilities;

import java.util.HashMap;

/**
 * The class sets up a collection of key words and allows the reading of this
 * 
 * @author Federico Di Tullio
 * @author Elia Vaccarini
 */

public class KeyWordsCreator {
	/**
	 * Collection of possible key words
	 */
	private HashMap<String, String> keywordscollection;

	/**
	 * Initialize the hashmap of the possible key words
	 */
	public KeyWordsCreator() {
		keywordscollection.put("/getkeywords", "it's a get root; provides all the possible roots on tap");
		keywordscollection.put("/getfilters", "it's a get root; describes the structure of all the possible filters");
		keywordscollection.put("/getdatabase", "it's a get root; provides the database");
		keywordscollection.put("/getdatabase", "it's a post root; it requires a JSONArray filter; provides the filtered database");
		keywordscollection.put("/getstatistics", "it's a get root; provides all the statistics");
		keywordscollection.put("/getstatistics", "it's a post root;it requires a JSONArray of fields; provides the statistics on the request fields");
	}

	/**
	 * Getters of the key words collection
	 * 
	 * @return the keywordscollection
	 */
	public HashMap<String, String> GetKeyWordsCollection() {
		return keywordscollection;
	}

}
