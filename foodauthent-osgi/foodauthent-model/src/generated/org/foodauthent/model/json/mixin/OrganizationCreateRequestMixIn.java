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



import org.foodauthent.model.OrganizationCreateRequest;
import org.foodauthent.model.OrganizationCreateRequest.OrganizationCreateRequestBuilder;

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
    defaultImpl = OrganizationCreateRequest.class)
@JsonSubTypes({
    @Type(value = OrganizationCreateRequest.class, name="OrganizationCreateRequest")
})
@JsonDeserialize(builder=OrganizationCreateRequestBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface OrganizationCreateRequestMixIn {

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
    
    @JsonProperty("parentDn")
    public String getParentDn();
    
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
        defaultImpl = OrganizationCreateRequestBuilder.class)
    @JsonSubTypes({
        @Type(value = OrganizationCreateRequest.OrganizationCreateRequestBuilder.class, name="OrganizationCreateRequest")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface OrganizationCreateRequestMixInBuilder {
    
        public OrganizationCreateRequestMixIn build();
    
        @JsonProperty("description")
        public OrganizationCreateRequestMixInBuilder setDescription(final String description);
        
        @JsonProperty("faxNumbers")
        public OrganizationCreateRequestMixInBuilder setFaxNumbers(final java.util.List<String> faxNumbers);
        
        @JsonProperty("phoneNumbers")
        public OrganizationCreateRequestMixInBuilder setPhoneNumbers(final java.util.List<String> phoneNumbers);
        
        @JsonProperty("businessCategory")
        public OrganizationCreateRequestMixInBuilder setBusinessCategory(final String businessCategory);
        
        @JsonProperty("postalAddress")
        public OrganizationCreateRequestMixInBuilder setPostalAddress(final OrganizationalPostalAddress postalAddress);
        
        @JsonProperty("billingAddress")
        public OrganizationCreateRequestMixInBuilder setBillingAddress(final OrganizationalPostalAddress billingAddress);
        
        @JsonProperty("parentDn")
        public OrganizationCreateRequestMixInBuilder setParentDn(final String parentDn);
        
        @JsonProperty("organizationName")
        public OrganizationCreateRequestMixInBuilder setOrganizationName(final String organizationName);
        
    }


}

