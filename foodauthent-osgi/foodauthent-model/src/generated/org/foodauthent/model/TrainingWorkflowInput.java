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


import org.foodauthent.model.FingerprintSet;
import org.foodauthent.model.WorkflowModuleInput;
import org.foodauthent.model.WorkflowParameter;


/**
 * Describes the input required by a training workflow.
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class TrainingWorkflowInput  extends FaModel {


  private java.util.List<WorkflowParameter> parameters;
  private FingerprintSet fingerprintsetMetadata;
  private String fingerprintsetURI;
  private java.util.List<WorkflowModuleInput> moduleInputs;
  
  public String getTypeID() {
    return "TrainingWorkflowInput";
  }
  

  @Override
  public UUID getFaId() {
  	return null;
  }
  
  private TrainingWorkflowInput(TrainingWorkflowInputBuilder builder) {
    
    parameters = immutable(builder.parameters);
    fingerprintsetMetadata = immutable(builder.fingerprintsetMetadata);
    fingerprintsetURI = immutable(builder.fingerprintsetURI);
    moduleInputs = immutable(builder.moduleInputs);
    
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
        return Objects.equals(parameters, ent.parameters) && Objects.equals(fingerprintsetMetadata, ent.fingerprintsetMetadata) && Objects.equals(fingerprintsetURI, ent.fingerprintsetURI) && Objects.equals(moduleInputs, ent.moduleInputs);
    }


  public java.util.List<WorkflowParameter> getParameters() {
        return parameters;
    }
    
  public FingerprintSet getFingerprintsetMetadata() {
        return fingerprintsetMetadata;
    }
    
  public String getFingerprintsetURI() {
        return fingerprintsetURI;
    }
    
  public java.util.List<WorkflowModuleInput> getModuleInputs() {
        return moduleInputs;
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
        builder.fingerprintsetMetadata = entity.fingerprintsetMetadata;
        builder.fingerprintsetURI = entity.fingerprintsetURI;
        builder.moduleInputs = entity.moduleInputs;
 		return builder;
  	}
  	
  
    public static class TrainingWorkflowInputBuilder {
    
        private TrainingWorkflowInputBuilder(){
            
        }
    
        private java.util.List<WorkflowParameter> parameters = new java.util.ArrayList<>();
        private FingerprintSet fingerprintsetMetadata = null;
        private String fingerprintsetURI = null;
        private java.util.List<WorkflowModuleInput> moduleInputs = new java.util.ArrayList<>();

        public TrainingWorkflowInputBuilder setParameters(java.util.List<WorkflowParameter> parameters) {
             this.parameters = parameters;
             return this;
        }

        public TrainingWorkflowInputBuilder setFingerprintsetMetadata(FingerprintSet fingerprintsetMetadata) {
             this.fingerprintsetMetadata = fingerprintsetMetadata;
             return this;
        }

        public TrainingWorkflowInputBuilder setFingerprintsetURI(String fingerprintsetURI) {
             this.fingerprintsetURI = fingerprintsetURI;
             return this;
        }

        public TrainingWorkflowInputBuilder setModuleInputs(java.util.List<WorkflowModuleInput> moduleInputs) {
             this.moduleInputs = moduleInputs;
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
