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


import org.foodauthent.model.Prediction;


/**
 * PredictionList
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class PredictionList extends java.util.ArrayList<Prediction>  {


  
  public String getTypeID() {
    return "PredictionList";
  }
  

  
  private PredictionList(PredictionListBuilder builder) {
    super();
    
    
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
        PredictionList ent = (PredictionList)o;
        return super.equals(ent);
    }


  
 	/**
  	 * @return a newly created builder
  	 */
  	public static PredictionListBuilder builder() {
  		return new PredictionListBuilder();
  	}
  	
  	/**
	 * Copy-builder, i.e. creates a new builder with all properties of the passed
	 * entity pre-set.
	 * 
	 * @param entity
	 *            entity to copy the properties from
	 * @return a new builder with the properties set
	 */
	public static PredictionListBuilder builder(PredictionList entity) {
		PredictionListBuilder builder = builder();
 		return builder;
  	}
  	
  
    public static class PredictionListBuilder {
    
        private PredictionListBuilder(){
            super();
        }
    

        
        public PredictionList build() {
            return new PredictionList(this);
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
