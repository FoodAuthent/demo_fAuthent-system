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



import org.foodauthent.model.Prediction;
import org.foodauthent.model.Prediction.PredictionBuilder;

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
    defaultImpl = Prediction.class)
@JsonSubTypes({
    @Type(value = Prediction.class, name="Prediction")
})
@JsonDeserialize(builder=PredictionBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface PredictionMixIn {

	@JsonIgnore
	public long getPersistenceId();
	
    @JsonIgnore
    public String getTypeID();
    
    

    @JsonProperty("fa-id")
    public java.util.UUID getFaId();
    
    @JsonProperty("prediction-map")
    public java.util.Map<String, java.util.Map<String, Float>> getPredictionMap();
    
    @JsonProperty("workflow-id")
    public java.util.UUID getWorkflowId();
    
    @JsonProperty("fingerprintset-id")
    public java.util.UUID getFingerprintsetId();
    
    @JsonProperty("model-id")
    public java.util.UUID getModelId();
    
    @JsonProperty("objectevent-ids")
    public java.util.List<java.util.UUID> getObjecteventIds();
    

    /**
     * MixIn class for entity builder implementations that adds jackson annotations for the de-/serialization.
     *
     * @author Martin Horn, University of Konstanz
     */
    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "",
        defaultImpl = PredictionBuilder.class)
    @JsonSubTypes({
        @Type(value = Prediction.PredictionBuilder.class, name="Prediction")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface PredictionMixInBuilder {
    
        public PredictionMixIn build();
    
        @JsonProperty("fa-id")
        public PredictionMixInBuilder setFaId(final java.util.UUID faId);
        
        @JsonProperty("prediction-map")
        public PredictionMixInBuilder setPredictionMap(final java.util.Map<String, java.util.Map<String, Float>> predictionMap);
        
        @JsonProperty("workflow-id")
        public PredictionMixInBuilder setWorkflowId(final java.util.UUID workflowId);
        
        @JsonProperty("fingerprintset-id")
        public PredictionMixInBuilder setFingerprintsetId(final java.util.UUID fingerprintsetId);
        
        @JsonProperty("model-id")
        public PredictionMixInBuilder setModelId(final java.util.UUID modelId);
        
        @JsonProperty("objectevent-ids")
        public PredictionMixInBuilder setObjecteventIds(final java.util.List<java.util.UUID> objecteventIds);
        
    }


}

