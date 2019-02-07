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

import org.foodauthent.model.FaObjectSet;



/**
 * ImportResult
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class ImportResult   extends FaModel {


  protected java.util.List<String> problems;
  protected FaObjectSet importedObjects;
  
  public String getTypeID() {
    return "ImportResult";
  }
  

  @Override
  public java.util.UUID getFaId() {
  	return null;
  }
  
  protected ImportResult() {}
  
  private ImportResult(ImportResultBuilder builder) {
    
    problems = immutable(builder.problems);
    importedObjects = immutable(builder.importedObjects);
    
    
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
        return Objects.equals(problems, ent.problems) && Objects.equals(importedObjects, ent.importedObjects);
    }


  /**
   * Get problems
   * @return problems 
   */
  public java.util.List<String> getProblems() {
        return problems;
    }
    
  /**
   * Get importedObjects
   * @return importedObjects 
   */
  public FaObjectSet getImportedObjects() {
        return importedObjects;
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
        builder.problems = entity.problems;
        builder.importedObjects = entity.importedObjects;
 		return builder;
  	}
  	
  
    public static class ImportResultBuilder {
    
        protected ImportResultBuilder(){
            
        }
    
        private java.util.List<String> problems = new java.util.ArrayList<>();
        private FaObjectSet importedObjects;

        /**
         * Get problems
         * @return problems 
         */
        public ImportResultBuilder setProblems(java.util.List<String> problems) {
             this.problems = problems;
             return this;
        }

        /**
         * Get importedObjects
         * @return importedObjects 
         */
        public ImportResultBuilder setImportedObjects(FaObjectSet importedObjects) {
             this.importedObjects = importedObjects;
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
