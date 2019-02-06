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

import org.foodauthent.model.OrganizationalPostalAddress;



/**
 * Organization Base Object
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class OrganizationBase   extends FaModel {


  protected String description;
  protected java.util.List<String> faxNumbers;
  protected java.util.List<String> phoneNumbers;
  protected String businessCategory;
  protected OrganizationalPostalAddress postalAddress;
  protected OrganizationalPostalAddress billingAddress;
  
  public String getTypeID() {
    return "OrganizationBase";
  }
  

  @Override
  public java.util.UUID getFaId() {
  	return null;
  }
  
  protected OrganizationBase() {}
  
  private OrganizationBase(OrganizationBaseBuilder builder) {
    
    description = immutable(builder.description);
    faxNumbers = immutable(builder.faxNumbers);
    phoneNumbers = immutable(builder.phoneNumbers);
    businessCategory = immutable(builder.businessCategory);
    postalAddress = immutable(builder.postalAddress);
    billingAddress = immutable(builder.billingAddress);
    
    
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
        OrganizationBase ent = (OrganizationBase)o;
        return Objects.equals(description, ent.description) && Objects.equals(faxNumbers, ent.faxNumbers) && Objects.equals(phoneNumbers, ent.phoneNumbers) && Objects.equals(businessCategory, ent.businessCategory) && Objects.equals(postalAddress, ent.postalAddress) && Objects.equals(billingAddress, ent.billingAddress);
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
  public OrganizationalPostalAddress getPostalAddress() {
        return postalAddress;
    }
    
  /**
   * Get billingAddress
   * @return billingAddress 
   */
  public OrganizationalPostalAddress getBillingAddress() {
        return billingAddress;
    }
    
  
 	/**
  	 * @return a newly created builder
  	 */
  	public static OrganizationBaseBuilder builder() {
  		return new OrganizationBaseBuilder();
  	}
  	
  	/**
	 * Copy-builder, i.e. creates a new builder with all properties of the passed
	 * entity pre-set.
	 * 
	 * @param entity
	 *            entity to copy the properties from
	 * @return a new builder with the properties set
	 */
	public static OrganizationBaseBuilder builder(OrganizationBase entity) {
		OrganizationBaseBuilder builder = builder();
        builder.description = entity.description;
        builder.faxNumbers = entity.faxNumbers;
        builder.phoneNumbers = entity.phoneNumbers;
        builder.businessCategory = entity.businessCategory;
        builder.postalAddress = entity.postalAddress;
        builder.billingAddress = entity.billingAddress;
 		return builder;
  	}
  	
  
    public static class OrganizationBaseBuilder {
    
        protected OrganizationBaseBuilder(){
            
        }
    
        private String description;
        private java.util.List<String> faxNumbers = new java.util.ArrayList<>();
        private java.util.List<String> phoneNumbers = new java.util.ArrayList<>();
        private String businessCategory;
        private OrganizationalPostalAddress postalAddress;
        private OrganizationalPostalAddress billingAddress;

        /**
         * verbose description
         * @return description 
         */
        public OrganizationBaseBuilder setDescription(String description) {
             this.description = description;
             return this;
        }

        /**
         * fax numbers
         * @return faxNumbers 
         */
        public OrganizationBaseBuilder setFaxNumbers(java.util.List<String> faxNumbers) {
             this.faxNumbers = faxNumbers;
             return this;
        }

        /**
         * phone numbers
         * @return phoneNumbers 
         */
        public OrganizationBaseBuilder setPhoneNumbers(java.util.List<String> phoneNumbers) {
             this.phoneNumbers = phoneNumbers;
             return this;
        }

        /**
         * business category
         * @return businessCategory 
         */
        public OrganizationBaseBuilder setBusinessCategory(String businessCategory) {
             this.businessCategory = businessCategory;
             return this;
        }

        /**
         * Get postalAddress
         * @return postalAddress 
         */
        public OrganizationBaseBuilder setPostalAddress(OrganizationalPostalAddress postalAddress) {
             this.postalAddress = postalAddress;
             return this;
        }

        /**
         * Get billingAddress
         * @return billingAddress 
         */
        public OrganizationBaseBuilder setBillingAddress(OrganizationalPostalAddress billingAddress) {
             this.billingAddress = billingAddress;
             return this;
        }

        
        public OrganizationBase build() {
            return new OrganizationBase(this);
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
