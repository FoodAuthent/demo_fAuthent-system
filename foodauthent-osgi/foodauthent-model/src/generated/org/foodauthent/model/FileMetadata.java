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



/**
 * Metadata of a file in the FoodAuthent-system.
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class FileMetadata   extends FaModel {

  /**
   * The file type.
   */
  public static enum TypeEnum {
    KNIME_WORKFLOW("knime_workflow"),
    
    KNIME_MODEL("knime_model"),
    
    PYTHON_SCRIPT("python_script"),
    
    SOP_PDF("sop_pdf"),
    
    FINGERPRINT_BRUKER("fingerprint_bruker"),
    
    ZIP("zip"),
    
    FAKX("fakx");

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
  protected TypeEnum type;
  protected String name;
  protected String contentType;
  protected String uploadName;
  protected String description;
  protected String author;
  protected LocalDate date;
  protected LocalDate uploadDate;
  protected Integer version;
  protected java.util.Map<String, String> additionalProperties;
  
  public String getTypeID() {
    return "FileMetadata";
  }
  

  
  protected FileMetadata() {}
  
  private FileMetadata(FileMetadataBuilder builder) {
    
    faId = immutable(builder.faId);
    type = immutable(builder.type);
    name = immutable(builder.name);
    contentType = immutable(builder.contentType);
    uploadName = immutable(builder.uploadName);
    description = immutable(builder.description);
    author = immutable(builder.author);
    date = immutable(builder.date);
    uploadDate = immutable(builder.uploadDate);
    version = immutable(builder.version);
    additionalProperties = immutable(builder.additionalProperties);
    
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
        FileMetadata ent = (FileMetadata)o;
        return Objects.equals(faId, ent.faId) && Objects.equals(type, ent.type) && Objects.equals(name, ent.name) && Objects.equals(contentType, ent.contentType) && Objects.equals(uploadName, ent.uploadName) && Objects.equals(description, ent.description) && Objects.equals(author, ent.author) && Objects.equals(date, ent.date) && Objects.equals(uploadDate, ent.uploadDate) && Objects.equals(version, ent.version) && Objects.equals(additionalProperties, ent.additionalProperties);
    }


  /**
   * A global id within the FoodAuthent-system.
   * @return faId 
   */
  public java.util.UUID getFaId() {
        return faId;
    }
    
  /**
   * The file type.
   * @return type 
   */
  public TypeEnum getType() {
        return type;
    }
    
  /**
   * A name for the file.
   * @return name 
   */
  public String getName() {
        return name;
    }
    
  /**
   * file content type
   * @return contentType 
   */
  public String getContentType() {
        return contentType;
    }
    
  /**
   * The name of the file as uploaded. Will be set automatically if left empty and a file is uploaded for the first time.
   * @return uploadName 
   */
  public String getUploadName() {
        return uploadName;
    }
    
  /**
   * A more verbose description of the file.
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
   * Time and date of the file upload. Will be set automatically.
   * @return uploadDate 
   */
  public LocalDate getUploadDate() {
        return uploadDate;
    }
    
  /**
   * The file&#39;s version.
   * @return version 
   */
  public Integer getVersion() {
        return version;
    }
    
  /**
   * Key-value-map for additional properties.
   * @return additionalProperties 
   */
  public java.util.Map<String, String> getAdditionalProperties() {
        return additionalProperties;
    }
    
  
 	/**
  	 * @return a newly created builder
  	 */
  	public static FileMetadataBuilder builder() {
  		return new FileMetadataBuilder();
  	}
  	
  	/**
	 * Copy-builder, i.e. creates a new builder with all properties of the passed
	 * entity pre-set.
	 * 
	 * @param entity
	 *            entity to copy the properties from
	 * @return a new builder with the properties set
	 */
	public static FileMetadataBuilder builder(FileMetadata entity) {
		FileMetadataBuilder builder = builder();
        builder.faId = entity.faId;
        builder.type = entity.type;
        builder.name = entity.name;
        builder.contentType = entity.contentType;
        builder.uploadName = entity.uploadName;
        builder.description = entity.description;
        builder.author = entity.author;
        builder.date = entity.date;
        builder.uploadDate = entity.uploadDate;
        builder.version = entity.version;
        builder.additionalProperties = entity.additionalProperties;
 		return builder;
  	}
  	
  
    public static class FileMetadataBuilder {
    
        protected FileMetadataBuilder(){
            
        }
    
        private java.util.UUID faId;
        private TypeEnum type;
        private String name;
        private String contentType;
        private String uploadName;
        private String description;
        private String author;
        private LocalDate date;
        private LocalDate uploadDate;
        private Integer version;
        private java.util.Map<String, String> additionalProperties = new java.util.HashMap<>();

        /**
         * A global id within the FoodAuthent-system.
         * @return faId 
         */
        public FileMetadataBuilder setFaId(java.util.UUID faId) {
             this.faId = faId;
             return this;
        }

        /**
         * The file type.
         * @return type 
         */
        public FileMetadataBuilder setType(TypeEnum type) {
             this.type = type;
             return this;
        }

        /**
         * A name for the file.
         * @return name 
         */
        public FileMetadataBuilder setName(String name) {
             this.name = name;
             return this;
        }

        /**
         * file content type
         * @return contentType 
         */
        public FileMetadataBuilder setContentType(String contentType) {
             this.contentType = contentType;
             return this;
        }

        /**
         * The name of the file as uploaded. Will be set automatically if left empty and a file is uploaded for the first time.
         * @return uploadName 
         */
        public FileMetadataBuilder setUploadName(String uploadName) {
             this.uploadName = uploadName;
             return this;
        }

        /**
         * A more verbose description of the file.
         * @return description 
         */
        public FileMetadataBuilder setDescription(String description) {
             this.description = description;
             return this;
        }

        /**
         * The authors name (TODO - could reference a user in the future).
         * @return author 
         */
        public FileMetadataBuilder setAuthor(String author) {
             this.author = author;
             return this;
        }

        /**
         * The creation date.
         * @return date 
         */
        public FileMetadataBuilder setDate(LocalDate date) {
             this.date = date;
             return this;
        }

        /**
         * Time and date of the file upload. Will be set automatically.
         * @return uploadDate 
         */
        public FileMetadataBuilder setUploadDate(LocalDate uploadDate) {
             this.uploadDate = uploadDate;
             return this;
        }

        /**
         * The file&#39;s version.
         * @return version 
         */
        public FileMetadataBuilder setVersion(Integer version) {
             this.version = version;
             return this;
        }

        /**
         * Key-value-map for additional properties.
         * @return additionalProperties 
         */
        public FileMetadataBuilder setAdditionalProperties(java.util.Map<String, String> additionalProperties) {
             this.additionalProperties = additionalProperties;
             return this;
        }

        
        public FileMetadata build() {
            return new FileMetadata(this);
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
