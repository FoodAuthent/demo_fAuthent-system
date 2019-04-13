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




/**
 * The system status with some statistics etc.
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class SystemInfo   extends FaModel {


  protected Long numSops;
  protected Long numFiles;
  protected Long numProducts;
  protected Long numFingerprints;
  protected Long numFingerprintsets;
  protected Long numWorkflows;
  protected Long numSamples;
  protected Long numPredictions;
  protected Long numModels;
  
  public String getTypeID() {
    return "SystemInfo";
  }
  

  @Override
  public java.util.UUID getFaId() {
  	return null;
  }
  
  protected SystemInfo() {}
  
  private SystemInfo(SystemInfoBuilder builder) {
    
    numSops = immutable(builder.numSops);
    numFiles = immutable(builder.numFiles);
    numProducts = immutable(builder.numProducts);
    numFingerprints = immutable(builder.numFingerprints);
    numFingerprintsets = immutable(builder.numFingerprintsets);
    numWorkflows = immutable(builder.numWorkflows);
    numSamples = immutable(builder.numSamples);
    numPredictions = immutable(builder.numPredictions);
    numModels = immutable(builder.numModels);
    
    
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
        SystemInfo ent = (SystemInfo)o;
        return Objects.equals(numSops, ent.numSops) && Objects.equals(numFiles, ent.numFiles) && Objects.equals(numProducts, ent.numProducts) && Objects.equals(numFingerprints, ent.numFingerprints) && Objects.equals(numFingerprintsets, ent.numFingerprintsets) && Objects.equals(numWorkflows, ent.numWorkflows) && Objects.equals(numSamples, ent.numSamples) && Objects.equals(numPredictions, ent.numPredictions) && Objects.equals(numModels, ent.numModels);
    }


  /**
   * Get numSops
   * @return numSops 
   */
  public Long getNumSops() {
        return numSops;
    }
    
  /**
   * Get numFiles
   * @return numFiles 
   */
  public Long getNumFiles() {
        return numFiles;
    }
    
  /**
   * Get numProducts
   * @return numProducts 
   */
  public Long getNumProducts() {
        return numProducts;
    }
    
  /**
   * Get numFingerprints
   * @return numFingerprints 
   */
  public Long getNumFingerprints() {
        return numFingerprints;
    }
    
  /**
   * Get numFingerprintsets
   * @return numFingerprintsets 
   */
  public Long getNumFingerprintsets() {
        return numFingerprintsets;
    }
    
  /**
   * Get numWorkflows
   * @return numWorkflows 
   */
  public Long getNumWorkflows() {
        return numWorkflows;
    }
    
  /**
   * Get numSamples
   * @return numSamples 
   */
  public Long getNumSamples() {
        return numSamples;
    }
    
  /**
   * Get numPredictions
   * @return numPredictions 
   */
  public Long getNumPredictions() {
        return numPredictions;
    }
    
  /**
   * Get numModels
   * @return numModels 
   */
  public Long getNumModels() {
        return numModels;
    }
    
  
 	/**
  	 * @return a newly created builder
  	 */
  	public static SystemInfoBuilder builder() {
  		return new SystemInfoBuilder();
  	}
  	
  	/**
	 * Copy-builder, i.e. creates a new builder with all properties of the passed
	 * entity pre-set.
	 * 
	 * @param entity
	 *            entity to copy the properties from
	 * @return a new builder with the properties set
	 */
	public static SystemInfoBuilder builder(SystemInfo entity) {
		SystemInfoBuilder builder = builder();
        builder.numSops = entity.numSops;
        builder.numFiles = entity.numFiles;
        builder.numProducts = entity.numProducts;
        builder.numFingerprints = entity.numFingerprints;
        builder.numFingerprintsets = entity.numFingerprintsets;
        builder.numWorkflows = entity.numWorkflows;
        builder.numSamples = entity.numSamples;
        builder.numPredictions = entity.numPredictions;
        builder.numModels = entity.numModels;
 		return builder;
  	}
  	
  
    public static class SystemInfoBuilder {
    
        protected SystemInfoBuilder(){
            
        }
    
        private Long numSops;
        private Long numFiles;
        private Long numProducts;
        private Long numFingerprints;
        private Long numFingerprintsets;
        private Long numWorkflows;
        private Long numSamples;
        private Long numPredictions;
        private Long numModels;

        /**
         * Get numSops
         * @return numSops 
         */
        public SystemInfoBuilder setNumSops(Long numSops) {
             this.numSops = numSops;
             return this;
        }

        /**
         * Get numFiles
         * @return numFiles 
         */
        public SystemInfoBuilder setNumFiles(Long numFiles) {
             this.numFiles = numFiles;
             return this;
        }

        /**
         * Get numProducts
         * @return numProducts 
         */
        public SystemInfoBuilder setNumProducts(Long numProducts) {
             this.numProducts = numProducts;
             return this;
        }

        /**
         * Get numFingerprints
         * @return numFingerprints 
         */
        public SystemInfoBuilder setNumFingerprints(Long numFingerprints) {
             this.numFingerprints = numFingerprints;
             return this;
        }

        /**
         * Get numFingerprintsets
         * @return numFingerprintsets 
         */
        public SystemInfoBuilder setNumFingerprintsets(Long numFingerprintsets) {
             this.numFingerprintsets = numFingerprintsets;
             return this;
        }

        /**
         * Get numWorkflows
         * @return numWorkflows 
         */
        public SystemInfoBuilder setNumWorkflows(Long numWorkflows) {
             this.numWorkflows = numWorkflows;
             return this;
        }

        /**
         * Get numSamples
         * @return numSamples 
         */
        public SystemInfoBuilder setNumSamples(Long numSamples) {
             this.numSamples = numSamples;
             return this;
        }

        /**
         * Get numPredictions
         * @return numPredictions 
         */
        public SystemInfoBuilder setNumPredictions(Long numPredictions) {
             this.numPredictions = numPredictions;
             return this;
        }

        /**
         * Get numModels
         * @return numModels 
         */
        public SystemInfoBuilder setNumModels(Long numModels) {
             this.numModels = numModels;
             return this;
        }

        
        public SystemInfo build() {
            return new SystemInfo(this);
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
