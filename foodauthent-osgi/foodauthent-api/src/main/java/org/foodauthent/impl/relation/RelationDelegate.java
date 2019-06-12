package org.foodauthent.impl.relation;

import java.util.UUID;

public interface RelationDelegate {

    public static final String PRODUCT = "product";
    public static final String SAMPLE = "sample";
    
    public String getEntityName();
    
    public Object getRelations(final String referencedEntity, final UUID faId, Integer pageNumber,
	    Integer pageSize);
    
}
