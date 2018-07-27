/*
 * TODO	
 */
package org.foodauthent.model.json.mixin;

import org.foodauthent.model.json.mixin.FingerprintMixIn;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;



import org.foodauthent.model.FingerprintSet;
import org.foodauthent.model.FingerprintSet.FingerprintSetBuilder;

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
    defaultImpl = FingerprintSet.class)
@JsonSubTypes({
    @Type(value = FingerprintSet.class, name="FingerprintSet")
})
@JsonDeserialize(builder=FingerprintSetBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface FingerprintSetMixIn {

	@JsonIgnore
	public long getPersistenceId();
	
    @JsonIgnore
    public String getTypeID();
    
    

    @JsonProperty("fa-id")
    public java.util.UUID getFaId();
    
    @JsonProperty("product-id")
    public java.util.UUID getProductId();
    
    @JsonProperty("fingerprints")
    public java.util.List<FingerprintMixIn> getFingerprints();
    
    @JsonProperty("file-id")
    public java.util.UUID getFileId();
    
    @JsonProperty("name")
    public String getName();
    
    @JsonProperty("metadata")
    public String getMetadata();
    
    @JsonProperty("additional-properties")
    public java.util.Map<String, String> getAdditionalProperties();
    

    /**
     * MixIn class for entity builder implementations that adds jackson annotations for the de-/serialization.
     *
     * @author Martin Horn, University of Konstanz
     */
    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "",
        defaultImpl = FingerprintSetBuilder.class)
    @JsonSubTypes({
        @Type(value = FingerprintSet.FingerprintSetBuilder.class, name="FingerprintSet")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface FingerprintSetMixInBuilder {
    
        public FingerprintSetMixIn build();
    
        @JsonProperty("fa-id")
        public FingerprintSetMixInBuilder setFaId(final java.util.UUID faId);
        
        @JsonProperty("product-id")
        public FingerprintSetMixInBuilder setProductId(final java.util.UUID productId);
        
        @JsonProperty("fingerprints")
        public FingerprintSetMixInBuilder setFingerprints(final java.util.List<FingerprintMixIn> fingerprints);
        
        @JsonProperty("file-id")
        public FingerprintSetMixInBuilder setFileId(final java.util.UUID fileId);
        
        @JsonProperty("name")
        public FingerprintSetMixInBuilder setName(final String name);
        
        @JsonProperty("metadata")
        public FingerprintSetMixInBuilder setMetadata(final String metadata);
        
        @JsonProperty("additional-properties")
        public FingerprintSetMixInBuilder setAdditionalProperties(final java.util.Map<String, String> additionalProperties);
        
    }


}

