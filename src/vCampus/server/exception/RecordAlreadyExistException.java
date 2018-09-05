package vCampus.server.exception;

public class RecordAlreadyExistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	
	public String getMessage() {
		return new String("RecordAlreadyExist");
	}
}
