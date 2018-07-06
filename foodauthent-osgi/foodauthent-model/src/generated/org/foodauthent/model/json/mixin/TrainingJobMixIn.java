/*
 * TODO	
 */
package org.foodauthent.model.json.mixin;

import org.foodauthent.model.TrainingJob;
import org.foodauthent.model.TrainingJob.StatusEnum;
import org.foodauthent.model.TrainingJob.TrainingJobBuilder;

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
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "", visible = true, defaultImpl = TrainingJob.class)
@JsonSubTypes({ @Type(value = TrainingJob.class, name = "TrainingJob") })
@JsonDeserialize(builder = TrainingJobBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface TrainingJobMixIn {

    @JsonIgnore
    public long getPersistenceId();

    @JsonIgnore
    public String getTypeID();

    @JsonProperty("fa-id")
    public java.util.UUID getFaId();

    @JsonProperty("worklfow-id")
    public java.util.UUID getWorklfowId();

    @JsonProperty("fingerprintset-id")
    public java.util.UUID getFingerprintsetId();

    @JsonProperty("prediction-workflow-id")
    public java.util.UUID getPredictionWorkflowId();

    @JsonProperty("status")
    public StatusEnum getStatus();

    /**
     * MixIn class for entity builder implementations that adds jackson annotations
     * for the de-/serialization.
     *
     * @author Martin Horn, University of Konstanz
     */
    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "", defaultImpl = TrainingJobBuilder.class)
    @JsonSubTypes({ @Type(value = TrainingJob.TrainingJobBuilder.class, name = "TrainingJob") })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface TrainingJobMixInBuilder {

	public TrainingJobMixIn build();

	@JsonProperty("fa-id")
	public TrainingJobMixInBuilder setFaId(final java.util.UUID faId);

	@JsonProperty("worklfow-id")
	public TrainingJobMixInBuilder setWorklfowId(final java.util.UUID worklfowId);

	@JsonProperty("fingerprintset-id")
	public TrainingJobMixInBuilder setFingerprintsetId(final java.util.UUID fingerprintsetId);

	@JsonProperty("prediction-workflow-id")
	public TrainingJobMixInBuilder setPredictionWorkflowId(final java.util.UUID predictionWorkflowId);

	@JsonProperty("status")
	public TrainingJobMixInBuilder setStatus(final StatusEnum status);

    }

}
