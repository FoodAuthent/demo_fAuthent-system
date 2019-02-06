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



import org.foodauthent.model.OrganizationBase;
import org.foodauthent.model.OrganizationBase.OrganizationBaseBuilder;
import org.foodauthent.model.Organization;
import org.foodauthent.model.OrganizationCreateRequest;

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
    defaultImpl = OrganizationBase.class)
@JsonSubTypes({
    @Type(value = OrganizationBase.class, name="OrganizationBase")
,
  @Type(value = Organization.class, name = "Organization")
,
  @Type(value = OrganizationCreateRequest.class, name = "OrganizationCreateRequest")
})
@JsonDeserialize(builder=OrganizationBaseBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface OrganizationBaseMixIn {

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
    

    /**
     * MixIn class for entity builder implementations that adds jackson annotations for the de-/serialization.
     *
     * @author Martin Horn, University of Konstanz
     */
    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "",
        defaultImpl = OrganizationBaseBuilder.class)
    @JsonSubTypes({
        @Type(value = OrganizationBase.OrganizationBaseBuilder.class, name="OrganizationBase")
        ,
      @Type(value = Organization.OrganizationBuilder.class, name = "Organization")
        ,
      @Type(value = OrganizationCreateRequest.OrganizationCreateRequestBuilder.class, name = "OrganizationCreateRequest")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface OrganizationBaseMixInBuilder {
    
        public OrganizationBaseMixIn build();
    
        @JsonProperty("description")
        public OrganizationBaseMixInBuilder setDescription(final String description);
        
        @JsonProperty("faxNumbers")
        public OrganizationBaseMixInBuilder setFaxNumbers(final java.util.List<String> faxNumbers);
        
        @JsonProperty("phoneNumbers")
        public OrganizationBaseMixInBuilder setPhoneNumbers(final java.util.List<String> phoneNumbers);
        
        @JsonProperty("businessCategory")
        public OrganizationBaseMixInBuilder setBusinessCategory(final String businessCategory);
        
        @JsonProperty("postalAddress")
        public OrganizationBaseMixInBuilder setPostalAddress(final OrganizationalPostalAddress postalAddress);
        
        @JsonProperty("billingAddress")
        public OrganizationBaseMixInBuilder setBillingAddress(final OrganizationalPostalAddress billingAddress);
        
    }


}

