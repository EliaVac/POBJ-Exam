package Errors;
/**
 * 
 * @author Federico Di Tullio
 * @author Elia Vaccarini
 */
public class FilterProblem extends Exception {
	/**
	 * The string that identify the message
	 */
	private String message;
	/**
	 * Initialize the message attribute
	 * @param message
	 */
	public FilterProblem(String message) {
		this.message=message;
	}
	/** Getter of the message
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	
}
