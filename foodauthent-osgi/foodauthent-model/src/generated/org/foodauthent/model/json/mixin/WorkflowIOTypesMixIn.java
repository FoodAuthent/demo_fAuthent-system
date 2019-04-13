/*
 * TODO	
 */
package org.foodauthent.model.json.mixin;

import org.foodauthent.model.FingerprintType;
import org.foodauthent.model.ModelType;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;



import org.foodauthent.model.WorkflowIOTypes;
import org.foodauthent.model.WorkflowIOTypes.WorkflowIOTypesBuilder;

/**
 * MixIn class for entity implementations that adds jackson annotations for de-/serialization.
 *
 * @author Martin Horn, University of Konstanz
 */
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    property = "",
    visible = true,
    defaultImpl = WorkflowIOTypes.class)
@JsonSubTypes({
    @Type(value = WorkflowIOTypes.class, name="WorkflowIOTypes")
})
@JsonDeserialize(builder=WorkflowIOTypesBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface WorkflowIOTypesMixIn {

	@JsonIgnore
	public long getPersistenceId();
	
    @JsonIgnore
    public String getTypeID();
    
   	@JsonIgnore
  	public UUID getFaId();
    

    @JsonProperty("fingerprint-type")
    public FingerprintType getFingerprintType();
    
    @JsonProperty("model-type")
    public ModelType getModelType();
    

    /**
     * MixIn class for entity builder implementations that adds jackson annotations for the de-/serialization.
     *
     * @author Martin Horn, University of Konstanz
     */
    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "",
        defaultImpl = WorkflowIOTypesBuilder.class)
    @JsonSubTypes({
        @Type(value = WorkflowIOTypes.WorkflowIOTypesBuilder.class, name="WorkflowIOTypes")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface WorkflowIOTypesMixInBuilder {
    
        public WorkflowIOTypesMixIn build();
    
        @JsonProperty("fingerprint-type")
        public WorkflowIOTypesMixInBuilder setFingerprintType(final FingerprintType fingerprintType);
        
        @JsonProperty("model-type")
        public WorkflowIOTypesMixInBuilder setModelType(final ModelType modelType);
        
    }


}

