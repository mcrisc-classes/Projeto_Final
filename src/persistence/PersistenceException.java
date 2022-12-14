package persistence;

public class PersistenceException extends Exception {
	private static final long serialVersionUID = 1L;

	public PersistenceException(Throwable cause) {
		super(cause);
	}

	public PersistenceException(String message) {
		super(message);
	}
}
