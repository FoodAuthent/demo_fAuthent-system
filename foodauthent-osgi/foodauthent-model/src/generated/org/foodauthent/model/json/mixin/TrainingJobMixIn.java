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

import org.foodauthent.model.TrainingJob.StatusEnum;


import org.foodauthent.model.TrainingJob;
import org.foodauthent.model.TrainingJob.TrainingJobBuilder;

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
    defaultImpl = TrainingJob.class)
@JsonSubTypes({
    @Type(value = TrainingJob.class, name="TrainingJob")
})
@JsonDeserialize(builder=TrainingJobBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface TrainingJobMixIn {

	@JsonIgnore
	public long getPersistenceId();
	
    @JsonIgnore
    public String getTypeID();
    
    

    @JsonProperty("fa-id")
    public java.util.UUID getFaId();
    
    @JsonProperty("model-id")
    public java.util.UUID getModelId();
    
    @JsonProperty("fingerprintset-ids")
    public java.util.List<java.util.UUID> getFingerprintsetIds();
    
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
        defaultImpl = TrainingJobBuilder.class)
    @JsonSubTypes({
        @Type(value = TrainingJob.TrainingJobBuilder.class, name="TrainingJob")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface TrainingJobMixInBuilder {
    
        public TrainingJobMixIn build();
    
        @JsonProperty("fa-id")
        public TrainingJobMixInBuilder setFaId(final java.util.UUID faId);
        
        @JsonProperty("model-id")
        public TrainingJobMixInBuilder setModelId(final java.util.UUID modelId);
        
        @JsonProperty("fingerprintset-ids")
        public TrainingJobMixInBuilder setFingerprintsetIds(final java.util.List<java.util.UUID> fingerprintsetIds);
        
        @JsonProperty("status")
        public TrainingJobMixInBuilder setStatus(final StatusEnum status);
        
        @JsonProperty("status-message")
        public TrainingJobMixInBuilder setStatusMessage(final String statusMessage);
        
    }


}

