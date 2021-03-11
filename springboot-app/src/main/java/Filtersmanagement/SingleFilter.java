package Filtersmanagement;

import java.util.Objects;

import com.springboot.app.singledataclasses.DateTime;

/**
 * The class contains attributes in order to represent a single filter and
 * methods to manage them
 * 
 * @author Elia Vaccarini
 * @author Federico Di Tullio
 */
public class SingleFilter {
	/**
	 * the string that identifies country
	 */
	private String country;
	/**
	 * the lower end date range when the country is created
	 */
	private DateTime createtimebeg;
	/**
	 * the extreme upper date range when the country is created
	 */
	private DateTime createtimeend;
	/**
	 * the lower end date range when the country is updated
	 */
	private DateTime updatedatebeg;
	/**
	 * the extreme upper date range when the country is updated
	 */
	private DateTime updatedateend;
	/**
	 * the filter's condition of the domain's state, if true it's dead, else it is
	 * alive
	 */
	private int isdead;

	/**
	 * The constructor requires all the parameters to initialize them
	 * 
	 * @param country
	 * @param createtimebeg
	 * @param createtimeend
	 * @param updatedatebeg
	 * @param updatedateend
	 * @param isdead
	 */
	public SingleFilter(String country, DateTime createtimebeg, DateTime createtimeend, DateTime updatedatebeg,
			DateTime updatedateend, int isdead) {
		super();
		this.country = country;
		this.createtimebeg = createtimebeg;
		this.createtimeend = createtimeend;
		this.updatedatebeg = updatedatebeg;
		this.updatedateend = updatedateend;
		this.isdead = isdead;
	}

	/**
	 * Getters of the country string of the filter
	 * 
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Getters of the the lower end date range when the country is created
	 * 
	 * @return the createtimebeg
	 */
	public DateTime getCreatetimebeg() {
		return createtimebeg;
	}

	/**
	 * Getters of the extreme upper date range when the country is created
	 * 
	 * @return the createtimeend
	 */
	public DateTime getCreatetimeend() {
		return createtimeend;
	}

	/**
	 * Getters of the lower end date range when the country is updated
	 * 
	 * @return the updatedatebeg
	 */
	public DateTime getUpdatedatebeg() {
		return updatedatebeg;
	}

	/**
	 * Getters of the extreme upper date range when the country is updated
	 * 
	 * @return the updatedateend
	 */
	public DateTime getUpdatedateend() {
		return updatedateend;
	}

	/**
	 * Getters of the filter's condition of the domain's state
	 * 
	 * @return the isdead
	 */
	public int isIsdead() {
		return isdead;
	}

	/**
	 * This function return a boolean that permit to verify if the object inserted
	 * as parameter matches to our object
	 * 
	 * @param obj
	 * @return true if the objects matches
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SingleFilter other = (SingleFilter) obj;
		return Objects.equals(country, other.country) && Objects.equals(createtimebeg, other.createtimebeg)
				&& Objects.equals(createtimeend, other.createtimeend) && isdead == other.isdead
				&& Objects.equals(updatedatebeg, other.updatedatebeg)
				&& Objects.equals(updatedateend, other.updatedateend);
	}

}
