/*
 * TODO	
 */
package org.foodauthent.model.json.mixin;

import org.foodauthent.model.FingerprintRawData;
import org.foodauthent.model.FingerprintRawData.FingerprintRawDataBuilder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * MixIn class for entity implementations that adds jackson annotations for
 * de-/serialization.
 *
 * @author Martin Horn, University of Konstanz
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "", visible = true, defaultImpl = FingerprintRawData.class)
@JsonSubTypes({ @Type(value = FingerprintRawData.class, name = "FingerprintRawData") })
@JsonDeserialize(builder = FingerprintRawDataBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface FingerprintRawDataMixIn {

    @JsonIgnore
    public long getPersistenceId();

    @JsonIgnore
    public String getTypeID();

    @JsonProperty("fa-id")
    public java.util.UUID getFaId();

    @JsonProperty("parent-id")
    public java.util.UUID getParentId();

    @JsonProperty("data")
    public byte[] getData();

    /**
     * MixIn class for entity builder implementations that adds jackson annotations
     * for the de-/serialization.
     *
     * @author Martin Horn, University of Konstanz
     */
    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "", defaultImpl = FingerprintRawDataBuilder.class)
    @JsonSubTypes({ @Type(value = FingerprintRawData.FingerprintRawDataBuilder.class, name = "FingerprintRawData") })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface FingerprintRawDataMixInBuilder {

	public FingerprintRawDataMixIn build();

	@JsonProperty("fa-id")
	public FingerprintRawDataMixInBuilder setFaId(final java.util.UUID faId);

	@JsonProperty("parent-id")
	public FingerprintRawDataMixInBuilder setParentId(final java.util.UUID parentId);

	@JsonProperty("data")
	public FingerprintRawDataMixInBuilder setData(final byte[] data);

    }

}
