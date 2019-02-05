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




/**
 * postal address object
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class PostalAddress   extends FaModel {


  protected String otherRecipientInformation;
  protected String street;
  protected String postalCode;
  protected String localityName;
  protected String stateOrProvinceName;
  protected String country;
  
  public String getTypeID() {
    return "PostalAddress";
  }
  

  @Override
  public java.util.UUID getFaId() {
  	return null;
  }
  
  protected PostalAddress() {}
  
  private PostalAddress(PostalAddressBuilder builder) {
    
    otherRecipientInformation = immutable(builder.otherRecipientInformation);
    if(builder.street == null) {
        throw new IllegalArgumentException("street must not be null.");
    }
    street = immutable(builder.street);
    if(builder.postalCode == null) {
        throw new IllegalArgumentException("postalCode must not be null.");
    }
    postalCode = immutable(builder.postalCode);
    if(builder.localityName == null) {
        throw new IllegalArgumentException("localityName must not be null.");
    }
    localityName = immutable(builder.localityName);
    stateOrProvinceName = immutable(builder.stateOrProvinceName);
    country = immutable(builder.country);
    
    
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
        PostalAddress ent = (PostalAddress)o;
        return Objects.equals(otherRecipientInformation, ent.otherRecipientInformation) && Objects.equals(street, ent.street) && Objects.equals(postalCode, ent.postalCode) && Objects.equals(localityName, ent.localityName) && Objects.equals(stateOrProvinceName, ent.stateOrProvinceName) && Objects.equals(country, ent.country);
    }


  /**
   * recipient address part
   * @return otherRecipientInformation 
   */
  public String getOtherRecipientInformation() {
        return otherRecipientInformation;
    }
    
  /**
   * street address part
   * @return street , never <code>null</code>
   */
  public String getStreet() {
        return street;
    }
    
  /**
   * postalCode address part
   * @return postalCode , never <code>null</code>
   */
  public String getPostalCode() {
        return postalCode;
    }
    
  /**
   * locality/city address part
   * @return localityName , never <code>null</code>
   */
  public String getLocalityName() {
        return localityName;
    }
    
  /**
   * stateOrProvinceName address part
   * @return stateOrProvinceName 
   */
  public String getStateOrProvinceName() {
        return stateOrProvinceName;
    }
    
  /**
   * country address part
   * @return country 
   */
  public String getCountry() {
        return country;
    }
    
  
 	/**
  	 * @return a newly created builder
  	 */
  	public static PostalAddressBuilder builder() {
  		return new PostalAddressBuilder();
  	}
  	
  	/**
	 * Copy-builder, i.e. creates a new builder with all properties of the passed
	 * entity pre-set.
	 * 
	 * @param entity
	 *            entity to copy the properties from
	 * @return a new builder with the properties set
	 */
	public static PostalAddressBuilder builder(PostalAddress entity) {
		PostalAddressBuilder builder = builder();
        builder.otherRecipientInformation = entity.otherRecipientInformation;
        builder.street = entity.street;
        builder.postalCode = entity.postalCode;
        builder.localityName = entity.localityName;
        builder.stateOrProvinceName = entity.stateOrProvinceName;
        builder.country = entity.country;
 		return builder;
  	}
  	
  
    public static class PostalAddressBuilder {
    
        protected PostalAddressBuilder(){
            
        }
    
        private String otherRecipientInformation;
        private String street;
        private String postalCode;
        private String localityName;
        private String stateOrProvinceName;
        private String country;

        /**
         * recipient address part
         * @return otherRecipientInformation 
         */
        public PostalAddressBuilder setOtherRecipientInformation(String otherRecipientInformation) {
             this.otherRecipientInformation = otherRecipientInformation;
             return this;
        }

        /**
         * street address part
         * @return street , never <code>null</code>
         */
        public PostalAddressBuilder setStreet(String street) {
             if(street == null) {
                 throw new IllegalArgumentException("street must not be null.");
             }
             this.street = street;
             return this;
        }

        /**
         * postalCode address part
         * @return postalCode , never <code>null</code>
         */
        public PostalAddressBuilder setPostalCode(String postalCode) {
             if(postalCode == null) {
                 throw new IllegalArgumentException("postalCode must not be null.");
             }
             this.postalCode = postalCode;
             return this;
        }

        /**
         * locality/city address part
         * @return localityName , never <code>null</code>
         */
        public PostalAddressBuilder setLocalityName(String localityName) {
             if(localityName == null) {
                 throw new IllegalArgumentException("localityName must not be null.");
             }
             this.localityName = localityName;
             return this;
        }

        /**
         * stateOrProvinceName address part
         * @return stateOrProvinceName 
         */
        public PostalAddressBuilder setStateOrProvinceName(String stateOrProvinceName) {
             this.stateOrProvinceName = stateOrProvinceName;
             return this;
        }

        /**
         * country address part
         * @return country 
         */
        public PostalAddressBuilder setCountry(String country) {
             this.country = country;
             return this;
        }

        
        public PostalAddress build() {
            return new PostalAddress(this);
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
