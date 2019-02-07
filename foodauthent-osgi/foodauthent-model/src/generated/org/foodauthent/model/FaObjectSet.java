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
 * FaObjectSet
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class FaObjectSet   extends FaModel {


  protected java.util.List<java.util.UUID> fingerprints;
  protected java.util.List<java.util.UUID> products;
  protected java.util.List<java.util.UUID> sops;
  protected java.util.List<java.util.UUID> workflows;
  protected java.util.List<java.util.UUID> files;
  
  public String getTypeID() {
    return "FaObjectSet";
  }
  

  @Override
  public java.util.UUID getFaId() {
  	return null;
  }
  
  protected FaObjectSet() {}
  
  private FaObjectSet(FaObjectSetBuilder builder) {
    
    fingerprints = immutable(builder.fingerprints);
    products = immutable(builder.products);
    sops = immutable(builder.sops);
    workflows = immutable(builder.workflows);
    files = immutable(builder.files);
    
    
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
        FaObjectSet ent = (FaObjectSet)o;
        return Objects.equals(fingerprints, ent.fingerprints) && Objects.equals(products, ent.products) && Objects.equals(sops, ent.sops) && Objects.equals(workflows, ent.workflows) && Objects.equals(files, ent.files);
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
   * Get workflows
   * @return workflows 
   */
  public java.util.List<java.util.UUID> getWorkflows() {
        return workflows;
    }
    
  /**
   * Get files
   * @return files 
   */
  public java.util.List<java.util.UUID> getFiles() {
        return files;
    }
    
  
 	/**
  	 * @return a newly created builder
  	 */
  	public static FaObjectSetBuilder builder() {
  		return new FaObjectSetBuilder();
  	}
  	
  	/**
	 * Copy-builder, i.e. creates a new builder with all properties of the passed
	 * entity pre-set.
	 * 
	 * @param entity
	 *            entity to copy the properties from
	 * @return a new builder with the properties set
	 */
	public static FaObjectSetBuilder builder(FaObjectSet entity) {
		FaObjectSetBuilder builder = builder();
        builder.fingerprints = entity.fingerprints;
        builder.products = entity.products;
        builder.sops = entity.sops;
        builder.workflows = entity.workflows;
        builder.files = entity.files;
 		return builder;
  	}
  	
  
    public static class FaObjectSetBuilder {
    
        protected FaObjectSetBuilder(){
            
        }
    
        private java.util.List<java.util.UUID> fingerprints = new java.util.ArrayList<>();
        private java.util.List<java.util.UUID> products = new java.util.ArrayList<>();
        private java.util.List<java.util.UUID> sops = new java.util.ArrayList<>();
        private java.util.List<java.util.UUID> workflows = new java.util.ArrayList<>();
        private java.util.List<java.util.UUID> files = new java.util.ArrayList<>();

        /**
         * Get fingerprints
         * @return fingerprints 
         */
        public FaObjectSetBuilder setFingerprints(java.util.List<java.util.UUID> fingerprints) {
             this.fingerprints = fingerprints;
             return this;
        }

        /**
         * Get products
         * @return products 
         */
        public FaObjectSetBuilder setProducts(java.util.List<java.util.UUID> products) {
             this.products = products;
             return this;
        }

        /**
         * Get sops
         * @return sops 
         */
        public FaObjectSetBuilder setSops(java.util.List<java.util.UUID> sops) {
             this.sops = sops;
             return this;
        }

        /**
         * Get workflows
         * @return workflows 
         */
        public FaObjectSetBuilder setWorkflows(java.util.List<java.util.UUID> workflows) {
             this.workflows = workflows;
             return this;
        }

        /**
         * Get files
         * @return files 
         */
        public FaObjectSetBuilder setFiles(java.util.List<java.util.UUID> files) {
             this.files = files;
             return this;
        }

        
        public FaObjectSet build() {
            return new FaObjectSet(this);
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
