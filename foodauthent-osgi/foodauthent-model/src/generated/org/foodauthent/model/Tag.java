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
 * A tag/label for objects.
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class Tag  extends FaModel {

  /**
   * The type of the tag, e.g. whether it&#39;s a tag for a workflow, a model or a fingerprint.
   */
  public enum TypeEnum {
    WORKFLOW("workflow"),
    
    MODEL("model"),
    
    FINGERPRINT("fingerprint"),
    
    SOP("sop");

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
  private TypeEnum type;
  
  public String getTypeID() {
    return "Tag";
  }
  
  private Tag(TagBuilder builder) {
    
    faId = immutable(builder.faId);
    name = immutable(builder.name);
    description = immutable(builder.description);
    type = immutable(builder.type);
    
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
        Tag ent = (Tag)o;
        return Objects.equals(faId, ent.faId) && Objects.equals(name, ent.name) && Objects.equals(description, ent.description) && Objects.equals(type, ent.type);
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
    
  public TypeEnum getType() {
        return type;
    }
    
  
 	/**
  	 * @return a newly created builder
  	 */
  	public static TagBuilder builder() {
  		return new TagBuilder();
  	}
  
    public static class TagBuilder {
    
        private TagBuilder(){
            
        }
    
        private java.util.UUID faId = null;
        private String name = null;
        private String description = null;
        private TypeEnum type = null;

        public TagBuilder setFaId(java.util.UUID faId) {
             this.faId = faId;
             return this;
        }

        public TagBuilder setName(String name) {
             this.name = name;
             return this;
        }

        public TagBuilder setDescription(String description) {
             this.description = description;
             return this;
        }

        public TagBuilder setType(TypeEnum type) {
             this.type = type;
             return this;
        }

        
        public Tag build() {
            return new Tag(this);
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