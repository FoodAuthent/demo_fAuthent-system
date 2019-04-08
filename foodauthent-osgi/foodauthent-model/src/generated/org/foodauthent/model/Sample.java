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
  protected java.util.UUID productId;
  protected String sampleId;
  protected OffsetDateTime dateOfSampleDrawing;
  protected String lot;
  protected String samplingPlace;
  protected OffsetDateTime bestBeforeDate;
  protected String application;
  protected java.util.List<String> typeOfAnalysis;
  protected String comment;
  
  public String getTypeID() {
    return "Sample";
  }
  

  
  protected Sample() {}
  
  private Sample(SampleBuilder builder) {
    
    faId = immutable(builder.faId);
    productId = immutable(builder.productId);
    sampleId = immutable(builder.sampleId);
    dateOfSampleDrawing = immutable(builder.dateOfSampleDrawing);
    lot = immutable(builder.lot);
    samplingPlace = immutable(builder.samplingPlace);
    bestBeforeDate = immutable(builder.bestBeforeDate);
    application = immutable(builder.application);
    typeOfAnalysis = immutable(builder.typeOfAnalysis);
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
        return Objects.equals(faId, ent.faId) && Objects.equals(productId, ent.productId) && Objects.equals(sampleId, ent.sampleId) && Objects.equals(dateOfSampleDrawing, ent.dateOfSampleDrawing) && Objects.equals(lot, ent.lot) && Objects.equals(samplingPlace, ent.samplingPlace) && Objects.equals(bestBeforeDate, ent.bestBeforeDate) && Objects.equals(application, ent.application) && Objects.equals(typeOfAnalysis, ent.typeOfAnalysis) && Objects.equals(comment, ent.comment);
    }


  /**
   * A global id within the FoodAuthent-system.
   * @return faId 
   */
  public java.util.UUID getFaId() {
        return faId;
    }
    
  /**
   * referenced product fa-id
   * @return productId 
   */
  public java.util.UUID getProductId() {
        return productId;
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
   * Lot
   * @return lot 
   */
  public String getLot() {
        return lot;
    }
    
  /**
   * Sampling Place
   * @return samplingPlace 
   */
  public String getSamplingPlace() {
        return samplingPlace;
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
        builder.productId = entity.productId;
        builder.sampleId = entity.sampleId;
        builder.dateOfSampleDrawing = entity.dateOfSampleDrawing;
        builder.lot = entity.lot;
        builder.samplingPlace = entity.samplingPlace;
        builder.bestBeforeDate = entity.bestBeforeDate;
        builder.application = entity.application;
        builder.typeOfAnalysis = entity.typeOfAnalysis;
        builder.comment = entity.comment;
 		return builder;
  	}
  	
  
    public static class SampleBuilder {
    
        protected SampleBuilder(){
            
        }
    
        private java.util.UUID faId;
        private java.util.UUID productId;
        private String sampleId;
        private OffsetDateTime dateOfSampleDrawing;
        private String lot;
        private String samplingPlace;
        private OffsetDateTime bestBeforeDate;
        private String application;
        private java.util.List<String> typeOfAnalysis = new java.util.ArrayList<>();
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
         * referenced product fa-id
         * @return productId 
         */
        public SampleBuilder setProductId(java.util.UUID productId) {
             this.productId = productId;
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
         * Lot
         * @return lot 
         */
        public SampleBuilder setLot(String lot) {
             this.lot = lot;
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