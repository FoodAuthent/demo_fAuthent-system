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



import org.foodauthent.model.UserGroup;
import org.foodauthent.model.UserGroup.UserGroupBuilder;

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
    defaultImpl = UserGroup.class)
@JsonSubTypes({
    @Type(value = UserGroup.class, name="UserGroup")
})
@JsonDeserialize(builder=UserGroupBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface UserGroupMixIn {

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
    
    @JsonProperty("dn")
    public String getDn();
    
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
        defaultImpl = UserGroupBuilder.class)
    @JsonSubTypes({
        @Type(value = UserGroup.UserGroupBuilder.class, name="UserGroup")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface UserGroupMixInBuilder {
    
        public UserGroupMixIn build();
    
        @JsonProperty("description")
        public UserGroupMixInBuilder setDescription(final String description);
        
        @JsonProperty("members")
        public UserGroupMixInBuilder setMembers(final java.util.List<String> members);
        
        @JsonProperty("dn")
        public UserGroupMixInBuilder setDn(final String dn);
        
        @JsonProperty("name")
        public UserGroupMixInBuilder setName(final String name);
        
    }


}

