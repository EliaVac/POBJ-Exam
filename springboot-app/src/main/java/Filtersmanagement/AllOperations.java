package Filtersmanagement;

import java.util.ArrayList;

import com.springboot.app.singledataclasses.DateTime;
import com.springboot.app.singledataclasses.SingleDomain;

public class AllOperations {
	public ArrayList<SingleDomain> CountryFilter(ArrayList<SingleDomain> database, String filtercountry) {
		ArrayList<SingleDomain> filtered = new ArrayList<SingleDomain>();
		for (int i = 0; i < database.size(); i++) {
			if (database.get(i).getCountry().compareTo(filtercountry) == 0)
				filtered.add(database.get(i));
		}
		return filtered;
	}

	/**
	 *
	 * @param database
	 * @param filterdate
	 * @param field
	 * @param operation
	 * @return
	 */
	public ArrayList<SingleDomain> DateFilter(ArrayList<SingleDomain> database, DateTime filterdate, boolean field,
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
	public ArrayList<SingleDomain> IsDeadFilter(ArrayList<SingleDomain> database, int isDead){
		ArrayList<SingleDomain> filtered = new ArrayList<SingleDomain>();
		for (int i=0; i<database.size(); i++) {
			if (database.get(i).isIsdead()== (isDead==1?true:false))
			filtered.add(database.get(i));
		}
		return filtered;
	
}
}
		
