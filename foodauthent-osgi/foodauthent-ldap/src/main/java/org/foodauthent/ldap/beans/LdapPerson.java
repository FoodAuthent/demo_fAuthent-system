package org.foodauthent.ldap.beans;

import java.security.cert.Certificate;
import java.util.Collection;
import java.util.Collections;

import org.foodauthent.ldap.DnUtil;
import org.foodauthent.people.Person;
import org.ldaptive.LdapUtils;
import org.ldaptive.beans.Attribute;
import org.ldaptive.beans.Entry;

@Entry(dn = "dn", attributes = { //
		@Attribute(name = "objectClass", values = { "inetOrgPerson", "organizationalPerson", "person", "top" }), //
		@Attribute(name = "cn", property = "commonName"), //
		@Attribute(name = "description"), //
		@Attribute(name = "sn", property = "lastName"), //
		@Attribute(name = "seeAlso"), //
		@Attribute(name = "telephoneNumber"), // //
		@Attribute(name = "destinationIndicator"), //
		@Attribute(name = "facsimileTelephoneNumber"), //
		@Attribute(name = "internationaliSDNNumber"), //
		@Attribute(name = "l", property = "localityName"), //
		@Attribute(name = "ou", property = "organizationalUnit"), //
		@Attribute(name = "physicalDeliveryOfficeName"), //
		@Attribute(name = "postOfficeBox"), //
		@Attribute(name = "postalAddress"), //
		@Attribute(name = "postalCode"), //
		@Attribute(name = "preferredDeliveryMethod"), //
		@Attribute(name = "registeredAddress"), //
		@Attribute(name = "st", property = "stateOrProvinceName"), //
		@Attribute(name = "street"), //
		@Attribute(name = "teletexTerminalIdentifier"), //
		@Attribute(name = "telexNumber", binary = true), //
		@Attribute(name = "title"), //
		@Attribute(name = "x121Address"), // //
		@Attribute(name = "audio", binary = true), //
		@Attribute(name = "businessCategory"), //
		@Attribute(name = "carLicense"), //
		@Attribute(name = "departmentNumber"), //
		@Attribute(name = "displayName"), //
		@Attribute(name = "employeeNumber"), //
		@Attribute(name = "employeeType"), //
		@Attribute(name = "givenName"), //
		@Attribute(name = "homePhone"), //
		@Attribute(name = "homePostalAddress"), //
		@Attribute(name = "initials"), //
		@Attribute(name = "jpegPhoto", binary = true), //
		@Attribute(name = "labeledURI"), //
		@Attribute(name = "mail"), //
		@Attribute(name = "manager"), //
		@Attribute(name = "mobile"), //
		@Attribute(name = "o", property = "organization"), //
		@Attribute(name = "pager"), //
		@Attribute(name = "photo", binary = true), //
		@Attribute(name = "preferredLanguage"), //
		@Attribute(name = "roomNumber"), //
		@Attribute(name = "secretary"), //
		@Attribute(name = "uid", property = "userName"), //
		@Attribute(name = "userCertificate"), //
		@Attribute(name = "userPKCS12", binary = true), //
		@Attribute(name = "userSMIMECertificate", binary = true), //
		@Attribute(name = "x500UniqueIdentifier")

})
public class LdapPerson implements Dn, Person {

	private String dn;
	private String commonName;
	private String description;
	private String lastName;
	private Collection<String> seeAlso;
	private Collection<String> telephoneNumber;
	private Collection<String> destinationIndicator;
	private Collection<String> facsimileTelephoneNumber;
	private Collection<Integer> internationaliSDNNumber;
	private Collection<String> localityName;
	private String organizationalUnit;
	private Collection<String> physicalDeliveryOfficeName;
	private Collection<String> postOfficeBox;
	private Collection<String> postalAddress;
	private Collection<String> postalCode;
	private String preferredDeliveryMethod;
	private Collection<String> registeredAddress;
	private Collection<String> stateOrProvinceName;
	private Collection<String> street;
	private Collection<String> teletexTerminalIdentifier;
	private Collection<byte[]> telexNumber;
	private Collection<String> title;
	private Collection<Integer> x121Address;
	private Collection<byte[]> audio;
	private String businessCategory;
	private Collection<String> carLicense;
	private Collection<String> departmentNumber;
	private String displayName;
	private String employeeNumber;
	private String employeeType;
	private String givenName;
	private Collection<String> homePhone;
	private Collection<String> homePostalAddress;
	private Collection<String> initials;
	private Collection<byte[]> jpegPhoto;
	private Collection<String> labeledURI;
	private Collection<String> mail;
	private Collection<String> manager;
	private Collection<String> mobile;
	private String organization;
	private Collection<String> pager;
	private Collection<byte[]> photo;
	private String preferredLanguage;
	private Collection<String> roomNumber;
	private Collection<String> secretary;
	private String userName;
	private Collection<Certificate> userCertificate;
	private Collection<byte[]> userPKCS12;
	private Collection<byte[]> userSMIMECertificate;
	private Collection<String> x500UniqueIdentifier;

