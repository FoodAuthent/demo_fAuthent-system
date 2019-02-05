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
 * Represents a workflow parameter.
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class WorkflowParameter   extends FaModel {

  /**
   * the parameter type
   */
  public static enum TypeEnum {
    STRING("string"),
    
    NUMBER("number");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

  }


  protected String name;
  protected Boolean required;
  protected TypeEnum type;
  protected String value;
  
  public String getTypeID() {
    return "WorkflowParameter";
  }
  

  @Override
  public java.util.UUID getFaId() {
  	return null;
  }
  
  protected WorkflowParameter() {}
  
  private WorkflowParameter(WorkflowParameterBuilder builder) {
    
    name = immutable(builder.name);
    required = immutable(builder.required);
    type = immutable(builder.type);
    value = immutable(builder.value);
    
    
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
        WorkflowParameter ent = (WorkflowParameter)o;
        return Objects.equals(name, ent.name) && Objects.equals(required, ent.required) && Objects.equals(type, ent.type) && Objects.equals(value, ent.value);
    }


  /**
   * the parameter name
   * @return name 
   */
  public String getName() {
        return name;
    }
    
  /**
   * whether the parameter is required
   * @return required 
   */
  public Boolean isRequired() {
        return required;
    }
    
  /**
   * the parameter type
   * @return type 
   */
  public TypeEnum getType() {
        return type;
    }
    
  /**
   * the parameter value
   * @return value 
   */
  public String getValue() {
        return value;
    }
    
  
 	/**
  	 * @return a newly created builder
  	 */
  	public static WorkflowParameterBuilder builder() {
  		return new WorkflowParameterBuilder();
  	}
  	
  	/**
	 * Copy-builder, i.e. creates a new builder with all properties of the passed
	 * entity pre-set.
	 * 
	 * @param entity
	 *            entity to copy the properties from
	 * @return a new builder with the properties set
	 */
	public static WorkflowParameterBuilder builder(WorkflowParameter entity) {
		WorkflowParameterBuilder builder = builder();
        builder.name = entity.name;
        builder.required = entity.required;
        builder.type = entity.type;
        builder.value = entity.value;
 		return builder;
  	}
  	
  
    public static class WorkflowParameterBuilder {
    
        protected WorkflowParameterBuilder(){
            
        }
    
        private String name;
        private Boolean required;
        private TypeEnum type;
        private String value;

        /**
         * the parameter name
         * @return name 
         */
        public WorkflowParameterBuilder setName(String name) {
             this.name = name;
             return this;
        }

        /**
         * whether the parameter is required
         * @return required 
         */
        public WorkflowParameterBuilder setRequired(Boolean required) {
             this.required = required;
             return this;
        }

        /**
         * the parameter type
         * @return type 
         */
        public WorkflowParameterBuilder setType(TypeEnum type) {
             this.type = type;
             return this;
        }

        /**
         * the parameter value
         * @return value 
         */
        public WorkflowParameterBuilder setValue(String value) {
             this.value = value;
             return this;
        }

        
        public WorkflowParameter build() {
            return new WorkflowParameter(this);
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
