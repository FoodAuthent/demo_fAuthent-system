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
 * Describes the outputs delivered by a training workflow.
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class TrainingWorkflowOutput   extends FaModel {


  protected String modelUri;
  
  public String getTypeID() {
    return "TrainingWorkflowOutput";
  }
  

  @Override
  public java.util.UUID getFaId() {
  	return null;
  }
  
  protected TrainingWorkflowOutput() {}
  
  private TrainingWorkflowOutput(TrainingWorkflowOutputBuilder builder) {
    
    modelUri = immutable(builder.modelUri);
    
    
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
        TrainingWorkflowOutput ent = (TrainingWorkflowOutput)o;
        return Objects.equals(modelUri, ent.modelUri);
    }


  /**
   * URI pointing to the created model file.
   * @return modelUri 
   */
  public String getModelUri() {
        return modelUri;
    }
    
  
 	/**
  	 * @return a newly created builder
  	 */
  	public static TrainingWorkflowOutputBuilder builder() {
  		return new TrainingWorkflowOutputBuilder();
  	}
  	
  	/**
	 * Copy-builder, i.e. creates a new builder with all properties of the passed
	 * entity pre-set.
	 * 
	 * @param entity
	 *            entity to copy the properties from
	 * @return a new builder with the properties set
	 */
	public static TrainingWorkflowOutputBuilder builder(TrainingWorkflowOutput entity) {
		TrainingWorkflowOutputBuilder builder = builder();
        builder.modelUri = entity.modelUri;
 		return builder;
  	}
  	
  
    public static class TrainingWorkflowOutputBuilder {
    
        protected TrainingWorkflowOutputBuilder(){
            
        }
    
        private String modelUri;

        /**
         * URI pointing to the created model file.
         * @return modelUri 
         */
        public TrainingWorkflowOutputBuilder setModelUri(String modelUri) {
             this.modelUri = modelUri;
             return this;
        }

        
        public TrainingWorkflowOutput build() {
            return new TrainingWorkflowOutput(this);
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
