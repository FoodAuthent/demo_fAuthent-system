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
 * Type of the fingerprint. The referenced file musst reflect this type, too.
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class FingerprintType   extends FaModel {

  /**
   * Gets or Sets name
   */
  public static enum NameEnum {
    BRUKER("bruker");

    private String value;

    NameEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

  }


  protected NameEnum name;
  
  public String getTypeID() {
    return "FingerprintType";
  }
  

  @Override
  public java.util.UUID getFaId() {
  	return null;
  }
  
  protected FingerprintType() {}
  
  private FingerprintType(FingerprintTypeBuilder builder) {
    
    if(builder.name == null) {
        throw new IllegalArgumentException("name must not be null.");
    }
    name = immutable(builder.name);
    
    
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
        FingerprintType ent = (FingerprintType)o;
        return Objects.equals(name, ent.name);
    }


  /**
   * Get name
   * @return name , never <code>null</code>
   */
  public NameEnum getName() {
        return name;
    }
    
  
 	/**
  	 * @return a newly created builder
  	 */
  	public static FingerprintTypeBuilder builder() {
  		return new FingerprintTypeBuilder();
  	}
  	
  	/**
	 * Copy-builder, i.e. creates a new builder with all properties of the passed
	 * entity pre-set.
	 * 
	 * @param entity
	 *            entity to copy the properties from
	 * @return a new builder with the properties set
	 */
	public static FingerprintTypeBuilder builder(FingerprintType entity) {
		FingerprintTypeBuilder builder = builder();
        builder.name = entity.name;
 		return builder;
  	}
  	
  
    public static class FingerprintTypeBuilder {
    
        protected FingerprintTypeBuilder(){
            
        }
    
        private NameEnum name;

        /**
         * Get name
         * @return name , never <code>null</code>
         */
        public FingerprintTypeBuilder setName(NameEnum name) {
             if(name == null) {
                 throw new IllegalArgumentException("name must not be null.");
             }
             this.name = name;
             return this;
        }

        
        public FingerprintType build() {
            return new FingerprintType(this);
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
