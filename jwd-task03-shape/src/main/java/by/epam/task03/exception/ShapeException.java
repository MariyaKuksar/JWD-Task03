package by.epam.task03.exception;

public class ShapeException extends Exception {
	private static final long serialVersionUID = 1L;

	public ShapeException() {
	}

	public ShapeException(String message, Throwable cause) {
		super(message, cause);
	}

	public ShapeException(String message) {
		super(message);
	}

	public ShapeException(Throwable cause) {
		super(cause);
	}

}
