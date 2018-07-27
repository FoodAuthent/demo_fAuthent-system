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
 * A workflow module used by other workflows (i.e. like a sub-workflow).
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class WorkflowModule  extends FaModel {

  /**
   * The type of the module. IMPORTANT: This property determines the required workflow input and output.
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


  private java.util.UUID fileId;
  private ModuleTypeEnum moduleType;
  private java.util.List<WorkflowParameter> moduleParameters;
  
  public String getTypeID() {
    return "WorkflowModule";
  }
  

  @Override
  public java.util.UUID getFaId() {
  	return null;
  }
  
  private WorkflowModule(WorkflowModuleBuilder builder) {
    
    fileId = immutable(builder.fileId);
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
        return Objects.equals(fileId, ent.fileId) && Objects.equals(moduleType, ent.moduleType) && Objects.equals(moduleParameters, ent.moduleParameters);
    }


  /**
   * The file-id that references the actual workflow file.
   * @return fileId 
   */
  public java.util.UUID getFileId() {
        return fileId;
    }
    
  /**
   * The type of the module. IMPORTANT: This property determines the required workflow input and output.
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
        builder.fileId = entity.fileId;
        builder.moduleType = entity.moduleType;
        builder.moduleParameters = entity.moduleParameters;
 		return builder;
  	}
  	
  
    public static class WorkflowModuleBuilder {
    
        private WorkflowModuleBuilder(){
            
        }
    
        private java.util.UUID fileId = null;
        private ModuleTypeEnum moduleType = null;
        private java.util.List<WorkflowParameter> moduleParameters = new java.util.ArrayList<>();

        /**
         * The file-id that references the actual workflow file.
         * @return fileId 
         */
        public WorkflowModuleBuilder setFileId(java.util.UUID fileId) {
             this.fileId = fileId;
             return this;
        }

        /**
         * The type of the module. IMPORTANT: This property determines the required workflow input and output.
         * @return moduleType 
         */
        public WorkflowModuleBuilder setModuleType(ModuleTypeEnum moduleType) {
             this.moduleType = moduleType;
             return this;
        }

        /**
         * The parameters required for the module.
         * @return moduleParameters 
         */
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
