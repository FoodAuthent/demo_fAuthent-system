package org.foodauthent.impl.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.foodauthent.ldap.beans.LdapGroup;
import org.foodauthent.ldap.beans.LdapPerson;
import org.foodauthent.model.PostalAddress;
import org.foodauthent.model.PostalAddress.PostalAddressBuilder;
import org.foodauthent.model.User;
import org.foodauthent.model.User.UserBuilder;
import org.foodauthent.model.UserBase;
import org.foodauthent.model.UserGroup;
import org.foodauthent.model.UserGroupBase;
import org.foodauthent.model.UserGroupCreateRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Strings;

class Convert {

    private static final Logger LOGGER = LoggerFactory.getLogger(Convert.class);

    public static final LdapPerson toLdapPerson(final String dn, final UserBase userBase) {
	final LdapPerson.Builder builder = LdapPerson.builder() //
		.withCommonName(userBase.getGivenName() + " " + userBase.getLastName()) //
		.withDescription(userBase.getDescription()) //
		.withDn(dn) //
		.withBusinessCategory(userBase.getBusinessCategory()) //
		.withDescription(userBase.getDescription()) //
		.withEmployeeNumber(userBase.getEmployeeNumber()) //
		.withEmployeeType(userBase.getEmployeeType()) //
		.withFacsimileTelephoneNumber(userBase.getFaxNumbers()) //
		.withGivenName(userBase.getGivenName()) //
		.withHomePhone(userBase.getHomePhoneNumbers()) //
		.withLabeledURI(userBase.getLabeledURI()) //
		.withLastName(userBase.getLastName()) //
		.withMail(userBase.getMail()) //
		.withMobile(userBase.getMobilePhoneNumbers()) //
		.withTelephoneNumber(userBase.getPhoneNumbers());
	final PostalAddress postalAddress = userBase.getPostalAddress();
	if (postalAddress != null) {
	    builder.withLocalityName(Arrays.asList(postalAddress.getLocalityName()));
	    builder.withPostalCode(Arrays.asList(postalAddress.getPostalCode()));
	    builder.withStateOrProvinceName(Arrays.asList(postalAddress.getStateOrProvinceName()));
	    builder.withPostalAddress(toAddressList(postalAddress));
	}
	final PostalAddress billingAddress = userBase.getBillingAddress();
	if (billingAddress != null) {
	    builder.withRegisteredAddress(toAddressList(billingAddress));
	}
	return builder.build();
    }

    public static final List<String> toAddressList(final PostalAddress postalAddress) {
	final List<String> address = new ArrayList<>();
	address.add(Strings.nullToEmpty(postalAddress.getOtherRecipientInformation()));
	address.add(Strings.nullToEmpty(postalAddress.getStreet()));
	address.add(Strings.nullToEmpty(postalAddress.getPostalCode()));
	address.add(Strings.nullToEmpty(postalAddress.getLocalityName()));
	address.add(Strings.nullToEmpty(postalAddress.getStateOrProvinceName()));
	address.add(Strings.nullToEmpty(postalAddress.getCountry()));
	return Arrays.asList(
		String.join("$", address.stream().map(a -> a.isEmpty() ? " " : a).collect(Collectors.toList())));
    }

