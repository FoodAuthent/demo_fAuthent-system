/*
 * TODO	
 */
package org.foodauthent.model.json.mixin;

import org.foodauthent.model.Prediction;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;



import org.foodauthent.model.PredictionPageResult;
import org.foodauthent.model.PredictionPageResult.PredictionPageResultBuilder;

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
    defaultImpl = PredictionPageResult.class)
@JsonSubTypes({
    @Type(value = PredictionPageResult.class, name="PredictionPageResult")
})
@JsonDeserialize(builder=PredictionPageResultBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface PredictionPageResultMixIn {

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
    public java.util.List<Prediction> getResults();
    

    /**
     * MixIn class for entity builder implementations that adds jackson annotations for the de-/serialization.
     *
     * @author Martin Horn, University of Konstanz
     */
    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "",
        defaultImpl = PredictionPageResultBuilder.class)
    @JsonSubTypes({
        @Type(value = PredictionPageResult.PredictionPageResultBuilder.class, name="PredictionPageResult")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface PredictionPageResultMixInBuilder {
    
        public PredictionPageResultMixIn build();
    
        @JsonProperty("pageNumber")
        public PredictionPageResultMixInBuilder setPageNumber(final Integer pageNumber);
        
        @JsonProperty("pageCount")
        public PredictionPageResultMixInBuilder setPageCount(final Integer pageCount);
        
        @JsonProperty("resultCount")
        public PredictionPageResultMixInBuilder setResultCount(final Integer resultCount);
        
        @JsonProperty("results")
        public PredictionPageResultMixInBuilder setResults(final java.util.List<Prediction> results);
        
    }


}

