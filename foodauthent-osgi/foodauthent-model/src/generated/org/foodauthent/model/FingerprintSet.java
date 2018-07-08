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
import java.util.UUID;


import org.foodauthent.model.Fingerprint;


/**
 * A set of fingerprints with its own id.
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class FingerprintSet  extends FaModel {


  private java.util.UUID faId;
  private java.util.UUID productId;
  private java.util.List<Fingerprint> fingerprints;
  private String name;
  
  public String getTypeID() {
    return "FingerprintSet";
  }
  

  
  private FingerprintSet(FingerprintSetBuilder builder) {
    
    faId = immutable(builder.faId);
    productId = immutable(builder.productId);
    fingerprints = immutable(builder.fingerprints);
    name = immutable(builder.name);
    
    faId = generateFaIdIfMissing(faId);
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
        FingerprintSet ent = (FingerprintSet)o;
        return Objects.equals(faId, ent.faId) && Objects.equals(productId, ent.productId) && Objects.equals(fingerprints, ent.fingerprints) && Objects.equals(name, ent.name);
    }


  public java.util.UUID getFaId() {
        return faId;
    }
    
  public java.util.UUID getProductId() {
        return productId;
    }
    
  public java.util.List<Fingerprint> getFingerprints() {
        return fingerprints;
    }
    
  public String getName() {
        return name;
    }
    
  
 	/**
  	 * @return a newly created builder
  	 */
  	public static FingerprintSetBuilder builder() {
  		return new FingerprintSetBuilder();
  	}
  	
  	/**
	 * Copy-builder, i.e. creates a new builder with all properties of the passed
	 * entity pre-set.
	 * 
	 * @param entity
	 *            entity to copy the properties from
	 * @return a new builder with the properties set
	 */
	public static FingerprintSetBuilder builder(FingerprintSet entity) {
		FingerprintSetBuilder builder = builder();
        builder.faId = entity.faId;
        builder.productId = entity.productId;
        builder.fingerprints = entity.fingerprints;
        builder.name = entity.name;
 		return builder;
  	}
  	
  
    public static class FingerprintSetBuilder {
    
        private FingerprintSetBuilder(){
            
        }
    
        private java.util.UUID faId = null;
        private java.util.UUID productId = null;
        private java.util.List<Fingerprint> fingerprints = new java.util.ArrayList<>();
        private String name = null;

        public FingerprintSetBuilder setFaId(java.util.UUID faId) {
             this.faId = faId;
             return this;
        }

        public FingerprintSetBuilder setProductId(java.util.UUID productId) {
             this.productId = productId;
             return this;
        }

        public FingerprintSetBuilder setFingerprints(java.util.List<Fingerprint> fingerprints) {
             this.fingerprints = fingerprints;
             return this;
        }

        public FingerprintSetBuilder setName(String name) {
             this.name = name;
             return this;
        }

        
        public FingerprintSet build() {
            return new FingerprintSet(this);
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
