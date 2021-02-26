package Errors;

/** Class invoked to handle JSON error
 * @author Federico Di Tullio	
 * @author Elia Vaccarini
 */
public class JSONProblem extends Exception{
	/** 
	 * The string that identify the message
	 */
	private String message;
	/**The constructor of the JSONProblem class
	 * @param message
	 */
	public JSONProblem(String message) {
		super(message);
		this.message=message;
	}
	/**Getters of the message attribute
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
}
