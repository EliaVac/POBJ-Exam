package com.springboot.app.utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.springboot.app.singledataclasses.DateTime;
import com.springboot.app.singledataclasses.SingleDomain;

import Errors.ConnectionProblem;

/**
 * The class sets up the database and allows the reading of this
 * 
 * @author Federico Di Tullio
 * @author Elia Vaccarini
 */
public class DatabaseCreator {
	/**
	 * The database
	 */
	private ArrayList<SingleDomain> database;

	/**
	 * Constructor class, it provides to create an ArrayList of all the data
	 * 
	 * @throws ConnectionProblem
	 * @throws JSONException
	 */
	public DatabaseCreator() throws ConnectionProblem, JSONException {
		super();
		database = new ArrayList<>();
		JSONObject databaseArray = null;
		StringBuilder content = new StringBuilder();
		try {
			URL url = new URL("https://api.domainsdb.info/v1/domains/search?limit=200");
			URLConnection urlConnection = url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
			String line;
			do {
				line = br.readLine();
				if (line != null)
					content.append(line + "\n");
			} while (line != null);
			br.close();
			databaseArray = new JSONObject(content.toString());
		} catch (IOException e) {
			throw new ConnectionProblem("Error due to failure connection, necessary for the download");
		} catch (JSONException e) {
			throw new JSONException("Error due to failure conversion of the JSON downloaded");
		}
		try {
			JSONArray domains = databaseArray.getJSONArray("domains");
			for (int i = 0; i < domains.length(); i++) {
				String[] fordate = ((String) ((JSONObject) domains.get(i)).get("create_date")).split("T");
				String[] firstpart = fordate[0].split("-");
				String[] secondpart = fordate[1].split(":");
				DateTime start = new DateTime(Integer.parseInt(firstpart[0]), Integer.parseInt(firstpart[1]),
						Integer.parseInt(firstpart[2]), Integer.parseInt(secondpart[0]),
						Integer.parseInt(secondpart[1]));
				fordate = ((String) ((JSONObject) domains.get(i)).get("update_date")).split("T");
				firstpart = fordate[0].split("-");
				secondpart = fordate[1].split(":");
				String domain = (String) ((JSONObject) domains.get(i)).get("domain");
				String country;
				try {
					country = (String) ((JSONObject) domains.get(i)).get("country");
				} catch (Exception e) {
					country = "undefined";
				}
				DateTime update = new DateTime(Integer.parseInt(firstpart[0]), Integer.parseInt(firstpart[1]),
						Integer.parseInt(firstpart[2]), Integer.parseInt(secondpart[0]),
						Integer.parseInt(secondpart[1]));
				boolean isdead = false;
				if (((String) ((JSONObject) domains.get(i)).get("isDead")).compareTo("True") == 0)
					isdead = true;
				SingleDomain toadd = new SingleDomain(domain, country, start, update, isdead);
				database.add(toadd);
			}
		} catch (JSONException e) {
			throw new JSONException("Error due to recognizing field of the JSON converted");
		}
	}

	/**
	 * Getters of the database attribute
	 * 
	 * @return the database
	 */
	public ArrayList<SingleDomain> getDatabase() {
		return database;

	}

}
