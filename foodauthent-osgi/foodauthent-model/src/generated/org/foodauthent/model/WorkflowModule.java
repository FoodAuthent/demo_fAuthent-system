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
 * A workflow module used by other workflows (i.e. like a sub-workflow).
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class WorkflowModule  extends FaModel {


  private java.util.UUID moduleId;
  private String moduleType;
  private java.util.List<WorkflowParameter> moduleParameters;
  
  public String getTypeID() {
    return "WorkflowModule";
  }
  

  @Override
  public UUID getFaId() {
	throw new UnsupportedOperationException("The entity 'WorkflowModule' doesn't provide a fa-id.");
  }
  
  private WorkflowModule(WorkflowModuleBuilder builder) {
    
    moduleId = immutable(builder.moduleId);
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
        WorkflowModule ent = (WorkflowModule)o;
        return Objects.equals(moduleId, ent.moduleId) && Objects.equals(moduleType, ent.moduleType) && Objects.equals(moduleParameters, ent.moduleParameters);
    }


  public java.util.UUID getModuleId() {
        return moduleId;
    }
    
  public String getModuleType() {
        return moduleType;
    }
    
  public java.util.List<WorkflowParameter> getModuleParameters() {
        return moduleParameters;
    }
    
  
 	/**
  	 * @return a newly created builder
  	 */
  	public static WorkflowModuleBuilder builder() {
  		return new WorkflowModuleBuilder();
  	}
  	
  	/**
	 * Copy-builder, i.e. creates a new builder with all properties of the passed
	 * entity pre-set.
	 * 
	 * @param entity
	 *            entity to copy the properties from
	 * @return a new builder with the properties set
	 */
	public static WorkflowModuleBuilder builder(WorkflowModule entity) {
		WorkflowModuleBuilder builder = builder();
        builder.moduleId = entity.moduleId;
        builder.moduleType = entity.moduleType;
        builder.moduleParameters = entity.moduleParameters;
 		return builder;
  	}
  	
  
    public static class WorkflowModuleBuilder {
    
        private WorkflowModuleBuilder(){
            
        }
    
        private java.util.UUID moduleId = null;
        private String moduleType = null;
        private java.util.List<WorkflowParameter> moduleParameters = new java.util.ArrayList<>();

        public WorkflowModuleBuilder setModuleId(java.util.UUID moduleId) {
             this.moduleId = moduleId;
             return this;
        }

        public WorkflowModuleBuilder setModuleType(String moduleType) {
             this.moduleType = moduleType;
             return this;
        }

        public WorkflowModuleBuilder setModuleParameters(java.util.List<WorkflowParameter> moduleParameters) {
             this.moduleParameters = moduleParameters;
             return this;
        }

        
        public WorkflowModule build() {
            return new WorkflowModule(this);
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
