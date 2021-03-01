package Filtersmanagement;

import com.springboot.app.singledataclasses.DateTime;

public class SingleFilter {
	private String country;
	private DateTime createtimebeg;
	private DateTime createtimeend;
	private DateTime updatedatebeg;
	private DateTime updatedateend;
	private boolean isdead;
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country
	 * @param createtimebeg
	 * @param createtimeend
	 * @param updatedatebeg
	 * @param updatedateend
	 * @param isdead
	 */
	public SingleFilter(String country, DateTime createtimebeg, DateTime createtimeend, DateTime updatedatebeg,	DateTime updatedateend, boolean isdead) {
		super();
		this.country = country;
		this.createtimebeg = createtimebeg;
		this.createtimeend = createtimeend;
		this.updatedatebeg = updatedatebeg;
		this.updatedateend = updatedateend;
		this.isdead = isdead;
	}
	/**
	 * 
	 * @param country2
	 * @param dateTime
	 * @param dateTime2
	 * @param dateTime3
	 * @param dateTime4
	 */
	public SingleFilter(String country2, DateTime dateTime, DateTime dateTime2, DateTime dateTime3, DateTime dateTime4) {
		super();
		this.country = country;
		this.createtimebeg = createtimebeg;
		this.createtimeend = createtimeend;
		this.updatedatebeg = updatedatebeg;
		this.updatedateend = updatedateend;
	}
	/**
	 * @return the createtimebeg
	 */
	public DateTime getCreatetimebeg() {
		return createtimebeg;
	}
	/**
	 * @return the createtimeend
	 */
	public DateTime getCreatetimeend() {
		return createtimeend;
	}
	/**
	 * @return the updatedatebeg
	 */
	public DateTime getUpdatedatebeg() {
		return updatedatebeg;
	}
	/**
	 * @return the updatedateend
	 */
	public DateTime getUpdatedateend() {
		return updatedateend;
	}
	/**
	 * @return the isdead
	 */
	public boolean isIsdead() {
		return isdead;
	}
}
