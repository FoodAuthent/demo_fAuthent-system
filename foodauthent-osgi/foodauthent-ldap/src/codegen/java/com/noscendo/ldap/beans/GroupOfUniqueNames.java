
package com.noscendo.ldap.beans;

import java.util.Collection;
import org.ldaptive.LdapUtils;
import org.ldaptive.beans.Attribute;
import org.ldaptive.beans.Entry;


/**
 * Ldaptive generated bean for objectClass 'groupOfUniqueNames'
 * 
 */
@Entry(dn = "dn", attributes = {
    @Attribute(name = "businessCategory"),
    @Attribute(name = "cn", property = "commonName"),
    @Attribute(name = "description"),
    @Attribute(name = "o", property = "organization"),
    @Attribute(name = "ou"),
    @Attribute(name = "owner"),
    @Attribute(name = "seeAlso"),
    @Attribute(name = "uniqueMember")
})
public class GroupOfUniqueNames {

    private String dn;
    private Collection<String> businessCategory;
    private Collection<String> commonName;
    private Collection<String> description;
    private Collection<String> organization;
    private Collection<String> ou;
    private Collection<String> owner;
    private Collection<String> seeAlso;
    private Collection<String> uniqueMember;

    public String getDn() {
        return dn;
    }

    public void setDn(String s) {
        this.dn = s;
    }

    public Collection<String> getBusinessCategory() {
        return businessCategory;
    }

    public void setBusinessCategory(Collection<String> c) {
        this.businessCategory = c;
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

    public Collection<String> getOrganization() {
        return organization;
    }

    public void setOrganization(Collection<String> c) {
        this.organization = c;
    }

    public Collection<String> getOu() {
        return ou;
    }

    public void setOu(Collection<String> c) {
        this.ou = c;
    }

    public Collection<String> getOwner() {
        return owner;
    }

    public void setOwner(Collection<String> c) {
        this.owner = c;
    }

    public Collection<String> getSeeAlso() {
        return seeAlso;
    }

    public void setSeeAlso(Collection<String> c) {
        this.seeAlso = c;
    }

    public Collection<String> getUniqueMember() {
        return uniqueMember;
    }

    public void setUniqueMember(Collection<String> c) {
        this.uniqueMember = c;
    }

    @Override
    public int hashCode() {
        return LdapUtils.computeHashCode(7919, this.dn, this.businessCategory, this.commonName, this.description, this.organization, this.ou, this.owner, this.seeAlso, this.uniqueMember);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof GroupOfUniqueNames) {
            GroupOfUniqueNames v = ((GroupOfUniqueNames) o);
            return ((((((((LdapUtils.areEqual(dn, v.dn)&&LdapUtils.areEqual(businessCategory, v.businessCategory))&&LdapUtils.areEqual(commonName, v.commonName))&&LdapUtils.areEqual(description, v.description))&&LdapUtils.areEqual(organization, v.organization))&&LdapUtils.areEqual(ou, v.ou))&&LdapUtils.areEqual(owner, v.owner))&&LdapUtils.areEqual(seeAlso, v.seeAlso))&&LdapUtils.areEqual(uniqueMember, v.uniqueMember));
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("[%s@%d::dn=%s, businessCategory=%s, commonName=%s, description=%s, organization=%s, ou=%s, owner=%s, seeAlso=%s, uniqueMember=%s]", this.getClass().getName(), this.hashCode(), this.dn, this.businessCategory, this.commonName, this.description, this.organization, this.ou, this.owner, this.seeAlso, this.uniqueMember);
    }

}
