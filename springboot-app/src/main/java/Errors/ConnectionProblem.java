/**
 * 
 */
package Errors;

/**
 * @author Federico
 *
 */
public class ConnectionProblem extends Exception {

	/**
	 * 
	 */
	public ConnectionProblem() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public ConnectionProblem(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public ConnectionProblem(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ConnectionProblem(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ConnectionProblem(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
