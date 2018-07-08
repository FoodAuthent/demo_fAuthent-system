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
 * Represents model training job.
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class TrainingJob  extends FaModel {

  /**
   * Gets or Sets status
   */
  public enum StatusEnum {
    RUNNING("running"),
    
    SUCCESS("success"),
    
    FAILED("failed");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

  }


  private java.util.UUID faId;
  private java.util.UUID worklfowId;
  private java.util.UUID fingerprintsetId;
  private java.util.UUID predictionWorkflowId;
  private StatusEnum status;
  
  public String getTypeID() {
    return "TrainingJob";
  }
  

  
  private TrainingJob(TrainingJobBuilder builder) {
    
    faId = immutable(builder.faId);
    worklfowId = immutable(builder.worklfowId);
    fingerprintsetId = immutable(builder.fingerprintsetId);
    predictionWorkflowId = immutable(builder.predictionWorkflowId);
    status = immutable(builder.status);
    
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
        TrainingJob ent = (TrainingJob)o;
        return Objects.equals(faId, ent.faId) && Objects.equals(worklfowId, ent.worklfowId) && Objects.equals(fingerprintsetId, ent.fingerprintsetId) && Objects.equals(predictionWorkflowId, ent.predictionWorkflowId) && Objects.equals(status, ent.status);
    }


  public java.util.UUID getFaId() {
        return faId;
    }
    
  public java.util.UUID getWorklfowId() {
        return worklfowId;
    }
    
  public java.util.UUID getFingerprintsetId() {
        return fingerprintsetId;
    }
    
  public java.util.UUID getPredictionWorkflowId() {
        return predictionWorkflowId;
    }
    
  public StatusEnum getStatus() {
        return status;
    }
    
  
 	/**
  	 * @return a newly created builder
  	 */
  	public static TrainingJobBuilder builder() {
  		return new TrainingJobBuilder();
  	}
  	
  	/**
	 * Copy-builder, i.e. creates a new builder with all properties of the passed
	 * entity pre-set.
	 * 
	 * @param entity
	 *            entity to copy the properties from
	 * @return a new builder with the properties set
	 */
	public static TrainingJobBuilder builder(TrainingJob entity) {
		TrainingJobBuilder builder = builder();
        builder.faId = entity.faId;
        builder.worklfowId = entity.worklfowId;
        builder.fingerprintsetId = entity.fingerprintsetId;
        builder.predictionWorkflowId = entity.predictionWorkflowId;
        builder.status = entity.status;
 		return builder;
  	}
  	
  
    public static class TrainingJobBuilder {
    
        private TrainingJobBuilder(){
            
        }
    
        private java.util.UUID faId = null;
        private java.util.UUID worklfowId = null;
        private java.util.UUID fingerprintsetId = null;
        private java.util.UUID predictionWorkflowId = null;
        private StatusEnum status = null;

        public TrainingJobBuilder setFaId(java.util.UUID faId) {
             this.faId = faId;
             return this;
        }

        public TrainingJobBuilder setWorklfowId(java.util.UUID worklfowId) {
             this.worklfowId = worklfowId;
             return this;
        }

        public TrainingJobBuilder setFingerprintsetId(java.util.UUID fingerprintsetId) {
             this.fingerprintsetId = fingerprintsetId;
             return this;
        }

        public TrainingJobBuilder setPredictionWorkflowId(java.util.UUID predictionWorkflowId) {
             this.predictionWorkflowId = predictionWorkflowId;
             return this;
        }

        public TrainingJobBuilder setStatus(StatusEnum status) {
             this.status = status;
             return this;
        }

        
        public TrainingJob build() {
            return new TrainingJob(this);
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
