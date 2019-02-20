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
 * Global Product Classification Attribute for storing gpc brick details
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class GPCAttribute   extends FaModel {


  protected String attributeTypeCode;
  protected String attributeTypeName;
  protected String attributeValueCode;
  protected String attributeValueName;
  
  public String getTypeID() {
    return "GPCAttribute";
  }
  

  @Override
  public java.util.UUID getFaId() {
  	return null;
  }
  
  protected GPCAttribute() {}
  
  private GPCAttribute(GPCAttributeBuilder builder) {
    
    attributeTypeCode = immutable(builder.attributeTypeCode);
    attributeTypeName = immutable(builder.attributeTypeName);
    attributeValueCode = immutable(builder.attributeValueCode);
    attributeValueName = immutable(builder.attributeValueName);
    
    
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
        GPCAttribute ent = (GPCAttribute)o;
        return Objects.equals(attributeTypeCode, ent.attributeTypeCode) && Objects.equals(attributeTypeName, ent.attributeTypeName) && Objects.equals(attributeValueCode, ent.attributeValueCode) && Objects.equals(attributeValueName, ent.attributeValueName);
    }


  /**
   * GPC brick code
   * @return attributeTypeCode 
   */
  public String getAttributeTypeCode() {
        return attributeTypeCode;
    }
    
  /**
   * GPC brick human readable name
   * @return attributeTypeName 
   */
  public String getAttributeTypeName() {
        return attributeTypeName;
    }
    
  /**
   * GPC brick&#39;s value
   * @return attributeValueCode 
   */
  public String getAttributeValueCode() {
        return attributeValueCode;
    }
    
  /**
   * GPC brick&#39;s value human readable description
   * @return attributeValueName 
   */
  public String getAttributeValueName() {
        return attributeValueName;
    }
    
  
 	/**
  	 * @return a newly created builder
  	 */
  	public static GPCAttributeBuilder builder() {
  		return new GPCAttributeBuilder();
  	}
  	
  	/**
	 * Copy-builder, i.e. creates a new builder with all properties of the passed
	 * entity pre-set.
	 * 
	 * @param entity
	 *            entity to copy the properties from
	 * @return a new builder with the properties set
	 */
	public static GPCAttributeBuilder builder(GPCAttribute entity) {
		GPCAttributeBuilder builder = builder();
        builder.attributeTypeCode = entity.attributeTypeCode;
        builder.attributeTypeName = entity.attributeTypeName;
        builder.attributeValueCode = entity.attributeValueCode;
        builder.attributeValueName = entity.attributeValueName;
 		return builder;
  	}
  	
  
    public static class GPCAttributeBuilder {
    
        protected GPCAttributeBuilder(){
            
        }
    
        private String attributeTypeCode;
        private String attributeTypeName;
        private String attributeValueCode;
        private String attributeValueName;

        /**
         * GPC brick code
         * @return attributeTypeCode 
         */
        public GPCAttributeBuilder setAttributeTypeCode(String attributeTypeCode) {
             this.attributeTypeCode = attributeTypeCode;
             return this;
        }

        /**
         * GPC brick human readable name
         * @return attributeTypeName 
         */
        public GPCAttributeBuilder setAttributeTypeName(String attributeTypeName) {
             this.attributeTypeName = attributeTypeName;
             return this;
        }

        /**
         * GPC brick&#39;s value
         * @return attributeValueCode 
         */
        public GPCAttributeBuilder setAttributeValueCode(String attributeValueCode) {
             this.attributeValueCode = attributeValueCode;
             return this;
        }

        /**
         * GPC brick&#39;s value human readable description
         * @return attributeValueName 
         */
        public GPCAttributeBuilder setAttributeValueName(String attributeValueName) {
             this.attributeValueName = attributeValueName;
             return this;
        }

        
        public GPCAttribute build() {
            return new GPCAttribute(this);
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
