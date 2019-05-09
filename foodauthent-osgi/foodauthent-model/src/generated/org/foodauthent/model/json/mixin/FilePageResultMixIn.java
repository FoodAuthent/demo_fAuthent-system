/*
 * TODO	
 */
package org.foodauthent.model.json.mixin;

import org.foodauthent.model.FileMetadata;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;



import org.foodauthent.model.FilePageResult;
import org.foodauthent.model.FilePageResult.FilePageResultBuilder;

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
    defaultImpl = FilePageResult.class)
@JsonSubTypes({
    @Type(value = FilePageResult.class, name="FilePageResult")
})
@JsonDeserialize(builder=FilePageResultBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface FilePageResultMixIn {

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
    public java.util.List<FileMetadata> getResults();
    

    /**
     * MixIn class for entity builder implementations that adds jackson annotations for the de-/serialization.
     *
     * @author Martin Horn, University of Konstanz
     */
    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "",
        defaultImpl = FilePageResultBuilder.class)
    @JsonSubTypes({
        @Type(value = FilePageResult.FilePageResultBuilder.class, name="FilePageResult")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface FilePageResultMixInBuilder {
    
        public FilePageResultMixIn build();
    
        @JsonProperty("pageNumber")
        public FilePageResultMixInBuilder setPageNumber(final Integer pageNumber);
        
        @JsonProperty("pageCount")
        public FilePageResultMixInBuilder setPageCount(final Integer pageCount);
        
        @JsonProperty("resultCount")
        public FilePageResultMixInBuilder setResultCount(final Integer resultCount);
        
        @JsonProperty("results")
        public FilePageResultMixInBuilder setResults(final java.util.List<FileMetadata> results);
        
    }


}

