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
 * bizTransaction
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class BizTransaction   extends FaModel {


  protected String type;
  protected String value;
  
  public String getTypeID() {
    return "BizTransaction";
  }
  

  @Override
  public java.util.UUID getFaId() {
  	return null;
  }
  
  protected BizTransaction() {}
  
  private BizTransaction(BizTransactionBuilder builder) {
    
    type = immutable(builder.type);
    value = immutable(builder.value);
    
    
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
        BizTransaction ent = (BizTransaction)o;
        return Objects.equals(type, ent.type) && Objects.equals(value, ent.value);
    }


  /**
   * Type of transaction
   * @return type 
   */
  public String getType() {
        return type;
    }
    
  /**
   * Value of transaction
   * @return value 
   */
  public String getValue() {
        return value;
    }
    
  
 	/**
  	 * @return a newly created builder
  	 */
  	public static BizTransactionBuilder builder() {
  		return new BizTransactionBuilder();
  	}
  	
  	/**
	 * Copy-builder, i.e. creates a new builder with all properties of the passed
	 * entity pre-set.
	 * 
	 * @param entity
	 *            entity to copy the properties from
	 * @return a new builder with the properties set
	 */
	public static BizTransactionBuilder builder(BizTransaction entity) {
		BizTransactionBuilder builder = builder();
        builder.type = entity.type;
        builder.value = entity.value;
 		return builder;
  	}
  	
  
    public static class BizTransactionBuilder {
    
        protected BizTransactionBuilder(){
            
        }
    
        private String type;
        private String value;

        /**
         * Type of transaction
         * @return type 
         */
        public BizTransactionBuilder setType(String type) {
             this.type = type;
             return this;
        }

        /**
         * Value of transaction
         * @return value 
         */
        public BizTransactionBuilder setValue(String value) {
             this.value = value;
             return this;
        }

        
        public BizTransaction build() {
            return new BizTransaction(this);
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
