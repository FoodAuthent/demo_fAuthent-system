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
 * Describes the outputs delivered by a prediction workflow.
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class PredictionWorkflowOutput   extends FaModel {


  private java.util.Map<String, Float> confidenceMap;
  
  public String getTypeID() {
    return "PredictionWorkflowOutput";
  }
  

  @Override
  public java.util.UUID getFaId() {
  	return null;
  }
  
  private PredictionWorkflowOutput(PredictionWorkflowOutputBuilder builder) {
    
    confidenceMap = immutable(builder.confidenceMap);
    
    
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
        PredictionWorkflowOutput ent = (PredictionWorkflowOutput)o;
        return Objects.equals(confidenceMap, ent.confidenceMap);
    }


  /**
   * The confidences for each fingerprint, mapped from the fingerprint-id.
   * @return confidenceMap 
   */
  public java.util.Map<String, Float> getConfidenceMap() {
        return confidenceMap;
    }
    
  
 	/**
  	 * @return a newly created builder
  	 */
  	public static PredictionWorkflowOutputBuilder builder() {
  		return new PredictionWorkflowOutputBuilder();
  	}
  	
  	/**
	 * Copy-builder, i.e. creates a new builder with all properties of the passed
	 * entity pre-set.
	 * 
	 * @param entity
	 *            entity to copy the properties from
	 * @return a new builder with the properties set
	 */
	public static PredictionWorkflowOutputBuilder builder(PredictionWorkflowOutput entity) {
		PredictionWorkflowOutputBuilder builder = builder();
        builder.confidenceMap = entity.confidenceMap;
 		return builder;
  	}
  	
  
    public static class PredictionWorkflowOutputBuilder {
    
        private PredictionWorkflowOutputBuilder(){
            
        }
    
        private java.util.Map<String, Float> confidenceMap = new java.util.HashMap<>();

        /**
         * The confidences for each fingerprint, mapped from the fingerprint-id.
         * @return confidenceMap 
         */
        public PredictionWorkflowOutputBuilder setConfidenceMap(java.util.Map<String, Float> confidenceMap) {
             this.confidenceMap = confidenceMap;
             return this;
        }

        
        public PredictionWorkflowOutput build() {
            return new PredictionWorkflowOutput(this);
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
