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



import org.foodauthent.model.QuantityElement;
import org.foodauthent.model.QuantityElement.QuantityElementBuilder;

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
    defaultImpl = QuantityElement.class)
@JsonSubTypes({
    @Type(value = QuantityElement.class, name="QuantityElement")
})
@JsonDeserialize(builder=QuantityElementBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface QuantityElementMixIn {

	@JsonIgnore
	public long getPersistenceId();
	
    @JsonIgnore
    public String getTypeID();
    
   	@JsonIgnore
  	public UUID getFaId();
    

    @JsonProperty("epcClass")
    public String getEpcClass();
    
    @JsonProperty("quantity")
    public String getQuantity();
    
    @JsonProperty("uom")
    public String getUom();
    

    /**
     * MixIn class for entity builder implementations that adds jackson annotations for the de-/serialization.
     *
     * @author Martin Horn, University of Konstanz
     */
    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "",
        defaultImpl = QuantityElementBuilder.class)
    @JsonSubTypes({
        @Type(value = QuantityElement.QuantityElementBuilder.class, name="QuantityElement")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface QuantityElementMixInBuilder {
    
        public QuantityElementMixIn build();
    
        @JsonProperty("epcClass")
        public QuantityElementMixInBuilder setEpcClass(final String epcClass);
        
        @JsonProperty("quantity")
        public QuantityElementMixInBuilder setQuantity(final String quantity);
        
        @JsonProperty("uom")
        public QuantityElementMixInBuilder setUom(final String uom);
        
    }


}

