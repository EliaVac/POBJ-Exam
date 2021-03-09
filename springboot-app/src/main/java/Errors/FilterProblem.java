package Errors;

/**
 * Class invoked to handle filter error
 * 
 * @author Federico Di Tullio
 * @author Elia Vaccarini
 */
public class FilterProblem extends Exception {
	/**
	 * The serial version
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * The string that identifies the message
	 */
	private String message;

	/**
	 * The constructor initializes the message attribute
	 * 
	 * @param message
	 */
	public FilterProblem(String message) {
		this.message = message;
	}

	/**
	 * Getters of the message
	 * 
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

}
