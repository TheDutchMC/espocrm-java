package dev.array21.espocrm.client;

/**
 * Builder for the EspoApiClient
 * @author Tobias de Bruijn
 * @since 1.0.0
 */
public class ClientBuilder {
	private EspoApiClient client = new EspoApiClient();
	
	/**
	 * Set the EspoCRM URL
	 * @param host The host
	 * @return Returns an instance of ClientBuilder for easy chaining
	 */
	public ClientBuilder setHost(String host) {
		if(host.endsWith("/")) {
			host = host.substring(0, host.length() - 1);
		}
		
		this.client.url = host;
		return this;
	}
	
	/**
	 * Set the username to use for authentication. You must also call {@link #setPassword(String)}<br>
	 * <br>
	 * <strong>It is highly discouraged to use this method of authentication. You should prefer to authenticate with an API key or with HMAC authentication</strong>
	 * @param username The username
	 * @return Returns an instance of ClientBuilder for easy chaining
	 */
	public ClientBuilder setUsername(String username) {
		this.client.username = username;
		return this;
	}
	
	/**
	 * Set the password to use for authentication. You must also call {@link #setUsername(String)}<br>
	 * <br>
	 * <strong>It is highly discouraged to use this method of authentication. You should prefer to authenticate with an API key or with HMAC authentication</strong>
	 * @param username The username
	 * @return Returns an instance of ClientBuilder for easy chaining
	 */
	public ClientBuilder setPassword(String password) {
		this.client.password = password;
		return this;
	}
	
	/**
	 * Set the API key to use for authentication. If you wish to use HMAC authentication, you must also call {@link #setSecretKey(String)}
	 * @param apiKey The apiKey
	 * @return Returns an instance of ClientBuilder for easy chaining
	 */
	public ClientBuilder setApiKey(String apiKey) {
		this.client.apiKey = apiKey;
		return this;
	}
	
	/**
	 * Set the secret key to use for authentication. You must also call {@link #setApiKey(String)}
	 * @param secretKey The secret key
	 * @return Returns an instance of ClientBuilder for easy chaining
	 */
	public ClientBuilder setSecretKey(String secretKey) {
		this.client.secretKey = secretKey;
		return this;
	}
	
	/**
	 * Create an instance of EspoApiClient from this builder. This will perform validation checks.
	 * @return Returns the EspoApiClient built from this ClientBuilder instance
	 * @throws IllegalStateException When the validation check fails
	 */
	public EspoApiClient build() {
		if(this.client.username != null && this.client.password == null) {
			throw new IllegalStateException("Client's username is set, but the password is not.");
		}
		
		if(this.client.password != null && this.client.username == null) {
			throw new IllegalStateException("Client's password is set, but the username is not.");
		}
		
		if(this.client.secretKey != null && this.client.apiKey == null) {
			throw new IllegalStateException("Client's secretKey is set, but the apiKey is not.");
		}
		
		return this.client;
	}
}
