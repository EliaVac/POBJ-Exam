package com.springboot.app.singledataclasses;

/**
 * The class contains attributes in order to represent a domain and methods to
 * manage them
 * 
 * @author Federico Di Tullio
 * @author Elia Vaccarini
 */

public class SingleDomain {
	/**
	 * the string that identify the domain
	 */
	private String domain;
	/**
	 * the country of the domain
	 */
	private String country;
	/**
	 * the date when the domain is created
	 */
	private DateTime createdate;
	/**
	 * the last date when the domain is updated
	 */
	private DateTime updatedate;
	/**
	 * the domain's state if true it's dead, else is alive
	 */
	private boolean isdead;

	/**
	 * The constructor requires all the parameters to initialize them
	 * 
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
	 * Getters of the domain
	 * 
	 * @return the domain
	 */
	public String getDomain() {
		return domain;
	}

	/**
	 * Getters of the country
	 * 
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Getters of the createdate's string
	 * 
	 * @return the createdate
	 */
	public String getCreatedate() {
		return createdate.toString();
	}

	/**
	 * Getters of the createdate's object
	 * 
	 * @param check
	 * @return the createdate
	 */
	public DateTime getCreatedate(boolean check) {
		return createdate;
	}

	/**
	 * Getters of the updatedate's string
	 * 
	 * @return the updatedate
	 */
	public String getUpdatedate() {
		return updatedate.toString();
	}

	/**
	 * Getters of the updatedate's object
	 * 
	 * @param check
	 * @return the updatedate
	 */
	public DateTime getUpdatedate(boolean check) {
		return updatedate;
	}

	/**
	 * Getters of isdead, that identify the status of the domain
	 * 
	 * @return the isdead
	 */
	public boolean isIsdead() {
		return isdead;
	}

}
