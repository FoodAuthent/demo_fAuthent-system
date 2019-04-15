/*
 * TODO	
 */
package org.foodauthent.model.json.mixin;

import org.foodauthent.model.FingerprintSet;
import org.foodauthent.model.WorkflowParameter;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;



import org.foodauthent.model.PredictionWorkflowInput;
import org.foodauthent.model.PredictionWorkflowInput.PredictionWorkflowInputBuilder;

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
    defaultImpl = PredictionWorkflowInput.class)
@JsonSubTypes({
    @Type(value = PredictionWorkflowInput.class, name="PredictionWorkflowInput")
})
@JsonDeserialize(builder=PredictionWorkflowInputBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface PredictionWorkflowInputMixIn {

	@JsonIgnore
	public long getPersistenceId();
	
    @JsonIgnore
    public String getTypeID();
    
   	@JsonIgnore
  	public UUID getFaId();
    

    @JsonProperty("parameters")
    public java.util.List<WorkflowParameter> getParameters();
    
    @JsonProperty("fingerprintset")
    public FingerprintSet getFingerprintset();
    
    @JsonProperty("fingerprint-URIs")
    public java.util.List<String> getFingerprintURIs();
    
    @JsonProperty("model-URI")
    public String getModelURI();
    

    /**
     * MixIn class for entity builder implementations that adds jackson annotations for the de-/serialization.
     *
     * @author Martin Horn, University of Konstanz
     */
    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "",
        defaultImpl = PredictionWorkflowInputBuilder.class)
    @JsonSubTypes({
        @Type(value = PredictionWorkflowInput.PredictionWorkflowInputBuilder.class, name="PredictionWorkflowInput")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface PredictionWorkflowInputMixInBuilder {
    
        public PredictionWorkflowInputMixIn build();
    
        @JsonProperty("parameters")
        public PredictionWorkflowInputMixInBuilder setParameters(final java.util.List<WorkflowParameter> parameters);
        
        @JsonProperty("fingerprintset")
        public PredictionWorkflowInputMixInBuilder setFingerprintset(final FingerprintSet fingerprintset);
        
        @JsonProperty("fingerprint-URIs")
        public PredictionWorkflowInputMixInBuilder setFingerprintURIs(final java.util.List<String> fingerprintURIs);
        
        @JsonProperty("model-URI")
        public PredictionWorkflowInputMixInBuilder setModelURI(final String modelURI);
        
    }


}

