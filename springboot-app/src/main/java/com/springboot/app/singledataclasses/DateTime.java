package com.springboot.app.singledataclasses;

/**
 * Representation of a date type
 * 
 * @author Elia Vaccarini
 * @author Federico Di Tullio
 */
public class DateTime {
	/**
	 * the year
	 */
	private int year;
	/**
	 * the month
	 */
	private int month;
	/**
	 * the day
	 */
	private int day;
	/**
	 * the hour
	 */
	private int hour;
	/**
	 * the minute
	 */
	private int minute;

	/**
	 * The DateTime's constructor that required all the parameters to initialize
	 * them
	 * 
	 * @param year
	 * @param month
	 * @param day
	 * @param hour
	 * @param minute
	 */
	public DateTime(int year, int month, int day, int hour, int minute) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.minute = minute;
	}

	/**
	 * Function that leads to get the date in a string format
	 * 
	 * @return the date by string
	 */
	@Override
	public String toString() {
		String dayc = "" + day;
		if (day < 10)
			dayc = "0" + day;
		String monthc = "" + month;
		if (month < 10)
			monthc = "0" + month;
		String hourc = "" + hour;
		if (hour < 10)
			hourc = "0" + hour;
		String minutec = "" + minute;
		if (minute < 10)
			minutec = "0" + minute;
		return dayc + "/" + monthc + "/" + year + " - " + hourc + ":" + minutec + " ";
	}

	/**
	 * This function compares two DateTime
	 * 
	 * @param filterdate
	 * @return true if the object's date is bigger than the argument's date
	 */

	public boolean BiggerThan(DateTime filterdate) {
		if (year > filterdate.year)
			return true;
		if (year == filterdate.year && month > filterdate.month)
			return true;
		if (year == filterdate.year && month == filterdate.month && day > filterdate.day)
			return true;
		if (year == filterdate.year && month == filterdate.month && day == filterdate.day && hour > filterdate.hour)
			return true;
		if (year == filterdate.year && month == filterdate.month && day == filterdate.day && hour == filterdate.hour
				&& minute > filterdate.minute)
			return true;
		return false;
	}

	/**
	 * This function compares two DateTime
	 * 
	 * @param filterdate
	 * @return true if the object's date is lower than the argument's date
	 */
	public boolean LowerThan(DateTime filterdate) {
		if (year < filterdate.year)
			return true;
		if (year == filterdate.year && month < filterdate.month)
			return true;
		if (year == filterdate.year && month == filterdate.month && day < filterdate.day)
			return true;
		if (year == filterdate.year && month == filterdate.month && day == filterdate.day && hour < filterdate.hour)
			return true;
		if (year == filterdate.year && month == filterdate.month && day == filterdate.day && hour == filterdate.hour
				&& minute < filterdate.minute)
			return true;
		return false;
	}
}
