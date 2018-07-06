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
 * One or more metadata entries (key-value-pair)
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class MetadataEntries  extends FaModel {


  private java.util.UUID faId;
  
  public String getTypeID() {
    return "MetadataEntries";
  }
  
  private MetadataEntries(MetadataEntriesBuilder builder) {
    
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
        MetadataEntries ent = (MetadataEntries)o;
        return Objects.equals(faId, ent.faId);
    }


  public java.util.UUID getFaId() {
        return faId;
    }
    
  
 	/**
  	 * @return a newly created builder
  	 */
  	public static MetadataEntriesBuilder builder() {
  		return new MetadataEntriesBuilder();
  	}
  	
  	/**
	 * Copy-builder, i.e. creates a new builder with all properties of the passed
	 * entity pre-set.
	 * 
	 * @param entity
	 *            entity to copy the properties from
	 * @return a new builder with the properties set
	 */
	public static MetadataEntriesBuilder builder(MetadataEntries entity) {
		MetadataEntriesBuilder builder = builder();
        builder.faId = entity.faId;
 		return builder;
  	}
  	
  
    public static class MetadataEntriesBuilder {
    
        private MetadataEntriesBuilder(){
            
        }
    
        private java.util.UUID faId = null;

        public MetadataEntriesBuilder setFaId(java.util.UUID faId) {
             this.faId = faId;
             return this;
        }

        
        public MetadataEntries build() {
            return new MetadataEntries(this);
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
