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
 * WorkflowOutput
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class WorkflowOutput  extends FaModel {

  /**
   * The outputs type.
   */
  public enum TypeEnum {
    STRING("string"),
    
    INTEGER("integer"),
    
    MODEL("model"),
    
    PREDICTION("prediction");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

  }


  private java.util.UUID faId;
  private Boolean required;
  private TypeEnum type;
  
  public String getTypeID() {
    return "WorkflowOutput";
  }
  
  private WorkflowOutput(WorkflowOutputBuilder builder) {
    
    faId = immutable(builder.faId);
    required = immutable(builder.required);
    type = immutable(builder.type);
    
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
        WorkflowOutput ent = (WorkflowOutput)o;
        return Objects.equals(faId, ent.faId) && Objects.equals(required, ent.required) && Objects.equals(type, ent.type);
    }


  public java.util.UUID getFaId() {
        return faId;
    }
    
  public Boolean isRequired() {
        return required;
    }
    
  public TypeEnum getType() {
        return type;
    }
    
  
 	/**
  	 * @return a newly created builder
  	 */
  	public static WorkflowOutputBuilder builder() {
  		return new WorkflowOutputBuilder();
  	}
  
    public static class WorkflowOutputBuilder {
    
        private WorkflowOutputBuilder(){
            
        }
    
        private java.util.UUID faId = null;
        private Boolean required = null;
        private TypeEnum type = null;

        public WorkflowOutputBuilder setFaId(java.util.UUID faId) {
             this.faId = faId;
             return this;
        }

        public WorkflowOutputBuilder setRequired(Boolean required) {
             this.required = required;
             return this;
        }

        public WorkflowOutputBuilder setType(TypeEnum type) {
             this.type = type;
             return this;
        }

        
        public WorkflowOutput build() {
            return new WorkflowOutput(this);
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
