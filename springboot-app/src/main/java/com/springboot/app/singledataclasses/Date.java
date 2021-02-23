package com.springboot.app.singledataclasses;
/**
 * Rappresentation of a date type
 * @author Elia Vaccarini
 * @author Federico Di Tullio
 *
 */
public class Date {
	private int year;
	private int month;
    private int day;
    private int hour;
    private int minute;
	/**
	 * @param year
	 * @param month
	 * @param day
	 * @param hour
	 * @param minute
	 */
	public Date(int year, int month, int day, int hour, int minute) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.minute = minute;
	}
	/**
	 * Function that leads to get the date in a format string
	 * @return the date by string
	 */
	@Override
	public String toString() {
		String dayc=""+day;
		if(day<10)
			dayc="0"+day;
		String monthc=""+month;
		if(month<10)
			monthc="0"+month;
		String hourc=""+hour;
		if(hour<10)
			hourc="0"+hour;
		String minutec=""+minute;
		if(minute<10)
			minutec="0"+minute;
		return dayc+"/"+monthc+"/"+year+ " - " + hourc + ":" + minutec+ " ";
	}
}
