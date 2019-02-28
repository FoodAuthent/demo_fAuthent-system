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

import org.foodauthent.model.Tag;
import org.foodauthent.model.WorkflowIOTypes;
import org.foodauthent.model.WorkflowParameter;



/**
 * A workflow for a certain task.
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class Workflow   extends FaModel {

  /**
   * The workflow representation, e.g. represented by a scripting language, cwl or a KNIME-workflow.
   */
  public static enum RepresentationEnum {
    CWL("cwl"),
    
    R("r"),
    
    PYTHON("python"),
    
    KNIME("knime");

    private String value;

    RepresentationEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

  }

  /**
   * The type of the workflow.  IMPORTANT: This property determines the required workflow input and output, e.g., PredictionWorkflowInput and PredicitonWorkflowOutput-entity.
   */
  public static enum TypeEnum {
    PREDICTION_WORKFLOW("prediction_workflow"),
    
    TRAINING_WORKFLOW("training_workflow");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

  }


  protected java.util.UUID faId;
  protected String name;
  protected String description;
  protected RepresentationEnum representation;
  protected TypeEnum type;
  protected java.util.List<WorkflowParameter> parameters;
  protected java.util.List<Tag> tags;
  protected java.util.UUID fileId;
  protected WorkflowIOTypes outputTypes;
  protected WorkflowIOTypes inputTypes;
  
  public String getTypeID() {
    return "Workflow";
  }
  

  
  protected Workflow() {}
  
  private Workflow(WorkflowBuilder builder) {
    
    faId = immutable(builder.faId);
    if(builder.name == null) {
        throw new IllegalArgumentException("name must not be null.");
    }
    name = immutable(builder.name);
    description = immutable(builder.description);
    if(builder.representation == null) {
        throw new IllegalArgumentException("representation must not be null.");
    }
    representation = immutable(builder.representation);
    if(builder.type == null) {
        throw new IllegalArgumentException("type must not be null.");
    }
    type = immutable(builder.type);
    parameters = immutable(builder.parameters);
    tags = immutable(builder.tags);
    if(builder.fileId == null) {
        throw new IllegalArgumentException("fileId must not be null.");
    }
    fileId = immutable(builder.fileId);
    outputTypes = immutable(builder.outputTypes);
    inputTypes = immutable(builder.inputTypes);
    
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
        Workflow ent = (Workflow)o;
        return Objects.equals(faId, ent.faId) && Objects.equals(name, ent.name) && Objects.equals(description, ent.description) && Objects.equals(representation, ent.representation) && Objects.equals(type, ent.type) && Objects.equals(parameters, ent.parameters) && Objects.equals(tags, ent.tags) && Objects.equals(fileId, ent.fileId) && Objects.equals(outputTypes, ent.outputTypes) && Objects.equals(inputTypes, ent.inputTypes);
    }


  /**
   * A global id within the FoodAuthent-system.
   * @return faId 
   */
  public java.util.UUID getFaId() {
        return faId;
    }
    
  /**
   * Get name
   * @return name , never <code>null</code>
   */
  public String getName() {
        return name;
    }
    
  /**
   * Get description
   * @return description 
   */
  public String getDescription() {
        return description;
    }
    
  /**
   * The workflow representation, e.g. represented by a scripting language, cwl or a KNIME-workflow.
   * @return representation , never <code>null</code>
   */
  public RepresentationEnum getRepresentation() {
        return representation;
    }
    
  /**
   * The type of the workflow.  IMPORTANT: This property determines the required workflow input and output, e.g., PredictionWorkflowInput and PredicitonWorkflowOutput-entity.
   * @return type , never <code>null</code>
   */
  public TypeEnum getType() {
        return type;
    }
    
  /**
   * The parameters of the workflow, TODO - should maybe be a map.
   * @return parameters 
   */
  public java.util.List<WorkflowParameter> getParameters() {
        return parameters;
    }
    
  /**
   * Descriptive tags/annotations for the workflow.
   * @return tags 
   */
  public java.util.List<Tag> getTags() {
        return tags;
    }
    
  /**
   * id referencing the workflow file.
   * @return fileId , never <code>null</code>
   */
  public java.util.UUID getFileId() {
        return fileId;
    }
    
  /**
   * Get outputTypes
   * @return outputTypes 
   */
  public WorkflowIOTypes getOutputTypes() {
        return outputTypes;
    }
    
  /**
   * Get inputTypes
   * @return inputTypes 
   */
  public WorkflowIOTypes getInputTypes() {
        return inputTypes;
    }
    
  
 	/**
  	 * @return a newly created builder
  	 */
  	public static WorkflowBuilder builder() {
  		return new WorkflowBuilder();
  	}
  	
  	/**
	 * Copy-builder, i.e. creates a new builder with all properties of the passed
	 * entity pre-set.
	 * 
	 * @param entity
	 *            entity to copy the properties from
	 * @return a new builder with the properties set
	 */
	public static WorkflowBuilder builder(Workflow entity) {
		WorkflowBuilder builder = builder();
        builder.faId = entity.faId;
        builder.name = entity.name;
        builder.description = entity.description;
        builder.representation = entity.representation;
        builder.type = entity.type;
        builder.parameters = entity.parameters;
        builder.tags = entity.tags;
        builder.fileId = entity.fileId;
        builder.outputTypes = entity.outputTypes;
        builder.inputTypes = entity.inputTypes;
 		return builder;
  	}
  	
  
    public static class WorkflowBuilder {
    
        protected WorkflowBuilder(){
            
        }
    
        private java.util.UUID faId;
        private String name;
        private String description;
        private RepresentationEnum representation;
        private TypeEnum type;
        private java.util.List<WorkflowParameter> parameters = new java.util.ArrayList<>();
        private java.util.List<Tag> tags = new java.util.ArrayList<>();
        private java.util.UUID fileId;
        private WorkflowIOTypes outputTypes;
        private WorkflowIOTypes inputTypes;

        /**
         * A global id within the FoodAuthent-system.
         * @return faId 
         */
        public WorkflowBuilder setFaId(java.util.UUID faId) {
             this.faId = faId;
             return this;
        }

        /**
         * Get name
         * @return name , never <code>null</code>
         */
        public WorkflowBuilder setName(String name) {
             if(name == null) {
                 throw new IllegalArgumentException("name must not be null.");
             }
             this.name = name;
             return this;
        }

        /**
         * Get description
         * @return description 
         */
        public WorkflowBuilder setDescription(String description) {
             this.description = description;
             return this;
        }

        /**
         * The workflow representation, e.g. represented by a scripting language, cwl or a KNIME-workflow.
         * @return representation , never <code>null</code>
         */
        public WorkflowBuilder setRepresentation(RepresentationEnum representation) {
             if(representation == null) {
                 throw new IllegalArgumentException("representation must not be null.");
             }
             this.representation = representation;
             return this;
        }

        /**
         * The type of the workflow.  IMPORTANT: This property determines the required workflow input and output, e.g., PredictionWorkflowInput and PredicitonWorkflowOutput-entity.
         * @return type , never <code>null</code>
         */
        public WorkflowBuilder setType(TypeEnum type) {
             if(type == null) {
                 throw new IllegalArgumentException("type must not be null.");
             }
             this.type = type;
             return this;
        }

        /**
         * The parameters of the workflow, TODO - should maybe be a map.
         * @return parameters 
         */
        public WorkflowBuilder setParameters(java.util.List<WorkflowParameter> parameters) {
             this.parameters = parameters;
             return this;
        }

        /**
         * Descriptive tags/annotations for the workflow.
         * @return tags 
         */
        public WorkflowBuilder setTags(java.util.List<Tag> tags) {
             this.tags = tags;
             return this;
        }

        /**
         * id referencing the workflow file.
         * @return fileId , never <code>null</code>
         */
        public WorkflowBuilder setFileId(java.util.UUID fileId) {
             if(fileId == null) {
                 throw new IllegalArgumentException("fileId must not be null.");
             }
             this.fileId = fileId;
             return this;
        }

        /**
         * Get outputTypes
         * @return outputTypes 
         */
        public WorkflowBuilder setOutputTypes(WorkflowIOTypes outputTypes) {
             this.outputTypes = outputTypes;
             return this;
        }

        /**
         * Get inputTypes
         * @return inputTypes 
         */
        public WorkflowBuilder setInputTypes(WorkflowIOTypes inputTypes) {
             this.inputTypes = inputTypes;
             return this;
        }

        
        public Workflow build() {
            return new Workflow(this);
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
