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
 * TrainingWorkflowInputFingerprint
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class TrainingWorkflowInputFingerprint   extends FaModel {


  protected String URI;
  protected String classLabel;
  protected java.util.UUID fingerprintId;
  
  public String getTypeID() {
    return "TrainingWorkflowInputFingerprint";
  }
  

  @Override
  public java.util.UUID getFaId() {
  	return null;
  }
  
  protected TrainingWorkflowInputFingerprint() {}
  
  private TrainingWorkflowInputFingerprint(TrainingWorkflowInputFingerprintBuilder builder) {
    
    URI = immutable(builder.URI);
    classLabel = immutable(builder.classLabel);
    fingerprintId = immutable(builder.fingerprintId);
    
    
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
        TrainingWorkflowInputFingerprint ent = (TrainingWorkflowInputFingerprint)o;
        return Objects.equals(URI, ent.URI) && Objects.equals(classLabel, ent.classLabel) && Objects.equals(fingerprintId, ent.fingerprintId);
    }


  /**
   * Get URI
   * @return URI 
   */
  public String getURI() {
        return URI;
    }
    
  /**
   * Get classLabel
   * @return classLabel 
   */
  public String getClassLabel() {
        return classLabel;
    }
    
  /**
   * Get fingerprintId
   * @return fingerprintId 
   */
  public java.util.UUID getFingerprintId() {
        return fingerprintId;
    }
    
  
 	/**
  	 * @return a newly created builder
  	 */
  	public static TrainingWorkflowInputFingerprintBuilder builder() {
  		return new TrainingWorkflowInputFingerprintBuilder();
  	}
  	
  	/**
	 * Copy-builder, i.e. creates a new builder with all properties of the passed
	 * entity pre-set.
	 * 
	 * @param entity
	 *            entity to copy the properties from
	 * @return a new builder with the properties set
	 */
	public static TrainingWorkflowInputFingerprintBuilder builder(TrainingWorkflowInputFingerprint entity) {
		TrainingWorkflowInputFingerprintBuilder builder = builder();
        builder.URI = entity.URI;
        builder.classLabel = entity.classLabel;
        builder.fingerprintId = entity.fingerprintId;
 		return builder;
  	}
  	
  
    public static class TrainingWorkflowInputFingerprintBuilder {
    
        protected TrainingWorkflowInputFingerprintBuilder(){
            
        }
    
        private String URI;
        private String classLabel;
        private java.util.UUID fingerprintId;

        /**
         * Get URI
         * @return URI 
         */
        public TrainingWorkflowInputFingerprintBuilder setURI(String URI) {
             this.URI = URI;
             return this;
        }

        /**
         * Get classLabel
         * @return classLabel 
         */
        public TrainingWorkflowInputFingerprintBuilder setClassLabel(String classLabel) {
             this.classLabel = classLabel;
             return this;
        }

        /**
         * Get fingerprintId
         * @return fingerprintId 
         */
        public TrainingWorkflowInputFingerprintBuilder setFingerprintId(java.util.UUID fingerprintId) {
             this.fingerprintId = fingerprintId;
             return this;
        }

        
        public TrainingWorkflowInputFingerprint build() {
            return new TrainingWorkflowInputFingerprint(this);
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
