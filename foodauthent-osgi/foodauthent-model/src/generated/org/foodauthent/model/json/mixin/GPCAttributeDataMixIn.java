/*
 * TODO	
 */
package org.foodauthent.model.json.mixin;

import org.foodauthent.model.GPCAttributeValueData;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;



import org.foodauthent.model.GPCAttributeData;
import org.foodauthent.model.GPCAttributeData.GPCAttributeDataBuilder;

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
    defaultImpl = GPCAttributeData.class)
@JsonSubTypes({
    @Type(value = GPCAttributeData.class, name="GPCAttributeData")
})
@JsonDeserialize(builder=GPCAttributeDataBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface GPCAttributeDataMixIn {

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
    
    @JsonProperty("elements")
    public java.util.List<GPCAttributeValueData> getElements();
    

    /**
     * MixIn class for entity builder implementations that adds jackson annotations for the de-/serialization.
     *
     * @author Martin Horn, University of Konstanz
     */
    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "",
        defaultImpl = GPCAttributeDataBuilder.class)
    @JsonSubTypes({
        @Type(value = GPCAttributeData.GPCAttributeDataBuilder.class, name="GPCAttributeData")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface GPCAttributeDataMixInBuilder {
    
        public GPCAttributeDataMixIn build();
    
        @JsonProperty("code")
        public GPCAttributeDataMixInBuilder setCode(final String code);
        
        @JsonProperty("text")
        public GPCAttributeDataMixInBuilder setText(final String text);
        
        @JsonProperty("elements")
        public GPCAttributeDataMixInBuilder setElements(final java.util.List<GPCAttributeValueData> elements);
        
    }


}

