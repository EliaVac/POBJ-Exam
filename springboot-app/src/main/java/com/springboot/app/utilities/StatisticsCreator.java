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
import com.springboot.app.singledataclasses.SingleStatistic;

import Errors.ConnectionProblem;
/**
 *  The class sets up a collection of statistics and allows the reading of this
 * @author Federico Di Tullio
 * @author Elia Vaccarini
 */
public class StatisticsCreator {
	/**
	 * Collection of statistics
	 */
	private ArrayList<SingleStatistic> statistics ;

	/**
	 * Constructor class, it provides to create an ArrayList of all the data
	 * 
	 * @throws ConnectionProblem
	 * @throws JSONException
	 */
	public StatisticsCreator(String paramzone) throws ConnectionProblem, JSONException {
		super();
		JSONObject statisticObj = null;
		StringBuilder content = new StringBuilder();
		try {
			URL url = new URL("https://api.domainsdb.info/v1/info/stat/"+paramzone+"?limit=200");
			URLConnection urlConnection = url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
			String line;
			do {
				line = br.readLine();
				if (line != null)
					content.append(line + "\n");
			} while (line != null);
			br.close();
			statisticObj = new JSONObject(content.toString());
		}catch (IOException e) {
			throw new ConnectionProblem("Error due to failure connection, necessary for the download");
		} catch (JSONException e) {
			throw new JSONException("Error due to failure conversion of the JSON downloaded");
		}
		try {
			statistics= new ArrayList<SingleStatistic>();
			JSONArray JSONstatistics = statisticObj.getJSONArray("statistics");
			for (int i = 0; i < JSONstatistics.length(); i++) {
				String[] fordate = ((String) ((JSONObject) JSONstatistics.get(i)).get("date")).split("T");
				String[] firstpart = fordate[0].split("-");
				String[] secondpart = fordate[1].split(":");
				DateTime date = new DateTime(Integer.parseInt(firstpart[0]), Integer.parseInt(firstpart[1]), Integer.parseInt(firstpart[2]), Integer.parseInt(secondpart[0]),
						Integer.parseInt(secondpart[1]));
				String zone = (String) ((JSONObject) JSONstatistics.get(i)).get("zone");
				int dec=((JSONObject) JSONstatistics.get(i)).getInt("dec");
				int inc=((JSONObject) JSONstatistics.get(i)).getInt("inc");
				int tot=((JSONObject) JSONstatistics.get(i)).getInt("total");
				SingleStatistic toadd = new SingleStatistic(zone,date,inc,dec,tot);
				statistics.add(toadd);
			}
		} catch (JSONException e) {
			throw new JSONException("Error due to recognizing field of the JSON converted");
		}
		
	}

	/**
	 * Getters of the statistics attribute
	 * 
	 * @return the statistics
	 */
	public ArrayList<SingleStatistic> getStats() {
		return statistics;

	}

}

