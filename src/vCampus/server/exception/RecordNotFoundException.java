package vCampus.server.exception;


public class RecordNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;
	
	public String getMessage() {
		return new String("RecordNotFound");
	}
}
