/*
 * TODO	
 */
package org.foodauthent.model.json.mixin;

import org.foodauthent.model.Workflow;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;



import org.foodauthent.model.WorkflowPageResult;
import org.foodauthent.model.WorkflowPageResult.WorkflowPageResultBuilder;

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
    defaultImpl = WorkflowPageResult.class)
@JsonSubTypes({
    @Type(value = WorkflowPageResult.class, name="WorkflowPageResult")
})
@JsonDeserialize(builder=WorkflowPageResultBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface WorkflowPageResultMixIn {

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
    public java.util.List<Workflow> getResults();
    

    /**
     * MixIn class for entity builder implementations that adds jackson annotations for the de-/serialization.
     *
     * @author Martin Horn, University of Konstanz
     */
    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "",
        defaultImpl = WorkflowPageResultBuilder.class)
    @JsonSubTypes({
        @Type(value = WorkflowPageResult.WorkflowPageResultBuilder.class, name="WorkflowPageResult")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface WorkflowPageResultMixInBuilder {
    
        public WorkflowPageResultMixIn build();
    
        @JsonProperty("pageNumber")
        public WorkflowPageResultMixInBuilder setPageNumber(final Integer pageNumber);
        
        @JsonProperty("pageCount")
        public WorkflowPageResultMixInBuilder setPageCount(final Integer pageCount);
        
        @JsonProperty("resultCount")
        public WorkflowPageResultMixInBuilder setResultCount(final Integer resultCount);
        
        @JsonProperty("results")
        public WorkflowPageResultMixInBuilder setResults(final java.util.List<Workflow> results);
        
    }


}

