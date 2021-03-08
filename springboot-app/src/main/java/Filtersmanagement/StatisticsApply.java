package Filtersmanagement;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.springboot.app.singledataclasses.DateTime;
import com.springboot.app.singledataclasses.SingleDomain;
import com.springboot.app.singledataclasses.SingleStatistic;
import com.springboot.app.utilities.StatisticsCreator;

import Errors.ConnectionProblem;
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
					val[k][0]=0;
					val[k][1]=Integer.MAX_VALUE;
				}
			}
			SingleFilterStats toadd = new SingleFilterStats(zone, times[0], times[1], val[0], val[1], val[2]);
			filterslist.add(toadd);
		}

	}

	public ArrayList<SingleStatistic> getFilteredStatistic() throws ConnectionProblem, JSONException {
		ArrayList<SingleStatistic> filteredstatistic = new ArrayList<SingleStatistic>();
		ArrayList<SingleStatistic> temp; // arraylist appoggio
		ArrayList<String> imported = new ArrayList<String>();
		for (int i = 0; i < filterslist.size(); i++) {
			if (filterslist.get(i).getZone() != null && filterslist.get(i).getZone().compareTo("bundle_all_zones") != 0) {
				boolean ok = true;
				for (int j = 0; j < imported.size() && ok; j++) {
					if (filterslist.get(i).getZone().compareTo(imported.get(j)) == 0)
						ok = false;
				}
				if (ok)
					try {
						imported.add(filterslist.get(i).getZone());
						StatisticsCreator downloadstats = new StatisticsCreator(filterslist.get(i).getZone());
						collection.addAll(downloadstats.getStats());
					} catch (ConnectionProblem e) {
						throw new ConnectionProblem("The requested zone " + filterslist.get(i).getZone()
								+ " can not be managed by the service.");
					}
			}
		}
		for (int i = 0; i < filterslist.size(); i++) {
			temp=collection;
			if (filterslist.get(i).getZone() != null)
				temp = ZoneFilter(temp, filterslist.get(i).getZone());
			if (filterslist.get(i).getMinimum_date() != null)
				temp = DateFilter(temp, filterslist.get(i).getMinimum_date(), true);
			if (filterslist.get(i).getMaximum_date() != null)
				temp = DateFilter(temp, filterslist.get(i).getMaximum_date(), false);
			if (filterslist.get(i).getTot() != null)
				temp = IntFilter(temp, filterslist.get(i).getTot()[0], filterslist.get(i).getTot()[1],1);
			if (filterslist.get(i).getInc() != null)
				temp = IntFilter(temp, filterslist.get(i).getInc()[0], filterslist.get(i).getInc()[1],2);
			if (filterslist.get(i).getDec() != null)
				temp = IntFilter(temp, filterslist.get(i).getDec()[0], filterslist.get(i).getDec()[1],3);
			if(temp!=null)
				for (int j = 0; j < temp.size(); j++) {
					filteredstatistic.add(temp.get(j));
					collection.remove(collection.indexOf(temp.get(j)));
				}
		}
		return filteredstatistic;
	}

}
