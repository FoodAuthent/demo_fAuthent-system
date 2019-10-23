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



import org.foodauthent.model.GPCAttributeValueData;
import org.foodauthent.model.GPCAttributeValueData.GPCAttributeValueDataBuilder;

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
    defaultImpl = GPCAttributeValueData.class)
@JsonSubTypes({
    @Type(value = GPCAttributeValueData.class, name="GPCAttributeValueData")
})
@JsonDeserialize(builder=GPCAttributeValueDataBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface GPCAttributeValueDataMixIn {

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
        defaultImpl = GPCAttributeValueDataBuilder.class)
    @JsonSubTypes({
        @Type(value = GPCAttributeValueData.GPCAttributeValueDataBuilder.class, name="GPCAttributeValueData")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface GPCAttributeValueDataMixInBuilder {
    
        public GPCAttributeValueDataMixIn build();
    
        @JsonProperty("code")
        public GPCAttributeValueDataMixInBuilder setCode(final String code);
        
        @JsonProperty("text")
        public GPCAttributeValueDataMixInBuilder setText(final String text);
        
    }


}

