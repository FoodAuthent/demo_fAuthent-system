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
import org.foodauthent.model.ModelType;
import org.foodauthent.model.Tag;



/**
 * A model created via training and used for prediction. Can also be a workflow.
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class Model   extends FaModel {


  protected java.util.UUID faId;
  protected String name;
  protected String description;
  protected String author;
  protected LocalDate date;
  protected Integer version;
  protected ModelType type;
  protected java.util.List<Tag> tags;
  protected java.util.UUID fileId;
  protected java.util.UUID workflowId;
  protected java.util.UUID fingerprintsetId;
  protected java.util.List<String> classLabels;
  
  public String getTypeID() {
    return "Model";
  }
  

  
  protected Model() {}
  
  private Model(ModelBuilder builder) {
    
    faId = immutable(builder.faId);
    name = immutable(builder.name);
    description = immutable(builder.description);
    author = immutable(builder.author);
    date = immutable(builder.date);
    version = immutable(builder.version);
    type = immutable(builder.type);
    tags = immutable(builder.tags);
    fileId = immutable(builder.fileId);
    workflowId = immutable(builder.workflowId);
    fingerprintsetId = immutable(builder.fingerprintsetId);
    classLabels = immutable(builder.classLabels);
    
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
        return Objects.equals(faId, ent.faId) && Objects.equals(name, ent.name) && Objects.equals(description, ent.description) && Objects.equals(author, ent.author) && Objects.equals(date, ent.date) && Objects.equals(version, ent.version) && Objects.equals(type, ent.type) && Objects.equals(tags, ent.tags) && Objects.equals(fileId, ent.fileId) && Objects.equals(workflowId, ent.workflowId) && Objects.equals(fingerprintsetId, ent.fingerprintsetId) && Objects.equals(classLabels, ent.classLabels);
    }


  /**
   * A global id within the FoodAuthent-system.
   * @return faId 
   */
  public java.util.UUID getFaId() {
        return faId;
    }
    
  /**
   * A name for the model.
   * @return name 
   */
  public String getName() {
        return name;
    }
    
  /**
   * A more verbose description of the model.
   * @return description 
   */
  public String getDescription() {
        return description;
    }
    
  /**
   * The authors name (TODO - could reference a user in the future).
   * @return author 
   */
  public String getAuthor() {
        return author;
    }
    
  /**
   * The creation date.
   * @return date 
   */
  public LocalDate getDate() {
        return date;
    }
    
  /**
   * The model&#39;s version.
   * @return version 
   */
  public Integer getVersion() {
        return version;
    }
    
  /**
   * Get type
   * @return type 
   */
  public ModelType getType() {
        return type;
    }
    
  /**
   * Descriptive tags/annotations for the model.
   * @return tags 
   */
  public java.util.List<Tag> getTags() {
        return tags;
    }
    
  /**
   * id referencing the model file.
   * @return fileId 
   */
  public java.util.UUID getFileId() {
        return fileId;
    }
    
  /**
   * Optional reference to the workflow used to create this model.
   * @return workflowId 
   */
  public java.util.UUID getWorkflowId() {
        return workflowId;
    }
    
  /**
   * Reference to the fingerprint the model has been trained on
   * @return fingerprintsetId 
   */
  public java.util.UUID getFingerprintsetId() {
        return fingerprintsetId;
    }
    
  /**
   * the available class labels
   * @return classLabels 
   */
  public java.util.List<String> getClassLabels() {
        return classLabels;
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
        builder.tags = entity.tags;
        builder.fileId = entity.fileId;
        builder.workflowId = entity.workflowId;
        builder.fingerprintsetId = entity.fingerprintsetId;
        builder.classLabels = entity.classLabels;
 		return builder;
  	}
  	
  
    public static class ModelBuilder {
    
        protected ModelBuilder(){
            
        }
    
        private java.util.UUID faId;
        private String name;
        private String description;
        private String author;
        private LocalDate date;
        private Integer version;
        private ModelType type;
        private java.util.List<Tag> tags = new java.util.ArrayList<>();
        private java.util.UUID fileId;
        private java.util.UUID workflowId;
        private java.util.UUID fingerprintsetId;
        private java.util.List<String> classLabels = new java.util.ArrayList<>();

        /**
         * A global id within the FoodAuthent-system.
         * @return faId 
         */
        public ModelBuilder setFaId(java.util.UUID faId) {
             this.faId = faId;
             return this;
        }

        /**
         * A name for the model.
         * @return name 
         */
        public ModelBuilder setName(String name) {
             this.name = name;
             return this;
        }

        /**
         * A more verbose description of the model.
         * @return description 
         */
        public ModelBuilder setDescription(String description) {
             this.description = description;
             return this;
        }

        /**
         * The authors name (TODO - could reference a user in the future).
         * @return author 
         */
        public ModelBuilder setAuthor(String author) {
             this.author = author;
             return this;
        }

        /**
         * The creation date.
         * @return date 
         */
        public ModelBuilder setDate(LocalDate date) {
             this.date = date;
             return this;
        }

        /**
         * The model&#39;s version.
         * @return version 
         */
        public ModelBuilder setVersion(Integer version) {
             this.version = version;
             return this;
        }

        /**
         * Get type
         * @return type 
         */
        public ModelBuilder setType(ModelType type) {
             this.type = type;
             return this;
        }

        /**
         * Descriptive tags/annotations for the model.
         * @return tags 
         */
        public ModelBuilder setTags(java.util.List<Tag> tags) {
             this.tags = tags;
             return this;
        }

        /**
         * id referencing the model file.
         * @return fileId 
         */
        public ModelBuilder setFileId(java.util.UUID fileId) {
             this.fileId = fileId;
             return this;
        }

        /**
         * Optional reference to the workflow used to create this model.
         * @return workflowId 
         */
        public ModelBuilder setWorkflowId(java.util.UUID workflowId) {
             this.workflowId = workflowId;
             return this;
        }

        /**
         * Reference to the fingerprint the model has been trained on
         * @return fingerprintsetId 
         */
        public ModelBuilder setFingerprintsetId(java.util.UUID fingerprintsetId) {
             this.fingerprintsetId = fingerprintsetId;
             return this;
        }

        /**
         * the available class labels
         * @return classLabels 
         */
        public ModelBuilder setClassLabels(java.util.List<String> classLabels) {
             this.classLabels = classLabels;
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
