package org.foodauthent.people;

import java.util.Collection;

public interface Group {

	String getDn();

	void setDn(String dn);
	
	String getName();

	void setName(String name);

	String getDescription();

	void setDescription(String description);

	Collection<String> getGroupMembers();

	void setGroupMembers(Collection<String> groupMembers);

}