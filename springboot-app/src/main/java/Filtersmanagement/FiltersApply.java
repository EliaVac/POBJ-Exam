package Filtersmanagement;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.apache.tomcat.jni.Local;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.springboot.app.singledataclasses.DateTime;
import com.springboot.app.singledataclasses.SingleDomain;

import Errors.FilterProblem;
import Errors.JSONProblem;

/**
 * Class management of filters
 * 
 * @author Elia Vaccarini
 * @author Federico Di Tullio
 */
public class FiltersApply extends AllOperations {
	/**
	 * the list of all the filters given
	 */
	private ArrayList<SingleFilter> filterslist;
	/**
	 * the database
	 */
	private ArrayList<SingleDomain> database;

	/**
	 * Initialize the database and add the recognized filters to the ArrayList
	 * "filterslist"
	 * 
	 * @param stringfilter
	 * @param database
	 * @throws JSONProblem
	 * @throws JSONException
	 * @throws FilterProblem
	 */
	public FiltersApply(String stringfilter, ArrayList<SingleDomain> database)
			throws JSONProblem, JSONException, FilterProblem {
		this.database = database;
		filterslist = new ArrayList<SingleFilter>();
		JSONArray filter = new JSONArray(stringfilter);
		for (int i = 0; i < filter.length(); i++) {
			JSONObject onefilter;
			String country = null;
			DateTime[] times = new DateTime[4];
			String[] timesstring = { "minimum_createtime", "maximum_createtime", "minimum_updatetime",
					"maximum_updatetime" };
			int isdead = -1;
			try {
				onefilter = (JSONObject) filter.get(i);
			} catch (JSONException e) {
				throw new JSONProblem("Wrong filter convertion");
			}

			check(onefilter.getNames(onefilter), true);
			try {
				country = onefilter.getString("country");
			} catch (Exception e) {
			}

			LocalDateTime now = LocalDateTime.now();
			for (int j = 0; j < 4; j++) {
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
			try {
				if (onefilter.getBoolean("isdead"))
					isdead = 1;
				else
					isdead = 0;
			} catch (Exception e) {
			}
			SingleFilter toadd = new SingleFilter(country, times[0], times[1], times[2], times[3], isdead);
			filterslist.add(toadd);
		}
	}

	/**
	 * Return the database filtered thanks to the filterslist, it analyzes one to
	 * one filter picking up only the satisfying element and removing it from the
	 * useful list for next filter one filter
	 * 
	 * @return the filteredDatabase
	 */
	public ArrayList<SingleDomain> getFilteredDatabase() {
		ArrayList<SingleDomain> filteredDatabase = new ArrayList<SingleDomain>();
		ArrayList<SingleDomain> temp; // arraylist appoggio
		for (int i = 0; i < filterslist.size(); i++) {
			temp = database;
			if (filterslist.get(i).getCountry() != null)
				temp = CountryFilter(temp, filterslist.get(i).getCountry());
			if (filterslist.get(i).getCreatetimebeg() != null)
				temp = DateFilter(temp, filterslist.get(i).getCreatetimebeg(), true, true);
			if (filterslist.get(i).getCreatetimeend() != null)
				temp = DateFilter(temp, filterslist.get(i).getCreatetimeend(), true, false);
			if (filterslist.get(i).getUpdatedatebeg() != null)
				temp = DateFilter(temp, filterslist.get(i).getUpdatedatebeg(), false, true);
			if (filterslist.get(i).getUpdatedateend() != null)
				temp = DateFilter(temp, filterslist.get(i).getUpdatedateend(), false, false);
			if (filterslist.get(i).isIsdead() != -1)
				temp = IsDeadFilter(temp, filterslist.get(i).isIsdead());
			for (int j = 0; j < temp.size(); j++) {
				filteredDatabase.add(temp.get(j));
				database.remove(database.indexOf(temp.get(j)));
			}
		}
		return filteredDatabase;
	}
}
