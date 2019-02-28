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

import org.foodauthent.model.GPCAttribute;



/**
 * Global Product Classification Brick for storing gpc brick details
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class GPCBrick   extends FaModel {


  protected String code;
  protected String text;
  protected java.util.List<GPCAttribute> attributes;
  
  public String getTypeID() {
    return "GPCBrick";
  }
  

  @Override
  public java.util.UUID getFaId() {
  	return null;
  }
  
  protected GPCBrick() {}
  
  private GPCBrick(GPCBrickBuilder builder) {
    
    code = immutable(builder.code);
    text = immutable(builder.text);
    attributes = immutable(builder.attributes);
    
    
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
        GPCBrick ent = (GPCBrick)o;
        return Objects.equals(code, ent.code) && Objects.equals(text, ent.text) && Objects.equals(attributes, ent.attributes);
    }


  /**
   * GPC brick code
   * @return code 
   */
  public String getCode() {
        return code;
    }
    
  /**
   * GPC brick human readable text
   * @return text 
   */
  public String getText() {
        return text;
    }
    
  /**
   * Get attributes
   * @return attributes 
   */
  public java.util.List<GPCAttribute> getAttributes() {
        return attributes;
    }
    
  
 	/**
  	 * @return a newly created builder
  	 */
  	public static GPCBrickBuilder builder() {
  		return new GPCBrickBuilder();
  	}
  	
  	/**
	 * Copy-builder, i.e. creates a new builder with all properties of the passed
	 * entity pre-set.
	 * 
	 * @param entity
	 *            entity to copy the properties from
	 * @return a new builder with the properties set
	 */
	public static GPCBrickBuilder builder(GPCBrick entity) {
		GPCBrickBuilder builder = builder();
        builder.code = entity.code;
        builder.text = entity.text;
        builder.attributes = entity.attributes;
 		return builder;
  	}
  	
  
    public static class GPCBrickBuilder {
    
        protected GPCBrickBuilder(){
            
        }
    
        private String code;
        private String text;
        private java.util.List<GPCAttribute> attributes = new java.util.ArrayList<>();

        /**
         * GPC brick code
         * @return code 
         */
        public GPCBrickBuilder setCode(String code) {
             this.code = code;
             return this;
        }

        /**
         * GPC brick human readable text
         * @return text 
         */
        public GPCBrickBuilder setText(String text) {
             this.text = text;
             return this;
        }

        /**
         * Get attributes
         * @return attributes 
         */
        public GPCBrickBuilder setAttributes(java.util.List<GPCAttribute> attributes) {
             this.attributes = attributes;
             return this;
        }

        
        public GPCBrick build() {
            return new GPCBrick(this);
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
