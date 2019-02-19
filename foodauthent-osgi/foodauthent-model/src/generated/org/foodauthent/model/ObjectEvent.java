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
 * Object Event Transaction
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class ObjectEvent   extends FaModel {


  protected java.util.UUID faId;
  protected String epcList;
  protected String bizStep;
  protected String readPoint;
  protected String quantityList;
  protected String action;
  protected String disposition;
  protected String bizTransactionList;
  protected String gtin;
  protected String bricks;
  
  public String getTypeID() {
    return "ObjectEvent";
  }
  

  
  protected ObjectEvent() {}
  
  private ObjectEvent(ObjectEventBuilder builder) {
    
    faId = immutable(builder.faId);
    epcList = immutable(builder.epcList);
    bizStep = immutable(builder.bizStep);
    readPoint = immutable(builder.readPoint);
    quantityList = immutable(builder.quantityList);
    action = immutable(builder.action);
    disposition = immutable(builder.disposition);
    bizTransactionList = immutable(builder.bizTransactionList);
    gtin = immutable(builder.gtin);
    bricks = immutable(builder.bricks);
    
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
        ObjectEvent ent = (ObjectEvent)o;
        return Objects.equals(faId, ent.faId) && Objects.equals(epcList, ent.epcList) && Objects.equals(bizStep, ent.bizStep) && Objects.equals(readPoint, ent.readPoint) && Objects.equals(quantityList, ent.quantityList) && Objects.equals(action, ent.action) && Objects.equals(disposition, ent.disposition) && Objects.equals(bizTransactionList, ent.bizTransactionList) && Objects.equals(gtin, ent.gtin) && Objects.equals(bricks, ent.bricks);
    }


  /**
   * A global id within the FoodAuthent-system.
   * @return faId 
   */
  public java.util.UUID getFaId() {
        return faId;
    }
    
  /**
   * List of epcs
   * @return epcList 
   */
  public String getEpcList() {
        return epcList;
    }
    
  /**
   * EPCIS bizStep
   * @return bizStep 
   */
  public String getBizStep() {
        return bizStep;
    }
    
  /**
   * Read point
   * @return readPoint 
   */
  public String getReadPoint() {
        return readPoint;
    }
    
  /**
   * List of quantity
   * @return quantityList 
   */
  public String getQuantityList() {
        return quantityList;
    }
    
  /**
   * EPCIS Action
   * @return action 
   */
  public String getAction() {
        return action;
    }
    
  /**
   * EPCIS Disposition
   * @return disposition 
   */
  public String getDisposition() {
        return disposition;
    }
    
  /**
   * List of bizTransactions
   * @return bizTransactionList 
   */
  public String getBizTransactionList() {
        return bizTransactionList;
    }
    
  /**
   * Global Trade Item Number
   * @return gtin 
   */
  public String getGtin() {
        return gtin;
    }
    
  /**
   * bricks
   * @return bricks 
   */
  public String getBricks() {
        return bricks;
    }
    
  
 	/**
  	 * @return a newly created builder
  	 */
  	public static ObjectEventBuilder builder() {
  		return new ObjectEventBuilder();
  	}
  	
  	/**
	 * Copy-builder, i.e. creates a new builder with all properties of the passed
	 * entity pre-set.
	 * 
	 * @param entity
	 *            entity to copy the properties from
	 * @return a new builder with the properties set
	 */
	public static ObjectEventBuilder builder(ObjectEvent entity) {
		ObjectEventBuilder builder = builder();
        builder.faId = entity.faId;
        builder.epcList = entity.epcList;
        builder.bizStep = entity.bizStep;
        builder.readPoint = entity.readPoint;
        builder.quantityList = entity.quantityList;
        builder.action = entity.action;
        builder.disposition = entity.disposition;
        builder.bizTransactionList = entity.bizTransactionList;
        builder.gtin = entity.gtin;
        builder.bricks = entity.bricks;
 		return builder;
  	}
  	
  
    public static class ObjectEventBuilder {
    
        protected ObjectEventBuilder(){
            
        }
    
        private java.util.UUID faId;
        private String epcList;
        private String bizStep;
        private String readPoint;
        private String quantityList;
        private String action;
        private String disposition;
        private String bizTransactionList;
        private String gtin;
        private String bricks;

        /**
         * A global id within the FoodAuthent-system.
         * @return faId 
         */
        public ObjectEventBuilder setFaId(java.util.UUID faId) {
             this.faId = faId;
             return this;
        }

        /**
         * List of epcs
         * @return epcList 
         */
        public ObjectEventBuilder setEpcList(String epcList) {
             this.epcList = epcList;
             return this;
        }

        /**
         * EPCIS bizStep
         * @return bizStep 
         */
        public ObjectEventBuilder setBizStep(String bizStep) {
             this.bizStep = bizStep;
             return this;
        }

        /**
         * Read point
         * @return readPoint 
         */
        public ObjectEventBuilder setReadPoint(String readPoint) {
             this.readPoint = readPoint;
             return this;
        }

        /**
         * List of quantity
         * @return quantityList 
         */
        public ObjectEventBuilder setQuantityList(String quantityList) {
             this.quantityList = quantityList;
             return this;
        }

        /**
         * EPCIS Action
         * @return action 
         */
        public ObjectEventBuilder setAction(String action) {
             this.action = action;
             return this;
        }

        /**
         * EPCIS Disposition
         * @return disposition 
         */
        public ObjectEventBuilder setDisposition(String disposition) {
             this.disposition = disposition;
             return this;
        }

        /**
         * List of bizTransactions
         * @return bizTransactionList 
         */
        public ObjectEventBuilder setBizTransactionList(String bizTransactionList) {
             this.bizTransactionList = bizTransactionList;
             return this;
        }

        /**
         * Global Trade Item Number
         * @return gtin 
         */
        public ObjectEventBuilder setGtin(String gtin) {
             this.gtin = gtin;
             return this;
        }

        /**
         * bricks
         * @return bricks 
         */
        public ObjectEventBuilder setBricks(String bricks) {
             this.bricks = bricks;
             return this;
        }

        
        public ObjectEvent build() {
            return new ObjectEvent(this);
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
