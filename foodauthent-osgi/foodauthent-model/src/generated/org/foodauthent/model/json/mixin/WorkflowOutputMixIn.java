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

import org.foodauthent.model.WorkflowOutput.TypeEnum;


import org.foodauthent.model.WorkflowOutput;
import org.foodauthent.model.WorkflowOutput.WorkflowOutputBuilder;

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
    defaultImpl = WorkflowOutput.class)
@JsonSubTypes({
    @Type(value = WorkflowOutput.class, name="WorkflowOutput")
})
@JsonDeserialize(builder=WorkflowOutputBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface WorkflowOutputMixIn {

	@JsonIgnore
	public long getPersistenceId();

    @JsonIgnore
    public String getTypeID();

    @JsonProperty("fa-id")
    public java.util.UUID getFaId();
    
    @JsonProperty("required")
    public Boolean isRequired();
    
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
        defaultImpl = WorkflowOutputBuilder.class)
    @JsonSubTypes({
        @Type(value = WorkflowOutput.WorkflowOutputBuilder.class, name="WorkflowOutput")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface WorkflowOutputMixInBuilder {
    
        public WorkflowOutputMixIn build();
    
        @JsonProperty("fa-id")
        public WorkflowOutputMixInBuilder setFaId(final java.util.UUID faId);
        
        @JsonProperty("required")
        public WorkflowOutputMixInBuilder setRequired(final Boolean required);
        
        @JsonProperty("type")
        public WorkflowOutputMixInBuilder setType(final TypeEnum type);
        
    }


}

