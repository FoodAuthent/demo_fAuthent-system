
package com.noscendo.ldap.beans;

import java.util.Collection;
import org.ldaptive.LdapUtils;
import org.ldaptive.beans.Attribute;
import org.ldaptive.beans.Entry;


/**
 * Ldaptive generated bean for objectClass 'top'
 * 
 */
@Entry(dn = "dn", attributes = {
    @Attribute(name = "objectClass")
})
public class Top {

    private String dn;
    private Collection<String> objectClass;

    public String getDn() {
        return dn;
    }

    public void setDn(String s) {
        this.dn = s;
    }

    public Collection<String> getObjectClass() {
        return objectClass;
    }

    public void setObjectClass(Collection<String> c) {
        this.objectClass = c;
    }

    @Override
    public int hashCode() {
        return LdapUtils.computeHashCode(7919, this.dn, this.objectClass);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof Top) {
            Top v = ((Top) o);
            return (LdapUtils.areEqual(dn, v.dn)&&LdapUtils.areEqual(objectClass, v.objectClass));
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("[%s@%d::dn=%s, objectClass=%s]", this.getClass().getName(), this.hashCode(), this.dn, this.objectClass);
    }

}
