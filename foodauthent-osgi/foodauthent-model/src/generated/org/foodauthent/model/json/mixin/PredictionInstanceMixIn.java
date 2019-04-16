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



import org.foodauthent.model.PredictionInstance;
import org.foodauthent.model.PredictionInstance.PredictionInstanceBuilder;

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
    defaultImpl = PredictionInstance.class)
@JsonSubTypes({
    @Type(value = PredictionInstance.class, name="PredictionInstance")
})
@JsonDeserialize(builder=PredictionInstanceBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface PredictionInstanceMixIn {

	@JsonIgnore
	public long getPersistenceId();
	
    @JsonIgnore
    public String getTypeID();
    
   	@JsonIgnore
  	public UUID getFaId();
    

    @JsonProperty("class-label")
    public String getClassLabel();
    
    @JsonProperty("probabilities")
    public java.util.List<Float> getProbabilities();
    

    /**
     * MixIn class for entity builder implementations that adds jackson annotations for the de-/serialization.
     *
     * @author Martin Horn, University of Konstanz
     */
    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "",
        defaultImpl = PredictionInstanceBuilder.class)
    @JsonSubTypes({
        @Type(value = PredictionInstance.PredictionInstanceBuilder.class, name="PredictionInstance")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface PredictionInstanceMixInBuilder {
    
        public PredictionInstanceMixIn build();
    
        @JsonProperty("class-label")
        public PredictionInstanceMixInBuilder setClassLabel(final String classLabel);
        
        @JsonProperty("probabilities")
        public PredictionInstanceMixInBuilder setProbabilities(final java.util.List<Float> probabilities);
        
    }


}

