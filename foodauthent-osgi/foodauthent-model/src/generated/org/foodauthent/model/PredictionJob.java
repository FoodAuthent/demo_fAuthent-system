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
 * Represents prediction job.
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class PredictionJob   extends FaModel {

  /**
   * The current status of the prediction job.
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
  protected java.util.UUID predictionId;
  protected StatusEnum status;
  protected String statusMessage;
  
  public String getTypeID() {
    return "PredictionJob";
  }
  

  
  protected PredictionJob() {}
  
  private PredictionJob(PredictionJobBuilder builder) {
    
    faId = immutable(builder.faId);
    predictionId = immutable(builder.predictionId);
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
        PredictionJob ent = (PredictionJob)o;
        return Objects.equals(faId, ent.faId) && Objects.equals(predictionId, ent.predictionId) && Objects.equals(status, ent.status) && Objects.equals(statusMessage, ent.statusMessage);
    }


  /**
   * A global id within the FoodAuthent-system.
   * @return faId 
   */
  public java.util.UUID getFaId() {
        return faId;
    }
    
  /**
   * The id of the prediction result if the job has completed successfully.
   * @return predictionId 
   */
  public java.util.UUID getPredictionId() {
        return predictionId;
    }
    
  /**
   * The current status of the prediction job.
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
  	public static PredictionJobBuilder builder() {
  		return new PredictionJobBuilder();
  	}
  	
  	/**
	 * Copy-builder, i.e. creates a new builder with all properties of the passed
	 * entity pre-set.
	 * 
	 * @param entity
	 *            entity to copy the properties from
	 * @return a new builder with the properties set
	 */
	public static PredictionJobBuilder builder(PredictionJob entity) {
		PredictionJobBuilder builder = builder();
        builder.faId = entity.faId;
        builder.predictionId = entity.predictionId;
        builder.status = entity.status;
        builder.statusMessage = entity.statusMessage;
 		return builder;
  	}
  	
  
    public static class PredictionJobBuilder {
    
        protected PredictionJobBuilder(){
            
        }
    
        private java.util.UUID faId;
        private java.util.UUID predictionId;
        private StatusEnum status;
        private String statusMessage;

        /**
         * A global id within the FoodAuthent-system.
         * @return faId 
         */
        public PredictionJobBuilder setFaId(java.util.UUID faId) {
             this.faId = faId;
             return this;
        }

        /**
         * The id of the prediction result if the job has completed successfully.
         * @return predictionId 
         */
        public PredictionJobBuilder setPredictionId(java.util.UUID predictionId) {
             this.predictionId = predictionId;
             return this;
        }

        /**
         * The current status of the prediction job.
         * @return status 
         */
        public PredictionJobBuilder setStatus(StatusEnum status) {
             this.status = status;
             return this;
        }

        /**
         * A message, e.g., in case the workflow failed.
         * @return statusMessage 
         */
        public PredictionJobBuilder setStatusMessage(String statusMessage) {
             this.statusMessage = statusMessage;
             return this;
        }

        
        public PredictionJob build() {
            return new PredictionJob(this);
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
