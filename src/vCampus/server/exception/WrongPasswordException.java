package vCampus.server.exception;

public class WrongPasswordException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4L;

	public String getMessage() {
		return new String("WrongPassword");
	}
}
