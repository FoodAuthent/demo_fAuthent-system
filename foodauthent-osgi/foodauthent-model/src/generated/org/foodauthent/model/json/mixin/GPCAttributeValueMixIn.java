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



import org.foodauthent.model.GPCAttributeValue;
import org.foodauthent.model.GPCAttributeValue.GPCAttributeValueBuilder;

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
    defaultImpl = GPCAttributeValue.class)
@JsonSubTypes({
    @Type(value = GPCAttributeValue.class, name="GPCAttributeValue")
})
@JsonDeserialize(builder=GPCAttributeValueBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface GPCAttributeValueMixIn {

	@JsonIgnore
	public long getPersistenceId();
	
    @JsonIgnore
    public String getTypeID();
    
   	@JsonIgnore
  	public UUID getFaId();
    

    @JsonProperty("code")
    public String getCode();
    
    @JsonProperty("text")
    public String getText();
    

    /**
     * MixIn class for entity builder implementations that adds jackson annotations for the de-/serialization.
     *
     * @author Martin Horn, University of Konstanz
     */
    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "",
        defaultImpl = GPCAttributeValueBuilder.class)
    @JsonSubTypes({
        @Type(value = GPCAttributeValue.GPCAttributeValueBuilder.class, name="GPCAttributeValue")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface GPCAttributeValueMixInBuilder {
    
        public GPCAttributeValueMixIn build();
    
        @JsonProperty("code")
        public GPCAttributeValueMixInBuilder setCode(final String code);
        
        @JsonProperty("text")
        public GPCAttributeValueMixInBuilder setText(final String text);
        
    }


}

