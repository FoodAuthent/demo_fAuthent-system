/*
 * TODO	
 */
package org.foodauthent.model.json.mixin;

import java.time.LocalDate;
import org.foodauthent.model.BizTransaction;
import org.foodauthent.model.Epc;
import org.foodauthent.model.GPCBrick;
import org.foodauthent.model.QuantityElement;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;



import org.foodauthent.model.DiscoveryServiceSearchFilter;
import org.foodauthent.model.DiscoveryServiceSearchFilter.DiscoveryServiceSearchFilterBuilder;

/**
 * MixIn class for entity implementations that adds jackson annotations for de-/serialization.
 *
 * @author Martin Horn, University of Konstanz
 */
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    property = "",
    visible = true,
    defaultImpl = DiscoveryServiceSearchFilter.class)
@JsonSubTypes({
    @Type(value = DiscoveryServiceSearchFilter.class, name="DiscoveryServiceSearchFilter")
})
@JsonDeserialize(builder=DiscoveryServiceSearchFilterBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface DiscoveryServiceSearchFilterMixIn {

	@JsonIgnore
	public long getPersistenceId();
	
    @JsonIgnore
    public String getTypeID();
    
   	@JsonIgnore
  	public UUID getFaId();
    

    @JsonProperty("epcList")
    public java.util.List<Epc> getEpcList();
    
    @JsonProperty("bizStep")
    public String getBizStep();
    
    @JsonProperty("readPoint")
    public String getReadPoint();
    
    @JsonProperty("quantityList")
    public java.util.List<QuantityElement> getQuantityList();
    
    @JsonProperty("action")
    public String getAction();
    
    @JsonProperty("disposition")
    public String getDisposition();
    
    @JsonProperty("bizTransactionList")
    public java.util.List<BizTransaction> getBizTransactionList();
    
    @JsonProperty("gtin")
    public String getGtin();
    
    @JsonProperty("bricks")
    public java.util.List<GPCBrick> getBricks();
    
    @JsonProperty("sourceList")
    public java.util.List<BizTransaction> getSourceList();
    
    @JsonProperty("destinationList")
    public java.util.List<BizTransaction> getDestinationList();
    
    @JsonProperty("ilmd")
    public java.util.List<BizTransaction> getIlmd();
    
    @JsonProperty("eventTimeFrom")
    public LocalDate getEventTimeFrom();
    
    @JsonProperty("eventTimeTo")
    public LocalDate getEventTimeTo();
    

    /**
     * MixIn class for entity builder implementations that adds jackson annotations for the de-/serialization.
     *
     * @author Martin Horn, University of Konstanz
     */
    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "",
        defaultImpl = DiscoveryServiceSearchFilterBuilder.class)
    @JsonSubTypes({
        @Type(value = DiscoveryServiceSearchFilter.DiscoveryServiceSearchFilterBuilder.class, name="DiscoveryServiceSearchFilter")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface DiscoveryServiceSearchFilterMixInBuilder {
    
        public DiscoveryServiceSearchFilterMixIn build();
    
        @JsonProperty("epcList")
        public DiscoveryServiceSearchFilterMixInBuilder setEpcList(final java.util.List<Epc> epcList);
        
        @JsonProperty("bizStep")
        public DiscoveryServiceSearchFilterMixInBuilder setBizStep(final String bizStep);
        
        @JsonProperty("readPoint")
        public DiscoveryServiceSearchFilterMixInBuilder setReadPoint(final String readPoint);
        
        @JsonProperty("quantityList")
        public DiscoveryServiceSearchFilterMixInBuilder setQuantityList(final java.util.List<QuantityElement> quantityList);
        
        @JsonProperty("action")
        public DiscoveryServiceSearchFilterMixInBuilder setAction(final String action);
        
        @JsonProperty("disposition")
        public DiscoveryServiceSearchFilterMixInBuilder setDisposition(final String disposition);
        
        @JsonProperty("bizTransactionList")
        public DiscoveryServiceSearchFilterMixInBuilder setBizTransactionList(final java.util.List<BizTransaction> bizTransactionList);
        
        @JsonProperty("gtin")
        public DiscoveryServiceSearchFilterMixInBuilder setGtin(final String gtin);
        
        @JsonProperty("bricks")
        public DiscoveryServiceSearchFilterMixInBuilder setBricks(final java.util.List<GPCBrick> bricks);
        
        @JsonProperty("sourceList")
        public DiscoveryServiceSearchFilterMixInBuilder setSourceList(final java.util.List<BizTransaction> sourceList);
        
        @JsonProperty("destinationList")
        public DiscoveryServiceSearchFilterMixInBuilder setDestinationList(final java.util.List<BizTransaction> destinationList);
        
        @JsonProperty("ilmd")
        public DiscoveryServiceSearchFilterMixInBuilder setIlmd(final java.util.List<BizTransaction> ilmd);
        
        @JsonProperty("eventTimeFrom")
        public DiscoveryServiceSearchFilterMixInBuilder setEventTimeFrom(final LocalDate eventTimeFrom);
        
        @JsonProperty("eventTimeTo")
        public DiscoveryServiceSearchFilterMixInBuilder setEventTimeTo(final LocalDate eventTimeTo);
        
    }


}

