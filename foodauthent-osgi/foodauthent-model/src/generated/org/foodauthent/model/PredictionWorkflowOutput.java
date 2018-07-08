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
import java.util.UUID;


import org.foodauthent.model.Prediction;


/**
 * Describes the outputs delivered by a prediction workflow.
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class PredictionWorkflowOutput  extends FaModel {


  private java.util.List<Prediction> predictionResults;
  
  public String getTypeID() {
    return "PredictionWorkflowOutput";
  }
  

  @Override
  public UUID getFaId() {
	throw new UnsupportedOperationException("The entity 'PredictionWorkflowOutput' doesn't provide a fa-id.");
  }
  
  private PredictionWorkflowOutput(PredictionWorkflowOutputBuilder builder) {
    
    predictionResults = immutable(builder.predictionResults);
    
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
        return Objects.equals(predictionResults, ent.predictionResults);
    }


  public java.util.List<Prediction> getPredictionResults() {
        return predictionResults;
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
        builder.predictionResults = entity.predictionResults;
 		return builder;
  	}
  	
  
    public static class PredictionWorkflowOutputBuilder {
    
        private PredictionWorkflowOutputBuilder(){
            
        }
    
        private java.util.List<Prediction> predictionResults = new java.util.ArrayList<>();

        public PredictionWorkflowOutputBuilder setPredictionResults(java.util.List<Prediction> predictionResults) {
             this.predictionResults = predictionResults;
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
