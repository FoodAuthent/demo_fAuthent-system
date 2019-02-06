/*
 * TODO	
 */
package org.foodauthent.model.json.mixin;

import org.foodauthent.model.FingerprintSet;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;



import org.foodauthent.model.FingerprintSetPageResult;
import org.foodauthent.model.FingerprintSetPageResult.FingerprintSetPageResultBuilder;

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
    defaultImpl = FingerprintSetPageResult.class)
@JsonSubTypes({
    @Type(value = FingerprintSetPageResult.class, name="FingerprintSetPageResult")
})
@JsonDeserialize(builder=FingerprintSetPageResultBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface FingerprintSetPageResultMixIn {

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
    public java.util.List<FingerprintSet> getResults();
    

    /**
     * MixIn class for entity builder implementations that adds jackson annotations for the de-/serialization.
     *
     * @author Martin Horn, University of Konstanz
     */
    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "",
        defaultImpl = FingerprintSetPageResultBuilder.class)
    @JsonSubTypes({
        @Type(value = FingerprintSetPageResult.FingerprintSetPageResultBuilder.class, name="FingerprintSetPageResult")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface FingerprintSetPageResultMixInBuilder {
    
        public FingerprintSetPageResultMixIn build();
    
        @JsonProperty("pageNumber")
        public FingerprintSetPageResultMixInBuilder setPageNumber(final Integer pageNumber);
        
        @JsonProperty("pageCount")
        public FingerprintSetPageResultMixInBuilder setPageCount(final Integer pageCount);
        
        @JsonProperty("resultCount")
        public FingerprintSetPageResultMixInBuilder setResultCount(final Integer resultCount);
        
        @JsonProperty("results")
        public FingerprintSetPageResultMixInBuilder setResults(final java.util.List<FingerprintSet> results);
        
    }


}

