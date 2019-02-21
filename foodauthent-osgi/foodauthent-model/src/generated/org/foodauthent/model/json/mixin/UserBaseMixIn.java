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



import org.foodauthent.model.UserBase;
import org.foodauthent.model.UserBase.UserBaseBuilder;
import org.foodauthent.model.UserCreateRequest;
import org.foodauthent.model.User;

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
    defaultImpl = UserBase.class)
@JsonSubTypes({
    @Type(value = UserBase.class, name="UserBase")
,
  @Type(value = UserCreateRequest.class, name = "UserCreateRequest")
,
  @Type(value = User.class, name = "User")
})
@JsonDeserialize(builder=UserBaseBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface UserBaseMixIn {

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
    

    /**
     * MixIn class for entity builder implementations that adds jackson annotations for the de-/serialization.
     *
     * @author Martin Horn, University of Konstanz
     */
    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "",
        defaultImpl = UserBaseBuilder.class)
    @JsonSubTypes({
        @Type(value = UserBase.UserBaseBuilder.class, name="UserBase")
        ,
      @Type(value = UserCreateRequest.UserCreateRequestBuilder.class, name = "UserCreateRequest")
        ,
      @Type(value = User.UserBuilder.class, name = "User")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface UserBaseMixInBuilder {
    
        public UserBaseMixIn build();
    
        @JsonProperty("title")
        public UserBaseMixInBuilder setTitle(final String title);
        
        @JsonProperty("givenName")
        public UserBaseMixInBuilder setGivenName(final String givenName);
        
        @JsonProperty("lastName")
        public UserBaseMixInBuilder setLastName(final String lastName);
        
        @JsonProperty("mail")
        public UserBaseMixInBuilder setMail(final java.util.List<String> mail);
        
        @JsonProperty("description")
        public UserBaseMixInBuilder setDescription(final String description);
        
        @JsonProperty("faxNumbers")
        public UserBaseMixInBuilder setFaxNumbers(final java.util.List<String> faxNumbers);
        
        @JsonProperty("phoneNumbers")
        public UserBaseMixInBuilder setPhoneNumbers(final java.util.List<String> phoneNumbers);
        
        @JsonProperty("homePhoneNumbers")
        public UserBaseMixInBuilder setHomePhoneNumbers(final java.util.List<String> homePhoneNumbers);
        
        @JsonProperty("mobilePhoneNumbers")
        public UserBaseMixInBuilder setMobilePhoneNumbers(final java.util.List<String> mobilePhoneNumbers);
        
        @JsonProperty("businessCategory")
        public UserBaseMixInBuilder setBusinessCategory(final String businessCategory);
        
        @JsonProperty("postalAddress")
        public UserBaseMixInBuilder setPostalAddress(final PostalAddress postalAddress);
        
        @JsonProperty("billingAddress")
        public UserBaseMixInBuilder setBillingAddress(final PostalAddress billingAddress);
        
        @JsonProperty("secretary")
        public UserBaseMixInBuilder setSecretary(final String secretary);
        
        @JsonProperty("employeeType")
        public UserBaseMixInBuilder setEmployeeType(final String employeeType);
        
        @JsonProperty("employeeNumber")
        public UserBaseMixInBuilder setEmployeeNumber(final String employeeNumber);
        
        @JsonProperty("labeledURI")
        public UserBaseMixInBuilder setLabeledURI(final java.util.List<String> labeledURI);
        
    }


}

