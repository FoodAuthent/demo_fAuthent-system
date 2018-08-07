package org.foodauthent.oneworldsync.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.ws.rs.client.WebTarget;

public class HMAC {

	private static final String KEY = 	"d9d4778a6e457267e92c5b499abe2108";

	private static final SecretKeySpec SIGNING_KEY = new SecretKeySpec(KEY.getBytes(), "HmacSHA256");

	public static final WebTarget sign(WebTarget target) throws InvalidKeyException, SignatureException, NoSuchAlgorithmException, UnsupportedEncodingException {
		final String uri = target.getUri().getPath()+"?"+target.getUri().getQuery();
		return target.queryParam("hash_code", calculateRFC2104HMAC(uri));
	}
	
	public static final String calculateRFC2104HMAC(String data) throws java.security.SignatureException,
			java.security.NoSuchAlgorithmException, java.security.InvalidKeyException, UnsupportedEncodingException {
		String result;
		// compute the hmac on input data bytes
		final Mac mac =  Mac.getInstance("HmacSHA256");
		mac.init(SIGNING_KEY);
		byte[] rawHmac = mac.doFinal(data.getBytes());
		// base64-encode the hmac
		result = Base64.getEncoder().encodeToString(rawHmac);
		result = URLEncoder.encode(result.trim(), "UTF-8");
		return result;
	}
}
