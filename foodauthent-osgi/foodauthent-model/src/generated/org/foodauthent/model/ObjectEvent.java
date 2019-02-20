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

import java.time.LocalDate;
import org.foodauthent.model.ArrayStringItem;
import org.foodauthent.model.BizTransaction;
import org.foodauthent.model.GPCAttribute;



/**
 * Object Event Transaction
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class ObjectEvent   extends FaModel {


  protected java.util.UUID faId;
  protected java.util.List<ArrayStringItem> epcList;
  protected String bizStep;
  protected String readPoint;
  protected java.util.List<ArrayStringItem> quantityList;
  protected String action;
  protected String disposition;
  protected java.util.List<BizTransaction> bizTransactionList;
  protected String gtin;
  protected java.util.List<GPCAttribute> bricks;
  protected LocalDate eventTime;
  
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
    eventTime = immutable(builder.eventTime);
    
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
        return Objects.equals(faId, ent.faId) && Objects.equals(epcList, ent.epcList) && Objects.equals(bizStep, ent.bizStep) && Objects.equals(readPoint, ent.readPoint) && Objects.equals(quantityList, ent.quantityList) && Objects.equals(action, ent.action) && Objects.equals(disposition, ent.disposition) && Objects.equals(bizTransactionList, ent.bizTransactionList) && Objects.equals(gtin, ent.gtin) && Objects.equals(bricks, ent.bricks) && Objects.equals(eventTime, ent.eventTime);
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
  public java.util.List<ArrayStringItem> getEpcList() {
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
  public java.util.List<ArrayStringItem> getQuantityList() {
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
  public java.util.List<BizTransaction> getBizTransactionList() {
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
  public java.util.List<GPCAttribute> getBricks() {
        return bricks;
    }
    
  /**
   * When the event happened
   * @return eventTime 
   */
  public LocalDate getEventTime() {
        return eventTime;
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
        builder.eventTime = entity.eventTime;
 		return builder;
  	}
  	
  
    public static class ObjectEventBuilder {
    
        protected ObjectEventBuilder(){
            
        }
    
        private java.util.UUID faId;
        private java.util.List<ArrayStringItem> epcList = new java.util.ArrayList<>();
        private String bizStep;
        private String readPoint;
        private java.util.List<ArrayStringItem> quantityList = new java.util.ArrayList<>();
        private String action;
        private String disposition;
        private java.util.List<BizTransaction> bizTransactionList = new java.util.ArrayList<>();
        private String gtin;
        private java.util.List<GPCAttribute> bricks = new java.util.ArrayList<>();
        private LocalDate eventTime;

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
        public ObjectEventBuilder setEpcList(java.util.List<ArrayStringItem> epcList) {
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
        public ObjectEventBuilder setQuantityList(java.util.List<ArrayStringItem> quantityList) {
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
        public ObjectEventBuilder setBizTransactionList(java.util.List<BizTransaction> bizTransactionList) {
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
        public ObjectEventBuilder setBricks(java.util.List<GPCAttribute> bricks) {
             this.bricks = bricks;
             return this;
        }

        /**
         * When the event happened
         * @return eventTime 
         */
        public ObjectEventBuilder setEventTime(LocalDate eventTime) {
             this.eventTime = eventTime;
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
