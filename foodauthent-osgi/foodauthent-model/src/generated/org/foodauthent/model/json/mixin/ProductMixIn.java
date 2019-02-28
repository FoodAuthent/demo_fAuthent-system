/*
 * TODO	
 */
package org.foodauthent.model.json.mixin;

import org.foodauthent.model.GPCBrick;
import org.foodauthent.model.ProductIngredientStatement;

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
    
    @JsonProperty("targetMarket")
    public String getTargetMarket();
    
    @JsonProperty("labelDescription")
    public String getLabelDescription();
    
    @JsonProperty("companyName")
    public String getCompanyName();
    
    @JsonProperty("productClassification")
    public String getProductClassification();
    
    @JsonProperty("countryOfOrigin")
    public String getCountryOfOrigin();
    
    @JsonProperty("regionOfOriginClaims")
    public String getRegionOfOriginClaims();
    
    @JsonProperty("ingredientStatement")
    public ProductIngredientStatement getIngredientStatement();
    
    @JsonProperty("comment")
    public String getComment();
    
    @JsonProperty("gpcBricks")
    public java.util.List<GPCBrick> getGpcBricks();
    

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
        
        @JsonProperty("targetMarket")
        public ProductMixInBuilder setTargetMarket(final String targetMarket);
        
        @JsonProperty("labelDescription")
        public ProductMixInBuilder setLabelDescription(final String labelDescription);
        
        @JsonProperty("companyName")
        public ProductMixInBuilder setCompanyName(final String companyName);
        
        @JsonProperty("productClassification")
        public ProductMixInBuilder setProductClassification(final String productClassification);
        
        @JsonProperty("countryOfOrigin")
        public ProductMixInBuilder setCountryOfOrigin(final String countryOfOrigin);
        
        @JsonProperty("regionOfOriginClaims")
        public ProductMixInBuilder setRegionOfOriginClaims(final String regionOfOriginClaims);
        
        @JsonProperty("ingredientStatement")
        public ProductMixInBuilder setIngredientStatement(final ProductIngredientStatement ingredientStatement);
        
        @JsonProperty("comment")
        public ProductMixInBuilder setComment(final String comment);
        
        @JsonProperty("gpcBricks")
        public ProductMixInBuilder setGpcBricks(final java.util.List<GPCBrick> gpcBricks);
        
    }


}

