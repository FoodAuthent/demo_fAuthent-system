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
 * Global product metadata, e.g., country of origin, etc. There can be multiple fingerprints for one product.
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class Product   extends FaModel {


  private java.util.UUID faId;
  private String gtin;
  private String name;
  private String description;
  private String ingredients;
  private String brand;
  
  public String getTypeID() {
    return "Product";
  }
  

  
  private Product(ProductBuilder builder) {
    
    faId = immutable(builder.faId);
    gtin = immutable(builder.gtin);
    name = immutable(builder.name);
    description = immutable(builder.description);
    ingredients = immutable(builder.ingredients);
    brand = immutable(builder.brand);
    
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
        Product ent = (Product)o;
        return Objects.equals(faId, ent.faId) && Objects.equals(gtin, ent.gtin) && Objects.equals(name, ent.name) && Objects.equals(description, ent.description) && Objects.equals(ingredients, ent.ingredients) && Objects.equals(brand, ent.brand);
    }


  /**
   * A global id within the FoodAuthent-system.
   * @return faId 
   */
  public java.util.UUID getFaId() {
        return faId;
    }
    
  /**
   * Get gtin
   * @return gtin 
   */
  public String getGtin() {
        return gtin;
    }
    
  /**
   * Get name
   * @return name 
   */
  public String getName() {
        return name;
    }
    
  /**
   * Get description
   * @return description 
   */
  public String getDescription() {
        return description;
    }
    
  /**
   * Get ingredients
   * @return ingredients 
   */
  public String getIngredients() {
        return ingredients;
    }
    
  /**
   * Get brand
   * @return brand 
   */
  public String getBrand() {
        return brand;
    }
    
  
 	/**
  	 * @return a newly created builder
  	 */
  	public static ProductBuilder builder() {
  		return new ProductBuilder();
  	}
  	
  	/**
	 * Copy-builder, i.e. creates a new builder with all properties of the passed
	 * entity pre-set.
	 * 
	 * @param entity
	 *            entity to copy the properties from
	 * @return a new builder with the properties set
	 */
	public static ProductBuilder builder(Product entity) {
		ProductBuilder builder = builder();
        builder.faId = entity.faId;
        builder.gtin = entity.gtin;
        builder.name = entity.name;
        builder.description = entity.description;
        builder.ingredients = entity.ingredients;
        builder.brand = entity.brand;
 		return builder;
  	}
  	
  
    public static class ProductBuilder {
    
        private ProductBuilder(){
            
        }
    
        private java.util.UUID faId = null;
        private String gtin = null;
        private String name = null;
        private String description = null;
        private String ingredients = null;
        private String brand = null;

        /**
         * A global id within the FoodAuthent-system.
         * @return faId 
         */
        public ProductBuilder setFaId(java.util.UUID faId) {
             this.faId = faId;
             return this;
        }

        /**
         * Get gtin
         * @return gtin 
         */
        public ProductBuilder setGtin(String gtin) {
             this.gtin = gtin;
             return this;
        }

        /**
         * Get name
         * @return name 
         */
        public ProductBuilder setName(String name) {
             this.name = name;
             return this;
        }

        /**
         * Get description
         * @return description 
         */
        public ProductBuilder setDescription(String description) {
             this.description = description;
             return this;
        }

        /**
         * Get ingredients
         * @return ingredients 
         */
        public ProductBuilder setIngredients(String ingredients) {
             this.ingredients = ingredients;
             return this;
        }

        /**
         * Get brand
         * @return brand 
         */
        public ProductBuilder setBrand(String brand) {
             this.brand = brand;
             return this;
        }

        
        public Product build() {
            return new Product(this);
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
