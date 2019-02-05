
package com.noscendo.ldap.beans;

import java.util.Collection;
import org.ldaptive.LdapUtils;
import org.ldaptive.beans.Attribute;
import org.ldaptive.beans.Entry;


/**
 * Ldaptive generated bean for objectClass 'person'
 * 
 */
@Entry(dn = "dn", attributes = {
    @Attribute(name = "cn", property = "commonName"),
    @Attribute(name = "description"),
    @Attribute(name = "sn", property = "lastName"),
    @Attribute(name = "seeAlso"),
    @Attribute(name = "telephoneNumber")
})
public class Person {

    private String dn;
    private Collection<String> commonName;
    private Collection<String> description;
    private Collection<String> lastName;
    private Collection<String> seeAlso;
    private Collection<String> telephoneNumber;

    public String getDn() {
        return dn;
    }

    public void setDn(String s) {
        this.dn = s;
    }

    public Collection<String> getCommonName() {
        return commonName;
    }

    public void setCommonName(Collection<String> c) {
        this.commonName = c;
    }

    public Collection<String> getDescription() {
        return description;
    }

    public void setDescription(Collection<String> c) {
        this.description = c;
    }

    public Collection<String> getLastName() {
        return lastName;
    }

    public void setLastName(Collection<String> c) {
        this.lastName = c;
    }

    public Collection<String> getSeeAlso() {
        return seeAlso;
    }

    public void setSeeAlso(Collection<String> c) {
        this.seeAlso = c;
    }

    public Collection<String> getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(Collection<String> c) {
        this.telephoneNumber = c;
    }

    @Override
    public int hashCode() {
        return LdapUtils.computeHashCode(7919, this.dn, this.commonName, this.description, this.lastName, this.seeAlso, this.telephoneNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof Person) {
            Person v = ((Person) o);
            return (((((LdapUtils.areEqual(dn, v.dn)&&LdapUtils.areEqual(commonName, v.commonName))&&LdapUtils.areEqual(description, v.description))&&LdapUtils.areEqual(lastName, v.lastName))&&LdapUtils.areEqual(seeAlso, v.seeAlso))&&LdapUtils.areEqual(telephoneNumber, v.telephoneNumber));
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("[%s@%d::dn=%s, commonName=%s, description=%s, lastName=%s, seeAlso=%s, telephoneNumber=%s]", this.getClass().getName(), this.hashCode(), this.dn, this.commonName, this.description, this.lastName, this.seeAlso, this.telephoneNumber);
    }

}
