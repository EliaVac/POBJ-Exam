package Filtersmanagement;

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
	protected void check(String[] toverify ) throws FilterProblem {
		String[] verified= {"country","minimum_createtime", "maximum_createtime", "minimum_updatetime",
				"maximum_updatetime","isdead"};
		Boolean[] isthere= {false,false,false,false,false,false};
		for(int i=0;i<toverify.length; i++) {
			boolean finish=true;
			for(int j=0;j<6&&finish;i++) {
				if(verified[j].compareTo(toverify[i])==0) {
					finish=false;
					if(isthere[j]==true)
						throw new FilterProblem("The field "+verified[j]+" has been written more times");
				}
			}
			if(finish==true) {
				throw new FilterProblem("The field "+toverify[i]+" doesn't exist; check all the possible filters with the root: /getfilters");
			}
		}
			
	}
}
