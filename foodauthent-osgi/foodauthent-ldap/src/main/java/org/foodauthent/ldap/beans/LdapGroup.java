
package org.foodauthent.ldap.beans;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

import org.foodauthent.ldap.DnUtil;
import org.foodauthent.people.Group;
import org.ldaptive.LdapUtils;
import org.ldaptive.beans.Attribute;
import org.ldaptive.beans.Entry;

@Entry(dn = "dn", attributes = { //
		@Attribute(name = "objectClass", values = { "groupOfUniqueNames" }), //
		@Attribute(name = "cn", property = "name"), //
		@Attribute(name = "description"), //
		@Attribute(name = "uniqueMember", property = "groupMembers") })
public class LdapGroup implements Dn, Group {

	private String dn;
	private String name;
	private String description;
	private Collection<String> groupMembers = new HashSet<String>();

	private LdapGroup(Builder builder) {
		this.dn = builder.dn;
		this.name = builder.name;
		this.description = builder.description;
		this.groupMembers = builder.groupMembers;
		this.dn = updateDn();
	}

	public LdapGroup() {
	}

	public LdapGroup(final String dn) {
		this.dn = dn;
	}

	public LdapGroup(final String parentDn, final String userName) {
		this.dn = String.join(",", "cn=" + userName, parentDn);
	}

	public String getDn() {
		return dn;
	}

	public void setDn(String s) {
		this.dn = s;
	}

	@Override
	public String updateDn() {
		if (name == null) {
			name = dn.substring(dn.indexOf("=") + 1, dn.indexOf(","));
		}
		return DnUtil.updateDn(this.dn, "cn", name);
	}

	public String getName() {
		return name;
	}

	public void setName(String c) {
		this.name = c;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String c) {
		this.description = c;
	}

	public Collection<String> getGroupMembers() {
		return groupMembers;
	}

	public void setGroupMembers(Collection<String> c) {
		this.groupMembers = c;
	}

	@Override
	public int hashCode() {
		return LdapUtils.computeHashCode(7919, this.dn, this.name, this.description, this.groupMembers);
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (o instanceof LdapGroup) {
			LdapGroup v = ((LdapGroup) o);
			return (((LdapUtils.areEqual(dn, v.dn) && //
					LdapUtils.areEqual(name, v.name)) && //
					LdapUtils.areEqual(description, v.description)) && //
					LdapUtils.areEqual(groupMembers, v.groupMembers));
		}
		return false;
	}

	@Override
	public String toString() {
		return String.format("[%s@%d::dn=%s, name=%s, description=%s, groupMembers=%s]", this.getClass().getName(),
				this.hashCode(), this.dn, this.name, this.description, this.groupMembers);
	}

	/**
	 * Creates builder to build {@link LdapGroup}.
	 * 
	 * @return created builder
	 */
	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Builder to build {@link LdapGroup}.
	 */
	public static final class Builder {
		private String dn;
		private String name;
		private String description;
		private Collection<String> groupMembers = Collections.emptyList();

		private Builder() {
		}

		public Builder withDn(String dn) {
			this.dn = dn;
			return this;
		}

		public Builder withName(String name) {
			this.name = name;
			return this;
		}

		public Builder withDescription(String description) {
			this.description = description;
			return this;
		}

		public Builder withGroupMembers(Collection<String> groupMembers) {
			this.groupMembers = groupMembers;
			return this;
		}

		public LdapGroup build() {
			return new LdapGroup(this);
		}
	}

}
