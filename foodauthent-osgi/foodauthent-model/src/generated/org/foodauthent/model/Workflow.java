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


import java.time.LocalDate;
import org.foodauthent.model.Tag;
import org.foodauthent.model.WorkflowInput;
import org.foodauthent.model.WorkflowOutput;


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
   * The type of the workflow, e.g. a generic one, a model etc. The type might also determine the what inputs/outputs to be expected.
   */
  public enum TypeEnum {
    PREDICTION("prediction"),
    
    TRAINING("training"),
    
    PROCESSING("processing");

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
  private String fileLink;
  private java.util.List<WorkflowInput> inputs;
  private java.util.List<WorkflowOutput> outputs;
  private java.util.List<Tag> tags;
  private java.util.UUID workflowfileId;
  
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
    fileLink = immutable(builder.fileLink);
    inputs = immutable(builder.inputs);
    outputs = immutable(builder.outputs);
    tags = immutable(builder.tags);
    workflowfileId = immutable(builder.workflowfileId);
    
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
        return Objects.equals(faId, ent.faId) && Objects.equals(name, ent.name) && Objects.equals(description, ent.description) && Objects.equals(author, ent.author) && Objects.equals(date, ent.date) && Objects.equals(version, ent.version) && Objects.equals(representation, ent.representation) && Objects.equals(type, ent.type) && Objects.equals(fileLink, ent.fileLink) && Objects.equals(inputs, ent.inputs) && Objects.equals(outputs, ent.outputs) && Objects.equals(tags, ent.tags) && Objects.equals(workflowfileId, ent.workflowfileId);
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
    
  public String getFileLink() {
        return fileLink;
    }
    
  public java.util.List<WorkflowInput> getInputs() {
        return inputs;
    }
    
  public java.util.List<WorkflowOutput> getOutputs() {
        return outputs;
    }
    
  public java.util.List<Tag> getTags() {
        return tags;
    }
    
  public java.util.UUID getWorkflowfileId() {
        return workflowfileId;
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
        builder.fileLink = entity.fileLink;
        builder.inputs = entity.inputs;
        builder.outputs = entity.outputs;
        builder.tags = entity.tags;
        builder.workflowfileId = entity.workflowfileId;
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
        private String fileLink = null;
        private java.util.List<WorkflowInput> inputs = new java.util.ArrayList<>();
        private java.util.List<WorkflowOutput> outputs = new java.util.ArrayList<>();
        private java.util.List<Tag> tags = new java.util.ArrayList<>();
        private java.util.UUID workflowfileId = null;

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

        public WorkflowBuilder setFileLink(String fileLink) {
             this.fileLink = fileLink;
             return this;
        }

        public WorkflowBuilder setInputs(java.util.List<WorkflowInput> inputs) {
             this.inputs = inputs;
             return this;
        }

        public WorkflowBuilder setOutputs(java.util.List<WorkflowOutput> outputs) {
             this.outputs = outputs;
             return this;
        }

        public WorkflowBuilder setTags(java.util.List<Tag> tags) {
             this.tags = tags;
             return this;
        }

        public WorkflowBuilder setWorkflowfileId(java.util.UUID workflowfileId) {
             this.workflowfileId = workflowfileId;
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
