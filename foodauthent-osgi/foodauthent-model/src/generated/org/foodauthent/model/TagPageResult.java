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

import org.foodauthent.model.Tag;



/**
 * TagPageResult
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class TagPageResult   extends FaModel {


  protected Integer pageNumber;
  protected Integer pageCount;
  protected Integer resultCount;
  protected java.util.List<Tag> results;
  
  public String getTypeID() {
    return "TagPageResult";
  }
  

  @Override
  public java.util.UUID getFaId() {
  	return null;
  }
  
  protected TagPageResult() {}
  
  private TagPageResult(TagPageResultBuilder builder) {
    
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
        TagPageResult ent = (TagPageResult)o;
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
  public java.util.List<Tag> getResults() {
        return results;
    }
    
  
 	/**
  	 * @return a newly created builder
  	 */
  	public static TagPageResultBuilder builder() {
  		return new TagPageResultBuilder();
  	}
  	
  	/**
	 * Copy-builder, i.e. creates a new builder with all properties of the passed
	 * entity pre-set.
	 * 
	 * @param entity
	 *            entity to copy the properties from
	 * @return a new builder with the properties set
	 */
	public static TagPageResultBuilder builder(TagPageResult entity) {
		TagPageResultBuilder builder = builder();
        builder.pageNumber = entity.pageNumber;
        builder.pageCount = entity.pageCount;
        builder.resultCount = entity.resultCount;
        builder.results = entity.results;
 		return builder;
  	}
  	
  
    public static class TagPageResultBuilder {
    
        protected TagPageResultBuilder(){
            
        }
    
        private Integer pageNumber;
        private Integer pageCount;
        private Integer resultCount;
        private java.util.List<Tag> results = new java.util.ArrayList<>();

        /**
         * Get pageNumber
         * @return pageNumber 
         */
        public TagPageResultBuilder setPageNumber(Integer pageNumber) {
             this.pageNumber = pageNumber;
             return this;
        }

        /**
         * Get pageCount
         * @return pageCount 
         */
        public TagPageResultBuilder setPageCount(Integer pageCount) {
             this.pageCount = pageCount;
             return this;
        }

        /**
         * Get resultCount
         * @return resultCount 
         */
        public TagPageResultBuilder setResultCount(Integer resultCount) {
             this.resultCount = resultCount;
             return this;
        }

        /**
         * Get results
         * @return results 
         */
        public TagPageResultBuilder setResults(java.util.List<Tag> results) {
             this.results = results;
             return this;
        }

        
        public TagPageResult build() {
            return new TagPageResult(this);
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
