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

import org.foodauthent.model.FingerprintSetType;
import org.foodauthent.model.ModelType;



/**
 * Definition of the workflows input and output types. Types that are not required as input are empty.
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class WorkflowIOTypes   extends FaModel {


  protected FingerprintSetType fingerprintsetType;
  protected ModelType modelType;
  
  public String getTypeID() {
    return "WorkflowIOTypes";
  }
  

  @Override
  public java.util.UUID getFaId() {
  	return null;
  }
  
  protected WorkflowIOTypes() {}
  
  private WorkflowIOTypes(WorkflowIOTypesBuilder builder) {
    
    fingerprintsetType = immutable(builder.fingerprintsetType);
    modelType = immutable(builder.modelType);
    
    
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
        WorkflowIOTypes ent = (WorkflowIOTypes)o;
        return Objects.equals(fingerprintsetType, ent.fingerprintsetType) && Objects.equals(modelType, ent.modelType);
    }


  /**
   * Get fingerprintsetType
   * @return fingerprintsetType 
   */
  public FingerprintSetType getFingerprintsetType() {
        return fingerprintsetType;
    }
    
  /**
   * Get modelType
   * @return modelType 
   */
  public ModelType getModelType() {
        return modelType;
    }
    
  
 	/**
  	 * @return a newly created builder
  	 */
  	public static WorkflowIOTypesBuilder builder() {
  		return new WorkflowIOTypesBuilder();
  	}
  	
  	/**
	 * Copy-builder, i.e. creates a new builder with all properties of the passed
	 * entity pre-set.
	 * 
	 * @param entity
	 *            entity to copy the properties from
	 * @return a new builder with the properties set
	 */
	public static WorkflowIOTypesBuilder builder(WorkflowIOTypes entity) {
		WorkflowIOTypesBuilder builder = builder();
        builder.fingerprintsetType = entity.fingerprintsetType;
        builder.modelType = entity.modelType;
 		return builder;
  	}
  	
  
    public static class WorkflowIOTypesBuilder {
    
        protected WorkflowIOTypesBuilder(){
            
        }
    
        private FingerprintSetType fingerprintsetType;
        private ModelType modelType;

        /**
         * Get fingerprintsetType
         * @return fingerprintsetType 
         */
        public WorkflowIOTypesBuilder setFingerprintsetType(FingerprintSetType fingerprintsetType) {
             this.fingerprintsetType = fingerprintsetType;
             return this;
        }

        /**
         * Get modelType
         * @return modelType 
         */
        public WorkflowIOTypesBuilder setModelType(ModelType modelType) {
             this.modelType = modelType;
             return this;
        }

        
        public WorkflowIOTypes build() {
            return new WorkflowIOTypes(this);
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
