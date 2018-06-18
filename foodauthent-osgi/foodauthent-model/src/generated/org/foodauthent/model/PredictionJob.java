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
  private java.util.UUID fingerprintId;
  private java.util.UUID predictionId;
  private StatusEnum status;
  
  public String getTypeID() {
    return "PredictionJob";
  }
  
  private PredictionJob(PredictionJobBuilder builder) {
    
    faId = immutable(builder.faId);
    worklfowId = immutable(builder.worklfowId);
    fingerprintId = immutable(builder.fingerprintId);
    predictionId = immutable(builder.predictionId);
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
        PredictionJob ent = (PredictionJob)o;
        return Objects.equals(faId, ent.faId) && Objects.equals(worklfowId, ent.worklfowId) && Objects.equals(fingerprintId, ent.fingerprintId) && Objects.equals(predictionId, ent.predictionId) && Objects.equals(status, ent.status);
    }


  public java.util.UUID getFaId() {
        return faId;
    }
    
  public java.util.UUID getWorklfowId() {
        return worklfowId;
    }
    
  public java.util.UUID getFingerprintId() {
        return fingerprintId;
    }
    
  public java.util.UUID getPredictionId() {
        return predictionId;
    }
    
  public StatusEnum getStatus() {
        return status;
    }
    
  
 	/**
  	 * @return a newly created builder
  	 */
  	public static PredictionJobBuilder builder() {
  		return new PredictionJobBuilder();
  	}
  
    public static class PredictionJobBuilder {
    
        private PredictionJobBuilder(){
            
        }
    
        private java.util.UUID faId = null;
        private java.util.UUID worklfowId = null;
        private java.util.UUID fingerprintId = null;
        private java.util.UUID predictionId = null;
        private StatusEnum status = null;

        public PredictionJobBuilder setFaId(java.util.UUID faId) {
             this.faId = faId;
             return this;
        }

        public PredictionJobBuilder setWorklfowId(java.util.UUID worklfowId) {
             this.worklfowId = worklfowId;
             return this;
        }

        public PredictionJobBuilder setFingerprintId(java.util.UUID fingerprintId) {
             this.fingerprintId = fingerprintId;
             return this;
        }

        public PredictionJobBuilder setPredictionId(java.util.UUID predictionId) {
             this.predictionId = predictionId;
             return this;
        }

        public PredictionJobBuilder setStatus(StatusEnum status) {
             this.status = status;
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
