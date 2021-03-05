package Filtersmanagement;

import java.time.LocalDateTime;
import java.util.ArrayList;

import com.springboot.app.singledataclasses.DateTime;
import com.springboot.app.singledataclasses.SingleDomain;

import Errors.FilterProblem;

/**
 * Define all possible filtering operations
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
			if (database.get(i).getCountry().compareTo(filtercountry) == 0)
				filtered.add(database.get(i));
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

	protected void check(String[] toverify) throws FilterProblem {
		if (toverify == null) {
			throw new FilterProblem(
					"There's a filter without any field; check all the possible filters with the root: /getfilters");
		}
		String[] verified = { "country", "minimum_createtime", "maximum_createtime", "minimum_updatetime",
				"maximum_updatetime", "isdead" };
		Boolean[] isthere = { false, false, false, false, false, false };
		for (int i = 0; i < toverify.length; i++) {
			boolean finish = true;
			for (int j = 0; j < 6 && finish; j++) {
				if (verified[j].compareTo(toverify[i]) == 0) {
					finish = false;
					if (isthere[j] == true)
						throw new FilterProblem("The field " + verified[j] + " has been written more times");
				}
			}
			if (finish == true) {
				throw new FilterProblem("The field " + toverify[i]
						+ " doesn't exist; check all the possible filters with the root: /getfilters");
			}
		}

	}
	protected void CheckDate(DateTime tocheck) throws FilterProblem {
		String[] day_hour=tocheck.toString().split(" - ");
		int year=Integer.parseInt(day_hour[0].split("/")[2]);
		int month=Integer.parseInt(day_hour[0].split("/")[1]);
		int day=Integer.parseInt(day_hour[0].split("/")[0]);
		int hour=Integer.parseInt(day_hour[1].split(":")[0]);
		int minute=Integer.parseInt(day_hour[1].split(":")[1]);
		LocalDateTime now = LocalDateTime.now();
		int[] DayForMonth = {31,29,31,30,31,30,31,31,30,31,30,31};
		if(year<1950||year>now.getYear())
			throw new FilterProblem("Please set an year bigger than 1950 and smaller than this year");
		if(month<1||month>12)
			throw new FilterProblem("You have setted an unexisting month: "+month);
		if(day<1||day>DayForMonth[month])
			throw new FilterProblem("You have setted an unexisting day: "+day+" for the month: "+month);
		if(hour<0||hour>23)
			throw new FilterProblem("You have setted an unexisting hour: "+hour);
		if(minute<0||minute>59)
			throw new FilterProblem("You have setted an unexisting minute: "+minute);		
	}
}
