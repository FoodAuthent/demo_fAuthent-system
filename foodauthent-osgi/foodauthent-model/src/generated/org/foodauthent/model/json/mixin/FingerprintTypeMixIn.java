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

import org.foodauthent.model.FingerprintType.NameEnum;


import org.foodauthent.model.FingerprintType;
import org.foodauthent.model.FingerprintType.FingerprintTypeBuilder;

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
    defaultImpl = FingerprintType.class)
@JsonSubTypes({
    @Type(value = FingerprintType.class, name="FingerprintType")
})
@JsonDeserialize(builder=FingerprintTypeBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface FingerprintTypeMixIn {

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
        defaultImpl = FingerprintTypeBuilder.class)
    @JsonSubTypes({
        @Type(value = FingerprintType.FingerprintTypeBuilder.class, name="FingerprintType")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface FingerprintTypeMixInBuilder {
    
        public FingerprintTypeMixIn build();
    
        @JsonProperty("name")
        public FingerprintTypeMixInBuilder setName(final NameEnum name);
        
    }


}

