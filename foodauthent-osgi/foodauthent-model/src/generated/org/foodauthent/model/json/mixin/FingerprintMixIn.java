/*
 * TODO	
 */
package org.foodauthent.model.json.mixin;

import org.foodauthent.model.FingerprintType;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;



import org.foodauthent.model.Fingerprint;
import org.foodauthent.model.Fingerprint.FingerprintBuilder;

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
    defaultImpl = Fingerprint.class)
@JsonSubTypes({
    @Type(value = Fingerprint.class, name="Fingerprint")
})
@JsonDeserialize(builder=FingerprintBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface FingerprintMixIn {

	@JsonIgnore
	public long getPersistenceId();
	
    @JsonIgnore
    public String getTypeID();
    
    

    @JsonProperty("fa-id")
    public java.util.UUID getFaId();
    
    @JsonProperty("sample-id")
    public java.util.UUID getSampleId();
    
    @JsonProperty("file-id")
    public java.util.UUID getFileId();
    
    @JsonProperty("sop-id")
    public java.util.UUID getSopId();
    
    @JsonProperty("type")
    public FingerprintType getType();
    

    /**
     * MixIn class for entity builder implementations that adds jackson annotations for the de-/serialization.
     *
     * @author Martin Horn, University of Konstanz
     */
    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "",
        defaultImpl = FingerprintBuilder.class)
    @JsonSubTypes({
        @Type(value = Fingerprint.FingerprintBuilder.class, name="Fingerprint")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface FingerprintMixInBuilder {
    
        public FingerprintMixIn build();
    
        @JsonProperty("fa-id")
        public FingerprintMixInBuilder setFaId(final java.util.UUID faId);
        
        @JsonProperty("sample-id")
        public FingerprintMixInBuilder setSampleId(final java.util.UUID sampleId);
        
        @JsonProperty("file-id")
        public FingerprintMixInBuilder setFileId(final java.util.UUID fileId);
        
        @JsonProperty("sop-id")
        public FingerprintMixInBuilder setSopId(final java.util.UUID sopId);
        
        @JsonProperty("type")
        public FingerprintMixInBuilder setType(final FingerprintType type);
        
    }


}

