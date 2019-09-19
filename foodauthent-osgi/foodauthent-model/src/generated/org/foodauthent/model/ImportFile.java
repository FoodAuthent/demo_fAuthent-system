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
 * ImportFile
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class ImportFile   extends FaModel {


  protected java.util.UUID faId;
  protected java.util.UUID fileId;
  protected String name;
  protected String description;

  public String getTypeID() {
    return "ImportFile";
  }



  protected ImportFile() {}

  private ImportFile(ImportFileBuilder builder) {
    
    faId = immutable(builder.faId);
    fileId = immutable(builder.fileId);
    name = immutable(builder.name);
    description = immutable(builder.description);

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
        ImportFile ent = (ImportFile)o;
        return Objects.equals(faId, ent.faId) && Objects.equals(fileId, ent.fileId) && Objects.equals(name, ent.name) && Objects.equals(description, ent.description);
    }


  /**
   * A global id within the FoodAuthent-system.
   * @return faId 
   */
  public java.util.UUID getFaId() {
        return faId;
    }

  /**
   * Id referencing the file in the fa-system.
   * @return fileId 
   */
  public java.util.UUID getFileId() {
        return fileId;
    }

  /**
   * A short SOP name
   * @return name 
   */
  public String getName() {
        return name;
    }

  /**
   * A short description of the sop
   * @return description 
   */
  public String getDescription() {
        return description;
    }


 	/**
  	 * @return a newly created builder
  	 */
  	public static ImportFileBuilder builder() {
  		return new ImportFileBuilder();
  	}

  	/**
	 * Copy-builder, i.e. creates a new builder with all properties of the passed
	 * entity pre-set.
	 *
	 * @param entity
	 *            entity to copy the properties from
	 * @return a new builder with the properties set
	 */
	public static ImportFileBuilder builder(ImportFile entity) {
		ImportFileBuilder builder = builder();
        builder.faId = entity.faId;
        builder.fileId = entity.fileId;
        builder.name = entity.name;
        builder.description = entity.description;
 		return builder;
  	}


    public static class ImportFileBuilder {

        protected ImportFileBuilder(){
            
        }

        private java.util.UUID faId;
        private java.util.UUID fileId;
        private String name;
        private String description;

        /**
         * A global id within the FoodAuthent-system.
         * @return faId 
         */
        public ImportFileBuilder setFaId(java.util.UUID faId) {
             this.faId = faId;
             return this;
        }

        /**
         * Id referencing the file in the fa-system.
         * @return fileId 
         */
        public ImportFileBuilder setFileId(java.util.UUID fileId) {
             this.fileId = fileId;
             return this;
        }

        /**
         * A short SOP name
         * @return name 
         */
        public ImportFileBuilder setName(String name) {
             this.name = name;
             return this;
        }

        /**
         * A short description of the sop
         * @return description 
         */
        public ImportFileBuilder setDescription(String description) {
             this.description = description;
             return this;
        }


        public ImportFile build() {
            return new ImportFile(this);
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
