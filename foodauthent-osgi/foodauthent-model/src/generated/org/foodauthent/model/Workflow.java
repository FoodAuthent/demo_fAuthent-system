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


import java.time.LocalDate;
import org.foodauthent.model.Tag;
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
    PREDICTION("prediction"),
    
    TRAINING("training");

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
  private String name;
  private String description;
  private String author;
  private LocalDate date;
  private Integer version;
  private RepresentationEnum representation;
  private TypeEnum type;
  private java.util.List<WorkflowParameter> parameters;
  private java.util.List<Tag> tags;
  private java.util.UUID workflowFileId;
  
  public String getTypeID() {
    return "Workflow";
  }
  

  
  private Workflow(WorkflowBuilder builder) {
    
    faId = immutable(builder.faId);
    name = immutable(builder.name);
    description = immutable(builder.description);
    author = immutable(builder.author);
    date = immutable(builder.date);
    version = immutable(builder.version);
    representation = immutable(builder.representation);
    type = immutable(builder.type);
    parameters = immutable(builder.parameters);
    tags = immutable(builder.tags);
    workflowFileId = immutable(builder.workflowFileId);
    
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
        return Objects.equals(faId, ent.faId) && Objects.equals(name, ent.name) && Objects.equals(description, ent.description) && Objects.equals(author, ent.author) && Objects.equals(date, ent.date) && Objects.equals(version, ent.version) && Objects.equals(representation, ent.representation) && Objects.equals(type, ent.type) && Objects.equals(parameters, ent.parameters) && Objects.equals(tags, ent.tags) && Objects.equals(workflowFileId, ent.workflowFileId);
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
    
  public String getAuthor() {
        return author;
    }
    
  public LocalDate getDate() {
        return date;
    }
    
  public Integer getVersion() {
        return version;
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
    
  public java.util.UUID getWorkflowFileId() {
        return workflowFileId;
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
        builder.author = entity.author;
        builder.date = entity.date;
        builder.version = entity.version;
        builder.representation = entity.representation;
        builder.type = entity.type;
        builder.parameters = entity.parameters;
        builder.tags = entity.tags;
        builder.workflowFileId = entity.workflowFileId;
 		return builder;
  	}
  	
  
    public static class WorkflowBuilder {
    
        private WorkflowBuilder(){
            
        }
    
        private java.util.UUID faId = null;
        private String name = null;
        private String description = null;
        private String author = null;
        private LocalDate date = null;
        private Integer version = null;
        private RepresentationEnum representation = null;
        private TypeEnum type = null;
        private java.util.List<WorkflowParameter> parameters = new java.util.ArrayList<>();
        private java.util.List<Tag> tags = new java.util.ArrayList<>();
        private java.util.UUID workflowFileId = null;

        public WorkflowBuilder setFaId(java.util.UUID faId) {
             this.faId = faId;
             return this;
        }

        public WorkflowBuilder setName(String name) {
             this.name = name;
             return this;
        }

        public WorkflowBuilder setDescription(String description) {
             this.description = description;
             return this;
        }

        public WorkflowBuilder setAuthor(String author) {
             this.author = author;
             return this;
        }

        public WorkflowBuilder setDate(LocalDate date) {
             this.date = date;
             return this;
        }

        public WorkflowBuilder setVersion(Integer version) {
             this.version = version;
             return this;
        }

        public WorkflowBuilder setRepresentation(RepresentationEnum representation) {
             this.representation = representation;
             return this;
        }

        public WorkflowBuilder setType(TypeEnum type) {
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

        public WorkflowBuilder setWorkflowFileId(java.util.UUID workflowFileId) {
             this.workflowFileId = workflowFileId;
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
