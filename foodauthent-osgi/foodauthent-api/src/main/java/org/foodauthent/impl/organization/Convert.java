package org.foodauthent.impl.organization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.foodauthent.model.Organization;
import org.foodauthent.model.Organization.OrganizationBuilder;
import org.foodauthent.model.OrganizationBase;
import org.foodauthent.model.OrganizationalPostalAddress;
import org.foodauthent.model.OrganizationalPostalAddress.OrganizationalPostalAddressBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.foodauthent.api.internal.people.OrganizationalUnitService;
import com.google.common.base.Strings;

class Convert {
    private static final Logger LOGGER = LoggerFactory.getLogger(Convert.class);

    public static final org.foodauthent.people.Organization toOrganization(final String dn,
	    final OrganizationBase organizationBase, final OrganizationalUnitService<org.foodauthent.people.Organization> organizationalUnitService) {
	final org.foodauthent.people.Organization org = organizationalUnitService.newEntryInstance(dn);
		org.setBusinessCategory(organizationBase.getBusinessCategory());
		org.setDescription(organizationBase.getDescription());
		org.setFacsimileTelephoneNumber(organizationBase.getFaxNumbers());
		org.setTelephoneNumber(organizationBase.getPhoneNumbers());
	final OrganizationalPostalAddress billingAddress = organizationBase.getBillingAddress();
	if (billingAddress != null) {
	    org.setRegisteredAddress(toAddressList(billingAddress));
	}
	final OrganizationalPostalAddress postalAddress = organizationBase.getPostalAddress();
	if (postalAddress != null) {
	    org.setLocalityName(postalAddress.getLocalityName());
	    org.setPostalCode(postalAddress.getPostalCode());
	    org.setStateOrProvinceName(postalAddress.getStateOrProvinceName());
	    org.setPostalAddress(toAddressList(postalAddress));
	}
	return org;
    }

    public static final List<String> toAddressList(final OrganizationalPostalAddress organizationalPostalAddress) {
	final List<String> address = new ArrayList<>();
	address.add(Strings.nullToEmpty(organizationalPostalAddress.getRecipientName()));
	address.add(Strings.nullToEmpty(organizationalPostalAddress.getOtherRecipientInformation()));
	address.add(Strings.nullToEmpty(organizationalPostalAddress.getStreet()));
	address.add(Strings.nullToEmpty(organizationalPostalAddress.getPostalCode()));
	address.add(Strings.nullToEmpty(organizationalPostalAddress.getLocalityName()));
	address.add(Strings.nullToEmpty(organizationalPostalAddress.getStateOrProvinceName()));
	address.add(Strings.nullToEmpty(organizationalPostalAddress.getCountry()));
	return Arrays.asList(
		String.join("$", address.stream().map(a -> a.isEmpty() ? " " : a).collect(Collectors.toList())));

    }

    public static final Organization toRestOrganization(org.foodauthent.people.Organization organization) {
	final OrganizationBuilder builder = Organization.builder() //
		.setBusinessCategory(organization.getBusinessCategory()) //
		.setDescription(organization.getDescription()) //
		.setDn(organization.getDn()) //
		.setFaxNumbers(organization.getFacsimileTelephoneNumber() == null ? null
			: new ArrayList<String>(organization.getFacsimileTelephoneNumber())) //
		.setPhoneNumbers(organization.getTelephoneNumber() == null ? null
			: new ArrayList<String>(organization.getTelephoneNumber())) //
		.setOrganizationName(organization.getName()) //
		.setBillingAddress(toRestOrganizationalPostalAddress(organization.getRegisteredAddress())) //
		.setPostalAddress(toRestOrganizationalPostalAddress(organization.getPostalAddress()));
	return builder.build();
    }

    public static final OrganizationalPostalAddress toRestOrganizationalPostalAddress(
	    final Collection<String> address) {
	if (address == null || address.isEmpty()) {
	    return null;
	}
	try {
	    final OrganizationalPostalAddressBuilder addressBuilder = OrganizationalPostalAddress.builder();
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
			addressBuilder.setRecipientName(tokens[i]);
			break;
		    case 1:
			addressBuilder.setOtherRecipientInformation(tokens[i]);
			break;
		    case 2:
			addressBuilder.setStreet(tokens[i]);
			break;
		    case 3:
			addressBuilder.setPostalCode(tokens[i]);
			break;
		    case 4:
			addressBuilder.setLocalityName(tokens[i]);
			break;
		    case 5:
			addressBuilder.setStateOrProvinceName(tokens[i]);
			break;
		    case 6:
			addressBuilder.setCountry(tokens[i]);
			break;
		    }
		}
	    }
	    return addressBuilder.build();
	} catch (Exception e) {
	    LOGGER.warn(String.format("unable to process postalAddress: %s", String.join(", ", address)));
	    return null;
	}
    }
}
