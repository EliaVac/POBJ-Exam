package Filtersmanagement;

import com.springboot.app.singledataclasses.DateTime;

/**
 * The class contains attributes in order to represent a single statistic filter
 * and methods to manage them
 * 
 * @author Federico Di Tullio
 * @author Elia Vaccarini
 */
public class SingleFilterStats {
	/**
	 * the string that identify the zone
	 */
	private String zone;
	/**
	 * the minimum date of records
	 */
	private DateTime minimun_date;
	/**
	 * the maximum date of records
	 */
	private DateTime maximum_date;

	/**
	 * the increment, the decrement and the total range of records
	 */
	private int[] inc, dec, tot;

	/**
	 * The constructor requires all the parameters to initialize them
	 * 
	 * @param zone
	 * @param minimun_date
	 * @param maximum_date
	 * @param inc
	 * @param dec
	 * @param tot
	 */
	public SingleFilterStats(String zone, DateTime minimum_date, DateTime maximum_date, int[] inc, int[] dec,
			int[] tot) {
		super();
		this.zone = zone;
		this.minimun_date = minimun_date;
		this.maximum_date = maximum_date;
		this.inc = inc;
		this.dec = dec;
		this.tot = tot;
	}

	/**
	 * Getters of the string zone
	 * 
	 * @return the zone
	 */
	public String getZone() {
		return zone;
	}

	/**
	 * Getters of the minimum date
	 * 
	 * @return the minimun_date
	 */
	public DateTime getMinimum_date() {
		return minimun_date;
	}

	/**
	 * Getters of the maximum date
	 * 
	 * @return the maximum_date
	 */
	public DateTime getMaximum_date() {
		return maximum_date;
	}

	/**
	 * Getters of the increment range
	 * 
	 * @return the inc
	 */
	public int[] getInc() {
		return inc;
	}

	/**
	 * Getters of the decrement range
	 * 
	 * @return the dec
	 */
	public int[] getDec() {
		return dec;
	}

	/**
	 * Getters of the total range
	 * 
	 * @return the tot
	 */
	public int[] getTot() {
		return tot;
	}

}
