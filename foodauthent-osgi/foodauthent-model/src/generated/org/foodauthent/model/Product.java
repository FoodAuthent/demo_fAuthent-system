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

import org.foodauthent.model.GPCBrick;
import org.foodauthent.model.ProductIngredientStatement;



/**
 * Global product metadata, e.g., country of origin, etc. There can be multiple fingerprints for one product.
 *
 * @author Martin Horn, University of Konstanz
 */
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public class Product   extends FaModel {


  protected java.util.UUID faId;
  protected String gtin;
  protected String brand;
  protected String targetMarket;
  protected String labelDescription;
  protected String companyName;
  protected String productClassification;
  protected String countryOfOrigin;
  protected String regionOfOriginClaims;
  protected ProductIngredientStatement ingredientStatement;
  protected String comment;
  protected java.util.List<GPCBrick> gpcBricks;
  
  public String getTypeID() {
    return "Product";
  }
  

  
  protected Product() {}
  
  private Product(ProductBuilder builder) {
    
    faId = immutable(builder.faId);
    gtin = immutable(builder.gtin);
    brand = immutable(builder.brand);
    targetMarket = immutable(builder.targetMarket);
    labelDescription = immutable(builder.labelDescription);
    companyName = immutable(builder.companyName);
    productClassification = immutable(builder.productClassification);
    countryOfOrigin = immutable(builder.countryOfOrigin);
    regionOfOriginClaims = immutable(builder.regionOfOriginClaims);
    ingredientStatement = immutable(builder.ingredientStatement);
    comment = immutable(builder.comment);
    gpcBricks = immutable(builder.gpcBricks);
    
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
        return Objects.equals(faId, ent.faId) && Objects.equals(gtin, ent.gtin) && Objects.equals(brand, ent.brand) && Objects.equals(targetMarket, ent.targetMarket) && Objects.equals(labelDescription, ent.labelDescription) && Objects.equals(companyName, ent.companyName) && Objects.equals(productClassification, ent.productClassification) && Objects.equals(countryOfOrigin, ent.countryOfOrigin) && Objects.equals(regionOfOriginClaims, ent.regionOfOriginClaims) && Objects.equals(ingredientStatement, ent.ingredientStatement) && Objects.equals(comment, ent.comment) && Objects.equals(gpcBricks, ent.gpcBricks);
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
   * Get ingredientStatement
   * @return ingredientStatement 
   */
  public ProductIngredientStatement getIngredientStatement() {
        return ingredientStatement;
    }
    
  /**
   * Comment
   * @return comment 
   */
  public String getComment() {
        return comment;
    }
    
  /**
   * Get gpcBricks
   * @return gpcBricks 
   */
  public java.util.List<GPCBrick> getGpcBricks() {
        return gpcBricks;
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
        builder.brand = entity.brand;
        builder.targetMarket = entity.targetMarket;
        builder.labelDescription = entity.labelDescription;
        builder.companyName = entity.companyName;
        builder.productClassification = entity.productClassification;
        builder.countryOfOrigin = entity.countryOfOrigin;
        builder.regionOfOriginClaims = entity.regionOfOriginClaims;
        builder.ingredientStatement = entity.ingredientStatement;
        builder.comment = entity.comment;
        builder.gpcBricks = entity.gpcBricks;
 		return builder;
  	}
  	
  
    public static class ProductBuilder {
    
        protected ProductBuilder(){
            
        }
    
        private java.util.UUID faId;
        private String gtin;
        private String brand;
        private String targetMarket;
        private String labelDescription;
        private String companyName;
        private String productClassification;
        private String countryOfOrigin;
        private String regionOfOriginClaims;
        private ProductIngredientStatement ingredientStatement;
        private String comment;
        private java.util.List<GPCBrick> gpcBricks = new java.util.ArrayList<>();

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
         * Brand
         * @return brand 
         */
        public ProductBuilder setBrand(String brand) {
             this.brand = brand;
             return this;
        }

        /**
         * Target Market
         * @return targetMarket 
         */
        public ProductBuilder setTargetMarket(String targetMarket) {
             this.targetMarket = targetMarket;
             return this;
        }

        /**
         * Label Description
         * @return labelDescription 
         */
        public ProductBuilder setLabelDescription(String labelDescription) {
             this.labelDescription = labelDescription;
             return this;
        }

        /**
         * Company Name
         * @return companyName 
         */
        public ProductBuilder setCompanyName(String companyName) {
             this.companyName = companyName;
             return this;
        }

        /**
         * Product Classification
         * @return productClassification 
         */
        public ProductBuilder setProductClassification(String productClassification) {
             this.productClassification = productClassification;
             return this;
        }

        /**
         * Country Of Origin
         * @return countryOfOrigin 
         */
        public ProductBuilder setCountryOfOrigin(String countryOfOrigin) {
             this.countryOfOrigin = countryOfOrigin;
             return this;
        }

        /**
         * Region Of Origin-Claims
         * @return regionOfOriginClaims 
         */
        public ProductBuilder setRegionOfOriginClaims(String regionOfOriginClaims) {
             this.regionOfOriginClaims = regionOfOriginClaims;
             return this;
        }

        /**
         * Get ingredientStatement
         * @return ingredientStatement 
         */
        public ProductBuilder setIngredientStatement(ProductIngredientStatement ingredientStatement) {
             this.ingredientStatement = ingredientStatement;
             return this;
        }

        /**
         * Comment
         * @return comment 
         */
        public ProductBuilder setComment(String comment) {
             this.comment = comment;
             return this;
        }

        /**
         * Get gpcBricks
         * @return gpcBricks 
         */
        public ProductBuilder setGpcBricks(java.util.List<GPCBrick> gpcBricks) {
             this.gpcBricks = gpcBricks;
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
