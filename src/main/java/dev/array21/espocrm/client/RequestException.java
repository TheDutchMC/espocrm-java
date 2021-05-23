package dev.array21.espocrm.client;

/**
 * This exception is thrown when we receive a non-200 HTTP status code from EspoCRM
 * @author Tobias de Bruijn
 * @since 1.0.0
 */
public class RequestException extends Exception {
	private static final long serialVersionUID = 1L;
	private int statusCode;
	
	public RequestException(int statusCode, String error) {
		super(error);
		this.statusCode = statusCode;
	}
	
	/**
	 * The HTTP status code returned by EspoCRM
	 * @return The HTTP status code
	 */
	public int getStatusCode() {
		return this.statusCode;
	}
}
