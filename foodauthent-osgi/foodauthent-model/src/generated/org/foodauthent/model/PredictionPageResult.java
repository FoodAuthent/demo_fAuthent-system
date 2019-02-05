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

import org.foodauthent.model.Prediction;



/**
 * PredictionPageResult
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class PredictionPageResult   extends FaModel {


  protected Integer pageNumber;
  protected Integer pageCount;
  protected Integer resultCount;
  protected java.util.List<Prediction> results;
  
  public String getTypeID() {
    return "PredictionPageResult";
  }
  

  @Override
  public java.util.UUID getFaId() {
  	return null;
  }
  
  protected PredictionPageResult() {}
  
  private PredictionPageResult(PredictionPageResultBuilder builder) {
    
    pageNumber = immutable(builder.pageNumber);
    pageCount = immutable(builder.pageCount);
    resultCount = immutable(builder.resultCount);
    results = immutable(builder.results);
    
    
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
        PredictionPageResult ent = (PredictionPageResult)o;
        return Objects.equals(pageNumber, ent.pageNumber) && Objects.equals(pageCount, ent.pageCount) && Objects.equals(resultCount, ent.resultCount) && Objects.equals(results, ent.results);
    }


  /**
   * Get pageNumber
   * @return pageNumber 
   */
  public Integer getPageNumber() {
        return pageNumber;
    }
    
  /**
   * Get pageCount
   * @return pageCount 
   */
  public Integer getPageCount() {
        return pageCount;
    }
    
  /**
   * Get resultCount
   * @return resultCount 
   */
  public Integer getResultCount() {
        return resultCount;
    }
    
  /**
   * Get results
   * @return results 
   */
  public java.util.List<Prediction> getResults() {
        return results;
    }
    
  
 	/**
  	 * @return a newly created builder
  	 */
  	public static PredictionPageResultBuilder builder() {
  		return new PredictionPageResultBuilder();
  	}
  	
  	/**
	 * Copy-builder, i.e. creates a new builder with all properties of the passed
	 * entity pre-set.
	 * 
	 * @param entity
	 *            entity to copy the properties from
	 * @return a new builder with the properties set
	 */
	public static PredictionPageResultBuilder builder(PredictionPageResult entity) {
		PredictionPageResultBuilder builder = builder();
        builder.pageNumber = entity.pageNumber;
        builder.pageCount = entity.pageCount;
        builder.resultCount = entity.resultCount;
        builder.results = entity.results;
 		return builder;
  	}
  	
  
    public static class PredictionPageResultBuilder {
    
        protected PredictionPageResultBuilder(){
            
        }
    
        private Integer pageNumber;
        private Integer pageCount;
        private Integer resultCount;
        private java.util.List<Prediction> results = new java.util.ArrayList<>();

        /**
         * Get pageNumber
         * @return pageNumber 
         */
        public PredictionPageResultBuilder setPageNumber(Integer pageNumber) {
             this.pageNumber = pageNumber;
             return this;
        }

        /**
         * Get pageCount
         * @return pageCount 
         */
        public PredictionPageResultBuilder setPageCount(Integer pageCount) {
             this.pageCount = pageCount;
             return this;
        }

        /**
         * Get resultCount
         * @return resultCount 
         */
        public PredictionPageResultBuilder setResultCount(Integer resultCount) {
             this.resultCount = resultCount;
             return this;
        }

        /**
         * Get results
         * @return results 
         */
        public PredictionPageResultBuilder setResults(java.util.List<Prediction> results) {
             this.results = results;
             return this;
        }

        
        public PredictionPageResult build() {
            return new PredictionPageResult(this);
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
