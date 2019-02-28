/*
 * TODO	
 */
package org.foodauthent.model.json.mixin;

import org.foodauthent.model.Tag;
import org.foodauthent.model.WorkflowIOTypes;
import org.foodauthent.model.WorkflowParameter;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import org.foodauthent.model.Workflow.RepresentationEnum;
import org.foodauthent.model.Workflow.TypeEnum;


import org.foodauthent.model.Workflow;
import org.foodauthent.model.Workflow.WorkflowBuilder;

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
    defaultImpl = Workflow.class)
@JsonSubTypes({
    @Type(value = Workflow.class, name="Workflow")
})
@JsonDeserialize(builder=WorkflowBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface WorkflowMixIn {

	@JsonIgnore
	public long getPersistenceId();
	
    @JsonIgnore
    public String getTypeID();
    
    

    @JsonProperty("fa-id")
    public java.util.UUID getFaId();
    
    @JsonProperty("name")
    public String getName();
    
    @JsonProperty("description")
    public String getDescription();
    
    @JsonProperty("representation")
    public RepresentationEnum getRepresentation();
    
    @JsonProperty("type")
    public TypeEnum getType();
    
    @JsonProperty("parameters")
    public java.util.List<WorkflowParameter> getParameters();
    
    @JsonProperty("tags")
    public java.util.List<Tag> getTags();
    
    @JsonProperty("file-id")
    public java.util.UUID getFileId();
    
    @JsonProperty("output-types")
    public WorkflowIOTypes getOutputTypes();
    
    @JsonProperty("input-types")
    public WorkflowIOTypes getInputTypes();
    

    /**
     * MixIn class for entity builder implementations that adds jackson annotations for the de-/serialization.
     *
     * @author Martin Horn, University of Konstanz
     */
    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "",
        defaultImpl = WorkflowBuilder.class)
    @JsonSubTypes({
        @Type(value = Workflow.WorkflowBuilder.class, name="Workflow")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface WorkflowMixInBuilder {
    
        public WorkflowMixIn build();
    
        @JsonProperty("fa-id")
        public WorkflowMixInBuilder setFaId(final java.util.UUID faId);
        
        @JsonProperty("name")
        public WorkflowMixInBuilder setName(final String name);
        
        @JsonProperty("description")
        public WorkflowMixInBuilder setDescription(final String description);
        
        @JsonProperty("representation")
        public WorkflowMixInBuilder setRepresentation(final RepresentationEnum representation);
        
        @JsonProperty("type")
        public WorkflowMixInBuilder setType(final TypeEnum type);
        
        @JsonProperty("parameters")
        public WorkflowMixInBuilder setParameters(final java.util.List<WorkflowParameter> parameters);
        
        @JsonProperty("tags")
        public WorkflowMixInBuilder setTags(final java.util.List<Tag> tags);
        
        @JsonProperty("file-id")
        public WorkflowMixInBuilder setFileId(final java.util.UUID fileId);
        
        @JsonProperty("output-types")
        public WorkflowMixInBuilder setOutputTypes(final WorkflowIOTypes outputTypes);
        
        @JsonProperty("input-types")
        public WorkflowMixInBuilder setInputTypes(final WorkflowIOTypes inputTypes);
        
    }


}

