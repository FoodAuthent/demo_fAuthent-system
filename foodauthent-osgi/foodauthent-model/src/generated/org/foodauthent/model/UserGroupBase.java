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
 * UserGroup Base Object
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class UserGroupBase   extends FaModel {


  protected String description;
  protected java.util.List<String> members;
  
  public String getTypeID() {
    return "UserGroupBase";
  }
  

  @Override
  public java.util.UUID getFaId() {
  	return null;
  }
  
  protected UserGroupBase() {}
  
  private UserGroupBase(UserGroupBaseBuilder builder) {
    
    description = immutable(builder.description);
    if(builder.members == null) {
        throw new IllegalArgumentException("members must not be null.");
    }
    members = immutable(builder.members);
    
    
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
        UserGroupBase ent = (UserGroupBase)o;
        return Objects.equals(description, ent.description) && Objects.equals(members, ent.members);
    }


  /**
   * verbose description
   * @return description 
   */
  public String getDescription() {
        return description;
    }
    
  /**
   * list of members user dn
   * @return members , never <code>null</code>
   */
  public java.util.List<String> getMembers() {
        return members;
    }
    
  
 	/**
  	 * @return a newly created builder
  	 */
  	public static UserGroupBaseBuilder builder() {
  		return new UserGroupBaseBuilder();
  	}
  	
  	/**
	 * Copy-builder, i.e. creates a new builder with all properties of the passed
	 * entity pre-set.
	 * 
	 * @param entity
	 *            entity to copy the properties from
	 * @return a new builder with the properties set
	 */
	public static UserGroupBaseBuilder builder(UserGroupBase entity) {
		UserGroupBaseBuilder builder = builder();
        builder.description = entity.description;
        builder.members = entity.members;
 		return builder;
  	}
  	
  
    public static class UserGroupBaseBuilder {
    
        protected UserGroupBaseBuilder(){
            
        }
    
        private String description;
        private java.util.List<String> members = new java.util.ArrayList<>();

        /**
         * verbose description
         * @return description 
         */
        public UserGroupBaseBuilder setDescription(String description) {
             this.description = description;
             return this;
        }

        /**
         * list of members user dn
         * @return members , never <code>null</code>
         */
        public UserGroupBaseBuilder setMembers(java.util.List<String> members) {
             if(members == null) {
                 throw new IllegalArgumentException("members must not be null.");
             }
             this.members = members;
             return this;
        }

        
        public UserGroupBase build() {
            return new UserGroupBase(this);
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
