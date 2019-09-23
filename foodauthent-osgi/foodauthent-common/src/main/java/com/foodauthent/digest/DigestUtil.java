package com.foodauthent.digest;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class DigestUtil {
	
	public static final String SHA256 = "SHA-256";
	
	public static final DigestInputStream sha256DigestInputStream(InputStream in) throws NoSuchAlgorithmException {
		if (in != null) {
			final MessageDigest messageDigest = MessageDigest.getInstance(SHA256);
			final DigestInputStream digestInputStream = new DigestInputStream(in, messageDigest);
			return digestInputStream;
		}
		return null;
	}

	public static final String toHex(MessageDigest digest) {
		final String hex = DatatypeConverter.printHexBinary(digest.digest()).toLowerCase();
		return hex;
	}
	
	public static final String sha256(String s) throws NoSuchAlgorithmException {
		final MessageDigest messageDigest = MessageDigest.getInstance(SHA256);
		return DatatypeConverter.printHexBinary(messageDigest.digest(s.getBytes(StandardCharsets.UTF_8))).toLowerCase();
	}

}
