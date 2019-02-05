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
 * Request Object for User authentication
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class UserAuthenticationRequest   extends FaModel {


  protected String user;
  protected String password;
  
  public String getTypeID() {
    return "UserAuthenticationRequest";
  }
  

  @Override
  public java.util.UUID getFaId() {
  	return null;
  }
  
  protected UserAuthenticationRequest() {}
  
  private UserAuthenticationRequest(UserAuthenticationRequestBuilder builder) {
    
    if(builder.user == null) {
        throw new IllegalArgumentException("user must not be null.");
    }
    user = immutable(builder.user);
    if(builder.password == null) {
        throw new IllegalArgumentException("password must not be null.");
    }
    password = immutable(builder.password);
    
    
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
        UserAuthenticationRequest ent = (UserAuthenticationRequest)o;
        return Objects.equals(user, ent.user) && Objects.equals(password, ent.password);
    }


  /**
   * Get user
   * @return user , never <code>null</code>
   */
  public String getUser() {
        return user;
    }
    
  /**
   * Get password
   * @return password , never <code>null</code>
   */
  public String getPassword() {
        return password;
    }
    
  
 	/**
  	 * @return a newly created builder
  	 */
  	public static UserAuthenticationRequestBuilder builder() {
  		return new UserAuthenticationRequestBuilder();
  	}
  	
  	/**
	 * Copy-builder, i.e. creates a new builder with all properties of the passed
	 * entity pre-set.
	 * 
	 * @param entity
	 *            entity to copy the properties from
	 * @return a new builder with the properties set
	 */
	public static UserAuthenticationRequestBuilder builder(UserAuthenticationRequest entity) {
		UserAuthenticationRequestBuilder builder = builder();
        builder.user = entity.user;
        builder.password = entity.password;
 		return builder;
  	}
  	
  
    public static class UserAuthenticationRequestBuilder {
    
        protected UserAuthenticationRequestBuilder(){
            
        }
    
        private String user;
        private String password;

        /**
         * Get user
         * @return user , never <code>null</code>
         */
        public UserAuthenticationRequestBuilder setUser(String user) {
             if(user == null) {
                 throw new IllegalArgumentException("user must not be null.");
             }
             this.user = user;
             return this;
        }

        /**
         * Get password
         * @return password , never <code>null</code>
         */
        public UserAuthenticationRequestBuilder setPassword(String password) {
             if(password == null) {
                 throw new IllegalArgumentException("password must not be null.");
             }
             this.password = password;
             return this;
        }

        
        public UserAuthenticationRequest build() {
            return new UserAuthenticationRequest(this);
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
