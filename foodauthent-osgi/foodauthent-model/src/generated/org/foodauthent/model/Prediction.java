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




/**
 * Prediction
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class Prediction   extends FaModel {


  private java.util.UUID faId;
  private Float confidence;
  private java.util.UUID workflowId;
  private java.util.UUID fingerprintId;
  
  public String getTypeID() {
    return "Prediction";
  }
  

  
  private Prediction(PredictionBuilder builder) {
    
    faId = immutable(builder.faId);
    confidence = immutable(builder.confidence);
    workflowId = immutable(builder.workflowId);
    fingerprintId = immutable(builder.fingerprintId);
    
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
        return Objects.equals(faId, ent.faId) && Objects.equals(confidence, ent.confidence) && Objects.equals(workflowId, ent.workflowId) && Objects.equals(fingerprintId, ent.fingerprintId);
    }


  public java.util.UUID getFaId() {
        return faId;
    }
    
  public Float getConfidence() {
        return confidence;
    }
    
  public java.util.UUID getWorkflowId() {
        return workflowId;
    }
    
  public java.util.UUID getFingerprintId() {
        return fingerprintId;
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
        builder.confidence = entity.confidence;
        builder.workflowId = entity.workflowId;
        builder.fingerprintId = entity.fingerprintId;
 		return builder;
  	}
  	
  
    public static class PredictionBuilder {
    
        private PredictionBuilder(){
            
        }
    
        private java.util.UUID faId = null;
        private Float confidence = null;
        private java.util.UUID workflowId = null;
        private java.util.UUID fingerprintId = null;

        public PredictionBuilder setFaId(java.util.UUID faId) {
             this.faId = faId;
             return this;
        }

        public PredictionBuilder setConfidence(Float confidence) {
             this.confidence = confidence;
             return this;
        }

        public PredictionBuilder setWorkflowId(java.util.UUID workflowId) {
             this.workflowId = workflowId;
             return this;
        }

        public PredictionBuilder setFingerprintId(java.util.UUID fingerprintId) {
             this.fingerprintId = fingerprintId;
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
