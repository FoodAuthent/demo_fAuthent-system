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
 * change password request object
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class ChangePasswordRequest   extends FaModel {


  protected String current;
  protected String _new;
  
  public String getTypeID() {
    return "ChangePasswordRequest";
  }
  

  @Override
  public java.util.UUID getFaId() {
  	return null;
  }
  
  protected ChangePasswordRequest() {}
  
  private ChangePasswordRequest(ChangePasswordRequestBuilder builder) {
    
    if(builder.current == null) {
        throw new IllegalArgumentException("current must not be null.");
    }
    current = immutable(builder.current);
    if(builder._new == null) {
        throw new IllegalArgumentException("_new must not be null.");
    }
    _new = immutable(builder._new);
    
    
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
        ChangePasswordRequest ent = (ChangePasswordRequest)o;
        return Objects.equals(current, ent.current) && Objects.equals(_new, ent._new);
    }


  /**
   * current password
   * @return current , never <code>null</code>
   */
  public String getCurrent() {
        return current;
    }
    
  /**
   * new password
   * @return _new , never <code>null</code>
   */
  public String getNew() {
        return _new;
    }
    
  
 	/**
  	 * @return a newly created builder
  	 */
  	public static ChangePasswordRequestBuilder builder() {
  		return new ChangePasswordRequestBuilder();
  	}
  	
  	/**
	 * Copy-builder, i.e. creates a new builder with all properties of the passed
	 * entity pre-set.
	 * 
	 * @param entity
	 *            entity to copy the properties from
	 * @return a new builder with the properties set
	 */
	public static ChangePasswordRequestBuilder builder(ChangePasswordRequest entity) {
		ChangePasswordRequestBuilder builder = builder();
        builder.current = entity.current;
        builder._new = entity._new;
 		return builder;
  	}
  	
  
    public static class ChangePasswordRequestBuilder {
    
        protected ChangePasswordRequestBuilder(){
            
        }
    
        private String current;
        private String _new;

        /**
         * current password
         * @return current , never <code>null</code>
         */
        public ChangePasswordRequestBuilder setCurrent(String current) {
             if(current == null) {
                 throw new IllegalArgumentException("current must not be null.");
             }
             this.current = current;
             return this;
        }

        /**
         * new password
         * @return _new , never <code>null</code>
         */
        public ChangePasswordRequestBuilder setNew(String _new) {
             if(_new == null) {
                 throw new IllegalArgumentException("_new must not be null.");
             }
             this._new = _new;
             return this;
        }

        
        public ChangePasswordRequest build() {
            return new ChangePasswordRequest(this);
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
