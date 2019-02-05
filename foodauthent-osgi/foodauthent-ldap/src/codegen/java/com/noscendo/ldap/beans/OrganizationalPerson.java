
package com.noscendo.ldap.beans;

import java.util.Collection;
import org.ldaptive.LdapUtils;
import org.ldaptive.beans.Attribute;
import org.ldaptive.beans.Entry;


/**
 * Ldaptive generated bean for objectClass 'organizationalPerson'
 * 
 */
@Entry(dn = "dn", attributes = {
    @Attribute(name = "destinationIndicator"),
    @Attribute(name = "facsimileTelephoneNumber"),
    @Attribute(name = "internationaliSDNNumber"),
    @Attribute(name = "l", property = "localityName"),
    @Attribute(name = "ou"),
    @Attribute(name = "physicalDeliveryOfficeName"),
    @Attribute(name = "postOfficeBox"),
    @Attribute(name = "postalAddress"),
    @Attribute(name = "postalCode"),
    @Attribute(name = "preferredDeliveryMethod"),
    @Attribute(name = "registeredAddress"),
    @Attribute(name = "st", property = "stateOrProvinceName"),
    @Attribute(name = "street"),
    @Attribute(name = "telephoneNumber"),
    @Attribute(name = "teletexTerminalIdentifier"),
    @Attribute(name = "telexNumber", binary = true),
    @Attribute(name = "title"),
    @Attribute(name = "x121Address")
})
public class OrganizationalPerson {

    private String dn;
    private Collection<String> destinationIndicator;
    private Collection<String> facsimileTelephoneNumber;
    private Collection<Integer> internationaliSDNNumber;
    private Collection<String> localityName;
    private Collection<String> ou;
    private Collection<String> physicalDeliveryOfficeName;
    private Collection<String> postOfficeBox;
    private Collection<String> postalAddress;
    private Collection<String> postalCode;
    private String preferredDeliveryMethod;
    private Collection<String> registeredAddress;
    private Collection<String> stateOrProvinceName;
    private Collection<String> street;
    private Collection<String> telephoneNumber;
    private Collection<String> teletexTerminalIdentifier;
    private Collection<byte[]> telexNumber;
    private Collection<String> title;
    private Collection<Integer> x121Address;

    public String getDn() {
        return dn;
    }

    public void setDn(String s) {
        this.dn = s;
    }

    public Collection<String> getDestinationIndicator() {
        return destinationIndicator;
    }

    public void setDestinationIndicator(Collection<String> c) {
        this.destinationIndicator = c;
    }

    public Collection<String> getFacsimileTelephoneNumber() {
        return facsimileTelephoneNumber;
    }

    public void setFacsimileTelephoneNumber(Collection<String> c) {
        this.facsimileTelephoneNumber = c;
    }

    public Collection<Integer> getInternationaliSDNNumber() {
        return internationaliSDNNumber;
    }

    public void setInternationaliSDNNumber(Collection<Integer> c) {
        this.internationaliSDNNumber = c;
    }

    public Collection<String> getLocalityName() {
        return localityName;
    }

    public void setLocalityName(Collection<String> c) {
        this.localityName = c;
    }

    public Collection<String> getOu() {
        return ou;
    }

    public void setOu(Collection<String> c) {
        this.ou = c;
    }

    public Collection<String> getPhysicalDeliveryOfficeName() {
        return physicalDeliveryOfficeName;
    }

    public void setPhysicalDeliveryOfficeName(Collection<String> c) {
        this.physicalDeliveryOfficeName = c;
    }

    public Collection<String> getPostOfficeBox() {
        return postOfficeBox;
    }

    public void setPostOfficeBox(Collection<String> c) {
        this.postOfficeBox = c;
    }

    public Collection<String> getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(Collection<String> c) {
        this.postalAddress = c;
    }

