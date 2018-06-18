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
 * The raw fingerprint/sample metadata including, e.g., the meassurment meta data such as device info, processing info, etc.
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class Fingerprint  extends FaModel {


  private java.util.UUID faId;
  
  public String getTypeID() {
    return "Fingerprint";
  }
  
  private Fingerprint(FingerprintBuilder builder) {
    
    faId = immutable(builder.faId);
    
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
        return Objects.equals(faId, ent.faId);
    }


  public java.util.UUID getFaId() {
        return faId;
    }
    
  
 	/**
  	 * @return a newly created builder
  	 */
  	public static FingerprintBuilder builder() {
  		return new FingerprintBuilder();
  	}
  
    public static class FingerprintBuilder {
    
        private FingerprintBuilder(){
            
        }
    
        private java.util.UUID faId = null;

        public FingerprintBuilder setFaId(java.util.UUID faId) {
             this.faId = faId;
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
