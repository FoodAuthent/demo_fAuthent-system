/*
 * TODO	
 */
package org.foodauthent.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.foodauthent.model.PostalAddress;



/**
 * User Object
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class UserCreateRequest extends UserBase  {


  protected String parentDn;
  protected String userName;
  
  public String getTypeID() {
    return "UserCreateRequest";
  }
  

  
  protected UserCreateRequest() {}
  
  private UserCreateRequest(UserCreateRequestBuilder builder) {
    super();
    title = immutable(builder.title);
    if(builder.givenName == null) {
        throw new IllegalArgumentException("givenName must not be null.");
    }
    givenName = immutable(builder.givenName);
    if(builder.lastName == null) {
        throw new IllegalArgumentException("lastName must not be null.");
    }
    lastName = immutable(builder.lastName);
    mail = immutable(builder.mail);
    description = immutable(builder.description);
    faxNumbers = immutable(builder.faxNumbers);
    phoneNumbers = immutable(builder.phoneNumbers);
    homePhoneNumbers = immutable(builder.homePhoneNumbers);
    mobilePhoneNumbers = immutable(builder.mobilePhoneNumbers);
    businessCategory = immutable(builder.businessCategory);
    postalAddress = immutable(builder.postalAddress);
    billingAddress = immutable(builder.billingAddress);
    secretary = immutable(builder.secretary);
    employeeType = immutable(builder.employeeType);
    employeeNumber = immutable(builder.employeeNumber);
    labeledURI = immutable(builder.labeledURI);
    if(builder.parentDn == null) {
        throw new IllegalArgumentException("parentDn must not be null.");
    }
    parentDn = immutable(builder.parentDn);
    if(builder.userName == null) {
        throw new IllegalArgumentException("userName must not be null.");
    }
    userName = immutable(builder.userName);
    
    
  }
  
   /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        UserCreateRequest ent = (UserCreateRequest)o;
        return super.equals(ent);
    }


  /**
   * parent organization&#39;s LDAP dn
   * @return parentDn , never <code>null</code>
   */
  public String getParentDn() {
        return parentDn;
    }
    
  /**
   * unique userid
   * @return userName , never <code>null</code>
   */
  public String getUserName() {
        return userName;
    }
    
  
 	/**
  	 * @return a newly created builder
  	 */
  	public static UserCreateRequestBuilder builder() {
  		return new UserCreateRequestBuilder();
  	}
  	
  	/**
	 * Copy-builder, i.e. creates a new builder with all properties of the passed
	 * entity pre-set.
	 * 
	 * @param entity
	 *            entity to copy the properties from
	 * @return a new builder with the properties set
	 */
	public static UserCreateRequestBuilder builder(UserCreateRequest entity) {
		UserCreateRequestBuilder builder = builder();
        builder.title = entity.title;
        builder.givenName = entity.givenName;
        builder.lastName = entity.lastName;
        builder.mail = entity.mail;
        builder.description = entity.description;
        builder.faxNumbers = entity.faxNumbers;
        builder.phoneNumbers = entity.phoneNumbers;
        builder.homePhoneNumbers = entity.homePhoneNumbers;
        builder.mobilePhoneNumbers = entity.mobilePhoneNumbers;
        builder.businessCategory = entity.businessCategory;
        builder.postalAddress = entity.postalAddress;
        builder.billingAddress = entity.billingAddress;
        builder.secretary = entity.secretary;
        builder.employeeType = entity.employeeType;
        builder.employeeNumber = entity.employeeNumber;
        builder.labeledURI = entity.labeledURI;
        builder.parentDn = entity.parentDn;
        builder.userName = entity.userName;
 		return builder;
  	}
  	
  
    public static class UserCreateRequestBuilder extends UserBaseBuilder {
    
        protected UserCreateRequestBuilder(){
            super();
        }
    
        private String title;
        private String givenName;
        private String lastName;
        private java.util.List<String> mail = new java.util.ArrayList<>();
        private String description;
        private java.util.List<String> faxNumbers = new java.util.ArrayList<>();
        private java.util.List<String> phoneNumbers = new java.util.ArrayList<>();
        private java.util.List<String> homePhoneNumbers = new java.util.ArrayList<>();
        private java.util.List<String> mobilePhoneNumbers = new java.util.ArrayList<>();
        private String businessCategory;
        private PostalAddress postalAddress;
        private PostalAddress billingAddress;
        private String secretary;
        private String employeeType;
        private String employeeNumber;
        private java.util.List<String> labeledURI = new java.util.ArrayList<>();
        private String parentDn;
        private String userName;

        /**
         * title
         * @return title 
         */
        public UserCreateRequestBuilder setTitle(String title) {
             this.title = title;
             return this;
        }

        /**
         * givenName / first name
         * @return givenName , never <code>null</code>
         */
        public UserCreateRequestBuilder setGivenName(String givenName) {
             if(givenName == null) {
                 throw new IllegalArgumentException("givenName must not be null.");
             }
             this.givenName = givenName;
             return this;
        }

        /**
         * last name
         * @return lastName , never <code>null</code>
         */
        public UserCreateRequestBuilder setLastName(String lastName) {
             if(lastName == null) {
                 throw new IllegalArgumentException("lastName must not be null.");
             }
             this.lastName = lastName;
             return this;
        }

        /**
         * email addresses
         * @return mail 
         */
        public UserCreateRequestBuilder setMail(java.util.List<String> mail) {
             this.mail = mail;
             return this;
        }

        /**
         * verbose description
         * @return description 
         */
        public UserCreateRequestBuilder setDescription(String description) {
             this.description = description;
             return this;
        }

        /**
         * fax numbers
         * @return faxNumbers 
         */
        public UserCreateRequestBuilder setFaxNumbers(java.util.List<String> faxNumbers) {
             this.faxNumbers = faxNumbers;
             return this;
        }

        /**
         * phone numbers
         * @return phoneNumbers 
         */
        public UserCreateRequestBuilder setPhoneNumbers(java.util.List<String> phoneNumbers) {
             this.phoneNumbers = phoneNumbers;
             return this;
        }

        /**
         * home phone numbers
         * @return homePhoneNumbers 
         */
        public UserCreateRequestBuilder setHomePhoneNumbers(java.util.List<String> homePhoneNumbers) {
             this.homePhoneNumbers = homePhoneNumbers;
             return this;
        }

        /**
         * mobile phone numbers
         * @return mobilePhoneNumbers 
         */
        public UserCreateRequestBuilder setMobilePhoneNumbers(java.util.List<String> mobilePhoneNumbers) {
             this.mobilePhoneNumbers = mobilePhoneNumbers;
             return this;
        }

        /**
         * business category
         * @return businessCategory 
         */
        public UserCreateRequestBuilder setBusinessCategory(String businessCategory) {
             this.businessCategory = businessCategory;
             return this;
        }

        /**
         * Get postalAddress
         * @return postalAddress 
         */
        public UserCreateRequestBuilder setPostalAddress(PostalAddress postalAddress) {
             this.postalAddress = postalAddress;
             return this;
        }

        /**
         * Get billingAddress
         * @return billingAddress 
         */
        public UserCreateRequestBuilder setBillingAddress(PostalAddress billingAddress) {
             this.billingAddress = billingAddress;
             return this;
        }

        /**
         * secretary
         * @return secretary 
         */
        public UserCreateRequestBuilder setSecretary(String secretary) {
             this.secretary = secretary;
             return this;
        }

        /**
         * employee type
         * @return employeeType 
         */
        public UserCreateRequestBuilder setEmployeeType(String employeeType) {
             this.employeeType = employeeType;
             return this;
        }

        /**
         * employee number
         * @return employeeNumber 
         */
        public UserCreateRequestBuilder setEmployeeNumber(String employeeNumber) {
             this.employeeNumber = employeeNumber;
             return this;
        }

        /**
         * URIs
         * @return labeledURI 
         */
        public UserCreateRequestBuilder setLabeledURI(java.util.List<String> labeledURI) {
             this.labeledURI = labeledURI;
             return this;
        }

        /**
         * parent organization&#39;s LDAP dn
         * @return parentDn , never <code>null</code>
         */
        public UserCreateRequestBuilder setParentDn(String parentDn) {
             if(parentDn == null) {
                 throw new IllegalArgumentException("parentDn must not be null.");
             }
             this.parentDn = parentDn;
             return this;
        }

        /**
         * unique userid
         * @return userName , never <code>null</code>
         */
        public UserCreateRequestBuilder setUserName(String userName) {
             if(userName == null) {
                 throw new IllegalArgumentException("userName must not be null.");
             }
             this.userName = userName;
             return this;
        }

        
        public UserCreateRequest build() {
            return new UserCreateRequest(this);
        }
    
    }
    
    
    /**
     * Turns an object into an immutable one (if not already).
     * TODO move it somewhere else
     *
     * @param obj the object to treat
     * @return the object itself or a immutable copy
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static <T> T immutable(final T obj) {
        if (obj == null) {
            return null;
        } else if (obj instanceof Map) {
            return (T)Collections.unmodifiableMap(new HashMap((Map)obj));
        } else if (obj instanceof List) {
            return (T)Collections.unmodifiableList(new ArrayList((List)obj));
        } else {
            return obj;
        }
    }
    

}
