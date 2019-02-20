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
 * epc
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class Epc   extends FaModel {


  protected String epc;
  
  public String getTypeID() {
    return "Epc";
  }
  

  @Override
  public java.util.UUID getFaId() {
  	return null;
  }
  
  protected Epc() {}
  
  private Epc(EpcBuilder builder) {
    
    epc = immutable(builder.epc);
    
    
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
        Epc ent = (Epc)o;
        return Objects.equals(epc, ent.epc);
    }


  /**
   * epc
   * @return epc 
   */
  public String getEpc() {
        return epc;
    }
    
  
 	/**
  	 * @return a newly created builder
  	 */
  	public static EpcBuilder builder() {
  		return new EpcBuilder();
  	}
  	
  	/**
	 * Copy-builder, i.e. creates a new builder with all properties of the passed
	 * entity pre-set.
	 * 
	 * @param entity
	 *            entity to copy the properties from
	 * @return a new builder with the properties set
	 */
	public static EpcBuilder builder(Epc entity) {
		EpcBuilder builder = builder();
        builder.epc = entity.epc;
 		return builder;
  	}
  	
  
    public static class EpcBuilder {
    
        protected EpcBuilder(){
            
        }
    
        private String epc;

        /**
         * epc
         * @return epc 
         */
        public EpcBuilder setEpc(String epc) {
             this.epc = epc;
             return this;
        }

        
        public Epc build() {
            return new Epc(this);
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
