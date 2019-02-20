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



import org.foodauthent.model.GPCAttribute;
import org.foodauthent.model.GPCAttribute.GPCAttributeBuilder;

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
    defaultImpl = GPCAttribute.class)
@JsonSubTypes({
    @Type(value = GPCAttribute.class, name="GPCAttribute")
})
@JsonDeserialize(builder=GPCAttributeBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface GPCAttributeMixIn {

	@JsonIgnore
	public long getPersistenceId();
	
    @JsonIgnore
    public String getTypeID();
    
   	@JsonIgnore
  	public UUID getFaId();
    

    @JsonProperty("attributeTypeCode")
    public String getAttributeTypeCode();
    
    @JsonProperty("attributeTypeName")
    public String getAttributeTypeName();
    
    @JsonProperty("attributeValueCode")
    public String getAttributeValueCode();
    
    @JsonProperty("attributeValueName")
    public String getAttributeValueName();
    

    /**
     * MixIn class for entity builder implementations that adds jackson annotations for the de-/serialization.
     *
     * @author Martin Horn, University of Konstanz
     */
    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "",
        defaultImpl = GPCAttributeBuilder.class)
    @JsonSubTypes({
        @Type(value = GPCAttribute.GPCAttributeBuilder.class, name="GPCAttribute")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface GPCAttributeMixInBuilder {
    
        public GPCAttributeMixIn build();
    
        @JsonProperty("attributeTypeCode")
        public GPCAttributeMixInBuilder setAttributeTypeCode(final String attributeTypeCode);
        
        @JsonProperty("attributeTypeName")
        public GPCAttributeMixInBuilder setAttributeTypeName(final String attributeTypeName);
        
        @JsonProperty("attributeValueCode")
        public GPCAttributeMixInBuilder setAttributeValueCode(final String attributeValueCode);
        
        @JsonProperty("attributeValueName")
        public GPCAttributeMixInBuilder setAttributeValueName(final String attributeValueName);
        
    }


}

