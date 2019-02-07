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


  protected java.util.List<java.util.UUID> fingerprints;
  protected java.util.List<java.util.UUID> products;
  protected java.util.List<java.util.UUID> sops;
  
  public String getTypeID() {
    return "ImportResult";
  }
  

  @Override
  public java.util.UUID getFaId() {
  	return null;
  }
  
  protected ImportResult() {}
  
  private ImportResult(ImportResultBuilder builder) {
    
    fingerprints = immutable(builder.fingerprints);
    products = immutable(builder.products);
    sops = immutable(builder.sops);
    
    
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
        return Objects.equals(fingerprints, ent.fingerprints) && Objects.equals(products, ent.products) && Objects.equals(sops, ent.sops);
    }


  /**
   * Get fingerprints
   * @return fingerprints 
   */
  public java.util.List<java.util.UUID> getFingerprints() {
        return fingerprints;
    }
    
  /**
   * Get products
   * @return products 
   */
  public java.util.List<java.util.UUID> getProducts() {
        return products;
    }
    
  /**
   * Get sops
   * @return sops 
   */
  public java.util.List<java.util.UUID> getSops() {
        return sops;
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
        builder.fingerprints = entity.fingerprints;
        builder.products = entity.products;
        builder.sops = entity.sops;
 		return builder;
  	}
  	
  
    public static class ImportResultBuilder {
    
        protected ImportResultBuilder(){
            
        }
    
        private java.util.List<java.util.UUID> fingerprints = new java.util.ArrayList<>();
        private java.util.List<java.util.UUID> products = new java.util.ArrayList<>();
        private java.util.List<java.util.UUID> sops = new java.util.ArrayList<>();

        /**
         * Get fingerprints
         * @return fingerprints 
         */
        public ImportResultBuilder setFingerprints(java.util.List<java.util.UUID> fingerprints) {
             this.fingerprints = fingerprints;
             return this;
        }

        /**
         * Get products
         * @return products 
         */
        public ImportResultBuilder setProducts(java.util.List<java.util.UUID> products) {
             this.products = products;
             return this;
        }

        /**
         * Get sops
         * @return sops 
         */
        public ImportResultBuilder setSops(java.util.List<java.util.UUID> sops) {
             this.sops = sops;
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
