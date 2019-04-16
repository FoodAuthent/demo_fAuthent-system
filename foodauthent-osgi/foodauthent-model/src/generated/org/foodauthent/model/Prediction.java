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

import org.foodauthent.model.PredictionInstance;



/**
 * Prediction
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class Prediction   extends FaModel {


  protected java.util.UUID faId;
  protected java.util.Map<String, PredictionInstance> predictionMap;
  protected java.util.UUID workflowId;
  protected java.util.UUID fingerprintsetId;
  protected java.util.UUID modelId;
  protected java.util.List<String> classLabels;
  
  public String getTypeID() {
    return "Prediction";
  }
  

  
  protected Prediction() {}
  
  private Prediction(PredictionBuilder builder) {
    
    faId = immutable(builder.faId);
    predictionMap = immutable(builder.predictionMap);
    workflowId = immutable(builder.workflowId);
    fingerprintsetId = immutable(builder.fingerprintsetId);
    modelId = immutable(builder.modelId);
    classLabels = immutable(builder.classLabels);
    
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
        return Objects.equals(faId, ent.faId) && Objects.equals(predictionMap, ent.predictionMap) && Objects.equals(workflowId, ent.workflowId) && Objects.equals(fingerprintsetId, ent.fingerprintsetId) && Objects.equals(modelId, ent.modelId) && Objects.equals(classLabels, ent.classLabels);
    }


  /**
   * A global id within the FoodAuthent-system.
   * @return faId 
   */
  public java.util.UUID getFaId() {
        return faId;
    }
    
  /**
   * The predictions for each individual fingerprint. The map key is the fingerprint-id.
   * @return predictionMap 
   */
  public java.util.Map<String, PredictionInstance> getPredictionMap() {
        return predictionMap;
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
   * @return fingerprintsetId 
   */
  public java.util.UUID getFingerprintsetId() {
        return fingerprintsetId;
    }
    
  /**
   * The model that has been used for the prediction.
   * @return modelId 
   */
  public java.util.UUID getModelId() {
        return modelId;
    }
    
  /**
   * available class labels
   * @return classLabels 
   */
  public java.util.List<String> getClassLabels() {
        return classLabels;
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
        builder.predictionMap = entity.predictionMap;
        builder.workflowId = entity.workflowId;
        builder.fingerprintsetId = entity.fingerprintsetId;
        builder.modelId = entity.modelId;
        builder.classLabels = entity.classLabels;
 		return builder;
  	}
  	
  
    public static class PredictionBuilder {
    
        protected PredictionBuilder(){
            
        }
    
        private java.util.UUID faId;
        private java.util.Map<String, PredictionInstance> predictionMap = new java.util.HashMap<>();
        private java.util.UUID workflowId;
        private java.util.UUID fingerprintsetId;
        private java.util.UUID modelId;
        private java.util.List<String> classLabels = new java.util.ArrayList<>();

        /**
         * A global id within the FoodAuthent-system.
         * @return faId 
         */
        public PredictionBuilder setFaId(java.util.UUID faId) {
             this.faId = faId;
             return this;
        }

        /**
         * The predictions for each individual fingerprint. The map key is the fingerprint-id.
         * @return predictionMap 
         */
        public PredictionBuilder setPredictionMap(java.util.Map<String, PredictionInstance> predictionMap) {
             this.predictionMap = predictionMap;
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
         * @return fingerprintsetId 
         */
        public PredictionBuilder setFingerprintsetId(java.util.UUID fingerprintsetId) {
             this.fingerprintsetId = fingerprintsetId;
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

        /**
         * available class labels
         * @return classLabels 
         */
        public PredictionBuilder setClassLabels(java.util.List<String> classLabels) {
             this.classLabels = classLabels;
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
