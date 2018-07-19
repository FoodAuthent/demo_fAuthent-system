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


import org.foodauthent.model.Tag;
import org.foodauthent.model.WorkflowModule;
import org.foodauthent.model.WorkflowParameter;


/**
 * A workflow for a certain task.
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class Workflow  extends FaModel {

  /**
   * The workflow representation, e.g. represented by a scripting language, cwl or a KNIME-workflow.
   */
  public enum RepresentationEnum {
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
   * The type of the workflow. IMPORTANT: This property determines the required workflow input and output, e.g., PredictionWorkflowInput and PredicitonWorkflowOutput-entity.
   */
  public enum TypeEnum {
    PREDICTION_WORKFLOW("prediction_workflow"),
    
    TRAINING_WORKFLOW("training_workflow"),
    
    READ_MODULE("read_module"),
    
    BINNING_MODULE("binning_module"),
    
    TRANSFORMSIGNAL_MODULE("transformsignal_module"),
    
    TRANSFORMSAMPLE_MODULE("transformsample_module");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

  }

  /**
   * Type of the model this workflow can consume or produce. Can be left empty, e.g., in case of a preprocessing workflow. Model type must match one of the model&#39;s type property.
   */
  public enum ModelTypeEnum {
    KNIME_WORKFLOW("knime_workflow"),
    
    KNIME_PYTHON("knime_python"),
    
    PMML("pmml");

    private String value;

    ModelTypeEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

  }


  private java.util.UUID faId;
  private String name;
  private String description;
  private RepresentationEnum representation;
  private TypeEnum type;
  private java.util.List<WorkflowParameter> parameters;
  private java.util.List<Tag> tags;
  private java.util.UUID fileId;
  private java.util.List<WorkflowModule> modules;
  private ModelTypeEnum modelType;
  
  public String getTypeID() {
    return "Workflow";
  }
  

  
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
    modules = immutable(builder.modules);
    modelType = immutable(builder.modelType);
    
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
        return Objects.equals(faId, ent.faId) && Objects.equals(name, ent.name) && Objects.equals(description, ent.description) && Objects.equals(representation, ent.representation) && Objects.equals(type, ent.type) && Objects.equals(parameters, ent.parameters) && Objects.equals(tags, ent.tags) && Objects.equals(fileId, ent.fileId) && Objects.equals(modules, ent.modules) && Objects.equals(modelType, ent.modelType);
    }


  public java.util.UUID getFaId() {
        return faId;
    }
    
  public String getName() {
        return name;
    }
    
  public String getDescription() {
        return description;
    }
    
  public RepresentationEnum getRepresentation() {
        return representation;
    }
    
  public TypeEnum getType() {
        return type;
    }
    
  public java.util.List<WorkflowParameter> getParameters() {
        return parameters;
    }
    
  public java.util.List<Tag> getTags() {
        return tags;
    }
    
  public java.util.UUID getFileId() {
        return fileId;
    }
    
  public java.util.List<WorkflowModule> getModules() {
        return modules;
    }
    
  public ModelTypeEnum getModelType() {
        return modelType;
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
        builder.modules = entity.modules;
        builder.modelType = entity.modelType;
 		return builder;
  	}
  	
  
    public static class WorkflowBuilder {
    
        private WorkflowBuilder(){
            
        }
    
        private java.util.UUID faId = null;
        private String name = null;
        private String description = null;
        private RepresentationEnum representation = null;
        private TypeEnum type = null;
        private java.util.List<WorkflowParameter> parameters = new java.util.ArrayList<>();
        private java.util.List<Tag> tags = new java.util.ArrayList<>();
        private java.util.UUID fileId = null;
        private java.util.List<WorkflowModule> modules = new java.util.ArrayList<>();
        private ModelTypeEnum modelType = null;

        public WorkflowBuilder setFaId(java.util.UUID faId) {
             this.faId = faId;
             return this;
        }

        public WorkflowBuilder setName(String name) {
             if(name == null) {
                 throw new IllegalArgumentException("name must not be null.");
             }
             this.name = name;
             return this;
        }

        public WorkflowBuilder setDescription(String description) {
             this.description = description;
             return this;
        }

        public WorkflowBuilder setRepresentation(RepresentationEnum representation) {
             if(representation == null) {
                 throw new IllegalArgumentException("representation must not be null.");
             }
             this.representation = representation;
             return this;
        }

        public WorkflowBuilder setType(TypeEnum type) {
             if(type == null) {
                 throw new IllegalArgumentException("type must not be null.");
             }
             this.type = type;
             return this;
        }

        public WorkflowBuilder setParameters(java.util.List<WorkflowParameter> parameters) {
             this.parameters = parameters;
             return this;
        }

        public WorkflowBuilder setTags(java.util.List<Tag> tags) {
             this.tags = tags;
             return this;
        }

        public WorkflowBuilder setFileId(java.util.UUID fileId) {
             if(fileId == null) {
                 throw new IllegalArgumentException("fileId must not be null.");
             }
             this.fileId = fileId;
             return this;
        }

        public WorkflowBuilder setModules(java.util.List<WorkflowModule> modules) {
             this.modules = modules;
             return this;
        }

        public WorkflowBuilder setModelType(ModelTypeEnum modelType) {
             this.modelType = modelType;
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
