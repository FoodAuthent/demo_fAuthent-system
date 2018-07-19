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


/**
 * A model created via training and used for prediction. Can also be a workflow.
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class Model  extends FaModel {

  /**
   * The type of the model. More for informational purpose.
   */
  public enum TypeEnum {
    KNIME_WORKFLOW("knime_workflow"),
    
    KNIME_GENERIC_MODEL("knime_generic_model"),
    
    KNIME_PYTHON_MODEL("knime_python_model"),
    
    PMML_MODEL("pmml_model");

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
   * Workflows of this type must be able to work with this model! See workflow&#39;s type property.
   */
  public enum WorkflowTypeEnum {
    WORKFLOW("prediction_workflow");

    private String value;

    WorkflowTypeEnum(String value) {
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
  private TypeEnum type;
  private WorkflowTypeEnum workflowType;
  private java.util.List<Tag> tags;
  private java.util.UUID modelFileId;
  
  public String getTypeID() {
    return "Model";
  }
  

  
  private Model(ModelBuilder builder) {
    
    faId = immutable(builder.faId);
    name = immutable(builder.name);
    description = immutable(builder.description);
    author = immutable(builder.author);
    date = immutable(builder.date);
    version = immutable(builder.version);
    type = immutable(builder.type);
    workflowType = immutable(builder.workflowType);
    tags = immutable(builder.tags);
    modelFileId = immutable(builder.modelFileId);
    
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
        Model ent = (Model)o;
        return Objects.equals(faId, ent.faId) && Objects.equals(name, ent.name) && Objects.equals(description, ent.description) && Objects.equals(author, ent.author) && Objects.equals(date, ent.date) && Objects.equals(version, ent.version) && Objects.equals(type, ent.type) && Objects.equals(workflowType, ent.workflowType) && Objects.equals(tags, ent.tags) && Objects.equals(modelFileId, ent.modelFileId);
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
    
  public TypeEnum getType() {
        return type;
    }
    
  public WorkflowTypeEnum getWorkflowType() {
        return workflowType;
    }
    
  public java.util.List<Tag> getTags() {
        return tags;
    }
    
  public java.util.UUID getModelFileId() {
        return modelFileId;
    }
    
  
 	/**
  	 * @return a newly created builder
  	 */
  	public static ModelBuilder builder() {
  		return new ModelBuilder();
  	}
  	
  	/**
	 * Copy-builder, i.e. creates a new builder with all properties of the passed
	 * entity pre-set.
	 * 
	 * @param entity
	 *            entity to copy the properties from
	 * @return a new builder with the properties set
	 */
	public static ModelBuilder builder(Model entity) {
		ModelBuilder builder = builder();
        builder.faId = entity.faId;
        builder.name = entity.name;
        builder.description = entity.description;
        builder.author = entity.author;
        builder.date = entity.date;
        builder.version = entity.version;
        builder.type = entity.type;
        builder.workflowType = entity.workflowType;
        builder.tags = entity.tags;
        builder.modelFileId = entity.modelFileId;
 		return builder;
  	}
  	
  
    public static class ModelBuilder {
    
        private ModelBuilder(){
            
        }
    
        private java.util.UUID faId = null;
        private String name = null;
        private String description = null;
        private String author = null;
        private LocalDate date = null;
        private Integer version = null;
        private TypeEnum type = null;
        private WorkflowTypeEnum workflowType = null;
        private java.util.List<Tag> tags = new java.util.ArrayList<>();
        private java.util.UUID modelFileId = null;

        public ModelBuilder setFaId(java.util.UUID faId) {
             this.faId = faId;
             return this;
        }

        public ModelBuilder setName(String name) {
             this.name = name;
             return this;
        }

        public ModelBuilder setDescription(String description) {
             this.description = description;
             return this;
        }

        public ModelBuilder setAuthor(String author) {
             this.author = author;
             return this;
        }

        public ModelBuilder setDate(LocalDate date) {
             this.date = date;
             return this;
        }

        public ModelBuilder setVersion(Integer version) {
             this.version = version;
             return this;
        }

        public ModelBuilder setType(TypeEnum type) {
             this.type = type;
             return this;
        }

        public ModelBuilder setWorkflowType(WorkflowTypeEnum workflowType) {
             this.workflowType = workflowType;
             return this;
        }

        public ModelBuilder setTags(java.util.List<Tag> tags) {
             this.tags = tags;
             return this;
        }

        public ModelBuilder setModelFileId(java.util.UUID modelFileId) {
             this.modelFileId = modelFileId;
             return this;
        }

        
        public Model build() {
            return new Model(this);
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
