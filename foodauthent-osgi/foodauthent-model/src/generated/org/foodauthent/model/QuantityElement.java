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
public class QuantityElement   extends FaModel {


  protected String epcClass;
  protected String quantity;
  protected String uom;
  
  public String getTypeID() {
    return "QuantityElement";
  }
  

  @Override
  public java.util.UUID getFaId() {
  	return null;
  }
  
  protected QuantityElement() {}
  
  private QuantityElement(QuantityElementBuilder builder) {
    
    epcClass = immutable(builder.epcClass);
    quantity = immutable(builder.quantity);
    uom = immutable(builder.uom);
    
    
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
        QuantityElement ent = (QuantityElement)o;
        return Objects.equals(epcClass, ent.epcClass) && Objects.equals(quantity, ent.quantity) && Objects.equals(uom, ent.uom);
    }


  /**
   * epcClass
   * @return epcClass 
   */
  public String getEpcClass() {
        return epcClass;
    }
    
  /**
   * quantity
   * @return quantity 
   */
  public String getQuantity() {
        return quantity;
    }
    
  /**
   * uom
   * @return uom 
   */
  public String getUom() {
        return uom;
    }
    
  
 	/**
  	 * @return a newly created builder
  	 */
  	public static QuantityElementBuilder builder() {
  		return new QuantityElementBuilder();
  	}
  	
  	/**
	 * Copy-builder, i.e. creates a new builder with all properties of the passed
	 * entity pre-set.
	 * 
	 * @param entity
	 *            entity to copy the properties from
	 * @return a new builder with the properties set
	 */
	public static QuantityElementBuilder builder(QuantityElement entity) {
		QuantityElementBuilder builder = builder();
        builder.epcClass = entity.epcClass;
        builder.quantity = entity.quantity;
        builder.uom = entity.uom;
 		return builder;
  	}
  	
  
    public static class QuantityElementBuilder {
    
        protected QuantityElementBuilder(){
            
        }
    
        private String epcClass;
        private String quantity;
        private String uom;

        /**
         * epcClass
         * @return epcClass 
         */
        public QuantityElementBuilder setEpcClass(String epcClass) {
             this.epcClass = epcClass;
             return this;
        }

        /**
         * quantity
         * @return quantity 
         */
        public QuantityElementBuilder setQuantity(String quantity) {
             this.quantity = quantity;
             return this;
        }

        /**
         * uom
         * @return uom 
         */
        public QuantityElementBuilder setUom(String uom) {
             this.uom = uom;
             return this;
        }

        
        public QuantityElement build() {
            return new QuantityElement(this);
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
