
package com.noscendo.ldap.beans;

import java.security.cert.Certificate;
import java.util.Collection;
import org.ldaptive.LdapUtils;
import org.ldaptive.beans.Attribute;
import org.ldaptive.beans.Entry;


/**
 * Ldaptive generated bean for objectClass 'inetOrgPerson'
 * 
 */
@Entry(dn = "dn", attributes = {
    @Attribute(name = "audio", binary = true),
    @Attribute(name = "businessCategory"),
    @Attribute(name = "carLicense"),
    @Attribute(name = "departmentNumber"),
    @Attribute(name = "displayName"),
    @Attribute(name = "employeeNumber"),
    @Attribute(name = "employeeType"),
    @Attribute(name = "givenName"),
    @Attribute(name = "homePhone"),
    @Attribute(name = "homePostalAddress"),
    @Attribute(name = "initials"),
    @Attribute(name = "jpegPhoto", binary = true),
    @Attribute(name = "labeledURI"),
    @Attribute(name = "mail"),
    @Attribute(name = "manager"),
    @Attribute(name = "mobile"),
    @Attribute(name = "o", property = "organization"),
    @Attribute(name = "pager"),
    @Attribute(name = "photo", binary = true),
    @Attribute(name = "preferredLanguage"),
    @Attribute(name = "roomNumber"),
    @Attribute(name = "secretary"),
    @Attribute(name = "uid"),
    @Attribute(name = "userCertificate"),
    @Attribute(name = "userPKCS12", binary = true),
    @Attribute(name = "userSMIMECertificate", binary = true),
    @Attribute(name = "x500UniqueIdentifier")
})
public class InetOrgPerson {

    private String dn;
    private Collection<byte[]> audio;
    private Collection<String> businessCategory;
    private Collection<String> carLicense;
    private Collection<String> departmentNumber;
    private String displayName;
    private String employeeNumber;
    private Collection<String> employeeType;
    private Collection<String> givenName;
    private Collection<String> homePhone;
    private Collection<String> homePostalAddress;
    private Collection<String> initials;
    private Collection<byte[]> jpegPhoto;
    private Collection<String> labeledURI;
    private Collection<String> mail;
    private Collection<String> manager;
    private Collection<String> mobile;
    private Collection<String> organization;
    private Collection<String> pager;
    private Collection<byte[]> photo;
    private String preferredLanguage;
    private Collection<String> roomNumber;
    private Collection<String> secretary;
    private Collection<String> uid;
    private Collection<Certificate> userCertificate;
    private Collection<byte[]> userPKCS12;
    private Collection<byte[]> userSMIMECertificate;
    private Collection<String> x500UniqueIdentifier;

    public String getDn() {
        return dn;
    }

    public void setDn(String s) {
        this.dn = s;
    }

    public Collection<byte[]> getAudio() {
        return audio;
    }

    public void setAudio(Collection<byte[]> c) {
        this.audio = c;
    }

    public Collection<String> getBusinessCategory() {
        return businessCategory;
    }

    public void setBusinessCategory(Collection<String> c) {
        this.businessCategory = c;
    }

    public Collection<String> getCarLicense() {
        return carLicense;
    }

    public void setCarLicense(Collection<String> c) {
        this.carLicense = c;
    }

    public Collection<String> getDepartmentNumber() {
        return departmentNumber;
    }

    public void setDepartmentNumber(Collection<String> c) {
        this.departmentNumber = c;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String s) {
        this.displayName = s;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String s) {
        this.employeeNumber = s;
    }

    public Collection<String> getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(Collection<String> c) {
        this.employeeType = c;
    }

    public Collection<String> getGivenName() {
        return givenName;
    }

    public void setGivenName(Collection<String> c) {
        this.givenName = c;
    }

    public Collection<String> getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(Collection<String> c) {
        this.homePhone = c;
    }

    public Collection<String> getHomePostalAddress() {
        return homePostalAddress;
    }

    public void setHomePostalAddress(Collection<String> c) {
        this.homePostalAddress = c;
    }

    public Collection<String> getInitials() {
        return initials;
    }

    public void setInitials(Collection<String> c) {
        this.initials = c;
    }

    public Collection<byte[]> getJpegPhoto() {
        return jpegPhoto;
    }

    public void setJpegPhoto(Collection<byte[]> c) {
        this.jpegPhoto = c;
    }

    public Collection<String> getLabeledURI() {
        return labeledURI;
    }

    public void setLabeledURI(Collection<String> c) {
        this.labeledURI = c;
    }

    public Collection<String> getMail() {
        return mail;
    }

    public void setMail(Collection<String> c) {
        this.mail = c;
    }

    public Collection<String> getManager() {
        return manager;
    }

    public void setManager(Collection<String> c) {
        this.manager = c;
    }

    public Collection<String> getMobile() {
        return mobile;
    }

