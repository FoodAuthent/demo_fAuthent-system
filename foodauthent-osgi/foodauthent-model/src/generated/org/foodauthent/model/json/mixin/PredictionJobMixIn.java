/*
 * TODO	
 */
package org.foodauthent.model.json.mixin;


import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import org.foodauthent.model.PredictionJob.StatusEnum;


import org.foodauthent.model.PredictionJob;
import org.foodauthent.model.PredictionJob.PredictionJobBuilder;

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
    defaultImpl = PredictionJob.class)
@JsonSubTypes({
    @Type(value = PredictionJob.class, name="PredictionJob")
})
@JsonDeserialize(builder=PredictionJobBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface PredictionJobMixIn {

	@JsonIgnore
	public long getPersistenceId();
	
    @JsonIgnore
    public String getTypeID();
    
    

    @JsonProperty("fa-id")
    public java.util.UUID getFaId();
    
    @JsonProperty("worklfow-id")
    public java.util.UUID getWorklfowId();
    
    @JsonProperty("fingerprint-set-id")
    public java.util.UUID getFingerprintSetId();
    
    @JsonProperty("prediction-id")
    public java.util.UUID getPredictionId();
    
    @JsonProperty("status")
    public StatusEnum getStatus();
    
    @JsonProperty("status-message")
    public String getStatusMessage();
    

    /**
     * MixIn class for entity builder implementations that adds jackson annotations for the de-/serialization.
     *
     * @author Martin Horn, University of Konstanz
     */
    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "",
        defaultImpl = PredictionJobBuilder.class)
    @JsonSubTypes({
        @Type(value = PredictionJob.PredictionJobBuilder.class, name="PredictionJob")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface PredictionJobMixInBuilder {
    
        public PredictionJobMixIn build();
    
        @JsonProperty("fa-id")
        public PredictionJobMixInBuilder setFaId(final java.util.UUID faId);
        
        @JsonProperty("worklfow-id")
        public PredictionJobMixInBuilder setWorklfowId(final java.util.UUID worklfowId);
        
        @JsonProperty("fingerprint-set-id")
        public PredictionJobMixInBuilder setFingerprintSetId(final java.util.UUID fingerprintSetId);
        
        @JsonProperty("prediction-id")
        public PredictionJobMixInBuilder setPredictionId(final java.util.UUID predictionId);
        
        @JsonProperty("status")
        public PredictionJobMixInBuilder setStatus(final StatusEnum status);
        
        @JsonProperty("status-message")
        public PredictionJobMixInBuilder setStatusMessage(final String statusMessage);
        
    }


}

