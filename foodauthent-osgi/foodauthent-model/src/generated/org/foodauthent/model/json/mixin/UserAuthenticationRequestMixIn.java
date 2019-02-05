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



import org.foodauthent.model.UserAuthenticationRequest;
import org.foodauthent.model.UserAuthenticationRequest.UserAuthenticationRequestBuilder;

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
    defaultImpl = UserAuthenticationRequest.class)
@JsonSubTypes({
    @Type(value = UserAuthenticationRequest.class, name="UserAuthenticationRequest")
})
@JsonDeserialize(builder=UserAuthenticationRequestBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface UserAuthenticationRequestMixIn {

	@JsonIgnore
	public long getPersistenceId();
	
    @JsonIgnore
    public String getTypeID();
    
   	@JsonIgnore
  	public UUID getFaId();
    

    @JsonProperty("user")
    public String getUser();
    
    @JsonProperty("password")
    public String getPassword();
    

    /**
     * MixIn class for entity builder implementations that adds jackson annotations for the de-/serialization.
     *
     * @author Martin Horn, University of Konstanz
     */
    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "",
        defaultImpl = UserAuthenticationRequestBuilder.class)
    @JsonSubTypes({
        @Type(value = UserAuthenticationRequest.UserAuthenticationRequestBuilder.class, name="UserAuthenticationRequest")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface UserAuthenticationRequestMixInBuilder {
    
        public UserAuthenticationRequestMixIn build();
    
        @JsonProperty("user")
        public UserAuthenticationRequestMixInBuilder setUser(final String user);
        
        @JsonProperty("password")
        public UserAuthenticationRequestMixInBuilder setPassword(final String password);
        
    }


}

