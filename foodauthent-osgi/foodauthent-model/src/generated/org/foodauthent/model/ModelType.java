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
 * type of a model
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class ModelType   extends FaModel {

  /**
   * The name of the type of the model, e.g., in order to be able to check for compatibility of the workflows using it.
   */
  public static enum NameEnum {
    KNIME_WORKFLOW("knime_workflow"),
    
    KNIME_PYTHON("knime_python"),
    
    PMML("pmml");

    private String value;

    NameEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

  }


  protected NameEnum name;
  
  public String getTypeID() {
    return "ModelType";
  }
  

  @Override
  public java.util.UUID getFaId() {
  	return null;
  }
  
  protected ModelType() {}
  
  private ModelType(ModelTypeBuilder builder) {
    
    if(builder.name == null) {
        throw new IllegalArgumentException("name must not be null.");
    }
    name = immutable(builder.name);
    
    
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
        ModelType ent = (ModelType)o;
        return Objects.equals(name, ent.name);
    }


  /**
   * The name of the type of the model, e.g., in order to be able to check for compatibility of the workflows using it.
   * @return name , never <code>null</code>
   */
  public NameEnum getName() {
        return name;
    }
    
  
 	/**
  	 * @return a newly created builder
  	 */
  	public static ModelTypeBuilder builder() {
  		return new ModelTypeBuilder();
  	}
  	
  	/**
	 * Copy-builder, i.e. creates a new builder with all properties of the passed
	 * entity pre-set.
	 * 
	 * @param entity
	 *            entity to copy the properties from
	 * @return a new builder with the properties set
	 */
	public static ModelTypeBuilder builder(ModelType entity) {
		ModelTypeBuilder builder = builder();
        builder.name = entity.name;
 		return builder;
  	}
  	
  
    public static class ModelTypeBuilder {
    
        protected ModelTypeBuilder(){
            
        }
    
        private NameEnum name;

        /**
         * The name of the type of the model, e.g., in order to be able to check for compatibility of the workflows using it.
         * @return name , never <code>null</code>
         */
        public ModelTypeBuilder setName(NameEnum name) {
             if(name == null) {
                 throw new IllegalArgumentException("name must not be null.");
             }
             this.name = name;
             return this;
        }

        
        public ModelType build() {
            return new ModelType(this);
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
