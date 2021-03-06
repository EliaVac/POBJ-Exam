package com.springboot.app.singledataclasses;

/**
 * 
 * @author Federico
 *
 */
public class SingleStatistic {
	/**
	 * The string that identify the zone
	 */
	private String zone;
	/**
	 * The Report Date
	 */
	private DateTime date;
	/**
	 * The increment
	 */
	private int increment;
	/**
	 * The decrement
	 */
	private int decrement;
	/**
	 * The total number of records
	 */
	private int total;

	/**
	 * The SingleStatistic's constructor that required all the parameters to initialize
	 * them
	 * @param zone
	 * @param data
	 * @param increment
	 * @param decrement
	 * @param total
	 */
	public SingleStatistic(String zone, DateTime date, int increment, int decrement, int total) {
		super();
		this.zone = zone;
		this.date = date;
		this.increment = increment;
		this.decrement = decrement;
		this.total = total;
	}

	/**
	 * Getters of the zone
	 * @return the zone
	 */
	public String getZone() {
		return zone;
	}

	/**
	 * Getters of the date's string
	 * @return the date string
	 */
	public String getDate() {
		return date.toString();
	}

	/**
	 * Getters of the date's object
	 * @return the date
	 */
	public DateTime getDate(boolean check) {
		return date;
	}

	/**
	 * Getters of the increment
	 * @return the increment
	 */
	public int getIncrement() {
		return increment;
	}

	/**
	 * Getters of the decrement
	 * @return the decrement
	 */
	public int getDecrement() {
		return decrement;
	}

	/**
	 * Getters of the total of records
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}

}
