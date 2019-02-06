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
 * organizational postal address object
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class OrganizationalPostalAddress extends PostalAddress  {


  protected String recipientName;
  
  public String getTypeID() {
    return "OrganizationalPostalAddress";
  }
  

  
  protected OrganizationalPostalAddress() {}
  
  private OrganizationalPostalAddress(OrganizationalPostalAddressBuilder builder) {
    super();
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
    recipientName = immutable(builder.recipientName);
    
    
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
        OrganizationalPostalAddress ent = (OrganizationalPostalAddress)o;
        return super.equals(ent);
    }


  /**
   * recipient address part
   * @return recipientName 
   */
  public String getRecipientName() {
        return recipientName;
    }
    
  
 	/**
  	 * @return a newly created builder
  	 */
  	public static OrganizationalPostalAddressBuilder builder() {
  		return new OrganizationalPostalAddressBuilder();
  	}
  	
  	/**
	 * Copy-builder, i.e. creates a new builder with all properties of the passed
	 * entity pre-set.
	 * 
	 * @param entity
	 *            entity to copy the properties from
	 * @return a new builder with the properties set
	 */
	public static OrganizationalPostalAddressBuilder builder(OrganizationalPostalAddress entity) {
		OrganizationalPostalAddressBuilder builder = builder();
        builder.otherRecipientInformation = entity.otherRecipientInformation;
        builder.street = entity.street;
        builder.postalCode = entity.postalCode;
        builder.localityName = entity.localityName;
        builder.stateOrProvinceName = entity.stateOrProvinceName;
        builder.country = entity.country;
        builder.recipientName = entity.recipientName;
 		return builder;
  	}
  	
  
    public static class OrganizationalPostalAddressBuilder extends PostalAddressBuilder {
    
        protected OrganizationalPostalAddressBuilder(){
            super();
        }
    
        private String otherRecipientInformation;
        private String street;
        private String postalCode;
        private String localityName;
        private String stateOrProvinceName;
        private String country;
        private String recipientName;

        /**
         * recipient address part
         * @return otherRecipientInformation 
         */
        public OrganizationalPostalAddressBuilder setOtherRecipientInformation(String otherRecipientInformation) {
             this.otherRecipientInformation = otherRecipientInformation;
             return this;
        }

        /**
         * street address part
         * @return street , never <code>null</code>
         */
        public OrganizationalPostalAddressBuilder setStreet(String street) {
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
        public OrganizationalPostalAddressBuilder setPostalCode(String postalCode) {
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
        public OrganizationalPostalAddressBuilder setLocalityName(String localityName) {
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
        public OrganizationalPostalAddressBuilder setStateOrProvinceName(String stateOrProvinceName) {
             this.stateOrProvinceName = stateOrProvinceName;
             return this;
        }

        /**
         * country address part
         * @return country 
         */
        public OrganizationalPostalAddressBuilder setCountry(String country) {
             this.country = country;
             return this;
        }

        /**
         * recipient address part
         * @return recipientName 
         */
        public OrganizationalPostalAddressBuilder setRecipientName(String recipientName) {
             this.recipientName = recipientName;
             return this;
        }

        
        public OrganizationalPostalAddress build() {
            return new OrganizationalPostalAddress(this);
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
