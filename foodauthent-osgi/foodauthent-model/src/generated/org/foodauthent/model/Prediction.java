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
 * Prediction
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class Prediction   extends FaModel {


  private java.util.UUID faId;
  private java.util.Map<String, Float> confidenceMap;
  private java.util.UUID workflowId;
  private java.util.UUID fingerprintSetId;
  private java.util.UUID modelId;
  
  public String getTypeID() {
    return "Prediction";
  }
  

  
  private Prediction(PredictionBuilder builder) {
    
    faId = immutable(builder.faId);
    confidenceMap = immutable(builder.confidenceMap);
    workflowId = immutable(builder.workflowId);
    fingerprintSetId = immutable(builder.fingerprintSetId);
    modelId = immutable(builder.modelId);
    
    faId = generateFaIdIfMissing(faId);
    
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
        Prediction ent = (Prediction)o;
        return Objects.equals(faId, ent.faId) && Objects.equals(confidenceMap, ent.confidenceMap) && Objects.equals(workflowId, ent.workflowId) && Objects.equals(fingerprintSetId, ent.fingerprintSetId) && Objects.equals(modelId, ent.modelId);
    }


  /**
   * A global id within the FoodAuthent-system.
   * @return faId 
   */
  public java.util.UUID getFaId() {
        return faId;
    }
    
  /**
   * The confidences for each fingerprint, mapped from the fingerprint-id.
   * @return confidenceMap 
   */
  public java.util.Map<String, Float> getConfidenceMap() {
        return confidenceMap;
    }
    
  /**
   * Workflow used for the prediction.
   * @return workflowId 
   */
  public java.util.UUID getWorkflowId() {
        return workflowId;
    }
    
  /**
   * Id of the set the prediction has been done for.
   * @return fingerprintSetId 
   */
  public java.util.UUID getFingerprintSetId() {
        return fingerprintSetId;
    }
    
  /**
   * The model that has been used for the prediction.
   * @return modelId 
   */
  public java.util.UUID getModelId() {
        return modelId;
    }
    
  
 	/**
  	 * @return a newly created builder
  	 */
  	public static PredictionBuilder builder() {
  		return new PredictionBuilder();
  	}
  	
  	/**
	 * Copy-builder, i.e. creates a new builder with all properties of the passed
	 * entity pre-set.
	 * 
	 * @param entity
	 *            entity to copy the properties from
	 * @return a new builder with the properties set
	 */
	public static PredictionBuilder builder(Prediction entity) {
		PredictionBuilder builder = builder();
        builder.faId = entity.faId;
        builder.confidenceMap = entity.confidenceMap;
        builder.workflowId = entity.workflowId;
        builder.fingerprintSetId = entity.fingerprintSetId;
        builder.modelId = entity.modelId;
 		return builder;
  	}
  	
  
    public static class PredictionBuilder {
    
        private PredictionBuilder(){
            
        }
    
        private java.util.UUID faId = null;
        private java.util.Map<String, Float> confidenceMap = new java.util.HashMap<>();
        private java.util.UUID workflowId = null;
        private java.util.UUID fingerprintSetId = null;
        private java.util.UUID modelId = null;

        /**
         * A global id within the FoodAuthent-system.
         * @return faId 
         */
        public PredictionBuilder setFaId(java.util.UUID faId) {
             this.faId = faId;
             return this;
        }

        /**
         * The confidences for each fingerprint, mapped from the fingerprint-id.
         * @return confidenceMap 
         */
        public PredictionBuilder setConfidenceMap(java.util.Map<String, Float> confidenceMap) {
             this.confidenceMap = confidenceMap;
             return this;
        }

        /**
         * Workflow used for the prediction.
         * @return workflowId 
         */
        public PredictionBuilder setWorkflowId(java.util.UUID workflowId) {
             this.workflowId = workflowId;
             return this;
        }

        /**
         * Id of the set the prediction has been done for.
         * @return fingerprintSetId 
         */
        public PredictionBuilder setFingerprintSetId(java.util.UUID fingerprintSetId) {
             this.fingerprintSetId = fingerprintSetId;
             return this;
        }

        /**
         * The model that has been used for the prediction.
         * @return modelId 
         */
        public PredictionBuilder setModelId(java.util.UUID modelId) {
             this.modelId = modelId;
             return this;
        }

        
        public Prediction build() {
            return new Prediction(this);
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
