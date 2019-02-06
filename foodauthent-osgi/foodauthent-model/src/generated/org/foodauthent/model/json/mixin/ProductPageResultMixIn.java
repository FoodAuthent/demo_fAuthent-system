/*
 * TODO	
 */
package org.foodauthent.model.json.mixin;

import org.foodauthent.model.Product;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;



import org.foodauthent.model.ProductPageResult;
import org.foodauthent.model.ProductPageResult.ProductPageResultBuilder;

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
    defaultImpl = ProductPageResult.class)
@JsonSubTypes({
    @Type(value = ProductPageResult.class, name="ProductPageResult")
})
@JsonDeserialize(builder=ProductPageResultBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface ProductPageResultMixIn {

	@JsonIgnore
	public long getPersistenceId();
	
    @JsonIgnore
    public String getTypeID();
    
   	@JsonIgnore
  	public UUID getFaId();
    

    @JsonProperty("pageNumber")
    public Integer getPageNumber();
    
    @JsonProperty("pageCount")
    public Integer getPageCount();
    
    @JsonProperty("resultCount")
    public Integer getResultCount();
    
    @JsonProperty("results")
    public java.util.List<Product> getResults();
    

    /**
     * MixIn class for entity builder implementations that adds jackson annotations for the de-/serialization.
     *
     * @author Martin Horn, University of Konstanz
     */
    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "",
        defaultImpl = ProductPageResultBuilder.class)
    @JsonSubTypes({
        @Type(value = ProductPageResult.ProductPageResultBuilder.class, name="ProductPageResult")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface ProductPageResultMixInBuilder {
    
        public ProductPageResultMixIn build();
    
        @JsonProperty("pageNumber")
        public ProductPageResultMixInBuilder setPageNumber(final Integer pageNumber);
        
        @JsonProperty("pageCount")
        public ProductPageResultMixInBuilder setPageCount(final Integer pageCount);
        
        @JsonProperty("resultCount")
        public ProductPageResultMixInBuilder setResultCount(final Integer resultCount);
        
        @JsonProperty("results")
        public ProductPageResultMixInBuilder setResults(final java.util.List<Product> results);
        
    }


}

