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

import org.foodauthent.model.Tag.TypeEnum;


import org.foodauthent.model.Tag;
import org.foodauthent.model.Tag.TagBuilder;

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
    defaultImpl = Tag.class)
@JsonSubTypes({
    @Type(value = Tag.class, name="Tag")
})
@JsonDeserialize(builder=TagBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface TagMixIn {

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
        defaultImpl = TagBuilder.class)
    @JsonSubTypes({
        @Type(value = Tag.TagBuilder.class, name="Tag")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface TagMixInBuilder {
    
        public TagMixIn build();
    
        @JsonProperty("fa-id")
        public TagMixInBuilder setFaId(final java.util.UUID faId);
        
        @JsonProperty("name")
        public TagMixInBuilder setName(final String name);
        
        @JsonProperty("description")
        public TagMixInBuilder setDescription(final String description);
        
        @JsonProperty("type")
        public TagMixInBuilder setType(final TypeEnum type);
        
    }


}

