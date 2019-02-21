/*
 * TODO	
 */
package org.foodauthent.model.json.mixin;

import java.time.OffsetDateTime;

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
    
    @JsonProperty("sampleId")
    public String getSampleId();
    
    @JsonProperty("dateOfSampleDrawing")
    public OffsetDateTime getDateOfSampleDrawing();
    
    @JsonProperty("gtin")
    public String getGtin();
    
    @JsonProperty("lot")
    public String getLot();
    
    @JsonProperty("brand")
    public String getBrand();
    
    @JsonProperty("targetMarket")
    public String getTargetMarket();
    
    @JsonProperty("samplingPlace")
    public String getSamplingPlace();
    
    @JsonProperty("labelDescription")
    public String getLabelDescription();
    
    @JsonProperty("companyName")
    public String getCompanyName();
    
    @JsonProperty("productClassification")
    public String getProductClassification();
    
    @JsonProperty("gpcAttribute")
    public String getGpcAttribute();
    
    @JsonProperty("gpcAttributeValue")
    public String getGpcAttributeValue();
    
    @JsonProperty("countryOfOrigin")
    public String getCountryOfOrigin();
    
    @JsonProperty("regionOfOriginClaims")
    public String getRegionOfOriginClaims();
    
    @JsonProperty("incredientStatementLanguageCode")
    public String getIncredientStatementLanguageCode();
    
    @JsonProperty("bestBeforeDate")
    public OffsetDateTime getBestBeforeDate();
    
    @JsonProperty("application")
    public String getApplication();
    
    @JsonProperty("typeOfAnalysis")
    public java.util.List<String> getTypeOfAnalysis();
    
    @JsonProperty("storageConditions")
    public String getStorageConditions();
    
    @JsonProperty("comment")
    public String getComment();
    

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
        
        @JsonProperty("sampleId")
        public SampleMixInBuilder setSampleId(final String sampleId);
        
        @JsonProperty("dateOfSampleDrawing")
        public SampleMixInBuilder setDateOfSampleDrawing(final OffsetDateTime dateOfSampleDrawing);
        
        @JsonProperty("gtin")
        public SampleMixInBuilder setGtin(final String gtin);
        
        @JsonProperty("lot")
        public SampleMixInBuilder setLot(final String lot);
        
        @JsonProperty("brand")
        public SampleMixInBuilder setBrand(final String brand);
        
        @JsonProperty("targetMarket")
        public SampleMixInBuilder setTargetMarket(final String targetMarket);
        
        @JsonProperty("samplingPlace")
        public SampleMixInBuilder setSamplingPlace(final String samplingPlace);
        
        @JsonProperty("labelDescription")
        public SampleMixInBuilder setLabelDescription(final String labelDescription);
        
        @JsonProperty("companyName")
        public SampleMixInBuilder setCompanyName(final String companyName);
        
        @JsonProperty("productClassification")
        public SampleMixInBuilder setProductClassification(final String productClassification);
        
        @JsonProperty("gpcAttribute")
        public SampleMixInBuilder setGpcAttribute(final String gpcAttribute);
        
        @JsonProperty("gpcAttributeValue")
        public SampleMixInBuilder setGpcAttributeValue(final String gpcAttributeValue);
        
        @JsonProperty("countryOfOrigin")
        public SampleMixInBuilder setCountryOfOrigin(final String countryOfOrigin);
        
        @JsonProperty("regionOfOriginClaims")
        public SampleMixInBuilder setRegionOfOriginClaims(final String regionOfOriginClaims);
        
        @JsonProperty("incredientStatementLanguageCode")
        public SampleMixInBuilder setIncredientStatementLanguageCode(final String incredientStatementLanguageCode);
        
        @JsonProperty("bestBeforeDate")
        public SampleMixInBuilder setBestBeforeDate(final OffsetDateTime bestBeforeDate);
        
        @JsonProperty("application")
        public SampleMixInBuilder setApplication(final String application);
        
        @JsonProperty("typeOfAnalysis")
        public SampleMixInBuilder setTypeOfAnalysis(final java.util.List<String> typeOfAnalysis);
        
        @JsonProperty("storageConditions")
        public SampleMixInBuilder setStorageConditions(final String storageConditions);
        
        @JsonProperty("comment")
        public SampleMixInBuilder setComment(final String comment);
        
    }


}

