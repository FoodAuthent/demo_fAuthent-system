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



import org.foodauthent.model.BizTransaction;
import org.foodauthent.model.BizTransaction.BizTransactionBuilder;

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
    defaultImpl = BizTransaction.class)
@JsonSubTypes({
    @Type(value = BizTransaction.class, name="BizTransaction")
})
@JsonDeserialize(builder=BizTransactionBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface BizTransactionMixIn {

	@JsonIgnore
	public long getPersistenceId();
	
    @JsonIgnore
    public String getTypeID();
    
   	@JsonIgnore
  	public UUID getFaId();
    

    @JsonProperty("type")
    public String getType();
    
    @JsonProperty("value")
    public String getValue();
    

    /**
     * MixIn class for entity builder implementations that adds jackson annotations for the de-/serialization.
     *
     * @author Martin Horn, University of Konstanz
     */
    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "",
        defaultImpl = BizTransactionBuilder.class)
    @JsonSubTypes({
        @Type(value = BizTransaction.BizTransactionBuilder.class, name="BizTransaction")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface BizTransactionMixInBuilder {
    
        public BizTransactionMixIn build();
    
        @JsonProperty("type")
        public BizTransactionMixInBuilder setType(final String type);
        
        @JsonProperty("value")
        public BizTransactionMixInBuilder setValue(final String value);
        
    }


}

