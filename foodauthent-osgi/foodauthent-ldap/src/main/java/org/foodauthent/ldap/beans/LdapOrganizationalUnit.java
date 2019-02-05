
package org.foodauthent.ldap.beans;

import java.util.Collections;
import java.util.List;

import org.foodauthent.ldap.DnUtil;
import org.foodauthent.people.Organization;
import org.ldaptive.LdapUtils;
import org.ldaptive.beans.Attribute;
import org.ldaptive.beans.Entry;

@Entry(dn = "dn", attributes = { //
		@Attribute(name = "objectClass", values = { "organizationalUnit" }), //
		@Attribute(name = "businessCategory"), //
		@Attribute(name = "description"), //
		@Attribute(name = "destinationIndicator"), //
		@Attribute(name = "facsimileTelephoneNumber"), //
		@Attribute(name = "internationaliSDNNumber"), //
		@Attribute(name = "l", property = "localityName"), //
		@Attribute(name = "ou", property = "name"), //
		@Attribute(name = "physicalDeliveryOfficeName"), //
		@Attribute(name = "postOfficeBox"), //
		@Attribute(name = "postalAddress"), //
		@Attribute(name = "postalCode"), //
		@Attribute(name = "preferredDeliveryMethod"), //
		@Attribute(name = "registeredAddress"), //
		@Attribute(name = "searchGuide"), //
		@Attribute(name = "seeAlso"), //
		@Attribute(name = "st", property = "stateOrProvinceName"), //
		@Attribute(name = "street"), //
		@Attribute(name = "telephoneNumber"), //
		@Attribute(name = "teletexTerminalIdentifier"), //
		@Attribute(name = "telexNumber", binary = true), //
		@Attribute(name = "x121Address") })
public class LdapOrganizationalUnit implements Dn, Organization {

	public static final String OU_GROUPS = "ou=groups";

	public static final String OU_USERS = "ou=users";

	private String dn;
	private String businessCategory;
	private String description;
	private String destinationIndicator;
	private List<String> facsimileTelephoneNumber;
	private List<Integer> internationaliSDNNumber;
	private String localityName;
	private String name;
	private String physicalDeliveryOfficeName;
	private String postOfficeBox;
	private List<String> postalAddress;
	private String postalCode;
	private String preferredDeliveryMethod;
	private List<String> registeredAddress;
	private List<String> searchGuide;
	private List<String> seeAlso;
	private String stateOrProvinceName;
	private List<String> street;
	private List<String> telephoneNumber;
	private List<String> teletexTerminalIdentifier;
	private List<byte[]> telexNumber;
	private List<Integer> x121Address;

	private LdapOrganizationalUnit(Builder builder) {
		this.dn = builder.dn;
		this.businessCategory = builder.businessCategory;
		this.description = builder.description;
		this.destinationIndicator = builder.destinationIndicator;
		this.facsimileTelephoneNumber = builder.facsimileTelephoneNumber;
		this.internationaliSDNNumber = builder.internationaliSDNNumber;
		this.localityName = builder.localityName;
		this.name = builder.name;
		this.physicalDeliveryOfficeName = builder.physicalDeliveryOfficeName;
		this.postOfficeBox = builder.postOfficeBox;
		this.postalAddress = builder.postalAddress;
		this.postalCode = builder.postalCode;
		this.preferredDeliveryMethod = builder.preferredDeliveryMethod;
		this.registeredAddress = builder.registeredAddress;
		this.searchGuide = builder.searchGuide;
		this.seeAlso = builder.seeAlso;
		this.stateOrProvinceName = builder.stateOrProvinceName;
		this.street = builder.street;
		this.telephoneNumber = builder.telephoneNumber;
		this.teletexTerminalIdentifier = builder.teletexTerminalIdentifier;
		this.telexNumber = builder.telexNumber;
		this.x121Address = builder.x121Address;
		this.dn = updateDn();
	}

	public LdapOrganizationalUnit() {
	}

