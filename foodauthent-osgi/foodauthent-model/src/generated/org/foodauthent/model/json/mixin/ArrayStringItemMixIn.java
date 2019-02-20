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



import org.foodauthent.model.ArrayStringItem;
import org.foodauthent.model.ArrayStringItem.ArrayStringItemBuilder;

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
    defaultImpl = ArrayStringItem.class)
@JsonSubTypes({
    @Type(value = ArrayStringItem.class, name="ArrayStringItem")
})
@JsonDeserialize(builder=ArrayStringItemBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface ArrayStringItemMixIn {

	@JsonIgnore
	public long getPersistenceId();
	
    @JsonIgnore
    public String getTypeID();
    
   	@JsonIgnore
  	public UUID getFaId();
    

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
        defaultImpl = ArrayStringItemBuilder.class)
    @JsonSubTypes({
        @Type(value = ArrayStringItem.ArrayStringItemBuilder.class, name="ArrayStringItem")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface ArrayStringItemMixInBuilder {
    
        public ArrayStringItemMixIn build();
    
        @JsonProperty("value")
        public ArrayStringItemMixInBuilder setValue(final String value);
        
    }


}

