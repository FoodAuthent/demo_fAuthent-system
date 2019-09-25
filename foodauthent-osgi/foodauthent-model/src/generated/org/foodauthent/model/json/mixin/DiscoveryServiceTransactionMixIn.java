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

import org.foodauthent.model.DiscoveryServiceTransaction.ActionEnum;


import org.foodauthent.model.DiscoveryServiceTransaction;
import org.foodauthent.model.DiscoveryServiceTransaction.DiscoveryServiceTransactionBuilder;

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
    defaultImpl = DiscoveryServiceTransaction.class)
@JsonSubTypes({
    @Type(value = DiscoveryServiceTransaction.class, name="DiscoveryServiceTransaction")
})
@JsonDeserialize(builder=DiscoveryServiceTransactionBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface DiscoveryServiceTransactionMixIn {

	@JsonIgnore
	public long getPersistenceId();
	
    @JsonIgnore
    public String getTypeID();
    
    

    @JsonProperty("fa-id")
    public java.util.UUID getFaId();
    
    @JsonProperty("epcList")
    public java.util.List<Epc> getEpcList();
    
    @JsonProperty("bizStep")
    public String getBizStep();
    
    @JsonProperty("readPoint")
    public String getReadPoint();
    
    @JsonProperty("quantityList")
    public java.util.List<String> getQuantityList();
    
    @JsonProperty("action")
    public ActionEnum getAction();
    
    @JsonProperty("bizTransactionList")
    public java.util.List<BizTransaction> getBizTransactionList();
    
    @JsonProperty("eventType")
    public String getEventType();
    
    @JsonProperty("interfaceId")
    public String getInterfaceId();
    
    @JsonProperty("gtin")
    public String getGtin();
    
    @JsonProperty("bricks")
    public java.util.List<String> getBricks();
    
    @JsonProperty("eventTime")
    public OffsetDateTime getEventTime();
    

    /**
     * MixIn class for entity builder implementations that adds jackson annotations for the de-/serialization.
     *
     * @author Martin Horn, University of Konstanz
     */
    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "",
        defaultImpl = DiscoveryServiceTransactionBuilder.class)
    @JsonSubTypes({
        @Type(value = DiscoveryServiceTransaction.DiscoveryServiceTransactionBuilder.class, name="DiscoveryServiceTransaction")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface DiscoveryServiceTransactionMixInBuilder {
    
        public DiscoveryServiceTransactionMixIn build();
    
        @JsonProperty("fa-id")
        public DiscoveryServiceTransactionMixInBuilder setFaId(final java.util.UUID faId);
        
        @JsonProperty("epcList")
        public DiscoveryServiceTransactionMixInBuilder setEpcList(final java.util.List<Epc> epcList);
        
        @JsonProperty("bizStep")
        public DiscoveryServiceTransactionMixInBuilder setBizStep(final String bizStep);
        
        @JsonProperty("readPoint")
        public DiscoveryServiceTransactionMixInBuilder setReadPoint(final String readPoint);
        
        @JsonProperty("quantityList")
        public DiscoveryServiceTransactionMixInBuilder setQuantityList(final java.util.List<String> quantityList);
        
        @JsonProperty("action")
        public DiscoveryServiceTransactionMixInBuilder setAction(final ActionEnum action);
        
        @JsonProperty("bizTransactionList")
        public DiscoveryServiceTransactionMixInBuilder setBizTransactionList(final java.util.List<BizTransaction> bizTransactionList);
        
        @JsonProperty("eventType")
        public DiscoveryServiceTransactionMixInBuilder setEventType(final String eventType);
        
        @JsonProperty("interfaceId")
        public DiscoveryServiceTransactionMixInBuilder setInterfaceId(final String interfaceId);
        
        @JsonProperty("gtin")
        public DiscoveryServiceTransactionMixInBuilder setGtin(final String gtin);
        
        @JsonProperty("bricks")
        public DiscoveryServiceTransactionMixInBuilder setBricks(final java.util.List<String> bricks);
        
        @JsonProperty("eventTime")
        public DiscoveryServiceTransactionMixInBuilder setEventTime(final OffsetDateTime eventTime);
        
    }


}

