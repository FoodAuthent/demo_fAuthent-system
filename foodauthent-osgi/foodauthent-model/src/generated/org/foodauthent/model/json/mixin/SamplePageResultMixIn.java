/*
 * TODO	
 */
package org.foodauthent.model.json.mixin;

import org.foodauthent.model.Sample;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;



import org.foodauthent.model.SamplePageResult;
import org.foodauthent.model.SamplePageResult.SamplePageResultBuilder;

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
    defaultImpl = SamplePageResult.class)
@JsonSubTypes({
    @Type(value = SamplePageResult.class, name="SamplePageResult")
})
@JsonDeserialize(builder=SamplePageResultBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface SamplePageResultMixIn {

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
    public java.util.List<Sample> getResults();
    

    /**
     * MixIn class for entity builder implementations that adds jackson annotations for the de-/serialization.
     *
     * @author Martin Horn, University of Konstanz
     */
    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "",
        defaultImpl = SamplePageResultBuilder.class)
    @JsonSubTypes({
        @Type(value = SamplePageResult.SamplePageResultBuilder.class, name="SamplePageResult")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface SamplePageResultMixInBuilder {
    
        public SamplePageResultMixIn build();
    
        @JsonProperty("pageNumber")
        public SamplePageResultMixInBuilder setPageNumber(final Integer pageNumber);
        
        @JsonProperty("pageCount")
        public SamplePageResultMixInBuilder setPageCount(final Integer pageCount);
        
        @JsonProperty("resultCount")
        public SamplePageResultMixInBuilder setResultCount(final Integer resultCount);
        
        @JsonProperty("results")
        public SamplePageResultMixInBuilder setResults(final java.util.List<Sample> results);
        
    }


}

