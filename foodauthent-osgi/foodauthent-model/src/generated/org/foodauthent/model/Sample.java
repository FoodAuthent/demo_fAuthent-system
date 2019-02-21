/*
 * TODO	
 */
package org.foodauthent.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import java.time.OffsetDateTime;



/**
 * Sample
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class Sample   extends FaModel {


  protected java.util.UUID faId;
  protected String sampleId;
  protected OffsetDateTime dateOfSampleDrawing;
  protected String gtin;
  protected String lot;
  protected String brand;
  protected String targetMarket;
  protected String samplingPlace;
  protected String labelDescription;
  protected String companyName;
  protected String productClassification;
  protected String gpcAttribute;
  protected String gpcAttributeValue;
  protected String countryOfOrigin;
  protected String regionOfOriginClaims;
  protected String incredientStatementLanguageCode;
  protected OffsetDateTime bestBeforeDate;
  protected String application;
  protected java.util.List<String> typeOfAnalysis;
  protected String storageConditions;
  protected String comment;
  
  public String getTypeID() {
    return "Sample";
  }
  

  
  protected Sample() {}
  
  private Sample(SampleBuilder builder) {
    
    faId = immutable(builder.faId);
    sampleId = immutable(builder.sampleId);
    dateOfSampleDrawing = immutable(builder.dateOfSampleDrawing);
    gtin = immutable(builder.gtin);
    lot = immutable(builder.lot);
    brand = immutable(builder.brand);
    targetMarket = immutable(builder.targetMarket);
    samplingPlace = immutable(builder.samplingPlace);
    labelDescription = immutable(builder.labelDescription);
    companyName = immutable(builder.companyName);
    productClassification = immutable(builder.productClassification);
    gpcAttribute = immutable(builder.gpcAttribute);
    gpcAttributeValue = immutable(builder.gpcAttributeValue);
    countryOfOrigin = immutable(builder.countryOfOrigin);
    regionOfOriginClaims = immutable(builder.regionOfOriginClaims);
    incredientStatementLanguageCode = immutable(builder.incredientStatementLanguageCode);
    bestBeforeDate = immutable(builder.bestBeforeDate);
    application = immutable(builder.application);
    typeOfAnalysis = immutable(builder.typeOfAnalysis);
    storageConditions = immutable(builder.storageConditions);
    comment = immutable(builder.comment);
    
    faId = generateFaIdIfMissing(faId);
    
  }
  
   /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        Sample ent = (Sample)o;
        return Objects.equals(faId, ent.faId) && Objects.equals(sampleId, ent.sampleId) && Objects.equals(dateOfSampleDrawing, ent.dateOfSampleDrawing) && Objects.equals(gtin, ent.gtin) && Objects.equals(lot, ent.lot) && Objects.equals(brand, ent.brand) && Objects.equals(targetMarket, ent.targetMarket) && Objects.equals(samplingPlace, ent.samplingPlace) && Objects.equals(labelDescription, ent.labelDescription) && Objects.equals(companyName, ent.companyName) && Objects.equals(productClassification, ent.productClassification) && Objects.equals(gpcAttribute, ent.gpcAttribute) && Objects.equals(gpcAttributeValue, ent.gpcAttributeValue) && Objects.equals(countryOfOrigin, ent.countryOfOrigin) && Objects.equals(regionOfOriginClaims, ent.regionOfOriginClaims) && Objects.equals(incredientStatementLanguageCode, ent.incredientStatementLanguageCode) && Objects.equals(bestBeforeDate, ent.bestBeforeDate) && Objects.equals(application, ent.application) && Objects.equals(typeOfAnalysis, ent.typeOfAnalysis) && Objects.equals(storageConditions, ent.storageConditions) && Objects.equals(comment, ent.comment);
    }


  /**
   * A global id within the FoodAuthent-system.
   * @return faId 
   */
  public java.util.UUID getFaId() {
        return faId;
    }
    
  /**
   * Sample Id
   * @return sampleId 
   */
  public String getSampleId() {
        return sampleId;
    }
    
  /**
   * Date of Sample Drawing
   * @return dateOfSampleDrawing 
   */
  public OffsetDateTime getDateOfSampleDrawing() {
        return dateOfSampleDrawing;
    }
    
  /**
   * Global Trade Item Number
   * @return gtin 
   */
  public String getGtin() {
        return gtin;
    }
    
  /**
   * Lot
   * @return lot 
   */
  public String getLot() {
        return lot;
    }
    
  /**
   * Brand
   * @return brand 
   */
  public String getBrand() {
        return brand;
    }
    
  /**
   * Target Market
   * @return targetMarket 
   */
  public String getTargetMarket() {
        return targetMarket;
    }
    
  /**
   * Sampling Place
   * @return samplingPlace 
   */
  public String getSamplingPlace() {
        return samplingPlace;
    }
    
  /**
   * Label Description
   * @return labelDescription 
   */
  public String getLabelDescription() {
        return labelDescription;
    }
    
  /**
   * Company Name
   * @return companyName 
   */
  public String getCompanyName() {
        return companyName;
    }
    
  /**
   * Product Classification
   * @return productClassification 
   */
  public String getProductClassification() {
        return productClassification;
    }
    
  /**
   * GPC Attribute
   * @return gpcAttribute 
   */
  public String getGpcAttribute() {
        return gpcAttribute;
    }
    
  /**
   * GPC Attribute Value
   * @return gpcAttributeValue 
   */
  public String getGpcAttributeValue() {
        return gpcAttributeValue;
    }
    
  /**
   * Country Of Origin
   * @return countryOfOrigin 
   */
  public String getCountryOfOrigin() {
        return countryOfOrigin;
    }
    
  /**
   * Region Of Origin-Claims
   * @return regionOfOriginClaims 
   */
  public String getRegionOfOriginClaims() {
        return regionOfOriginClaims;
    }
    
  /**
   * Incredient Statement + language Code
   * @return incredientStatementLanguageCode 
   */
  public String getIncredientStatementLanguageCode() {
        return incredientStatementLanguageCode;
    }
    
  /**
   * Best Before Date
   * @return bestBeforeDate 
   */
  public OffsetDateTime getBestBeforeDate() {
        return bestBeforeDate;
    }
    
  /**
   * Application
   * @return application 
   */
  public String getApplication() {
        return application;
    }
    
  /**
   * Type Of Analysis
   * @return typeOfAnalysis 
   */
  public java.util.List<String> getTypeOfAnalysis() {
        return typeOfAnalysis;
    }
    
  /**
   * StorageConditions
   * @return storageConditions 
   */
  public String getStorageConditions() {
        return storageConditions;
    }
    
  /**
   * Comment
   * @return comment 
   */
  public String getComment() {
        return comment;
    }
    
  
 	/**
  	 * @return a newly created builder
  	 */
  	public static SampleBuilder builder() {
  		return new SampleBuilder();
  	}
  	
  	/**
	 * Copy-builder, i.e. creates a new builder with all properties of the passed
	 * entity pre-set.
	 * 
	 * @param entity
	 *            entity to copy the properties from
	 * @return a new builder with the properties set
	 */
	public static SampleBuilder builder(Sample entity) {
		SampleBuilder builder = builder();
        builder.faId = entity.faId;
        builder.sampleId = entity.sampleId;
        builder.dateOfSampleDrawing = entity.dateOfSampleDrawing;
        builder.gtin = entity.gtin;
        builder.lot = entity.lot;
        builder.brand = entity.brand;
        builder.targetMarket = entity.targetMarket;
        builder.samplingPlace = entity.samplingPlace;
        builder.labelDescription = entity.labelDescription;
        builder.companyName = entity.companyName;
        builder.productClassification = entity.productClassification;
        builder.gpcAttribute = entity.gpcAttribute;
        builder.gpcAttributeValue = entity.gpcAttributeValue;
        builder.countryOfOrigin = entity.countryOfOrigin;
        builder.regionOfOriginClaims = entity.regionOfOriginClaims;
        builder.incredientStatementLanguageCode = entity.incredientStatementLanguageCode;
        builder.bestBeforeDate = entity.bestBeforeDate;
        builder.application = entity.application;
        builder.typeOfAnalysis = entity.typeOfAnalysis;
        builder.storageConditions = entity.storageConditions;
        builder.comment = entity.comment;
 		return builder;
  	}
  	
  
    public static class SampleBuilder {
    
        protected SampleBuilder(){
            
        }
    
        private java.util.UUID faId;
        private String sampleId;
        private OffsetDateTime dateOfSampleDrawing;
        private String gtin;
        private String lot;
        private String brand;
        private String targetMarket;
        private String samplingPlace;
        private String labelDescription;
        private String companyName;
        private String productClassification;
        private String gpcAttribute;
        private String gpcAttributeValue;
        private String countryOfOrigin;
        private String regionOfOriginClaims;
        private String incredientStatementLanguageCode;
        private OffsetDateTime bestBeforeDate;
        private String application;
        private java.util.List<String> typeOfAnalysis = new java.util.ArrayList<>();
        private String storageConditions;
        private String comment;

        /**
         * A global id within the FoodAuthent-system.
         * @return faId 
         */
        public SampleBuilder setFaId(java.util.UUID faId) {
             this.faId = faId;
             return this;
        }

        /**
         * Sample Id
         * @return sampleId 
         */
        public SampleBuilder setSampleId(String sampleId) {
             this.sampleId = sampleId;
             return this;
        }

        /**
         * Date of Sample Drawing
         * @return dateOfSampleDrawing 
         */
        public SampleBuilder setDateOfSampleDrawing(OffsetDateTime dateOfSampleDrawing) {
             this.dateOfSampleDrawing = dateOfSampleDrawing;
             return this;
        }

        /**
         * Global Trade Item Number
         * @return gtin 
         */
        public SampleBuilder setGtin(String gtin) {
             this.gtin = gtin;
             return this;
        }

        /**
         * Lot
         * @return lot 
         */
        public SampleBuilder setLot(String lot) {
             this.lot = lot;
             return this;
        }

        /**
         * Brand
         * @return brand 
         */
        public SampleBuilder setBrand(String brand) {
             this.brand = brand;
             return this;
        }

        /**
         * Target Market
         * @return targetMarket 
         */
        public SampleBuilder setTargetMarket(String targetMarket) {
             this.targetMarket = targetMarket;
             return this;
        }

        /**
         * Sampling Place
         * @return samplingPlace 
         */
        public SampleBuilder setSamplingPlace(String samplingPlace) {
             this.samplingPlace = samplingPlace;
             return this;
        }

        /**
         * Label Description
         * @return labelDescription 
         */
        public SampleBuilder setLabelDescription(String labelDescription) {
             this.labelDescription = labelDescription;
             return this;
        }

        /**
         * Company Name
         * @return companyName 
         */
        public SampleBuilder setCompanyName(String companyName) {
             this.companyName = companyName;
             return this;
        }

        /**
         * Product Classification
         * @return productClassification 
         */
        public SampleBuilder setProductClassification(String productClassification) {
             this.productClassification = productClassification;
             return this;
        }

        /**
         * GPC Attribute
         * @return gpcAttribute 
         */
        public SampleBuilder setGpcAttribute(String gpcAttribute) {
             this.gpcAttribute = gpcAttribute;
             return this;
        }

        /**
         * GPC Attribute Value
         * @return gpcAttributeValue 
         */
        public SampleBuilder setGpcAttributeValue(String gpcAttributeValue) {
             this.gpcAttributeValue = gpcAttributeValue;
             return this;
        }

        /**
         * Country Of Origin
         * @return countryOfOrigin 
         */
        public SampleBuilder setCountryOfOrigin(String countryOfOrigin) {
             this.countryOfOrigin = countryOfOrigin;
             return this;
        }

        /**
         * Region Of Origin-Claims
         * @return regionOfOriginClaims 
         */
        public SampleBuilder setRegionOfOriginClaims(String regionOfOriginClaims) {
             this.regionOfOriginClaims = regionOfOriginClaims;
             return this;
        }

        /**
         * Incredient Statement + language Code
         * @return incredientStatementLanguageCode 
         */
        public SampleBuilder setIncredientStatementLanguageCode(String incredientStatementLanguageCode) {
             this.incredientStatementLanguageCode = incredientStatementLanguageCode;
             return this;
        }

        /**
         * Best Before Date
         * @return bestBeforeDate 
         */
        public SampleBuilder setBestBeforeDate(OffsetDateTime bestBeforeDate) {
             this.bestBeforeDate = bestBeforeDate;
             return this;
        }

        /**
         * Application
         * @return application 
         */
        public SampleBuilder setApplication(String application) {
             this.application = application;
             return this;
        }

        /**
         * Type Of Analysis
         * @return typeOfAnalysis 
         */
        public SampleBuilder setTypeOfAnalysis(java.util.List<String> typeOfAnalysis) {
             this.typeOfAnalysis = typeOfAnalysis;
             return this;
        }

        /**
         * StorageConditions
         * @return storageConditions 
         */
        public SampleBuilder setStorageConditions(String storageConditions) {
             this.storageConditions = storageConditions;
             return this;
        }

        /**
         * Comment
         * @return comment 
         */
        public SampleBuilder setComment(String comment) {
             this.comment = comment;
             return this;
        }

        
        public Sample build() {
            return new Sample(this);
        }
    
    }
    
    
    /**
     * Turns an object into an immutable one (if not already).
     * TODO move it somewhere else
     *
     * @param obj the object to treat
     * @return the object itself or a immutable copy
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static <T> T immutable(final T obj) {
        if (obj == null) {
            return null;
        } else if (obj instanceof Map) {
            return (T)Collections.unmodifiableMap(new HashMap((Map)obj));
        } else if (obj instanceof List) {
            return (T)Collections.unmodifiableList(new ArrayList((List)obj));
        } else {
            return obj;
        }
    }
    

}
