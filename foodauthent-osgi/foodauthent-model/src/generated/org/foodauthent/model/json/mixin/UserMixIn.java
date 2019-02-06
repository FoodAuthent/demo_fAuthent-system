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



import org.foodauthent.model.User;
import org.foodauthent.model.User.UserBuilder;

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
    defaultImpl = User.class)
@JsonSubTypes({
    @Type(value = User.class, name="User")
})
@JsonDeserialize(builder=UserBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface UserMixIn {

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
    
    @JsonProperty("dn")
    public String getDn();
    
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
        defaultImpl = UserBuilder.class)
    @JsonSubTypes({
        @Type(value = User.UserBuilder.class, name="User")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface UserMixInBuilder {
    
        public UserMixIn build();
    
        @JsonProperty("title")
        public UserMixInBuilder setTitle(final String title);
        
        @JsonProperty("givenName")
        public UserMixInBuilder setGivenName(final String givenName);
        
        @JsonProperty("lastName")
        public UserMixInBuilder setLastName(final String lastName);
        
        @JsonProperty("mail")
        public UserMixInBuilder setMail(final java.util.List<String> mail);
        
        @JsonProperty("description")
        public UserMixInBuilder setDescription(final String description);
        
        @JsonProperty("faxNumbers")
        public UserMixInBuilder setFaxNumbers(final java.util.List<String> faxNumbers);
        
        @JsonProperty("phoneNumbers")
        public UserMixInBuilder setPhoneNumbers(final java.util.List<String> phoneNumbers);
        
        @JsonProperty("homePhoneNumbers")
        public UserMixInBuilder setHomePhoneNumbers(final java.util.List<String> homePhoneNumbers);
        
        @JsonProperty("mobilePhoneNumbers")
        public UserMixInBuilder setMobilePhoneNumbers(final java.util.List<String> mobilePhoneNumbers);
        
        @JsonProperty("businessCategory")
        public UserMixInBuilder setBusinessCategory(final String businessCategory);
        
        @JsonProperty("postalAddress")
        public UserMixInBuilder setPostalAddress(final PostalAddress postalAddress);
        
        @JsonProperty("billingAddress")
        public UserMixInBuilder setBillingAddress(final PostalAddress billingAddress);
        
        @JsonProperty("secretary")
        public UserMixInBuilder setSecretary(final String secretary);
        
        @JsonProperty("employeeType")
        public UserMixInBuilder setEmployeeType(final String employeeType);
        
        @JsonProperty("employeeNumber")
        public UserMixInBuilder setEmployeeNumber(final String employeeNumber);
        
        @JsonProperty("labeledURI")
        public UserMixInBuilder setLabeledURI(final java.util.List<String> labeledURI);
        
        @JsonProperty("dn")
        public UserMixInBuilder setDn(final String dn);
        
        @JsonProperty("userName")
        public UserMixInBuilder setUserName(final String userName);
        
    }


}

