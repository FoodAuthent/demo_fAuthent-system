/*
 * TODO	
 */
package org.foodauthent.model.json.mixin;

import org.foodauthent.model.DiscoveryServiceTransaction;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;



import org.foodauthent.model.DiscoveryServiceTransactionPageResult;
import org.foodauthent.model.DiscoveryServiceTransactionPageResult.DiscoveryServiceTransactionPageResultBuilder;

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
    defaultImpl = DiscoveryServiceTransactionPageResult.class)
@JsonSubTypes({
    @Type(value = DiscoveryServiceTransactionPageResult.class, name="DiscoveryServiceTransactionPageResult")
})
@JsonDeserialize(builder=DiscoveryServiceTransactionPageResultBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface DiscoveryServiceTransactionPageResultMixIn {

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
    public java.util.List<DiscoveryServiceTransaction> getResults();
    

    /**
     * MixIn class for entity builder implementations that adds jackson annotations for the de-/serialization.
     *
     * @author Martin Horn, University of Konstanz
     */
    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "",
        defaultImpl = DiscoveryServiceTransactionPageResultBuilder.class)
    @JsonSubTypes({
        @Type(value = DiscoveryServiceTransactionPageResult.DiscoveryServiceTransactionPageResultBuilder.class, name="DiscoveryServiceTransactionPageResult")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface DiscoveryServiceTransactionPageResultMixInBuilder {
    
        public DiscoveryServiceTransactionPageResultMixIn build();
    
        @JsonProperty("pageNumber")
        public DiscoveryServiceTransactionPageResultMixInBuilder setPageNumber(final Integer pageNumber);
        
        @JsonProperty("pageCount")
        public DiscoveryServiceTransactionPageResultMixInBuilder setPageCount(final Integer pageCount);
        
        @JsonProperty("resultCount")
        public DiscoveryServiceTransactionPageResultMixInBuilder setResultCount(final Integer resultCount);
        
        @JsonProperty("results")
        public DiscoveryServiceTransactionPageResultMixInBuilder setResults(final java.util.List<DiscoveryServiceTransaction> results);
        
    }


}

