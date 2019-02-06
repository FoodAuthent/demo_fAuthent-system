package org.foodauthent.impl.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.foodauthent.model.PostalAddress;
import org.foodauthent.model.PostalAddress.PostalAddressBuilder;
import org.foodauthent.model.User;
import org.foodauthent.model.User.UserBuilder;
import org.foodauthent.model.UserBase;
import org.foodauthent.model.UserGroup;
import org.foodauthent.model.UserGroupBase;
import org.foodauthent.model.UserGroupCreateRequest;
import org.foodauthent.people.Group;
import org.foodauthent.people.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.foodauthent.api.internal.people.GroupService;
import com.foodauthent.api.internal.people.PersonService;
import com.google.common.base.Strings;

class Convert {

    private static final Logger LOGGER = LoggerFactory.getLogger(Convert.class);

    public static final Person toPerson(final String dn, final UserBase userBase,
	    final PersonService<Person> personService) {
	final Person person = personService.newEntryInstance(dn);
	person.setCommonName(userBase.getGivenName() + " " + userBase.getLastName());
	person.setDescription(userBase.getDescription());
	person.setBusinessCategory(userBase.getBusinessCategory());
	person.setDescription(userBase.getDescription());
	person.setEmployeeNumber(userBase.getEmployeeNumber());
	person.setEmployeeType(userBase.getEmployeeType());
	person.setFacsimileTelephoneNumber(userBase.getFaxNumbers());
	person.setGivenName(userBase.getGivenName());
	person.setHomePhone(userBase.getHomePhoneNumbers());
	person.setLabeledURI(userBase.getLabeledURI());
	person.setLastName(userBase.getLastName());
	person.setMail(userBase.getMail());
	person.setMobile(userBase.getMobilePhoneNumbers());
	person.setTelephoneNumber(userBase.getPhoneNumbers());
	final PostalAddress postalAddress = userBase.getPostalAddress();
	if (postalAddress != null) {
	    person.setLocalityName(Arrays.asList(postalAddress.getLocalityName()));
	    person.setPostalCode(Arrays.asList(postalAddress.getPostalCode()));
	    person.setStateOrProvinceName(Arrays.asList(postalAddress.getStateOrProvinceName()));
	    person.setPostalAddress(toAddressList(postalAddress));
	}
	final PostalAddress billingAddress = userBase.getBillingAddress();
	if (billingAddress != null) {
	    person.setRegisteredAddress(toAddressList(billingAddress));
	}
	return person;
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

    public static final User toRestUser(Person person) {
	final UserBuilder builder = User.builder() //
		.setDescription(person.getDescription()) //
		.setDn(person.getDn()) //
		.setBusinessCategory(person.getBusinessCategory()) //
		.setDescription(person.getDescription()) //
		.setEmployeeNumber(person.getEmployeeNumber()) //
		.setEmployeeType(person.getEmployeeType()) //
		.setFaxNumbers(person.getFacsimileTelephoneNumber() == null ? null
			: new ArrayList<String>(person.getFacsimileTelephoneNumber())) //
		.setGivenName(person.getGivenName()) //
		.setHomePhoneNumbers(
			person.getHomePhone() == null ? null : new ArrayList<String>(person.getHomePhone())) //
		.setLabeledURI(person.getLabeledURI() == null ? null : new ArrayList<String>(person.getLabeledURI())) //
		.setLastName(person.getLastName()) //
		.setMail(person.getMail() == null ? null : new ArrayList<String>(person.getMail())) //
		.setMobilePhoneNumbers(person.getMobile() == null ? null : new ArrayList<String>(person.getMobile())) //
		.setPhoneNumbers(
			person.getTelephoneNumber() == null ? null : new ArrayList<String>(person.getTelephoneNumber())) //
		.setPostalAddress(toRestPostalAddress(person.getPostalAddress())) //
		.setUserName(person.getUserName()) //
		.setBillingAddress(toRestPostalAddress(person.getRegisteredAddress()));
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

    public static final Group toLdapGroup(final UserGroupCreateRequest userGroupCreateRequest,
	    final GroupService<Group> groupService) {
	final Group group = groupService.newEntryInstance(null);
	group.setName(userGroupCreateRequest.getName());
	group.setDescription(userGroupCreateRequest.getDescription());
	group.setGroupMembers(userGroupCreateRequest.getMembers());
	return group;
    }

    public static final UserGroup toRestUserGroup(final Group group) {
	return UserGroup.builder() //
		.setDn(group.getDn()) //
		.setName(group.getName()) //
		.setDescription(group.getDescription()) //
		.setMembers(group.getGroupMembers() == null ? Collections.emptyList()
			: new ArrayList<String>(group.getGroupMembers())) //
		.build();
    }

    public static final Group toLdapGroup(final UserGroupBase userGroupBase, final String dn,
	    final GroupService<Group> groupService) {
	final Group group = groupService.newEntryInstance(dn);
	group.setDescription(userGroupBase.getDescription());
	group.setGroupMembers(userGroupBase.getMembers());
	return group;
    }

}
