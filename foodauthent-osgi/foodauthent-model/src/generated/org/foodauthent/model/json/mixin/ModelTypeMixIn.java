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

import org.foodauthent.model.ModelType.NameEnum;


import org.foodauthent.model.ModelType;
import org.foodauthent.model.ModelType.ModelTypeBuilder;

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
    defaultImpl = ModelType.class)
@JsonSubTypes({
    @Type(value = ModelType.class, name="ModelType")
})
@JsonDeserialize(builder=ModelTypeBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface ModelTypeMixIn {

	@JsonIgnore
	public long getPersistenceId();
	
    @JsonIgnore
    public String getTypeID();
    
   	@JsonIgnore
  	public UUID getFaId();
    

    @JsonProperty("name")
    public NameEnum getName();
    

    /**
     * MixIn class for entity builder implementations that adds jackson annotations for the de-/serialization.
     *
     * @author Martin Horn, University of Konstanz
     */
    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "",
        defaultImpl = ModelTypeBuilder.class)
    @JsonSubTypes({
        @Type(value = ModelType.ModelTypeBuilder.class, name="ModelType")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface ModelTypeMixInBuilder {
    
        public ModelTypeMixIn build();
    
        @JsonProperty("name")
        public ModelTypeMixInBuilder setName(final NameEnum name);
        
    }


}

