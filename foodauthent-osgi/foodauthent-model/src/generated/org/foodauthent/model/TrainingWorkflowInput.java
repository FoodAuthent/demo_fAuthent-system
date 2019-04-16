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
  protected java.util.List<TrainingWorkflowInputFingerprint> fingerprints;
  
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
    fingerprints = immutable(builder.fingerprints);
    
    
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
        return Objects.equals(parameters, ent.parameters) && Objects.equals(fingerprints, ent.fingerprints);
    }


  /**
   * The workflow parameters as provided by the Workflow-entity.
   * @return parameters 
   */
  public java.util.List<WorkflowParameter> getParameters() {
        return parameters;
    }
    
  /**
   * Get fingerprints
   * @return fingerprints 
   */
  public java.util.List<TrainingWorkflowInputFingerprint> getFingerprints() {
        return fingerprints;
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
        builder.fingerprints = entity.fingerprints;
 		return builder;
  	}
  	
  
    public static class TrainingWorkflowInputBuilder {
    
        protected TrainingWorkflowInputBuilder(){
            
        }
    
        private java.util.List<WorkflowParameter> parameters = new java.util.ArrayList<>();
        private java.util.List<TrainingWorkflowInputFingerprint> fingerprints = new java.util.ArrayList<>();

        /**
         * The workflow parameters as provided by the Workflow-entity.
         * @return parameters 
         */
        public TrainingWorkflowInputBuilder setParameters(java.util.List<WorkflowParameter> parameters) {
             this.parameters = parameters;
             return this;
        }

        /**
         * Get fingerprints
         * @return fingerprints 
         */
        public TrainingWorkflowInputBuilder setFingerprints(java.util.List<TrainingWorkflowInputFingerprint> fingerprints) {
             this.fingerprints = fingerprints;
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
