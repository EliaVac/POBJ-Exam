package Errors;

import java.time.LocalDateTime;

import com.springboot.app.singledataclasses.DateTime;

/**
 * Describe a generic error
 * 
 * @author Elia Vaccarini
 * @author Federico Di Tullio
 */
public class ErrorResponse {
	/**
	 * The code of the exception generated
	 */
	private int errorcode;
	/**
	 * The message for a better understanding of the problem
	 */
	private String message;
	/**
	 * The date when the exception is generated
	 */
	private DateTime datetime;

	/**
	 * Initialize the ErrorResponse class with the parameters
	 * 
	 * @param errorcode
	 * @param message
	 */
	public ErrorResponse(int errorcode, String message) {
		this.errorcode = errorcode;
		this.message = message;
		LocalDateTime day = LocalDateTime.now();
		datetime = new DateTime(day.getYear(), day.getMonthValue(), day.getDayOfMonth(), day.getHour(),
				day.getMinute());

	}

	/**
	 * Getters of the errorcode attribute
	 * 
	 * @return the errorcode
	 */
	public int getErrorcode() {
		return errorcode;
	}

	/**
	 * Getters of the message attribute
	 * 
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Getters of the datetime attribute
	 * 
	 * @return the string of the datetime
	 */
	public String getDatetime() {
		return datetime.toString();
	}
}
