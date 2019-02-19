/*
 * TODO	
 */
package org.foodauthent.model.json.mixin;

import org.foodauthent.model.ObjectEvent;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;



import org.foodauthent.model.ObjectEventPageResult;
import org.foodauthent.model.ObjectEventPageResult.ObjectEventPageResultBuilder;

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
    defaultImpl = ObjectEventPageResult.class)
@JsonSubTypes({
    @Type(value = ObjectEventPageResult.class, name="ObjectEventPageResult")
})
@JsonDeserialize(builder=ObjectEventPageResultBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface ObjectEventPageResultMixIn {

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
    public java.util.List<ObjectEvent> getResults();
    

    /**
     * MixIn class for entity builder implementations that adds jackson annotations for the de-/serialization.
     *
     * @author Martin Horn, University of Konstanz
     */
    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "",
        defaultImpl = ObjectEventPageResultBuilder.class)
    @JsonSubTypes({
        @Type(value = ObjectEventPageResult.ObjectEventPageResultBuilder.class, name="ObjectEventPageResult")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface ObjectEventPageResultMixInBuilder {
    
        public ObjectEventPageResultMixIn build();
    
        @JsonProperty("pageNumber")
        public ObjectEventPageResultMixInBuilder setPageNumber(final Integer pageNumber);
        
        @JsonProperty("pageCount")
        public ObjectEventPageResultMixInBuilder setPageCount(final Integer pageCount);
        
        @JsonProperty("resultCount")
        public ObjectEventPageResultMixInBuilder setResultCount(final Integer resultCount);
        
        @JsonProperty("results")
        public ObjectEventPageResultMixInBuilder setResults(final java.util.List<ObjectEvent> results);
        
    }


}

