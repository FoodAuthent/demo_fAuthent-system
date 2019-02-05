
package com.noscendo.ldap.beans;

import org.ldaptive.LdapUtils;
import org.ldaptive.beans.Attribute;
import org.ldaptive.beans.Entry;


/**
 * Ldaptive generated bean for objectClass 'tlsKeyInfo'
 * 
 */
@Entry(dn = "dn", attributes = {
    @Attribute(name = "keyAlgorithm"),
    @Attribute(name = "privateKey", binary = true),
    @Attribute(name = "privateKeyFormat"),
    @Attribute(name = "publicKey", binary = true),
    @Attribute(name = "publicKeyFormat")
})
public class TlsKeyInfo {

    private String dn;
    private String keyAlgorithm;
    private byte[] privateKey;
    private String privateKeyFormat;
    private byte[] publicKey;
    private String publicKeyFormat;

    public String getDn() {
        return dn;
    }

    public void setDn(String s) {
        this.dn = s;
    }

    public String getKeyAlgorithm() {
        return keyAlgorithm;
    }

    public void setKeyAlgorithm(String s) {
        this.keyAlgorithm = s;
    }

    public byte[] getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(byte[] s) {
        this.privateKey = s;
    }

    public String getPrivateKeyFormat() {
        return privateKeyFormat;
    }

    public void setPrivateKeyFormat(String s) {
        this.privateKeyFormat = s;
    }

    public byte[] getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(byte[] s) {
        this.publicKey = s;
    }

    public String getPublicKeyFormat() {
        return publicKeyFormat;
    }

    public void setPublicKeyFormat(String s) {
        this.publicKeyFormat = s;
    }

    @Override
    public int hashCode() {
        return LdapUtils.computeHashCode(7919, this.dn, this.keyAlgorithm, this.privateKey, this.privateKeyFormat, this.publicKey, this.publicKeyFormat);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof TlsKeyInfo) {
            TlsKeyInfo v = ((TlsKeyInfo) o);
            return (((((LdapUtils.areEqual(dn, v.dn)&&LdapUtils.areEqual(keyAlgorithm, v.keyAlgorithm))&&LdapUtils.areEqual(privateKey, v.privateKey))&&LdapUtils.areEqual(privateKeyFormat, v.privateKeyFormat))&&LdapUtils.areEqual(publicKey, v.publicKey))&&LdapUtils.areEqual(publicKeyFormat, v.publicKeyFormat));
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("[%s@%d::dn=%s, keyAlgorithm=%s, privateKey=%s, privateKeyFormat=%s, publicKey=%s, publicKeyFormat=%s]", this.getClass().getName(), this.hashCode(), this.dn, this.keyAlgorithm, this.privateKey, this.privateKeyFormat, this.publicKey, this.publicKeyFormat);
    }

}
