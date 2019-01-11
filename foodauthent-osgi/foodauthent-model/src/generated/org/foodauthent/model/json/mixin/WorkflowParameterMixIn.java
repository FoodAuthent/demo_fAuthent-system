/*
 * TODO	
 */
package org.foodauthent.model.json.mixin;


import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import org.foodauthent.model.WorkflowParameter.TypeEnum;


import org.foodauthent.model.WorkflowParameter;
import org.foodauthent.model.WorkflowParameter.WorkflowParameterBuilder;

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
    defaultImpl = WorkflowParameter.class)
@JsonSubTypes({
    @Type(value = WorkflowParameter.class, name="WorkflowParameter")
})
@JsonDeserialize(builder=WorkflowParameterBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface WorkflowParameterMixIn {

	@JsonIgnore
	public long getPersistenceId();
	
    @JsonIgnore
    public String getTypeID();
    
   	@JsonIgnore
  	public UUID getFaId();
    

    @JsonProperty("name")
    public String getName();
    
    @JsonProperty("required")
    public Boolean isRequired();
    
    @JsonProperty("type")
    public TypeEnum getType();
    
    @JsonProperty("value")
    public String getValue();
    

    /**
     * MixIn class for entity builder implementations that adds jackson annotations for the de-/serialization.
     *
     * @author Martin Horn, University of Konstanz
     */
    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "",
        defaultImpl = WorkflowParameterBuilder.class)
    @JsonSubTypes({
        @Type(value = WorkflowParameter.WorkflowParameterBuilder.class, name="WorkflowParameter")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface WorkflowParameterMixInBuilder {
    
        public WorkflowParameterMixIn build();
    
        @JsonProperty("name")
        public WorkflowParameterMixInBuilder setName(final String name);
        
        @JsonProperty("required")
        public WorkflowParameterMixInBuilder setRequired(final Boolean required);
        
        @JsonProperty("type")
        public WorkflowParameterMixInBuilder setType(final TypeEnum type);
        
        @JsonProperty("value")
        public WorkflowParameterMixInBuilder setValue(final String value);
        
    }


}