	public LdapOrganizationalUnit(final String dn) {
		this.dn = dn;
	}

	public LdapOrganizationalUnit(final String parentDn, final String name) {
		this.dn = String.join(",", "ou=" + name, parentDn);
		this.name = name;
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
		if (name == null) {
			name = dn.substring(dn.indexOf("=") + 1, dn.indexOf(","));
		}
		return DnUtil.updateDn(dn, "ou", name);
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
	public String getDescription() {
		return description;
	}

	@Override
	public void setDescription(String c) {
		this.description = c;
	}

	@Override
	public String getDestinationIndicator() {
		return destinationIndicator;
	}

	@Override
	public void setDestinationIndicator(String c) {
		this.destinationIndicator = c;
	}

	@Override
	public List<String> getFacsimileTelephoneNumber() {
		return facsimileTelephoneNumber;
	}

	@Override
	public void setFacsimileTelephoneNumber(List<String> c) {
		this.facsimileTelephoneNumber = c;
	}

	public List<Integer> getInternationaliSDNNumber() {
		return internationaliSDNNumber;
	}

	public void setInternationaliSDNNumber(List<Integer> c) {
		this.internationaliSDNNumber = c;
	}

	@Override
	public String getLocalityName() {
		return localityName;
	}

	@Override
	public void setLocalityName(String c) {
		this.localityName = c;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getPhysicalDeliveryOfficeName() {
		return physicalDeliveryOfficeName;
	}

	@Override
	public void setPhysicalDeliveryOfficeName(String c) {
		this.physicalDeliveryOfficeName = c;
	}

	@Override
	public String getPostOfficeBox() {
		return postOfficeBox;
	}

	@Override
	public void setPostOfficeBox(String c) {
		this.postOfficeBox = c;
	}

	@Override
	public List<String> getPostalAddress() {
		return postalAddress;
	}

	@Override
	public void setPostalAddress(List<String> c) {
		this.postalAddress = c;
	}

	@Override
	public String getPostalCode() {
		return postalCode;
	}

	@Override
	public void setPostalCode(String c) {
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
	public List<String> getRegisteredAddress() {
		return registeredAddress;
	}

	@Override
	public void setRegisteredAddress(List<String> c) {
		this.registeredAddress = c;
	}

	@Override
	public List<String> getSearchGuide() {
		return searchGuide;
	}

	@Override
	public void setSearchGuide(List<String> c) {
		this.searchGuide = c;
	}

	@Override
	public List<String> getSeeAlso() {
		return seeAlso;
	}

	@Override
	public void setSeeAlso(List<String> c) {
		this.seeAlso = c;
	}

	@Override
	public String getStateOrProvinceName() {
		return stateOrProvinceName;
	}

	@Override
	public void setStateOrProvinceName(String c) {
		this.stateOrProvinceName = c;
	}

	@Override
	public List<String> getStreet() {
		return street;
	}

	@Override
	public void setStreet(List<String> c) {
		this.street = c;
	}

	@Override
	public List<String> getTelephoneNumber() {
		return telephoneNumber;
	}

	@Override
	public void setTelephoneNumber(List<String> c) {
		this.telephoneNumber = c;
	}

	public List<String> getTeletexTerminalIdentifier() {
		return teletexTerminalIdentifier;
	}

	public void setTeletexTerminalIdentifier(List<String> c) {
		this.teletexTerminalIdentifier = c;
	}

	public List<byte[]> getTelexNumber() {
		return telexNumber;
	}

	public void setTelexNumber(List<byte[]> c) {
		this.telexNumber = c;
	}

	public List<Integer> getX121Address() {
		return x121Address;
	}

	public void setX121Address(List<Integer> c) {
		this.x121Address = c;
	}

	@Override
	public int hashCode() {
		return LdapUtils.computeHashCode(7919, this.dn, this.businessCategory, this.description,
				this.destinationIndicator, this.facsimileTelephoneNumber, this.internationaliSDNNumber,
				this.localityName, this.name, this.physicalDeliveryOfficeName, this.postOfficeBox, this.postalAddress,
				this.postalCode, this.preferredDeliveryMethod, this.registeredAddress, this.searchGuide, this.seeAlso,
				this.stateOrProvinceName, this.street, this.telephoneNumber, this.teletexTerminalIdentifier,
				this.telexNumber, this.x121Address);
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (o instanceof LdapOrganizationalUnit) {
			LdapOrganizationalUnit v = ((LdapOrganizationalUnit) o);
			return (((((((((((((((((((((LdapUtils.areEqual(dn, v.dn)
					&& LdapUtils.areEqual(businessCategory, v.businessCategory))
					&& LdapUtils.areEqual(description, v.description))
					&& LdapUtils.areEqual(destinationIndicator, v.destinationIndicator))
					&& LdapUtils.areEqual(facsimileTelephoneNumber, v.facsimileTelephoneNumber))
					&& LdapUtils.areEqual(internationaliSDNNumber, v.internationaliSDNNumber))
					&& LdapUtils.areEqual(localityName, v.localityName)) && LdapUtils.areEqual(name, v.name))
					&& LdapUtils.areEqual(physicalDeliveryOfficeName, v.physicalDeliveryOfficeName))
					&& LdapUtils.areEqual(postOfficeBox, v.postOfficeBox))
					&& LdapUtils.areEqual(postalAddress, v.postalAddress))
					&& LdapUtils.areEqual(postalCode, v.postalCode))
					&& LdapUtils.areEqual(preferredDeliveryMethod, v.preferredDeliveryMethod))
					&& LdapUtils.areEqual(registeredAddress, v.registeredAddress))
					&& LdapUtils.areEqual(searchGuide, v.searchGuide)) && LdapUtils.areEqual(seeAlso, v.seeAlso))
					&& LdapUtils.areEqual(stateOrProvinceName, v.stateOrProvinceName))
					&& LdapUtils.areEqual(street, v.street)) && LdapUtils.areEqual(telephoneNumber, v.telephoneNumber))
					&& LdapUtils.areEqual(teletexTerminalIdentifier, v.teletexTerminalIdentifier))
					&& LdapUtils.areEqual(telexNumber, v.telexNumber))
					&& LdapUtils.areEqual(x121Address, v.x121Address));
		}
		return false;
	}

	@Override
	public String toString() {
		return String.format(
				"[%s@%d::dn=%s, businessCategory=%s, description=%s, destinationIndicator=%s, facsimileTelephoneNumber=%s, internationaliSDNNumber=%s, localityName=%s, name=%s, physicalDeliveryOfficeName=%s, postOfficeBox=%s, postalAddress=%s, postalCode=%s, preferredDeliveryMethod=%s, registeredAddress=%s, searchGuide=%s, seeAlso=%s, stateOrProvinceName=%s, street=%s, telephoneNumber=%s, teletexTerminalIdentifier=%s, telexNumber=%s, x121Address=%s]",
				this.getClass().getName(), this.hashCode(), this.dn, this.businessCategory, this.description,
				this.destinationIndicator, this.facsimileTelephoneNumber, this.internationaliSDNNumber,
				this.localityName, this.name, this.physicalDeliveryOfficeName, this.postOfficeBox, this.postalAddress,
				this.postalCode, this.preferredDeliveryMethod, this.registeredAddress, this.searchGuide, this.seeAlso,
				this.stateOrProvinceName, this.street, this.telephoneNumber, this.teletexTerminalIdentifier,
				this.telexNumber, this.x121Address);
	}

	/**
	 * Creates builder to build {@link LdapOrganizationalUnit}.
	 * 
	 * @return created builder
	 */
	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Builder to build {@link LdapOrganizationalUnit}.
	 */
	public static final class Builder {
		private String dn;
		private String businessCategory;
		private String description;
		private String destinationIndicator;
		private List<String> facsimileTelephoneNumber = Collections.emptyList();
		private List<Integer> internationaliSDNNumber = Collections.emptyList();
		private String localityName;
		private String name;
		private String physicalDeliveryOfficeName;
		private String postOfficeBox;
		private List<String> postalAddress = Collections.emptyList();
		private String postalCode;
		private String preferredDeliveryMethod;
		private List<String> registeredAddress = Collections.emptyList();
		private List<String> searchGuide = Collections.emptyList();
		private List<String> seeAlso = Collections.emptyList();
		private String stateOrProvinceName;
		private List<String> street = Collections.emptyList();
		private List<String> telephoneNumber = Collections.emptyList();
		private List<String> teletexTerminalIdentifier = Collections.emptyList();
		private List<byte[]> telexNumber = Collections.emptyList();
		private List<Integer> x121Address = Collections.emptyList();

		private Builder() {
		}

		public Builder withDn(String dn) {
			this.dn = dn;
			return this;
		}

		public Builder withBusinessCategory(String businessCategory) {
			this.businessCategory = businessCategory;
			return this;
		}

		public Builder withDescription(String description) {
			this.description = description;
			return this;
		}

		public Builder withDestinationIndicator(String destinationIndicator) {
			this.destinationIndicator = destinationIndicator;
			return this;
		}

		public Builder withFacsimileTelephoneNumber(List<String> facsimileTelephoneNumber) {
			this.facsimileTelephoneNumber = facsimileTelephoneNumber;
			return this;
		}

		public Builder withInternationaliSDNNumber(List<Integer> internationaliSDNNumber) {
			this.internationaliSDNNumber = internationaliSDNNumber;
			return this;
		}

		public Builder withLocalityName(String localityName) {
			this.localityName = localityName;
			return this;
		}

		public Builder withName(String name) {
			this.name = name;
			return this;
		}

		public Builder withPhysicalDeliveryOfficeName(String physicalDeliveryOfficeName) {
			this.physicalDeliveryOfficeName = physicalDeliveryOfficeName;
			return this;
		}

		public Builder withPostOfficeBox(String postOfficeBox) {
			this.postOfficeBox = postOfficeBox;
			return this;
		}

		public Builder withPostalAddress(List<String> postalAddress) {
			this.postalAddress = postalAddress;
			return this;
		}

		public Builder withPostalCode(String postalCode) {
			this.postalCode = postalCode;
			return this;
		}

		public Builder withPreferredDeliveryMethod(String preferredDeliveryMethod) {
			this.preferredDeliveryMethod = preferredDeliveryMethod;
			return this;
		}

		public Builder withRegisteredAddress(List<String> registeredAddress) {
			this.registeredAddress = registeredAddress;
			return this;
		}

		public Builder withSearchGuide(List<String> searchGuide) {
			this.searchGuide = searchGuide;
			return this;
		}

		public Builder withSeeAlso(List<String> seeAlso) {
			this.seeAlso = seeAlso;
			return this;
		}

		public Builder withStateOrProvinceName(String stateOrProvinceName) {
			this.stateOrProvinceName = stateOrProvinceName;
			return this;
		}

		public Builder withStreet(List<String> street) {
			this.street = street;
			return this;
		}

		public Builder withTelephoneNumber(List<String> telephoneNumber) {
			this.telephoneNumber = telephoneNumber;
			return this;
		}

		public Builder withTeletexTerminalIdentifier(List<String> teletexTerminalIdentifier) {
			this.teletexTerminalIdentifier = teletexTerminalIdentifier;
			return this;
		}

		public Builder withTelexNumber(List<byte[]> telexNumber) {
			this.telexNumber = telexNumber;
			return this;
		}

		public Builder withX121Address(List<Integer> x121Address) {
			this.x121Address = x121Address;
			return this;
		}

		public LdapOrganizationalUnit build() {
			return new LdapOrganizationalUnit(this);
		}
	}

}
