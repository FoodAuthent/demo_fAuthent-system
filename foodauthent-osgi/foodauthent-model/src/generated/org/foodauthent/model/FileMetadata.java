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


/**
 * Metadata of a file in the FoodAuthent-system.
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class FileMetadata  extends FaModel {

  /**
   * The file type.
   */
  public enum TypeEnum {
    KNIME_WORKFLOW("knime_workflow"),
    
    KNIME_MODEL("knime_model"),
    
    PYTHON_SCRIPT("python_script"),
    
    SOP_PDF("sop_pdf"),
    
    FINGERPRINTS_BRUKER("fingerprints_bruker");

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
  private TypeEnum type;
  private String name;
  private String uploadName;
  private String description;
  private String author;
  private LocalDate date;
  private LocalDate uploadDate;
  private Integer version;
  
  public String getTypeID() {
    return "FileMetadata";
  }
  

  
  private FileMetadata(FileMetadataBuilder builder) {
    
    faId = immutable(builder.faId);
    type = immutable(builder.type);
    name = immutable(builder.name);
    uploadName = immutable(builder.uploadName);
    description = immutable(builder.description);
    author = immutable(builder.author);
    date = immutable(builder.date);
    uploadDate = immutable(builder.uploadDate);
    version = immutable(builder.version);
    
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
        return Objects.equals(faId, ent.faId) && Objects.equals(type, ent.type) && Objects.equals(name, ent.name) && Objects.equals(uploadName, ent.uploadName) && Objects.equals(description, ent.description) && Objects.equals(author, ent.author) && Objects.equals(date, ent.date) && Objects.equals(uploadDate, ent.uploadDate) && Objects.equals(version, ent.version);
    }


  public java.util.UUID getFaId() {
        return faId;
    }
    
  public TypeEnum getType() {
        return type;
    }
    
  public String getName() {
        return name;
    }
    
  public String getUploadName() {
        return uploadName;
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
    
  public LocalDate getUploadDate() {
        return uploadDate;
    }
    
  public Integer getVersion() {
        return version;
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
        builder.uploadName = entity.uploadName;
        builder.description = entity.description;
        builder.author = entity.author;
        builder.date = entity.date;
        builder.uploadDate = entity.uploadDate;
        builder.version = entity.version;
 		return builder;
  	}
  	
  
    public static class FileMetadataBuilder {
    
        private FileMetadataBuilder(){
            
        }
    
        private java.util.UUID faId = null;
        private TypeEnum type = null;
        private String name = null;
        private String uploadName = null;
        private String description = null;
        private String author = null;
        private LocalDate date = null;
        private LocalDate uploadDate = null;
        private Integer version = null;

        public FileMetadataBuilder setFaId(java.util.UUID faId) {
             this.faId = faId;
             return this;
        }

        public FileMetadataBuilder setType(TypeEnum type) {
             this.type = type;
             return this;
        }

        public FileMetadataBuilder setName(String name) {
             this.name = name;
             return this;
        }

        public FileMetadataBuilder setUploadName(String uploadName) {
             this.uploadName = uploadName;
             return this;
        }

        public FileMetadataBuilder setDescription(String description) {
             this.description = description;
             return this;
        }

        public FileMetadataBuilder setAuthor(String author) {
             this.author = author;
             return this;
        }

        public FileMetadataBuilder setDate(LocalDate date) {
             this.date = date;
             return this;
        }

        public FileMetadataBuilder setUploadDate(LocalDate uploadDate) {
             this.uploadDate = uploadDate;
             return this;
        }

        public FileMetadataBuilder setVersion(Integer version) {
             this.version = version;
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
