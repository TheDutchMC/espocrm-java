package dev.array21.espocrm.client;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import com.google.gson.Gson;

import dev.array21.espocrm.Serializer;
import dev.array21.espocrm.types.Method;
import dev.array21.espocrm.types.Params;
import nl.thedutchmc.httplib.Http;
import nl.thedutchmc.httplib.Http.MediaFormat;
import nl.thedutchmc.httplib.Http.RequestMethod;
import nl.thedutchmc.httplib.Http.ResponseObject;

public class EspoApiClient {
	protected String url, username, password, apiKey, secretKey;
	private final String urlPath = "";
	private final Gson gson = new Gson();
	
	private String normalizeUrl(String action) {
		return String.format("%s%s%s", this.url, this.urlPath, action);
	}
	
	public String requestGet(String action, Params params) throws InvalidKeyException, IOException, RequestException {
		return this.request(Method.GET, action, params, null);
	}
	
	public <T> String request(Method method, String action, T payload) throws InvalidKeyException, IOException, RequestException {
		return this.request(method, action, null, payload);
	}
	
	private <T> String request(Method method, String action, Params params, T payload) throws InvalidKeyException, IOException, RequestException {
		String url = normalizeUrl(this.url);
		
		if(params != null && method == Method.POST) {
			url = String.format("%s?%s", url, Serializer.serialize(params));
		}
		
		HashMap<String, String> headers = new HashMap<>();
		
		if(this.username != null && this.password != null) {
			String authString = URLEncoder.encode(String.format("%s:%s", this.username, this.password), StandardCharsets.UTF_8);
			headers.put("Authorization", String.format("Basic %s", Base64.getEncoder().encodeToString(authString.getBytes())));

		} else if(this.apiKey != null && this.secretKey != null) {
			headers.put("X-Hmac-Authorization", getHmacAuthorization(method, action));
		
		} else if(this.apiKey != null && this.secretKey == null) {
			headers.put("X-Api_key", this.apiKey);
		}
		
		ResponseObject responseObject;
		if(payload != null && method != Method.GET) {
			responseObject = new Http().makeRequest(toRequestMethod(method), url, null, MediaFormat.JSON, this.gson.toJson(payload), headers);
		} else {
			responseObject = new Http().makeRequest(toRequestMethod(method), url, null, null, null, headers);
		}
		
		if(responseObject.getResponseCode() != 200) {
			throw new RequestException(responseObject.getConnectionMessage());
		}
		
		return responseObject.getMessage();
	}
	
	private String getHmacAuthorization(Method method, String path) throws InvalidKeyException {
		//Setup the hashing algorithm
		Mac sha256_HMAC = null;
		try {
			sha256_HMAC = Mac.getInstance("HmacSHA256");
			SecretKeySpec secretKey = new SecretKeySpec(this.secretKey.getBytes(), "HmacSHA256");
			sha256_HMAC.init(secretKey);
		} catch (NoSuchAlgorithmException e) {
			// We don't need to handle this exception, since the `HmacSHA256` algorithm is always there
		}
		
		//Get the hash
		//Compose of (method + ' /' + path)
		//Where method: GET, POST etc
		//Where path: Account, Contact etc
		byte[] hash = sha256_HMAC.doFinal((method.toString() + " /" + path).getBytes());
		
		//Compose the final list of Bytes
		//Compose of apiKey + ':' + hash
		//String#getBytes() returns a byte[], so we first have to turn it into
		//a Byte[], then put it in a List<Byte> before we can add it.
		List<Byte> hmacBytes = new ArrayList<>();
		hmacBytes.addAll(Arrays.asList(toObject((this.apiKey + ":").getBytes())));
		hmacBytes.addAll(Arrays.asList(toObject(hash)));
		
		//Get the final hmacAuthorization value
		//First turn the hmacBytes<Byte> into a byte[],
		//Then encode it as base64
		String hmacAuthorization = Base64.getEncoder().encodeToString(toPrimitive(hmacBytes.toArray(new Byte[0])));
		
		//Finally return that base64 String
		return hmacAuthorization;
	}
	
    private static Byte[] toObject(final byte[] array) {
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return new Byte[0];
        }
        final Byte[] result = new Byte[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = Byte.valueOf(array[i]);
        }
        return result;
    }
    
    private static byte[] toPrimitive(final Byte[] array) {
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return new byte[0];
        }
        final byte[] result = new byte[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i].byteValue();
        }
        return result;
    }
    
    private RequestMethod toRequestMethod(Method method) {
    	switch(method) {
	    	case GET:return RequestMethod.GET;
			case DELETE: return RequestMethod.DELETE;
			case POST: return RequestMethod.POST;
			case PUT: return RequestMethod.PUT;
			default: 
				return null;
    	}
    }
}
