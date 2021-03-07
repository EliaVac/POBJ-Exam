package Filtersmanagement;

import com.springboot.app.singledataclasses.DateTime;

/**
 * 
 * @author Federico
 *
 */
public class SingleFilterStats {
	/**
	 * 
	 */
	private String zone;
	/**
	 * 
	 */
	private DateTime minimun_date;
	/**
	 * 
	 */
	private DateTime maximum_date;

	/**
	 * 
	 */
	private int[] inc, dec, tot;

	/**
	 * @param zone
	 * @param minimun_date
	 * @param maximum_date
	 * @param inc
	 * @param dec
	 * @param tot
	 */
	public SingleFilterStats(String zone, DateTime minimun_date, DateTime maximum_date, int[] inc, int[] dec,
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
	 * @return the zone
	 */
	public String getZone() {
		return zone;
	}

	/**
	 * @return the minimun_date
	 */
	public DateTime getMinimun_date() {
		return minimun_date;
	}

	/**
	 * @return the maximum_date
	 */
	public DateTime getMaximum_date() {
		return maximum_date;
	}

	/**
	 * @return the inc
	 */
	public int[] getInc() {
		return inc;
	}

	/**
	 * @return the dec
	 */
	public int[] getDec() {
		return dec;
	}

	/**
	 * @return the tot
	 */
	public int[] getTot() {
		return tot;
	}

}
