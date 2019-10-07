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




/**
 * DiscoveryServiceTransactionFilter
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class DiscoveryServiceSearchFilter   extends FaModel {


  protected java.util.List<String> epcList;
  protected String bizStep;
  protected String readPoint;
  protected java.util.List<String> quantityList;
  protected String action;
  protected java.util.List<BizTransaction> bizTransactionList;
  protected String eventType;
  protected String interfaceId;
  protected String gtin;
  protected java.util.List<String> bricks;
  protected OffsetDateTime eventTimeFrom;
  protected OffsetDateTime eventTimeTo;

  public String getTypeID() {
    return "DiscoveryServiceSearchFilter";
  }


  @Override
  public java.util.UUID getFaId() {
  	return null;
  }

  protected DiscoveryServiceSearchFilter() {}

  private DiscoveryServiceSearchFilter(DiscoveryServiceSearchFilterBuilder builder) {
    
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
    eventTimeFrom = immutable(builder.eventTimeFrom);
    eventTimeTo = immutable(builder.eventTimeTo);


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
        DiscoveryServiceSearchFilter ent = (DiscoveryServiceSearchFilter)o;
        return Objects.equals(epcList, ent.epcList) && Objects.equals(bizStep, ent.bizStep) && Objects.equals(readPoint, ent.readPoint) && Objects.equals(quantityList, ent.quantityList) && Objects.equals(action, ent.action) && Objects.equals(bizTransactionList, ent.bizTransactionList) && Objects.equals(eventType, ent.eventType) && Objects.equals(interfaceId, ent.interfaceId) && Objects.equals(gtin, ent.gtin) && Objects.equals(bricks, ent.bricks) && Objects.equals(eventTimeFrom, ent.eventTimeFrom) && Objects.equals(eventTimeTo, ent.eventTimeTo);
    }


  /**
   * List of epcs
   * @return epcList 
   */
  public java.util.List<String> getEpcList() {
        return epcList;
    }

  /**
   * The business step of which this event was a part
   * @return bizStep 
   */
  public String getBizStep() {
        return bizStep;
    }

  /**
   * The read point at which the event took place.
   * @return readPoint 
   */
  public String getReadPoint() {
        return readPoint;
    }

  /**
   * Represents quantity of entities sharing a common EPC class, but where the individual identities of the entities are not specified.
   * @return quantityList 
   */
  public java.util.List<String> getQuantityList() {
        return quantityList;
    }

  /**
   * Event action.
   * @return action 
   */
  public String getAction() {
        return action;
    }

  /**
   * An unordered list of business transactions that define the context of this event(A BusinessTransaction identifies a particular business transaction. An example of a business transaction is a specific purchase order)
   * @return bizTransactionList 
   */
  public java.util.List<BizTransaction> getBizTransactionList() {
        return bizTransactionList;
    }

  /**
   * EPCIS eventType, for Foodauthent system could be only ObjectEvent
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
   * A brick identifies a category of consumer-related products
   * @return bricks 
   */
  public java.util.List<String> getBricks() {
        return bricks;
    }

  /**
   * start date and time for the research. It’s an ISO 8601 format
   * @return eventTimeFrom 
   */
  public OffsetDateTime getEventTimeFrom() {
        return eventTimeFrom;
    }

  /**
   * end date and time for the research. It’s an ISO 8601 format
   * @return eventTimeTo 
   */
  public OffsetDateTime getEventTimeTo() {
        return eventTimeTo;
    }


 	/**
  	 * @return a newly created builder
  	 */
  	public static DiscoveryServiceSearchFilterBuilder builder() {
  		return new DiscoveryServiceSearchFilterBuilder();
  	}

  	/**
	 * Copy-builder, i.e. creates a new builder with all properties of the passed
	 * entity pre-set.
	 *
	 * @param entity
	 *            entity to copy the properties from
	 * @return a new builder with the properties set
	 */
	public static DiscoveryServiceSearchFilterBuilder builder(DiscoveryServiceSearchFilter entity) {
		DiscoveryServiceSearchFilterBuilder builder = builder();
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
        builder.eventTimeFrom = entity.eventTimeFrom;
        builder.eventTimeTo = entity.eventTimeTo;
 		return builder;
  	}


    public static class DiscoveryServiceSearchFilterBuilder {

        protected DiscoveryServiceSearchFilterBuilder(){
            
        }

        private java.util.List<String> epcList = new java.util.ArrayList<>();
        private String bizStep;
        private String readPoint;
        private java.util.List<String> quantityList = new java.util.ArrayList<>();
        private String action;
        private java.util.List<BizTransaction> bizTransactionList = new java.util.ArrayList<>();
        private String eventType;
        private String interfaceId;
        private String gtin;
        private java.util.List<String> bricks = new java.util.ArrayList<>();
        private OffsetDateTime eventTimeFrom;
        private OffsetDateTime eventTimeTo;

        /**
         * List of epcs
         * @return epcList 
         */
        public DiscoveryServiceSearchFilterBuilder setEpcList(java.util.List<String> epcList) {
             this.epcList = epcList;
             return this;
        }

        /**
         * The business step of which this event was a part
         * @return bizStep 
         */
        public DiscoveryServiceSearchFilterBuilder setBizStep(String bizStep) {
             this.bizStep = bizStep;
             return this;
        }

        /**
         * The read point at which the event took place.
         * @return readPoint 
         */
        public DiscoveryServiceSearchFilterBuilder setReadPoint(String readPoint) {
             this.readPoint = readPoint;
             return this;
        }

        /**
         * Represents quantity of entities sharing a common EPC class, but where the individual identities of the entities are not specified.
         * @return quantityList 
         */
        public DiscoveryServiceSearchFilterBuilder setQuantityList(java.util.List<String> quantityList) {
             this.quantityList = quantityList;
             return this;
        }

        /**
         * Event action.
         * @return action 
         */
        public DiscoveryServiceSearchFilterBuilder setAction(String action) {
             this.action = action;
             return this;
        }

        /**
         * An unordered list of business transactions that define the context of this event(A BusinessTransaction identifies a particular business transaction. An example of a business transaction is a specific purchase order)
         * @return bizTransactionList 
         */
        public DiscoveryServiceSearchFilterBuilder setBizTransactionList(java.util.List<BizTransaction> bizTransactionList) {
             this.bizTransactionList = bizTransactionList;
             return this;
        }

        /**
         * EPCIS eventType, for Foodauthent system could be only ObjectEvent
         * @return eventType 
         */
        public DiscoveryServiceSearchFilterBuilder setEventType(String eventType) {
             this.eventType = eventType;
             return this;
        }

        /**
         * interfaceId
         * @return interfaceId 
         */
        public DiscoveryServiceSearchFilterBuilder setInterfaceId(String interfaceId) {
             this.interfaceId = interfaceId;
             return this;
        }

        /**
         * Global Trade Item Number
         * @return gtin 
         */
        public DiscoveryServiceSearchFilterBuilder setGtin(String gtin) {
             this.gtin = gtin;
             return this;
        }

        /**
         * A brick identifies a category of consumer-related products
         * @return bricks 
         */
        public DiscoveryServiceSearchFilterBuilder setBricks(java.util.List<String> bricks) {
             this.bricks = bricks;
             return this;
        }

        /**
         * start date and time for the research. It’s an ISO 8601 format
         * @return eventTimeFrom 
         */
        public DiscoveryServiceSearchFilterBuilder setEventTimeFrom(OffsetDateTime eventTimeFrom) {
             this.eventTimeFrom = eventTimeFrom;
             return this;
        }

        /**
         * end date and time for the research. It’s an ISO 8601 format
         * @return eventTimeTo 
         */
        public DiscoveryServiceSearchFilterBuilder setEventTimeTo(OffsetDateTime eventTimeTo) {
             this.eventTimeTo = eventTimeTo;
             return this;
        }


        public DiscoveryServiceSearchFilter build() {
            return new DiscoveryServiceSearchFilter(this);
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
