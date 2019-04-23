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

import org.foodauthent.model.TrainingWorkflowInputFingerprint;
import org.foodauthent.model.WorkflowParameter;



/**
 * Describes the input required by a training workflow.
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class TrainingWorkflowInput   extends FaModel {


  protected java.util.List<WorkflowParameter> parameters;
<<<<<<< HEAD
  protected FingerprintSet fingerprintsetMetadata;
  protected String fingerprintsetURI;
=======
  protected java.util.List<TrainingWorkflowInputFingerprint> fingerprints;
>>>>>>> master
  
  public String getTypeID() {
    return "TrainingWorkflowInput";
  }
  

  @Override
  public java.util.UUID getFaId() {
  	return null;
  }
  
  protected TrainingWorkflowInput() {}
  
  private TrainingWorkflowInput(TrainingWorkflowInputBuilder builder) {
    
    parameters = immutable(builder.parameters);
<<<<<<< HEAD
    fingerprintsetMetadata = immutable(builder.fingerprintsetMetadata);
    fingerprintsetURI = immutable(builder.fingerprintsetURI);
=======
    fingerprints = immutable(builder.fingerprints);
>>>>>>> master
    
    
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
        TrainingWorkflowInput ent = (TrainingWorkflowInput)o;
<<<<<<< HEAD
        return Objects.equals(parameters, ent.parameters) && Objects.equals(fingerprintsetMetadata, ent.fingerprintsetMetadata) && Objects.equals(fingerprintsetURI, ent.fingerprintsetURI);
=======
        return Objects.equals(parameters, ent.parameters) && Objects.equals(fingerprints, ent.fingerprints);
>>>>>>> master
    }


  /**
   * The workflow parameters as given provided by the Workflow-entity.
   * @return parameters 
   */
  public java.util.List<WorkflowParameter> getParameters() {
        return parameters;
    }
    
  /**
<<<<<<< HEAD
   * Get fingerprintsetMetadata
   * @return fingerprintsetMetadata 
   */
  public FingerprintSet getFingerprintsetMetadata() {
        return fingerprintsetMetadata;
    }
    
  /**
   * URI pointing to the resource containg the fingerprints to learn the model from.
   * @return fingerprintsetURI 
   */
  public String getFingerprintsetURI() {
        return fingerprintsetURI;
=======
   * Get fingerprints
   * @return fingerprints 
   */
  public java.util.List<TrainingWorkflowInputFingerprint> getFingerprints() {
        return fingerprints;
>>>>>>> master
    }
    
  
 	/**
  	 * @return a newly created builder
  	 */
  	public static TrainingWorkflowInputBuilder builder() {
  		return new TrainingWorkflowInputBuilder();
  	}
  	
  	/**
	 * Copy-builder, i.e. creates a new builder with all properties of the passed
	 * entity pre-set.
	 * 
	 * @param entity
	 *            entity to copy the properties from
	 * @return a new builder with the properties set
	 */
	public static TrainingWorkflowInputBuilder builder(TrainingWorkflowInput entity) {
		TrainingWorkflowInputBuilder builder = builder();
        builder.parameters = entity.parameters;
<<<<<<< HEAD
        builder.fingerprintsetMetadata = entity.fingerprintsetMetadata;
        builder.fingerprintsetURI = entity.fingerprintsetURI;
=======
        builder.fingerprints = entity.fingerprints;
>>>>>>> master
 		return builder;
  	}
  	
  
    public static class TrainingWorkflowInputBuilder {
    
        protected TrainingWorkflowInputBuilder(){
            
        }
    
        private java.util.List<WorkflowParameter> parameters = new java.util.ArrayList<>();
<<<<<<< HEAD
        private FingerprintSet fingerprintsetMetadata;
        private String fingerprintsetURI;
=======
        private java.util.List<TrainingWorkflowInputFingerprint> fingerprints = new java.util.ArrayList<>();
>>>>>>> master

        /**
         * The workflow parameters as given provided by the Workflow-entity.
         * @return parameters 
         */
        public TrainingWorkflowInputBuilder setParameters(java.util.List<WorkflowParameter> parameters) {
             this.parameters = parameters;
             return this;
        }

        /**
<<<<<<< HEAD
         * Get fingerprintsetMetadata
         * @return fingerprintsetMetadata 
         */
        public TrainingWorkflowInputBuilder setFingerprintsetMetadata(FingerprintSet fingerprintsetMetadata) {
             this.fingerprintsetMetadata = fingerprintsetMetadata;
             return this;
        }

        /**
         * URI pointing to the resource containg the fingerprints to learn the model from.
         * @return fingerprintsetURI 
         */
        public TrainingWorkflowInputBuilder setFingerprintsetURI(String fingerprintsetURI) {
             this.fingerprintsetURI = fingerprintsetURI;
=======
         * Get fingerprints
         * @return fingerprints 
         */
        public TrainingWorkflowInputBuilder setFingerprints(java.util.List<TrainingWorkflowInputFingerprint> fingerprints) {
             this.fingerprints = fingerprints;
>>>>>>> master
             return this;
        }

        
        public TrainingWorkflowInput build() {
            return new TrainingWorkflowInput(this);
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
