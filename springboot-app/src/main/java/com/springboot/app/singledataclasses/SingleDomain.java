package com.springboot.app.singledataclasses;

public class SingleDomain {
	private String domain;
	private String country;
	private Date createdate;
	private Date updatedate;
	private boolean isdead;
	/**
	 * @param domain
	 * @param country
	 * @param createdate
	 * @param updatedate
	 * @param isdead
	 */
	public SingleDomain(String domain, String country, Date createdate, Date updatedate, boolean isdead) {
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
	/**
	 * @return the updatedate
	 */
	public String getUpdatedate() {
		return updatedate.toString();
	}
	/**
	 * @return the isdead
	 */
	public boolean isIsdead() {
		return isdead;
	}
	
}
