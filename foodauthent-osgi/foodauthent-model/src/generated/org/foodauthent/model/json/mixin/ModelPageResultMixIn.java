/*
 * TODO	
 */
package org.foodauthent.model.json.mixin;

import org.foodauthent.model.Model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;



import org.foodauthent.model.ModelPageResult;
import org.foodauthent.model.ModelPageResult.ModelPageResultBuilder;

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
    defaultImpl = ModelPageResult.class)
@JsonSubTypes({
    @Type(value = ModelPageResult.class, name="ModelPageResult")
})
@JsonDeserialize(builder=ModelPageResultBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface ModelPageResultMixIn {

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
    public java.util.List<Model> getResults();
    

    /**
     * MixIn class for entity builder implementations that adds jackson annotations for the de-/serialization.
     *
     * @author Martin Horn, University of Konstanz
     */
    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "",
        defaultImpl = ModelPageResultBuilder.class)
    @JsonSubTypes({
        @Type(value = ModelPageResult.ModelPageResultBuilder.class, name="ModelPageResult")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface ModelPageResultMixInBuilder {
    
        public ModelPageResultMixIn build();
    
        @JsonProperty("pageNumber")
        public ModelPageResultMixInBuilder setPageNumber(final Integer pageNumber);
        
        @JsonProperty("pageCount")
        public ModelPageResultMixInBuilder setPageCount(final Integer pageCount);
        
        @JsonProperty("resultCount")
        public ModelPageResultMixInBuilder setResultCount(final Integer resultCount);
        
        @JsonProperty("results")
        public ModelPageResultMixInBuilder setResults(final java.util.List<Model> results);
        
    }


}

