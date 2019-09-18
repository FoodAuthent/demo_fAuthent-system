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

import org.foodauthent.model.GPCAttributeValue;




/**
 * Global Product Classification Attribute for storing gpc brick details
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class GPCAttribute   extends FaModel {


  protected String code;
  protected String text;
  protected java.util.List<GPCAttributeValue> values;
  
  public String getTypeID() {
    return "GPCAttribute";
  }
  

  @Override
  public java.util.UUID getFaId() {
  	return null;
  }
  
  protected GPCAttribute() {}
  
  private GPCAttribute(GPCAttributeBuilder builder) {
    
    code = immutable(builder.code);
    text = immutable(builder.text);
    values = immutable(builder.values);
    
    
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
        return Objects.equals(code, ent.code) && Objects.equals(text, ent.text) && Objects.equals(values, ent.values);
    }


  /**
   * GPC attribute code
   * @return code 
   */
  public String getCode() {
        return code;
    }
    
  /**
   * GPC attribute human readable text
   * @return text 
   */
  public String getText() {
        return text;
    }
    
  /**
   * Get values
   * @return values 
   */
  public java.util.List<GPCAttributeValue> getValues() {
        return values;
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
        builder.code = entity.code;
        builder.text = entity.text;
        builder.values = entity.values;
 		return builder;
  	}
  	
  
    public static class GPCAttributeBuilder {
    
        protected GPCAttributeBuilder(){
            
        }
    
        private String code;
        private String text;
        private java.util.List<GPCAttributeValue> values = new java.util.ArrayList<>();

        /**
         * GPC attribute code
         * @return code 
         */
        public GPCAttributeBuilder setCode(String code) {
             this.code = code;
             return this;
        }

        /**
         * GPC attribute human readable text
         * @return text 
         */
        public GPCAttributeBuilder setText(String text) {
             this.text = text;
             return this;
        }

        /**
         * Get values
         * @return values 
         */
        public GPCAttributeBuilder setValues(java.util.List<GPCAttributeValue> values) {
             this.values = values;
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
