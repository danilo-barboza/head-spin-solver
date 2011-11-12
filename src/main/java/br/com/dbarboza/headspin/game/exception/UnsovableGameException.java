package br.com.dbarboza.headspin.game.exception;

public class UnsovableGameException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UnsovableGameException() {
	}

	public UnsovableGameException(String message) {
		super(message);
	}

	public UnsovableGameException(Throwable cause) {
		super(cause);
	}

	public UnsovableGameException(String message, Throwable cause) {
		super(message, cause);
	}

}
