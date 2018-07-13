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
 * Represents prediction job.
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class PredictionJob  extends FaModel {

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
  private java.util.UUID fingerprintSetId;
  private java.util.List<java.util.UUID> predictionIds;
  private StatusEnum status;
  private String statusMessage;
  
  public String getTypeID() {
    return "PredictionJob";
  }
  

  
  private PredictionJob(PredictionJobBuilder builder) {
    
    faId = immutable(builder.faId);
    worklfowId = immutable(builder.worklfowId);
    fingerprintSetId = immutable(builder.fingerprintSetId);
    predictionIds = immutable(builder.predictionIds);
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
        return Objects.equals(faId, ent.faId) && Objects.equals(worklfowId, ent.worklfowId) && Objects.equals(fingerprintSetId, ent.fingerprintSetId) && Objects.equals(predictionIds, ent.predictionIds) && Objects.equals(status, ent.status) && Objects.equals(statusMessage, ent.statusMessage);
    }


  public java.util.UUID getFaId() {
        return faId;
    }
    
  public java.util.UUID getWorklfowId() {
        return worklfowId;
    }
    
  public java.util.UUID getFingerprintSetId() {
        return fingerprintSetId;
    }
    
  public java.util.List<java.util.UUID> getPredictionIds() {
        return predictionIds;
    }
    
  public StatusEnum getStatus() {
        return status;
    }
    
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
        builder.worklfowId = entity.worklfowId;
        builder.fingerprintSetId = entity.fingerprintSetId;
        builder.predictionIds = entity.predictionIds;
        builder.status = entity.status;
        builder.statusMessage = entity.statusMessage;
 		return builder;
  	}
  	
  
    public static class PredictionJobBuilder {
    
        private PredictionJobBuilder(){
            
        }
    
        private java.util.UUID faId = null;
        private java.util.UUID worklfowId = null;
        private java.util.UUID fingerprintSetId = null;
        private java.util.List<java.util.UUID> predictionIds = new java.util.ArrayList<>();
        private StatusEnum status = null;
        private String statusMessage = null;

        public PredictionJobBuilder setFaId(java.util.UUID faId) {
             this.faId = faId;
             return this;
        }

        public PredictionJobBuilder setWorklfowId(java.util.UUID worklfowId) {
             this.worklfowId = worklfowId;
             return this;
        }

        public PredictionJobBuilder setFingerprintSetId(java.util.UUID fingerprintSetId) {
             this.fingerprintSetId = fingerprintSetId;
             return this;
        }

        public PredictionJobBuilder setPredictionIds(java.util.List<java.util.UUID> predictionIds) {
             this.predictionIds = predictionIds;
             return this;
        }

        public PredictionJobBuilder setStatus(StatusEnum status) {
             this.status = status;
             return this;
        }

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
