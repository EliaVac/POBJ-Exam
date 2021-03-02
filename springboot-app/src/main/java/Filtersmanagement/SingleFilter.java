package Filtersmanagement;

import com.springboot.app.singledataclasses.DateTime;

public class SingleFilter {
	private String country;
	private DateTime createtimebeg;
	private DateTime createtimeend;
	private DateTime updatedatebeg;
	private DateTime updatedateend;
	private int isdead;
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
	public SingleFilter(String country, DateTime createtimebeg, DateTime createtimeend, DateTime updatedatebeg,	DateTime updatedateend, int isdead) {
		super();
		this.country = country;
		this.createtimebeg = createtimebeg;
		this.createtimeend = createtimeend;
		this.updatedatebeg = updatedatebeg;
		this.updatedateend = updatedateend;
		this.isdead = isdead;
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
	public int isIsdead() {
		return isdead;
	}
}
