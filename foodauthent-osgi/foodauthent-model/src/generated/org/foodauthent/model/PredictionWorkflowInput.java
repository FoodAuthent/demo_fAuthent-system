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


import org.foodauthent.model.WorkflowParameter;


/**
 * Describes the input required by a prediction workflow.
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class PredictionWorkflowInput   extends FaModel {


  private java.util.List<WorkflowParameter> parameters;
  private String fingerprintSetURI;
  private String modelURI;
  
  public String getTypeID() {
    return "PredictionWorkflowInput";
  }
  

  @Override
  public UUID getFaId() {
	throw new UnsupportedOperationException("The entity 'PredictionWorkflowInput' doesn't provide a fa-id.");
  }
  
  private PredictionWorkflowInput(PredictionWorkflowInputBuilder builder) {
    
    parameters = immutable(builder.parameters);
    fingerprintSetURI = immutable(builder.fingerprintSetURI);
    modelURI = immutable(builder.modelURI);
    
    
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
        PredictionWorkflowInput ent = (PredictionWorkflowInput)o;
        return Objects.equals(parameters, ent.parameters) && Objects.equals(fingerprintSetURI, ent.fingerprintSetURI) && Objects.equals(modelURI, ent.modelURI);
    }


  public java.util.List<WorkflowParameter> getParameters() {
        return parameters;
    }
    
  public String getFingerprintSetURI() {
        return fingerprintSetURI;
    }
    
  public String getModelURI() {
        return modelURI;
    }
    
  
 	/**
  	 * @return a newly created builder
  	 */
  	public static PredictionWorkflowInputBuilder builder() {
  		return new PredictionWorkflowInputBuilder();
  	}
  	
  	/**
	 * Copy-builder, i.e. creates a new builder with all properties of the passed
	 * entity pre-set.
	 * 
	 * @param entity
	 *            entity to copy the properties from
	 * @return a new builder with the properties set
	 */
	public static PredictionWorkflowInputBuilder builder(PredictionWorkflowInput entity) {
		PredictionWorkflowInputBuilder builder = builder();
        builder.parameters = entity.parameters;
        builder.fingerprintSetURI = entity.fingerprintSetURI;
        builder.modelURI = entity.modelURI;
 		return builder;
  	}
  	
  
    public static class PredictionWorkflowInputBuilder {
    
        private PredictionWorkflowInputBuilder(){
            
        }
    
        private java.util.List<WorkflowParameter> parameters = new java.util.ArrayList<>();
        private String fingerprintSetURI = null;
        private String modelURI = null;

        public PredictionWorkflowInputBuilder setParameters(java.util.List<WorkflowParameter> parameters) {
             this.parameters = parameters;
             return this;
        }

        public PredictionWorkflowInputBuilder setFingerprintSetURI(String fingerprintSetURI) {
             this.fingerprintSetURI = fingerprintSetURI;
             return this;
        }

        public PredictionWorkflowInputBuilder setModelURI(String modelURI) {
             this.modelURI = modelURI;
             return this;
        }

        
        public PredictionWorkflowInput build() {
            return new PredictionWorkflowInput(this);
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
