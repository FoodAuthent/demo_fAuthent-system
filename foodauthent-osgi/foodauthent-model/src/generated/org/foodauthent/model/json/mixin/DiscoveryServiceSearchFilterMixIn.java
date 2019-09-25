/*
 * TODO	
 */
package org.foodauthent.model.json.mixin;

import java.time.OffsetDateTime;
import org.foodauthent.model.BizTransaction;
import org.foodauthent.model.Epc;

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
    public java.util.List<String> getQuantityList();
    
    @JsonProperty("action")
    public String getAction();
    
    @JsonProperty("bizTransactionList")
    public java.util.List<BizTransaction> getBizTransactionList();
    
    @JsonProperty("eventType")
    public String getEventType();
    
    @JsonProperty("interfaceId")
    public java.util.UUID getInterfaceId();
    
    @JsonProperty("gtin")
    public String getGtin();
    
    @JsonProperty("bricks")
    public java.util.List<String> getBricks();
    
    @JsonProperty("eventTimeFrom")
    public OffsetDateTime getEventTimeFrom();
    
    @JsonProperty("eventTimeTo")
    public OffsetDateTime getEventTimeTo();
    

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
        public DiscoveryServiceSearchFilterMixInBuilder setQuantityList(final java.util.List<String> quantityList);
        
        @JsonProperty("action")
        public DiscoveryServiceSearchFilterMixInBuilder setAction(final String action);
        
        @JsonProperty("bizTransactionList")
        public DiscoveryServiceSearchFilterMixInBuilder setBizTransactionList(final java.util.List<BizTransaction> bizTransactionList);
        
        @JsonProperty("eventType")
        public DiscoveryServiceSearchFilterMixInBuilder setEventType(final String eventType);
        
        @JsonProperty("interfaceId")
        public DiscoveryServiceSearchFilterMixInBuilder setInterfaceId(final java.util.UUID interfaceId);
        
        @JsonProperty("gtin")
        public DiscoveryServiceSearchFilterMixInBuilder setGtin(final String gtin);
        
        @JsonProperty("bricks")
        public DiscoveryServiceSearchFilterMixInBuilder setBricks(final java.util.List<String> bricks);
        
        @JsonProperty("eventTimeFrom")
        public DiscoveryServiceSearchFilterMixInBuilder setEventTimeFrom(final OffsetDateTime eventTimeFrom);
        
        @JsonProperty("eventTimeTo")
        public DiscoveryServiceSearchFilterMixInBuilder setEventTimeTo(final OffsetDateTime eventTimeTo);
        
    }


}

