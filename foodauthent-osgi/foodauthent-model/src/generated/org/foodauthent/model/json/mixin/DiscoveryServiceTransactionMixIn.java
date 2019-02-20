/*
 * TODO	
 */
package org.foodauthent.model.json.mixin;

import java.time.LocalDate;
import org.foodauthent.model.ArrayStringItem;
import org.foodauthent.model.BizTransaction;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;



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
    public java.util.List<ArrayStringItem> getEpcList();
    
    @JsonProperty("bizStep")
    public String getBizStep();
    
    @JsonProperty("readPoint")
    public String getReadPoint();
    
    @JsonProperty("quantityList")
    public java.util.List<ArrayStringItem> getQuantityList();
    
    @JsonProperty("action")
    public String getAction();
    
    @JsonProperty("disposition")
    public String getDisposition();
    
    @JsonProperty("bizTransactionList")
    public java.util.List<BizTransaction> getBizTransactionList();
    
    @JsonProperty("gtin")
    public String getGtin();
    
    @JsonProperty("bricks")
    public java.util.List<ArrayStringItem> getBricks();
    
    @JsonProperty("sourceList")
    public java.util.List<BizTransaction> getSourceList();
    
    @JsonProperty("destinationList")
    public java.util.List<BizTransaction> getDestinationList();
    
    @JsonProperty("ilmd")
    public java.util.List<ArrayStringItem> getIlmd();
    
    @JsonProperty("eventTime")
    public LocalDate getEventTime();
    

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
        public DiscoveryServiceTransactionMixInBuilder setEpcList(final java.util.List<ArrayStringItem> epcList);
        
        @JsonProperty("bizStep")
        public DiscoveryServiceTransactionMixInBuilder setBizStep(final String bizStep);
        
        @JsonProperty("readPoint")
        public DiscoveryServiceTransactionMixInBuilder setReadPoint(final String readPoint);
        
        @JsonProperty("quantityList")
        public DiscoveryServiceTransactionMixInBuilder setQuantityList(final java.util.List<ArrayStringItem> quantityList);
        
        @JsonProperty("action")
        public DiscoveryServiceTransactionMixInBuilder setAction(final String action);
        
        @JsonProperty("disposition")
        public DiscoveryServiceTransactionMixInBuilder setDisposition(final String disposition);
        
        @JsonProperty("bizTransactionList")
        public DiscoveryServiceTransactionMixInBuilder setBizTransactionList(final java.util.List<BizTransaction> bizTransactionList);
        
        @JsonProperty("gtin")
        public DiscoveryServiceTransactionMixInBuilder setGtin(final String gtin);
        
        @JsonProperty("bricks")
        public DiscoveryServiceTransactionMixInBuilder setBricks(final java.util.List<ArrayStringItem> bricks);
        
        @JsonProperty("sourceList")
        public DiscoveryServiceTransactionMixInBuilder setSourceList(final java.util.List<BizTransaction> sourceList);
        
        @JsonProperty("destinationList")
        public DiscoveryServiceTransactionMixInBuilder setDestinationList(final java.util.List<BizTransaction> destinationList);
        
        @JsonProperty("ilmd")
        public DiscoveryServiceTransactionMixInBuilder setIlmd(final java.util.List<ArrayStringItem> ilmd);
        
        @JsonProperty("eventTime")
        public DiscoveryServiceTransactionMixInBuilder setEventTime(final LocalDate eventTime);
        
    }


}

