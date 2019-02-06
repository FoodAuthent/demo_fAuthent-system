/*
 * TODO	
 */
package org.foodauthent.model.json.mixin;

import org.foodauthent.model.SOP;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;



import org.foodauthent.model.SOPPageResult;
import org.foodauthent.model.SOPPageResult.SOPPageResultBuilder;

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
    defaultImpl = SOPPageResult.class)
@JsonSubTypes({
    @Type(value = SOPPageResult.class, name="SOPPageResult")
})
@JsonDeserialize(builder=SOPPageResultBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface SOPPageResultMixIn {

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
    public java.util.List<SOP> getResults();
    

    /**
     * MixIn class for entity builder implementations that adds jackson annotations for the de-/serialization.
     *
     * @author Martin Horn, University of Konstanz
     */
    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "",
        defaultImpl = SOPPageResultBuilder.class)
    @JsonSubTypes({
        @Type(value = SOPPageResult.SOPPageResultBuilder.class, name="SOPPageResult")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface SOPPageResultMixInBuilder {
    
        public SOPPageResultMixIn build();
    
        @JsonProperty("pageNumber")
        public SOPPageResultMixInBuilder setPageNumber(final Integer pageNumber);
        
        @JsonProperty("pageCount")
        public SOPPageResultMixInBuilder setPageCount(final Integer pageCount);
        
        @JsonProperty("resultCount")
        public SOPPageResultMixInBuilder setResultCount(final Integer resultCount);
        
        @JsonProperty("results")
        public SOPPageResultMixInBuilder setResults(final java.util.List<SOP> results);
        
    }


}

