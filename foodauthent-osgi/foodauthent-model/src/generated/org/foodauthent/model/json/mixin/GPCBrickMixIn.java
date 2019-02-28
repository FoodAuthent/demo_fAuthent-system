/*
 * TODO	
 */
package org.foodauthent.model.json.mixin;

import org.foodauthent.model.GPCAttribute;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;



import org.foodauthent.model.GPCBrick;
import org.foodauthent.model.GPCBrick.GPCBrickBuilder;

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
    defaultImpl = GPCBrick.class)
@JsonSubTypes({
    @Type(value = GPCBrick.class, name="GPCBrick")
})
@JsonDeserialize(builder=GPCBrickBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface GPCBrickMixIn {

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
    
    @JsonProperty("attributes")
    public java.util.List<GPCAttribute> getAttributes();
    

    /**
     * MixIn class for entity builder implementations that adds jackson annotations for the de-/serialization.
     *
     * @author Martin Horn, University of Konstanz
     */
    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "",
        defaultImpl = GPCBrickBuilder.class)
    @JsonSubTypes({
        @Type(value = GPCBrick.GPCBrickBuilder.class, name="GPCBrick")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface GPCBrickMixInBuilder {
    
        public GPCBrickMixIn build();
    
        @JsonProperty("code")
        public GPCBrickMixInBuilder setCode(final String code);
        
        @JsonProperty("text")
        public GPCBrickMixInBuilder setText(final String text);
        
        @JsonProperty("attributes")
        public GPCBrickMixInBuilder setAttributes(final java.util.List<GPCAttribute> attributes);
        
    }


}

