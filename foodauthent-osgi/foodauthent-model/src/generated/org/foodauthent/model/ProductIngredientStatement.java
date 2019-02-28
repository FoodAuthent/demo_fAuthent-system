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
 * Incredient Statement by language Code
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class ProductIngredientStatement   extends FaModel {


  protected String language;
  protected String text;
  
  public String getTypeID() {
    return "ProductIngredientStatement";
  }
  

  @Override
  public java.util.UUID getFaId() {
  	return null;
  }
  
  protected ProductIngredientStatement() {}
  
  private ProductIngredientStatement(ProductIngredientStatementBuilder builder) {
    
    language = immutable(builder.language);
    text = immutable(builder.text);
    
    
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
        ProductIngredientStatement ent = (ProductIngredientStatement)o;
        return Objects.equals(language, ent.language) && Objects.equals(text, ent.text);
    }


  /**
   * Get language
   * @return language 
   */
  public String getLanguage() {
        return language;
    }
    
  /**
   * Get text
   * @return text 
   */
  public String getText() {
        return text;
    }
    
  
 	/**
  	 * @return a newly created builder
  	 */
  	public static ProductIngredientStatementBuilder builder() {
  		return new ProductIngredientStatementBuilder();
  	}
  	
  	/**
	 * Copy-builder, i.e. creates a new builder with all properties of the passed
	 * entity pre-set.
	 * 
	 * @param entity
	 *            entity to copy the properties from
	 * @return a new builder with the properties set
	 */
	public static ProductIngredientStatementBuilder builder(ProductIngredientStatement entity) {
		ProductIngredientStatementBuilder builder = builder();
        builder.language = entity.language;
        builder.text = entity.text;
 		return builder;
  	}
  	
  
    public static class ProductIngredientStatementBuilder {
    
        protected ProductIngredientStatementBuilder(){
            
        }
    
        private String language;
        private String text;

        /**
         * Get language
         * @return language 
         */
        public ProductIngredientStatementBuilder setLanguage(String language) {
             this.language = language;
             return this;
        }

        /**
         * Get text
         * @return text 
         */
        public ProductIngredientStatementBuilder setText(String text) {
             this.text = text;
             return this;
        }

        
        public ProductIngredientStatement build() {
            return new ProductIngredientStatement(this);
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
