package org.foodauthent.people;

import java.util.List;

public interface Organization {

	String getDn();

	String getBusinessCategory();

	void setBusinessCategory(String c);

	String getDescription();

	void setDescription(String c);

	String getDestinationIndicator();

	void setDestinationIndicator(String c);

	List<String> getFacsimileTelephoneNumber();

	void setFacsimileTelephoneNumber(List<String> c);

	String getLocalityName();

	void setLocalityName(String c);

	String getName();

	void setName(String c);

	String getPhysicalDeliveryOfficeName();

	void setPhysicalDeliveryOfficeName(String c);

	String getPostOfficeBox();

	void setPostOfficeBox(String c);

	List<String> getPostalAddress();

	void setPostalAddress(List<String> c);

	String getPostalCode();

	void setPostalCode(String c);

	String getPreferredDeliveryMethod();

	void setPreferredDeliveryMethod(String s);

	List<String> getRegisteredAddress();

	void setRegisteredAddress(List<String> c);

	List<String> getSearchGuide();

	void setSearchGuide(List<String> c);

	List<String> getSeeAlso();

	void setSeeAlso(List<String> c);

	String getStateOrProvinceName();

	void setStateOrProvinceName(String c);

	List<String> getStreet();

	void setStreet(List<String> c);

	List<String> getTelephoneNumber();

	void setTelephoneNumber(List<String> c);

	String toString();

}