/*
 * TODO	
 */
package org.foodauthent.model.json.mixin;

import org.foodauthent.model.GPCAttributeData;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;



import org.foodauthent.model.GPCBrickData;
import org.foodauthent.model.GPCBrickData.GPCBrickDataBuilder;

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
    defaultImpl = GPCBrickData.class)
@JsonSubTypes({
    @Type(value = GPCBrickData.class, name="GPCBrickData")
})
@JsonDeserialize(builder=GPCBrickDataBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface GPCBrickDataMixIn {

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
    public java.util.List<GPCAttributeData> getElements();
    

    /**
     * MixIn class for entity builder implementations that adds jackson annotations for the de-/serialization.
     *
     * @author Martin Horn, University of Konstanz
     */
    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "",
        defaultImpl = GPCBrickDataBuilder.class)
    @JsonSubTypes({
        @Type(value = GPCBrickData.GPCBrickDataBuilder.class, name="GPCBrickData")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface GPCBrickDataMixInBuilder {
    
        public GPCBrickDataMixIn build();
    
        @JsonProperty("code")
        public GPCBrickDataMixInBuilder setCode(final String code);
        
        @JsonProperty("text")
        public GPCBrickDataMixInBuilder setText(final String text);
        
        @JsonProperty("elements")
        public GPCBrickDataMixInBuilder setElements(final java.util.List<GPCAttributeData> elements);
        
    }


}

