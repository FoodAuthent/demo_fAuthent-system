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
 * Represents model training job.
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class TrainingJob   extends FaModel {

  /**
   * Gets or Sets status
   */
  public static enum StatusEnum {
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


  protected java.util.UUID faId;
  protected java.util.UUID modelId;
  protected StatusEnum status;
  protected String statusMessage;
  
  public String getTypeID() {
    return "TrainingJob";
  }
  

  
  protected TrainingJob() {}
  
  private TrainingJob(TrainingJobBuilder builder) {
    
    faId = immutable(builder.faId);
    modelId = immutable(builder.modelId);
    status = immutable(builder.status);
    statusMessage = immutable(builder.statusMessage);
    
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
        return Objects.equals(faId, ent.faId) && Objects.equals(modelId, ent.modelId) && Objects.equals(status, ent.status) && Objects.equals(statusMessage, ent.statusMessage);
    }


  /**
   * A global id within the FoodAuthent-system.
   * @return faId 
   */
  public java.util.UUID getFaId() {
        return faId;
    }
    
  /**
   * The created model after successful training.
   * @return modelId 
   */
  public java.util.UUID getModelId() {
        return modelId;
    }
    
  /**
   * Get status
   * @return status 
   */
  public StatusEnum getStatus() {
        return status;
    }
    
  /**
   * A message, e.g., in case the workflow failed.
   * @return statusMessage 
   */
  public String getStatusMessage() {
        return statusMessage;
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
        builder.modelId = entity.modelId;
        builder.status = entity.status;
        builder.statusMessage = entity.statusMessage;
 		return builder;
  	}
  	
  
    public static class TrainingJobBuilder {
    
        protected TrainingJobBuilder(){
            
        }
    
        private java.util.UUID faId;
        private java.util.UUID modelId;
        private StatusEnum status;
        private String statusMessage;

        /**
         * A global id within the FoodAuthent-system.
         * @return faId 
         */
        public TrainingJobBuilder setFaId(java.util.UUID faId) {
             this.faId = faId;
             return this;
        }

        /**
         * The created model after successful training.
         * @return modelId 
         */
        public TrainingJobBuilder setModelId(java.util.UUID modelId) {
             this.modelId = modelId;
             return this;
        }

        /**
         * Get status
         * @return status 
         */
        public TrainingJobBuilder setStatus(StatusEnum status) {
             this.status = status;
             return this;
        }

        /**
         * A message, e.g., in case the workflow failed.
         * @return statusMessage 
         */
        public TrainingJobBuilder setStatusMessage(String statusMessage) {
             this.statusMessage = statusMessage;
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
