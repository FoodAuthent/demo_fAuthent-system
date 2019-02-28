/*
 * TODO	
 */
package org.foodauthent.model.json.mixin;


import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;



import org.foodauthent.model.ProductIngredientStatement;
import org.foodauthent.model.ProductIngredientStatement.ProductIngredientStatementBuilder;

/**
 * MixIn class for entity implementations that adds jackson annotations for de-/serialization.
 *
 * @author Martin Horn, University of Konstanz
 */
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    property = "",
    visible = true,
    defaultImpl = ProductIngredientStatement.class)
@JsonSubTypes({
    @Type(value = ProductIngredientStatement.class, name="ProductIngredientStatement")
})
@JsonDeserialize(builder=ProductIngredientStatementBuilder.class)
@javax.annotation.Generated(value = "org.foodauthent.codegen.FoodAuthentCodegen")
public interface ProductIngredientStatementMixIn {

	@JsonIgnore
	public long getPersistenceId();
	
    @JsonIgnore
    public String getTypeID();
    
   	@JsonIgnore
  	public UUID getFaId();
    

    @JsonProperty("language")
    public String getLanguage();
    
    @JsonProperty("text")
    public String getText();
    

    /**
     * MixIn class for entity builder implementations that adds jackson annotations for the de-/serialization.
     *
     * @author Martin Horn, University of Konstanz
     */
    @JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "",
        defaultImpl = ProductIngredientStatementBuilder.class)
    @JsonSubTypes({
        @Type(value = ProductIngredientStatement.ProductIngredientStatementBuilder.class, name="ProductIngredientStatement")
    })
    // AUTO-GENERATED CODE; DO NOT MODIFY
    public static interface ProductIngredientStatementMixInBuilder {
    
        public ProductIngredientStatementMixIn build();
    
        @JsonProperty("language")
        public ProductIngredientStatementMixInBuilder setLanguage(final String language);
        
        @JsonProperty("text")
        public ProductIngredientStatementMixInBuilder setText(final String text);
        
    }


}

