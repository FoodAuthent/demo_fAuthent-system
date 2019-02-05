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

import org.foodauthent.model.Product;



/**
 * ProductPageResult
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class ProductPageResult   extends FaModel {


  protected Integer pageNumber;
  protected Integer pageCount;
  protected Integer resultCount;
  protected java.util.List<Product> results;
  
  public String getTypeID() {
    return "ProductPageResult";
  }
  

  @Override
  public java.util.UUID getFaId() {
  	return null;
  }
  
  protected ProductPageResult() {}
  
  private ProductPageResult(ProductPageResultBuilder builder) {
    
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
        ProductPageResult ent = (ProductPageResult)o;
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
  public java.util.List<Product> getResults() {
        return results;
    }
    
  
 	/**
  	 * @return a newly created builder
  	 */
  	public static ProductPageResultBuilder builder() {
  		return new ProductPageResultBuilder();
  	}
  	
  	/**
	 * Copy-builder, i.e. creates a new builder with all properties of the passed
	 * entity pre-set.
	 * 
	 * @param entity
	 *            entity to copy the properties from
	 * @return a new builder with the properties set
	 */
	public static ProductPageResultBuilder builder(ProductPageResult entity) {
		ProductPageResultBuilder builder = builder();
        builder.pageNumber = entity.pageNumber;
        builder.pageCount = entity.pageCount;
        builder.resultCount = entity.resultCount;
        builder.results = entity.results;
 		return builder;
  	}
  	
  
    public static class ProductPageResultBuilder {
    
        protected ProductPageResultBuilder(){
            
        }
    
        private Integer pageNumber;
        private Integer pageCount;
        private Integer resultCount;
        private java.util.List<Product> results = new java.util.ArrayList<>();

        /**
         * Get pageNumber
         * @return pageNumber 
         */
        public ProductPageResultBuilder setPageNumber(Integer pageNumber) {
             this.pageNumber = pageNumber;
             return this;
        }

        /**
         * Get pageCount
         * @return pageCount 
         */
        public ProductPageResultBuilder setPageCount(Integer pageCount) {
             this.pageCount = pageCount;
             return this;
        }

        /**
         * Get resultCount
         * @return resultCount 
         */
        public ProductPageResultBuilder setResultCount(Integer resultCount) {
             this.resultCount = resultCount;
             return this;
        }

        /**
         * Get results
         * @return results 
         */
        public ProductPageResultBuilder setResults(java.util.List<Product> results) {
             this.results = results;
             return this;
        }

        
        public ProductPageResult build() {
            return new ProductPageResult(this);
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