    public static final User toRestUser(LdapPerson ldapUser) {
	final UserBuilder builder = User.builder() //
		.setDescription(ldapUser.getDescription()) //
		.setDn(ldapUser.getDn()) //
		.setBusinessCategory(ldapUser.getBusinessCategory()) //
		.setDescription(ldapUser.getDescription()) //
		.setEmployeeNumber(ldapUser.getEmployeeNumber()) //
		.setEmployeeType(ldapUser.getEmployeeType()) //
		.setFaxNumbers(ldapUser.getFacsimileTelephoneNumber() == null ? null
			: new ArrayList<String>(ldapUser.getFacsimileTelephoneNumber())) //
		.setGivenName(ldapUser.getGivenName()) //
		.setHomePhoneNumbers(
			ldapUser.getHomePhone() == null ? null : new ArrayList<String>(ldapUser.getHomePhone())) //
		.setLabeledURI(
			ldapUser.getLabeledURI() == null ? null : new ArrayList<String>(ldapUser.getLabeledURI())) //
		.setLastName(ldapUser.getLastName()) //
		.setMail(ldapUser.getMail() == null ? null : new ArrayList<String>(ldapUser.getMail())) //
		.setMobilePhoneNumbers(
			ldapUser.getMobile() == null ? null : new ArrayList<String>(ldapUser.getMobile())) //
		.setPhoneNumbers(ldapUser.getTelephoneNumber() == null ? null
			: new ArrayList<String>(ldapUser.getTelephoneNumber())) //
		.setPostalAddress(toRestPostalAddress(ldapUser.getPostalAddress())) //
		.setUserName(ldapUser.getUserName()) //
		.setBillingAddress(toRestPostalAddress(ldapUser.getRegisteredAddress()));
	return builder.build();
    }

    public static final PostalAddress toRestPostalAddress(final Collection<String> address) {
	if (address == null || address.isEmpty()) {
	    return null;
	}
	try {
	    final PostalAddressBuilder addressBuilder = PostalAddress.builder();
	    final String[] tokens = address.iterator().next().split("\\$");
	    // compatability for existing short-form address entries
	    if (tokens.length <= 3) {
		for (int i = 0; i < tokens.length; i++) {
		    if (" ".equals(tokens[i])) {
			continue;
		    }
		    switch (i) {
		    case 0:
			addressBuilder.setStreet(tokens[i]);
			break;
		    case 1:
			if (tokens[i].indexOf(" ") != -1) {
			    final String postalCode = tokens[i].substring(0, tokens[i].indexOf(" "));
			    final String localityName = tokens[i].substring(tokens[i].indexOf(" ") + 1);
			    addressBuilder.setPostalCode(postalCode);
			    addressBuilder.setLocalityName(localityName);
			}
			break;
		    case 2:
			addressBuilder.setCountry(tokens[i]);
			break;
		    }
		}
	    } else {
		for (int i = 0; i < tokens.length; i++) {
		    if (" ".equals(tokens[i])) {
			continue;
		    }
		    switch (i) {
		    case 0:
			addressBuilder.setOtherRecipientInformation(tokens[i]);
			break;
		    case 1:
			addressBuilder.setStreet(tokens[i]);
			break;
		    case 2:
			addressBuilder.setPostalCode(tokens[i]);
			break;
		    case 3:
			addressBuilder.setLocalityName(tokens[i]);
			break;
		    case 4:
			addressBuilder.setStateOrProvinceName(tokens[i]);
			break;
		    case 5:
			addressBuilder.setCountry(tokens[i]);
			break;
		    }
		}
	    }
	    return addressBuilder.build();
	} catch (Exception e) {
	    e.printStackTrace();
	    LOGGER.warn(String.format("unable to process postalAddress: %s", String.join(", ", address)));
	    return null;
	}
    }

    public static final LdapGroup toLdapGroup(final UserGroupCreateRequest userGroupCreateRequest) {
	return LdapGroup.builder() //
		.withName(userGroupCreateRequest.getName()) //
		.withDescription(userGroupCreateRequest.getDescription()) //
		.withGroupMembers(userGroupCreateRequest.getMembers()) //
		.build();
    }

    public static final UserGroup toRestUserGroup(final LdapGroup ldapGroup) {
	return UserGroup.builder() //
		.setDn(ldapGroup.getDn()) //
		.setName(ldapGroup.getName()) //
		.setDescription(ldapGroup.getDescription()) //
		.setMembers(ldapGroup.getGroupMembers() == null ? Collections.emptyList()
			: new ArrayList<String>(ldapGroup.getGroupMembers())) //
		.build();
    }

    public static final LdapGroup toLdapGroup(final UserGroupBase userGroupBase, final String dn) {
	return LdapGroup.builder() //
		.withDn(dn) //
		.withDescription(userGroupBase.getDescription()) //
		.withGroupMembers(userGroupBase.getMembers()) //
		.build();
    }

}
