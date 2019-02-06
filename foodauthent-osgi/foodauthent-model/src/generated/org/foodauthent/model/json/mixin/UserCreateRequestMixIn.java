/*
 * TODO	
 */
package org.foodauthent.model.json.mixin;

import org.foodauthent.model.PostalAddress;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;



import org.foodauthent.model.UserCreateRequest;
import org.foodauthent.model.UserCreateRequest.UserCreateRequestBuilder;

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
    defaultImpl = UserCreateRequest.class)
@JsonSubTypes({
    @Type(value = UserCreateRequest.class, name="UserCreateRequest")
})
@JsonDeserialize(builder=UserCreateRequestBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface UserCreateRequestMixIn {

	@JsonIgnore
	public long getPersistenceId();
	
    @JsonIgnore
    public String getTypeID();
    
   	@JsonIgnore
  	public UUID getFaId();
    

    @JsonProperty("title")
    public String getTitle();
    
    @JsonProperty("givenName")
    public String getGivenName();
    
    @JsonProperty("lastName")
    public String getLastName();
    
    @JsonProperty("mail")
    public java.util.List<String> getMail();
    
    @JsonProperty("description")
    public String getDescription();
    
    @JsonProperty("faxNumbers")
    public java.util.List<String> getFaxNumbers();
    
    @JsonProperty("phoneNumbers")
    public java.util.List<String> getPhoneNumbers();
    
    @JsonProperty("homePhoneNumbers")
    public java.util.List<String> getHomePhoneNumbers();
    
    @JsonProperty("mobilePhoneNumbers")
    public java.util.List<String> getMobilePhoneNumbers();
    
    @JsonProperty("businessCategory")
    public String getBusinessCategory();
    
    @JsonProperty("postalAddress")
    public PostalAddress getPostalAddress();
    
    @JsonProperty("billingAddress")
    public PostalAddress getBillingAddress();
    
    @JsonProperty("secretary")
    public String getSecretary();
    
    @JsonProperty("employeeType")
    public String getEmployeeType();
    
    @JsonProperty("employeeNumber")
    public String getEmployeeNumber();
    
    @JsonProperty("labeledURI")
    public java.util.List<String> getLabeledURI();
    
    @JsonProperty("parentDn")
    public String getParentDn();
    
    @JsonProperty("userName")
    public String getUserName();
    

    /**
     * MixIn class for entity builder implementations that adds jackson annotations for the de-/serialization.
     *
     * @author Martin Horn, University of Konstanz
     */
    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "",
        defaultImpl = UserCreateRequestBuilder.class)
    @JsonSubTypes({
        @Type(value = UserCreateRequest.UserCreateRequestBuilder.class, name="UserCreateRequest")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface UserCreateRequestMixInBuilder {
    
        public UserCreateRequestMixIn build();
    
        @JsonProperty("title")
        public UserCreateRequestMixInBuilder setTitle(final String title);
        
        @JsonProperty("givenName")
        public UserCreateRequestMixInBuilder setGivenName(final String givenName);
        
        @JsonProperty("lastName")
        public UserCreateRequestMixInBuilder setLastName(final String lastName);
        
        @JsonProperty("mail")
        public UserCreateRequestMixInBuilder setMail(final java.util.List<String> mail);
        
        @JsonProperty("description")
        public UserCreateRequestMixInBuilder setDescription(final String description);
        
        @JsonProperty("faxNumbers")
        public UserCreateRequestMixInBuilder setFaxNumbers(final java.util.List<String> faxNumbers);
        
        @JsonProperty("phoneNumbers")
        public UserCreateRequestMixInBuilder setPhoneNumbers(final java.util.List<String> phoneNumbers);
        
        @JsonProperty("homePhoneNumbers")
        public UserCreateRequestMixInBuilder setHomePhoneNumbers(final java.util.List<String> homePhoneNumbers);
        
        @JsonProperty("mobilePhoneNumbers")
        public UserCreateRequestMixInBuilder setMobilePhoneNumbers(final java.util.List<String> mobilePhoneNumbers);
        
        @JsonProperty("businessCategory")
        public UserCreateRequestMixInBuilder setBusinessCategory(final String businessCategory);
        
        @JsonProperty("postalAddress")
        public UserCreateRequestMixInBuilder setPostalAddress(final PostalAddress postalAddress);
        
        @JsonProperty("billingAddress")
        public UserCreateRequestMixInBuilder setBillingAddress(final PostalAddress billingAddress);
        
        @JsonProperty("secretary")
        public UserCreateRequestMixInBuilder setSecretary(final String secretary);
        
        @JsonProperty("employeeType")
        public UserCreateRequestMixInBuilder setEmployeeType(final String employeeType);
        
        @JsonProperty("employeeNumber")
        public UserCreateRequestMixInBuilder setEmployeeNumber(final String employeeNumber);
        
        @JsonProperty("labeledURI")
        public UserCreateRequestMixInBuilder setLabeledURI(final java.util.List<String> labeledURI);
        
        @JsonProperty("parentDn")
        public UserCreateRequestMixInBuilder setParentDn(final String parentDn);
        
        @JsonProperty("userName")
        public UserCreateRequestMixInBuilder setUserName(final String userName);
        
    }


}