	private LdapPerson(Builder builder) {
		this.dn = builder.dn;
		this.commonName = builder.commonName;
		this.description = builder.description;
		this.lastName = builder.lastName;
		this.seeAlso = builder.seeAlso;
		this.telephoneNumber = builder.telephoneNumber;
		this.destinationIndicator = builder.destinationIndicator;
		this.facsimileTelephoneNumber = builder.facsimileTelephoneNumber;
		this.internationaliSDNNumber = builder.internationaliSDNNumber;
		this.localityName = builder.localityName;
		this.organizationalUnit = builder.organizationalUnit;
		this.physicalDeliveryOfficeName = builder.physicalDeliveryOfficeName;
		this.postOfficeBox = builder.postOfficeBox;
		this.postalAddress = builder.postalAddress;
		this.postalCode = builder.postalCode;
		this.preferredDeliveryMethod = builder.preferredDeliveryMethod;
		this.registeredAddress = builder.registeredAddress;
		this.stateOrProvinceName = builder.stateOrProvinceName;
		this.street = builder.street;
		this.teletexTerminalIdentifier = builder.teletexTerminalIdentifier;
		this.telexNumber = builder.telexNumber;
		this.title = builder.title;
		this.x121Address = builder.x121Address;
		this.audio = builder.audio;
		this.businessCategory = builder.businessCategory;
		this.carLicense = builder.carLicense;
		this.departmentNumber = builder.departmentNumber;
		this.displayName = builder.displayName;
		this.employeeNumber = builder.employeeNumber;
		this.employeeType = builder.employeeType;
		this.givenName = builder.givenName;
		this.homePhone = builder.homePhone;
		this.homePostalAddress = builder.homePostalAddress;
		this.initials = builder.initials;
		this.jpegPhoto = builder.jpegPhoto;
		this.labeledURI = builder.labeledURI;
		this.mail = builder.mail;
		this.manager = builder.manager;
		this.mobile = builder.mobile;
		this.organization = builder.organization;
		this.pager = builder.pager;
		this.photo = builder.photo;
		this.preferredLanguage = builder.preferredLanguage;
		this.roomNumber = builder.roomNumber;
		this.secretary = builder.secretary;
		this.userName = builder.userName;
		this.userCertificate = builder.userCertificate;
		this.userPKCS12 = builder.userPKCS12;
		this.userSMIMECertificate = builder.userSMIMECertificate;
		this.x500UniqueIdentifier = builder.x500UniqueIdentifier;
		this.dn = updateDn();
	}

	public LdapPerson() {
	}

	public LdapPerson(final String dn) {
		this.dn = dn;
	}

	public LdapPerson(final String parentDn, final String userName) {
		this.dn = String.join(",", "uid=" + userName, parentDn);
	}

	@Override
	public String getDn() {
		return dn;
	}

	@Override
	public void setDn(String s) {
		this.dn = s;
	}

	@Override
	public String updateDn() {
		if (userName == null) {
			userName = dn.substring(dn.indexOf("=") + 1, dn.indexOf(","));
		}
		return DnUtil.updateDn(dn, "uid", userName);
	}

	@Override
	public String getCommonName() {
		return commonName;
	}