    public void setMobile(Collection<String> c) {
        this.mobile = c;
    }

    public Collection<String> getOrganization() {
        return organization;
    }

    public void setOrganization(Collection<String> c) {
        this.organization = c;
    }

    public Collection<String> getPager() {
        return pager;
    }

    public void setPager(Collection<String> c) {
        this.pager = c;
    }

    public Collection<byte[]> getPhoto() {
        return photo;
    }

    public void setPhoto(Collection<byte[]> c) {
        this.photo = c;
    }

    public String getPreferredLanguage() {
        return preferredLanguage;
    }

    public void setPreferredLanguage(String s) {
        this.preferredLanguage = s;
    }

    public Collection<String> getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Collection<String> c) {
        this.roomNumber = c;
    }

    public Collection<String> getSecretary() {
        return secretary;
    }

    public void setSecretary(Collection<String> c) {
        this.secretary = c;
    }

    public Collection<String> getUid() {
        return uid;
    }

    public void setUid(Collection<String> c) {
        this.uid = c;
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
        return LdapUtils.computeHashCode(7919, this.dn, this.audio, this.businessCategory, this.carLicense, this.departmentNumber, this.displayName, this.employeeNumber, this.employeeType, this.givenName, this.homePhone, this.homePostalAddress, this.initials, this.jpegPhoto, this.labeledURI, this.mail, this.manager, this.mobile, this.organization, this.pager, this.photo, this.preferredLanguage, this.roomNumber, this.secretary, this.uid, this.userCertificate, this.userPKCS12, this.userSMIMECertificate, this.x500UniqueIdentifier);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof InetOrgPerson) {
            InetOrgPerson v = ((InetOrgPerson) o);
            return (((((((((((((((((((((((((((LdapUtils.areEqual(dn, v.dn)&&LdapUtils.areEqual(audio, v.audio))&&LdapUtils.areEqual(businessCategory, v.businessCategory))&&LdapUtils.areEqual(carLicense, v.carLicense))&&LdapUtils.areEqual(departmentNumber, v.departmentNumber))&&LdapUtils.areEqual(displayName, v.displayName))&&LdapUtils.areEqual(employeeNumber, v.employeeNumber))&&LdapUtils.areEqual(employeeType, v.employeeType))&&LdapUtils.areEqual(givenName, v.givenName))&&LdapUtils.areEqual(homePhone, v.homePhone))&&LdapUtils.areEqual(homePostalAddress, v.homePostalAddress))&&LdapUtils.areEqual(initials, v.initials))&&LdapUtils.areEqual(jpegPhoto, v.jpegPhoto))&&LdapUtils.areEqual(labeledURI, v.labeledURI))&&LdapUtils.areEqual(mail, v.mail))&&LdapUtils.areEqual(manager, v.manager))&&LdapUtils.areEqual(mobile, v.mobile))&&LdapUtils.areEqual(organization, v.organization))&&LdapUtils.areEqual(pager, v.pager))&&LdapUtils.areEqual(photo, v.photo))&&LdapUtils.areEqual(preferredLanguage, v.preferredLanguage))&&LdapUtils.areEqual(roomNumber, v.roomNumber))&&LdapUtils.areEqual(secretary, v.secretary))&&LdapUtils.areEqual(uid, v.uid))&&LdapUtils.areEqual(userCertificate, v.userCertificate))&&LdapUtils.areEqual(userPKCS12, v.userPKCS12))&&LdapUtils.areEqual(userSMIMECertificate, v.userSMIMECertificate))&&LdapUtils.areEqual(x500UniqueIdentifier, v.x500UniqueIdentifier));
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("[%s@%d::dn=%s, audio=%s, businessCategory=%s, carLicense=%s, departmentNumber=%s, displayName=%s, employeeNumber=%s, employeeType=%s, givenName=%s, homePhone=%s, homePostalAddress=%s, initials=%s, jpegPhoto=%s, labeledURI=%s, mail=%s, manager=%s, mobile=%s, organization=%s, pager=%s, photo=%s, preferredLanguage=%s, roomNumber=%s, secretary=%s, uid=%s, userCertificate=%s, userPKCS12=%s, userSMIMECertificate=%s, x500UniqueIdentifier=%s]", this.getClass().getName(), this.hashCode(), this.dn, this.audio, this.businessCategory, this.carLicense, this.departmentNumber, this.displayName, this.employeeNumber, this.employeeType, this.givenName, this.homePhone, this.homePostalAddress, this.initials, this.jpegPhoto, this.labeledURI, this.mail, this.manager, this.mobile, this.organization, this.pager, this.photo, this.preferredLanguage, this.roomNumber, this.secretary, this.uid, this.userCertificate, this.userPKCS12, this.userSMIMECertificate, this.x500UniqueIdentifier);
    }

}
