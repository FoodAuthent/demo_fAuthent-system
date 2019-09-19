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

import java.time.OffsetDateTime;
import org.foodauthent.model.BizTransaction;
import org.foodauthent.model.Epc;
import org.foodauthent.model.QuantityElement;

import com.fasterxml.jackson.annotation.JsonInclude;


/**
 * DiscoveryServiceTransaction
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class DiscoveryServiceTransaction   extends FaModel {

  /**
   * Event action.
   */
  public static enum ActionEnum {
    ADD("ADD"),
    
    OBSERVE("OBSERVE"),
    
    DELETE("DELETE");

    private String value;

    ActionEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

  }


  protected java.util.UUID faId;
  protected java.util.List<Epc> epcList;
  protected String bizStep;
  protected String readPoint;
  protected java.util.List<QuantityElement> quantityList;
  protected ActionEnum action;
  protected java.util.List<BizTransaction> bizTransactionList;
  protected String eventType;
  protected String interfaceId;
  protected String gtin;
  protected java.util.List<String> bricks;
  protected OffsetDateTime eventTime;

  public String getTypeID() {
    return "DiscoveryServiceTransaction";
  }



  protected DiscoveryServiceTransaction() {}

  private DiscoveryServiceTransaction(DiscoveryServiceTransactionBuilder builder) {
    
    faId = immutable(builder.faId);
    epcList = immutable(builder.epcList);
    bizStep = immutable(builder.bizStep);
    readPoint = immutable(builder.readPoint);
    quantityList = immutable(builder.quantityList);
    action = immutable(builder.action);
    bizTransactionList = immutable(builder.bizTransactionList);
    eventType = immutable(builder.eventType);
    interfaceId = immutable(builder.interfaceId);
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
        DiscoveryServiceTransaction ent = (DiscoveryServiceTransaction)o;
        return Objects.equals(faId, ent.faId) && Objects.equals(epcList, ent.epcList) && Objects.equals(bizStep, ent.bizStep) && Objects.equals(readPoint, ent.readPoint) && Objects.equals(quantityList, ent.quantityList) && Objects.equals(action, ent.action) && Objects.equals(bizTransactionList, ent.bizTransactionList) && Objects.equals(eventType, ent.eventType) && Objects.equals(interfaceId, ent.interfaceId) && Objects.equals(gtin, ent.gtin) && Objects.equals(bricks, ent.bricks) && Objects.equals(eventTime, ent.eventTime);
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
  public java.util.List<Epc> getEpcList() {
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
  public java.util.List<QuantityElement> getQuantityList() {
        return quantityList;
    }

  /**
   * Event action.
   * @return action 
   */
  public ActionEnum getAction() {
        return action;
    }

  /**
   * List of bizTransactions
   * @return bizTransactionList 
   */
  public java.util.List<BizTransaction> getBizTransactionList() {
        return bizTransactionList;
    }

  /**
   * EPCIS eventType
   * @return eventType 
   */
  public String getEventType() {
        return eventType;
    }

  /**
   * interfaceId
   * @return interfaceId 
   */
  public String getInterfaceId() {
        return interfaceId;
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
  public java.util.List<String> getBricks() {
        return bricks;
    }

  /**
   * When the event happened
   * @return eventTime 
   */
  public OffsetDateTime getEventTime() {
        return eventTime;
    }


 	/**
  	 * @return a newly created builder
  	 */
  	public static DiscoveryServiceTransactionBuilder builder() {
  		return new DiscoveryServiceTransactionBuilder();
  	}

  	/**
	 * Copy-builder, i.e. creates a new builder with all properties of the passed
	 * entity pre-set.
	 *
	 * @param entity
	 *            entity to copy the properties from
	 * @return a new builder with the properties set
	 */
	public static DiscoveryServiceTransactionBuilder builder(DiscoveryServiceTransaction entity) {
		DiscoveryServiceTransactionBuilder builder = builder();
        builder.faId = entity.faId;
        builder.epcList = entity.epcList;
        builder.bizStep = entity.bizStep;
        builder.readPoint = entity.readPoint;
        builder.quantityList = entity.quantityList;
        builder.action = entity.action;
        builder.bizTransactionList = entity.bizTransactionList;
        builder.eventType = entity.eventType;
        builder.interfaceId = entity.interfaceId;
        builder.gtin = entity.gtin;
        builder.bricks = entity.bricks;
        builder.eventTime = entity.eventTime;
 		return builder;
  	}


    public static class DiscoveryServiceTransactionBuilder {

        protected DiscoveryServiceTransactionBuilder(){
            
        }

        private java.util.UUID faId;
        private java.util.List<Epc> epcList = new java.util.ArrayList<>();
        private String bizStep;
        private String readPoint;
        private java.util.List<QuantityElement> quantityList = new java.util.ArrayList<>();
        private ActionEnum action;
        private java.util.List<BizTransaction> bizTransactionList = new java.util.ArrayList<>();
        private String eventType;
        private String interfaceId;
        private String gtin;
        private java.util.List<String> bricks = new java.util.ArrayList<>();
        private OffsetDateTime eventTime;

        /**
         * A global id within the FoodAuthent-system.
         * @return faId 
         */
        public DiscoveryServiceTransactionBuilder setFaId(java.util.UUID faId) {
             this.faId = faId;
             return this;
        }

        /**
         * List of epcs
         * @return epcList 
         */
        public DiscoveryServiceTransactionBuilder setEpcList(java.util.List<Epc> epcList) {
             this.epcList = epcList;
             return this;
        }

        /**
         * EPCIS bizStep
         * @return bizStep 
         */
        public DiscoveryServiceTransactionBuilder setBizStep(String bizStep) {
             this.bizStep = bizStep;
             return this;
        }

        /**
         * Read point
         * @return readPoint 
         */
        public DiscoveryServiceTransactionBuilder setReadPoint(String readPoint) {
             this.readPoint = readPoint;
             return this;
        }

        /**
         * List of quantity
         * @return quantityList 
         */
        public DiscoveryServiceTransactionBuilder setQuantityList(java.util.List<QuantityElement> quantityList) {
             this.quantityList = quantityList;
             return this;
        }

        /**
         * Event action.
         * @return action 
         */
        public DiscoveryServiceTransactionBuilder setAction(ActionEnum action) {
             this.action = action;
             return this;
        }

        /**
         * List of bizTransactions
         * @return bizTransactionList 
         */
        public DiscoveryServiceTransactionBuilder setBizTransactionList(java.util.List<BizTransaction> bizTransactionList) {
             this.bizTransactionList = bizTransactionList;
             return this;
        }

        /**
         * EPCIS eventType
         * @return eventType 
         */
        public DiscoveryServiceTransactionBuilder setEventType(String eventType) {
             this.eventType = eventType;
             return this;
        }

        /**
         * interfaceId
         * @return interfaceId 
         */
        public DiscoveryServiceTransactionBuilder setInterfaceId(String interfaceId) {
             this.interfaceId = interfaceId;
             return this;
        }

        /**
         * Global Trade Item Number
         * @return gtin 
         */
        public DiscoveryServiceTransactionBuilder setGtin(String gtin) {
             this.gtin = gtin;
             return this;
        }

        /**
         * bricks
         * @return bricks 
         */
        public DiscoveryServiceTransactionBuilder setBricks(java.util.List<String> bricks) {
             this.bricks = bricks;
             return this;
        }

        /**
         * When the event happened
         * @return eventTime 
         */
        public DiscoveryServiceTransactionBuilder setEventTime(OffsetDateTime eventTime) {
             this.eventTime = eventTime;
             return this;
        }


        public DiscoveryServiceTransaction build() {
            return new DiscoveryServiceTransaction(this);
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
