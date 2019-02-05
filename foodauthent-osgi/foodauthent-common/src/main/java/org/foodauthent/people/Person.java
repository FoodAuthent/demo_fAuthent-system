package org.foodauthent.people;

import java.util.Collection;

public interface Person {

	String getDn();

	String getCommonName();

	void setCommonName(String c);

	String getDescription();

	void setDescription(String c);

	String getLastName();

	void setLastName(String c);

	Collection<String> getSeeAlso();

	void setSeeAlso(Collection<String> c);

	Collection<String> getTelephoneNumber();

	void setTelephoneNumber(Collection<String> c);

	Collection<String> getDestinationIndicator();

	void setDestinationIndicator(Collection<String> c);

	Collection<String> getFacsimileTelephoneNumber();

	void setFacsimileTelephoneNumber(Collection<String> c);

	Collection<Integer> getInternationaliSDNNumber();

	void setInternationaliSDNNumber(Collection<Integer> c);

	Collection<String> getLocalityName();

	void setLocalityName(Collection<String> c);

	String getOrganizationalUnit();

	void setOrganizationalUnit(String c);

	Collection<String> getPhysicalDeliveryOfficeName();

	void setPhysicalDeliveryOfficeName(Collection<String> c);

	Collection<String> getPostOfficeBox();

	void setPostOfficeBox(Collection<String> c);

	Collection<String> getPostalAddress();

	void setPostalAddress(Collection<String> c);

	Collection<String> getPostalCode();

	void setPostalCode(Collection<String> c);

	String getPreferredDeliveryMethod();

	void setPreferredDeliveryMethod(String s);

	Collection<String> getRegisteredAddress();

	void setRegisteredAddress(Collection<String> c);

	Collection<String> getStateOrProvinceName();

	void setStateOrProvinceName(Collection<String> c);

	Collection<String> getStreet();

	void setStreet(Collection<String> c);

	Collection<String> getTeletexTerminalIdentifier();

	void setTeletexTerminalIdentifier(Collection<String> c);

	Collection<byte[]> getTelexNumber();

	void setTelexNumber(Collection<byte[]> c);

	Collection<String> getTitle();

	void setTitle(Collection<String> c);

	Collection<Integer> getX121Address();

	void setX121Address(Collection<Integer> c);

	Collection<byte[]> getAudio();

	void setAudio(Collection<byte[]> c);

	String getBusinessCategory();

	void setBusinessCategory(String c);

	Collection<String> getCarLicense();

	void setCarLicense(Collection<String> c);

	Collection<String> getDepartmentNumber();

	void setDepartmentNumber(Collection<String> c);

	String getDisplayName();

	void setDisplayName(String s);

	String getEmployeeNumber();

	void setEmployeeNumber(String s);

	String getEmployeeType();

	void setEmployeeType(String c);

	String getGivenName();

	void setGivenName(String c);

	Collection<String> getHomePhone();

	void setHomePhone(Collection<String> c);

	Collection<String> getHomePostalAddress();

	void setHomePostalAddress(Collection<String> c);

	Collection<String> getInitials();

	void setInitials(Collection<String> c);

	Collection<byte[]> getJpegPhoto();

	void setJpegPhoto(Collection<byte[]> c);

	Collection<String> getLabeledURI();

	void setLabeledURI(Collection<String> c);

	Collection<String> getMail();

	void setMail(Collection<String> c);

	Collection<String> getManager();

	void setManager(Collection<String> c);

	Collection<String> getMobile();

	void setMobile(Collection<String> c);

	String getOrganization();

	void setOrganization(String c);

	Collection<String> getPager();

	void setPager(Collection<String> c);

	Collection<byte[]> getPhoto();

	void setPhoto(Collection<byte[]> c);

	String getPreferredLanguage();

	void setPreferredLanguage(String s);

	Collection<String> getRoomNumber();

	void setRoomNumber(Collection<String> c);

	Collection<String> getSecretary();

	void setSecretary(Collection<String> c);

	String getUserName();

	void setUserName(String c);


}