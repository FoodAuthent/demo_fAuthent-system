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

import org.foodauthent.model.FingerprintType;



/**
 * A fingerprint object representing its metadata.
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class Fingerprint   extends FaModel {


  protected java.util.UUID faId;
  protected java.util.UUID sampleId;
  protected java.util.UUID fileId;
  protected java.util.UUID sopId;
  protected FingerprintType type;
  
  public String getTypeID() {
    return "Fingerprint";
  }
  

  
  protected Fingerprint() {}
  
  private Fingerprint(FingerprintBuilder builder) {
    
    faId = immutable(builder.faId);
    sampleId = immutable(builder.sampleId);
    fileId = immutable(builder.fileId);
    sopId = immutable(builder.sopId);
    type = immutable(builder.type);
    
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
        Fingerprint ent = (Fingerprint)o;
        return Objects.equals(faId, ent.faId) && Objects.equals(sampleId, ent.sampleId) && Objects.equals(fileId, ent.fileId) && Objects.equals(sopId, ent.sopId) && Objects.equals(type, ent.type);
    }


  /**
   * A global id within the FoodAuthent-system.
   * @return faId 
   */
  public java.util.UUID getFaId() {
        return faId;
    }
    
  /**
   * The fa-id of the sample the fingerprint is associated with.
   * @return sampleId 
   */
  public java.util.UUID getSampleId() {
        return sampleId;
    }
    
  /**
   * Id referencing the fingerprint file.
   * @return fileId 
   */
  public java.util.UUID getFileId() {
        return fileId;
    }
    
  /**
   * reference to sop used to create the fingerprint
   * @return sopId 
   */
  public java.util.UUID getSopId() {
        return sopId;
    }
    
  /**
   * Get type
   * @return type 
   */
  public FingerprintType getType() {
        return type;
    }
    
  
 	/**
  	 * @return a newly created builder
  	 */
  	public static FingerprintBuilder builder() {
  		return new FingerprintBuilder();
  	}
  	
  	/**
	 * Copy-builder, i.e. creates a new builder with all properties of the passed
	 * entity pre-set.
	 * 
	 * @param entity
	 *            entity to copy the properties from
	 * @return a new builder with the properties set
	 */
	public static FingerprintBuilder builder(Fingerprint entity) {
		FingerprintBuilder builder = builder();
        builder.faId = entity.faId;
        builder.sampleId = entity.sampleId;
        builder.fileId = entity.fileId;
        builder.sopId = entity.sopId;
        builder.type = entity.type;
 		return builder;
  	}
  	
  
    public static class FingerprintBuilder {
    
        protected FingerprintBuilder(){
            
        }
    
        private java.util.UUID faId;
        private java.util.UUID sampleId;
        private java.util.UUID fileId;
        private java.util.UUID sopId;
        private FingerprintType type;

        /**
         * A global id within the FoodAuthent-system.
         * @return faId 
         */
        public FingerprintBuilder setFaId(java.util.UUID faId) {
             this.faId = faId;
             return this;
        }

        /**
         * The fa-id of the sample the fingerprint is associated with.
         * @return sampleId 
         */
        public FingerprintBuilder setSampleId(java.util.UUID sampleId) {
             this.sampleId = sampleId;
             return this;
        }

        /**
         * Id referencing the fingerprint file.
         * @return fileId 
         */
        public FingerprintBuilder setFileId(java.util.UUID fileId) {
             this.fileId = fileId;
             return this;
        }

        /**
         * reference to sop used to create the fingerprint
         * @return sopId 
         */
        public FingerprintBuilder setSopId(java.util.UUID sopId) {
             this.sopId = sopId;
             return this;
        }

        /**
         * Get type
         * @return type 
         */
        public FingerprintBuilder setType(FingerprintType type) {
             this.type = type;
             return this;
        }

        
        public Fingerprint build() {
            return new Fingerprint(this);
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
