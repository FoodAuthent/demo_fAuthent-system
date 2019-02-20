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
 * EPC
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class ArrayStringItem   extends FaModel {


  protected String value;
  
  public String getTypeID() {
    return "ArrayStringItem";
  }
  

  @Override
  public java.util.UUID getFaId() {
  	return null;
  }
  
  protected ArrayStringItem() {}
  
  private ArrayStringItem(ArrayStringItemBuilder builder) {
    
    value = immutable(builder.value);
    
    
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
        ArrayStringItem ent = (ArrayStringItem)o;
        return Objects.equals(value, ent.value);
    }


  /**
   * value of the item
   * @return value 
   */
  public String getValue() {
        return value;
    }
    
  
 	/**
  	 * @return a newly created builder
  	 */
  	public static ArrayStringItemBuilder builder() {
  		return new ArrayStringItemBuilder();
  	}
  	
  	/**
	 * Copy-builder, i.e. creates a new builder with all properties of the passed
	 * entity pre-set.
	 * 
	 * @param entity
	 *            entity to copy the properties from
	 * @return a new builder with the properties set
	 */
	public static ArrayStringItemBuilder builder(ArrayStringItem entity) {
		ArrayStringItemBuilder builder = builder();
        builder.value = entity.value;
 		return builder;
  	}
  	
  
    public static class ArrayStringItemBuilder {
    
        protected ArrayStringItemBuilder(){
            
        }
    
        private String value;

        /**
         * value of the item
         * @return value 
         */
        public ArrayStringItemBuilder setValue(String value) {
             this.value = value;
             return this;
        }

        
        public ArrayStringItem build() {
            return new ArrayStringItem(this);
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
