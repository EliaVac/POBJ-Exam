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
		keywordscollection.put("/getkeywords", null);
		keywordscollection.put("/getfilters", null);
		keywordscollection.put("/getdatabase", null);
		keywordscollection.put("/getdatabase", null);
		keywordscollection.put("/getstatistics", null);
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
