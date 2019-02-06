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
 * UserGroup Object for creating new groups
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class UserGroupCreateRequest extends UserGroupBase  {


  protected String name;
  
  public String getTypeID() {
    return "UserGroupCreateRequest";
  }
  

  
  protected UserGroupCreateRequest() {}
  
  private UserGroupCreateRequest(UserGroupCreateRequestBuilder builder) {
    super();
    description = immutable(builder.description);
    if(builder.members == null) {
        throw new IllegalArgumentException("members must not be null.");
    }
    members = immutable(builder.members);
    if(builder.name == null) {
        throw new IllegalArgumentException("name must not be null.");
    }
    name = immutable(builder.name);
    
    
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
        UserGroupCreateRequest ent = (UserGroupCreateRequest)o;
        return super.equals(ent);
    }


  /**
   * unique group name
   * @return name , never <code>null</code>
   */
  public String getName() {
        return name;
    }
    
  
 	/**
  	 * @return a newly created builder
  	 */
  	public static UserGroupCreateRequestBuilder builder() {
  		return new UserGroupCreateRequestBuilder();
  	}
  	
  	/**
	 * Copy-builder, i.e. creates a new builder with all properties of the passed
	 * entity pre-set.
	 * 
	 * @param entity
	 *            entity to copy the properties from
	 * @return a new builder with the properties set
	 */
	public static UserGroupCreateRequestBuilder builder(UserGroupCreateRequest entity) {
		UserGroupCreateRequestBuilder builder = builder();
        builder.description = entity.description;
        builder.members = entity.members;
        builder.name = entity.name;
 		return builder;
  	}
  	
  
    public static class UserGroupCreateRequestBuilder extends UserGroupBaseBuilder {
    
        protected UserGroupCreateRequestBuilder(){
            super();
        }
    
        private String description;
        private java.util.List<String> members = new java.util.ArrayList<>();
        private String name;

        /**
         * verbose description
         * @return description 
         */
        public UserGroupCreateRequestBuilder setDescription(String description) {
             this.description = description;
             return this;
        }

        /**
         * list of members user dn
         * @return members , never <code>null</code>
         */
        public UserGroupCreateRequestBuilder setMembers(java.util.List<String> members) {
             if(members == null) {
                 throw new IllegalArgumentException("members must not be null.");
             }
             this.members = members;
             return this;
        }

        /**
         * unique group name
         * @return name , never <code>null</code>
         */
        public UserGroupCreateRequestBuilder setName(String name) {
             if(name == null) {
                 throw new IllegalArgumentException("name must not be null.");
             }
             this.name = name;
             return this;
        }

        
        public UserGroupCreateRequest build() {
            return new UserGroupCreateRequest(this);
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
