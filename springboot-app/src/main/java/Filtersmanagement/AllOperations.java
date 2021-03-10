package Filtersmanagement;

import java.time.LocalDateTime;
import java.util.ArrayList;

import com.springboot.app.singledataclasses.DateTime;
import com.springboot.app.singledataclasses.SingleDomain;
import com.springboot.app.singledataclasses.SingleStatistic;

import Errors.FilterProblem;

/**
 * This class defines all possible filtering operations
 * 
 * @author Elia Vaccarini
 * @author Federico Di Tullio
 */
public class AllOperations {
	/**
	 * Returns an ArrayList built by all elements of the database that have an
	 * attribute country equals to parameters filtercountry
	 * 
	 * @param database
	 * @param filtercountry
	 * @return the filtered ArrayList
	 */
	protected ArrayList<SingleDomain> CountryFilter(ArrayList<SingleDomain> database, String filtercountry) {
		ArrayList<SingleDomain> filtered = new ArrayList<SingleDomain>();
		for (int i = 0; i < database.size(); i++) {
			if (database.get(i).getCountry().compareToIgnoreCase(filtercountry) == 0)
				filtered.add(database.get(i));
		}
		return filtered;
	}

	/**
	 * Returns an ArrayList built by all elements of the statistic collection that
	 * have an attribute zone equals to parameters filtercountry
	 * 
	 * @param collection
	 * @param filtercountry
	 * @return the filtered ArrayList
	 */
	protected ArrayList<SingleStatistic> ZoneFilter(ArrayList<SingleStatistic> collection, String filtercountry) {
		ArrayList<SingleStatistic> filtered = new ArrayList<SingleStatistic>();
		for (int i = 0; i < collection.size(); i++) {
			if (collection.get(i).getZone().compareToIgnoreCase(filtercountry) == 0)
				filtered.add(collection.get(i));
		}
		return filtered;
	}

	/**
	 * Returns an ArrayList built by all elements of the database that satisfy the
	 * date comparison condition specified by the parameters
	 * 
	 * @param database
	 * @param filterdate
	 * @param field      if true the function analyze the comparison on the
	 *                   attribute createdate, else on the attribute updatedate
	 * @param operation  if true pick the elements with a date bigger than the
	 *                   argument "filterdate", else lower than
	 * @return the filtered ArrayList
	 */
	protected ArrayList<SingleDomain> DateFilter(ArrayList<SingleDomain> database, DateTime filterdate, boolean field,
			boolean operation) {
		ArrayList<SingleDomain> filtered = new ArrayList<SingleDomain>();
		if (operation)
			for (int i = 0; i < database.size(); i++) {
				if (field) {
					if (database.get(i).getCreatedate(true).BiggerThan(filterdate))
						filtered.add(database.get(i));
				} else {
					if (database.get(i).getUpdatedate(true).BiggerThan(filterdate))
						filtered.add(database.get(i));
				}
			}
		else {
			for (int i = 0; i < database.size(); i++) {
				if (field) {
					if (database.get(i).getCreatedate(true).LowerThan(filterdate))
						filtered.add(database.get(i));
				} else {
					if (database.get(i).getUpdatedate(true).LowerThan(filterdate))
						filtered.add(database.get(i));
				}
			}
		}
		return filtered;
	}

	/**
	 * Returns an ArrayList built by all elements of the statistic collection that
	 * satisfy the date comparison condition specified by the parameters
	 * 
	 * @param collection
	 * @param filterdate
	 * @param operation
	 * @return
	 */
	protected ArrayList<SingleStatistic> DateFilter(ArrayList<SingleStatistic> collection, DateTime filterdate,
			boolean operation) {
		ArrayList<SingleStatistic> filtered = new ArrayList<SingleStatistic>();
		if (operation) {
			for (int i = 0; i < collection.size(); i++)
				if (collection.get(i).getDate(true).BiggerThan(filterdate))
					filtered.add(collection.get(i));
		} else
			for (int i = 0; i < collection.size(); i++)
				if (collection.get(i).getDate(true).LowerThan(filterdate))
					filtered.add(collection.get(i));
		return filtered;
	}