    public Collection<String> getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Collection<String> c) {
        this.postalCode = c;
    }

    public String getPreferredDeliveryMethod() {
        return preferredDeliveryMethod;
    }

    public void setPreferredDeliveryMethod(String s) {
        this.preferredDeliveryMethod = s;
    }

    public Collection<String> getRegisteredAddress() {
        return registeredAddress;
    }

    public void setRegisteredAddress(Collection<String> c) {
        this.registeredAddress = c;
    }

    public Collection<String> getStateOrProvinceName() {
        return stateOrProvinceName;
    }

    public void setStateOrProvinceName(Collection<String> c) {
        this.stateOrProvinceName = c;
    }

    public Collection<String> getStreet() {
        return street;
    }

    public void setStreet(Collection<String> c) {
        this.street = c;
    }

    public Collection<String> getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(Collection<String> c) {
        this.telephoneNumber = c;
    }

    public Collection<String> getTeletexTerminalIdentifier() {
        return teletexTerminalIdentifier;
    }

    public void setTeletexTerminalIdentifier(Collection<String> c) {
        this.teletexTerminalIdentifier = c;
    }

    public Collection<byte[]> getTelexNumber() {
        return telexNumber;
    }

    public void setTelexNumber(Collection<byte[]> c) {
        this.telexNumber = c;
    }

    public Collection<String> getTitle() {
        return title;
    }

    public void setTitle(Collection<String> c) {
        this.title = c;
    }

    public Collection<Integer> getX121Address() {
        return x121Address;
    }

    public void setX121Address(Collection<Integer> c) {
        this.x121Address = c;
    }

    @Override
    public int hashCode() {
        return LdapUtils.computeHashCode(7919, this.dn, this.destinationIndicator, this.facsimileTelephoneNumber, this.internationaliSDNNumber, this.localityName, this.ou, this.physicalDeliveryOfficeName, this.postOfficeBox, this.postalAddress, this.postalCode, this.preferredDeliveryMethod, this.registeredAddress, this.stateOrProvinceName, this.street, this.telephoneNumber, this.teletexTerminalIdentifier, this.telexNumber, this.title, this.x121Address);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof OrganizationalPerson) {
            OrganizationalPerson v = ((OrganizationalPerson) o);
            return ((((((((((((((((((LdapUtils.areEqual(dn, v.dn)&&LdapUtils.areEqual(destinationIndicator, v.destinationIndicator))&&LdapUtils.areEqual(facsimileTelephoneNumber, v.facsimileTelephoneNumber))&&LdapUtils.areEqual(internationaliSDNNumber, v.internationaliSDNNumber))&&LdapUtils.areEqual(localityName, v.localityName))&&LdapUtils.areEqual(ou, v.ou))&&LdapUtils.areEqual(physicalDeliveryOfficeName, v.physicalDeliveryOfficeName))&&LdapUtils.areEqual(postOfficeBox, v.postOfficeBox))&&LdapUtils.areEqual(postalAddress, v.postalAddress))&&LdapUtils.areEqual(postalCode, v.postalCode))&&LdapUtils.areEqual(preferredDeliveryMethod, v.preferredDeliveryMethod))&&LdapUtils.areEqual(registeredAddress, v.registeredAddress))&&LdapUtils.areEqual(stateOrProvinceName, v.stateOrProvinceName))&&LdapUtils.areEqual(street, v.street))&&LdapUtils.areEqual(telephoneNumber, v.telephoneNumber))&&LdapUtils.areEqual(teletexTerminalIdentifier, v.teletexTerminalIdentifier))&&LdapUtils.areEqual(telexNumber, v.telexNumber))&&LdapUtils.areEqual(title, v.title))&&LdapUtils.areEqual(x121Address, v.x121Address));
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("[%s@%d::dn=%s, destinationIndicator=%s, facsimileTelephoneNumber=%s, internationaliSDNNumber=%s, localityName=%s, ou=%s, physicalDeliveryOfficeName=%s, postOfficeBox=%s, postalAddress=%s, postalCode=%s, preferredDeliveryMethod=%s, registeredAddress=%s, stateOrProvinceName=%s, street=%s, telephoneNumber=%s, teletexTerminalIdentifier=%s, telexNumber=%s, title=%s, x121Address=%s]", this.getClass().getName(), this.hashCode(), this.dn, this.destinationIndicator, this.facsimileTelephoneNumber, this.internationaliSDNNumber, this.localityName, this.ou, this.physicalDeliveryOfficeName, this.postOfficeBox, this.postalAddress, this.postalCode, this.preferredDeliveryMethod, this.registeredAddress, this.stateOrProvinceName, this.street, this.telephoneNumber, this.teletexTerminalIdentifier, this.telexNumber, this.title, this.x121Address);
    }

}
