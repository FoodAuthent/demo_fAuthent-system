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
 * SOP
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class SOP   extends FaModel {


  private java.util.UUID faId;
  private String fileLink;
  private String name;
  private String description;
  private java.util.UUID productId;
  
  public String getTypeID() {
    return "SOP";
  }
  

  
  private SOP(SOPBuilder builder) {
    
    faId = immutable(builder.faId);
    fileLink = immutable(builder.fileLink);
    name = immutable(builder.name);
    description = immutable(builder.description);
    productId = immutable(builder.productId);
    
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
        SOP ent = (SOP)o;
        return Objects.equals(faId, ent.faId) && Objects.equals(fileLink, ent.fileLink) && Objects.equals(name, ent.name) && Objects.equals(description, ent.description) && Objects.equals(productId, ent.productId);
    }


  public java.util.UUID getFaId() {
        return faId;
    }
    
  public String getFileLink() {
        return fileLink;
    }
    
  public String getName() {
        return name;
    }
    
  public String getDescription() {
        return description;
    }
    
  public java.util.UUID getProductId() {
        return productId;
    }
    
  
 	/**
  	 * @return a newly created builder
  	 */
  	public static SOPBuilder builder() {
  		return new SOPBuilder();
  	}
  	
  	/**
	 * Copy-builder, i.e. creates a new builder with all properties of the passed
	 * entity pre-set.
	 * 
	 * @param entity
	 *            entity to copy the properties from
	 * @return a new builder with the properties set
	 */
	public static SOPBuilder builder(SOP entity) {
		SOPBuilder builder = builder();
        builder.faId = entity.faId;
        builder.fileLink = entity.fileLink;
        builder.name = entity.name;
        builder.description = entity.description;
        builder.productId = entity.productId;
 		return builder;
  	}
  	
  
    public static class SOPBuilder {
    
        private SOPBuilder(){
            
        }
    
        private java.util.UUID faId = null;
        private String fileLink = null;
        private String name = null;
        private String description = null;
        private java.util.UUID productId = null;

        public SOPBuilder setFaId(java.util.UUID faId) {
             this.faId = faId;
             return this;
        }

        public SOPBuilder setFileLink(String fileLink) {
             this.fileLink = fileLink;
             return this;
        }

        public SOPBuilder setName(String name) {
             this.name = name;
             return this;
        }

        public SOPBuilder setDescription(String description) {
             this.description = description;
             return this;
        }

        public SOPBuilder setProductId(java.util.UUID productId) {
             this.productId = productId;
             return this;
        }

        
        public SOP build() {
            return new SOP(this);
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