	/**
	 * Returns an ArrayList built with elements of the database that satisfy the
	 * comparison between their attribute isdead and the condition represented by
	 * the parameter isDead
	 * 
	 * @param database
	 * @param isDead
	 * @return the filtered ArrayList
	 */
	protected ArrayList<SingleDomain> IsDeadFilter(ArrayList<SingleDomain> database, int isDead) {
		ArrayList<SingleDomain> filtered = new ArrayList<SingleDomain>();
		for (int i = 0; i < database.size(); i++) {
			if (database.get(i).isIsdead() == (isDead == 1))
				filtered.add(database.get(i));
		}
		return filtered;
	}

	/**
	 * It's a method that verifies the filters' correct input and manages possible
	 * errors
	 * 
	 * @param toverify
	 * @throws FilterProblem
	 */
	protected void check(String[] toverify, boolean typefilter) throws FilterProblem {
		if (toverify == null) {
			throw new FilterProblem(
					"There's a filter without any field; check all the possible filters with the root: /getfilters");
		}
		String[] verified = { "country", "minimum_createtime", "maximum_createtime", "minimum_updatetime",
				"maximum_updatetime", "isdead", "zone", "minimum_date", "maximum_date", "increment", "decrement",
				"total" };
		int min = (typefilter ? 0 : 6);
		int max = (typefilter ? 6 : verified.length);
		Boolean[] isthere = { false, false, false, false, false, false, false, false, false, false, false, false };
		for (int i = 0; i < toverify.length; i++) {
			boolean finish = true;
			for (int j = min; j < max && finish; j++) {
				if (verified[j].compareToIgnoreCase(toverify[i]) == 0) {
					finish = false;
					if (isthere[j] == true)
						throw new FilterProblem("The field " + verified[j] + " has been written more times");
					isthere[j]=true;
				}
			}
			if (finish == true) {
				throw new FilterProblem("The field " + toverify[i]
						+ " doesn't exist; check all the possible filters with the root: /getfilters");
			}
		}

	}

	/**
	 * It's a method that verifies the correct date format and manages possible
	 * errors
	 * 
	 * @param tocheck
	 * @throws FilterProblem
	 */
	protected void CheckDate(DateTime tocheck) throws FilterProblem {
		String[] day_hour = tocheck.toString().split(" - ");
		int year = Integer.parseInt(day_hour[0].split("/")[2]);
		int month = Integer.parseInt(day_hour[0].split("/")[1]);
		int day = Integer.parseInt(day_hour[0].split("/")[0]);
		int hour = Integer.parseInt(day_hour[1].split(":")[0]);
		int minute = Integer.parseInt(day_hour[1].split(":")[1].trim());
		LocalDateTime now = LocalDateTime.now();
		int[] DayForMonth = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if (year < 1950 || year > now.getYear()) {
			throw new FilterProblem("Please set an year bigger than 1950 and smaller than this year");
		}
		if (month < 1 || month > 12) {
			throw new FilterProblem("You have setted an unexisting month: " + month);
		}
		if (day < 1 || day > DayForMonth[month - 1]) {
			throw new FilterProblem("You have setted an unexisting day: " + day + " for the month: " + month);
		}
		if (hour < 0 || hour > 23) {
			throw new FilterProblem("You have setted an unexisting hour: " + hour);
		}
		if (minute < 0 || minute > 59) {
			throw new FilterProblem("You have setted an unexisting minute: " + minute);
		}
	}
/**
 * Returns an ArrayList built by all elements of the statistic collection that
 * have a parameter of increment and/or decrement and/or total between minimum and maximum
 * 
 * @param collection
 * @param min
 * @param max
 * @param field
 * @return filtered
 */
	protected ArrayList<SingleStatistic> IntFilter(ArrayList<SingleStatistic> collection, int min, int max, int field) {
		ArrayList<SingleStatistic> filtered = new ArrayList<SingleStatistic>();
		for (int i = 0; i < collection.size(); i++) {
			int num = 0;
			if (field == 1)
				num = collection.get(i).getIncrement();
			else if (field == 2)
				num = collection.get(i).getDecrement();
			else if (field == 3)
				num = collection.get(i).getTotal();
			if (num >= min && num <= max)
				filtered.add(collection.get(i));
		}
		return filtered;
	}
	/**
	 * It's a method that verifies the correct insertion of increment,decrement,total fields and manages possible
	 * errors
	 * @param tocheck
	 * @param field
	 * @throws FilterProblem
	 */
	protected void CheckInt(int[] tocheck, String field) throws FilterProblem {
		for(int i=0;i<tocheck.length;i++) {
			if(tocheck[i]<0)
				throw new FilterProblem("The field "+field+" has a negative value, the filter request only positive value");
		}
	}
}
