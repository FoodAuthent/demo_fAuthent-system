/*
 * TODO	
 */
package org.foodauthent.model.json.mixin;

import org.foodauthent.model.json.mixin.WorkflowParameterMixIn;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import org.foodauthent.model.WorkflowModuleInput.ModuleTypeEnum;


import org.foodauthent.model.WorkflowModuleInput;
import org.foodauthent.model.WorkflowModuleInput.WorkflowModuleInputBuilder;

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
    defaultImpl = WorkflowModuleInput.class)
@JsonSubTypes({
    @Type(value = WorkflowModuleInput.class, name="WorkflowModuleInput")
})
@JsonDeserialize(builder=WorkflowModuleInputBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface WorkflowModuleInputMixIn {

	@JsonIgnore
	public long getPersistenceId();
	
    @JsonIgnore
    public String getTypeID();
    
   	@JsonIgnore
  	public UUID getFaId();
    

    @JsonProperty("workflow-URI")
    public String getWorkflowURI();
    
    @JsonProperty("module-type")
    public ModuleTypeEnum getModuleType();
    
    @JsonProperty("module-parameters")
    public java.util.List<WorkflowParameterMixIn> getModuleParameters();
    

    /**
     * MixIn class for entity builder implementations that adds jackson annotations for the de-/serialization.
     *
     * @author Martin Horn, University of Konstanz
     */
    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "",
        defaultImpl = WorkflowModuleInputBuilder.class)
    @JsonSubTypes({
        @Type(value = WorkflowModuleInput.WorkflowModuleInputBuilder.class, name="WorkflowModuleInput")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface WorkflowModuleInputMixInBuilder {
    
        public WorkflowModuleInputMixIn build();
    
        @JsonProperty("workflow-URI")
        public WorkflowModuleInputMixInBuilder setWorkflowURI(final String workflowURI);
        
        @JsonProperty("module-type")
        public WorkflowModuleInputMixInBuilder setModuleType(final ModuleTypeEnum moduleType);
        
        @JsonProperty("module-parameters")
        public WorkflowModuleInputMixInBuilder setModuleParameters(final java.util.List<WorkflowParameterMixIn> moduleParameters);
        
    }


}

