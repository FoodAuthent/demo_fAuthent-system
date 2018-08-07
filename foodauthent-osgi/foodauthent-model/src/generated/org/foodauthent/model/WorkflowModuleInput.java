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

import org.foodauthent.model.WorkflowParameter;


/**
 * Input for a workflow module.
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class WorkflowModuleInput   extends FaModel {

  /**
   * The type of the module.
   */
  public enum ModuleTypeEnum {
    READ("read"),
    
    TRANSFORM_SIGNAL("transform_signal"),
    
    BINNING("binning"),
    
    TRANSFORM_SAMPLE("transform_sample"),
    
    PREDICT("predict"),
    
    TRAIN("train");

    private String value;

    ModuleTypeEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

  }


  private String workflowURI;
  private ModuleTypeEnum moduleType;
  private java.util.List<WorkflowParameter> moduleParameters;
  
  public String getTypeID() {
    return "WorkflowModuleInput";
  }
  

  @Override
  public java.util.UUID getFaId() {
  	return null;
  }
  
  private WorkflowModuleInput(WorkflowModuleInputBuilder builder) {
    
    workflowURI = immutable(builder.workflowURI);
    moduleType = immutable(builder.moduleType);
    moduleParameters = immutable(builder.moduleParameters);
    
    
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
        WorkflowModuleInput ent = (WorkflowModuleInput)o;
        return Objects.equals(workflowURI, ent.workflowURI) && Objects.equals(moduleType, ent.moduleType) && Objects.equals(moduleParameters, ent.moduleParameters);
    }


  /**
   * URI of the workflow to use.
   * @return workflowURI 
   */
  public String getWorkflowURI() {
        return workflowURI;
    }
    
  /**
   * The type of the module.
   * @return moduleType 
   */
  public ModuleTypeEnum getModuleType() {
        return moduleType;
    }
    
  /**
   * The parameters required for the module.
   * @return moduleParameters 
   */
  public java.util.List<WorkflowParameter> getModuleParameters() {
        return moduleParameters;
    }
    
  
 	/**
  	 * @return a newly created builder
  	 */
  	public static WorkflowModuleInputBuilder builder() {
  		return new WorkflowModuleInputBuilder();
  	}
  	
  	/**
	 * Copy-builder, i.e. creates a new builder with all properties of the passed
	 * entity pre-set.
	 * 
	 * @param entity
	 *            entity to copy the properties from
	 * @return a new builder with the properties set
	 */
	public static WorkflowModuleInputBuilder builder(WorkflowModuleInput entity) {
		WorkflowModuleInputBuilder builder = builder();
        builder.workflowURI = entity.workflowURI;
        builder.moduleType = entity.moduleType;
        builder.moduleParameters = entity.moduleParameters;
 		return builder;
  	}
  	
  
    public static class WorkflowModuleInputBuilder {
    
        private WorkflowModuleInputBuilder(){
            
        }
    
        private String workflowURI = null;
        private ModuleTypeEnum moduleType = null;
        private java.util.List<WorkflowParameter> moduleParameters = new java.util.ArrayList<>();

        /**
         * URI of the workflow to use.
         * @return workflowURI 
         */
        public WorkflowModuleInputBuilder setWorkflowURI(String workflowURI) {
             this.workflowURI = workflowURI;
             return this;
        }

        /**
         * The type of the module.
         * @return moduleType 
         */
        public WorkflowModuleInputBuilder setModuleType(ModuleTypeEnum moduleType) {
             this.moduleType = moduleType;
             return this;
        }

        /**
         * The parameters required for the module.
         * @return moduleParameters 
         */
        public WorkflowModuleInputBuilder setModuleParameters(java.util.List<WorkflowParameter> moduleParameters) {
             this.moduleParameters = moduleParameters;
             return this;
        }

        
        public WorkflowModuleInput build() {
            return new WorkflowModuleInput(this);
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
