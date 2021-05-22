package dev.array21.espocrm.client;

public class RequestException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public RequestException(String error) {
		super(error);
	}
}
