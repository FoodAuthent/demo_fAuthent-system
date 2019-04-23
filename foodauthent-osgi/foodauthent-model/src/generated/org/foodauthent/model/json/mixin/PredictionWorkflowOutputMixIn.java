/*
 * TODO	
 */
package org.foodauthent.model.json.mixin;

import org.foodauthent.model.PredictionInstance;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;



import org.foodauthent.model.PredictionWorkflowOutput;
import org.foodauthent.model.PredictionWorkflowOutput.PredictionWorkflowOutputBuilder;

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
    defaultImpl = PredictionWorkflowOutput.class)
@JsonSubTypes({
    @Type(value = PredictionWorkflowOutput.class, name="PredictionWorkflowOutput")
})
@JsonDeserialize(builder=PredictionWorkflowOutputBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface PredictionWorkflowOutputMixIn {

	@JsonIgnore
	public long getPersistenceId();
	
    @JsonIgnore
    public String getTypeID();
    
   	@JsonIgnore
  	public UUID getFaId();
    

    @JsonProperty("prediction-map")
    public java.util.Map<String, PredictionInstance> getPredictionMap();
    

    /**
     * MixIn class for entity builder implementations that adds jackson annotations for the de-/serialization.
     *
     * @author Martin Horn, University of Konstanz
     */
    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "",
        defaultImpl = PredictionWorkflowOutputBuilder.class)
    @JsonSubTypes({
        @Type(value = PredictionWorkflowOutput.PredictionWorkflowOutputBuilder.class, name="PredictionWorkflowOutput")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface PredictionWorkflowOutputMixInBuilder {
    
        public PredictionWorkflowOutputMixIn build();
    
        @JsonProperty("prediction-map")
        public PredictionWorkflowOutputMixInBuilder setPredictionMap(final java.util.Map<String, PredictionInstance> predictionMap);
        
    }


}