	@Override
	public void setCommonName(String c) {
		this.commonName = c;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void setDescription(String c) {
		this.description = c;
	}

	@Override
	public String getLastName() {
		return lastName;
	}

	@Override
	public void setLastName(String c) {
		this.lastName = c;
	}

	@Override
	public Collection<String> getSeeAlso() {
		return seeAlso;
	}

	@Override
	public void setSeeAlso(Collection<String> c) {
		this.seeAlso = c;
	}

	@Override
	public Collection<String> getTelephoneNumber() {
		return telephoneNumber;
	}

	@Override
	public void setTelephoneNumber(Collection<String> c) {
		this.telephoneNumber = c;
	}

	@Override
	public Collection<String> getDestinationIndicator() {
		return destinationIndicator;
	}

	@Override
	public void setDestinationIndicator(Collection<String> c) {
		this.destinationIndicator = c;
	}

	@Override
	public Collection<String> getFacsimileTelephoneNumber() {
		return facsimileTelephoneNumber;
	}

	@Override
	public void setFacsimileTelephoneNumber(Collection<String> c) {
		this.facsimileTelephoneNumber = c;
	}

	@Override
	public Collection<Integer> getInternationaliSDNNumber() {
		return internationaliSDNNumber;
	}

	@Override
	public void setInternationaliSDNNumber(Collection<Integer> c) {
		this.internationaliSDNNumber = c;
	}

	@Override
	public Collection<String> getLocalityName() {
		return localityName;
	}

	@Override
	public void setLocalityName(Collection<String> c) {
		this.localityName = c;
	}

	@Override
	public String getOrganizationalUnit() {
		return organizationalUnit;
	}

	@Override
	public void setOrganizationalUnit(String c) {
		this.organizationalUnit = c;
	}

	@Override
	public Collection<String> getPhysicalDeliveryOfficeName() {
		return physicalDeliveryOfficeName;
	}

	@Override
	public void setPhysicalDeliveryOfficeName(Collection<String> c) {
		this.physicalDeliveryOfficeName = c;
	}

	@Override
	public Collection<String> getPostOfficeBox() {
		return postOfficeBox;
	}

	@Override
	public void setPostOfficeBox(Collection<String> c) {
		this.postOfficeBox = c;
	}

	@Override
	public Collection<String> getPostalAddress() {
		return postalAddress;
	}

	@Override
	public void setPostalAddress(Collection<String> c) {
		this.postalAddress = c;
	}

	@Override
	public Collection<String> getPostalCode() {
		return postalCode;
	}

	@Override
	public void setPostalCode(Collection<String> c) {
		this.postalCode = c;
	}

	@Override
	public String getPreferredDeliveryMethod() {
		return preferredDeliveryMethod;
	}

	@Override
	public void setPreferredDeliveryMethod(String s) {
		this.preferredDeliveryMethod = s;
	}

	@Override
	public Collection<String> getRegisteredAddress() {
		return registeredAddress;
	}

	@Override
	public void setRegisteredAddress(Collection<String> c) {
		this.registeredAddress = c;
	}

	@Override
	public Collection<String> getStateOrProvinceName() {
		return stateOrProvinceName;
	}

	@Override
	public void setStateOrProvinceName(Collection<String> c) {
		this.stateOrProvinceName = c;
	}

	@Override
	public Collection<String> getStreet() {
		return street;
	}

	@Override
	public void setStreet(Collection<String> c) {
		this.street = c;
	}

	@Override
	public Collection<String> getTeletexTerminalIdentifier() {
		return teletexTerminalIdentifier;
	}

	@Override
	public void setTeletexTerminalIdentifier(Collection<String> c) {
		this.teletexTerminalIdentifier = c;
	}

	@Override
	public Collection<byte[]> getTelexNumber() {
		return telexNumber;
	}

	@Override
	public void setTelexNumber(Collection<byte[]> c) {
		this.telexNumber = c;
	}

	@Override
	public Collection<String> getTitle() {
		return title;
	}

	@Override
	public void setTitle(Collection<String> c) {
		this.title = c;
	}

	@Override
	public Collection<Integer> getX121Address() {
		return x121Address;
	}

	@Override
	public void setX121Address(Collection<Integer> c) {
		this.x121Address = c;
	}

	@Override
	public Collection<byte[]> getAudio() {
		return audio;
	}

	@Override
	public void setAudio(Collection<byte[]> c) {
		this.audio = c;
	}

	@Override
	public String getBusinessCategory() {
		return businessCategory;
	}

	@Override
	public void setBusinessCategory(String c) {
		this.businessCategory = c;
	}

	@Override
	public Collection<String> getCarLicense() {
		return carLicense;
	}

	@Override
	public void setCarLicense(Collection<String> c) {
		this.carLicense = c;
	}

	@Override
	public Collection<String> getDepartmentNumber() {
		return departmentNumber;
	}

	@Override
	public void setDepartmentNumber(Collection<String> c) {
		this.departmentNumber = c;
	}

	@Override
	public String getDisplayName() {
		return displayName;
	}

	@Override
	public void setDisplayName(String s) {
		this.displayName = s;
	}

	@Override
	public String getEmployeeNumber() {
		return employeeNumber;
	}

	@Override
	public void setEmployeeNumber(String s) {
		this.employeeNumber = s;
	}

	@Override
	public String getEmployeeType() {
		return employeeType;
	}

	@Override
	public void setEmployeeType(String c) {
		this.employeeType = c;
	}

	@Override
	public String getGivenName() {
		return givenName;
	}

	@Override
	public void setGivenName(String c) {
		this.givenName = c;
	}

	@Override
	public Collection<String> getHomePhone() {
		return homePhone;
	}

	@Override
	public void setHomePhone(Collection<String> c) {
		this.homePhone = c;
	}

	@Override
	public Collection<String> getHomePostalAddress() {
		return homePostalAddress;
	}

	@Override
	public void setHomePostalAddress(Collection<String> c) {
		this.homePostalAddress = c;
	}

	@Override
	public Collection<String> getInitials() {
		return initials;
	}

	@Override
	public void setInitials(Collection<String> c) {
		this.initials = c;
	}

	@Override
	public Collection<byte[]> getJpegPhoto() {
		return jpegPhoto;
	}

	@Override
	public void setJpegPhoto(Collection<byte[]> c) {
		this.jpegPhoto = c;
	}

	@Override
	public Collection<String> getLabeledURI() {
		return labeledURI;
	}

	@Override
	public void setLabeledURI(Collection<String> c) {
		this.labeledURI = c;
	}

	@Override
	public Collection<String> getMail() {
		return mail;
	}

	@Override
	public void setMail(Collection<String> c) {
		this.mail = c;
	}

	@Override
	public Collection<String> getManager() {
		return manager;
	}

	@Override
	public void setManager(Collection<String> c) {
		this.manager = c;
	}

	@Override
	public Collection<String> getMobile() {
		return mobile;
	}

	@Override
	public void setMobile(Collection<String> c) {
		this.mobile = c;
	}

	@Override
	public String getOrganization() {
		return organization;
	}

	@Override
	public void setOrganization(String c) {
		this.organization = c;
	}

	@Override
	public Collection<String> getPager() {
		return pager;
	}

	@Override
	public void setPager(Collection<String> c) {
		this.pager = c;
	}

	@Override
	public Collection<byte[]> getPhoto() {
		return photo;
	}

	@Override
	public void setPhoto(Collection<byte[]> c) {
		this.photo = c;
	}

	@Override
	public String getPreferredLanguage() {
		return preferredLanguage;
	}

	@Override
	public void setPreferredLanguage(String s) {
		this.preferredLanguage = s;
	}

	@Override
	public Collection<String> getRoomNumber() {
		return roomNumber;
	}

	@Override
	public void setRoomNumber(Collection<String> c) {
		this.roomNumber = c;
	}

	@Override
	public Collection<String> getSecretary() {
		return secretary;
	}

	@Override
	public void setSecretary(Collection<String> c) {
		this.secretary = c;
	}

	@Override
	public String getUserName() {
		return userName;
	}

	@Override
	public void setUserName(String c) {
		this.userName = c;
	}

	public Collection<Certificate> getUserCertificate() {
		return userCertificate;
	}

	public void setUserCertificate(Collection<Certificate> c) {
		this.userCertificate = c;
	}

	public Collection<byte[]> getUserPKCS12() {
		return userPKCS12;
	}

	public void setUserPKCS12(Collection<byte[]> c) {
		this.userPKCS12 = c;
	}

	public Collection<byte[]> getUserSMIMECertificate() {
		return userSMIMECertificate;
	}

	public void setUserSMIMECertificate(Collection<byte[]> c) {
		this.userSMIMECertificate = c;
	}

	public Collection<String> getX500UniqueIdentifier() {
		return x500UniqueIdentifier;
	}

	public void setX500UniqueIdentifier(Collection<String> c) {
		this.x500UniqueIdentifier = c;
	}

	@Override
	public int hashCode() {
		return LdapUtils.computeHashCode(7919, this.dn, this.commonName, this.description, this.lastName, this.seeAlso,
				this.telephoneNumber, this.destinationIndicator, this.facsimileTelephoneNumber,
				this.internationaliSDNNumber, this.localityName, this.organizationalUnit,
				this.physicalDeliveryOfficeName, this.postOfficeBox, this.postalAddress, this.postalCode,
				this.preferredDeliveryMethod, this.registeredAddress, this.stateOrProvinceName, this.street,
				this.teletexTerminalIdentifier, this.telexNumber, this.title, this.x121Address, this.audio,
				this.businessCategory, this.carLicense, this.departmentNumber, this.displayName, this.employeeNumber,
				this.employeeType, this.givenName, this.homePhone, this.homePostalAddress, this.initials,
				this.jpegPhoto, this.labeledURI, this.mail, this.manager, this.mobile, this.organization, this.pager,
				this.photo, this.preferredLanguage, this.roomNumber, this.secretary, this.userName,
				this.userCertificate, this.userPKCS12, this.userSMIMECertificate, this.x500UniqueIdentifier);
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (o instanceof LdapPerson) {
			LdapPerson v = ((LdapPerson) o);
			return (((((((((((((((((((((((((((((((((((((((((((((((((LdapUtils.areEqual(dn, v.dn)
					&& LdapUtils.areEqual(commonName, v.commonName)) && LdapUtils.areEqual(description, v.description))
					&& LdapUtils.areEqual(lastName, v.lastName)) && LdapUtils.areEqual(seeAlso, v.seeAlso))
					&& LdapUtils.areEqual(telephoneNumber, v.telephoneNumber))
					&& LdapUtils.areEqual(destinationIndicator, v.destinationIndicator))
					&& LdapUtils.areEqual(facsimileTelephoneNumber, v.facsimileTelephoneNumber))
					&& LdapUtils.areEqual(internationaliSDNNumber, v.internationaliSDNNumber))
					&& LdapUtils.areEqual(localityName, v.localityName))
					&& LdapUtils.areEqual(organizationalUnit, v.organizationalUnit))
					&& LdapUtils.areEqual(physicalDeliveryOfficeName, v.physicalDeliveryOfficeName))
					&& LdapUtils.areEqual(postOfficeBox, v.postOfficeBox))
					&& LdapUtils.areEqual(postalAddress, v.postalAddress))
					&& LdapUtils.areEqual(postalCode, v.postalCode))
					&& LdapUtils.areEqual(preferredDeliveryMethod, v.preferredDeliveryMethod))
					&& LdapUtils.areEqual(registeredAddress, v.registeredAddress))
					&& LdapUtils.areEqual(stateOrProvinceName, v.stateOrProvinceName))
					&& LdapUtils.areEqual(street, v.street))
					&& LdapUtils.areEqual(teletexTerminalIdentifier, v.teletexTerminalIdentifier))
					&& LdapUtils.areEqual(telexNumber, v.telexNumber)) && LdapUtils.areEqual(title, v.title))
					&& LdapUtils.areEqual(x121Address, v.x121Address)) && LdapUtils.areEqual(audio, v.audio))
					&& LdapUtils.areEqual(businessCategory, v.businessCategory))
					&& LdapUtils.areEqual(carLicense, v.carLicense))
					&& LdapUtils.areEqual(departmentNumber, v.departmentNumber))
					&& LdapUtils.areEqual(displayName, v.displayName))
					&& LdapUtils.areEqual(employeeNumber, v.employeeNumber))
					&& LdapUtils.areEqual(employeeType, v.employeeType)) && LdapUtils.areEqual(givenName, v.givenName))
					&& LdapUtils.areEqual(homePhone, v.homePhone))
					&& LdapUtils.areEqual(homePostalAddress, v.homePostalAddress))
					&& LdapUtils.areEqual(initials, v.initials)) && LdapUtils.areEqual(jpegPhoto, v.jpegPhoto))
					&& LdapUtils.areEqual(labeledURI, v.labeledURI)) && LdapUtils.areEqual(mail, v.mail))
					&& LdapUtils.areEqual(manager, v.manager)) && LdapUtils.areEqual(mobile, v.mobile))
					&& LdapUtils.areEqual(organization, v.organization)) && LdapUtils.areEqual(pager, v.pager))
					&& LdapUtils.areEqual(photo, v.photo))
					&& LdapUtils.areEqual(preferredLanguage, v.preferredLanguage))
					&& LdapUtils.areEqual(roomNumber, v.roomNumber)) && LdapUtils.areEqual(secretary, v.secretary))
					&& LdapUtils.areEqual(userName, v.userName))
					&& LdapUtils.areEqual(userCertificate, v.userCertificate))
					&& LdapUtils.areEqual(userPKCS12, v.userPKCS12))
					&& LdapUtils.areEqual(userSMIMECertificate, v.userSMIMECertificate))
					&& LdapUtils.areEqual(x500UniqueIdentifier, v.x500UniqueIdentifier));

		}
		return false;
	}

	@Override
	public String toString() {
		return String.format(
				"[%s@%d::dn=%s, commonName=%s, description=%s, lastName=%s, seeAlso=%s, telephoneNumber=%s, destinationIndicator=%s, facsimileTelephoneNumber=%s, internationaliSDNNumber=%s, localityName=%s, ou=%s, physicalDeliveryOfficeName=%s, postOfficeBox=%s, postalAddress=%s, postalCode=%s, preferredDeliveryMethod=%s, registeredAddress=%s, stateOrProvinceName=%s, street=%s, teletexTerminalIdentifier=%s, telexNumber=%s, title=%s, x121Address=%s, audio=%s, businessCategory=%s, carLicense=%s, departmentNumber=%s, displayName=%s, employeeNumber=%s, employeeType=%s, givenName=%s, homePhone=%s, homePostalAddress=%s, initials=%s, jpegPhoto=%s, labeledURI=%s, mail=%s, manager=%s, mobile=%s, organization=%s, pager=%s, photo=%s, preferredLanguage=%s, roomNumber=%s, secretary=%s, uid=%s, userCertificate=%s, userPKCS12=%s, userSMIMECertificate=%s, x500UniqueIdentifier=%s]",
				this.getClass().getName(), this.hashCode(), this.dn, this.commonName, this.description, this.lastName,
				this.seeAlso, this.telephoneNumber, this.destinationIndicator, this.facsimileTelephoneNumber,
				this.internationaliSDNNumber, this.localityName, this.organizationalUnit,
				this.physicalDeliveryOfficeName, this.postOfficeBox, this.postalAddress, this.postalCode,
				this.preferredDeliveryMethod, this.registeredAddress, this.stateOrProvinceName, this.street,
				this.teletexTerminalIdentifier, this.telexNumber, this.title, this.x121Address, this.audio,
				this.businessCategory, this.carLicense, this.departmentNumber, this.displayName, this.employeeNumber,
				this.employeeType, this.givenName, this.homePhone, this.homePostalAddress, this.initials,
				this.jpegPhoto, this.labeledURI, this.mail, this.manager, this.mobile, this.organization, this.pager,
				this.photo, this.preferredLanguage, this.roomNumber, this.secretary, this.userName,
				this.userCertificate, this.userPKCS12, this.userSMIMECertificate, this.x500UniqueIdentifier);
	}

	/**
	 * Creates builder to build {@link LdapPerson}.
	 * 
	 * @return created builder
	 */
	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Builder to build {@link LdapPerson}.
	 */
	public static final class Builder {
		private String dn;
		private String commonName;
		private String description;
		private String lastName;
		private Collection<String> seeAlso = Collections.emptyList();
		private Collection<String> telephoneNumber = Collections.emptyList();
		private Collection<String> destinationIndicator = Collections.emptyList();
		private Collection<String> facsimileTelephoneNumber = Collections.emptyList();
		private Collection<Integer> internationaliSDNNumber = Collections.emptyList();
		private Collection<String> localityName = Collections.emptyList();
		private String organizationalUnit;
		private Collection<String> physicalDeliveryOfficeName = Collections.emptyList();
		private Collection<String> postOfficeBox = Collections.emptyList();
		private Collection<String> postalAddress = Collections.emptyList();
		private Collection<String> postalCode = Collections.emptyList();
		private String preferredDeliveryMethod;
		private Collection<String> registeredAddress = Collections.emptyList();
		private Collection<String> stateOrProvinceName = Collections.emptyList();
		private Collection<String> street = Collections.emptyList();
		private Collection<String> teletexTerminalIdentifier = Collections.emptyList();
		private Collection<byte[]> telexNumber = Collections.emptyList();
		private Collection<String> title = Collections.emptyList();
		private Collection<Integer> x121Address = Collections.emptyList();
		private Collection<byte[]> audio = Collections.emptyList();
		private String businessCategory;
		private Collection<String> carLicense = Collections.emptyList();
		private Collection<String> departmentNumber = Collections.emptyList();
		private String displayName;
		private String employeeNumber;
		private String employeeType;
		private String givenName;
		private Collection<String> homePhone = Collections.emptyList();
		private Collection<String> homePostalAddress = Collections.emptyList();
		private Collection<String> initials = Collections.emptyList();
		private Collection<byte[]> jpegPhoto = Collections.emptyList();
		private Collection<String> labeledURI = Collections.emptyList();
		private Collection<String> mail = Collections.emptyList();
		private Collection<String> manager = Collections.emptyList();
		private Collection<String> mobile = Collections.emptyList();
		private String organization;
		private Collection<String> pager = Collections.emptyList();
		private Collection<byte[]> photo = Collections.emptyList();
		private String preferredLanguage;
		private Collection<String> roomNumber = Collections.emptyList();
		private Collection<String> secretary = Collections.emptyList();
		private String userName;
		private Collection<Certificate> userCertificate = Collections.emptyList();
		private Collection<byte[]> userPKCS12 = Collections.emptyList();
		private Collection<byte[]> userSMIMECertificate = Collections.emptyList();
		private Collection<String> x500UniqueIdentifier = Collections.emptyList();

		private Builder() {
		}

		public Builder withDn(String dn) {
			this.dn = dn;
			return this;
		}

		public Builder withCommonName(String commonName) {
			this.commonName = commonName;
			return this;
		}

		public Builder withDescription(String description) {
			this.description = description;
			return this;
		}

		public Builder withLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public Builder withSeeAlso(Collection<String> seeAlso) {
			this.seeAlso = seeAlso;
			return this;
		}

		public Builder withTelephoneNumber(Collection<String> telephoneNumber) {
			this.telephoneNumber = telephoneNumber;
			return this;
		}

		public Builder withDestinationIndicator(Collection<String> destinationIndicator) {
			this.destinationIndicator = destinationIndicator;
			return this;
		}

		public Builder withFacsimileTelephoneNumber(Collection<String> facsimileTelephoneNumber) {
			this.facsimileTelephoneNumber = facsimileTelephoneNumber;
			return this;
		}

		public Builder withInternationaliSDNNumber(Collection<Integer> internationaliSDNNumber) {
			this.internationaliSDNNumber = internationaliSDNNumber;
			return this;
		}

		public Builder withLocalityName(Collection<String> localityName) {
			this.localityName = localityName;
			return this;
		}

		public Builder withOrganizationalUnit(String organizationalUnit) {
			this.organizationalUnit = organizationalUnit;
			return this;
		}

		public Builder withPhysicalDeliveryOfficeName(Collection<String> physicalDeliveryOfficeName) {
			this.physicalDeliveryOfficeName = physicalDeliveryOfficeName;
			return this;
		}

		public Builder withPostOfficeBox(Collection<String> postOfficeBox) {
			this.postOfficeBox = postOfficeBox;
			return this;
		}

		public Builder withPostalAddress(Collection<String> postalAddress) {
			this.postalAddress = postalAddress;
			return this;
		}

		public Builder withPostalCode(Collection<String> postalCode) {
			this.postalCode = postalCode;
			return this;
		}

		public Builder withPreferredDeliveryMethod(String preferredDeliveryMethod) {
			this.preferredDeliveryMethod = preferredDeliveryMethod;
			return this;
		}

		public Builder withRegisteredAddress(Collection<String> registeredAddress) {
			this.registeredAddress = registeredAddress;
			return this;
		}

		public Builder withStateOrProvinceName(Collection<String> stateOrProvinceName) {
			this.stateOrProvinceName = stateOrProvinceName;
			return this;
		}

		public Builder withStreet(Collection<String> street) {
			this.street = street;
			return this;
		}

		public Builder withTeletexTerminalIdentifier(Collection<String> teletexTerminalIdentifier) {
			this.teletexTerminalIdentifier = teletexTerminalIdentifier;
			return this;
		}

		public Builder withTelexNumber(Collection<byte[]> telexNumber) {
			this.telexNumber = telexNumber;
			return this;
		}

		public Builder withTitle(Collection<String> title) {
			this.title = title;
			return this;
		}

		public Builder withX121Address(Collection<Integer> x121Address) {
			this.x121Address = x121Address;
			return this;
		}

		public Builder withAudio(Collection<byte[]> audio) {
			this.audio = audio;
			return this;
		}

		public Builder withBusinessCategory(String businessCategory) {
			this.businessCategory = businessCategory;
			return this;
		}

		public Builder withCarLicense(Collection<String> carLicense) {
			this.carLicense = carLicense;
			return this;
		}

		public Builder withDepartmentNumber(Collection<String> departmentNumber) {
			this.departmentNumber = departmentNumber;
			return this;
		}

		public Builder withDisplayName(String displayName) {
			this.displayName = displayName;
			return this;
		}

		public Builder withEmployeeNumber(String employeeNumber) {
			this.employeeNumber = employeeNumber;
			return this;
		}

		public Builder withEmployeeType(String employeeType) {
			this.employeeType = employeeType;
			return this;
		}

		public Builder withGivenName(String givenName) {
			this.givenName = givenName;
			return this;
		}

		public Builder withHomePhone(Collection<String> homePhone) {
			this.homePhone = homePhone;
			return this;
		}

		public Builder withHomePostalAddress(Collection<String> homePostalAddress) {
			this.homePostalAddress = homePostalAddress;
			return this;
		}

		public Builder withInitials(Collection<String> initials) {
			this.initials = initials;
			return this;
		}

		public Builder withJpegPhoto(Collection<byte[]> jpegPhoto) {
			this.jpegPhoto = jpegPhoto;
			return this;
		}

		public Builder withLabeledURI(Collection<String> labeledURI) {
			this.labeledURI = labeledURI;
			return this;
		}

		public Builder withMail(Collection<String> mail) {
			this.mail = mail;
			return this;
		}

		public Builder withManager(Collection<String> manager) {
			this.manager = manager;
			return this;
		}

		public Builder withMobile(Collection<String> mobile) {
			this.mobile = mobile;
			return this;
		}

		public Builder withOrganization(String organization) {
			this.organization = organization;
			return this;
		}

		public Builder withPager(Collection<String> pager) {
			this.pager = pager;
			return this;
		}

		public Builder withPhoto(Collection<byte[]> photo) {
			this.photo = photo;
			return this;
		}

		public Builder withPreferredLanguage(String preferredLanguage) {
			this.preferredLanguage = preferredLanguage;
			return this;
		}

		public Builder withRoomNumber(Collection<String> roomNumber) {
			this.roomNumber = roomNumber;
			return this;
		}

		public Builder withSecretary(Collection<String> secretary) {
			this.secretary = secretary;
			return this;
		}

		public Builder withUserName(String userName) {
			this.userName = userName;
			return this;
		}

		public Builder withUserCertificate(Collection<Certificate> userCertificate) {
			this.userCertificate = userCertificate;
			return this;
		}

		public Builder withUserPKCS12(Collection<byte[]> userPKCS12) {
			this.userPKCS12 = userPKCS12;
			return this;
		}

		public Builder withUserSMIMECertificate(Collection<byte[]> userSMIMECertificate) {
			this.userSMIMECertificate = userSMIMECertificate;
			return this;
		}

		public Builder withX500UniqueIdentifier(Collection<String> x500UniqueIdentifier) {
			this.x500UniqueIdentifier = x500UniqueIdentifier;
			return this;
		}

		public LdapPerson build() {
			return new LdapPerson(this);
		}
	}

}
