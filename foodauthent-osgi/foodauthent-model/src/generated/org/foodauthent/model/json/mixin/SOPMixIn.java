/*
 * TODO	
 */
package org.foodauthent.model.json.mixin;

import org.foodauthent.model.SOP;
import org.foodauthent.model.SOP.SOPBuilder;

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
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "", visible = true, defaultImpl = SOP.class)
@JsonSubTypes({ @Type(value = SOP.class, name = "SOP") })
@JsonDeserialize(builder = SOPBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface SOPMixIn {

    @JsonIgnore
    public long getPersistenceId();

    @JsonIgnore
    public String getTypeID();

    @JsonProperty("fa-id")
    public java.util.UUID getFaId();

    @JsonProperty("file-link")
    public String getFileLink();

    @JsonProperty("name")
    public String getName();

    @JsonProperty("description")
    public String getDescription();

    @JsonProperty("product-id")
    public java.util.UUID getProductId();

    /**
     * MixIn class for entity builder implementations that adds jackson annotations
     * for the de-/serialization.
     *
     * @author Martin Horn, University of Konstanz
     */
    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "", defaultImpl = SOPBuilder.class)
    @JsonSubTypes({ @Type(value = SOP.SOPBuilder.class, name = "SOP") })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface SOPMixInBuilder {

	public SOPMixIn build();

	@JsonProperty("fa-id")
	public SOPMixInBuilder setFaId(final java.util.UUID faId);

	@JsonProperty("file-link")
	public SOPMixInBuilder setFileLink(final String fileLink);

	@JsonProperty("name")
	public SOPMixInBuilder setName(final String name);

	@JsonProperty("description")
	public SOPMixInBuilder setDescription(final String description);

	@JsonProperty("product-id")
	public SOPMixInBuilder setProductId(final java.util.UUID productId);

    }

}
