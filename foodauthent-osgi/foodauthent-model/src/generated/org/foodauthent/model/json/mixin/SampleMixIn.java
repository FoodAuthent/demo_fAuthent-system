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



import org.foodauthent.model.Sample;
import org.foodauthent.model.Sample.SampleBuilder;

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
    defaultImpl = Sample.class)
@JsonSubTypes({
    @Type(value = Sample.class, name="Sample")
})
@JsonDeserialize(builder=SampleBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface SampleMixIn {

	@JsonIgnore
	public long getPersistenceId();
	
    @JsonIgnore
    public String getTypeID();
    
    

    @JsonProperty("fa-id")
    public java.util.UUID getFaId();
    
    @JsonProperty("product-id")
    public java.util.UUID getProductId();
    
    @JsonProperty("sop-id")
    public java.util.UUID getSopId();
    
    @JsonProperty("sampleId")
    public String getSampleId();
    
    @JsonProperty("dateOfSampleDrawing")
    public String getDateOfSampleDrawing();
    
    @JsonProperty("lot")
    public String getLot();
    
    @JsonProperty("samplingPlace")
    public String getSamplingPlace();
    
    @JsonProperty("bestBeforeDate")
    public String getBestBeforeDate();
    
    @JsonProperty("application")
    public String getApplication();
    
    @JsonProperty("comments")
    public java.util.List<String> getComments();
    

    /**
     * MixIn class for entity builder implementations that adds jackson annotations for the de-/serialization.
     *
     * @author Martin Horn, University of Konstanz
     */
    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "",
        defaultImpl = SampleBuilder.class)
    @JsonSubTypes({
        @Type(value = Sample.SampleBuilder.class, name="Sample")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface SampleMixInBuilder {
    
        public SampleMixIn build();
    
        @JsonProperty("fa-id")
        public SampleMixInBuilder setFaId(final java.util.UUID faId);
        
        @JsonProperty("product-id")
        public SampleMixInBuilder setProductId(final java.util.UUID productId);
        
        @JsonProperty("sop-id")
        public SampleMixInBuilder setSopId(final java.util.UUID sopId);
        
        @JsonProperty("sampleId")
        public SampleMixInBuilder setSampleId(final String sampleId);
        
        @JsonProperty("dateOfSampleDrawing")
        public SampleMixInBuilder setDateOfSampleDrawing(final String dateOfSampleDrawing);
        
        @JsonProperty("lot")
        public SampleMixInBuilder setLot(final String lot);
        
        @JsonProperty("samplingPlace")
        public SampleMixInBuilder setSamplingPlace(final String samplingPlace);
        
        @JsonProperty("bestBeforeDate")
        public SampleMixInBuilder setBestBeforeDate(final String bestBeforeDate);
        
        @JsonProperty("application")
        public SampleMixInBuilder setApplication(final String application);
        
        @JsonProperty("comments")
        public SampleMixInBuilder setComments(final java.util.List<String> comments);
        
    }


}

