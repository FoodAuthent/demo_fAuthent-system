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
 * User Base Object
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class UserBase   extends FaModel {


  protected String title;
  protected String givenName;
  protected String lastName;
  protected java.util.List<String> mail;
  protected String description;
  protected java.util.List<String> faxNumbers;
  protected java.util.List<String> phoneNumbers;
  protected java.util.List<String> homePhoneNumbers;
  protected java.util.List<String> mobilePhoneNumbers;
  protected String businessCategory;
  protected PostalAddress postalAddress;
  protected PostalAddress billingAddress;
  protected String secretary;
  protected String employeeType;
  protected String employeeNumber;
  protected java.util.List<String> labeledURI;
  
  public String getTypeID() {
    return "UserBase";
  }
  

  @Override
  public java.util.UUID getFaId() {
  	return null;
  }
  
  protected UserBase() {}
  
  private UserBase(UserBaseBuilder builder) {
    
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
        UserBase ent = (UserBase)o;
        return Objects.equals(title, ent.title) && Objects.equals(givenName, ent.givenName) && Objects.equals(lastName, ent.lastName) && Objects.equals(mail, ent.mail) && Objects.equals(description, ent.description) && Objects.equals(faxNumbers, ent.faxNumbers) && Objects.equals(phoneNumbers, ent.phoneNumbers) && Objects.equals(homePhoneNumbers, ent.homePhoneNumbers) && Objects.equals(mobilePhoneNumbers, ent.mobilePhoneNumbers) && Objects.equals(businessCategory, ent.businessCategory) && Objects.equals(postalAddress, ent.postalAddress) && Objects.equals(billingAddress, ent.billingAddress) && Objects.equals(secretary, ent.secretary) && Objects.equals(employeeType, ent.employeeType) && Objects.equals(employeeNumber, ent.employeeNumber) && Objects.equals(labeledURI, ent.labeledURI);
    }


  /**
   * title
   * @return title 
   */
  public String getTitle() {
        return title;
    }
    
  /**
   * givenName / first name
   * @return givenName , never <code>null</code>
   */
  public String getGivenName() {
        return givenName;
    }
    
  /**
   * last name
   * @return lastName , never <code>null</code>
   */
  public String getLastName() {
        return lastName;
    }
    
  /**
   * email addresses
   * @return mail 
   */
  public java.util.List<String> getMail() {
        return mail;
    }
    
  /**
   * verbose description
   * @return description 
   */
  public String getDescription() {
        return description;
    }
    
  /**
   * fax numbers
   * @return faxNumbers 
   */
  public java.util.List<String> getFaxNumbers() {
        return faxNumbers;
    }
    
  /**
   * phone numbers
   * @return phoneNumbers 
   */
  public java.util.List<String> getPhoneNumbers() {
        return phoneNumbers;
    }
    
  /**
   * home phone numbers
   * @return homePhoneNumbers 
   */
  public java.util.List<String> getHomePhoneNumbers() {
        return homePhoneNumbers;
    }
    
  /**
   * mobile phone numbers
   * @return mobilePhoneNumbers 
   */
  public java.util.List<String> getMobilePhoneNumbers() {
        return mobilePhoneNumbers;
    }
    
  /**
   * business category
   * @return businessCategory 
   */
  public String getBusinessCategory() {
        return businessCategory;
    }
    
  /**
   * Get postalAddress
   * @return postalAddress 
   */
  public PostalAddress getPostalAddress() {
        return postalAddress;
    }
    
  /**
   * Get billingAddress
   * @return billingAddress 
   */
  public PostalAddress getBillingAddress() {
        return billingAddress;
    }
    
  /**
   * secretary
   * @return secretary 
   */
  public String getSecretary() {
        return secretary;
    }
    
  /**
   * employee type
   * @return employeeType 
   */
  public String getEmployeeType() {
        return employeeType;
    }
    
  /**
   * employee number
   * @return employeeNumber 
   */
  public String getEmployeeNumber() {
        return employeeNumber;
    }
    
  /**
   * URIs
   * @return labeledURI 
   */
  public java.util.List<String> getLabeledURI() {
        return labeledURI;
    }
    
  
 	/**
  	 * @return a newly created builder
  	 */
  	public static UserBaseBuilder builder() {
  		return new UserBaseBuilder();
  	}
  	
  	/**
	 * Copy-builder, i.e. creates a new builder with all properties of the passed
	 * entity pre-set.
	 * 
	 * @param entity
	 *            entity to copy the properties from
	 * @return a new builder with the properties set
	 */
	public static UserBaseBuilder builder(UserBase entity) {
		UserBaseBuilder builder = builder();
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
 		return builder;
  	}
  	
  
    public static class UserBaseBuilder {
    
        protected UserBaseBuilder(){
            
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

        /**
         * title
         * @return title 
         */
        public UserBaseBuilder setTitle(String title) {
             this.title = title;
             return this;
        }

        /**
         * givenName / first name
         * @return givenName , never <code>null</code>
         */
        public UserBaseBuilder setGivenName(String givenName) {
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
        public UserBaseBuilder setLastName(String lastName) {
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
        public UserBaseBuilder setMail(java.util.List<String> mail) {
             this.mail = mail;
             return this;
        }

        /**
         * verbose description
         * @return description 
         */
        public UserBaseBuilder setDescription(String description) {
             this.description = description;
             return this;
        }

        /**
         * fax numbers
         * @return faxNumbers 
         */
        public UserBaseBuilder setFaxNumbers(java.util.List<String> faxNumbers) {
             this.faxNumbers = faxNumbers;
             return this;
        }

        /**
         * phone numbers
         * @return phoneNumbers 
         */
        public UserBaseBuilder setPhoneNumbers(java.util.List<String> phoneNumbers) {
             this.phoneNumbers = phoneNumbers;
             return this;
        }

        /**
         * home phone numbers
         * @return homePhoneNumbers 
         */
        public UserBaseBuilder setHomePhoneNumbers(java.util.List<String> homePhoneNumbers) {
             this.homePhoneNumbers = homePhoneNumbers;
             return this;
        }

        /**
         * mobile phone numbers
         * @return mobilePhoneNumbers 
         */
        public UserBaseBuilder setMobilePhoneNumbers(java.util.List<String> mobilePhoneNumbers) {
             this.mobilePhoneNumbers = mobilePhoneNumbers;
             return this;
        }

        /**
         * business category
         * @return businessCategory 
         */
        public UserBaseBuilder setBusinessCategory(String businessCategory) {
             this.businessCategory = businessCategory;
             return this;
        }

        /**
         * Get postalAddress
         * @return postalAddress 
         */
        public UserBaseBuilder setPostalAddress(PostalAddress postalAddress) {
             this.postalAddress = postalAddress;
             return this;
        }

        /**
         * Get billingAddress
         * @return billingAddress 
         */
        public UserBaseBuilder setBillingAddress(PostalAddress billingAddress) {
             this.billingAddress = billingAddress;
             return this;
        }

        /**
         * secretary
         * @return secretary 
         */
        public UserBaseBuilder setSecretary(String secretary) {
             this.secretary = secretary;
             return this;
        }

        /**
         * employee type
         * @return employeeType 
         */
        public UserBaseBuilder setEmployeeType(String employeeType) {
             this.employeeType = employeeType;
             return this;
        }

        /**
         * employee number
         * @return employeeNumber 
         */
        public UserBaseBuilder setEmployeeNumber(String employeeNumber) {
             this.employeeNumber = employeeNumber;
             return this;
        }

        /**
         * URIs
         * @return labeledURI 
         */
        public UserBaseBuilder setLabeledURI(java.util.List<String> labeledURI) {
             this.labeledURI = labeledURI;
             return this;
        }

        
        public UserBase build() {
            return new UserBase(this);
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
