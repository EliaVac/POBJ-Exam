package com.springboot.app.singledataclasses;
/**
 * The class contains attributes in order to represent a domain and methods to manage them   
 * @author Federico Di Tullio
 * @author Elia Vaccarini
 */

public class SingleDomain {
	private String domain;
	private String country;
	private DateTime createdate;
	private DateTime updatedate;
	private boolean isdead;
	/**
	 * @param domain
	 * @param country
	 * @param createdate
	 * @param updatedate
	 * @param isdead
	 */
	public SingleDomain(String domain, String country, DateTime createdate, DateTime updatedate, boolean isdead) {
		super();
		this.domain = domain;
		this.country = country;
		this.createdate = createdate;
		this.updatedate = updatedate;
		this.isdead = isdead;
}
	/**
	 * @return the domain
	 */
	public String getDomain() {
		return domain;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	 }
	/**
	 * @return the createdate
	 */
	public String getCreatedate() {
		return createdate.toString();
	}
	public DateTime getCreatedate(boolean check) {
		return createdate;
	}
	/**
	 * @return the updatedate
	 */
	public String getUpdatedate() {
		return updatedate.toString();
	}
	public DateTime getUpdatedate(boolean check) {
		return updatedate;
	}
	/**
	 * @return the isdead
	 */
	public boolean isIsdead() {
		return isdead;
	}
	
}
