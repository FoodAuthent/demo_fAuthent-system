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



import org.foodauthent.model.UserGroupBase;
import org.foodauthent.model.UserGroupBase.UserGroupBaseBuilder;
import org.foodauthent.model.UserGroup;
import org.foodauthent.model.UserGroupCreateRequest;

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
    defaultImpl = UserGroupBase.class)
@JsonSubTypes({
    @Type(value = UserGroupBase.class, name="UserGroupBase")
,
  @Type(value = UserGroup.class, name = "UserGroup")
,
  @Type(value = UserGroupCreateRequest.class, name = "UserGroupCreateRequest")
})
@JsonDeserialize(builder=UserGroupBaseBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface UserGroupBaseMixIn {

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
    

    /**
     * MixIn class for entity builder implementations that adds jackson annotations for the de-/serialization.
     *
     * @author Martin Horn, University of Konstanz
     */
    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "",
        defaultImpl = UserGroupBaseBuilder.class)
    @JsonSubTypes({
        @Type(value = UserGroupBase.UserGroupBaseBuilder.class, name="UserGroupBase")
        ,
      @Type(value = UserGroup.UserGroupBuilder.class, name = "UserGroup")
        ,
      @Type(value = UserGroupCreateRequest.UserGroupCreateRequestBuilder.class, name = "UserGroupCreateRequest")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface UserGroupBaseMixInBuilder {
    
        public UserGroupBaseMixIn build();
    
        @JsonProperty("description")
        public UserGroupBaseMixInBuilder setDescription(final String description);
        
        @JsonProperty("members")
        public UserGroupBaseMixInBuilder setMembers(final java.util.List<String> members);
        
    }


}

