/*
 * TODO	
 */
package org.foodauthent.model.json.mixin;


import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;



import org.foodauthent.model.PublishMetadata;
import org.foodauthent.model.PublishMetadata.PublishMetadataBuilder;

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
    defaultImpl = PublishMetadata.class)
@JsonSubTypes({
    @Type(value = PublishMetadata.class, name="PublishMetadata")
})
@JsonDeserialize(builder=PublishMetadataBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface PublishMetadataMixIn {

	@JsonIgnore
	public long getPersistenceId();
	
    @JsonIgnore
    public String getTypeID();
    
   	@JsonIgnore
  	public UUID getFaId();
    

    @JsonProperty("gtin")
    public String getGtin();
    
    @JsonProperty("bricks")
    public java.util.List<String> getBricks();
    
    @JsonProperty("epcis")
    public Boolean isEpcis();
    
    @JsonProperty("discovery")
    public Boolean isDiscovery();
    
    @JsonProperty("transaction-ids")
    public java.util.List<java.util.UUID> getTransactionIds();
    

    /**
     * MixIn class for entity builder implementations that adds jackson annotations for the de-/serialization.
     *
     * @author Martin Horn, University of Konstanz
     */
    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "",
        defaultImpl = PublishMetadataBuilder.class)
    @JsonSubTypes({
        @Type(value = PublishMetadata.PublishMetadataBuilder.class, name="PublishMetadata")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface PublishMetadataMixInBuilder {
    
        public PublishMetadataMixIn build();
    
        @JsonProperty("gtin")
        public PublishMetadataMixInBuilder setGtin(final String gtin);
        
        @JsonProperty("bricks")
        public PublishMetadataMixInBuilder setBricks(final java.util.List<String> bricks);
        
        @JsonProperty("epcis")
        public PublishMetadataMixInBuilder setEpcis(final Boolean epcis);
        
        @JsonProperty("discovery")
        public PublishMetadataMixInBuilder setDiscovery(final Boolean discovery);
        
        @JsonProperty("transaction-ids")
        public PublishMetadataMixInBuilder setTransactionIds(final java.util.List<java.util.UUID> transactionIds);
        
    }


}

