package vCampus.server.exception;

public class OutOfLimitException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getMessage() {
		return new String("OutOfLimit");
	}
}
