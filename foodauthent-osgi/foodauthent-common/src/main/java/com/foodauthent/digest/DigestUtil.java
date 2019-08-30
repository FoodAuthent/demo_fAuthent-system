package com.foodauthent.digest;

import java.io.InputStream;
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
		return toHex(digest.digest());
	}
	
	public static final String toHex(byte[] bytes) {
		final String hex = DatatypeConverter.printHexBinary(bytes).toLowerCase();
		return hex;
	}

}
