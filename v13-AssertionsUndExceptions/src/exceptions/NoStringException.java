package exceptions;

public class NoStringException extends StringClipException {

	public NoStringException() {}

	public NoStringException(String message) {
		super(message);
	}
}
