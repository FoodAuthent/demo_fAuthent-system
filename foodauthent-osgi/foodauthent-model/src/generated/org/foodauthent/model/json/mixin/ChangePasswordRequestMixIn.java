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



import org.foodauthent.model.ChangePasswordRequest;
import org.foodauthent.model.ChangePasswordRequest.ChangePasswordRequestBuilder;

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
    defaultImpl = ChangePasswordRequest.class)
@JsonSubTypes({
    @Type(value = ChangePasswordRequest.class, name="ChangePasswordRequest")
})
@JsonDeserialize(builder=ChangePasswordRequestBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface ChangePasswordRequestMixIn {

	@JsonIgnore
	public long getPersistenceId();
	
    @JsonIgnore
    public String getTypeID();
    
   	@JsonIgnore
  	public UUID getFaId();
    

    @JsonProperty("current")
    public String getCurrent();
    
    @JsonProperty("new")
    public String getNew();
    

    /**
     * MixIn class for entity builder implementations that adds jackson annotations for the de-/serialization.
     *
     * @author Martin Horn, University of Konstanz
     */
    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "",
        defaultImpl = ChangePasswordRequestBuilder.class)
    @JsonSubTypes({
        @Type(value = ChangePasswordRequest.ChangePasswordRequestBuilder.class, name="ChangePasswordRequest")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface ChangePasswordRequestMixInBuilder {
    
        public ChangePasswordRequestMixIn build();
    
        @JsonProperty("current")
        public ChangePasswordRequestMixInBuilder setCurrent(final String current);
        
        @JsonProperty("new")
        public ChangePasswordRequestMixInBuilder setNew(final String _new);
        
    }


}

