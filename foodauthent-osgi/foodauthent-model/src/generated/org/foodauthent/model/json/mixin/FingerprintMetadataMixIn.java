/*
 * TODO	
 */
package org.foodauthent.model.json.mixin;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;



import org.foodauthent.model.FingerprintMetadata;
import org.foodauthent.model.FingerprintMetadata.FingerprintMetadataBuilder;

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
    defaultImpl = FingerprintMetadata.class)
@JsonSubTypes({
    @Type(value = FingerprintMetadata.class, name="FingerprintMetadata")
})
@JsonDeserialize(builder=FingerprintMetadataBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface FingerprintMetadataMixIn {

	@JsonIgnore
	public long getPersistenceId();

    @JsonIgnore
    public String getTypeID();

    @JsonProperty("parent-id")
    public java.util.UUID getParentId();
    

    /**
     * MixIn class for entity builder implementations that adds jackson annotations for the de-/serialization.
     *
     * @author Martin Horn, University of Konstanz
     */
    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "",
        defaultImpl = FingerprintMetadataBuilder.class)
    @JsonSubTypes({
        @Type(value = FingerprintMetadata.FingerprintMetadataBuilder.class, name="FingerprintMetadata")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface FingerprintMetadataMixInBuilder {
    
        public FingerprintMetadataMixIn build();
    
        @JsonProperty("parent-id")
        public FingerprintMetadataMixInBuilder setParentId(final java.util.UUID parentId);
        
    }


}

