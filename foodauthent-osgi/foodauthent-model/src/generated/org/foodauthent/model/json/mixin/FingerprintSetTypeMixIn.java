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

import org.foodauthent.model.FingerprintSetType.NameEnum;


import org.foodauthent.model.FingerprintSetType;
import org.foodauthent.model.FingerprintSetType.FingerprintSetTypeBuilder;

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
    defaultImpl = FingerprintSetType.class)
@JsonSubTypes({
    @Type(value = FingerprintSetType.class, name="FingerprintSetType")
})
@JsonDeserialize(builder=FingerprintSetTypeBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface FingerprintSetTypeMixIn {

	@JsonIgnore
	public long getPersistenceId();
	
    @JsonIgnore
    public String getTypeID();
    
   	@JsonIgnore
  	public UUID getFaId();
    

    @JsonProperty("name")
    public NameEnum getName();
    

    /**
     * MixIn class for entity builder implementations that adds jackson annotations for the de-/serialization.
     *
     * @author Martin Horn, University of Konstanz
     */
    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "",
        defaultImpl = FingerprintSetTypeBuilder.class)
    @JsonSubTypes({
        @Type(value = FingerprintSetType.FingerprintSetTypeBuilder.class, name="FingerprintSetType")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface FingerprintSetTypeMixInBuilder {
    
        public FingerprintSetTypeMixIn build();
    
        @JsonProperty("name")
        public FingerprintSetTypeMixInBuilder setName(final NameEnum name);
        
    }


}

