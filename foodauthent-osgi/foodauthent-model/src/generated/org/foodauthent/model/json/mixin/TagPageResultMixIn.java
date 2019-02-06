/*
 * TODO	
 */
package org.foodauthent.model.json.mixin;

import org.foodauthent.model.Tag;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;



import org.foodauthent.model.TagPageResult;
import org.foodauthent.model.TagPageResult.TagPageResultBuilder;

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
    defaultImpl = TagPageResult.class)
@JsonSubTypes({
    @Type(value = TagPageResult.class, name="TagPageResult")
})
@JsonDeserialize(builder=TagPageResultBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface TagPageResultMixIn {

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
    public java.util.List<Tag> getResults();
    

    /**
     * MixIn class for entity builder implementations that adds jackson annotations for the de-/serialization.
     *
     * @author Martin Horn, University of Konstanz
     */
    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "",
        defaultImpl = TagPageResultBuilder.class)
    @JsonSubTypes({
        @Type(value = TagPageResult.TagPageResultBuilder.class, name="TagPageResult")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface TagPageResultMixInBuilder {
    
        public TagPageResultMixIn build();
    
        @JsonProperty("pageNumber")
        public TagPageResultMixInBuilder setPageNumber(final Integer pageNumber);
        
        @JsonProperty("pageCount")
        public TagPageResultMixInBuilder setPageCount(final Integer pageCount);
        
        @JsonProperty("resultCount")
        public TagPageResultMixInBuilder setResultCount(final Integer resultCount);
        
        @JsonProperty("results")
        public TagPageResultMixInBuilder setResults(final java.util.List<Tag> results);
        
    }


}

