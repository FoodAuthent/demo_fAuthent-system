/*
 * TODO	
 */
package org.foodauthent.model.json.mixin;

import org.foodauthent.model.OrganizationalPostalAddress;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;



import org.foodauthent.model.Organization;
import org.foodauthent.model.Organization.OrganizationBuilder;

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
    defaultImpl = Organization.class)
@JsonSubTypes({
    @Type(value = Organization.class, name="Organization")
})
@JsonDeserialize(builder=OrganizationBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface OrganizationMixIn {

	@JsonIgnore
	public long getPersistenceId();
	
    @JsonIgnore
    public String getTypeID();
    
   	@JsonIgnore
  	public UUID getFaId();
    

    @JsonProperty("description")
    public String getDescription();
    
    @JsonProperty("faxNumbers")
    public java.util.List<String> getFaxNumbers();
    
    @JsonProperty("phoneNumbers")
    public java.util.List<String> getPhoneNumbers();
    
    @JsonProperty("businessCategory")
    public String getBusinessCategory();
    
    @JsonProperty("postalAddress")
    public OrganizationalPostalAddress getPostalAddress();
    
    @JsonProperty("billingAddress")
    public OrganizationalPostalAddress getBillingAddress();
    
    @JsonProperty("dn")
    public String getDn();
    
    @JsonProperty("organizationName")
    public String getOrganizationName();
    

    /**
     * MixIn class for entity builder implementations that adds jackson annotations for the de-/serialization.
     *
     * @author Martin Horn, University of Konstanz
     */
    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "",
        defaultImpl = OrganizationBuilder.class)
    @JsonSubTypes({
        @Type(value = Organization.OrganizationBuilder.class, name="Organization")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface OrganizationMixInBuilder {
    
        public OrganizationMixIn build();
    
        @JsonProperty("description")
        public OrganizationMixInBuilder setDescription(final String description);
        
        @JsonProperty("faxNumbers")
        public OrganizationMixInBuilder setFaxNumbers(final java.util.List<String> faxNumbers);
        
        @JsonProperty("phoneNumbers")
        public OrganizationMixInBuilder setPhoneNumbers(final java.util.List<String> phoneNumbers);
        
        @JsonProperty("businessCategory")
        public OrganizationMixInBuilder setBusinessCategory(final String businessCategory);
        
        @JsonProperty("postalAddress")
        public OrganizationMixInBuilder setPostalAddress(final OrganizationalPostalAddress postalAddress);
        
        @JsonProperty("billingAddress")
        public OrganizationMixInBuilder setBillingAddress(final OrganizationalPostalAddress billingAddress);
        
        @JsonProperty("dn")
        public OrganizationMixInBuilder setDn(final String dn);
        
        @JsonProperty("organizationName")
        public OrganizationMixInBuilder setOrganizationName(final String organizationName);
        
    }


}

