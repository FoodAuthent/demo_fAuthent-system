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
import org.foodauthent.model.BizTransaction;
import org.foodauthent.model.Epc;
import org.foodauthent.model.GPCBrick;
import org.foodauthent.model.QuantityElement;



/**
 * DiscoveryServiceTransactionFilter
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class DiscoveryServiceSearchFilter   extends FaModel {


  protected java.util.List<Epc> epcList;
  protected String bizStep;
  protected String readPoint;
  protected java.util.List<QuantityElement> quantityList;
  protected String action;
  protected String disposition;
  protected java.util.List<BizTransaction> bizTransactionList;
  protected String gtin;
  protected java.util.List<GPCBrick> bricks;
  protected java.util.List<BizTransaction> sourceList;
  protected java.util.List<BizTransaction> destinationList;
  protected java.util.List<BizTransaction> ilmd;
  protected LocalDate eventTimeFrom;
  protected LocalDate eventTimeTo;
  
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
    disposition = immutable(builder.disposition);
    bizTransactionList = immutable(builder.bizTransactionList);
    gtin = immutable(builder.gtin);
    bricks = immutable(builder.bricks);
    sourceList = immutable(builder.sourceList);
    destinationList = immutable(builder.destinationList);
    ilmd = immutable(builder.ilmd);
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
        return Objects.equals(epcList, ent.epcList) && Objects.equals(bizStep, ent.bizStep) && Objects.equals(readPoint, ent.readPoint) && Objects.equals(quantityList, ent.quantityList) && Objects.equals(action, ent.action) && Objects.equals(disposition, ent.disposition) && Objects.equals(bizTransactionList, ent.bizTransactionList) && Objects.equals(gtin, ent.gtin) && Objects.equals(bricks, ent.bricks) && Objects.equals(sourceList, ent.sourceList) && Objects.equals(destinationList, ent.destinationList) && Objects.equals(ilmd, ent.ilmd) && Objects.equals(eventTimeFrom, ent.eventTimeFrom) && Objects.equals(eventTimeTo, ent.eventTimeTo);
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
  public java.util.List<GPCBrick> getBricks() {
        return bricks;
    }
    
  /**
   * List of sources
   * @return sourceList 
   */
  public java.util.List<BizTransaction> getSourceList() {
        return sourceList;
    }
    
  /**
   * List of destinations
   * @return destinationList 
   */
  public java.util.List<BizTransaction> getDestinationList() {
        return destinationList;
    }
    
  /**
   * ilmd
   * @return ilmd 
   */
  public java.util.List<BizTransaction> getIlmd() {
        return ilmd;
    }
    
  /**
   * start date for the research
   * @return eventTimeFrom 
   */
  public LocalDate getEventTimeFrom() {
        return eventTimeFrom;
    }
    
  /**
   * end date for the research
   * @return eventTimeTo 
   */
  public LocalDate getEventTimeTo() {
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
        builder.disposition = entity.disposition;
        builder.bizTransactionList = entity.bizTransactionList;
        builder.gtin = entity.gtin;
        builder.bricks = entity.bricks;
        builder.sourceList = entity.sourceList;
        builder.destinationList = entity.destinationList;
        builder.ilmd = entity.ilmd;
        builder.eventTimeFrom = entity.eventTimeFrom;
        builder.eventTimeTo = entity.eventTimeTo;
 		return builder;
  	}
  	
  
    public static class DiscoveryServiceSearchFilterBuilder {
    
        protected DiscoveryServiceSearchFilterBuilder(){
            
        }
    
        private java.util.List<Epc> epcList = new java.util.ArrayList<>();
        private String bizStep;
        private String readPoint;
        private java.util.List<QuantityElement> quantityList = new java.util.ArrayList<>();
        private String action;
        private String disposition;
        private java.util.List<BizTransaction> bizTransactionList = new java.util.ArrayList<>();
        private String gtin;
        private java.util.List<GPCBrick> bricks = new java.util.ArrayList<>();
        private java.util.List<BizTransaction> sourceList = new java.util.ArrayList<>();
        private java.util.List<BizTransaction> destinationList = new java.util.ArrayList<>();
        private java.util.List<BizTransaction> ilmd = new java.util.ArrayList<>();
        private LocalDate eventTimeFrom;
        private LocalDate eventTimeTo;

        /**
         * List of epcs
         * @return epcList 
         */
        public DiscoveryServiceSearchFilterBuilder setEpcList(java.util.List<Epc> epcList) {
             this.epcList = epcList;
             return this;
        }

        /**
         * EPCIS bizStep
         * @return bizStep 
         */
        public DiscoveryServiceSearchFilterBuilder setBizStep(String bizStep) {
             this.bizStep = bizStep;
             return this;
        }

        /**
         * Read point
         * @return readPoint 
         */
        public DiscoveryServiceSearchFilterBuilder setReadPoint(String readPoint) {
             this.readPoint = readPoint;
             return this;
        }

        /**
         * List of quantity
         * @return quantityList 
         */
        public DiscoveryServiceSearchFilterBuilder setQuantityList(java.util.List<QuantityElement> quantityList) {
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
         * EPCIS Disposition
         * @return disposition 
         */
        public DiscoveryServiceSearchFilterBuilder setDisposition(String disposition) {
             this.disposition = disposition;
             return this;
        }

        /**
         * List of bizTransactions
         * @return bizTransactionList 
         */
        public DiscoveryServiceSearchFilterBuilder setBizTransactionList(java.util.List<BizTransaction> bizTransactionList) {
             this.bizTransactionList = bizTransactionList;
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
         * bricks
         * @return bricks 
         */
        public DiscoveryServiceSearchFilterBuilder setBricks(java.util.List<GPCBrick> bricks) {
             this.bricks = bricks;
             return this;
        }

        /**
         * List of sources
         * @return sourceList 
         */
        public DiscoveryServiceSearchFilterBuilder setSourceList(java.util.List<BizTransaction> sourceList) {
             this.sourceList = sourceList;
             return this;
        }

        /**
         * List of destinations
         * @return destinationList 
         */
        public DiscoveryServiceSearchFilterBuilder setDestinationList(java.util.List<BizTransaction> destinationList) {
             this.destinationList = destinationList;
             return this;
        }

        /**
         * ilmd
         * @return ilmd 
         */
        public DiscoveryServiceSearchFilterBuilder setIlmd(java.util.List<BizTransaction> ilmd) {
             this.ilmd = ilmd;
             return this;
        }

        /**
         * start date for the research
         * @return eventTimeFrom 
         */
        public DiscoveryServiceSearchFilterBuilder setEventTimeFrom(LocalDate eventTimeFrom) {
             this.eventTimeFrom = eventTimeFrom;
             return this;
        }

        /**
         * end date for the research
         * @return eventTimeTo 
         */
        public DiscoveryServiceSearchFilterBuilder setEventTimeTo(LocalDate eventTimeTo) {
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
