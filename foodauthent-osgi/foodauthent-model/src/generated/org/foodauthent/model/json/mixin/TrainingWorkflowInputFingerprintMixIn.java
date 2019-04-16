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



import org.foodauthent.model.TrainingWorkflowInputFingerprint;
import org.foodauthent.model.TrainingWorkflowInputFingerprint.TrainingWorkflowInputFingerprintBuilder;

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
    defaultImpl = TrainingWorkflowInputFingerprint.class)
@JsonSubTypes({
    @Type(value = TrainingWorkflowInputFingerprint.class, name="TrainingWorkflowInputFingerprint")
})
@JsonDeserialize(builder=TrainingWorkflowInputFingerprintBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface TrainingWorkflowInputFingerprintMixIn {

	@JsonIgnore
	public long getPersistenceId();
	
    @JsonIgnore
    public String getTypeID();
    
   	@JsonIgnore
  	public UUID getFaId();
    

    @JsonProperty("URI")
    public String getURI();
    
    @JsonProperty("class-label")
    public String getClassLabel();
    
    @JsonProperty("fingerprint-id")
    public java.util.UUID getFingerprintId();
    

    /**
     * MixIn class for entity builder implementations that adds jackson annotations for the de-/serialization.
     *
     * @author Martin Horn, University of Konstanz
     */
    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "",
        defaultImpl = TrainingWorkflowInputFingerprintBuilder.class)
    @JsonSubTypes({
        @Type(value = TrainingWorkflowInputFingerprint.TrainingWorkflowInputFingerprintBuilder.class, name="TrainingWorkflowInputFingerprint")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface TrainingWorkflowInputFingerprintMixInBuilder {
    
        public TrainingWorkflowInputFingerprintMixIn build();
    
        @JsonProperty("URI")
        public TrainingWorkflowInputFingerprintMixInBuilder setURI(final String URI);
        
        @JsonProperty("class-label")
        public TrainingWorkflowInputFingerprintMixInBuilder setClassLabel(final String classLabel);
        
        @JsonProperty("fingerprint-id")
        public TrainingWorkflowInputFingerprintMixInBuilder setFingerprintId(final java.util.UUID fingerprintId);
        
    }


}

