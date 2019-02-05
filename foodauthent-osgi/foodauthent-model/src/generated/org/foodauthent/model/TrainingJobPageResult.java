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

import org.foodauthent.model.TrainingJob;



/**
 * TrainingJobPageResult
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class TrainingJobPageResult   extends FaModel {


  protected Integer pageNumber;
  protected Integer pageCount;
  protected Integer resultCount;
  protected java.util.List<TrainingJob> results;
  
  public String getTypeID() {
    return "TrainingJobPageResult";
  }
  

  @Override
  public java.util.UUID getFaId() {
  	return null;
  }
  
  protected TrainingJobPageResult() {}
  
  private TrainingJobPageResult(TrainingJobPageResultBuilder builder) {
    
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
        TrainingJobPageResult ent = (TrainingJobPageResult)o;
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
  public java.util.List<TrainingJob> getResults() {
        return results;
    }
    
  
 	/**
  	 * @return a newly created builder
  	 */
  	public static TrainingJobPageResultBuilder builder() {
  		return new TrainingJobPageResultBuilder();
  	}
  	
  	/**
	 * Copy-builder, i.e. creates a new builder with all properties of the passed
	 * entity pre-set.
	 * 
	 * @param entity
	 *            entity to copy the properties from
	 * @return a new builder with the properties set
	 */
	public static TrainingJobPageResultBuilder builder(TrainingJobPageResult entity) {
		TrainingJobPageResultBuilder builder = builder();
        builder.pageNumber = entity.pageNumber;
        builder.pageCount = entity.pageCount;
        builder.resultCount = entity.resultCount;
        builder.results = entity.results;
 		return builder;
  	}
  	
  
    public static class TrainingJobPageResultBuilder {
    
        protected TrainingJobPageResultBuilder(){
            
        }
    
        private Integer pageNumber;
        private Integer pageCount;
        private Integer resultCount;
        private java.util.List<TrainingJob> results = new java.util.ArrayList<>();

        /**
         * Get pageNumber
         * @return pageNumber 
         */
        public TrainingJobPageResultBuilder setPageNumber(Integer pageNumber) {
             this.pageNumber = pageNumber;
             return this;
        }

        /**
         * Get pageCount
         * @return pageCount 
         */
        public TrainingJobPageResultBuilder setPageCount(Integer pageCount) {
             this.pageCount = pageCount;
             return this;
        }

        /**
         * Get resultCount
         * @return resultCount 
         */
        public TrainingJobPageResultBuilder setResultCount(Integer resultCount) {
             this.resultCount = resultCount;
             return this;
        }

        /**
         * Get results
         * @return results 
         */
        public TrainingJobPageResultBuilder setResults(java.util.List<TrainingJob> results) {
             this.results = results;
             return this;
        }

        
        public TrainingJobPageResult build() {
            return new TrainingJobPageResult(this);
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
