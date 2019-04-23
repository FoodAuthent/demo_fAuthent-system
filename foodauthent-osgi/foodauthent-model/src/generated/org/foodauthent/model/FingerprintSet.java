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

import org.foodauthent.model.Fingerprint;
import org.foodauthent.model.FingerprintSetType;



/**
 * A set of fingerprints with its own id.
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class FingerprintSet   extends FaModel {


  protected java.util.UUID faId;
  protected java.util.UUID productId;
  protected java.util.List<Fingerprint> fingerprints;
  protected java.util.UUID fileId;
  protected String name;
<<<<<<< HEAD
  protected FingerprintSetType type;
=======
  protected String description;
  protected String classLabel;
>>>>>>> master
  
  public String getTypeID() {
    return "FingerprintSet";
  }
  

  
  protected FingerprintSet() {}
  
  private FingerprintSet(FingerprintSetBuilder builder) {
    
    faId = immutable(builder.faId);
    if(builder.productId == null) {
        throw new IllegalArgumentException("productId must not be null.");
    }
    productId = immutable(builder.productId);
    fingerprints = immutable(builder.fingerprints);
    if(builder.fileId == null) {
        throw new IllegalArgumentException("fileId must not be null.");
    }
    fileId = immutable(builder.fileId);
    name = immutable(builder.name);
<<<<<<< HEAD
    if(builder.type == null) {
        throw new IllegalArgumentException("type must not be null.");
    }
    type = immutable(builder.type);
=======
    description = immutable(builder.description);
    classLabel = immutable(builder.classLabel);
>>>>>>> master
    
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
<<<<<<< HEAD
        return Objects.equals(faId, ent.faId) && Objects.equals(productId, ent.productId) && Objects.equals(fingerprints, ent.fingerprints) && Objects.equals(fileId, ent.fileId) && Objects.equals(name, ent.name) && Objects.equals(type, ent.type);
=======
        return Objects.equals(faId, ent.faId) && Objects.equals(fingerprintIds, ent.fingerprintIds) && Objects.equals(name, ent.name) && Objects.equals(description, ent.description) && Objects.equals(classLabel, ent.classLabel);
>>>>>>> master
    }


  /**
   * A global id within the FoodAuthent-system.
   * @return faId 
   */
  public java.util.UUID getFaId() {
        return faId;
    }
    
  /**
   * The fa-id of the product all fingerprints are associated with.
   * @return productId , never <code>null</code>
   */
  public java.util.UUID getProductId() {
        return productId;
    }
    
  /**
   * The fingerprints.
   * @return fingerprints 
   */
  public java.util.List<Fingerprint> getFingerprints() {
        return fingerprints;
    }
    
  /**
   * Id referencing the fingerpint-set file.
   * @return fileId , never <code>null</code>
   */
  public java.util.UUID getFileId() {
        return fileId;
    }
    
  /**
   * A human-readable name of the fingerprint set.
   * @return name 
   */
  public String getName() {
        return name;
    }
    
  /**
   * Get type
   * @return type , never <code>null</code>
   */
  public FingerprintSetType getType() {
        return type;
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
        builder.productId = entity.productId;
        builder.fingerprints = entity.fingerprints;
        builder.fileId = entity.fileId;
        builder.name = entity.name;
<<<<<<< HEAD
        builder.type = entity.type;
=======
        builder.description = entity.description;
        builder.classLabel = entity.classLabel;
>>>>>>> master
 		return builder;
  	}
  	
  
    public static class FingerprintSetBuilder {
    
        protected FingerprintSetBuilder(){
            
        }
    
        private java.util.UUID faId;
        private java.util.UUID productId;
        private java.util.List<Fingerprint> fingerprints = new java.util.ArrayList<>();
        private java.util.UUID fileId;
        private String name;
<<<<<<< HEAD
        private FingerprintSetType type;
=======
        private String description;
        private String classLabel;
>>>>>>> master

        /**
         * A global id within the FoodAuthent-system.
         * @return faId 
         */
        public FingerprintSetBuilder setFaId(java.util.UUID faId) {
             this.faId = faId;
             return this;
        }

        /**
         * The fa-id of the product all fingerprints are associated with.
         * @return productId , never <code>null</code>
         */
        public FingerprintSetBuilder setProductId(java.util.UUID productId) {
             if(productId == null) {
                 throw new IllegalArgumentException("productId must not be null.");
             }
             this.productId = productId;
             return this;
        }

        /**
         * The fingerprints.
         * @return fingerprints 
         */
        public FingerprintSetBuilder setFingerprints(java.util.List<Fingerprint> fingerprints) {
             this.fingerprints = fingerprints;
             return this;
        }

        /**
         * Id referencing the fingerpint-set file.
         * @return fileId , never <code>null</code>
         */
        public FingerprintSetBuilder setFileId(java.util.UUID fileId) {
             if(fileId == null) {
                 throw new IllegalArgumentException("fileId must not be null.");
             }
             this.fileId = fileId;
             return this;
        }

        /**
         * A human-readable name of the fingerprint set.
         * @return name 
         */
        public FingerprintSetBuilder setName(String name) {
             this.name = name;
             return this;
        }

        /**
         * Get type
         * @return type , never <code>null</code>
         */
        public FingerprintSetBuilder setType(FingerprintSetType type) {
             if(type == null) {
                 throw new IllegalArgumentException("type must not be null.");
             }
             this.type = type;
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
