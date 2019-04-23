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
    
    @JsonProperty("fingerprint-ids")
    public java.util.List<java.util.UUID> getFingerprintIds();
    
    @JsonProperty("name")
    public String getName();
    
    @JsonProperty("description")
    public String getDescription();
    
    @JsonProperty("class-label")
    public String getClassLabel();
    

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
        
        @JsonProperty("fingerprint-ids")
        public FingerprintSetMixInBuilder setFingerprintIds(final java.util.List<java.util.UUID> fingerprintIds);
        
        @JsonProperty("name")
        public FingerprintSetMixInBuilder setName(final String name);
        
        @JsonProperty("description")
        public FingerprintSetMixInBuilder setDescription(final String description);
        
        @JsonProperty("class-label")
        public FingerprintSetMixInBuilder setClassLabel(final String classLabel);
        
    }


}

