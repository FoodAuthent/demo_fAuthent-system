/*
 * TODO	
 */
package org.foodauthent.model.json.mixin;

import org.foodauthent.model.Fingerprint;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;



import org.foodauthent.model.FingerprintPageResult;
import org.foodauthent.model.FingerprintPageResult.FingerprintPageResultBuilder;

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
    defaultImpl = FingerprintPageResult.class)
@JsonSubTypes({
    @Type(value = FingerprintPageResult.class, name="FingerprintPageResult")
})
@JsonDeserialize(builder=FingerprintPageResultBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface FingerprintPageResultMixIn {

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
    public java.util.List<Fingerprint> getResults();
    

    /**
     * MixIn class for entity builder implementations that adds jackson annotations for the de-/serialization.
     *
     * @author Martin Horn, University of Konstanz
     */
    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "",
        defaultImpl = FingerprintPageResultBuilder.class)
    @JsonSubTypes({
        @Type(value = FingerprintPageResult.FingerprintPageResultBuilder.class, name="FingerprintPageResult")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface FingerprintPageResultMixInBuilder {
    
        public FingerprintPageResultMixIn build();
    
        @JsonProperty("pageNumber")
        public FingerprintPageResultMixInBuilder setPageNumber(final Integer pageNumber);
        
        @JsonProperty("pageCount")
        public FingerprintPageResultMixInBuilder setPageCount(final Integer pageCount);
        
        @JsonProperty("resultCount")
        public FingerprintPageResultMixInBuilder setResultCount(final Integer resultCount);
        
        @JsonProperty("results")
        public FingerprintPageResultMixInBuilder setResults(final java.util.List<Fingerprint> results);
        
    }


}

