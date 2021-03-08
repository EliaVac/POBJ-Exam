/**
 * 
 */
package Errors;

/**
 * Class invoked to handle connection error
 * 
 * @author Federico Di Tullio
 * @author Elia Vaccarini
 */
public class ConnectionProblem extends Exception {
	/**
	 * The string that identifies the message
	 */
	private String message;

	/**
	 * The constructor of the ConnectionProblem class
	 * 
	 * @param message
	 */
	public ConnectionProblem(String message) {
		super(message);
		this.message = message;
	}

	/**
	 * Getters of the message attribute
	 * 
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
}