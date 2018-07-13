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



import org.foodauthent.model.MetadataEntries;
import org.foodauthent.model.MetadataEntries.MetadataEntriesBuilder;

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
    defaultImpl = MetadataEntries.class)
@JsonSubTypes({
    @Type(value = MetadataEntries.class, name="MetadataEntries")
})
@JsonDeserialize(builder=MetadataEntriesBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface MetadataEntriesMixIn {

	@JsonIgnore
	public long getPersistenceId();
	
    @JsonIgnore
    public String getTypeID();
    
    

    @JsonProperty("fa-id")
    public java.util.UUID getFaId();
    

    /**
     * MixIn class for entity builder implementations that adds jackson annotations for the de-/serialization.
     *
     * @author Martin Horn, University of Konstanz
     */
    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "",
        defaultImpl = MetadataEntriesBuilder.class)
    @JsonSubTypes({
        @Type(value = MetadataEntries.MetadataEntriesBuilder.class, name="MetadataEntries")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface MetadataEntriesMixInBuilder {
    
        public MetadataEntriesMixIn build();
    
        @JsonProperty("fa-id")
        public MetadataEntriesMixInBuilder setFaId(final java.util.UUID faId);
        
    }


}

