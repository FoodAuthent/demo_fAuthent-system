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
 * A set of fingerprints with its own id.
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class FingerprintSet   extends FaModel {


  protected java.util.UUID faId;
  protected java.util.List<java.util.UUID> fingerprintIds;
  protected String name;
  protected String description;
  protected String classLabel;
  
  public String getTypeID() {
    return "FingerprintSet";
  }
  

  
  protected FingerprintSet() {}
  
  private FingerprintSet(FingerprintSetBuilder builder) {
    
    faId = immutable(builder.faId);
    if(builder.fingerprintIds == null) {
        throw new IllegalArgumentException("fingerprintIds must not be null.");
    }
    fingerprintIds = immutable(builder.fingerprintIds);
    if(builder.name == null) {
        throw new IllegalArgumentException("name must not be null.");
    }
    name = immutable(builder.name);
    description = immutable(builder.description);
    classLabel = immutable(builder.classLabel);
    
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
        return Objects.equals(faId, ent.faId) && Objects.equals(fingerprintIds, ent.fingerprintIds) && Objects.equals(name, ent.name) && Objects.equals(description, ent.description) && Objects.equals(classLabel, ent.classLabel);
    }


  /**
   * A global id within the FoodAuthent-system.
   * @return faId 
   */
  public java.util.UUID getFaId() {
        return faId;
    }
    
  /**
   * Ids referencing the fingerprints this set summarizes.
   * @return fingerprintIds , never <code>null</code>
   */
  public java.util.List<java.util.UUID> getFingerprintIds() {
        return fingerprintIds;
    }
    
  /**
   * A human-readable name of the fingerprint set.
   * @return name , never <code>null</code>
   */
  public String getName() {
        return name;
    }
    
  /**
   * A more detailed description of the fingerprint set.
   * @return description 
   */
  public String getDescription() {
        return description;
    }
    
  /**
   * A class label associated with this fingerprint set.
   * @return classLabel 
   */
  public String getClassLabel() {
        return classLabel;
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
        builder.fingerprintIds = entity.fingerprintIds;
        builder.name = entity.name;
        builder.description = entity.description;
        builder.classLabel = entity.classLabel;
 		return builder;
  	}
  	
  
    public static class FingerprintSetBuilder {
    
        protected FingerprintSetBuilder(){
            
        }
    
        private java.util.UUID faId;
        private java.util.List<java.util.UUID> fingerprintIds = new java.util.ArrayList<>();
        private String name;
        private String description;
        private String classLabel;

        /**
         * A global id within the FoodAuthent-system.
         * @return faId 
         */
        public FingerprintSetBuilder setFaId(java.util.UUID faId) {
             this.faId = faId;
             return this;
        }

        /**
         * Ids referencing the fingerprints this set summarizes.
         * @return fingerprintIds , never <code>null</code>
         */
        public FingerprintSetBuilder setFingerprintIds(java.util.List<java.util.UUID> fingerprintIds) {
             if(fingerprintIds == null) {
                 throw new IllegalArgumentException("fingerprintIds must not be null.");
             }
             this.fingerprintIds = fingerprintIds;
             return this;
        }

        /**
         * A human-readable name of the fingerprint set.
         * @return name , never <code>null</code>
         */
        public FingerprintSetBuilder setName(String name) {
             if(name == null) {
                 throw new IllegalArgumentException("name must not be null.");
             }
             this.name = name;
             return this;
        }

        /**
         * A more detailed description of the fingerprint set.
         * @return description 
         */
        public FingerprintSetBuilder setDescription(String description) {
             this.description = description;
             return this;
        }

        /**
         * A class label associated with this fingerprint set.
         * @return classLabel 
         */
        public FingerprintSetBuilder setClassLabel(String classLabel) {
             this.classLabel = classLabel;
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
