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



import org.foodauthent.model.SystemInfo;
import org.foodauthent.model.SystemInfo.SystemInfoBuilder;

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
    defaultImpl = SystemInfo.class)
@JsonSubTypes({
    @Type(value = SystemInfo.class, name="SystemInfo")
})
@JsonDeserialize(builder=SystemInfoBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface SystemInfoMixIn {

	@JsonIgnore
	public long getPersistenceId();
	
    @JsonIgnore
    public String getTypeID();
    
   	@JsonIgnore
  	public UUID getFaId();
    

    @JsonProperty("num-sops")
    public Long getNumSops();
    
    @JsonProperty("num-files")
    public Long getNumFiles();
    
    @JsonProperty("num-products")
    public Long getNumProducts();
    
    @JsonProperty("num-fingerprints")
    public Long getNumFingerprints();
    
    @JsonProperty("num-fingerprintsets")
    public Long getNumFingerprintsets();
    
    @JsonProperty("num-workflows")
    public Long getNumWorkflows();
    
    @JsonProperty("num-samples")
    public Long getNumSamples();
    
    @JsonProperty("num-predictions")
    public Long getNumPredictions();
    
    @JsonProperty("num-models")
    public Long getNumModels();
    

    /**
     * MixIn class for entity builder implementations that adds jackson annotations for the de-/serialization.
     *
     * @author Martin Horn, University of Konstanz
     */
    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "",
        defaultImpl = SystemInfoBuilder.class)
    @JsonSubTypes({
        @Type(value = SystemInfo.SystemInfoBuilder.class, name="SystemInfo")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface SystemInfoMixInBuilder {
    
        public SystemInfoMixIn build();
    
        @JsonProperty("num-sops")
        public SystemInfoMixInBuilder setNumSops(final Long numSops);
        
        @JsonProperty("num-files")
        public SystemInfoMixInBuilder setNumFiles(final Long numFiles);
        
        @JsonProperty("num-products")
        public SystemInfoMixInBuilder setNumProducts(final Long numProducts);
        
        @JsonProperty("num-fingerprints")
        public SystemInfoMixInBuilder setNumFingerprints(final Long numFingerprints);
        
        @JsonProperty("num-fingerprintsets")
        public SystemInfoMixInBuilder setNumFingerprintsets(final Long numFingerprintsets);
        
        @JsonProperty("num-workflows")
        public SystemInfoMixInBuilder setNumWorkflows(final Long numWorkflows);
        
        @JsonProperty("num-samples")
        public SystemInfoMixInBuilder setNumSamples(final Long numSamples);
        
        @JsonProperty("num-predictions")
        public SystemInfoMixInBuilder setNumPredictions(final Long numPredictions);
        
        @JsonProperty("num-models")
        public SystemInfoMixInBuilder setNumModels(final Long numModels);
        
    }


}

