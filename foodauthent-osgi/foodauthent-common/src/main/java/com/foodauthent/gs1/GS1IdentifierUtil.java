package com.foodauthent.gs1;

public class GS1IdentifierUtil {

	public static final int DEFAULT_GCP_LENGTH = 7;

	public static final String EPC_CLASS_LGTIN_URN_PREFIX = "urn:epc:class:lgtin:";

	public static String convertToEpcClass(String gtin, String lot, int gcpLength) {
//		final String sgtin = convertGTINtoSGTIN(gtin, DEFAULT_GCP_LENGTH);
		final String sgtin = convertGTINtoSGTIN(gtin, gcpLength);
		return EPC_CLASS_LGTIN_URN_PREFIX + sgtin + "." + lot;
	}

	public static String convertGTINtoSGTIN(String gtin) {
		return convertGTINtoSGTIN(gtin, DEFAULT_GCP_LENGTH);
	}

	public static String convertGTINtoSGTIN(String gtin, int gcpLength) {
		String theGtin = gtin;
		while (theGtin.length() < 14) {
			theGtin += "0";
		}
		// remove checksum
		theGtin = theGtin.substring(0, theGtin.length() - 1);
		theGtin = theGtin.replaceFirst("^0+(?!$)", "");
		String seperator = ".0";
		if (!gtin.startsWith("0")) {
			seperator = "." + theGtin.charAt(0);
			theGtin = theGtin.substring(1);
		}
		String gtin1 = theGtin.substring(0, gcpLength);
		String gtin2 = theGtin.substring(gcpLength);

		return gtin1 + seperator + gtin2;
	}

	public static String convertSGTINtoGTIN(String sgtin) {
		if (sgtin.indexOf(".") == -1) {
			return sgtin;
		}
		if (sgtin.lastIndexOf(".") == sgtin.indexOf(".")) {
			return sgtin.substring(0, sgtin.indexOf("."));
		}
		String gtin = sgtin.lastIndexOf(".") == sgtin.indexOf(".") ? sgtin : sgtin.substring(0, sgtin.lastIndexOf("."));
		if (gtin.indexOf(".0") != -1) {
			gtin = gtin.replace(".0", "");
		} else if (gtin.indexOf('.') != -1) {
			final char c = gtin.charAt(sgtin.indexOf(".") + 1);
			gtin = c + gtin.replace("." + c, "");
		}
		if (gtin.indexOf('.') != -1) {
			gtin = gtin.substring(0, gtin.lastIndexOf('.'));
		}
		gtin = (gtin.length() < 13 ? "0" : "") + gtin + getChecksum(gtin);
		return gtin;
	}

	public static int getChecksum(String s) {
		if (s.isEmpty()) {
			return 0;
		}
		while (s.length() < 14) {
			s = "0" + s;
		}
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			sum += ((i + 1) % 2 == 0) ? 3 * Integer.parseInt(String.valueOf(s.charAt(i)))
					: Integer.parseInt(String.valueOf(s.charAt(i)));
		}
		int checkDigit = sum % 10;
		checkDigit = (checkDigit > 0) ? 10 - checkDigit : checkDigit;
		return checkDigit;
	}

	public static String getGcp(final String gtin, int gcpLength) {
		String realGcp = gtin;
		while (realGcp.startsWith("0")) {
			realGcp = realGcp.replaceFirst("0", "");
		}
		return realGcp.substring(0, gcpLength);
	}

}
