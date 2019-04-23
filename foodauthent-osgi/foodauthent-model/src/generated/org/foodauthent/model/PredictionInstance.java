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
 * One particular prediction for a fingerprint.
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class PredictionInstance   extends FaModel {


  protected String classLabel;
  protected java.util.List<Float> probabilities;
  
  public String getTypeID() {
    return "PredictionInstance";
  }
  

  @Override
  public java.util.UUID getFaId() {
  	return null;
  }
  
  protected PredictionInstance() {}
  
  private PredictionInstance(PredictionInstanceBuilder builder) {
    
    classLabel = immutable(builder.classLabel);
    probabilities = immutable(builder.probabilities);
    
    
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
        PredictionInstance ent = (PredictionInstance)o;
        return Objects.equals(classLabel, ent.classLabel) && Objects.equals(probabilities, ent.probabilities);
    }


  /**
   * the predicted class
   * @return classLabel 
   */
  public String getClassLabel() {
        return classLabel;
    }
    
  /**
   * the probability distribution over all classes
   * @return probabilities 
   */
  public java.util.List<Float> getProbabilities() {
        return probabilities;
    }
    
  
 	/**
  	 * @return a newly created builder
  	 */
  	public static PredictionInstanceBuilder builder() {
  		return new PredictionInstanceBuilder();
  	}
  	
  	/**
	 * Copy-builder, i.e. creates a new builder with all properties of the passed
	 * entity pre-set.
	 * 
	 * @param entity
	 *            entity to copy the properties from
	 * @return a new builder with the properties set
	 */
	public static PredictionInstanceBuilder builder(PredictionInstance entity) {
		PredictionInstanceBuilder builder = builder();
        builder.classLabel = entity.classLabel;
        builder.probabilities = entity.probabilities;
 		return builder;
  	}
  	
  
    public static class PredictionInstanceBuilder {
    
        protected PredictionInstanceBuilder(){
            
        }
    
        private String classLabel;
        private java.util.List<Float> probabilities = new java.util.ArrayList<>();

        /**
         * the predicted class
         * @return classLabel 
         */
        public PredictionInstanceBuilder setClassLabel(String classLabel) {
             this.classLabel = classLabel;
             return this;
        }

        /**
         * the probability distribution over all classes
         * @return probabilities 
         */
        public PredictionInstanceBuilder setProbabilities(java.util.List<Float> probabilities) {
             this.probabilities = probabilities;
             return this;
        }

        
        public PredictionInstance build() {
            return new PredictionInstance(this);
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
