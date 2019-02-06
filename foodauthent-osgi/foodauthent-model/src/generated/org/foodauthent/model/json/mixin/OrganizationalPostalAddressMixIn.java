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



import org.foodauthent.model.OrganizationalPostalAddress;
import org.foodauthent.model.OrganizationalPostalAddress.OrganizationalPostalAddressBuilder;

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
    defaultImpl = OrganizationalPostalAddress.class)
@JsonSubTypes({
    @Type(value = OrganizationalPostalAddress.class, name="OrganizationalPostalAddress")
})
@JsonDeserialize(builder=OrganizationalPostalAddressBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface OrganizationalPostalAddressMixIn {

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
    
    @JsonProperty("recipientName")
    public String getRecipientName();
    

    /**
     * MixIn class for entity builder implementations that adds jackson annotations for the de-/serialization.
     *
     * @author Martin Horn, University of Konstanz
     */
    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "",
        defaultImpl = OrganizationalPostalAddressBuilder.class)
    @JsonSubTypes({
        @Type(value = OrganizationalPostalAddress.OrganizationalPostalAddressBuilder.class, name="OrganizationalPostalAddress")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface OrganizationalPostalAddressMixInBuilder {
    
        public OrganizationalPostalAddressMixIn build();
    
        @JsonProperty("otherRecipientInformation")
        public OrganizationalPostalAddressMixInBuilder setOtherRecipientInformation(final String otherRecipientInformation);
        
        @JsonProperty("street")
        public OrganizationalPostalAddressMixInBuilder setStreet(final String street);
        
        @JsonProperty("postalCode")
        public OrganizationalPostalAddressMixInBuilder setPostalCode(final String postalCode);
        
        @JsonProperty("localityName")
        public OrganizationalPostalAddressMixInBuilder setLocalityName(final String localityName);
        
        @JsonProperty("stateOrProvinceName")
        public OrganizationalPostalAddressMixInBuilder setStateOrProvinceName(final String stateOrProvinceName);
        
        @JsonProperty("country")
        public OrganizationalPostalAddressMixInBuilder setCountry(final String country);
        
        @JsonProperty("recipientName")
        public OrganizationalPostalAddressMixInBuilder setRecipientName(final String recipientName);
        
    }


}

