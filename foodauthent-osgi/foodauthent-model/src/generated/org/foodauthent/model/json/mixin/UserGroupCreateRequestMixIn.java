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



import org.foodauthent.model.UserGroupCreateRequest;
import org.foodauthent.model.UserGroupCreateRequest.UserGroupCreateRequestBuilder;

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
    defaultImpl = UserGroupCreateRequest.class)
@JsonSubTypes({
    @Type(value = UserGroupCreateRequest.class, name="UserGroupCreateRequest")
})
@JsonDeserialize(builder=UserGroupCreateRequestBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface UserGroupCreateRequestMixIn {

	@JsonIgnore
	public long getPersistenceId();
	
    @JsonIgnore
    public String getTypeID();
    
   	@JsonIgnore
  	public UUID getFaId();
    

    @JsonProperty("description")
    public String getDescription();
    
    @JsonProperty("members")
    public java.util.List<String> getMembers();
    
    @JsonProperty("name")
    public String getName();
    

    /**
     * MixIn class for entity builder implementations that adds jackson annotations for the de-/serialization.
     *
     * @author Martin Horn, University of Konstanz
     */
    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "",
        defaultImpl = UserGroupCreateRequestBuilder.class)
    @JsonSubTypes({
        @Type(value = UserGroupCreateRequest.UserGroupCreateRequestBuilder.class, name="UserGroupCreateRequest")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface UserGroupCreateRequestMixInBuilder {
    
        public UserGroupCreateRequestMixIn build();
    
        @JsonProperty("description")
        public UserGroupCreateRequestMixInBuilder setDescription(final String description);
        
        @JsonProperty("members")
        public UserGroupCreateRequestMixInBuilder setMembers(final java.util.List<String> members);
        
        @JsonProperty("name")
        public UserGroupCreateRequestMixInBuilder setName(final String name);
        
    }


}

