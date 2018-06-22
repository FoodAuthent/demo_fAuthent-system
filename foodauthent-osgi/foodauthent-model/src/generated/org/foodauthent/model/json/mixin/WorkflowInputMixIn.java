/*
 * TODO	
 */
package org.foodauthent.model.json.mixin;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import org.foodauthent.model.WorkflowInput.TypeEnum;


import org.foodauthent.model.WorkflowInput;
import org.foodauthent.model.WorkflowInput.WorkflowInputBuilder;

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
    defaultImpl = WorkflowInput.class)
@JsonSubTypes({
    @Type(value = WorkflowInput.class, name="WorkflowInput")
})
@JsonDeserialize(builder=WorkflowInputBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface WorkflowInputMixIn {

	@JsonIgnore
	public long getPersistenceId();

    @JsonIgnore
    public String getTypeID();

    @JsonProperty("fa-id")
    public java.util.UUID getFaId();
    
    @JsonProperty("id")
    public String getId();
    
    @JsonProperty("required")
    public Boolean Required();
    
    @JsonProperty("type")
    public TypeEnum getType();
    

    /**
     * MixIn class for entity builder implementations that adds jackson annotations for the de-/serialization.
     *
     * @author Martin Horn, University of Konstanz
     */
    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "",
        defaultImpl = WorkflowInputBuilder.class)
    @JsonSubTypes({
        @Type(value = WorkflowInput.WorkflowInputBuilder.class, name="WorkflowInput")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface WorkflowInputMixInBuilder {
    
        public WorkflowInputMixIn build();
    
        @JsonProperty("fa-id")
        public WorkflowInputMixInBuilder setFaId(final java.util.UUID faId);
        
        @JsonProperty("id")
        public WorkflowInputMixInBuilder setId(final String id);
        
        @JsonProperty("required")
        public WorkflowInputMixInBuilder setRequired(final Boolean required);
        
        @JsonProperty("type")
        public WorkflowInputMixInBuilder setType(final TypeEnum type);
        
    }


}

