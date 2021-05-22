package dev.array21.espocrm.client;

public class ClientBuilder {
	private EspoApiClient client = new EspoApiClient();
	
	public ClientBuilder setHost(String host) {
		this.client.url = host;
		return this;
	}
	
	public ClientBuilder setUsername(String username) {
		this.client.username = username;
		return this;
	}
	
	public ClientBuilder setPassword(String password) {
		this.client.password = password;
		return this;
	}
	
	public ClientBuilder apiKey(String apiKey) {
		this.client.apiKey = apiKey;
		return this;
	}
	
	public ClientBuilder secretKey(String secretKey) {
		this.client.secretKey = secretKey;
		return this;
	}
	
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
