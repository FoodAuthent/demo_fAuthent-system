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




/**
 * The fingerprint/sample raw data.
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class FingerprintRawData  extends FaModel {


  private java.util.UUID parentId;
  private byte[] data;
  
  public String getTypeID() {
    return "FingerprintRawData";
  }
  
  private FingerprintRawData(FingerprintRawDataBuilder builder) {
    
    if(builder.parentId == null) {
        throw new IllegalArgumentException("parentId must not be null.");
    }
    parentId = immutable(builder.parentId);
    if(builder.data == null) {
        throw new IllegalArgumentException("data must not be null.");
    }
    data = immutable(builder.data);
    
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
        FingerprintRawData ent = (FingerprintRawData)o;
        return Objects.equals(parentId, ent.parentId) && Objects.equals(data, ent.data);
    }


  public java.util.UUID getParentId() {
        return parentId;
    }
    
  public byte[] getData() {
        return data;
    }
    
  
 	/**
  	 * @return a newly created builder
  	 */
  	public static FingerprintRawDataBuilder builder() {
  		return new FingerprintRawDataBuilder();
  	}
  
    public static class FingerprintRawDataBuilder {
    
        private FingerprintRawDataBuilder(){
            
        }
    
        private java.util.UUID parentId = null;
        private byte[] data = null;

        public FingerprintRawDataBuilder setParentId(java.util.UUID parentId) {
             if(parentId == null) {
                 throw new IllegalArgumentException("parentId must not be null.");
             }
             this.parentId = parentId;
             return this;
        }

        public FingerprintRawDataBuilder setData(byte[] data) {
             if(data == null) {
                 throw new IllegalArgumentException("data must not be null.");
             }
             this.data = data;
             return this;
        }

        
        public FingerprintRawData build() {
            return new FingerprintRawData(this);
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

    @Override
    public UUID getFaId() {
	// TODO Auto-generated method stub
	return null;
    }
    

}
