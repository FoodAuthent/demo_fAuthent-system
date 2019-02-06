/*
 * TODO	
 */
package org.foodauthent.model.json.mixin;

import org.foodauthent.model.TrainingJob;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;



import org.foodauthent.model.TrainingJobPageResult;
import org.foodauthent.model.TrainingJobPageResult.TrainingJobPageResultBuilder;

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
    defaultImpl = TrainingJobPageResult.class)
@JsonSubTypes({
    @Type(value = TrainingJobPageResult.class, name="TrainingJobPageResult")
})
@JsonDeserialize(builder=TrainingJobPageResultBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface TrainingJobPageResultMixIn {

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
    public java.util.List<TrainingJob> getResults();
    

    /**
     * MixIn class for entity builder implementations that adds jackson annotations for the de-/serialization.
     *
     * @author Martin Horn, University of Konstanz
     */
    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "",
        defaultImpl = TrainingJobPageResultBuilder.class)
    @JsonSubTypes({
        @Type(value = TrainingJobPageResult.TrainingJobPageResultBuilder.class, name="TrainingJobPageResult")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface TrainingJobPageResultMixInBuilder {
    
        public TrainingJobPageResultMixIn build();
    
        @JsonProperty("pageNumber")
        public TrainingJobPageResultMixInBuilder setPageNumber(final Integer pageNumber);
        
        @JsonProperty("pageCount")
        public TrainingJobPageResultMixInBuilder setPageCount(final Integer pageCount);
        
        @JsonProperty("resultCount")
        public TrainingJobPageResultMixInBuilder setResultCount(final Integer resultCount);
        
        @JsonProperty("results")
        public TrainingJobPageResultMixInBuilder setResults(final java.util.List<TrainingJob> results);
        
    }


}

