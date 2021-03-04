package com.springboot.app.utilities;

import java.util.HashMap;
/**
 * The class sets up a collection of key words and allows the reading of this
 * @author Federico Di Tullio
 * @author Elia Vaccarini
 */

public class KeyWordsCreator {
	private HashMap<String, String> keywordscollection;
	public KeyWordsCreator() {
		
		
		
	}
	/**
	 * @return the keywordscollection
	 */
	public HashMap<String, String> GetKeyWordsCollection() {
		return keywordscollection;
	}

}
