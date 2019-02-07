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
 * ImportResult
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class ImportResult   extends FaModel {


  protected java.util.List<java.util.UUID> products;
  
  public String getTypeID() {
    return "ImportResult";
  }
  

  @Override
  public java.util.UUID getFaId() {
  	return null;
  }
  
  protected ImportResult() {}
  
  private ImportResult(ImportResultBuilder builder) {
    
    products = immutable(builder.products);
    
    
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
        ImportResult ent = (ImportResult)o;
        return Objects.equals(products, ent.products);
    }


  /**
   * Get products
   * @return products 
   */
  public java.util.List<java.util.UUID> getProducts() {
        return products;
    }
    
  
 	/**
  	 * @return a newly created builder
  	 */
  	public static ImportResultBuilder builder() {
  		return new ImportResultBuilder();
  	}
  	
  	/**
	 * Copy-builder, i.e. creates a new builder with all properties of the passed
	 * entity pre-set.
	 * 
	 * @param entity
	 *            entity to copy the properties from
	 * @return a new builder with the properties set
	 */
	public static ImportResultBuilder builder(ImportResult entity) {
		ImportResultBuilder builder = builder();
        builder.products = entity.products;
 		return builder;
  	}
  	
  
    public static class ImportResultBuilder {
    
        protected ImportResultBuilder(){
            
        }
    
        private java.util.List<java.util.UUID> products = new java.util.ArrayList<>();

        /**
         * Get products
         * @return products 
         */
        public ImportResultBuilder setProducts(java.util.List<java.util.UUID> products) {
             this.products = products;
             return this;
        }

        
        public ImportResult build() {
            return new ImportResult(this);
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
