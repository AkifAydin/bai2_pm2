package exceptions;

public class StringClipException extends Exception {

	public StringClipException() {
	}

	public StringClipException(String message) {
		super(message);
	}

	/*
	 * 	Muss den „Wrapper“ Konstruktor für Throwables anbieten
	 *  
	 */
	public StringClipException(Throwable cause) {
		super(cause);
	}
}
