/*
 * TODO	
 */
package org.foodauthent.model.json.mixin;

import org.foodauthent.model.PredictionJob;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;



import org.foodauthent.model.PredictionJobPageResult;
import org.foodauthent.model.PredictionJobPageResult.PredictionJobPageResultBuilder;

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
    defaultImpl = PredictionJobPageResult.class)
@JsonSubTypes({
    @Type(value = PredictionJobPageResult.class, name="PredictionJobPageResult")
})
@JsonDeserialize(builder=PredictionJobPageResultBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface PredictionJobPageResultMixIn {

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
    public java.util.List<PredictionJob> getResults();
    

    /**
     * MixIn class for entity builder implementations that adds jackson annotations for the de-/serialization.
     *
     * @author Martin Horn, University of Konstanz
     */
    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "",
        defaultImpl = PredictionJobPageResultBuilder.class)
    @JsonSubTypes({
        @Type(value = PredictionJobPageResult.PredictionJobPageResultBuilder.class, name="PredictionJobPageResult")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface PredictionJobPageResultMixInBuilder {
    
        public PredictionJobPageResultMixIn build();
    
        @JsonProperty("pageNumber")
        public PredictionJobPageResultMixInBuilder setPageNumber(final Integer pageNumber);
        
        @JsonProperty("pageCount")
        public PredictionJobPageResultMixInBuilder setPageCount(final Integer pageCount);
        
        @JsonProperty("resultCount")
        public PredictionJobPageResultMixInBuilder setResultCount(final Integer resultCount);
        
        @JsonProperty("results")
        public PredictionJobPageResultMixInBuilder setResults(final java.util.List<PredictionJob> results);
        
    }


}

