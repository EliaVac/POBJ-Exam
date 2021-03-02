package Filtersmanagement;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.springboot.app.singledataclasses.DateTime;
import com.springboot.app.singledataclasses.SingleDomain;

import Errors.JSONProblem;

public class FiltersApply {
	private ArrayList<SingleFilter> filterslist;
	private ArrayList<SingleDomain> database;
	private AllOperations operation;

	public FiltersApply(String stringfilter, ArrayList<SingleDomain> database) throws JSONProblem, JSONException {
		this.database=database;
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
			try {
				country = onefilter.getString("country");
			} catch (Exception e) {
			}

			for (int j = 0; j < 4; j++) {
				try {
					times[j] = null;
					JSONObject date = (JSONObject) onefilter.get(timesstring[j]);
					int year = 0, month = 0, day = 0, hour = 0, minute = 0;
					try {
						year = Integer.parseInt((String) date.getString("year"));
					} catch (Exception e) {
					}
					try {
						month = Integer.parseInt((String) date.getString("month"));
					} catch (Exception e) {
					}
					try {
						day = Integer.parseInt((String) date.getString("day"));
					} catch (Exception e) {
					}
					try {
						hour = Integer.parseInt((String) date.getString("hour"));
					} catch (Exception e) {
					}
					try {
						minute = Integer.parseInt((String) date.getString("minute"));
					} catch (Exception e) {
					}
					times[j] = new DateTime(year, month, day, hour, minute);
				} catch (Exception e) {
				}
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

	public ArrayList<SingleDomain> getFilteredDatabase() {
		ArrayList<SingleDomain> filteredDatabase = new ArrayList<SingleDomain>();
		ArrayList<SingleDomain> temp = database;
		operation = new AllOperations();
		for (int i = 0; i < filterslist.size(); i++) {
			temp = database;
			if (filterslist.get(i).getCountry() != null)
				temp = operation.CountryFilter(temp, filterslist.get(i).getCountry());
			if (filterslist.get(i).getCreatetimebeg() != null)
				temp = operation.DateFilter(temp, filterslist.get(i).getCreatetimebeg(), true, true);
			if (filterslist.get(i).getCreatetimeend() != null)
				temp = operation.DateFilter(temp, filterslist.get(i).getCreatetimeend(), true, false);
			if (filterslist.get(i).getUpdatedatebeg() != null)
				temp = operation.DateFilter(temp, filterslist.get(i).getUpdatedatebeg(), false, true);
			if (filterslist.get(i).getUpdatedateend() != null)
				temp = operation.DateFilter(temp, filterslist.get(i).getUpdatedateend(), false, false);
			if (filterslist.get(i).isIsdead() != -1)
				temp = operation.IsDeadFilter(temp, filterslist.get(i).isIsdead());
			for (int j = 0; j < temp.size(); j++) {
				filteredDatabase.add(temp.get(j));
				database.remove(database.indexOf(temp.get(j)));
			}
		}
		return filteredDatabase;
	}
}
