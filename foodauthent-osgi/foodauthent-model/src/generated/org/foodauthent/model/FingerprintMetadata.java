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
 * The fingerprint/sample metadata including, e.g., the meassurment meta data such as device info, processing info, etc.
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class FingerprintMetadata  extends FaModel {


  private java.util.UUID faId;
  private java.util.UUID parentId;
  
  public String getTypeID() {
    return "FingerprintMetadata";
  }
  
  private FingerprintMetadata(FingerprintMetadataBuilder builder) {
    
    faId = immutable(builder.faId);
    parentId = immutable(builder.parentId);
    
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
        FingerprintMetadata ent = (FingerprintMetadata)o;
        return Objects.equals(faId, ent.faId) && Objects.equals(parentId, ent.parentId);
    }


  public java.util.UUID getFaId() {
        return faId;
    }
    
  public java.util.UUID getParentId() {
        return parentId;
    }
    
  
 	/**
  	 * @return a newly created builder
  	 */
  	public static FingerprintMetadataBuilder builder() {
  		return new FingerprintMetadataBuilder();
  	}
  
    public static class FingerprintMetadataBuilder {
    
        private FingerprintMetadataBuilder(){
            
        }
    
        private java.util.UUID faId = null;
        private java.util.UUID parentId = null;

        public FingerprintMetadataBuilder setFaId(java.util.UUID faId) {
             this.faId = faId;
             return this;
        }

        public FingerprintMetadataBuilder setParentId(java.util.UUID parentId) {
             this.parentId = parentId;
             return this;
        }

        
        public FingerprintMetadata build() {
            return new FingerprintMetadata(this);
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
