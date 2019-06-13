package org.foodauthent.impl.relation;

import java.util.UUID;

public interface RelationDelegate {

    public static final String PRODUCT = "product";
    public static final String SAMPLE = "sample";
    public static final String WORKFLOW = "workflow";
    public static final String FINGERPRINT = "fingerprint";
    public static final String MODEL = "model";
    public static final String SOP = "sop";
    public static final String PREDICTION = "prediction";
    public static final String TRAINING_JOB ="trainingJob";
    
    public String getEntityName();
    
    public Object getRelations(final String referencedEntity, final UUID faId, Integer pageNumber,
	    Integer pageSize);
    
}
