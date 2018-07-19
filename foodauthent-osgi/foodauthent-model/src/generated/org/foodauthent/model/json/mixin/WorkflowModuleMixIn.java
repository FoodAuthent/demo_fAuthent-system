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



import org.foodauthent.model.WorkflowModule;
import org.foodauthent.model.WorkflowModule.WorkflowModuleBuilder;

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
    defaultImpl = WorkflowModule.class)
@JsonSubTypes({
    @Type(value = WorkflowModule.class, name="WorkflowModule")
})
@JsonDeserialize(builder=WorkflowModuleBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface WorkflowModuleMixIn {

	@JsonIgnore
	public long getPersistenceId();
	
    @JsonIgnore
    public String getTypeID();
    
   	@JsonIgnore
  	public UUID getFaId();
    

    @JsonProperty("workflow-id")
    public java.util.UUID getWorkflowId();
    
    @JsonProperty("module-type")
    public String getModuleType();
    
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
        defaultImpl = WorkflowModuleBuilder.class)
    @JsonSubTypes({
        @Type(value = WorkflowModule.WorkflowModuleBuilder.class, name="WorkflowModule")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface WorkflowModuleMixInBuilder {
    
        public WorkflowModuleMixIn build();
    
        @JsonProperty("workflow-id")
        public WorkflowModuleMixInBuilder setWorkflowId(final java.util.UUID workflowId);
        
        @JsonProperty("module-type")
        public WorkflowModuleMixInBuilder setModuleType(final String moduleType);
        
        @JsonProperty("module-parameters")
        public WorkflowModuleMixInBuilder setModuleParameters(final java.util.List<WorkflowParameterMixIn> moduleParameters);
        
    }


}

