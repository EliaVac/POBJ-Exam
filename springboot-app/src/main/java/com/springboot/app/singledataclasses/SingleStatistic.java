package com.springboot.app.singledataclasses;

public class SingleStatistic {
	private String zone;
	private DateTime date;
	private int increment;
	private int decrement;
	private int total;
	/**
	 * @param zone
	 * @param data
	 * @param increment
	 * @param decrement
	 * @param total
	 */
	public SingleStatistic(String zone, DateTime data, int increment, int decrement, int total) {
		super();
		this.zone = zone;
		this.date = data;
		this.increment = increment;
		this.decrement = decrement;
		this.total = total;
	}
	/**
	 * @return the zone
	 */
	public String getZone() {
		return zone;
	}
	/**
	 * @return the date string
	 */
	public String getDate() {
		return date.toString();
	}
	/**
	 * 
	 * @return the date
	 */
	public DateTime getDate(boolean check) {
		return date;
	}
	/**
	 * @return the increment
	 */
	public int getIncrement() {
		return increment;
	}
	/**
	 * @return the decrement
	 */
	public int getDecrement() {
		return decrement;
	}
	/**
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}
	

}
