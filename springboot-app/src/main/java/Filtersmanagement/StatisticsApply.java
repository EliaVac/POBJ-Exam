package Filtersmanagement;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.springboot.app.singledataclasses.DateTime;
import com.springboot.app.singledataclasses.SingleStatistic;

import Errors.FilterProblem;
import Errors.JSONProblem;

/**
 * Class management of statistics
 * 
 * @author Federico Di Tullio
 * @author Elia Vaccarini
 */
public class StatisticsApply extends AllOperations {
	/**
	 * the collection of statistics
	 */
	private ArrayList<SingleStatistic> collection;
	/**
	 * the list of all the filtered statistics given
	 */
	private ArrayList<SingleFilterStats> filterslist;

	/**
	 * Initialize the collection and add the recognized filters to the ArrayList
	 * "filterslist"
	 * 
	 * @param stringfilter
	 * @param collection
	 * @throws JSONException
	 * @throws FilterProblem
	 * @throws JSONProblem
	 */
	public StatisticsApply(String stringfilter, ArrayList<SingleStatistic> collection)
			throws JSONException, FilterProblem, JSONProblem {
		this.collection = collection;
		filterslist = new ArrayList<SingleFilterStats>();
		JSONArray filter = new JSONArray(stringfilter);
		for (int i = 0; i < filter.length(); i++) {
			JSONObject onefilter;
			String zone = null;
			DateTime[] times = new DateTime[2];
			String[] timesstring = { "minimum_date", "maximum_date" };
			int[][] val = new int[3][2];
			try {
				onefilter = (JSONObject) filter.get(i);
			} catch (JSONException e) {
				throw new JSONProblem("Wrong filter convertion");
			}

			check(onefilter.getNames(onefilter), false);
			try {
				zone = onefilter.getString("zone");
			} catch (Exception e) {
			}

			LocalDateTime now = LocalDateTime.now();
			for (int j = 0; j < 2; j++) {
				try {
					times[j] = null;
					JSONObject date = (JSONObject) onefilter.get(timesstring[j]);
					int year = 0, month = 0, day = 0, hour = 0, minute = 0;
					try {
						year = date.getInt("year");
					} catch (JSONException e) {
						year = now.getYear();
					}
					try {
						month = date.getInt("month");
					} catch (Exception e) {
						month = now.getMonthValue();
					}
					try {
						day = date.getInt("day");
					} catch (Exception e) {
						day = now.getDayOfMonth();
					}
					try {
						hour = date.getInt("hour");
					} catch (Exception e) {
					}
					try {
						minute = date.getInt("minute");
					} catch (Exception e) {
					}
					times[j] = new DateTime(year, month, day, hour, minute);
				} catch (Exception e) {
				}
				if (times[j] != null)
					CheckDate(times[j]);
			}
			String[] valstring = { "increment", "decrement", "total" };
			for (int k = 0; k < 3; k++) {
				try {
					JSONObject values = (JSONObject) onefilter.get(valstring[k]);
					try {
						val[k][0] = values.getInt("minimum");
					} catch (JSONException e) {
						val[k][0] = 0;
					}
					try {
						val[k][1] = values.getInt("maximum");
					} catch (JSONException e) {
						val[k][1] = Integer.MAX_VALUE;
					}
				} catch (JSONException e) {
				}
			}
			SingleFilterStats toadd = new SingleFilterStats(zone, times[0], times[1], val[0], val[1], val[2]);
			filterslist.add(toadd);
		}

	}

}
