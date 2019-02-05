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



import org.foodauthent.model.PostalAddress;
import org.foodauthent.model.PostalAddress.PostalAddressBuilder;
import org.foodauthent.model.OrganizationalPostalAddress;

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
    defaultImpl = PostalAddress.class)
@JsonSubTypes({
    @Type(value = PostalAddress.class, name="PostalAddress")
,
  @Type(value = OrganizationalPostalAddress.class, name = "OrganizationalPostalAddress")
})
@JsonDeserialize(builder=PostalAddressBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface PostalAddressMixIn {

	@JsonIgnore
	public long getPersistenceId();
	
    @JsonIgnore
    public String getTypeID();
    
   	@JsonIgnore
  	public UUID getFaId();
    

    @JsonProperty("otherRecipientInformation")
    public String getOtherRecipientInformation();
    
    @JsonProperty("street")
    public String getStreet();
    
    @JsonProperty("postalCode")
    public String getPostalCode();
    
    @JsonProperty("localityName")
    public String getLocalityName();
    
    @JsonProperty("stateOrProvinceName")
    public String getStateOrProvinceName();
    
    @JsonProperty("country")
    public String getCountry();
    

    /**
     * MixIn class for entity builder implementations that adds jackson annotations for the de-/serialization.
     *
     * @author Martin Horn, University of Konstanz
     */
    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "",
        defaultImpl = PostalAddressBuilder.class)
    @JsonSubTypes({
        @Type(value = PostalAddress.PostalAddressBuilder.class, name="PostalAddress")
        ,
      @Type(value = OrganizationalPostalAddress.OrganizationalPostalAddressBuilder.class, name = "OrganizationalPostalAddress")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface PostalAddressMixInBuilder {
    
        public PostalAddressMixIn build();
    
        @JsonProperty("otherRecipientInformation")
        public PostalAddressMixInBuilder setOtherRecipientInformation(final String otherRecipientInformation);
        
        @JsonProperty("street")
        public PostalAddressMixInBuilder setStreet(final String street);
        
        @JsonProperty("postalCode")
        public PostalAddressMixInBuilder setPostalCode(final String postalCode);
        
        @JsonProperty("localityName")
        public PostalAddressMixInBuilder setLocalityName(final String localityName);
        
        @JsonProperty("stateOrProvinceName")
        public PostalAddressMixInBuilder setStateOrProvinceName(final String stateOrProvinceName);
        
        @JsonProperty("country")
        public PostalAddressMixInBuilder setCountry(final String country);
        
    }


}

