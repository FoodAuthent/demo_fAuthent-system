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



import org.foodauthent.model.Product;
import org.foodauthent.model.Product.ProductBuilder;

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
    defaultImpl = Product.class)
@JsonSubTypes({
    @Type(value = Product.class, name="Product")
})
@JsonDeserialize(builder=ProductBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface ProductMixIn {

	@JsonIgnore
	public long getPersistenceId();
	
    @JsonIgnore
    public String getTypeID();
    
    

    @JsonProperty("fa-id")
    public java.util.UUID getFaId();
    
    @JsonProperty("gtin")
    public String getGtin();
    
    @JsonProperty("brand")
    public String getBrand();
    
    @JsonProperty("gpcAttributes")
    public java.util.List<GPCAttribute> getGpcAttributes();
    

    /**
     * MixIn class for entity builder implementations that adds jackson annotations for the de-/serialization.
     *
     * @author Martin Horn, University of Konstanz
     */
    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "",
        defaultImpl = ProductBuilder.class)
    @JsonSubTypes({
        @Type(value = Product.ProductBuilder.class, name="Product")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface ProductMixInBuilder {
    
        public ProductMixIn build();
    
        @JsonProperty("fa-id")
        public ProductMixInBuilder setFaId(final java.util.UUID faId);
        
        @JsonProperty("gtin")
        public ProductMixInBuilder setGtin(final String gtin);
        
        @JsonProperty("brand")
        public ProductMixInBuilder setBrand(final String brand);
        
        @JsonProperty("gpcAttributes")
        public ProductMixInBuilder setGpcAttributes(final java.util.List<GPCAttribute> gpcAttributes);
        
    }


}

